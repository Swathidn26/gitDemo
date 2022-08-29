package com.axisb.qaf.steps;

import java.util.List;
import java.util.Map;

import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.pages.DEHVendorCheckerFlowPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class DEHVendorCheckerFlowStep extends WebDriverTestCase {

	DEHVendorCheckerFlowPage dehvendorcheckerflow = new DEHVendorCheckerFlowPage();

	@QAFTestStep(description = "user lands on Vendor tab and selects Beneficiary to approve")
	public void user_lands_on_vendor_tab_and_selects_beneficiary_to_approve() throws Exception {
		dehvendorcheckerflow.selectBeneApprove();
	}

	@QAFTestStep(description = "user clicks on proceed button followed by submit button")
	public void user_clicks_on_proceed_button_followed_by_submit_button() throws Exception {
		dehvendorcheckerflow.clickforSubmission();
	}

	@QAFTestStep(description = "user enters otp and clicks on submit button{0}")
	public void user_enters_otp_and_clicks_on_submit_button(Map<String, String> otpdetails) throws Exception {
		dehvendorcheckerflow.enterOTP(otpdetails);

	}

	@QAFTestStep(description = "request submitted successfully message is displayed")
	public void request_submitted_successfully_message_is_displayed() throws Exception {
		dehvendorcheckerflow.displaySuccessMsg();
	}

	@QAFTestStep(description = "user lands on Vendor tab and selects Beneficiary to reject")
	public void user_lands_on_vendor_tab_and_selects_beneficiary_to_reject() throws Exception {
		dehvendorcheckerflow.selectBeneReject();
	}

	@QAFTestStep(description = "user lands on Vendor tab and customizes by selecting columns options{0}")
	public void user_lands_on_vendor_tab_and_customizes_by_selecting_columns_options(List<Map<String, String>> options)
			throws Exception {
		dehvendorcheckerflow.customizeOptions(options);
	}

	@QAFTestStep(description = "user selects Beneficiary to approve and clicks on proceed button followed by submit")
	public void user_selects_beneficiary_to_approve_and_clicks_on_proceed_button_followed_by_submit() throws Exception {
		dehvendorcheckerflow.selectBeneApprove();
		dehvendorcheckerflow.clickforSubmission();
	}

	@QAFTestStep(description = "user lands on Vendor tab and enters details in search bar and gets the data")
	public void user_lands_on_vendor_tab_and_enters_details_in_search_bar_and_gets_the_data()
			throws customElementNotFoundException, customElementNotClickableException, InterruptedException {
		dehvendorcheckerflow.searchtext();
	}
	

	@QAFTestStep(description = "user lands on Vendor tab and clicks on refresh button thrice")
	public void user_lands_on_vendor_tab_and_clicks_on_refresh_button_thrice() throws Exception {
		dehvendorcheckerflow.clickRefreshThrice();
	}

	@QAFTestStep(description = "toast Message is displayed")
	public void toast_message_is_displayed() throws Exception {
		dehvendorcheckerflow.refreshDisplayMsg();
	}

	@QAFTestStep(description = "user lands on Vendor tab and selects mutliple request to approve")
	public void user_lands_on_vendor_tab_and_selects_mutliple_request_to_approve() throws Exception {
		dehvendorcheckerflow.mutlipleBeneApprove();
	}

	@QAFTestStep(description = "user lands on Vendor tab and selects mutliple request to reject")
	public void user_lands_on_vendor_tab_and_selects_mutliple_request_to_reject() throws Exception {
		dehvendorcheckerflow.mutlipleBeneReject();
	}
}
