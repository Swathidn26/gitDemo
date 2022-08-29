package com.axisb.qaf.pages;

import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.utils.CommonUtility;
import com.qmetry.qaf.automation.core.AutomationError;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class PaymentOverviewPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	/*************** Recall Transaction ****************/

	@FindBy(locator = "xpath=//div[@id='mainTab']/div[1]")
	private QAFWebElement pendingTab;

	@FindBy(locator = "//span[contains(text(),'Vendor (')]")
	private QAFWebElement vendorTab;

	@FindBy(locator = "xpath=//span[contains(text(),'Statutory (')]")
	private QAFWebElement statutoryTab;

	@FindBy(locator = "xpath=//span[contains(text(),'Beneficiary (')]")
	private QAFWebElement beneficiaryTab;

	@FindBy(locator = "xpath=//td[contains(text(),'Pending with Approver')]")
	private QAFWebElement pendingWithApproverLink;

	@FindBy(locator = "xpath=//td[contains(text(),'Pending with Bank')]")
	private QAFWebElement pendingWithBankLink;

	@FindBy(locator = "xpath=//td[contains(text(),'GST NEFT/RTGS')]/following-sibling::td[3]")
	private QAFWebElement pendingWithApproverStatutoryLink;

	@FindBy(locator = "xpath=//span[contains(text(),'Recall Transaction')]")
	private QAFWebElement recallTransactionBtn;

	@FindBy(locator = "xpath=(//*[contains(@class,'Alert-message')])[1]")
	private QAFWebElement toastMsgBox;

	@FindBy(locator = "xpath=//div[contains(@class,'individualTransactionDetails')]/p/span")
	private QAFWebElement close_PopUp;
	
	/****************** Remind Checker *************/

	@FindBy(locator = "xpath=//span[contains(text(),'Remind Checker')]")
	private QAFWebElement remindCheckerBtn;

	@FindBy(locator = "xpath=//div[contains(text(),'Reminder sent successfully')]")
	private QAFWebElement remindCheckerSucussMsg;

	/*****************
	 * Recall Transaction
	 * 
	 * @throws Exception
	 **********/

	public void verifyPendingCount() throws Exception {
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 60);
		try {
			int total = 0;
			List<WebElement> pendingCategoryList = CommonUtility.cFindElements(driver,
					By.xpath("//div[@id='mainTabCmp']/following-sibling::div[1]/button"), 10);
			for (WebElement element : pendingCategoryList) {
				int categoryCount = Integer.parseInt(element.getText().replaceAll("[^0-9]", ""));
				total += categoryCount;
			}
			int pendingCount = Integer.parseInt(pendingTab.getText());
			boolean beneCountFlag = Validator.verifyThat(pendingCount, Matchers.equalTo(total));
			Validator.assertTrue(beneCountFlag, "[Failed! Total Pending Count is : " +pendingCount+ "Sum of the Vendor,Statutory,Beneficiary count : " + total+"]",
					"Passed! Pending Count is : " + pendingCount + " Total Count is : " + total);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public void clickOnVendorTab() throws Exception {
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 60);
		Boolean vendorTabFlag = CommonUtility.cVerifyElementIsPresent(driver, vendorTab, 25);
		if (vendorTabFlag == true) {
			CommonUtility.cClick(driver, vendorTab);
		} else {
			Validator.assertTrue(vendorTabFlag, "[Vendor tab is not available in Payment overview screen]", "Passed");
		}
	}

	public void clickOnStatutoryTab() throws Exception {
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 60);
		Boolean statutoryTabFlag = CommonUtility.cVerifyElementIsPresent(driver, statutoryTab, 25);
		if (statutoryTabFlag == true) {
			CommonUtility.cClick(driver, statutoryTab);
		} else {
			Validator.assertTrue(statutoryTabFlag, "[Statutory tab is not available in Payment overview screen]",
					"Passed");
		}
	}

	public void clickOnBeneficiaryTab() throws Exception {
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 60);
		Boolean beneficiaryTabFlag = CommonUtility.cVerifyElementIsPresent(driver, beneficiaryTab, 25);
		if (beneficiaryTabFlag == true) {
			CommonUtility.cClick(driver, beneficiaryTab);
		} else {
			Validator.assertTrue(beneficiaryTabFlag, "[Beneficiary tab is not available in Payment overview screen]",
					"Passed");
		}
	}

	public void doVendorRecallTransaction() throws Exception {
		Boolean pendingWithApproverFlag = CommonUtility.cVerifyElementIsPresent(driver, pendingWithApproverLink, 10);
		if (pendingWithApproverFlag == true) {
			CommonUtility.cClick(driver, pendingWithApproverLink);
			CommonUtility.cClick(driver, recallTransactionBtn);
		} else {
			throw new AutomationError("Pending with approver data is not available in vendor section");
		}
	}

	public void doStatutoryRecallTrasnsaction(Map<String, String> statutoryDetails) throws Exception {
			clickStatutoryPendingWithAproverLink(statutoryDetails);
	}

	public void clickStatutoryPendingWithAproverLink(Map<String, String> statutoryDetails) throws Exception {
		try {
			List<WebElement> paymentOverviewTable = CommonUtility.cFindElements(driver,
					By.xpath("//table/tbody/tr/table/tbody/tr"), 10);
			for (int i = 1; i <= paymentOverviewTable.size(); i++) {
				String xpathTansactionType = "//table/tbody/tr[" + i + "]/table/tbody/tr/td[3]";
				String xpathStatus = "//table/tbody/tr[" + i + "]/table/tbody/tr/td[6]";
				WebElement transactionType = CommonUtility.cFindElement(driver, By.xpath(xpathTansactionType), 5);
				WebElement status = CommonUtility.cFindElement(driver, By.xpath(xpathStatus), 5);

				if (transactionType.getText().equalsIgnoreCase(statutoryDetails.get("TransactionType"))
						&& status.getText().equalsIgnoreCase(statutoryDetails.get("Status"))) {
					CommonUtility.cClick(driver, transactionType);
					CommonUtility.cClick(driver, recallTransactionBtn);
					CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 20);
					break;
				}
			}
		} catch (customElementNotFoundException e) {
			throw new AutomationError("Pending with approver data is not available in statutory section");
		} 
	}

	public void verifyRecallTransactionSuccessMsg() throws Exception {
		String toastMessage = toastMsgBox.getText();	
		boolean recallSuccessFlag = false;
		if(toastMessage.equals("Transaction recalled successfully and saved in drafts")) 
			recallSuccessFlag = true;
		Validator.assertTrue(recallSuccessFlag,
				"[Recall transaction failed! Message displayed as :"+toastMessage +" instead of success]",
				"Recall transaction for Pending with approver is successful");
		
	}

	/************************************
	 * Negative Flows
	 ***********************************/

	public void verifyIsRecallTransactionAvailableForBeneficiary()
			throws customElementNotClickableException, customElementNotFoundException, Exception {
		Boolean pendingWithApproverFlag = CommonUtility.cVerifyElementIsPresent(driver, pendingWithApproverLink, 10);
		if (pendingWithApproverFlag == true) {
			CommonUtility.cClick(driver, pendingWithApproverLink);
			boolean recallTransactionFlag = CommonUtility.cVerifyElementIsPresent(driver, recallTransactionBtn, 10);
			Validator.assertFalse(recallTransactionFlag, "[Failed, Recall Transaction is available]",
					"Verified that Recall transaction option is not there for beneficiary pending with apporver");
		} else {
			throw new AutomationError("Pending with approver data is not available in beneficiary section");
			
		}
	}

	public void verifyRecallTransactionBtnForVendorPendingWithBank()
			throws customElementNotClickableException, customElementNotFoundException, Exception {
		boolean pendingWithBankFlag = CommonUtility.cVerifyElementIsPresent(driver, pendingWithBankLink, 10);
		if (pendingWithBankFlag == true) {
			CommonUtility.cClick(driver, pendingWithBankLink);
			boolean recallTransactionFlag = CommonUtility.cVerifyElementIsPresent(driver, recallTransactionBtn, 10);
			Validator.assertFalse(recallTransactionFlag, "[Failed, Recall Transaction is available]",
					"Verified that Recall transaction option is not there for vendor pending with bank");
		} else {
			throw new AutomationError("Pending with bank data is not available in vendor section");
		}
	}

	public void verifyRecallTransactionBtnForStatutoryPendingWithBank()
			throws customElementNotClickableException, customElementNotFoundException, Exception {
		Boolean pendingWithBankFlag = CommonUtility.cVerifyElementIsPresent(driver, pendingWithBankLink, 10);
		if (pendingWithBankFlag == true) {
			CommonUtility.cClick(driver, pendingWithBankLink);
			boolean recallTransactionFlag = CommonUtility.cVerifyElementIsPresent(driver, recallTransactionBtn, 10);
			Validator.assertFalse(recallTransactionFlag, "[Failed, Recall Transaction is available]",
					"Verified that Recall transaction option is not there for statutory pending with bank");
		} else {
			throw new AutomationError("Pending with bank data is not available in vendor section");
		}
	}

	/************************************
	 * Remind Checker
	 ***********************************/

	public void doVendorRemindChecker() throws Exception {
		Boolean pendingApproverFlag = CommonUtility.cVerifyElementIsPresent(driver, pendingWithApproverLink, 10);
		if (pendingApproverFlag == true) {
			CommonUtility.cClick(driver, pendingWithApproverLink);
			CommonUtility.cClick(driver, remindCheckerBtn);
		} else {
			throw new AutomationError("Pending with bank data is not available in vendor section");
		}
	}

	public void doStatutoryRemindChecker() throws Exception {
		Boolean pendingApproverFlag = CommonUtility.cVerifyElementIsPresent(driver, pendingWithApproverLink, 10);
		if (pendingApproverFlag == true) {
			CommonUtility.cClick(driver, pendingWithApproverLink);
			CommonUtility.cClick(driver, remindCheckerBtn);
		} else {
			throw new AutomationError("Pending with approver data is not available in statutory section");
		}
	}

	public void doBeneficiaryRemindChecker() throws Exception {
		Boolean pendingApproverFlag = CommonUtility.cVerifyElementIsPresent(driver, pendingWithApproverLink, 10);
		if (pendingApproverFlag == true) {
			CommonUtility.cClick(driver, pendingWithApproverLink);
			CommonUtility.cClick(driver, remindCheckerBtn);
		} else {
			throw new AutomationError("Pending with approver data is not available in beneficiary section");
			
		}
	}

	public void verifyRemindCheckerSuccessMsg()
			throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cExplicitlyWait(driver, toastMsgBox, 90);
		String toastMessage = toastMsgBox.getText();	
		boolean remindCheckerFlag = false;
		if(toastMessage.equals("Reminder sent successfully"))
			remindCheckerFlag = true;
		Validator.assertTrue(remindCheckerFlag,
				"[Success message not displayed! Message displayed as :"+toastMessage +" ]",
				"Reminder sent successfully to checker");
	}

	public void verifyRemindCheckerBtnForVendorPendingWithBank()
			throws customElementNotClickableException, customElementNotFoundException, Exception {
		Boolean pendingWithBankFlag = CommonUtility.cVerifyElementIsPresent(driver, pendingWithBankLink, 10);
		if (pendingWithBankFlag == true) {
			CommonUtility.cClick(driver, pendingWithBankLink);
			boolean remindCheckerFlag = CommonUtility.cVerifyElementIsPresent(driver, remindCheckerBtn, 10);
			Validator.assertFalse(remindCheckerFlag, "[Failed, Remind Checker button is available]",
					"Verified that Remind checker option is not there for vendor pending with bank");
		} else {
			throw new AutomationError("Pending with bank data is not available in vendor section");
		}
	}

	public void verifyRemindCheckerBtnForStatutoryPendingWithBank()
			throws customElementNotClickableException, customElementNotFoundException, Exception {
		Boolean pendingWithBankFlag = CommonUtility.cVerifyElementIsPresent(driver, pendingWithBankLink, 10);
		if (pendingWithBankFlag == true) {
			CommonUtility.cClick(driver, pendingWithBankLink);
			boolean remindCheckerFlag = CommonUtility.cVerifyElementIsPresent(driver, remindCheckerBtn, 10);
			Validator.assertFalse(remindCheckerFlag, "[Failed, Remind Checker button is available]",
					"Verified that Remind checker option is not there for statutory pending with bank");
		} else {
			throw new AutomationError("Pending with bank data is not available in statutory section");
		}
	}

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {

	}

}
