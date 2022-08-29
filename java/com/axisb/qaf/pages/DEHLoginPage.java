package com.axisb.qaf.pages;

import java.io.FileReader;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.axisb.qaf.exceptions.customElementFoundException;
import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.utils.CommonUtility;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class DEHLoginPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	LoginPage loginPage = new LoginPage();
	FileReader read = null;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(locator = "xpath=//label[contains(text(),'Corporate ID')]/following-sibling::div/input")
	private QAFWebElement corpID;

	@FindBy(locator = "xpath=//label[contains(text(),'Login ID*')]/following-sibling::div/input")
	private QAFWebElement loginID;

	@FindBy(locator = "xpath=//label[contains(text(),'Contact Number')]/following-sibling::div/input")
	private QAFWebElement phoneNumber;

	@FindBy(locator = "xpath=//label[contains(text(),'Email ID')]/following-sibling::div/input")
	private QAFWebElement email;

	@FindBy(locator = "xpath=//input[@type='password']")
	private QAFWebElement password;

	@FindBy(locator = "xpath=//span[contains(text(),'Proceed')]/parent::span/parent::button")
	private QAFWebElement proceedBtn;

	@FindBy(locator = "xpath=//span[contains(text(),'Trouble logging in')]")
	private QAFWebElement trobleLoggingIn;

	@FindBy(locator = "xpath=//span[contains(text(),'Activate Account')]")
	private QAFWebElement activateAccount;

	@FindBy(locator = "xpath=//span[contains(text(),'Submit')]")
	private QAFWebElement btnOTPSubmit;

	@FindBy(locator = "xpath=//button[text()='Refresh']")
	private QAFWebElement refreshBtn;

	@FindBy(locator = "xpath=//span[contains(text(),'Dashboard')]")
	private QAFWebElement dashboardMenu;

	@FindBy(locator = "xpath=//div[@id='service']")
	private QAFWebElement serviceMenu;

	@FindBy(locator = "xpath=//div[@id='payments']")
	private QAFWebElement paymentsMenu;

	@FindBy(locator = "xpath=//div[@id='reports']")
	private QAFWebElement reportsMenu;

	@FindBy(locator = "xpath=//div[@id='drafts']")
	private QAFWebElement draftsMenu;

	@FindBy(locator = "xpath=//div[@id='treasury']")
	private QAFWebElement treasuryMenu;

	@FindBy(locator = "xpath=//div[@id='commercial-cards']")
	private QAFWebElement commercialCardsMenu;

	@FindBy(locator = "xpath=//span[contains(text(),'Dashboard')]")
	private QAFWebElement redirectionDropdown;

	@FindBy(locator = "xpath=//span[contains(text(),'Payment Overview')]")
	private QAFWebElement redirectToPayment;

	@FindBy(locator = "xpath=//span[contains(text(),'Service Request Overview')]")
	private QAFWebElement redirectToService;

	@FindBy(locator = "xpath=//span[text()='Forgot Corporate ID?']")
	private QAFWebElement forgotCorpID;

	@FindBy(locator = "xpath=//label[contains(text(),'Contact Number')]/following-sibling::div/input")
	private QAFWebElement contactNumber;

	@FindBy(locator = "xpath=//span[text()='Get OTP']")
	private QAFWebElement getOTP;

	@FindBy(locator = "xpath=//span[text()='Forgot Login ID?']")
	private QAFWebElement forgotUserID;

	@FindBy(locator = "xpath=//span[contains(text(),'Forgot/ Reset Password?')]")
	private QAFWebElement forgotPassword;

	@FindBy(locator = "xpath=(//p)[1]")
	private QAFWebElement errorMsg;

	@FindBy(locator = "xpath=//span[text()='Service Overview']")
	private QAFWebElement serviceOverviewLbl;

	@FindBy(locator = "xpath=//div[text()='Payments Overview']")
	private QAFWebElement paymentsOverviewLbl;

	@FindBy(locator = "xpath=//div[contains(@class,'profile-menu_loginIDText')]")
	private QAFWebElement profileMenu;

	@FindBy(locator = "xpath=//li[text()='LOG OUT']")
	private QAFWebElement logOut;

	@FindBy(locator = "xpath=//li[text()='PASSWORD RESET']")
	private QAFWebElement passwordReset;

	@FindBy(locator = "xpath=//label[text()='Old Password*']/following::div[1]")
	private QAFWebElement oldPassword;

	@FindBy(locator = "xpath=//label[text()='New Password*']/following::div[1]")
	private QAFWebElement newPassword;

	@FindBy(locator = "xpath=//label[text()='Confirm New Password*']/following::div[1]")
	private QAFWebElement confirmNewPassword;

	@FindBy(locator = "xpath=//div[contains(text(),'Download Forms')]")
	private QAFWebElement formsAndDownloadLink;

	@FindBy(locator = "xpath=//div[text()='Terms & Conditions']")
	private QAFWebElement termsAndConditionsLink;

	@FindBy(locator = "xpath=//div[contains(text(),'ATM/Branch Locator')]")
	private QAFWebElement atmBranchLocatorLink;

	@FindBy(locator = "xpath=//div[contains(text(),'FAQ')]")
	private QAFWebElement faqLink;

	@FindBy(locator = "xpath=//li[contains(text(),'Customer Care')]")
	private QAFWebElement customerCareLink;

	@FindBy(locator = "xpath=//a[contains(text(),'customer@axis.com')]")
	private QAFWebElement customerCarePopUp;

	@FindBy(locator = "xpath=//span[contains(text(),'API Portal')]")
	private QAFWebElement apiPortalLink;

	@FindBy(locator = "xpath=//div[contains(text(),'Online Security')]")
	private QAFWebElement onlineSecurityLink;

	@FindBy(locator = "xpath=//div[contains(text(),'Privacy Policy')]")
	private QAFWebElement privacyPolicyLink;

	public QAFWebElement getDashboardMenu() {
		return dashboardMenu;
	}

	public QAFWebElement getServiceMenu() {
		return serviceMenu;
	}

	public QAFWebElement getPaymentsMenu() {
		return paymentsMenu;
	}

	public QAFWebElement getReportsMenu() {
		return reportsMenu;
	}

	public QAFWebElement getDraftsMenu() {
		return draftsMenu;
	}

	public QAFWebElement getTreasuryMenu() {
		return treasuryMenu;
	}

	public QAFWebElement getCommercialCardMenu() {
		return commercialCardsMenu;
	}

	/*********** DEH Login *******/
	public void enterLoginDetails(Map<String, String> loginDetails) throws Exception {
		CommonUtility.cWaitForPageLoad(driver);
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, corpID);
		CommonUtility.cSendKeys(driver, corpID, loginDetails.get("corpid").toUpperCase());
		CommonUtility.cSendKeys(driver, loginID, loginDetails.get("username").toUpperCase());
		CommonUtility.cSendKeys(driver, password, CommonUtility
				.cDecryptPassword(CommonUtility.property.getProperty("encrypt.key"), CommonUtility.property.getProperty(
						loginDetails.get("corpid").toUpperCase() + "." + loginDetails.get("username").toUpperCase())));
	}

	public void enterLoginDetailsInLowerCase(Map<String, String> loginDetails) throws Exception {
		CommonUtility.cWaitForPageLoad(driver);
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, corpID);
		CommonUtility.cSendKeys(driver, corpID, loginDetails.get("corpid").toLowerCase());
		CommonUtility.cSendKeys(driver, loginID, loginDetails.get("username").toLowerCase());
		CommonUtility.cSendKeys(driver, password, CommonUtility
				.cDecryptPassword(CommonUtility.property.getProperty("encrypt.key"), CommonUtility.property.getProperty(
						loginDetails.get("corpid").toUpperCase() + "." + loginDetails.get("username").toUpperCase())));
	}

	public void clickProceedBtn()
			throws customElementNotClickableException, customElementNotFoundException, customElementFoundException {
		CommonUtility.cClick(driver, proceedBtn);
		CommonUtility.cWaitForLoaderAbsenceWithSpinner(driver, 10);
	}

	public void clickGetOtpBtn()
			throws customElementNotClickableException, customElementNotFoundException, customElementFoundException {
		CommonUtility.cClick(driver, getOTP);
		CommonUtility.cWaitForLoaderAbsenceWithSpinner(driver, 10);
	}

	public void openUrl(Map<String, String> loginDetails, WebElement menu) throws Exception {
		try {
			openDEHBaseWithOtpUrl(loginDetails);
		} catch (Exception e) {
			Validator.assertTrue(false, "Unable to open the URL! Check the screenshots for more Info", "");
		}
		try {
			enterLoginDetails(loginDetails);
		} catch (Exception e) {
			Validator.assertTrue(false, "Unable to enter Credentials! Check the screenshots for more Info", "");
		}
		try {
			clickProceedBtn();
		} catch (Exception e) {
			Validator.assertTrue(false, "Unable to click on the Proceed button! Check the screenshots for more Info",
					"");
		}
		try {
			enterOTP(getOTP(loginDetails));
		} catch (Exception e) {
			Validator.assertTrue(false, "Unable to enter OTP! Check the screenshots for more Info", "");
		}
		try {
			clickOTPSubmitBtn();
		} catch (Exception e) {
			Validator.assertTrue(false, "Unable to Login into the system! Check the screenshots for more Info", "");
		}
		try {
			navigationMenu(loginDetails, menu);
		} catch (Exception e) {
			Validator.assertTrue(false, "Unable to navigate to specific screen! Check the screenshots for more Info",
					"");
		}
	}

	/**
	 * Method to Open Base URL and OTP Portal
	 * 
	 * @throws Exception
	 **/
	public void openDEHBaseWithOtpUrl(Map<String, String> loginDetails) throws Exception {
		CommonUtility.cLoadProperties(System.getProperty("user.dir") + "/resources/application.properties");
		if (loginDetails.get("Environment").equalsIgnoreCase("DEHQA")) {
			driver.get(CommonUtility.property.getProperty("env.baseDEHurlQA"));
		} else if (loginDetails.get("Environment").equalsIgnoreCase("DEHDEV")) {
			driver.get(CommonUtility.property.getProperty("env.baseDEHurlDEV"));
		} else if (loginDetails.get("Environment").equalsIgnoreCase("DEHUAT")) {
			driver.get(CommonUtility.property.getProperty("env.baseDEHurlUAT"));
		}
		CommonUtility.cWaitForPageLoad(driver);
		String currentWindow = driver.getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		for (String window : tabs) {
			driver.switchTo().window(window);
			if (!window.equals(currentWindow)) {
				driver.close();
			}
		}
		driver.switchTo().window(currentWindow);
		loginPage.loadAPI(loginDetails);
		loginPage.launchDEH_OTP_URL(loginDetails);
		driver.manage().window().maximize();
	}

	/** Method to get OTP from OTP Portal **/

	public String getOTP(Map<String, String> loginDetails) throws Exception {
		String currentWindow = driver.getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		for (String window : tabs) {
			driver.switchTo().window(window);
			if (driver.getCurrentUrl().contains("userOtp")) {
				driver.navigate().refresh();
				CommonUtility.cWaitForPageLoad(driver);
				CommonUtility.cClick(driver, refreshBtn);
				break;
			}
		}
		String otp = fetchOTP(loginDetails);
		driver.switchTo().window(currentWindow);
		return otp;
	}

	/**
	 * Method to Fetch OTP from OTP site
	 */
	public String fetchOTP(Map<String, String> loginDetails)
			throws customElementNotClickableException, customElementNotFoundException {
		driver.get(driver.getCurrentUrl());
		CommonUtility.cWaitForPageLoad(driver);
		List<WebElement> otpTable = CommonUtility.cFindElements(driver, By.xpath("//table/tbody/tr"), 10);
		String OTP = "";

		for (int i = 0; i < otpTable.size(); i++) {
			String xpathUSER = "//table/tbody/tr[" + (i + 1) + "]/td[1]";
			String xpathENCOTP = "//table/tbody/tr[" + (i + 1) + "]/td[2]";
			String xpathValidationAttemps = "//table/tbody/tr[" + (i + 1) + "]/td[4]";
			WebElement user = CommonUtility.cFindElement(driver, By.xpath(xpathUSER), 5);
			WebElement encOTP = CommonUtility.cFindElement(driver, By.xpath(xpathENCOTP), 5);
			WebElement validatedAttempts = CommonUtility.cFindElement(driver, By.xpath(xpathValidationAttemps), 5);
			if (user.getText().contains(
					loginDetails.get("corpid").toUpperCase() + "." + loginDetails.get("username").toUpperCase())
					&& validatedAttempts.getText().contains("0")) {
				OTP = encOTP.getText();
				return OTP;
			}
		}
		return OTP;
	}

	/* Method to Enter OTP */
	public void enterOTP(String OTPString) throws customElementNotFoundException, customElementNotClickableException {
		char[] otpValues = OTPString.toCharArray();

		for (int i = 0; i < otpValues.length; i++) {
			WebElement otpElement = CommonUtility.cFindElement(driver,
					By.xpath("//input[contains(@aria-label,'Digit " + (i + 1) + "')]"), 20);
			CommonUtility.cSendKeys(driver, otpElement, Character.toString(otpValues[i]));
		}
	}

	/***
	 * Method to Click on OTP Submit button
	 * 
	 * @throws Exception
	 * 
	 * @throws customElementFoundException
	 ***/
	public void clickOTPSubmitBtn() throws Exception {
		CommonUtility.cClick(driver, btnOTPSubmit);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 40);
	}

	/** This method is used to verify the redirection of service overview screen **/

	public void verifyServiceScreen() throws Exception {
		boolean serviceScreenFlag = CommonUtility.cVerifyElementIsPresent(driver, serviceOverviewLbl, 40);
		Validator.assertTrue(serviceScreenFlag, "[Failed! The Service Overview screen is not reached by the system]",
				"Verified that system was redirected to Service Overview screen");
	}

	/**
	 * This method is used to verify the redirection of Payments overview screen
	 **/

	public void verifyPaymentscreen() throws Exception {
		boolean paymentScreenFlag = CommonUtility.cVerifyElementIsPresent(driver, paymentsOverviewLbl, 40);
		Validator.assertTrue(paymentScreenFlag, "[Failed! The Payments Overview screen is not reached by the system]",
				"Verified that system was redirected to Payments Overview screen");
	}

	/**
	 * This method is used to verify the redirection of Dashboard screen
	 **/

	public void verifyDashboardscreen() throws Exception {
		boolean dashboardScreenFlag = CommonUtility.cVerifyElementIsPresent(driver, dashboardMenu, 20);
		Validator.assertTrue(dashboardScreenFlag, "[Failed! The Dashboard screen is not reached by the system]",
				"Verified that system was redirected to Dashboard screen");
	}

	/**
	 * This method is used to verify the login screen
	 **/

	public void verifyLoginscreen() throws Exception {
		boolean loginScreenFlag = CommonUtility.cVerifyElementIsPresent(driver, corpID, 20);
		Validator.assertTrue(loginScreenFlag, "[Failed! The Login screen is not reached by the system]",
				"Verified that system logged out and redirected to login screen");
	}

	/**
	 * This method is used to Navigate to specific module in DEH application
	 *
	 * @param menu
	 */
	public void navigationMenu(Map<String, String> loginDetails, WebElement menu) throws Exception {
		if (loginDetails.get("Path").equalsIgnoreCase("Service")) {
			CommonUtility.cClick(driver, menu);
			CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 60);
		} else if (loginDetails.get("Path").equalsIgnoreCase("Payments")) {
			CommonUtility.cClick(driver, menu);
			CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 60);
		} else if (loginDetails.get("Path").equalsIgnoreCase("Dashboard")) {
			CommonUtility.cClick(driver, menu);
			CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 60);
		} else if (loginDetails.get("Path").equalsIgnoreCase("Drafts")) {
			CommonUtility.cClick(driver, menu);
			CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 60);
		} else if (loginDetails.get("Path").equalsIgnoreCase("Reports")) {
			CommonUtility.cClick(driver, menu);
			CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 60);
		} else if (loginDetails.get("Path").equalsIgnoreCase("Treasury")) {
			CommonUtility.cClick(driver, menu);
			CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 60);
		} else if (loginDetails.get("Path").equalsIgnoreCase("Commercial Cards")) {
			CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, menu);
			CommonUtility.cClick(driver, menu);
			CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 60);
		}
	}

	/*** Click on redirection menu drop down ***/
	public void clickRedirectionDropdown() throws Exception {
		CommonUtility.cClick(driver, redirectionDropdown);
	}

	/*** Selecting Payments menu from login page for redirection ***/
	public void selectPaymentMenu(Map<String, String> loginDetails) throws Exception {
		CommonUtility.cClick(driver, redirectionDropdown);
		CommonUtility.cClick(driver, redirectToPayment);
	}

	/*** Selecting Service menu from login page for redirection ***/
	public void selectServiceMenu(Map<String, String> loginDetails) throws Exception {
		CommonUtility.cClick(driver, redirectionDropdown);
		CommonUtility.cClick(driver, redirectToService);
	}

	public void clickOnForgotCorpID() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, forgotCorpID);
	}

	public void clickOnForgotUserID() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, forgotUserID);
	}

	public void clickOnForgotPassword() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, forgotPassword);
	}

	public void clickOnActivateAccount() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, activateAccount);
	}

	public void enterForgotPasswordDetails(List<Map<String, String>> forgotPasswordDetails)
			throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cSendKeys(driver, corpID, forgotPasswordDetails.get(0).get("CorpID").toUpperCase());
		CommonUtility.cSendKeys(driver, loginID, forgotPasswordDetails.get(0).get("Username").toUpperCase());
		CommonUtility.cSendKeys(driver, phoneNumber, forgotPasswordDetails.get(0).get("PhoneNumber").toUpperCase());
		CommonUtility.cSendKeys(driver, email, forgotPasswordDetails.get(0).get("Email").toUpperCase());
	}

	public void enterDetailsOfForgotCorpIDorUserID(List<Map<String, String>> resetPassword)
			throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cSendKeys(driver, email, resetPassword.get(0).get("EmailID"));
		CommonUtility.cSendKeys(driver, contactNumber, resetPassword.get(0).get("ContactNumber"));
	}

	public void enterActivateAccountDetails(List<Map<String, String>> accountDetails)
			throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cSendKeys(driver, corpID, accountDetails.get(0).get("CorpID").toUpperCase());
		CommonUtility.cSendKeys(driver, loginID, accountDetails.get(0).get("Username").toUpperCase());
		CommonUtility.cSendKeys(driver, phoneNumber, accountDetails.get(0).get("PhoneNumber").toUpperCase());
		CommonUtility.cSendKeys(driver, email, accountDetails.get(0).get("Email").toUpperCase());
	}

	public void verifyInvalidCredentialsErrorMsg() {
		String actualErrorMsg = errorMsg.getText();
		String expectedErrorMsg = "Invalid Credentials entered. To login again, Kindly Click here";
		boolean errorMsgFlag = false;
		if (actualErrorMsg.equalsIgnoreCase(expectedErrorMsg)) {
			errorMsgFlag = true;
			Validator.assertTrue(errorMsgFlag, "Failed! Expected : " + expectedErrorMsg + ", Actual: " + actualErrorMsg,
					"[" + expectedErrorMsg + "- error message has displayed as expected]");
		} else {
			Validator.assertTrue(errorMsgFlag, "Failed! Expected : " + expectedErrorMsg + ", Actual: " + actualErrorMsg,
					"[" + expectedErrorMsg + "- error message has displayed as expected]");
		}
	}

	public void verifyPasswordExpiredErrorMsg() {
		String actualErrorMsg = errorMsg.getText();
		String expectedErrorMsg = "Your password has expired. To reset password, Click here";
		boolean errorMsgFlag = false;
		if (actualErrorMsg.equalsIgnoreCase(expectedErrorMsg)) {
			errorMsgFlag = true;
			Validator.assertTrue(errorMsgFlag, "Failed! Expected : " + expectedErrorMsg + ", Actual: " + actualErrorMsg,
					"[" + expectedErrorMsg + "- error message has displayed as expected]");
		} else {
			Validator.assertTrue(errorMsgFlag, "Failed! Expected : " + expectedErrorMsg + ", Actual: " + actualErrorMsg,
					"[" + expectedErrorMsg + "- error message has displayed as expected]");
		}
	}

	public void clickOnProfileManu() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, profileMenu);
	}

	public void clickOnLogOut() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, logOut);
	}

	public void enterDetailsForPasswordReset(Map<String, String> resetPassword)
			throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cSendKeys(driver, oldPassword, resetPassword.get("OldPassword"));
		CommonUtility.cSendKeys(driver, newPassword, resetPassword.get("NewPassword"));
		CommonUtility.cSendKeys(driver, confirmNewPassword, resetPassword.get("NewPassword"));
	}

	public void clickOnFormsAndDownloadLink()
			throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, formsAndDownloadLink);
		CommonUtility.cWaitForPageLoad(driver);
	}

	public void clickOnTermsAndConditionsLink()
			throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, termsAndConditionsLink);
		CommonUtility.cWaitForPageLoad(driver);
	}

	public void clickOnATMBranchLocatorLink()
			throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, atmBranchLocatorLink);
		CommonUtility.cWaitForPageLoad(driver);
	}

	public void clickOnFAQLink() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, faqLink);
		CommonUtility.cWaitForPageLoad(driver);
	}

	public void clickOnOnlineSecurityLink() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, onlineSecurityLink);
		CommonUtility.cWaitForPageLoad(driver);
	}

	public void clickOnPrivacyPolicyLink() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, privacyPolicyLink);
		CommonUtility.cWaitForPageLoad(driver);
	}

	public void clickOnAPIPortalLink() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, apiPortalLink);
		CommonUtility.cWaitForPageLoad(driver);
	}

	public void clickOnCustomerCareLink() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, customerCareLink);
		CommonUtility.cWaitForPageLoad(driver);
	}

	public void verifyCustomerCarePopUp() throws Exception {
		boolean customerCareFlag = CommonUtility.cVerifyElementIsPresent(driver, customerCarePopUp, 20);
		Validator.assertTrue(customerCareFlag, "[Failed! Unable to see the Customer Care pop up]",
				"Verified Customer Care pop up");
	}

	public void verifyFormsAndDownloadUrl()
			throws customElementNotClickableException, customElementNotFoundException, Exception {
		boolean formsFlag = false;
		ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
		for (String window : allTabs) {
			driver.switchTo().window(window);
			if (driver.getCurrentUrl().contains("corporate-internet-banking/downloads")) {
				formsFlag = true;
				break;
			}
		}
		Validator.assertTrue(formsFlag, "[Failed! System was not redirected to Forms & Downloads site]",
				"System was successfully redirected to Forms & Download page");
	}

	public void verifyTermsAndConditionsUrl()
			throws customElementNotClickableException, customElementNotFoundException, Exception {
		boolean termsFlag = false;
		ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
		for (String window : allTabs) {
			driver.switchTo().window(window);
			if (driver.getCurrentUrl().contains("internet-banking-t-c#menuTab")) {
				termsFlag = true;
				break;
			}
		}
		Validator.assertTrue(termsFlag, "[Failed! System was not redirected to Terms & Conditions site]",
				"System was successfully redirected to Terms & Conditions site");
	}

	public void verifyATMBranchLocatorUrl()
			throws customElementNotClickableException, customElementNotFoundException, Exception {
		boolean atmBranchFlag = false;
		ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
		for (String window : allTabs) {
			driver.switchTo().window(window);
			if (driver.getCurrentUrl().contains("type=branches")) {
				atmBranchFlag = true;
				break;
			}
		}
		Validator.assertTrue(atmBranchFlag, "[Failed! System was not redirected to ATM/Branch Locator site]",
				"System was successfully redirected to ATM/Branch Locator site");
	}

	public void verifyFAQUrl() throws customElementNotClickableException, customElementNotFoundException, Exception {
		boolean faqFlag = false;
		ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
		for (String window : allTabs) {
			driver.switchTo().window(window);
			if (driver.getCurrentUrl().contains("internet-banking-faqs#menuTab")) {
				faqFlag = true;
				break;
			}
		}
		Validator.assertTrue(faqFlag, "[Failed! System was not redirected to FAQ's site]",
				"System was successfully redirected to FAQ's site");
	}

	public void verifyOnlineSecurityUrl()
			throws customElementNotClickableException, customElementNotFoundException, Exception {
		boolean securityFlag = false;
		ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
		for (String window : allTabs) {
			driver.switchTo().window(window);
			if (driver.getCurrentUrl().contains("bank-smart/safe-banking")) {
				securityFlag = true;
				break;
			}
		}
		Validator.assertTrue(securityFlag, "[Failed! System was not redirected to Online Security site]",
				"System was successfully redirected to Online Security site");
	}

	public void verifyPrivacyPolicyUrl()
			throws customElementNotClickableException, customElementNotFoundException, Exception {
		boolean policyFlag = false;
		ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
		for (String window : allTabs) {
			driver.switchTo().window(window);
			if (driver.getCurrentUrl().contains("privacy-policy")) {
				policyFlag = true;
				break;
			}
		}
		Validator.assertTrue(policyFlag, "[Failed! System was not redirected to privacy policy site]",
				"System was successfully redirected to privacy policy site");
	}

	public void verifyAPIPortalUrl()
			throws customElementNotClickableException, customElementNotFoundException, Exception {
		boolean apiPortalFlag = false;
		ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
		for (String window : allTabs) {
			driver.switchTo().window(window);
			if (driver.getCurrentUrl().contains("apiportal.axisbank.com")) {
				apiPortalFlag = true;
				break;
			}
		}
		Validator.assertTrue(apiPortalFlag, "[Failed! System was not redirected to API Portal site]",
				"System was successfully redirected to API Portal site");
	}

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {

	}

}
