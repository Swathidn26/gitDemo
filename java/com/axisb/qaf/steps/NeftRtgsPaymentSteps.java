package com.axisb.qaf.steps;

import java.util.List;
import java.util.Map;
import com.axisb.qaf.exceptions.customElementFoundException;
import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.pages.AddNewBeneficiaryPage;
import com.axisb.qaf.pages.LoginwithOTPPage;
import com.axisb.qaf.pages.NeftRtgsPaymentPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class NeftRtgsPaymentSteps extends WebDriverTestCase{
	NeftRtgsPaymentPage neftRtgsPaymentPage = new NeftRtgsPaymentPage();
	
	@QAFTestStep(description="user clicks on payments and click new payments and gst Payment via NEFT RTGS")
	public void user_clicks_on_payments_and_click_new_payments_and_gst_payment_via_neft_rtgs() throws Exception {
	    neftRtgsPaymentPage.clickNeftPayments();
	}

	@QAFTestStep(description="user enters CPIN Amount and select Debit Account enter Remarks{0}")
	public void user_enters_cpin_amount_and_select_debit_account_enter_remarks(List<Map<String,String>>cpinDetails) throws Exception {
         neftRtgsPaymentPage.paymentDetails(cpinDetails);
	}

	@QAFTestStep(description="user selects rule and Approver and enters Remark{0}")
	public void user_selects_rule_and_approver_and_enters_remark(List<Map<String,String>>ruleDetails) throws Exception {
          neftRtgsPaymentPage.clicknewrule(ruleDetails);	 
	}
	
	
	@QAFTestStep(description="user clicks on continue button")
	public void user_clicks_on_continue_button() throws Exception{
		neftRtgsPaymentPage.clickContinueBtn();
	}

	@QAFTestStep(description="user clicks on makepayment button")
	public void user_clicks_on_makepayment_button() throws Exception{
		neftRtgsPaymentPage.clickMakePayment();
	}
	
	@QAFTestStep(description="submit message is displayed")
	public void submit_message_is_displayed() throws Exception{
		neftRtgsPaymentPage.submissionMessage();
	}
	
	@QAFTestStep(description="user clicks on add a row")
	public void user_clicks_on_add_a_row() throws Exception {
		neftRtgsPaymentPage.addNewRow();
	}
	
	@QAFTestStep(description="user click on delete record icon and click yes button to confirm delete")
	public void user_click_on_delete_record_icon() throws Exception {
		neftRtgsPaymentPage.deleteNeftRow();
	}
	
	@QAFTestStep(description="record deleted success toast message is displayed")
	public void record_deleted_success_toast_message_is_displayed() throws Exception {
	   neftRtgsPaymentPage.deletToastMessage();
	}
	
	@QAFTestStep(description="user click on save as draft")
	public void user_click_on_save_as_draft() throws Exception {
		neftRtgsPaymentPage.saveAsDraftRecord();
	}

	@QAFTestStep(description="toast message for saving as draft is displayed")
	public void toast_message_for_saving_as_draft_is_displayed() throws Exception {
	    neftRtgsPaymentPage.saveasDraftToastMessage();
	}

	@QAFTestStep(description="user clicks on customize and selects options{0}")
	public void user_clicks_on_customize_and_selects_options(List<Map<String,String>> options) throws Exception {
		neftRtgsPaymentPage.customizeColumns(options); 
	}
	
	@QAFTestStep(description="user enters details CPIN Amount and select Debit Account enter Remarks{0}")
	public void user_enters_details_cpin_amount_and_select_debit_account_enter_remarks(List<Map<String,String>>newrowDetails) throws InterruptedException, Exception {
	   neftRtgsPaymentPage.newrowDetails(newrowDetails);
	}
	
	@QAFTestStep(description="user selects new rule and Approver and enters Remark{0}")
	public void user_selects_new_rule_and_approver_and_enters_remark(List<Map<String,String>> newrowRule) throws InterruptedException, Exception {
	   neftRtgsPaymentPage.newRowModifyRule(newrowRule);
	}
	
	@QAFTestStep(description="submission message is displayed")
	public void submission_message_is_displayed() throws Exception {
		neftRtgsPaymentPage.multiplerowSubmissionMsg();  
	}
	
}
