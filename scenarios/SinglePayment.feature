@SinglePayment 
Feature: SinglePayment 
Background: Single Payment 
	Given user is on Login page{"Environment":"UAT", "Path":"Single Payment", "corpid":"DP1", "username":"ENTERER2"} 
Scenario: Initiate New Payment for NEFT Mode using My Accounts 
	When user clicks on NewPayment tab 
	And navigates to Single Payment Page 
	And enters below payment details 
		|Amount	|Paymentmode|FromAcctno      |ToAcctno         |toAccountTab |LEI                 |Credit Narration|Remarks to Approver    |RulesApplicable|Approver1|
		|100    |NEFT       |RAINBOW TOUCH   |008010200071202  |My Accounts  |1234001234567890H123|123456          | NEFT Transaction      |1 EC + 1 BOD   |APPROVER2 |
	And user clicks on Proceed Button 
	Then user verifies Bank Payment is successfully completed 
	
Scenario: Initiate New Payment for RTGS Mode using Axis Accounts 
	When user clicks on NewPayment tab 
	And navigates to Single Payment Page 
	And enters below payment details 
		|Amount  |Paymentmode|FromAcctno    |ToAcctno          |toAccountTab       |LEI                  |Credit Narration |Remarks to Approver    |RulesApplicable |Approver1|
		|200001	 |RTGS       |ASAR IASOCTES |911020047840864   |Other Axis Accounts|4321001234567890H123 |456789           | RTGS Transaction      |1 EC + 1 BOD   |APPROVER2 |
	And user clicks on Proceed Button 
	Then user verifies Bank Payment is successfully completed 
	
Scenario: Initiate New Payment for IMPS Mode using Other Accounts 
	When user clicks on NewPayment tab 
	And navigates to Single Payment Page 
	And enters below payment details 
		|Amount |Paymentmode   |FromAcctno    |ToAcctno       |toAccountTab       |LEI                  |Credit Narration |Remarks to Approver    |RulesApplicable |Approver1|
		|500	|IMPS          |RAINBOW TOUCH |969420         |Other Bank Accounts|4321001234567890H123 |456789           | IMPS Transaction      |1 EC + 1 BOD    |APPROVER2 |
	And user clicks on Proceed Button 
	Then user verifies Bank Payment is successfully completed 
	
Scenario: Initiate Recurring Payment for IMPS Mode using Other Accounts 
	When user clicks on NewPayment tab 
	And navigates to Single Payment Page 
	And user clicks on Recurring Payment checkbox and select frequency type and installments 
		|FrequencyType|Installements| 
		|   Monthly   |    32         |
	And enters below payment details 
		|Amount |Paymentmode   |FromAcctno    |ToAcctno       |toAccountTab       |LEI                  |Credit Narration |Remarks to Approver    |RulesApplicable |Approver1|
		|500	|IMPS          |RAINBOW TOUCH |969420         |Other Bank Accounts|4321001234567890H123 |456789           |IMPS Recurring         |1 EC + 1 BOD    |APPROVER2 |
	And user clicks on Proceed Button 
	Then user verifies Bank Payment is successfully completed 
	
Scenario: Schedule Payment for NEFT Mode using My Accounts 
	Given user clicks on NewPayment tab 
	And navigates to Single Payment Page 
	When user selects any date after the current date 
		|SelectMonth   |SelectDate|
		|December 2022  |    19    |
	And enters below payment details 
		|Amount	|Paymentmode|FromAcctno      |ToAcctno         |toAccountTab |LEI                 |Credit Narration|Remarks to Approver        |RulesApplicable|Approver1|
		|100    |NEFT       |RAINBOW TOUCH   |008010200071202  |My Accounts  |1234001234567890H123|123456          | NEFT Scheduled Transaction|1 EC + 1 BOD   |APPROVER2 |
	And user clicks on Proceed Button 
	Then user verifies Bank Payment is successfully completed 
	
Scenario: Initiate  Mutliple New Payment for NEFT Mode using My Accounts 
	When user clicks on NewPayment tab 
	And navigates to Single Payment Page 
	And enters below payment details 
		|Amount	|Paymentmode|FromAcctno      |ToAcctno         |toAccountTab |LEI                 |Credit Narration|Remarks to Approver    |RulesApplicable|Approver1|
		|100    |NEFT       |RAINBOW TOUCH   |ACLUPRV SEICES  |My Accounts  |1234001234567890H123|123456          | NEFT Scheduled Transaction|1 EC + 1 BOD   |APPROVER2 |
	And user clicks on Proceed Button and Add New Payment Button 
	And enters below payment details 
		|Amount |Paymentmode   |FromAcctno    |ToAcctno       |toAccountTab       |LEI                  |Credit Narration |Remarks to Approver            |RulesApplicable |Approver1|
		|500	|IMPS          |RAINBOW TOUCH |1122 Bhupi         |Other Bank Accounts|4321001234567890H123 |456789       | NEFT Multiple Payment        |1 EC + 1 BOD    |APPROVER2 |
	And user clicks on AddPayment Button and user validate multiple payment details 
	Then user verifies Bank Payment is successfully completed 
	
	
Scenario: Schedule Multiple Payment for NEFT Mode using My Accounts 
	Given user clicks on NewPayment tab 
	And navigates to Single Payment Page 
	When user selects any date after the current date 
		|SelectMonth   |SelectDate|
		|December 2022     |    13    |
	And enters below payment details 
		|Amount	|Paymentmode|FromAcctno      |ToAcctno         |toAccountTab |LEI                 |Credit Narration|Remarks to Approver      |RulesApplicable|Approver1|
		|100    |NEFT       |RAINBOW TOUCH   |ACLUPRV SEICES  |My Accounts  |1234001234567890H123|123456           | NEFT Schedule Transaction|1 EC + 1 BOD   |APPROVER2 |
	And user clicks on Proceed Button and Add New Payment Button 
	And user selects any date after the current date 
		|SelectMonth   |SelectDate|
		|December 2022     |    22     |
	And enters below payment details 
		|Amount |Paymentmode   |FromAcctno    |ToAcctno       |toAccountTab       |LEI                  |Credit Narration |Remarks to Approver      |RulesApplicable |Approver1|
		|500	|IMPS          |RAINBOW TOUCH |1122 Bhupi     |Other Bank Accounts|4321001234567890H123 |456789           |IMPS Schedule Transaction|1 EC + 1 BOD    |APPROVER2 |
	And user clicks on AddPayment Button and user validate multiple payment details 
	Then user verifies Bank Payment is successfully completed 
	
Scenario: Initiate Multiple Recurring Payment for IMPS Mode using Other Accounts 
	Given user clicks on NewPayment tab 
	And navigates to Single Payment Page 
	When user clicks on Recurring Payment checkbox and select frequency type and installments 
		|FrequencyType|Installements| 
		|   Monthly   |    32        |
	And enters below payment details 
		|Amount |Paymentmode   |FromAcctno    |ToAcctno       |toAccountTab       |LEI                  |Credit Narration |Remarks to Approver    |RulesApplicable |Approver1|
		|500	|IMPS          |RAINBOW TOUCH |008010200071202|My Accounts|4321001234567890H123         |456789           | IMPS Recurring Tranaction|1 EC + 1 BOD    |APPROVER2 |
	And user clicks on Proceed Button and Add New Payment Button 
	And user clicks on Recurring Payment checkbox and select frequency type and installments 
		|FrequencyType|Installements| 
		|   Monthly   |    10       |
	And enters below payment details 
		|Amount	|Paymentmode|FromAcctno      |ToAcctno         |toAccountTab |LEI                 |Credit Narration       |Remarks to Approver    |RulesApplicable|Approver1|
		|100    |NEFT       |RAINBOW TOUCH   |911020047840864  |Other Axis Accounts |1234001234567890H123|123456          | IMPS Recurring Tranaction|1 EC + 1 BOD   |APPROVER2 |
	And user clicks on AddPayment Button and user validate multiple payment details 
	Then user verifies Bank Payment is successfully completed 
	
Scenario: Initiate  Mutliple Payment for NEFT Mode using My Accounts  and delete any one payment 
	Given user clicks on NewPayment tab 
	And navigates to Single Payment Page 
	When enters below payment details 
		|Amount	|Paymentmode|FromAcctno      |ToAcctno         |toAccountTab |LEI                    |Credit Narration|Remarks to Approver       |RulesApplicable|Approver1|
		|100    |NEFT       |ACLUPRV SEICES   |21OCT  |Other Bank Accounts  |1234001234567890H123    |123456          | NEFT Multiple Transaction|1 EC + 1 BOD   |APPROVER2 |
	And user clicks on Proceed Button and Add New Payment Button 
	And enters below payment details 
		|Amount |Paymentmode   |FromAcctno        |ToAcctno           |toAccountTab       |LEI          |Credit Narration |Remarks to Approver            |RulesApplicable |Approver1|
		|500	|IMPS          |ACLUPRV SEICES    |RAINBOW TOUCH      |My Accounts|4321001234567890H123 |456789           | IMPS Multiple Transaction     |1 EC + 1 BOD    |APPROVER2 |
	And user clicks on AddPayment Button and user validate multiple payment details 
	And user delete any one payments and verify delete toast message 
	Then user verifies Bank Payment is successfully completed 
	
Scenario: Initiate New Payment and Edit existing Payment details for NEFT Mode using My Accounts 
	Given user clicks on NewPayment tab 
	And navigates to Single Payment Page 
	When enters below payment details 
		|Amount	|Paymentmode|FromAcctno      |ToAcctno         |toAccountTab      |LEI                    |Credit Narration|Remarks to Approver    |RulesApplicable|Approver1|
		|100    |NEFT       |RAINBOW TOUCH   |1122 Bhupi       |Other Bank Accounts  |1234001234567890H123|123456          | Edit NEFT Transaction|1 EC + 1 BOD   |APPROVER|
	And user clicks on Proceed Button 
	And user clicks on Edit and fill the remaining details 
		|FromAcctno    |ToAcctno                |toAccountTab           |RulesApplicable|Approver1|
		|ACLUPRV SEICES|911020047840864         |Other Axis Accounts    |1 EC + 1 BOD   |APPROVER2|
	And And user clicks on Proceed Button 
	Then user verifies Bank Payment is successfully completed 
	
Scenario: Initiate  Mutliple Payment for NEFT Mode using My Accounts and delete all Payments 
	When user clicks on NewPayment tab 
	And navigates to Single Payment Page 
	And enters below payment details 
		|Amount	|Paymentmode|FromAcctno      |ToAcctno         |toAccountTab |LEI                 |Credit Narration|Remarks to Approver     |RulesApplicable|Approver1|
		|100    |NEFT       |ACLUPRV SEICES  |RAINBOW TOUCH |My Accounts  |1234001234567890H123   |   123456       | Delete NEFT Transaction|1 EC + 1 BOD   |APPROVER2 |
	And user clicks on Proceed Button and Add New Payment Button 
	And enters below payment details 
		|Amount |Paymentmode   |FromAcctno                        |ToAcctno           |toAccountTab       |LEI                  |Credit Narration |Remarks to Approver            |RulesApplicable |Approver1|
		|500	|IMPS          |AXGALHIY SANP MMEAGEPVNT TDT L    |55151              |Other Bank Accounts|4321001234567890H123 |456789           | Delete IMPS Transaction        |1 EC + 1 BOD    |APPROVER2 |
	And user clicks on AddPayment Button and user validate multiple payment details 
	Then user clicks deletes all existing payments and verify delete toast message 
	
Scenario: Initiate New Payment and Copy the existing Payment for NEFT Mode using My Accounts 
	Given user clicks on NewPayment tab 
	And navigates to Single Payment Page 
	And user selects any date after the current date 
		|SelectMonth   |SelectDate|
		|December 2022     |    23     |
	When enters below payment details 
		|Amount	|Paymentmode|FromAcctno      |ToAcctno         |toAccountTab |LEI                    |Credit Narration|Remarks to Approver    |RulesApplicable|Approver1|
		|100    |NEFT       |RAINBOW TOUCH   |1122 Bhupi  |Other Bank Accounts  |1234001234567890H123|123456          | Copy NEFT Payment     |1 EC + 1 BOD   |APPROVER2 |
	And user clicks on Proceed Button 
	And user clicks on Copy and Validate copied details 
	And user clicks on Proceed Button and Validate summary page displayed details 
	Then user verifies Bank Payment is successfully completed 
