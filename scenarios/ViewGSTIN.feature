@ViewGSTIN 
Feature: view GSTIN
Background: View GSTIN
Given user is on Login page{"Environment":"UAT", "Path":"GST Payment", "corpid":"DP2", "username":"ENTERER"} 

Scenario: Delink the Approved GSTIN 
    Given user clicks on payments and click new payments and GST ePayments 
    And user clicks on View GSTIN,approved tab select gstin and click delink button
    And user clicks on view rule, select rules, approver and enter Remarks 
        |rules|approver|Remarks|
        |2 GEN|APPROVER2|Approve request|
    When user click on Delink button 
    Then Delink toastmessage is displayed 
    
Scenario: Remind Pending GSTIN 
    Given user clicks on payments and click new payments and GST ePayments 
    When user clicks on View GSTIN,pending tab select gstin and click remind 
    Then remind toastmessage is displayed 
    
Scenario: Delete Pending GSTIN
    Given user clicks on payments and click new payments and GST ePayments 
    When user clicks on View GSTIN, penidng tab select gstins and click delete
    Then delete toastmessage is displayed
    
Scenario: Remove gstin from rejected tab
    Given user clicks on payments and click new payments and GST ePayments 
    When user clicks on View GSTIN,Rejected tab and select gstindetail  and click remove from list
    Then reject toastmessage is displayed 
    
Scenario: Relink gstin from Delinked tab 
    Given user clicks on payments and click new payments and GST ePayments 
    And user clicks on View GSTIN,Delinked tab and select gstin and click relink
    And user selects rules and approver enter Remarks 
        |rules|approver|
        |2 GEN|APPROVER2|
    When user click on Relink button 
    Then relink toast message is displayed 