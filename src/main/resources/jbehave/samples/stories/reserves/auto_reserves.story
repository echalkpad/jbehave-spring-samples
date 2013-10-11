Scenario: Rule with code 1 conditions

Given Reserves context: Cause of Loss VANDALISM , Coverage UMPD , Total loss
When Calculate automatic reserves
Then Result code 1 Indemnity reserve 12000.0 Expense reserve 1000.0

Scenario: Rule with code 1 conditions

Given Reserves context: Cause of Loss AUTOINCIDENT , Coverage UMPD , Total loss
When Calculate automatic reserves
Then Result code 1 Indemnity reserve 12000.0 Expense reserve 1000.0

Scenario: Rule with code 1 conditions

Given Reserves context: Total loss true Cause of Loss AUTOINCIDENT , Coverage UMPD , Severity MAJOR
When Calculate automatic reserves
Then Result code 1 Indemnity reserve 12000.0 Expense reserve 1000.0

Scenario: Rule with code 2 conditions

Given Reserves context: Total loss false Cause of Loss AUTOINCIDENT , Coverage UMPD , Severity MAJOR
When Calculate automatic reserves
Then Result code 2 Indemnity reserve 12000.0 Expense reserve 1000.0

Scenario: Rule with code 3 conditions

Given Reserves context: Total loss false Cause of Loss AUTOINCIDENT , Coverage UMPD , Severity MODERATE
When Calculate automatic reserves
Then Result code 3 Indemnity reserve 4000.0 Expense reserve 500.0