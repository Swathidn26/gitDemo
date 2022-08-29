package com.axisb.qaf.pages;

import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.utils.CommonUtility;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class EpaymentMakerPage extends WebDriverBaseTestPage<WebDriverTestPage>{
	
	@FindBy(locator="xpath=//span[contains(text(),'Payments')]")
	private QAFWebElement payment_Link;

	@FindBy(locator = "xpath=(//*[contains(text(), 'New Payments')])[1]")
	private QAFWebElement new_Payment_Link;

	@FindBy(locator="xpath=//span[contains(text(),'GST ePayments')]")
	private QAFWebElement gst_Epayment_Link;

	@FindBy(locator="xpath=//span[contains(text(),'Make Payment')]")
	private QAFWebElement make_Payment_Link;

	@FindBy(locator="xpath=(//div[@id='actions'])[1]")
	private QAFWebElement select_Debit_Account_Link;

	@FindBy(locator = "xpath=(//li[@role='option'])[1]")
	private QAFWebElement select_Debit_Account;

	@FindBy(locator ="xpath=(//input[@type='checkbox'])[7]")
	private QAFWebElement checkbox_Link;

	@FindBy(locator="xpath=(//*[contains(text(),'VIEW/MODIFY RULE ')])[1]")
	private QAFWebElement view_modify_rule;

	@FindBy(locator="xpath=//div[@id='Rule Applicable']")
	private QAFWebElement rule_applicable;

	@FindBy(locator="xpath=(//*[contains(text(),'1 EC + 1 BOD')])[1]")
	private QAFWebElement select_rule;

	@FindBy(locator ="xpath=//span[contains(text(),'Continue')]")
	private QAFWebElement continue_Button;

	@FindBy(locator="xpath=//span[contains(text(),'Confirm Payment')]")
	private QAFWebElement confirm_Payment;

	@FindBy(locator="xpath=//*[contains(text(),'Last 7 Days')]")
	private QAFWebElement last_seven_days;

	@FindBy(locator="xpath=//input[@name='gstin']")
	private QAFWebElement gstin_link;

	@FindBy(locator="xpath=//input[@name='cpin']")
	private QAFWebElement cpin_link;

	@FindBy(locator="xpath=//span[contains(text(),'Apply')]")
	private QAFWebElement apply_button;

	@FindBy(locator="xpath=//*[contains(text(),'Clear All')]")
	private QAFWebElement clear_button;

	@FindBy(locator="xpath=//span[contains(text(),'Drafts')]")
	private QAFWebElement drafts_link;

	@FindBy(locator="xpath=//*[contains(text(),'Advanced Search')]")
	private QAFWebElement advanced_search;

	@FindBy(locator="xpath=(//*[contains(text(),'08AAACA9952G1ZJ')])[1]")
	private QAFWebElement gstin_data;

	@FindBy(locator="xpath=//span[contains(text(),'Save')]")
	private QAFWebElement save_button;

	@FindBy(locator="xpath=(//span[@role='presentation'])[7]")
	private QAFWebElement cpin;

	@FindBy(locator = "xpath=//p[contains(text(),'Payment is successfully initiated and is pending for approval')]")
	private QAFWebElement success_msg;

	@FindBy(locator = "xpath=//span[contains(text(),'Back to Payments Overview')]")
	private QAFWebElement backToOverview_Btn;

	@FindBy(locator="xpath=(//input[@type='checkbox']/parent::span)[2]")
	private QAFWebElement cpin_checkbox;

	@FindBy(locator="xpath=//span[contains(text(),'Save To Drafts')]")
	private QAFWebElement save_to_draft;

	public void clickPayment() throws Exception {
		CommonUtility.cClick(driver, payment_Link);
	}

	public void clickCpinCheckBox() throws Exception {
		CommonUtility.cClick(driver, cpin_checkbox);
	}

	public void clickViewModifyRule() throws Exception {
		CommonUtility.cClick(driver, view_modify_rule);
	}

	public void clickRuleApplicable() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, rule_applicable);
	}

	public void selectRule() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cExplicitlyWait(driver, select_rule, 15);
		CommonUtility.cClick(driver, select_rule);
	}

	public void clickSave() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, save_button);
	}

	public void clickDrafts() throws Exception {
		CommonUtility.cClick(driver, drafts_link);
	}

	public void clickMakePayment() throws Exception {
		CommonUtility.cExplicitlyWait(driver, new_Payment_Link, 15);
		CommonUtility.cMoveToElementFromSourceToTarget(driver, new_Payment_Link, gst_Epayment_Link);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 60);
	}

	public void selectDebitAccount()throws Exception {
		CommonUtility.cExplicitlyWait(driver, select_Debit_Account_Link, 15);
		CommonUtility.cClick(driver, select_Debit_Account_Link);
		CommonUtility.cExplicitlyWait(driver, select_Debit_Account, 15);
		CommonUtility.cClick(driver, select_Debit_Account);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 30);
		checkbox_Link.click();
	}

	public void clickContinue() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, continue_Button);
	}

	public void clickAdvancedSearch() throws Exception {
		CommonUtility.cClick(driver, advanced_search);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 30);
	}

	public void clickConfirm() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, confirm_Payment);
	}

	public void clickSaveToDraft()throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, save_to_draft);
	}

	public void accountDetails(String gstin) throws InterruptedException, customElementNotClickableException, customElementNotFoundException, Exception {
		CommonUtility.cExplicitlyWait(driver, apply_button, 15);
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, gstin_link);
		CommonUtility.cSendKeys(driver,gstin_link,gstin);
	}

	public void clickApply()throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, apply_button);
	}

	public void clickClear()throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, clear_button);
	}

	public void verifySuccessMsgEpaymentMaker() throws Throwable {
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 30);
		CommonUtility.cExplicitlyWait(driver, success_msg, 15);
		boolean epaymentSuccessFlag = CommonUtility.cVerifyElementIsPresent(driver, success_msg, 10);
		Validator.assertTrue(epaymentSuccessFlag,
				"[API failure! Epayment Confirmation Validation Failed!]",
				"Epayment Confirmation completed successfully");
	}


	public void verifyBackToOverview() throws Exception {
		Validator.assertTrue(backToOverview_Btn.isEnabled(),
				"[API failure! Back to Overview is not enabled Failed!]",
				"Back to Overview is enabled successfully");
	}


	public void verifyAdvancedSearchApply() throws Throwable {
		CommonUtility.cExplicitlyWait(driver, gstin_data, 30);
		boolean gstnDataFlag = CommonUtility.cVerifyElementIsPresent(driver, gstin_data, 10);
		Validator.assertTrue(gstnDataFlag,
				"[Gstn Data is not filtered according to the given input! Failed!]",
				"Gstn Data is filtered according to the given input successfully");
	}
	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
	}

}