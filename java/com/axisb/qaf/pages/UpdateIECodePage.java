package com.axisb.qaf.pages;

import java.util.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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

public class UpdateIECodePage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "//*[contains(text(),'Service') ]")
	private QAFWebElement service_Request_Link;

	@FindBy(locator = "//div[@class='grid-view-click']")
	private QAFWebElement view_More_Link;

	@FindBy(locator = "//span[contains(text(),'New Request')]")
	private QAFWebElement newRequest_Btn;

	@FindBy(locator = "//p[contains(text(),'IE Code Update')]")
	private QAFWebElement ieCodeUpdate_Btn;

	@FindBy(locator = "//*[@id='mui-component-select-customerId']/parent::div")
	private QAFWebElement customer_Id_Dropdown;

	@FindBy(locator = "//input[@value='iecode']")
	private QAFWebElement ieCode_RadioBtn;

	@FindBy(locator = "//input[@id='standard-required']")
	private QAFWebElement ieCode_Txt;

	@FindBy(locator = "//span[contains(text(),'Validate')]")
	private QAFWebElement validate_Btn;

	@FindBy(locator = "//div[@role='alert']/div[2]")
	private QAFWebElement validated_toastMsg;

	@FindBy(locator = "//span[contains(text(),'Proceed')]")
	private QAFWebElement proceed_Button;

	@FindBy(locator = "//*[contains(text(),'VIEW RULE')]")
	private QAFWebElement viewRule_Btn;

	@FindBy(locator = "//*[@id='mui-component-select-ruleId']")
	private QAFWebElement ruleApplicable_Dropdown;

	@FindBy(locator = "//*[@id='menu-ruleId']/div[3]/ul/li")
	private QAFWebElement gen_Btn;

	@FindBy(locator = "//*[contains(@class,'common-fields_checkBoxContainer')]/div[1]/span[1]")
	private QAFWebElement termsAndCondtions_Chkbox;

	@FindBy(locator = "//span[contains(text(),'Submit')]")
	private QAFWebElement submit_Btn;

	@FindBy(locator = "//span[contains(text(),'Back to Service Overview')]")
	private QAFWebElement backToOverview_Btn;

	@FindBy(locator = "//p[contains(text(),'Request Submitted Successfully')]")
	private QAFWebElement success_Msg;

	@FindBy(locator = "//span[contains(text(),'Switch to Old View')]")
	private QAFWebElement switch_To_Old_View;

	@FindBy(locator = "//span[contains(text(),'Close')]")
	private QAFWebElement close_account_dormat_link;

	public void clickViewMore() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, view_More_Link);
	}

	public void clickNewRequest() throws customElementNotClickableException, customElementNotFoundException, Exception {
		try {
			if (close_account_dormat_link.isDisplayed()) {
				CommonUtility.cClick(driver, close_account_dormat_link);
			}
		} catch (Exception e) {
			try {
				CommonUtility.cExplicitlyWait(driver, close_account_dormat_link, 120);
				if (close_account_dormat_link.isDisplayed()) {
					CommonUtility.cClick(driver, close_account_dormat_link);
				}
			} catch (Exception e1) {
			}
		}
		Thread.sleep(10000);
		CommonUtility.cClick(driver, newRequest_Btn);
	}

	public void clickIECodeUpdateBtn() throws customElementNotClickableException, customElementNotFoundException, customElementFoundException {
		CommonUtility.cClick(driver, ieCodeUpdate_Btn);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 40);
	}

	public void clickCustomerId(String customerId) throws Exception {
		String customerIDxpath = "//li[@data-value='" + customerId + "']";
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 30);
		try {
			CommonUtility.cClick(driver, customer_Id_Dropdown);
		} catch (Exception e) {
			CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 30);
			try {
				CommonUtility.cClick(driver, customer_Id_Dropdown);
			} catch (Exception e1) {
				Validator.assertTrue(false, "[API failed, Loading is still in-progress!]",
						"Customer ID value selected successfully");
			}
		}
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 30);
		CommonUtility.cClick(driver, customer_Id_Dropdown);
		WebElement custID = driver.findElement(customerIDxpath);
		CommonUtility.cExplicitlyWait(driver, custID, 30);
		try {
			CommonUtility.cClick(driver, custID);
		} catch (customElementNotClickableException e) {
			Validator.assertTrue(false, "[API failed,Loading still in-progress!]",
					"Customer ID value selected successfully");
		}
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 50);
		Thread.sleep(10000);
	}

	public void clickIeCodeRadioBtn() throws customElementNotClickableException, customElementNotFoundException {
		ieCode_RadioBtn.click();
	}

	public void enterIECode(String iecode)
			throws customElementNotClickableException, customElementNotFoundException, Exception {
		CommonUtility.cSendKeys(driver, ieCode_Txt, iecode);
	}

	public void verifyValidateBtn() {
		Assert.assertTrue(validate_Btn.isEnabled());
	}

	public void clickValidateBtn()
			throws customElementNotClickableException, customElementNotFoundException, Exception {
		CommonUtility.cClick(driver, validate_Btn);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 60);
	}

	public void verfiyValidatedSuccessMsg() throws Exception {
		try {
			CommonUtility.cExplicitlyWait(driver, validated_toastMsg, 20);
			String validatedMsg =validated_toastMsg.getText();
			boolean validatedSuccessFlag=false;
			if(validatedMsg.equals("IE Code validated")) {
				validatedSuccessFlag=true;
				Validator.assertTrue(validatedSuccessFlag,"[API failure!]"+validatedMsg,
						"IE Code validated successfully");
			}else {
				Validator.assertTrue(validatedSuccessFlag,"[API failure!]"+validatedMsg,
						"IE Code validated successfully");
			}
		} catch (customElementNotFoundException e) {
			Validator.assertTrue(validated_toastMsg.isEnabled(),"[API failure! IE Code validation failed!]",
					"IE Code validated successfully");
		}
	}

	public void clickProceedBtn() throws Exception {
		if (proceed_Button.isDisplayed()) {
			CommonUtility.cClick(driver, proceed_Button);
			CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 20);
		}
	}

	public void clickViewRuleBtn() throws Exception {
		CommonUtility.cClick(driver, viewRule_Btn);
	}

	public void clickRuleApplicable() throws Exception {
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 20);
		CommonUtility.cClick(driver, ruleApplicable_Dropdown);
		CommonUtility.cClick(driver, gen_Btn);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 20);
		CommonUtility.cClick(driver, termsAndCondtions_Chkbox);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 20);
	}

	public void clickSubmit() throws Exception {
		try {
			CommonUtility.cClick(driver, submit_Btn);
		} catch (Exception e) {
			throw new Exception("EXCEPTION OCCURED WHILE CLICKING ON SUBMIT BUTTON");
		}
	}

	public void verifySuccessMsg() throws Throwable {
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 30);
		CommonUtility.cVerifyElementIsPresent(driver, success_Msg, 30);
		Validator.assertTrue(success_Msg.isEnabled(), "[Submission failed, Please check the screenshot for more details]", "IE Code Update successful");
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, success_Msg);
	}

	public void validateBackToOverview() {
		Assert.assertTrue(backToOverview_Btn.isEnabled());
	}

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {

	}

}
