package com.axisb.qaf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.utils.CommonUtility;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class ApproveIECodePage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator ="//*[@id='service']/div/span")
	private QAFWebElement service_link;

	@FindBy(locator = "//div[contains(text(),'Pending Requests')]")
	private QAFWebElement pending_requests;

	@FindBy(locator = "(//div[@class='ag-selection-checkbox'])[1]")
	private QAFWebElement ie_code_checkbox;

	@FindBy(locator = "//input[@name='terms and conditions']")
	private QAFWebElement terms_and_condition_link;

	@FindBy(locator = "//span[contains(text(),'Approve')]")
	private QAFWebElement approve_link;

	@FindBy(locator = "(//input[@type='tel'])[1]")
	private QAFWebElement otp_link;

	@FindBy(locator = "//span[contains(text(),'Submit')]")
	private QAFWebElement submit_btn;

	@FindBy(locator = "//p[contains(text(),'Request Submitted Successfully')]")
	private QAFWebElement success_msg_approveIeCode;

	public void clickPendingRequest() throws Exception {
		CommonUtility.cExplicitlyWait(driver, pending_requests, 10);
		CommonUtility.cClick(driver, pending_requests);
	}

	public void clickIeCodeCheckBox() throws Exception {
		CommonUtility.cClick(driver, ie_code_checkbox);
	}

	public void clickTermsAndConditions() throws Exception {
		CommonUtility.cClick(driver, terms_and_condition_link);
	}

	public void clickApproveLink() throws Exception {
		CommonUtility.cClick(driver, approve_link);
	}

	public void enterOtp(String otp) throws Exception {
		CommonUtility.cSendKeys(driver, otp_link, otp);
	}

	public void clickSubmitBtn() throws Exception {
		CommonUtility.cClick(driver, submit_btn);
	}

	public void verifySuccessMsgApproveIeCode() throws Throwable {
		CommonUtility.cExplicitlyWaitForAbsence(driver, By.xpath("//div[contains(@class='loader')]"), 60);
		CommonUtility.cExplicitlyWait(driver, success_msg_approveIeCode, 60);
		boolean updateGstnSuccessFlag = CommonUtility.cVerifyElementIsPresent(driver, success_msg_approveIeCode, 10);
		Validator.assertTrue(updateGstnSuccessFlag,
				"[API failure! Approve IE Code Validation Failed!]",
				"IE Code is Approved successfully");
	}

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {

	}

}
