@UpdateIECode
Feature: UpdateIECode 
Background: Update IECode	
    Given user is on Login page{"Environment":"UAT", "Path":"Service Request", "corpid":"DP1", "username":"ENTERER"} 

Scenario: Update Import Export IeCode 
	When user clicks on new request and ie code update 
	And user select the customer id as "873528609" and user clicks ie code radio button 
	And user enters the ie code as "0817500863" then validate button will be enabled 
	And user click on validate button and proceed button 
	And user selects the rule,terms and conditions and user clicks submit button 
	Then Success message will be displayed and Back to overview button will be enabled 
