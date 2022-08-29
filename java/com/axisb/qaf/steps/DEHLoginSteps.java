package com.axisb.qaf.steps;

import java.util.List;
import java.util.Map;

import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.pages.DEHLoginPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Validator;

public class DEHLoginSteps extends WebDriverTestCase {
	DEHLoginPage dehLoginPage = new DEHLoginPage();

	@QAFTestStep(description = "user launching the DEH Url and enter the valid credentials{0}")
	public void launchUrl_And_EnterCredentials(Map<String, String> loginDetails) throws Exception {
		if (loginDetails.get("Environment").equals("DEHQA") && loginDetails.get("Path").equalsIgnoreCase("Payments")) {
			dehLoginPage.openDEHBaseWithOtpUrl(loginDetails);
			dehLoginPage.enterLoginDetails(loginDetails);
		}else if(loginDetails.get("Environment").equals("DEHDEV") && loginDetails.get("Path").equalsIgnoreCase("Payments")) {
			dehLoginPage.openDEHBaseWithOtpUrl(loginDetails);
			dehLoginPage.enterLoginDetails(loginDetails);
		}else if(loginDetails.get("Environment").equals("DEHQA") && loginDetails.get("Path").equalsIgnoreCase("Service")) {
			dehLoginPage.openDEHBaseWithOtpUrl(loginDetails);
			dehLoginPage.enterLoginDetails(loginDetails);
		}else if(loginDetails.get("Environment").equals("DEHDEV") && loginDetails.get("Path").equalsIgnoreCase("Service")) {
			dehLoginPage.openDEHBaseWithOtpUrl(loginDetails);
			dehLoginPage.enterLoginDetails(loginDetails);
		}
	}
	@QAFTestStep(description = "user launch the DEH Urls{0}")
	public void launchDEHUrls(Map<String, String> loginDetails) throws Exception {
		try {
			dehLoginPage.openDEHBaseWithOtpUrl(loginDetails);
		} catch (Exception e) {
			Validator.assertTrue(false, "Unable to open the URL! Check the screenshots for more Info", "");
		}
	}
	@QAFTestStep(description = "user enters the login details with lower case{0}")
	public void enterCredntialsInLowerCase(Map<String, String> loginDetails) throws Exception {
		  dehLoginPage.enterLoginDetailsInLowerCase(loginDetails);
	}
	@QAFTestStep(description = "user enters the login details with upper case{0}")
	public void enterCredntialsInUpperCase(Map<String, String> loginDetails) throws Exception {
		  dehLoginPage.enterLoginDetails(loginDetails);
	}
	
	@QAFTestStep(description = "user select Payment menu from the redirection drop down{0}")
	public void selectPaymentMenu(Map<String, String> loginDetails) throws Exception {
		if(loginDetails.get("Path").equalsIgnoreCase("Service")) {
		 dehLoginPage.selectServiceMenu(loginDetails);
		}else if(loginDetails.get("Path").equalsIgnoreCase("Payments")) {
		 dehLoginPage.selectPaymentMenu(loginDetails);
		}
	}

	@QAFTestStep(description="user clicks on proceed and submit button by entering OTP number{0}")
	public void clickOnProceedAndSubmit(Map<String, String> loginDetails) throws Exception {
		dehLoginPage.clickProceedBtn();
		dehLoginPage.enterOTP(dehLoginPage.getOTP(loginDetails));
		dehLoginPage.clickOTPSubmitBtn();
	}
	
	@QAFTestStep(description="user clicks on proceed button")
	public void clickOnProceedButton() throws Exception {
		dehLoginPage.clickProceedBtn();
	}
	
	@QAFTestStep(description="user clicks on get OTP button")
	public void clickOnGetOTPButton() throws Exception {
		dehLoginPage.clickGetOtpBtn();
	}
	
	@QAFTestStep(description="system should be displayed with invalid credentials error message")
	public void verifyingInvalidCredentialErrorMsg() throws Exception {
		dehLoginPage.verifyInvalidCredentialsErrorMsg();
	}
	
	@QAFTestStep(description="system should display the password expired error message")
	public void verifyingExpiredPasswordErrorMsg() throws Exception {
		dehLoginPage.verifyPasswordExpiredErrorMsg();
	}
	
	@QAFTestStep(description="system should be redirected to Service Overview screen")
	public void verifyServiceScreen() throws Exception {
		dehLoginPage.verifyServiceScreen();
	}
	
	@QAFTestStep(description="system should be redirected to Payments Overview screen")
	public void verifyingPaymentsScreen() throws Exception {
		dehLoginPage.verifyPaymentscreen();
	}
	
	@QAFTestStep(description="user should be logged into the system and redirected to the Dasboard screen")
	public void verifyingDashoardScreen() throws Exception {
		dehLoginPage.verifyDashboardscreen();
	}
	
	@QAFTestStep(description="system should be logged out and redirected to the login screen")
	public void verifyingLoginScreen() throws Exception {
		dehLoginPage.verifyLoginscreen();
	}
	
	@QAFTestStep(description="user click on forgot corp ID hyperlik")
	public void clickOnForgotCorpIDLink() throws customElementNotClickableException, customElementNotFoundException {
		dehLoginPage.clickOnForgotCorpID();
	}
	
	@QAFTestStep(description="user click on forgot user ID hyperlik")
	public void clickOnForgotUserIDLink() throws customElementNotClickableException, customElementNotFoundException {
		dehLoginPage.clickOnForgotUserID();
	}
	
	@QAFTestStep(description="user click on forgot or reset password hyperlik")
	public void clickOnForgotPasswordLink() throws customElementNotClickableException, customElementNotFoundException {
		dehLoginPage.clickOnForgotPassword();
	}
	
	@QAFTestStep(description="user enter all the details to retrive the Corp ID{0}")
	public void enterDetailsOfForgotCorpID(List<Map<String, String>> forgotCorpOrUserID) throws customElementNotClickableException, customElementNotFoundException {
		dehLoginPage.enterDetailsOfForgotCorpIDorUserID(forgotCorpOrUserID);
	}
	
	@QAFTestStep(description="user enter all the details to retrive the User ID{0}")
	public void enterDetailsOfForgotUserID(List<Map<String, String>> forgotCorpOrUserID) throws customElementNotClickableException, customElementNotFoundException {
		dehLoginPage.enterDetailsOfForgotCorpIDorUserID(forgotCorpOrUserID);
	}
	
	@QAFTestStep(description="user enter all the details to reset the password section{0}")
	public void enterDetailsOfForgotCorpIDorUserID(List<Map<String, String>> forgotPasswordDetails) throws customElementNotClickableException, customElementNotFoundException {
		dehLoginPage.enterForgotPasswordDetails(forgotPasswordDetails);
	}
	
	@QAFTestStep(description="user clicks on Log Out from profile menu")
	public void clickOnProfileMenu() throws customElementNotClickableException, customElementNotFoundException {
		dehLoginPage.clickOnProfileManu();
		dehLoginPage.clickOnLogOut();
	}
	
	@QAFTestStep(description="system should reset the password successfully")
	public void resetPasswordSuccessMsg() throws customElementNotClickableException, customElementNotFoundException {
		//Yet to implement 
	}
	
	@QAFTestStep(description="user click on Activate account hyperlik")
	public void clickOnActivateAccountLink() throws customElementNotClickableException, customElementNotFoundException {
		dehLoginPage.clickOnActivateAccount();
	}
	
	@QAFTestStep(description="user enter all the details to Activate Account section{0}")
	public void enterDetailsToActivateAccountSection(List<Map<String, String>> activateAccountDetails) throws customElementNotClickableException, customElementNotFoundException {
		dehLoginPage.enterActivateAccountDetails(activateAccountDetails);
	}
	
	@QAFTestStep(description="system should activate the account successfully")
	public void activateAccountSuccessMsg() throws customElementNotClickableException, customElementNotFoundException {
		//Yet to implement 
	}
	
	@QAFTestStep(description="user enters the old and new password for the reset{0}")
	public void enterDetailsForPasswordReset(Map<String, String> activateAccountDetails) throws customElementNotClickableException, customElementNotFoundException {
		dehLoginPage.enterDetailsForPasswordReset(activateAccountDetails);
	}
	
	@QAFTestStep(description="user clicks on Forms & Download link")
	public void clickOnFormsAndDonloads() throws customElementNotClickableException, customElementNotFoundException {
		dehLoginPage.clickOnFormsAndDownloadLink(); 
	}
	
	@QAFTestStep(description="user clicks on terms & conditions link")
	public void clickOnTermsAndConditionsLink() throws customElementNotClickableException, customElementNotFoundException {
		dehLoginPage.clickOnTermsAndConditionsLink(); 
	}
	
	@QAFTestStep(description="user clicks on ATM/Branch Locator link")
	public void clickOnATMBranchLocatorLink() throws customElementNotClickableException, customElementNotFoundException {
		dehLoginPage.clickOnATMBranchLocatorLink(); 
	}
	
	@QAFTestStep(description="user clicks on FAQ's link")
	public void clickOnFAQLink() throws customElementNotClickableException, customElementNotFoundException {
		dehLoginPage.clickOnFAQLink(); 
	}
	
	@QAFTestStep(description="user clicks on Online Security link")
	public void clickOnOnlineSecurityLink() throws customElementNotClickableException, customElementNotFoundException {
		dehLoginPage.clickOnOnlineSecurityLink(); 
	}
	
	@QAFTestStep(description="user clicks on privacy policy link")
	public void clickOnPrivacyPolicyLink() throws customElementNotClickableException, customElementNotFoundException {
		dehLoginPage.clickOnPrivacyPolicyLink(); 
	}
	
	@QAFTestStep(description="user clicks on API Portal link")
	public void clickOnAPIPortalLink() throws customElementNotClickableException, customElementNotFoundException {
		dehLoginPage.clickOnAPIPortalLink(); 
	}
	
	@QAFTestStep(description="user clicks on Customer Care link")
	public void clickOnCustomerCareLink() throws customElementNotClickableException, customElementNotFoundException {
		dehLoginPage.clickOnCustomerCareLink(); 
	}
	
	@QAFTestStep(description="system should be redirected to Forms & Downloads page")
	public void verifyFormsAndDownloadUrl() throws Exception {
		dehLoginPage.verifyFormsAndDownloadUrl();
	}
	
	@QAFTestStep(description="system should be redirected to Terms & Conditions page")
	public void verifyTermsAndConditionsUrl() throws Exception {
		dehLoginPage.verifyTermsAndConditionsUrl();
	}
	
	@QAFTestStep(description="system should be redirected to ATM Branch Lcator page")
	public void verifyATMBranchLocatorUrl() throws Exception {
		dehLoginPage.verifyATMBranchLocatorUrl();
	}
	
	@QAFTestStep(description="system should be redirected to FAQ's page")
	public void verifyFAQUrl() throws Exception {
		dehLoginPage.verifyFAQUrl();
	}
	
	@QAFTestStep(description="system should be redirected to Online Security page")
	public void verifyOnlineSecurityUrl() throws Exception {
		dehLoginPage.verifyOnlineSecurityUrl();
	}
	
	@QAFTestStep(description="system should be redirected to Privacy Policy page")
	public void verifyPrivacyPolicyUrl() throws Exception {
		dehLoginPage.verifyPrivacyPolicyUrl();
	}
	
	@QAFTestStep(description="system should display the customer care pop up")
	public void verifyCustomerCarePopUp() throws Exception {
		dehLoginPage.verifyCustomerCarePopUp();
	}
	
	@QAFTestStep(description="system should be redirected to API Portal page")
	public void verifyAPIPortalUrl() throws Exception {
		dehLoginPage.verifyAPIPortalUrl();
	}
	
}
