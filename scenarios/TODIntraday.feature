@TodIntraday 
Feature: TodIntraday

Background: TOD Intraday 
Given user is on Login page{"Environment":"UAT", "Path":"TOD", "corpid":"TODCORP1", "username":"MAKER2"}

Scenario: 1. Verify default selections - Intraday
When user clicks on initiate new request and click Intraday/TOD request
And select customerID eligible for intraday or TOD
|CustomerID|EntityName|
|004022408|RHAIN|
Then SR type should be Intraday by default

Scenario: 2. Verify prefilled data, disabled regularization date & successful submission - Intraday
When user clicks on initiate new request and click Intraday/TOD request
And select customerID and fill the form to proceed
|CustomerID|EntityName|purpose|mode|RequestedAmount|
|004022408|RHAIN|Exchange Obligation|Fund Transfer|10000|
And entity name, ID or TOD account number, charges account number is prefilled
And regularization date is not editable
And user enters RM email IDs
|emailId|
|nitish.sarvam|
|sarvesh.kapil|
Then review page should be available with rule and T&C
And request should be submitted successfully

Scenario: 3. Verify maximum allowed required date & successful submission - Intraday
When user clicks on initiate new request and click Intraday/TOD request
And select customerID eligible for intraday or TOD
|CustomerID|EntityName|
|004022408|RHAIN|
Then verify required date cannot be more than 7 days from current date
And fill request for 7 day ahead from today's date
|CustomerID|EntityName|purpose|mode|RequestedAmount|
|004022408|RHAIN|Exchange Obligation|Fund Transfer|10000|
And user enters RM email IDs
|emailId||
|nitish.sarvam||
And review page should be available with rule and T&C
And request should be submitted successfully

Scenario: 4. Verify maximum RM mail IDs that can be added - Intraday
When user clicks on initiate new request and click Intraday/TOD request
And select customerID and fill the form to proceed
|CustomerID|EntityName|purpose|mode|RequestedAmount|
|004022408|RHAIN|Exchange Obligation|Fund Transfer|10000|
Then verify proceed button is disabled without adding RM mail ID 
And verify message after adding maximum RM mail IDs
|emailId|
|glen.maxwell|
|dinesh.karthik|
|virat.kohli|
|rashid.khan|
|avesh.khan|

Scenario: 5. Verify dormant account error message
When user clicks on initiate new request and click Intraday/TOD request
And select customerID having dormant or frozen account
|CustomerID|EntityName|
|004018862|SHILPA|
Then verify frozen or dormant message is displayed

Scenario: 6. Verify mode of regularization is selected and disabled by default & successful submission - TOD
When user clicks on initiate new request and click Intraday/TOD request
And select customerID eligible for intraday or TOD
|CustomerID|EntityName|
|004022408|RHAIN|
And select TOD and fill the form to proceed
|CustomerID|EntityName|purpose|mode|RequestedAmount|
|004022408|RHAIN|Exchange Obligation|Fund Transfer|10000|
And mode of regularization is disabled and selected by default
And user enters RM email IDs
|emailId|
|nitish.sarvam|
|sarvesh.kapil|
Then review page should be available with rule and T&C
And request should be submitted successfully

Scenario: 7. Verify maximum allowed required and regularization date - TOD
When user clicks on initiate new request and click Intraday/TOD request
And select customerID eligible for intraday or TOD
|CustomerID|EntityName|
|004022408|RHAIN|
And select TOD request
Then verify required date cannot be more than 7 days from current date
And fill TOD request for 7 day ahead from today's date and regularization cannot be same as required date
|CustomerID|EntityName|purpose|mode|RequestedAmount|
|004022408|RHAIN|Exchange Obligation|Fund Transfer|10000|
And verify regularization date can be 15 days from required date

Scenario: 8. verify back to overview menu and submitted form available in overview table
When user clicks on initiate new request and click Intraday/TOD request
And select customerID and fill the form to proceed
|CustomerID|EntityName|purpose|mode|RequestedAmount|
|004022408|RHAIN|Exchange Obligation|Fund Transfer|10000|
And user enters RM email IDs
|emailId||
|nitish.sarvam||
And review page should be available with rule and T&C
And request should be submitted successfully
And click on back to overview button
Then user should be taken to overview page with submitted form ID in overview table