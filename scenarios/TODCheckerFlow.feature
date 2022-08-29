@TODChecker
Feature: TODChecker

Background: Single Payment
Given user is on Login page{"Environment":"UAT", "Path":"TOD", "corpid":"TODCORP1", "username":"CHECKER1"} 

Scenario: 1. Validating buttons for checker
When checker clicks on first pending request
Then T&C check box, reject button should be visible
And approve button should be disabled

Scenario: 2. Approving a request
When checker clicks on first pending request
And clicks on T&C, approve
Then OTP screen should be displayed

Scenario: 3. Rejecting a request
When checker clicks on first pending request
And clicks on Reject
And add remarks and click submit
Then verify toast message for rejection

Scenario: 4. Verifying service overview screen
When checker clicks on first request
Then service overview screen should open with all details

Scenario: 5. Verifying multiple selections
When clicking on Request number header check box for multiple selection
And clicks on T&C, approve
Then OTP screen should be displayed
