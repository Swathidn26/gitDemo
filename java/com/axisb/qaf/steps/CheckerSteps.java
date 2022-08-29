package com.axisb.qaf.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.axisb.qaf.pages.CheckerPage;

public class CheckerSteps extends WebDriverTestCase {
	CheckerPage checkerpage = new CheckerPage();

	@QAFTestStep(description = "select any BeneficiaryName in the Vendorlist for the approval")
	public void select_any_beneficiary_name_in_the_vendorlist_for_the_approval() throws Exception {
		checkerpage.approveVendor();
	}
	@QAFTestStep(description = "select any BeneficiaryName in the Vendorlist for the reject")
	public void select_any_beneficiary_name_in_the_vendorlist_for_the_reject() throws Exception {
		checkerpage.rejectVendor();
	}
	
	@QAFTestStep(description = "click on proceed and submit button")
	public void click_on_proceed_and_submit() throws Exception {
		checkerpage.clickVendorProceedAndSubmit();
	}
	
	@QAFTestStep(description = "click on Proceed")
	public void click_on_proceed() throws Exception {
		checkerpage.clickProceed();
	}
	@QAFTestStep(description = "click on Submit")
	public void click_on_submit() throws Exception {
		checkerpage.clickSubmit();
	}
	@QAFTestStep(description = "user click on Beneficiary")
	public void userclickBeneficiary() throws Exception {
		
		checkerpage.clickBeneficiaryTab();
	}
	@QAFTestStep(description = "select any BeneficiaryName in the Beneficiarylist for the approval")
	public void select_any_beneficiary_name_in_the_beneficiarylist_for_the_approval() throws Exception {
		checkerpage.approveBeneficary();
	}
	@QAFTestStep(description = "select any BeneficiaryName in the Beneficiarylist for the reject")
	public void select_any_beneficiary_name_in_the_beneficiarylist_for_the_reject() throws Exception {
		checkerpage.rejectBeneficiary();
	}
	@QAFTestStep(description = "user should able to see Otp Screen")
	public void user_should_able_to_see_Otp_Screen() throws Exception {
		checkerpage.otpClose();
	}
	
}