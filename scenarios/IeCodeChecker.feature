@ApproveIECode
Feature: ApproveIECode
Background: Approve the IECode
Given user is on Login page{"Environment":"UAT", "Path":"Service Request", "corpid":"GSTNDATA2A", "username":"Checker3"} 
   
Scenario: Update Import Export IeCode
    When user click service tab and click pending request
    And user enable the check box and accept terms and conditions
    And user approve the ie code and user enters the otp as "123456"
    Then ie code will be approved and success message will be displayed