Feature: CheckerFlow
Background:
	Given  user is on Login page{"Environment":"UAT","Path":"Single Payment","corpid":"GSTNDATA2A", "username":"checker2"}
   
Scenario: ApproveVendor
	When select any BeneficiaryName in the Vendorlist for the approval
	And click on proceed and submit button
    Then user should able to see Otp Screen
    
Scenario: RejectVendor
	When select any BeneficiaryName in the Vendorlist for the reject
	And click on Proceed
    And click on Submit	
    Then user should able to see Otp Screen
     
Scenario: ApproveBeneficiary
    Given user click on Beneficiary
	When select any BeneficiaryName in the Beneficiarylist for the approval
	And click on Proceed
	And click on Submit	
    Then user should able to see Otp Screen
    
Scenario: RejectBeneficiary
    Given user click on Beneficiary
	When select any BeneficiaryName in the Beneficiarylist for the reject
	And click on Proceed
	And click on Submit
	Then user should able to see Otp Screen
    
