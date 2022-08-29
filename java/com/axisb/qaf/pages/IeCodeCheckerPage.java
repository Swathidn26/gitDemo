package com.axisb.qaf.pages;

import org.openqa.selenium.By;

import com.axisb.qaf.utils.CommonUtility;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class IeCodeCheckerPage extends WebDriverBaseTestPage<WebDriverTestPage>{

	@FindBy(locator = "xpath=//div[contains(text(),'Pending Requests')]")
	private QAFWebElement pending_requests;

	@FindBy(locator = "xpath=(//input[@type='checkbox']//parent::div)[8]")
	private QAFWebElement ie_code_checkbox;

	@FindBy(locator = "xpath=//input[@name='terms and conditions']/parent::span")
	private QAFWebElement terms_and_condition_link;

	@FindBy(locator = "xpath=//span[contains(text(),'Approve')]")
	private QAFWebElement approve_link;

	@FindBy(locator = "xpath=(//input[@type='tel'])[1]")
	private QAFWebElement otp_link;

	@FindBy(locator = "xpath=//span[contains(text(),'Submit')]")
	private QAFWebElement submit_btn;

	@FindBy(locator = "xpath=//p[contains(text(),'Request Submitted Successfully')]")
	private QAFWebElement success_msg_approveIeCode;

	public void clickPendingRequestLink() throws Exception {
		CommonUtility.cWaitForPageLoad(driver);
		CommonUtility.cClick(driver, pending_requests);
	}

	public void clickIeCodeCheckBox() throws Exception {
		CommonUtility.cClick(driver, ie_code_checkbox);
	}

	public void clickTermsAndConditions() throws Exception {
		CommonUtility.cFindElement(driver, terms_and_condition_link, 10).click();; 
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
		boolean updateGstnSuccessFlag = CommonUtility.cVerifyElementIsPresent(driver, success_msg_approveIeCode, 10);
		Validator.assertTrue(updateGstnSuccessFlag,
				"[API failure! Approve IE Code Validation Failed!]",
				"IE Code is Approved successfully");
	}

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {

	}
}
