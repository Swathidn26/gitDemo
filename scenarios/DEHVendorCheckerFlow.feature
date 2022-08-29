@DehVendorChecker
Feature: DEH Vendor Checker flow scripts
Background: Vendor checker flows
Given user is on Login page{"Environment":"DEHDEV", "Path":"Payments", "corpid":"SITCORP14", "username":"CHECKER1"} 


Scenario: 1 Approve the request 
When user lands on Vendor tab and selects Beneficiary to approve
And user clicks on proceed button followed by submit button
And user enters otp and clicks on submit button{"corpid":"SITCORP14", "username":"CHECKER1"}
Then request submitted successfully message is displayed 

Scenario: 2 Reject the request 
When user lands on Vendor tab and selects Beneficiary to reject
And user clicks on proceed button followed by submit button 
And user enters otp and clicks on submit button{"corpid":"SITCORP14", "username":"CHECKER1"}
Then request submitted successfully message is displayed  

Scenario: 3 customize columns and approve the request 
When user lands on Vendor tab and customizes by selecting columns options
|options|
|Transaction Type|
|Requested By|
|Beneficiary Bank|
And user selects Beneficiary to approve and clicks on proceed button followed by submit 
And user enters otp and clicks on submit button{"corpid":"SITCORP14", "username":"CHECKER1"}
Then request submitted successfully message is displayed  

Scenario: 4 working of search bar
When user lands on Vendor tab and enters details in search bar and gets the data 
And user selects Beneficiary to approve and clicks on proceed button followed by submit 
And user enters otp and clicks on submit button{"corpid":"SITCORP14", "username":"CHECKER1"}
Then request submitted successfully message is displayed 

Scenario: 5 working of refresh button
When user lands on Vendor tab and clicks on refresh button thrice
Then toast Message is displayed 

Scenario: 6 approve multiple Request
When user lands on Vendor tab and selects mutliple request to approve
And user clicks on proceed button followed by submit button
And user enters otp and clicks on submit button{"corpid":"SITCORP14", "username":"CHECKER1"}
Then request submitted successfully message is displayed 

Scenario: 7 Reject multiple Request
When user lands on Vendor tab and selects mutliple request to reject
And user clicks on proceed button followed by submit button
And user enters otp and clicks on submit button{"corpid":"SITCORP14", "username":"CHECKER1"}
Then request submitted successfully message is displayed 


