Feature: Master checker 
Background: Master checker
Given user is on Login page{"Environment":"UAT", "Path":"GST Payment", "corpid":"DP2", "username":"APPROVER2"} 

Scenario: Approve add to master request 
    Given user clickes on payments and click on GST payments and select statutory
	And user selects gstin and selects action as approve and enter remarks, clicks proceed and submit
#	Then user enters OTP "123456" and click submit and get confirmation message 
	
Scenario: Reject add to master request 

Given user clickes on payments and click on GST payments and select statutory
And user selects gstin and selects action as reject and enter remarks, clicks proceed and submit
#	Then user clicks submit and enter OTP "123456" and click submit and get confirmation message 
