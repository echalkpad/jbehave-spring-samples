package jbehave.samples.steps.rule;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import jbehave.samples.autoreserves.AutomaticReservesContext;
import jbehave.samples.autoreserves.AutomaticReservesRule;
import jbehave.samples.autoreserves.services.AutomaticReservesRulePredicate;
import jbehave.samples.domain.Severity;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.Alias;

/**
 * Steps for "rule_compliance_story_simple.story", "rule_compliance_story.story".
 */
public class RuleComplianceSteps {
    
	private AutomaticReservesRule rule;
	
	private AutomaticReservesContext context;
	
	/**
	 * Rule condition creation
	 * 
	 * @param causeOfLoss List of cause of losses
	 * @param coverage
	 */
	@Given("Rule conditions: Cause of Loss $causeOfLoss , Coverage $coverage , Total loss")
	public void givenRuleConditionsCauseOfLossCoverageTotalLoss(List<String> causeOfLoss, String coverage) {
		rule = new AutomaticReservesRule()
			.withCausesOfLosses(causeOfLoss)
			.withCoverages(coverage).withTotalLoss(true);
	}
	
	/**
	 * {@link AutomaticReservesRule} created with cause of loss, and coverage set.
	 * 
	 * @param causeOfLoss Cause of loss code
	 * @param coverage Coverage code
	 */
	@Given("Rule conditions: Cause of Loss $causeOfLoss , Coverage $coverage , Severity $severity")
	public void givenRuleConditionsCauseOfLossCoverage(List<String> causeOfLoss, List<String> coverage, Severity severity) {
		rule = new AutomaticReservesRule()
					.withCoverages(coverage).withCausesOfLosses(causeOfLoss).withSeverities(severity);
	}	
	
	@When("Reserves context: Cause of Loss $causeOfLoss , Coverage $coverage , Severity $severity")
	@Alias("Reserves context: Cause of Loss <causeOfLoss> , Coverage <coverage> , Severity <severity>")	
	public void givenReservesContextCauseOfLossCoverage(
			@Named("causeOfLoss")String causeOfLoss, 
			@Named("coverage")String coverage, 
			@Named("severity")Severity severity) {
		context = new AutomaticReservesContext(severity, causeOfLoss, coverage);
	}
	
	@Then("Rule meets requirements: <result>")
	@Alias("Rule meets requirements: $result")	
	public void thenRuleMeetsRequirements(
			@Named("result")Boolean exptected) {
		Boolean result = new AutomaticReservesRulePredicate(context).apply(rule);
		assertThat(result, equalTo(exptected));
	}
}
