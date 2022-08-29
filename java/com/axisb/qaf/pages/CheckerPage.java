package com.axisb.qaf.pages;

import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.utils.CommonUtility;
import com.qmetry.qaf.automation.core.AutomationError;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class CheckerPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	@FindBy(locator = "xpath=//span[contains(text(),'Vendor')]")
	private QAFWebElement vendorlink;

	@FindBy(locator = "xpath=//span[contains(text(),'Beneficiary')]")
	private QAFWebElement beneficiarylink;

	@FindBy(locator = "xpath=//span[contains(text(),'Statutory')]")
	private QAFWebElement statutorylink;

	@FindBy(locator = "xpath=//input[@id='quickFilter']")
	private QAFWebElement searchtxtarea;

	@FindBy(locator = "xpath=//span[contains(text(),'Advanced Search']")
	private QAFWebElement advancedsearchbtn;

	@FindBy(locator = "xpath=//span[contains(text(),'Proceed')]")
	private QAFWebElement proceedBtn;

	@FindBy(locator = "xpath=//span[contains(text(),'Submit')]")
	private QAFWebElement submitBtn;

	@FindBy(locator = "xpath=//span[contains(text(),'Back')]")
	private QAFWebElement backBtn;

	@FindBy(locator = "xpath=//input[@id='start-date-date-picker-placeholder']")
	private QAFWebElement startDatepicker;

	@FindBy(locator = "xpath=//input[@id='start-date-date-picker-placeholder']")
	private QAFWebElement resetdatebtn;

	@FindBy(locator = "xpath=//*[contains(text(),'Customize')]")
	private QAFWebElement customizebtn;

	@FindBy(locator = "xpath=//*[contains(text(),'Apply')]")
	private QAFWebElement applybtn;

	@FindBy(locator = "xpath=//*[contains(text(),'Reset')]")
	private QAFWebElement resetbtn;

	@FindBy(locator = "xpath=//*[@id='customize-search-text']")
	private QAFWebElement searchtext;

	@FindBy(locator = "xpath=//div[@id='parent-header-action']")
	private QAFWebElement parentaction_dropdown;

	@FindBy(locator = "xpath=(//div[@id='actions']/span)[1]")
	private QAFWebElement actiondropdown;

	@FindBy(locator = "xpath=//*[@role='listbox']/li[3]")
	private QAFWebElement approvedropdown;

	@FindBy(locator = "xpath=//*[@role='listbox']/li[4]")
	private QAFWebElement rejectapprovedropdown;

	@FindBy(locator = "xpath=//*[@role='listbox']/li[4]")
	private QAFWebElement rejectdropdown;

	@FindBy(locator = "xpath=//*[contains(text(),'Bene test')]")
	private QAFWebElement beneficiaryname;

	@FindBy(locator = "xpath=//h2/div/div/button")
	private QAFWebElement otpclosebtn;

	@FindBy(locator = "xpath=(//div[@col-id='amountToDisplay'])[2]")
	private QAFWebElement amountToPay;

	@FindBy(locator = "xpath=(//div[@col-id='debitAccount'])[2]//div[contains(@class,'account-balance')]/div[2]")
	private QAFWebElement accountBalance;

	@FindBy(locator = "xpath=//div[contains(@class,'_insufficientBalanceText')]")
	private QAFWebElement insufficientBalance_Procced;
	
	@FindBy(locator = "xpath=(//button[contains(@class,'single-transaction-summary')])[1]")
	private QAFWebElement insufficientBalance_Summary;

	public void approveVendor() throws Exception {
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 250);
		try {
			boolean vendorDataFlag = CommonUtility.cVerifyElementIsPresent(driver, actiondropdown, 10);
			CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, actiondropdown);
			CommonUtility.cClick(driver, actiondropdown);
			CommonUtility.cClick(driver, approvedropdown);
			Validator.assertTrue(vendorDataFlag, "[Failed,Vendor is not available]",
					"Selected the action as approve successfully");
		} catch (Exception e) {
			throw new AutomationError("No vendor payment present for this checker. Please check and re-run");
		}
	}
	
	public void clickVendorProceedAndSubmit() throws Exception {
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, amountToPay);
		int amount = Integer.parseInt(amountToPay.getText().trim().replaceAll("[^0-9]", ""));
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, accountBalance);
		int accountBalanceAmount = Integer.parseInt(accountBalance.getText().trim().replaceAll("[^\\d-]", ""));
		if (amount <= accountBalanceAmount) {
			CommonUtility.cClick(driver, proceedBtn);
			CommonUtility.cClick(driver, submitBtn);
		} else {
			boolean insufficientFlag = CommonUtility.cVerifyElementIsPresent(driver, insufficientBalance_Procced, 10);
			Validator.assertTrue(insufficientFlag, "Failed! Insufficient Balance alert message is not displayed",
					"Verified that system is displaying the Insuffient Balance alert message where debit account balance is less than the amount to be deducted");
			CommonUtility.cClick(driver, proceedBtn);
			boolean insufficientSummaryFlag = CommonUtility.cVerifyElementIsPresent(driver, insufficientBalance_Summary,
					10);
			Validator.assertTrue(insufficientSummaryFlag,
					"Failed! Insufficient Balance alert message is not displayed in summary screen",
					"Verified that system is displaying the Insuffient Balance alert message where debit account balance is less than the amount to be deducted");
			clickSubmit();
		}
	}

	public void clickProceed() throws Exception {
		
		boolean insufficientFlag = CommonUtility.cVerifyElementIsPresent(driver, insufficientBalance_Procced, 10);
		Validator.assertFalse(insufficientFlag, "Failed! Insufficient alert message should not be displayed",
					"Verified that the system not diplayed the Insuffient Balance alert message");
	    CommonUtility.cClick(driver, proceedBtn);
	}

	public void clickSubmit() throws Exception {
		CommonUtility.cClick(driver, submitBtn);

	}

	public void clickBeneficiaryTab() throws Exception {
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 190);
		try {
			CommonUtility.cExplicitlyWait(driver, beneficiarylink, 50);
			CommonUtility.cClick(driver, beneficiarylink);
			CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 60);
		} catch (Exception e) {
			throw new AutomationError("Beneficiary data is not available");
		}
	}

	public void approveBeneficary() throws Exception {
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 190);
		try {
			boolean beneficiaryDataFlag = CommonUtility.cVerifyElementIsPresent(driver, actiondropdown, 10);
			CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, actiondropdown);
			CommonUtility.cClick(driver, actiondropdown);
			CommonUtility.cClick(driver, approvedropdown);
			Validator.assertTrue(beneficiaryDataFlag, "[Failed,Beneficiary is not available]",
					"Selected the action as approve successfully");
		} catch (customElementNotFoundException e) {
			throw new AutomationError("Beneficiary data is not available");
		}
	}

	public void rejectVendor() throws Exception {
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 190);
		try {
			boolean vendorDataFlag = CommonUtility.cVerifyElementIsPresent(driver, actiondropdown, 10);
			CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, actiondropdown);
			CommonUtility.cClick(driver, actiondropdown);
			CommonUtility.cClick(driver, rejectdropdown);
			Validator.assertTrue(vendorDataFlag, "[Failed,Vendor is not available]",
					"Selected the action as reject successfully");
		} catch (customElementNotFoundException e) {
			throw new AutomationError("Vendor data is not available");
		}
	}

	public void rejectBeneficiary() throws Exception {
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 190);
		try {
			boolean beneficiaryDataFlag = CommonUtility.cVerifyElementIsPresent(driver, actiondropdown, 10);
			CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, actiondropdown);
			CommonUtility.cClick(driver, actiondropdown);
			CommonUtility.cClick(driver, rejectdropdown);
			Validator.assertTrue(beneficiaryDataFlag, "[Failed,Beneficiary is not available]",
					"Selected the action as reject successfully");
		} catch (customElementNotFoundException e) {
			throw new AutomationError("Beneficiary data is not available");
		}
	}

	public void otpClose() throws Exception {
		CommonUtility.cClick(driver, otpclosebtn);
	}

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub
	}
}