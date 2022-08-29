Feature: Repay 
Background: Repay
	Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"GSTNDATA2A", "username":"MAKER3"}
	 
Scenario: 1. Repay the successful payments 
	When user selects payment name to Repay {"Scenario":"Successful"}
	And user get details of payment and click on repay 
	Then user verifies payment details {"RulesApplicable":"1 EC + 1 BOD", "Approver1":"CHECKER2"}
	And user verifies Bank Payment is successfully completed
	
Scenario: 2. Repay the Reject payments 
	When user selects payment name to Repay {"Scenario":"Rejected"}
	And user get details of payment and click on repay 
	Then user verifies payment details {"RulesApplicable":"1 EC + 1 BOD", "Approver1":"CHECKER2"}
	And user verifies Bank Payment is successfully completed	

Scenario: 3. Repay the Failed payments 
	When user selects payment name to Repay {"Scenario":"Failed"}
	And user get details of payment and click on repay 
	Then user verifies payment details {"RulesApplicable":"1 EC + 1 BOD", "Approver1":"CHECKER2"}
	And user verifies Bank Payment is successfully completed	
	