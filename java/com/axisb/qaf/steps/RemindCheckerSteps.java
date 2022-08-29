package com.axisb.qaf.steps;

import com.axisb.qaf.pages.AddNewBeneficiaryPage;
import com.axisb.qaf.pages.PaymentOverviewPage;
import com.qmetry.qaf.automation.step.QAFTestStep;

public class RemindCheckerSteps {

	PaymentOverviewPage paymentOverviewPage = new PaymentOverviewPage();
	AddNewBeneficiaryPage addNewBeneficiaryPage = new AddNewBeneficiaryPage();
	
	@QAFTestStep(description="user clicks on pending with approver record and performs remind checker for vendor")
	public void user_clicks_on_vendor_remind_checker() throws Exception {
		paymentOverviewPage.doVendorRemindChecker();
	}
	
	@QAFTestStep(description="user clicks on pending with approver record and performs remind checker for statutory")
	public void user_clicks_on_statutory_remind_checker() throws Exception {
		paymentOverviewPage.doStatutoryRemindChecker();
	}
	
	@QAFTestStep(description="user clicks on pending with approver record and performs remind checker for beneficiary")
	public void user_clicks_on_beneficiary_remind_checker() throws Exception {
		paymentOverviewPage.doBeneficiaryRemindChecker();
	}
	
	@QAFTestStep(description="system should display the remind checker success message")
	public void user_verifies_remind_checker_success_message() throws Exception {
		paymentOverviewPage.verifyRemindCheckerSuccessMsg();
	}
	
	@QAFTestStep(description ="Remind checker option should not be available for vendor pending with bank")
	public void user_checks_Remind_checker_for_vendor_pending_with_bank() throws Exception {
		paymentOverviewPage.verifyRemindCheckerBtnForVendorPendingWithBank();
	}	
	
	@QAFTestStep(description ="Remind checker option should not be available for statutory pending with bank")
	public void user_checks_Remind_checker_for_statutory_pending_with_bank() throws Exception {
		paymentOverviewPage.verifyRemindCheckerBtnForStatutoryPendingWithBank();
	}
	
}
