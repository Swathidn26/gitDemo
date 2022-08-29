@BeneAddition 
Feature: BeneficiaryAddition 
Background: LoginToCDP 
	Given  user is on Login page{"Environment":"UAT","Path":"Single Payment","corpid":"DP1", "username":"ENTERER"} 
	And  user clicks on Beneficiary Management tab and clicks on Add New Beneficiary link 
	
Scenario: Create new Beneficiary for OtherBank 
	When user enter otherbank  details 
		|IFSCCode           |BeneAcctname             |BeneType                 |LEI       |AccountCategory| Mobileno  |Email                   |AddressLine1|AddressLine2|Pincode|Remarks                        |Approver|
		|YESB0000599        |OtherBankBene            |Individual / Govt. Entity|00123456  |Salary         |9023445689 |OtherBank@mail.com      |Hyderabad  |HitechCity   |500090 | otherBank Bene Added          |APPROVER3|
	And user clicks on Proceed and Submit Button 
	Then user Should able to see Beneficiary Managament Button 
	
Scenario: Create new Beneficiary for AxisBank 
	Given user selects on AxisBank Account 
	When user enter following details 
		|BeneAccno      |confirmBeneAccno     |BeneType      |AccountCategory     |Mobileno        |Email                             |AddressLine1|AddressLine2|Pincode|Remarks               |Approver|
		|909020031901569|909020031901569      |Non-Individual|Salary              |9000123639      |Testaxisbank@mail.com             |Hyderabad   |Madhapur    |500091 | AxisBank Bene Added  |APPROVER3|
	And user clicks on Proceed and Submit Button 
	Then user Should able to see Beneficiary Managament Button 
	