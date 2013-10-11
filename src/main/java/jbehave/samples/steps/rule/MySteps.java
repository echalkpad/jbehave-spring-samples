package jbehave.samples.steps.rule;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class MySteps {
    
	int h = 1;
	
	int i = 1;
	
	int j = 1;
	
	@BeforeStories()
	public void beforeStories() {
		
		System.err.println("Before stories: " + h++);
	}
	
	@BeforeStory
    public void beforeStory(@Named("author") String author) {
        if (author.length() > 0) {
            System.err.println("This story is authored by " + author);
        } else {
            System.err.println("Before Story ...");
        }
    } 	
	
	@BeforeScenario()
	public void beforeScenario() {
		System.err.println("Before scenario: " + j++);
	}
	
	
	@Given("Claim $number created")
	public void givenClaimCreated(
			@Named("number")String number) {
	  // PENDING
	}
	
	@Given("Claims feature created")	
	public void givenClaimsFeatureCreated() {
	  // PENDING
	}
	
	@Given("Indemnity reserve set 200")
	
	public void givenIndemnityReserveSet200() {
	  // PENDING
	}
	
	/**
	 * Setting indemnity reserve to {@link ClaimsFeature}
	 * @param indemnity Indemnity amount to set
	 */
	@Given("Indemnity reserve set $indemnity")
	public void givenIndemnityReserveSet(
			@Named("indemnity")String indemnity) {
	  
	}

	@Given("Expense reserve set $expense")	
	public void givenExpenseReserveSet(
			@Named("expense")String expense) {
	  // PENDING
	}
	
	 
	@Given("Recovery reserve set $recovery")
	public void givenRecoveryReserveSet(
			@Named("recovery")String recovery) {
//	   assertThat(1, equalTo(2));
	}
	
	
	@When("Claims feature stored")	
	public void whenClaimsFeatureStored() {
	  // PENDING
	}

	/**
	 * Checking if history table meets provided {@link ExamplesTable}
	 * 
	 * @param table Table with Format
	 * |{@link {ClaimsFeature#afsadf}}|||
	 */
	@Then("Reserve history: $table")
	public void thenReserveHistory(ExamplesTable table) {
	  // PENDING
	}
}
