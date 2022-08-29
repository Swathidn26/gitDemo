package com.axisb.qaf.pages;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;

import com.axisb.qaf.utils.CommonUtility;
import com.axisb.qaf.utils.LoginSSOkeys;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class LoginPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	
	@FindBy(locator = "xpath=//input[@id='corpid']")
	private QAFWebElement corpid;

	@FindBy(locator = "xpath=//input[@id='userId']")
	private QAFWebElement corpuname;

	@FindBy(locator = "xpath=//button[@class='login_Loginbutton__28Ifz']")
	private QAFWebElement btnlogin;
	
	JavascriptExecutor js=(JavascriptExecutor)driver;

	public void enterLogincred(List<Map<String, String>> loginDetails) {
		corpid.sendKeys(loginDetails.get(0).get("corpid"));
		corpuname.sendKeys(loginDetails.get(0).get("corpuname"));
	}

	public void loginBtn() {
		btnlogin.click();
	}

	public void loginUsingSSO(Map<String, String> dataTable) {
		switch (dataTable.get("username")) {
		case "Approver":
			driver.get(LoginSSOkeys.appUrl+LoginSSOkeys.approver);
			break;
		case "Approver1":
			driver.get(LoginSSOkeys.appUrl+LoginSSOkeys.approver1);
			break;
		case "Pradeep":
			driver.get(LoginSSOkeys.appUrl+LoginSSOkeys.pradeep);
		case "Enterer":
			driver.get(LoginSSOkeys.appUrl+LoginSSOkeys.enterer);
			break;
		case "Maker3":
			driver.get(LoginSSOkeys.appUrl+LoginSSOkeys.maker3);
			break;
		case "EntererDp2":
			driver.get(LoginSSOkeys.appUrl+LoginSSOkeys.entererdp2);
			break;
		case "DP2Approver":
		    driver.get(LoginSSOkeys.appUrl+LoginSSOkeys.approverdp2);
		    break;
		case "TODCorpMaker1":
			driver.get(LoginSSOkeys.appUrl+LoginSSOkeys.todcorpm1);
			break;
		case "TODCorpMaker2":
			driver.get(LoginSSOkeys.appUrl+LoginSSOkeys.todcorpm2);
			break;
		case "TODCorpChecker1":
			driver.get(LoginSSOkeys.appUrl+LoginSSOkeys.todcorpc1);
			break;
		case "TODCorpChecker2":
			driver.get(LoginSSOkeys.appUrl+LoginSSOkeys.todcorpc2);
			break;
		default:
			break;
		}
	}
	
	public void loadAPI(Map<String, String> loginDetails) throws Exception {
		CommonUtility.cLoadProperties(System.getProperty("user.dir")+"/resources/application.properties");
		if(loginDetails.get("Environment").equals("QA")||loginDetails.get("Environment").equals("DEHQA")) {
			String openString="window.open('"+CommonUtility.property.getProperty("env.baseurlQA")+"', '_blank');";
			js.executeScript(openString);
			String currentWindow = driver.getWindowHandle();
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			for (String window : tabs) {
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("qacdsrvcs")) {
					CommonUtility.cWaitForPageLoad(driver);
					driver.get(CommonUtility.property.getProperty("env.baseurlQA"));
					CommonUtility.cWaitForPageLoad(driver);
					Thread.sleep(2000);
				}
			}
			driver.switchTo().window(currentWindow);
			CommonUtility.cWaitForPageLoad(driver);
		}else if(loginDetails.get("Environment").equals("DEV")||loginDetails.get("Environment").equals("DEHDEV")) {
			String openString="window.open('"+CommonUtility.property.getProperty("env.baseurlDEV")+"', '_blank');";
			js.executeScript(openString);
			String currentWindow = driver.getWindowHandle();
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			for (String window : tabs) {
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("devcdsrvcs")) {
					CommonUtility.cWaitForPageLoad(driver);
					driver.get(CommonUtility.property.getProperty("env.baseurlDEV"));
					CommonUtility.cWaitForPageLoad(driver);
					Thread.sleep(2000);
				}
			}
			driver.switchTo().window(currentWindow);
			CommonUtility.cWaitForPageLoad(driver);
		}
	}
	public void launchDEH_OTP_URL(Map<String, String> loginDetails) throws Exception {
		CommonUtility.cLoadProperties(System.getProperty("user.dir")+"/resources/application.properties");
		if(loginDetails.get("Environment").equals("DEHQA")) {
			String openString="window.open('"+CommonUtility.property.getProperty("env.otpDEHurlQA")+"', '_blank');";
			js.executeScript(openString);
			CommonUtility.cWaitForPageLoad(driver);
		}else if(loginDetails.get("Environment").equals("DEHDEV")) {
			String openString="window.open('"+ CommonUtility.property.getProperty("env.otpDEHurlDEV")+"', '_blank');";
			js.executeScript(openString);
			CommonUtility.cWaitForPageLoad(driver);
		}else if(loginDetails.get("Environment").equals("DEHUAT")) {
			String openString="window.open('"+ CommonUtility.property.getProperty("env.otpDEHurlUAT")+"', '_blank');";
			js.executeScript(openString);
			CommonUtility.cWaitForPageLoad(driver);
		}
	}

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub

	}

	
}
