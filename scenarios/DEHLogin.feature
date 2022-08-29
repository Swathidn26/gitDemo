@DEHLogin
Feature: DEHLogin

Scenario: 1. Login into DEH by entering crentials in lower case
Given user launch the DEH Urls{"Environment":"DEHDEV"}
When user enters the login details with lower case{"corpid":"SITCORP24", "username":"MAKER01"}
And user clicks on proceed and submit button by entering OTP number{"corpid":"SITCORP24", "username":"MAKER01"}
Then user should be logged into the system and redirected to the Dasboard screen

Scenario: 2. Login into DEH by entering crentials in upper case
Given user launch the DEH Urls{"Environment":"DEHDEV"}
When user enters the login details with upper case{"corpid":"SITCORP24", "username":"MAKER01"}
And user clicks on proceed and submit button by entering OTP number{"corpid":"SITCORP24", "username":"MAKER01"}
Then user should be logged into the system and redirected to the Dasboard screen

Scenario: 3. Login into DEH by entering invalid crentials
Given user launch the DEH Urls{"Environment":"DEHDEV"}
When user enters the login details with upper case{"corpid":"TESTCORP12", "username":"DUMMY"}
And user clicks on proceed button
Then system should be displayed with invalid credentials error message

Scenario: 4. Login into DEH by entering credentials which password has expired
Given user launch the DEH Urls{"Environment":"DEHDEV"}
When user enters the login details with upper case{"corpid":"SITCORP20", "username":"MAKER02"}
And user clicks on proceed button
Then system should display the password expired error message


Scenario: 5. Forgot or Reset password
Given user launch the DEH Urls{"Environment":"DEHDEV"}
And user click on forgot or reset password hyperlik
When user enter all the details to reset the password section
	|CorpID		|Username	|PhoneNumber	|Email|
	|SITCORP24	|MAKER01	|9597867855		|Automation@testmail.com|
And user clicks on proceed button
Then system should reset the password successfully

Scenario: 6. Activate account
Given user launch the DEH Urls{"Environment":"DEHDEV"}
When user click on Activate account hyperlik 
And user enter all the details to Activate Account section
    |CorpID		|Username	|PhoneNumber	|Email|
	|SITCORP24	|MAKER01	|9597867855		|Automation@testmail.com|
And user clicks on proceed button
Then system should activate the account successfully

Scenario: 7. Login into DEH application and logout from the application
Given user launch the DEH Urls{"Environment":"DEHDEV"}
When user enters the login details with upper case{"corpid":"SITCORP24", "username":"MAKER01"}
And user clicks on proceed and submit button by entering OTP number{"corpid":"SITCORP24", "username":"MAKER01"}
And user clicks on Log Out from profile menu
Then system should be logged out and redirected to the login screen

Scenario: 8. Verify the Forms And Download hyperlink
Given user launch the DEH Urls{"Environment":"DEHDEV"}
When user clicks on Forms & Download link
Then system should be redirected to Forms & Downloads page

Scenario: 9. Verify the Terms & Conditions hyperlink
Given user launch the DEH Urls{"Environment":"DEHDEV"}
When user clicks on terms & conditions link
Then system should be redirected to Terms & Conditions page

Scenario: 10. Verify the ATM/Branch hyperlink
Given user launch the DEH Urls{"Environment":"DEHDEV"}
When user clicks on ATM/Branch Locator link
Then system should be redirected to ATM Branch Lcator page

Scenario: 11. Verify the FAQ's hyperlink
Given user launch the DEH Urls{"Environment":"DEHDEV"}
When user clicks on FAQ's link
Then system should be redirected to FAQ's page

Scenario: 12. Verify the Online Security hyperlink
Given user launch the DEH Urls{"Environment":"DEHDEV"}
When user clicks on Online Security link
Then system should be redirected to Online Security page

Scenario: 13. Verify the Privacy Policy hyperlink
Given user launch the DEH Urls{"Environment":"DEHDEV"}
When user clicks on privacy policy link
Then system should be redirected to Privacy Policy page

Scenario: 14. Verify the API portal button link
Given user launch the DEH Urls{"Environment":"DEHDEV"}
When user clicks on API Portal link
Then system should be redirected to API Portal page

Scenario: 15. Verify the Customer care hyperlink
Given user launch the DEH Urls{"Environment":"DEHDEV"}
When user clicks on Customer Care link
Then system should display the customer care pop up

#Below scenarios might be need in future
  
#Scenario: Login and redirect to service overiview screen directly
#Given user launching the DEH Url and enter the valid credentials{"Environment":"DEHDEV", "Path":"Service", "corpid":"SITCORP24", "username":"MAKER01"}   
#When user select Payment menu from the redirection drop down{"Path":"Service"}
#And user clicks on proceed and submit button by entering OTP number{"corpid":"SITCORP24", "username":"MAKER01"}
#Then system should be redirected to Service Overview screen
#
#Scenario: Login and redirect to payments screen directly
#Given user launching the DEH Url and enter the valid credentials{"Environment":"DEHDEV", "Path":"Service", "corpid":"SITCORP24", "username":"MAKER01"}   
#When user select Payment menu from the redirection drop down{"Path":"Payments"}
#And user clicks on proceed and submit button by entering OTP number{"corpid":"SITCORP24", "username":"MAKER01"}
#Then system should be redirected to Payments Overview screen

#Scenario: Verifying Forgot Corp ID functionality
#Given user launch the DEH Urls{"Environment":"DEHDEV"}
#When user click on forgot corp ID hyperlik
#And user enter all the details to retrive the Corp ID
#    |EmailID		        |ContactNumber	|
#	|Automation@test.com	|9597867855	    |
#And user clicks on get OTP button
#
#Scenario: Verifying Forgot User ID functionality
#Given user launch the DEH Urls{"Environment":"DEHDEV"}
#When  user click on forgot user ID hyperlik
#And user enter all the details to retrive the user ID
#    |EmailID		        |ContactNumber	|
#	|Automation@test.com	|9597867855	    |
#And user clicks on get OTP button

