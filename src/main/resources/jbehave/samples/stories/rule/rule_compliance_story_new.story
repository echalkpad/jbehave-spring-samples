Scenario: Checking rule with code 1 meets requirements

Given Rule conditions are Cause of Loss AUTOINCIDENT,VANDALISM , Coverage UMPD , Total loss
When Reserves context are Total loss , Cause of Loss AUTOINCIDENT , Coverage UMPD
Then Rule meets reqs: true

Scenario: Checking rule with code 1 doesn't meet requirements

Given Rule conditions are Cause of Loss AUTOINCIDENT,VANDALISM , Coverage UMPD , Total loss
When Reserves context are Total loss , Cause of Loss AUTOINCIDENT , Coverage MPD
Then Rule meets reqs: false









					 
