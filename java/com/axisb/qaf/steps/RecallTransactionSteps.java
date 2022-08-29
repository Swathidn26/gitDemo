package com.axisb.qaf.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.axisb.qaf.pages.AddNewBeneficiaryPage;

import java.util.Map;

import com.axisb.qaf.pages.PaymentOverviewPage;

public class RecallTransactionSteps extends WebDriverTestCase {
	
	PaymentOverviewPage paymentOverviewPage = new PaymentOverviewPage();
	AddNewBeneficiaryPage addNewBeneficiaryPage = new AddNewBeneficiaryPage();
	
	@QAFTestStep(description="user verifies pending count before recall transaction")
	public void user_verifies_pending_count() throws Exception {
		paymentOverviewPage.verifyPendingCount();
	}
	
	@QAFTestStep(description="user performs the recall transaction for pending with approver")
	public void user_clicks_on_vendor_recall_trasnsaction() throws Exception {
		paymentOverviewPage.doVendorRecallTransaction();
	}
	
	@QAFTestStep(description="user performs the recall transaction for pending with approver{0}")
	public void user_clicks_on_statutory_recall_trasnsaction(Map<String, String> statutoryDetails) throws Exception {
		paymentOverviewPage.doStatutoryRecallTrasnsaction(statutoryDetails);
	}
	
	@QAFTestStep(description="user clicks on Vendor tab")
	public void user_clicks_on_vendor_tab() throws Exception {
		paymentOverviewPage.clickOnVendorTab();
	}
	
	@QAFTestStep(description="user clicks on Beneficiary tab")
	public void user_clicks_on_beneficiary_tab() throws Exception {
		paymentOverviewPage.clickOnBeneficiaryTab();
	}
	
	@QAFTestStep(description="user clicks on Statutory tab")
	public void user_clicks_on_statutory_tab() throws Exception {
		paymentOverviewPage.clickOnStatutoryTab();
	}
	
	@QAFTestStep(description="Recall transaction option should not be available for beneficiary pending with approval")
	public void user_checks_Recall_transaction_for_beneificary() throws Exception {
		paymentOverviewPage.verifyIsRecallTransactionAvailableForBeneficiary();
	}
	
	@QAFTestStep(description="user verifies recall transaction success message")
	public void user_verifies_recall_transaction_success_message() throws Exception {
		paymentOverviewPage.verifyRecallTransactionSuccessMsg();
	}
	
	@QAFTestStep(description="user verifies pending count after recall transaction")
	public void user_verifies_pending_count_after_recall_transaction() throws Exception {
		paymentOverviewPage.verifyPendingCount();
	}
	
	/********************Negative Flows***********************/
	
	@QAFTestStep(description = "Recall transaction option should not be available for vendor pending with bank")
	public void user_checks_Recall_transaction_for_vendor_pending_with_bank() throws Exception {
		paymentOverviewPage.verifyRemindCheckerBtnForVendorPendingWithBank();
	}	
	
	@QAFTestStep(description = "Recall transaction option should not be available for statutory pending with bank")
	public void user_checks_Recall_transaction_for_statutory_pending_with_bank() throws Exception {
		paymentOverviewPage.verifyRemindCheckerBtnForStatutoryPendingWithBank();
	}
}
