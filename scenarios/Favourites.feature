Feature: Favourites 
	
Scenario: 1. Delete a favourite beneficiary from the favourites
	Given  user is on Login page{"Environment":"UAT","Path":"Single Payment","corpid":"GSTNDATA2A", "username":"MAKER3"} 
	And user navigates to favourite section and clicks on ViewAll 
	And user is able to view the list of Favourites 
	When user select any favourites from the list and clicks on Delete 
	And user confirm to click on Delete 
	Then user verify delete toast message displayed in the page 
	
Scenario: 2. Mark as favourite Vendor from the Successful Tab 
	Given  user is on Login page{"Environment":"UAT","Path":"Single Payment","corpid":"GSTNDATA2A", "username":"MAKER3"}
	When user goes to Recent activity section and clicks on Successful link 
	And user select any Vendor and clicks on Star mark 
	Then user Should able mark as favourite and also verify toast message displayed in the page 
	
Scenario: 3. Remove favourite Vendor from the Successful Tab 
	Given  user is on Login page{"Environment":"UAT","Path":"Single Payment","corpid":"GSTNDATA2A", "username":"MAKER3"}
	When user goes to Recent activity section and clicks on Successful link 
	And user select any Favourite Vendor and clicks on Star mark 
	Then user Should able unmark as favourite and also verify toast message displayed in the page 
	
Scenario: 4. Mark as favourite Beneficiary from the Successful Tab 
	Given  user is on Login page{"Environment":"UAT","Path":"Single Payment","corpid":"GSTNDATA2A", "username":"MAKER3"}
	When user goes to Recent activity section and clicks on Successful link 
	And clicks on Beneficiary Tab 
	And user select any Beneficiary from the list and clicks on Star mark 
	Then user Should able mark as favourite and also verify toast message displayed in the page 
	
Scenario: 5. Remove favourite Beneficiary from the Successful Tab 
	Given  user is on Login page{"Environment":"UAT","Path":"Single Payment","corpid":"GSTNDATA2A", "username":"MAKER3"}
	When user goes to Recent activity section and clicks on Successful link 
	And clicks on Beneficiary Tab 
	And user select any Favourite Beneficiary and clicks on Star mark 
	Then user Should able unmark as favourite and also verify toast message displayed in the page 
	
Scenario: 6. Verify user able to make Payment by filling remaining details from Favourite Section 
	Given  user is on Login page{"Environment":"UAT","Path":"Single Payment","corpid":"DP1", "username":"ENTERER"}
	And user goes to Recent activity section and clicks on Successful link 
	And user select any favourite vendor from the list and capture transaction details 
	When user navigates to favourite section and clicks on ViewAll 
	And user is able to view the list of Favourites 
	And user select any Vendor from the list and clicks on Pay Button 
	And user verify prepopulated details are filled or not in the page 
	And user fills all the remaining details and clicks on make payment 
		|LEI                  |Credit Narration |Remarks to Approver    |RulesApplicable |Approver1|
		|4321001234567890H123 |456789           | One field is incorrect|1 EC + 1 BOD    |APPROVER |
	Then user verify fund transfer toast message displayed in the page 
	
Scenario: 7. Verify user able to Edit Payment from Favourite Section 
	Given  user is on Login page{"Environment":"UAT","Path":"Single Payment","corpid":"DP1", "username":"ENTERER"}
	And user navigates to favourite section and clicks on ViewAll 
	And user is able to view the list of Favourites 
	When user select any Favourite from the list and clicks on Pay Button 
	And user able to edit payment details and clicks on make payment
		|Amount |Paymentmode|FromAcctno    | LEI                  |Credit Narration |Remarks to Approver    |RulesApplicable |Approver1|
		|25    |NEFT       |  RAINBOW TOUCH | 4321001234567890H123 |456789           | One field is incorrect|1 EC + 1 BOD   |APPROVER |
	Then user verify fund transfer toast message displayed in the page 	
	
Scenario: 8. Add Beneficiary to Favourites for OtherBank 
	Given  user is on Login page{"Environment":"UAT","Path":"Single Payment","corpid":"DP1", "username":"ENTERER"}
	And user clicks on Beneficiary Management tab and clicks on Add New Beneficiary link 
	When user clicks on Add to Favourites checkbox 
	And user enter otherbank  details 
		|IFSCCode           |BeneAcctname             |BeneType                 |LEI       |AccountCategory| Mobileno  |Email                   |AddressLine1|AddressLine2|Pincode|Remarks                        |Approver|
		|YESB0000599        |OtherBankBene            |Individual / Govt. Entity|00123456  |Salary         |9023445689 |OtherBank@mail.com      |Hyderabad  |HitechCity   |500090 | otherBank Bene Added          |APPROVER3|
	And user clicks on Proceed and Submit Button 
	Then user Should able to see Beneficiary Managament Button 
	
Scenario: 9. Add Beneficiary to Favourites for AxisBank 
	Given  user is on Login page{"Environment":"UAT","Path":"Single Payment","corpid":"DP1", "username":"ENTERER"}
	And user clicks on Beneficiary Management tab and clicks on Add New Beneficiary link 
	When user selects on AxisBank Account 
	And user clicks on Add to Favourites checkbox 
	And user enter following details 
		|BeneAccno      |confirmBeneAccno     |BeneType      |AccountCategory     |Mobileno        |Email                             |AddressLine1|AddressLine2|Pincode|Remarks               |Approver|
		|909020031901569|909020031901569      |Non-Individual|Salary              |9000123639      |Testaxisbank@mail.com             |Hyderabad   |Madhapur    |500091 | AxisBank Bene Added  |APPROVER3|
	And user clicks on Proceed and Submit Button 
	Then user Should able to see Beneficiary Managament Button 
