@EPaymentMaker
Feature: EPaymentMaker
Background: EPayment Maker 
Given user is on Login page{"Environment":"UAT", "Path":"GST Payment", "corpid":"DP1", "username":"ENTERER"} 
 
Scenario: apply inputs in advanced search for the selected debit account
When user clicks on make payment, select debit account and rule checkbox
And provide required inputs in advanced search as "08AAACA9952G1ZJ"
And user clicks on apply
Then data will be filtered for the applied inputs

Scenario: clear inputs in advanced search for the selected debit account
When user clicks on make payment, select debit account and rule checkbox
And provide required inputs in advanced search as "08AAACA9952G1ZJ"
And user clicks on clear
Then all the data will be displayed

Scenario: Save an e payment as a draft
When user clicks on make payment, select debit account and rule checkbox
And user clicks on continue and save as draft
Then data will be saved in draft

Scenario: Make an e Payment
When user clicks on make payment, select debit account and rule checkbox
And User clicks on continue and confirm button
Then success message will be displayed and Back to over view will be enabled


