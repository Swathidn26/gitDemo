package com.axisb.qaf.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.axisb.qaf.pages.AddNewBeneficiaryPage;
import com.axisb.qaf.pages.EpaymentMakerPage;
import com.axisb.qaf.pages.UpdateIECodePage;

public class EpaymentMakerSteps extends WebDriverTestCase {
	AddNewBeneficiaryPage addNewBeneficiaryPage=new AddNewBeneficiaryPage();
	EpaymentMakerPage ePaymentMaker=new EpaymentMakerPage();
	UpdateIECodePage updateIECodePage = new UpdateIECodePage();

	@QAFTestStep(description="provide required inputs in advanced search as {gstin}")
	public void provide_required_inputs_in_advanced_search_as(String gstin)throws Exception  {
		ePaymentMaker.clickAdvancedSearch();
		ePaymentMaker.accountDetails(gstin);
	}

	@QAFTestStep(description="user clicks on make payment, select debit account and rule checkbox")
	public void user_clicks_on_make_payment_select_debit_account_and_rule_checkbox() throws Exception {
		ePaymentMaker.clickMakePayment();
		ePaymentMaker.selectDebitAccount();
		ePaymentMaker.clickViewModifyRule();
		ePaymentMaker.clickRuleApplicable();
		ePaymentMaker.selectRule();
		ePaymentMaker.clickSave();
	}

	@QAFTestStep(description="user clicks on apply")
	public void user_clicks_on_apply() throws Exception {
		ePaymentMaker.clickApply();
	}

	@QAFTestStep(description="data will be filtered for the applied inputs")
	public void data_will_be_filtered_for_the_applied_inputs() throws Throwable {
		ePaymentMaker.verifyAdvancedSearchApply();
	}

	@QAFTestStep(description="user clicks on clear")
	public void user_clicks_on_clear() throws Exception {
		ePaymentMaker.clickClear();
	}

	@QAFTestStep(description="all the data will be displayed")
	public void all_the_data_will_be_displayed() throws Throwable {
		ePaymentMaker.verifyAdvancedSearchApply();
	}

	@QAFTestStep(description="user clicks on continue and save as draft")
	public void user_clicks_on_continue_and_save_as_draft() throws Exception {
		ePaymentMaker.clickContinue();
		ePaymentMaker.clickCpinCheckBox();
		ePaymentMaker.clickSaveToDraft();
	}

	@QAFTestStep(description="data will be saved in draft")
	public void data_will_be_saved_in_draft_as() throws Throwable {
		ePaymentMaker.clickDrafts();
	}

	@QAFTestStep(description="User clicks on continue and confirm button") public
	void User_clicks_on_continue_and_confirm_button() throws Exception {
		ePaymentMaker.clickContinue(); ePaymentMaker.clickConfirm(); 
	}

	@QAFTestStep(description = "success message will be displayed and Back to over view will be enabled")
	public void success_message_will_be_displayed_and_back_to_over_view_will_be_enabled() throws Throwable {
		ePaymentMaker.verifySuccessMsgEpaymentMaker();
		ePaymentMaker.verifyBackToOverview();
	}
}