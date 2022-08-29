package com.axisb.qaf.steps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.pages.MasterCheckerPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class MasterCheckerSteps extends WebDriverTestCase {

	MasterCheckerPage masterchecker = new MasterCheckerPage();
	
	@QAFTestStep(description="user clickes on payments and click on GST payments and select statutory")
	public void user_clickes_on_payments_and_click_on_gst_payments_and_select_statutory() throws Exception {
		masterchecker.gstPayments();
	}
	
	@QAFTestStep(description ="user selects gstin and selects action as approve and enter remarks, clicks proceed and submit")
	public void user_selects_gstin_and_selects_action_as_approve_and_enter_remarks_clicks_proceed_and_submit() throws Exception {
		masterchecker.selectGstinApprove();
	}

	@QAFTestStep(description = "user clicks submit and enter OTP {otp} and click submit and get confirmation message")
	public void user_clicks_submit_and_get_the_confirmation_message(String otp) throws InterruptedException {
		masterchecker.submitButton(otp);
	}

	
	@QAFTestStep(description ="user selects gstin and selects action as reject and enter remarks, clicks proceed and submit")
	public void user_selects_gstin_and_selects_action_as_reject_and_enter_remarks_clicks_proceed_and_submit() throws Exception {
		masterchecker.selectGstinReject();
	}

}
