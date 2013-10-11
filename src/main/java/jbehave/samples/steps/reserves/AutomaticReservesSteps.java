package jbehave.samples.steps.reserves;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

import java.math.BigDecimal;

import jbehave.samples.autoreserves.AutomaticReservesContext;
import jbehave.samples.autoreserves.AutomaticReservesRuleResult;
import jbehave.samples.autoreserves.services.AutomaticReservesRuleFacade;
import jbehave.samples.domain.Severity;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.Alias;
import org.springframework.beans.factory.annotation.Autowired;


public class AutomaticReservesSteps {
    
	private AutomaticReservesContext context;
	
	private AutomaticReservesRuleResult result;
	
	@Autowired
	private AutomaticReservesRuleFacade automaticReservesRuleFacade;
	
	/**
	 * Setting {@link AutomaticReservesContext} with total loss and other values for reserves calculation
	 * @param causeOfLoss Cause of loss code
	 * @param coverage Coverage code	
	 */
	@Given("Reserves context: Cause of Loss $causeOfLoss , Coverage $coverage , Total loss")
	public void givenReservesContextCauseOfLossCoverageTotalLoss(@Named("causeOfLoss")String causeOfLoss, 
			@Named("coverage")String coverage) {
		context = new AutomaticReservesContext(true, causeOfLoss, coverage);
	}
	
	/**
	 * Setting {@link AutomaticReservesContext} with values for reserves calculation
	 * @param causeOfLoss Cause of loss code
	 * @param coverage Coverage code
	 * @param severity Severity
	 */
	@Given("Reserves context: Cause of Loss $causeOfLoss , Coverage $coverage , Severity $severity")
	public void givenReservesContextCauseOfLossCoverageSeverity(@Named("causeOfLoss")String causeOfLoss, 
			@Named("coverage")String coverage, 	@Named("severity")Severity severity) {
		context = new AutomaticReservesContext(severity, causeOfLoss, coverage);
	}
	
	/**
	 * Setting {@link AutomaticReservesContext} with values for reserves calculation
	 * @param causeOfLoss Cause of loss code
	 * @param coverage Coverage code
	 * @param severity Severity
	 */
	@Given("Reserves context: Total loss $totalLoss Cause of Loss $causeOfLoss , Coverage $coverage , Severity $severity")
	@Alias("Reserves context: Total loss <totalLoss> Cause of Loss <causeOfLoss> , Coverage <coverage> , Severity <severity>")
	public void givenReservesContextCauseOfLossCoverageSeverityTotalLoss(
			@Named("totalLoss")Boolean totalLoss,
			@Named("causeOfLoss")String causeOfLoss, 
			@Named("coverage")String coverage, 	@Named("severity")Severity severity) {
		context = new AutomaticReservesContext(severity, causeOfLoss, coverage);
		context.setTotalLossInd(totalLoss);
	}
	
	/**
	 * Calculating automatically reserves
	 */
	@When("Calculate automatic reserves")
	public void whenCalculateAutomaticReserves() {
		result = automaticReservesRuleFacade.calculateReserves(context);
	}
	
	@Then("Result code $code Indemnity reserve $indemnity Expense reserve $expense")
	@Alias("Result code <code> Indemnity reserve <indemnity> Expense reserve <expense>")
	public void thenResultCode(
			@Named("code")String code, 
			@Named("indemnity")BigDecimal indemnity,
			@Named("expense")BigDecimal expense) {
		if (code.equals("-")) {
			assertThat(result.getCode(), nullValue());
			return;
		}
		
	  	assertThat(result.getCode(), equalTo(code));
	  	assertThat(result.getIndemnityReserve(), equalTo(indemnity));
	  	assertThat(result.getExpenseReserve(), equalTo(expense));
	}
	
	@Then("No result found")
	public void thenNoResultFound() {
		assertThat(result, nullValue());
	}

	

}
