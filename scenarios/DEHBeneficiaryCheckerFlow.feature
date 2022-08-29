@DehBeneficiaryChecker
Feature: DEH Beneficiary Checker flow scripts
Background: Beneficiary checker flows
Given user is on Login page{"Environment":"DEHDEV", "Path":"Payments", "corpid":"SITCORP14", "username":"CHECKER1"}

Scenario: 1 Approve the  beneficiary request 
When user lands on Payments page and navigates to Beneficiary to approve
And user clicks on proceed button followed by submit button
And user enters otp and clicks on submit button{"corpid":"SITCORP14", "username":"CHECKER1"}
Then request submitted successfully message is displayed 

Scenario: 2 Reject the request 
When user lands on Payments page and navigates to Beneficiary to  reject
And user clicks on proceed button followed by submit button 
And user enters otp and clicks on submit button{"corpid":"SITCORP14", "username":"CHECKER1"}
Then request submitted successfully message is displayed  

Scenario: 3 customize columns and approve the request 
When user lands on Payments page and navigates to Beneficiary and customizes by selecting columns options
|options|
|Bank|
|Requested By|
|Account Type|
And user selects Beneficiary to approve and clicks on proceed button followed by submit 
And user enters otp and clicks on submit button{"corpid":"SITCORP14", "username":"CHECKER1"}
Then request submitted successfully message is displayed  

Scenario: 4 working of search bar
When user lands on Payments page and navigates to Beneficiary and enters details in search bar and gets the data 
And user selects Beneficiary to approve and clicks on proceed button followed by submit 
And user enters otp and clicks on submit button{"corpid":"SITCORP14", "username":"CHECKER1"}
Then request submitted successfully message is displayed 

Scenario: 5 approve multiple Request
When user lands on Payments page and navigates to Beneficiary and selects mutliple request to approve
And user clicks on proceed button followed by submit button
And user enters otp and clicks on submit button{"corpid":"SITCORP14", "username":"CHECKER1"}
Then request submitted successfully message is displayed 

Scenario: 6 Reject multiple Request
When user lands on Payments page and navigates to Beneficiary and selects mutliple request to reject
And user clicks on proceed button followed by submit button
And user enters otp and clicks on submit button{"corpid":"SITCORP14", "username":"CHECKER1"}
Then request submitted successfully message is displayed 


