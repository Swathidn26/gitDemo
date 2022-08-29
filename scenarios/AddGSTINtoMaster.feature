@AddtoMaster 
Feature: AddtoMaster 
Background: Add to Master
Given user is on Login page{"Environment":"UAT", "Path":"GST Payment", "corpid":"DP2", "username":"ENTERER"} 

Scenario: Add GSTIN to Master
	Given user clicks on payments and click new payments and GST ePayments 
	And user clicks on register gstin
	And user clicks on Discover GSTIN
	And user clicks on view modify selects rule and approver and add remarks and click save 
		|rule|approver|remarks|            
		|2 GEN|APPROVER2|Approve Request|
	When User selects gstin and clicks add to master button
	Then success toast message is displayed
	