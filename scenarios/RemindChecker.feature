@PaymentOverView
Feature: Remind Checker 
Background: Remind Checker
Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"DP1", "username":"ENTERER"} 

Scenario: Vendor remind checker for pending with approver
  When user clicks on Vendor tab
  And  user clicks on pending with approver record and performs remind checker for vendor 
  Then system should display the remind checker success message
  
Scenario: Statutory remind checker for pending with approver
  When user clicks on Statutory tab
  And user clicks on pending with approver record and performs remind checker for statutory
  Then system should display the remind checker success message
  
Scenario: Beneficiary remind checker for pending with approver
  When user clicks on Beneficiary tab
  And user clicks on pending with approver record and performs remind checker for beneficiary 
  Then system should display the remind checker success message

#Negative flow

Scenario: Check whether vendor status pending with bank has remind checker option
   When user clicks on Vendor tab
   Then Remind checker option should not be available for vendor pending with bank
 
Scenario: Check whether statutory status pending with bank has remind checker option
   When user clicks on Statutory tab
   Then Remind checker option should not be available for statutory pending with bank

  	