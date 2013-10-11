Automatic reserves predicate sample story

Meta: 
@author dslaveckij
@theme Rule compliance

Narrative:
In order to show how rule meets requirements
As a development team
I want to show AutomaticReservesRulePredicate usage
					 
Scenario: Checking rule with code 2 with various context configurations
Given Rule conditions: Cause of Loss AUTOINCIDENT,VANDALISM , Coverage UMPD , Severity MINOR
When Reserves context: Cause of Loss <causeOfLoss> , Coverage <coverage> , Severity <severity>
Then Rule meets requirements: <result>
Examples:   
|causeOfLoss|coverage|severity|result|
|AUTOINCIDENT|UMPD|MINOR|true|
|VANDALISM|UMPD|MINOR|true|
|THEFT|UMPD|MINOR|false|
|AUTOINCIDENT|UMPD|MAJOR|false|

