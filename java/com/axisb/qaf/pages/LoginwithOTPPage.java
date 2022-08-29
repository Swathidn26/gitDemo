package com.axisb.qaf.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.utils.CommonUtility;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class LoginwithOTPPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	JavascriptExecutor js=(JavascriptExecutor)driver;
	int loginRetry=0;
	int maxLoginRetries=2;
	int otpExpired=0;

	//Login Page - IDP
	@FindBy(locator = "xpath=//*[@id='custid']")
	private QAFWebElement corpid;

	@FindBy(locator = "xpath=//input[@id='usrname']")
	private QAFWebElement corpuname;

	@FindBy(locator = "xpath=//input[@id='usrpwd']")
	private QAFWebElement corpPasswrd;

	@FindBy(locator = "xpath=//button[@id='loginBtn']")
	private QAFWebElement btnlogin;

	@FindBy(locator = "xpath=//button[@id='loginBlk']")
	private QAFWebElement btnloginBlocked;

	@FindBy(locator = "xpath=//*[@id='loginErr']")
	private QAFWebElement errLogin;

	//Confirm OTP Screen
	@FindBy(locator = "xpath=//button[@id='confirmOtp']")
	private QAFWebElement btnOTPConfirm;

	@FindBy(locator = "xpath=//button[contains(text(), 'CONTINUE')]")
	private QAFWebElement btnOTPContinue;
	
	@FindBy(locator = "xpath=//button[text()='OK']")
	private QAFWebElement btnOTPExpired;
	
	@FindBy(locator = "xpath=//button[contains(text(),'CANCEL')]")
	private QAFWebElement btnOTPCancel;
	
	@FindBy(locator = "xpath=//*[contains(text(),'YES')]")
	private QAFWebElement btnOTPCancelYes;
	
	//AxisIDP OTP Fetch Page
	@FindBy(locator = "xpath=//*[@name='uname']")
	private QAFWebElement otpUsername;

	@FindBy(locator = "xpath=//*[@name='psw']")
	private QAFWebElement otpPass;

	@FindBy(locator = "xpath=//*[@type='submit']")
	private QAFWebElement btnOTPSubmit;

	@FindBy(locator = "xpath=//a[text()='OTP']")
	private QAFWebElement linkOTP;

	@FindBy(locator = "xpath=//*[@id='otp']/table")
	private QAFWebElement tableOTP;

	@FindBy(locator = "xpath=//span[text()='Payments']")
	private QAFWebElement paymentslink;

	@FindBy(locator = "xpath=//*[contains(text(), 'GST Payments')]")
	private QAFWebElement gstPaymentsLinkIDP;

	@FindBy(locator = "xpath=(//span[contains(text(), 'Single Payments')])[2]")
	private QAFWebElement singlePaymentsLinkIDP;
	
	@FindBy(locator = "xpath=//h3[text()='Transfer Funds']")
	private QAFWebElement transferfundsLinkIDP;

	@FindBy(locator = "xpath=//a[contains(text(), 'Logout')]")
	private QAFWebElement otpLogout;

	@FindBy(locator = "xpath=//span[contains(text(),'Service Requests')]/parent::a")
	private QAFWebElement serviceRequestLinkIDP;


	@FindBy(locator = "xpath=//*[contains(text(),'Update GSTN')]")
	private QAFWebElement updateGSTNLinkIDP;
	
	@FindBy(locator = "xpath=//*[contains(text(), 'TOD/Intraday')]")
	private QAFWebElement todIntradayLinkIDP;

	@FindBy(locator = "xpath=//*[text()='Commercial Cards']")
	private QAFWebElement commercialCardLinkIDP;
	
	@FindBy(locator = "xpath=//*[text()='Positive Pay']")
	private QAFWebElement positivePayLinkIDP;
	
	@FindBy(locator = "xpath=//*[text()='Forex']")
	private QAFWebElement forexLinkIDP;
	
	@FindBy(locator = "xpath=//*[text()='FX Overview']")
	private QAFWebElement forexOverviewLinkIDP;
	
	@FindBy(locator = "xpath=(//*[text()='View More'])[2]")
	private QAFWebElement otherViewMoreLinkIDP;
		
	public QAFWebElement getTodIntradayLinkIDP() {
		return todIntradayLinkIDP;
	}
	public QAFWebElement getCommercialCardLinkIDP() {
		return commercialCardLinkIDP;
	}
	public QAFWebElement getServiceRequestLinkIDP() throws Exception {
		return serviceRequestLinkIDP;
	}
	public QAFWebElement getForexLinkIDP() {
		return forexLinkIDP;
	}

	/**
	 * To use in Login Page to Navigate to GST Payments or Single Payments Link
	 */
	public QAFWebElement getGstPaymentsLinkIDP() {
		return gstPaymentsLinkIDP;
	}
	public QAFWebElement getSinglePaymentsLinkIDP() {
		return singlePaymentsLinkIDP;
	}

	//	AXIS BANK LOGIN
	public void enterLogincred(Map<String, String> loginDetails) throws Exception {
		CommonUtility.cWaitForPageLoad(driver);
		js.executeScript("arguments[0].focus();", corpid);
		CommonUtility.cSendKeys(driver, corpid, loginDetails.get("corpid").toUpperCase());
		CommonUtility.cSendKeys(driver, corpuname, loginDetails.get("username").toUpperCase());
		CommonUtility.cSendKeys(driver, corpPasswrd, CommonUtility.cDecryptPassword(CommonUtility.property.getProperty("encrypt.key"), CommonUtility.property.getProperty(loginDetails.get("corpid").toUpperCase()+"."+loginDetails.get("username").toUpperCase())));
	}

	public void clickLoginBtn() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, btnlogin);;
	}
	//	OTP CONFIRMATION SCREEN
	/**
	 * Method to Enter OTP
	 */
	public void enterOTP(String OTPString) throws customElementNotFoundException, customElementNotClickableException {
		char[] otpValues=OTPString.toCharArray();

		for (int i=0; i< otpValues.length;i++) {
			//OTP Enter
			WebElement otpElement=CommonUtility.cFindElement(driver, By.xpath("//input[@type='tel']["+(i+1)+"]"), 20);
			CommonUtility.cSendKeys(driver, otpElement, Character.toString(otpValues[i]));
		}
	}
	/**
	 * Method to Click on Confirm OTP
	 */
	public void clickOTPConfirm() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, btnOTPConfirm);;
	}

	//	OTP FETCH SCREEN
	/**
	 * Method to Fetch OTP from fileUpload/OTP Portal
	 */
	public String getOTP(Map<String, String> loginDetails) throws Exception {
		String currentWindow = driver.getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		for (String window : tabs) {
			driver.switchTo().window(window);
			if(driver.getCurrentUrl().contains("FileUpload")) {
				driver.navigate().refresh();
				CommonUtility.cWaitForPageLoad(driver);
				break;
			}
		}

		if(CommonUtility.cVerifyElementIsPresent(driver, otpUsername, 5)) {
			enterOTPFetchCred();
			clickOTPSubmit();
		}
		else {
			driver.navigate().refresh();
			CommonUtility.cWaitForPageLoad(driver);
			goToOTPLink();
		}

		goToOTPLink();
		String otp= fetchOTP(loginDetails);
		CommonUtility.cClick(driver, otpLogout);
		driver.switchTo().window(currentWindow);

		return otp;

	}

	/**
	 * Method to Enter credential for OTP Portal
	 * @throws Exception 
	 */
	public void enterOTPFetchCred() throws Exception {
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, otpUsername);
		CommonUtility.cSendKeys(driver, otpUsername, CommonUtility.property.getProperty("idpUser"));
		CommonUtility.cSendKeys(driver, otpPass,  CommonUtility.cDecryptPassword(CommonUtility.property.getProperty("encrypt.key"),CommonUtility.property.getProperty("idpPass")));
	}
	/**
	 * Method to Click OTP Login Button
	 */
	public void clickOTPSubmit() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, btnOTPSubmit);;
	}

	/**
	 * Method to Navigate to OTP Portal
	 */
	public void goToOTPLink() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cWaitForPageLoad(driver);
		CommonUtility.cClick(driver, linkOTP);
		CommonUtility.cExplicitlyWait(driver, tableOTP, 0);
	}

	/**
	 * Method to Fetch OTP from OTP Portal
	 */
	public String fetchOTP(Map<String, String> loginDetails) throws customElementNotClickableException, customElementNotFoundException {
		driver.get(driver.getCurrentUrl());
		CommonUtility.cWaitForPageLoad(driver);
		List<WebElement> otpTable = CommonUtility.cFindElements(driver, By.xpath("//*[@id='otp']/table/tbody/tr"), 10);
		String OTP="";

		for(int i=0; i<otpTable.size();i++) {
			String xpathCORPID="//*[@id='otp']/table/tbody/tr["+(i+1)+"]/th[1]";
			String xpathUSERID="//*[@id='otp']/table/tbody/tr["+(i+1)+"]/th[2]";
			String xpathOTAC="//*[@id='otp']/table/tbody/tr["+(i+1)+"]/th[3]";
			String xpathIsValidated="//*[@id='otp']/table/tbody/tr["+(i+1)+"]/th[4]";

			WebElement isValidated = CommonUtility.cFindElement(driver, By.xpath(xpathIsValidated), 5);
			WebElement userID = CommonUtility.cFindElement(driver, By.xpath(xpathUSERID), 5);
			WebElement eleOTP = CommonUtility.cFindElement(driver, By.xpath(xpathOTAC), 5);
			WebElement corpID = CommonUtility.cFindElement(driver, By.xpath(xpathCORPID), 5);

			if(isValidated.getText().contains("N") 
					&& userID.getText().contains(loginDetails.get("username").toUpperCase())
					&& corpID.getText().contains(loginDetails.get("corpid").toUpperCase()) ){
				OTP=eleOTP.getText();
				Validator.assertFalse(OTP.equals(""), "OTP Couldn't be fetched! Please re run the script", "OTP to be entered-"+OTP);
				return OTP;
			}
		}
		if(OTP.equals("") && loginRetry<=maxLoginRetries) {
			try {
				loginRetry++;
				CommonUtility.cClick(driver, otpLogout);
				getOTP(loginDetails);
				OTP= fetchOTP(loginDetails);
			}catch(Exception e) {
				Validator.assertTrue(false, "Login Page Timed Out!", "Successfully Logging");
			}
		}
		Validator.assertFalse(OTP.equals("")&&loginRetry>maxLoginRetries, "OTP Couldn't be fetched! Please re run the script", "OTP to be entered-"+OTP);
		return OTP;
	}

	//	OPEN IDP and OTP SCREEN
	/**
	 * Method to Open Base URL and OTP Portal
	 */
	public void openBasewithOTPURL() throws IOException {
		CommonUtility.cLoadProperties(System.getProperty("user.dir")+"/resources/application.properties");
		driver.get(CommonUtility.property.getProperty("env.baseurlUAT"));
		String currentWindow=driver.getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		for (String window : tabs) {
			driver.switchTo().window(window);
			if(!window.equals(currentWindow)) {
				driver.close();
			}
		}
		driver.switchTo().window(currentWindow);
		String openString="window.open('"+CommonUtility.property.getProperty("env.otpurl")+"', '_blank');";
		js.executeScript(openString);
		driver.switchTo().window(currentWindow);
		driver.manage().window().maximize();

	}

	/**
	 * This method is used to Login from IDP and Navigate to CDP according to the Payment Type.
	 * 
	 * Where, "loginDetails"- Fetched from Feature in {corpid:"value", corpUsername:"value"} format
	 *  and "paymentTypeLinkIDP"- WebElement to Click on the appropriate Payment Type such as GST PAYMENT or SINGLE PAYMENT CDP.
	 *  
	 * #Note, For paymentTypeLinkIDP, Use getGstPaymentsLinkIDP() and getSinglePaymentsLinkIDP() method already present in LoginwithOTPPage 
	 * 
	 * 
	 * @param loginDetails- Fetched from Feature File in {corpid:"value", corpUsername:"value"} format
	 * @param paymentTypeLinkIDP- WebElement to Click on the appropriate Payment Type such as GST PAYMENT or SINGLE PAYMENT CDP.
	 */
	public void openUrl(Map<String, String> loginDetails, WebElement paymentTypeLinkIDP) throws Exception {
		try {
			openBasewithOTPURL();
		} catch (Exception e) {
			Validator.assertTrue(false, "Unable to open the URL! Check the screenshots for more Info", "");
		}
		try {
			enterLogincred(loginDetails);
		} catch (Exception e) {
			Validator.assertTrue(false, "Unable to enter Credentials! Check the screenshots for more Info", "");
		}
		try {	
			clickLoginBtn();
		} catch (Exception e) {
			Validator.assertTrue(false, "Unable to click on the Login Button! Check the screenshots for more Info", "");
		}
		try {
			handleActiveSession(loginDetails);
		} catch (Exception e) {
			Validator.assertTrue(false, "Login Failed! Check the screenshots for more Info", "");
		}
		try {
			enterOTP(getOTP(loginDetails));
		} catch (Exception e) {
			Validator.assertTrue(false, "Unable to enter OTP! Check the screenshots for more Info", "");
		}
		try {
			clickOTPConfirm();
		} catch (Exception e) {
			Validator.assertTrue(false, "Unable to Log in using the OTP ! Check the screenshots for more Info", "");
		}
		try {
			verifyIfOTPExpired(loginDetails, paymentTypeLinkIDP);
		} catch (Exception e) {
			Validator.assertTrue(false, "Unable to Proceed as OTP Expired! Check the screenshots for more Info", "");
		}
		
		try {
			loadAPI();
		} catch (Exception e) {
			Validator.assertTrue(false, "Unable to Load the API Gateway! Check the screenshots for more Info", "");
		}
		try {
			verifyLogin();
		} catch (Exception e) {
			Validator.assertTrue(false, "Unable to Login to IDP Page! Check the screenshots for more Info", "");
		}
		try {
			GoToCDPPage(loginDetails, paymentTypeLinkIDP);
		} catch (Exception e) {
			Validator.assertTrue(false, "Unable to Login to CDP! Check the screenshots for more Info", "");
		}
	}
	
	public void verifyIfOTPExpired(Map<String, String> loginDetails, WebElement paymentTypeLinkIDP) throws Exception {
		Boolean isOTPExpired=CommonUtility.cVerifyElementIsPresent(driver, btnOTPExpired, 5);
		if(isOTPExpired) {
			otpExpired++;
			if(otpExpired>2) {
				Validator.assertTrue(false, "Maximum Logon Attempts exceeded as OTP expired Twice!! Please relaunch the Test", "");
			}
			CommonUtility.cClick(driver, btnOTPExpired);
			CommonUtility.cClick(driver, btnOTPCancel);
			CommonUtility.cClick(driver, btnOTPCancelYes);
			openUrl(loginDetails, paymentTypeLinkIDP);
		}
		
	}
	
	/**
	 * Method to Verify if Successfully Logged in to IDP Portal
	 */
	public void verifyLogin() {
		CommonUtility.cWaitForPageLoad(driver);
		Validator.assertTrue(paymentslink.isDisplayed(), "Login Failed! Check screenshot for more info", "Successfully Logged in to IDP Screen!!");
	}
	/**
	 * Method to CDP load API
	 */
	public void loadAPI() throws Exception {
		String openString="window.open('"+CommonUtility.property.getProperty("env.apiurl")+"', '_blank');";
		js.executeScript(openString);
		String openpreprodString="window.open('"+CommonUtility.property.getProperty("env.preprodapiurl")+"', '_blank');";
		js.executeScript(openpreprodString);
		String currentWindow = driver.getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		for (String window : tabs) {
			driver.switchTo().window(window);
			if(driver.getCurrentUrl().contains("uat/cdp/api/v1")) {
				CommonUtility.cWaitForPageLoad(driver);
				driver.get(CommonUtility.property.getProperty("env.apiurl"));
				CommonUtility.cWaitForPageLoad(driver);
				Thread.sleep(5000);
			}
			if(driver.getCurrentUrl().contains("dmz/cdp/api/v1")) {
				CommonUtility.cWaitForPageLoad(driver);
				driver.get(CommonUtility.property.getProperty("env.preprodapiurl"));
				CommonUtility.cWaitForPageLoad(driver);
				Thread.sleep(5000);
			}
		}
		driver.switchTo().window(currentWindow);

	}

	/**
	 * Method to Handle Active Session Login
	 * @throws Exception 
	 */
	public void handleActiveSession(Map<String, String> loginDetails) throws Exception {
		try {
			CommonUtility.cExplicitlyWait(driver, btnOTPConfirm, 10);
		}catch(Exception ex) {
			try {
				Thread.sleep(1000);
				if(CommonUtility.cVerifyElementIsPresent(driver, btnloginBlocked, 5)   || CommonUtility.cVerifyElementIsPresent(driver, btnOTPContinue, 10)) {
					Validator.assertTrue(true, "", "Login Blocked or a Session already exist!! Retrying");
					if(CommonUtility.cVerifyElementIsPresent(driver,btnloginBlocked,5)) {
						CommonUtility.cClick(driver, btnloginBlocked);
						enterLogincred(loginDetails);
						clickLoginBtn();
					}
					CommonUtility.cClick(driver, btnOTPContinue);
					CommonUtility.cExplicitlyWait(driver, btnOTPConfirm, 10);
				}

			}catch(Exception e) {
				Validator.assertTrue(false, "Login Page Timed Out! Try after sometime", "");
			}

			boolean loginCredsError=CommonUtility.cVerifyElementIsPresent(driver,errLogin, 5);
			Validator.assertFalse(loginCredsError, "Incorrect User Credentials!! Please update and rerun", "Correct Credentials entered for IDP. Entering OTP in the next Page");

		}
	}

	/**
	 * This method is used to Navigate from IDP from CDP using the 
	 *
	 * @param paymentTypeLinkIDP
	 */
	public void GoToCDPPage(Map<String, String> loginDetails, WebElement paymentTypeLinkIDP) throws Exception {
		if(loginDetails.get("Path").equalsIgnoreCase("Service Request")) {
			CommonUtility.cClick(driver, paymentTypeLinkIDP);
			if(!CommonUtility.cVerifyElementIsPresent(driver, updateGSTNLinkIDP, 5)) {
				CommonUtility.cClick(driver, paymentTypeLinkIDP);
			}
			CommonUtility.cClick(driver, updateGSTNLinkIDP);

		}else if(loginDetails.get("Path").equalsIgnoreCase("TOD")) {
			CommonUtility.cClick(driver,getServiceRequestLinkIDP());
			if(!CommonUtility.cVerifyElementIsPresent(driver, otherViewMoreLinkIDP, 5)) {
				CommonUtility.cClick(driver, getServiceRequestLinkIDP());
			}
			try {
				CommonUtility.cClick(driver,otherViewMoreLinkIDP);
			}catch(Exception e) {}
			if(!CommonUtility.cVerifyElementIsPresent(driver, paymentTypeLinkIDP, 5)) {
				try {
					CommonUtility.cClick(driver,otherViewMoreLinkIDP);
				}catch(Exception e) {}
			}
			CommonUtility.cClick(driver, paymentTypeLinkIDP);
			
		}else if(loginDetails.get("Path").equalsIgnoreCase("Commercial Cards")) {
			CommonUtility.cClick(driver, paymentTypeLinkIDP);
		}else if(loginDetails.get("Path").equalsIgnoreCase("Treasury")) {
			CommonUtility.cClick(driver, paymentTypeLinkIDP);
			if(!CommonUtility.cVerifyElementIsPresent(driver, forexOverviewLinkIDP, 5)) {
				CommonUtility.cClick(driver, paymentTypeLinkIDP);
			}
			CommonUtility.cClick(driver,forexOverviewLinkIDP);
		}else if (loginDetails.get("Path").equalsIgnoreCase("Single Payment")) {
			CommonUtility.cClick(driver, paymentslink);
			CommonUtility.cClick(driver, paymentTypeLinkIDP);
			try {
			CommonUtility.cClick(driver, transferfundsLinkIDP);
			}catch(Exception e)
			{
				
			}
		}
		else {
			CommonUtility.cClick(driver, paymentslink);
			if(!CommonUtility.cVerifyElementIsPresent(driver, paymentTypeLinkIDP, 5)) {
				CommonUtility.cClick(driver, paymentslink);
			}
			CommonUtility.cClick(driver, paymentTypeLinkIDP);
		}
		Thread.sleep(2000);
		verifyUserOnCDPPage();

	}

	/**
	 * Method to Verify if Successfully Logged in to CDP Portal
	 */
	public void verifyUserOnCDPPage() throws Exception {
		int count=0;
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		while(tabs.size()<=2) {
			tabs = new ArrayList<String>(driver.getWindowHandles());
		}
		for (String otpwindow : tabs) {
			driver.switchTo().window(otpwindow);
			if(driver.getCurrentUrl().contains("FileUpload")) {
				driver.close();
			}
		}
		tabs = new ArrayList<String>(driver.getWindowHandles());
		for (String window : tabs) {
			count=count+1;
			driver.switchTo().window(window);
			CommonUtility.cWaitForPageLoad(driver);
			if(driver.getCurrentUrl().contains("digicorp") || driver.getCurrentUrl().contains("/sso")|| driver.getCurrentUrl().contains("gtb")) {
				CommonUtility.cExplicitlyWaitForAbsence(driver, By.xpath("//*[contains(@class,'bouncing-loader_bouncingLoader_')]"), 60);
				break;
			}
		}
		Thread.sleep(1000);
		Boolean switchToWindow=false;
		int retryCount=0;
		//To Handle Intermittent Switch Issue
		while(switchToWindow==false && retryCount<=10) {
			if(!driver.getCurrentUrl().contains("digicorp")|| !driver.getCurrentUrl().contains("gtb")) {
				Thread.sleep(1000);
				tabs = new ArrayList<String>(driver.getWindowHandles());
				for (String window : tabs) {
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains("digicorp")|| driver.getCurrentUrl().contains("gtb")) {
						CommonUtility.cExplicitlyWaitForAbsence(driver, By.xpath("//*[contains(@class,'bouncing-loader_bouncingLoader_')]"), 60);
						switchToWindow=true;
						break;
					}
				}
			}else{
				switchToWindow=true;
			}
			retryCount++;
		}
		if(switchToWindow==false && retryCount>10){
			Validator.assertFalse(true, "Couldn't Load the CDP Page. Login Failure. Check Screenshot for more Info", "Page Successfully Loaded. Url- "+driver.getCurrentUrl());
		}
		boolean forbiddenPageFlag=false;
		if(CommonUtility.cPageContainsText(driver, "Forbidden") || driver.getCurrentUrl().toUpperCase().contains("FORBIDDEN")) {
			forbiddenPageFlag=true;
		}
		Validator.assertFalse(forbiddenPageFlag, "Couldn't load the Page!! 403 Forbidden error. Url-"+driver.getCurrentUrl(), "Page Successfully Loaded. Url- "+driver.getCurrentUrl());

	}

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {

	}


}