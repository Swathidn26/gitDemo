@NeftRetgs 
Feature: NeftRtgs 
Background: NEFT Payment 
	Given user is on Login page{"Environment":"UAT", "Path":"GST Payment", "corpid":"DP2", "username":"ENTERER"} 
	
Scenario: 1. Submitting NEFT Payment Request 
	Given user clicks on payments and click new payments and gst Payment via NEFT RTGS 
	And user enters CPIN Amount and select Debit Account enter Remarks 
		|Amount|Remarks|
		|10|approve request|
	And user selects rule and Approver and enters Remark 
		|rule|Approver|Remark|
		|1 EC + 1 BOD|APPROVER|approval for payment|
	When user clicks on continue button 
	And user clicks on makepayment button 
	Then submit message is displayed 
	
Scenario: 2. customizing the columns 
	Given user clicks on payments and click new payments and gst Payment via NEFT RTGS 
	And user clicks on customize and selects options 
		|options       |
		|Execution Date|
		|CRN           |
	And user enters CPIN Amount and select Debit Account enter Remarks 
		|Amount|Remarks|
		|10|approve request|
	And user selects rule and Approver and enters Remark 
		|rule|Approver|Remark|
		|1 EC + 1 BOD|APPROVER|approval for payment|
	When user clicks on continue button 
	And user clicks on makepayment button 
	Then submit message is displayed 
	
Scenario: 3. deleting a record from a row 
	Given user clicks on payments and click new payments and gst Payment via NEFT RTGS 
	When user click on delete record icon and click yes button to confirm delete
	Then record deleted success toast message is displayed 
	
Scenario: 4. saving record as draft 
	Given user clicks on payments and click new payments and gst Payment via NEFT RTGS 
	And user enters CPIN Amount and select Debit Account enter Remarks 
		|Amount|Remarks|
		|10|approve request|
	And user selects rule and Approver and enters Remark 
		|rule|Approver|Remark|
		|1 EC + 1 BOD|APPROVER|approval for payment|
	When user click on save as draft 	
	Then toast message for saving as draft is displayed
	
Scenario: 5. Add new row for NEFT payment 
	Given user clicks on payments and click new payments and gst Payment via NEFT RTGS 
	And user enters CPIN Amount and select Debit Account enter Remarks 
		|Amount|Remarks|
		|10|approve request|
		|10|approve request|
	And user selects rule and Approver and enters Remark 
		|rule|Approver|Remark|
		|1 EC + 1 BOD|APPROVER|approval for payment|
    And user clicks on add a row 
    And user enters details CPIN Amount and select Debit Account enter Remarks 
		|Amount|Remarks|
		|5|approve request|
	And user selects new rule and Approver and enters Remark 
		|rule|Approver|Remark|
		|1 EC + 1 BOD|APPROVER2|approval for payment|
	When user clicks on continue button 
	And user clicks on makepayment button 
	Then submission message is displayed 
	