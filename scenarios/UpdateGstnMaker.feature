@UpateGstnMaker
Feature: UpdateGstnMaker
Background: Update Gstn Maker 
Given user is on Login page{"Environment":"UAT", "Path":"Service Request", "corpid":"GSTNDATA2A", "username":"MAKER3"}

Scenario: cancel update gstn
When user click on new request and gstn update
And user select the customer id as "003093133" and select one gstn
And user click on proceed,selects the rule,terms and conditions and user clicks cancel button
Then pop up should be displayed whether to quit and and redirected to overview page.

Scenario: validate submit button without clicking on terms and condition
When user click on new request and gstn update
And user select the customer id as "003093133" and select one gstn
And user click on proceed,selects the rule and does not click terms and conditions
Then submit button will not be enabled

Scenario: submit gstn with new gstn as default
When user click on new request and gstn update
And user select the customer id as "003093133" and select one gstn as deafult
And user click on proceed,selects the rule,terms and conditions and user clicks submit button
Then Success message will be displayed and Back to overview will be enabled

Scenario: sumbit gstn with already existing deafult gstn
When user click on new request and gstn update
And user select the customer id as "003093133" and selects two gstns with no gstn as deafult
And user click on proceed,selects the rule,terms and conditions and user clicks submit button
Then Success message will be displayed and Back to overview will be enabled