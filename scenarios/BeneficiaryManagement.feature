Feature: BeneficiaryManagement 
Scenario: Verify that Beneficiaries tab total count is matching with grid total count
    Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"DP1", "username":"ENTERER"}
    When user clicks on Beneficiary Management link
    Then user verifies the beneficiary tab total count
   
Scenario: Verify that Disabled Beneficiaries tab total count is matching with grid total count
    Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"DP1", "username":"ENTERER"}
    When user clicks on Beneficiary Management link
    And user clicks on disabled beneficiary tab
    And user verifies the disabled beneficiary tab total count
    
Scenario: Verify that Pending Beneficiaries tab total count is matching with grid total count
    Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"DP2", "username":"ENTERER"}
    When user clicks on Beneficiary Management link
    And user clicks on pending beneficiary tab
    Then user verifies the pending beneficiary tab total count

Scenario: Verify disabled Beneficiaries in the All Beneficiaries are Enabled
	Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"DP1", "username":"ENTERER"}
	When user clicks on Beneficiary Management link 
	And user select disabled Beneficiaries in the Disabled Beneficiary tab and make Enable
	Then user verifies otp screen is visible
		
Scenario: Verify enabled Beneficiaries in the All Beneficiaries are Disabled
	Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"DP2", "username":"ENTERER"}
	When user clicks on Beneficiary Management link 
	And user select enabled Beneficiaries in the Total Beneficiary tab and make Disable 
	Then user verifies otp screen is visible		
Scenario: Select any Beneficairies in the Bene List and Delete it 
	Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"DP1", "username":"ENTERER"}
	When user clicks on Beneficiary Management link 
	And user select any Beneficairies from the Bene List Deletes it 
		|RulesApplicable|Approver1|
		|GENERAL        |CHECKER3 |																																																																																																																																			|
	Then user verifies alert message is visible			
Scenario: Select any Beneficairies in the Bene List and mark as Favourite 
	Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"DP2", "username":"ENTERER"}
	When user clicks on Beneficiary Management link 
	Then user select any Beneficairies from the Bene List and mark as Favourite 
Scenario: Select any Beneficairies in the Bene List and mark as UnFavourite 
	Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"DP2", "username":"ENTERER"}
	When user clicks on Beneficiary Management link 
	Then user select any Beneficairies from the Bene List and mark as UnFavourite 
	
Scenario: Select any Beneficairies in the Bene List and makePayment 
	Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"DP1", "username":"ENTERER"}
	When user clicks on Beneficiary Management link 
	And user select any Beneficairies from the Bene List and makePayment 
		|BeneficiaryName|
		|address|																																																																																																																																			|
	And enters below payment details 
	|Amount	|Paymentmode|FromAcctno      |ToAcctno |toAccountTab |LEI                 |Credit Narration|Remarks to Approver    |RulesApplicable|Approver1|
	|100    |NEFT       |RAINBOW TOUCH   |address  |All Payees   |1234001234567890H123|123456          | Make Payment          |1 EC + 1 BOD   |APPROVER2 |
	Then user verifies summary page and clicks make payment	
	
Scenario: Select any Beneficairies in the Bene List and Delete it 
	Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"DP1", "username":"ENTERER"}
	When user clicks on Beneficiary Management link 
	And user select any Beneficairies from the Bene List which makepayment is done and Deletes it 
		|BeneficiaryName    |RulesApplicable|Approver1|
		|address			|GENERAL        |APPROVER  |																																																																																																																																			|
	Then user verifies alert message is visible