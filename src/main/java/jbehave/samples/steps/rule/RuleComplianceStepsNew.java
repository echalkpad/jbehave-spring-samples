package jbehave.samples.steps.rule;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import jbehave.samples.autoreserves.AutomaticReservesContext;
import jbehave.samples.autoreserves.AutomaticReservesRule;
import jbehave.samples.autoreserves.services.AutomaticReservesRulePredicate;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Steps for "rule_compliance_story_new.story".
 */
public class RuleComplianceStepsNew {
    
	private AutomaticReservesRule rule;
	
	private AutomaticReservesContext context;
		
	@Given("Rule conditions are Cause of Loss $causeOfLoss , Coverage $coverage , Total loss")
	public void givenRuleConditionsCauseOfLossCoverageTotalLoss(List<String> causeOfLoss, String coverage) {
		rule = new AutomaticReservesRule()
			.withCausesOfLosses(causeOfLoss)
			.withCoverages(coverage).withTotalLoss(true);
	}
		
	
	@When("Reserves context are Total loss , Cause of Loss $causeOfLoss , Coverage $coverageCd")
	public void whenReservesContext(String causeOfLoss, String coverageCd) {
		context = new AutomaticReservesContext(true, causeOfLoss, coverageCd);
	}
	
	@Then("Rule meets reqs: $result")	
	public void thenRuleMeetsRequirements(Boolean expected) {
		Boolean result = new AutomaticReservesRulePredicate(context).apply(rule);
		assertThat(result, equalTo(expected));
	}
}
