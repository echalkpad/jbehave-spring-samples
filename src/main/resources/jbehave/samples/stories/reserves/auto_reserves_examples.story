Automatic reserves calculation

Meta: 
@author dslaveckij
@theme AutoReserves

Narrative:
In order to show automatic reserve calculation
As a development team
I want to show cases how reserves are calculated depending on reserves context.

Scenario: Rule checking with examples
Given Reserves context: Total loss <totalLoss> Cause of Loss <causeOfLoss> , Coverage <coverage> , Severity <severity>
When Calculate automatic reserves
Then Result code <code> Indemnity reserve <indemnity> Expense reserve <expense>

Examples:   
|totalLoss|causeOfLoss|coverage|severity|code|indemnity|expense|
|true|AUTOINCIDENT|UMPD|null|1|12000.0|1000.0|
|true|VANDALISM|UMPD|null|1|12000.0|1000.0|
|false|AUTOINCIDENT|UMPD|MAJOR|2|12000.0|1000.0|
|false|VANDALISM|UMPD|MAJOR|2|12000.0|1000.0|
|false|AUTOINCIDENT|UMPD|MODERATE|3|4000.0|500.0|
|false|VANDALISM|UMPD|MODERATE|3|4000.0|500.0|
|false|AUTOINCIDENT|UMPD|MINOR|4|1000.0|200.0|
|false|VANDALISM|UMPD|MINOR|4|1000.0|200.0|
|false|THEFT|UMPD|null|5|12000.0|1500.0|
|false|AUTOINCIDENT|MPD|MAJOR|6|100000.0|5000.0|
|false|AUTOINCIDENT|MPD|MODERATE|7|30000.0|2000.0|
|false|AUTOINCIDENT|MPD|MINOR|8|10000.0|500.0|