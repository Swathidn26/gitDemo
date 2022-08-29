package com.axisb.qaf.steps;

import com.axisb.qaf.pages.IeCodeCheckerPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class IeCodeCheckerSteps extends WebDriverTestCase{

	IeCodeCheckerPage ieCodeCheckerPage = new IeCodeCheckerPage();

	@QAFTestStep(description="user click service tab and click pending request")
	public void user_click_service_tab_and_click_pending_request() throws Exception {
		ieCodeCheckerPage.clickPendingRequestLink();
	}

	@QAFTestStep(description="user enable the check box and accept terms and conditions")
	public void user_enable_the_check_box_and_accept_terms_and_conditions() throws Exception {
		ieCodeCheckerPage.clickIeCodeCheckBox();
		ieCodeCheckerPage.clickTermsAndConditions();
	}

	@QAFTestStep(description="user approve the ie code and user enters the otp as {otp}")
	public void user_approve_the_ie_code_and_user_enters_the_otp_as(String otp) throws Exception {
		ieCodeCheckerPage.clickApproveLink();
		ieCodeCheckerPage.enterOtp(otp);
	}

	@QAFTestStep(description="ie code will be approved and success message will be displayed")
	public void ie_code_will_be_approved_and_success_message_will_be_displayed() throws Throwable {
		ieCodeCheckerPage.verifySuccessMsgApproveIeCode();
	}

}
