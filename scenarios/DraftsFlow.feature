@DraftsFlow 
Feature: DraftsFlow 

Scenario: 1. Save as Draft while creating new Paymentmode of NEFT
	Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"DP1", "username":"ENTERER"}
	When user initiate new payment details  
		|Amount	|Paymentmode|FromAcctno      |ToAcctno        |toAccountTab|LEI                 |Credit Narration|Remarks to Approver    |RulesApplicable|Approver1|
		|100    |NEFT       |RAINBOW TOUCH   |008010200071202 |My Accounts |1234001234567890H123|123456          | One field is incorrect|1 EC + 1 BOD   |APPROVER |
	And user clicks on save as draft
	Then user verifies payment is added to Drafts {'DraftsName':'ACLUPRV SEICES'}

Scenario: 2. Recall Transaction for Statutory payments from Payments Overview
	Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"DP2", "username":"ENTERER"}
	When user selects payment from Statutory payments and clicks on Recall Transaction{"TransactionType":"GST NEFT/RTGS", "Status":"Pending with Approver"}
	Then user verifies RecallTransaction Success Message

Scenario: 3. Save as Draft while creating new Paymentmode of RTGS
	Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"DP1", "username":"ENTERER"}
	When user initiate new payment details 
		|Amount  |Paymentmode|FromAcctno    |ToAcctno          |toAccountTab       |LEI                  |Credit Narration |Remarks to Approver    |RulesApplicable |Approver1|
		|200001	 |RTGS       |ASAR IASOCTES |911020047840864   |Other Axis Accounts|4321001234567890H123 |456789           | One field is incorrect|1 EC + 1 BOD   |APPROVER |
	And user clicks on save as draft
	Then user verifies payment is added to Drafts {'DraftsName':'axisAccountValidatedAccountName'}
	
Scenario: 4. Delete Saved Drafts and validate count
	Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"DP1", "username":"ENTERER"}
	When user selects any draft and delete {'DraftsName':'1122 Bhupi'}
	Then user verifies payment deleted 
		
Scenario: 5. Sorting of Drafts Old to New
Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"DP2", "username":"ENTERER"}
	When user selects Drafts tab and sort it from Old to New
	Then user verifies if saved Drafts are in sorted order
	
Scenario: Sorting of Drafts New to Old
	Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"DP2", "username":"ENTERER"}
	When user selects Drafts tab and sort it from New to Old
	Then user verifies if saved Drafts are in sorted order
	
Scenario: 6. Save as Draft while creating new Paymentmode of IMPS
	Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"DP1", "username":"ENTERER"}
	When user initiate new payment details 
	|Amount |Paymentmode   |FromAcctno    |ToAcctno       |toAccountTab       |LEI                  |Credit Narration |Remarks to Approver    |RulesApplicable |Approver1|
	|500	|IMPS          |RAINBOW TOUCH |911020047840864|Other Axis Accounts|4321001234567890H123 |456789           | One field is incorrect|1 EC + 1 BOD    |APPROVER |
	And user clicks on save as draft
	Then user verifies payment is added to Drafts {'DraftsName':'1122 Bhupi'}
	
Scenario: 7. Add new Beneficiary saving as Drafts
	Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"DP1", "username":"ENTERER"}
	When user clicks on Beneficiary Management 
	And user clicks on AddNewBeneficiary 
	And user enter otherbank  details 
		        |IFSCCode           |BeneAcctname             |BeneType                 |LEI       |AccountCategory| Mobileno  |Email                   |AddressLine1|AddressLine2|Pincode|Remarks                        |Approver|
		        |YESB0000599        |OtherBankBene            |Individual / Govt. Entity|00123456  |Salary         |9023445689 |OtherBank@mail.com      |Hyderabad  |HitechCity   |500090 | otherBank Bene Added          |APPROVER3|
	And user clicks on save as draft
	And user clicks on proceed
	Then user verifies payment is added to Drafts {'DraftsName':'YESB0000599'}
	
Scenario:  8. Save as Draft while creating new error Payment
	Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"DP1", "username":"ENTERER"}
	When user initiate new Error payment details 
		|Amount	|Paymentmode|FromAcctno      |ToAcctno         |toAccountTab        |LEI                 |Credit Narration|Remarks to Approver    |RulesApplicable|Approver1|
		|200001 |RTGS       |RAINBOW TOUCH   |911020047840864  |Other Axis Accounts |1234001234567890H123|123456          | One field is incorrect|1 EC + 1 BOD   |APPROVER |
	And user clicks on save as draft
	Then user verifies payment is added to Drafts {'DraftsName':'axisAccountValidatedAccountName'}