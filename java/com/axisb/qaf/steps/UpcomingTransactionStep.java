package com.axisb.qaf.steps;

import java.util.List;
import java.util.Map;

import com.axisb.qaf.pages.UpcomingTransactionPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class UpcomingTransactionStep extends WebDriverTestCase {

	UpcomingTransactionPage upcomingtransaction = new UpcomingTransactionPage();

	@QAFTestStep(description = "user selects an option to cancel transaction")
	public void user_selects_an_option_to_cancel_transaction() throws Exception {
		upcomingtransaction.newrecurringPayment();
	}

	@QAFTestStep(description = "user selects particular transactions to be cancelled")
	public void user_selects_particular_transactions_to_be_cancelled() throws Exception {
		upcomingtransaction.cancelTransaction();
	}

	@QAFTestStep(description = "user selects rule and Approver and enter Remark{0}")
	public void user_selects_rule_and_approver_and_enter_remark(List<Map<String, String>> details) throws Exception {
		upcomingtransaction.viewModifyRule(details);
	}

	@QAFTestStep(description = "user clicks on proceed button and confirms the cancellation")
	public void user_clicks_on_proceed_button_and_confirms_the_cancellation() throws Exception {
		upcomingtransaction.clickProceed();
	}

	@QAFTestStep(description = "cancellation success message will be displayed")
	public void cancellation_success_message_will_be_displayed() throws Exception {
		upcomingtransaction.displaySuccessMessage();
	}

	@QAFTestStep(description = "user selects an option to cancel schedule transaction")
	public void user_selects_an_option_to_cancel_schedule_transaction() throws Exception {
		upcomingtransaction.newScehdulePayment();
	}

	@QAFTestStep(description = "user selects particular schedule transactions to be cancelled")
	public void user_selects_particular_schedule_transactions_to_be_cancelled() throws Exception {
		upcomingtransaction.cancelTransaction();
	}

}
