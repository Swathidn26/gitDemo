@UpcomingTransaction 
Feature: GSTIN MasterReports 
Background: GSTIN Reports 
	Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"DP1", "username":"ENTERER"} 

	
Scenario: Deleting upcoming transaction for recurring payment 
	When user selects an option to cancel transaction 
	And user selects particular transactions to be cancelled 
	And user selects rule and Approver and enter Remark 
		|rule|Approver|Remark|
		|1 EC + 1 BOD|APPROVER|cancel upcoming transaction|
	And user clicks on proceed button and confirms the cancellation 
	Then cancellation success message will be displayed 
	
	
Scenario: Deleting upcoming transaction for Schedule payment 
	When user selects an option to cancel schedule transaction 
	And user selects particular schedule transactions to be cancelled 
	And user selects rule and Approver and enter Remark 
		|rule|Approver|Remark|
		|1 EC + 1 BOD|APPROVER|cancel upcoming transaction|
	And user clicks on proceed button and confirms the cancellation  
	Then cancellation success message will be displayed 