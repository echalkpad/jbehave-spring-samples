Automatic reserves predicate usage sample story

Meta: 
@author dslaveckij
@theme Rule compliance

Narrative:
In order to show how rule meets requirements
As a development team
I want to show AutomaticReservesRulePredicate usage
					 
Scenario: Checking rule with code 2 meets conditions
Given Rule conditions: Cause of Loss AUTOINCIDENT,VANDALISM , Coverage UMPD , Severity MAJOR
When Reserves context: Cause of Loss AUTOINCIDENT , Coverage UMPD , Severity MAJOR
Then Rule meets requirements: true

Scenario: Checking rule with code 2 doesn' meet conditions
Given Rule conditions: Cause of Loss AUTOINCIDENT,VANDALISM , Coverage UMPD , Severity MAJOR
When Reserves context: Cause of Loss AUTOINCIDENT , Coverage UMPD , Severity MINOR
Then Rule meets requirements: false