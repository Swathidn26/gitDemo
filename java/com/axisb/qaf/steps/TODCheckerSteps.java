package com.axisb.qaf.steps;

import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.pages.TODCheckerPage;
import com.qmetry.qaf.automation.step.QAFTestStep;

public class TODCheckerSteps {

	TODCheckerPage todCheckerPage = new TODCheckerPage();
	
	@QAFTestStep(description = "checker clicks on first pending request")
	public void clicking_on_first_pending_request() throws Exception {
		todCheckerPage.clickFirstPendingRequest();
	}

	@QAFTestStep(description = "T&C check box, reject button should be visible")
	public void t_c_check_box_approve_button_reject_button_should_be_visible() throws Exception {
		todCheckerPage.verifyTnC();
	}
	
	@QAFTestStep(description ="approve button should be disabled")
	public void approve_reject_button_should_be_disabled() throws Exception {
		todCheckerPage.verifyDisabledApproveButtons();
	}

	@QAFTestStep(description = "clicks on T&C, approve")
	public void click_t_c_approve() throws customElementNotClickableException, customElementNotFoundException {
		todCheckerPage.clickTnCApprove();
	}		

	@QAFTestStep(description = "OTP screen should be displayed")
	public void validate_otp_screen_is_displayed() throws Exception {
	    todCheckerPage.validateOTPScreen();
	}

	@QAFTestStep(description = "clicks on Reject")
	public void accept_t_c_followed_by_reject() throws customElementNotClickableException, customElementNotFoundException {
		todCheckerPage.clickReject();
	}

	@QAFTestStep(description = "add remarks and click submit")
	public void add_remarks_and_click_submit() throws customElementNotClickableException, customElementNotFoundException {
	    todCheckerPage.addRemarks();
	    todCheckerPage.clickSubmit();
	}

	@QAFTestStep(description = "verify toast message for rejection")
	public void verify_toast_message_for_rejection() throws customElementNotFoundException {
	    todCheckerPage.verifySuccesMessage();
	}
	
	@QAFTestStep(description ="checker clicks on first request")
	public void clicking_on_first_request() throws customElementNotClickableException, customElementNotFoundException {
	   todCheckerPage.clickFirstRequest();
	}

	@QAFTestStep(description ="service overview screen should open with all details")
	public void service_overview_screen_should_open_with_all_details() throws Exception {
		todCheckerPage.verifyServiceOverviewScreen();
	}
	
	@QAFTestStep(description ="clicking on Request number header check box for multiple selection")
	public void clicking_on_request_number_header_check_box_for_multiple_selection() throws Exception {
		todCheckerPage.clickHeaderCheckBox();
	}
}
