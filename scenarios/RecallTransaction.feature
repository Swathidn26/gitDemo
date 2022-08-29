@PaymentOverView
Feature: RecallTransaction 
Background: Recall Transaction
Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"DP1", "username":"ENTERER"} 
	
Scenario: Vendor recall transaction for pending with approver
  When user verifies pending count before recall transaction
  And user clicks on vendor tab 
  And user performs the recall transaction for pending with approver
  And user verifies recall transaction success message
  Then user verifies pending count after recall transaction

Scenario: Statutory recall transaction for pending with approver
  When user verifies pending count before recall transaction
  And user clicks on statutory tab  
  And user performs the recall transaction for pending with approver{"TransactionType":"GST NEFT/RTGS", "Status":"Pending with Approver"}
  And user verifies recall transaction success message
  Then user verifies pending count after recall transaction
 
Scenario: Check whether Beneificary has recall transaction option
  When user clicks on Beneficiary tab
  Then Recall transaction option should not be available for beneficiary pending with approval

Scenario: Check whether vendor status pending with bank has recall transaction option
   When user clicks on Vendor tab
   Then Recall transaction option should not be available for vendor pending with bank
 
Scenario: Check whether statutory status pending with bank has recall transaction option
   When user clicks on Statutory tab
   Then Recall transaction option should not be available for statutory pending with bank
