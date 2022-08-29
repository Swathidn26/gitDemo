package com.axisb.qaf.steps;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.pages.*;
import com.axisb.qaf.pages.UpdateIECodePage;


public class UpdateIECodeSteps extends WebDriverTestCase {
	UpdateIECodePage updateIECodePage = new UpdateIECodePage();
	AddNewBeneficiaryPage addNewBeneficiaryPage = new AddNewBeneficiaryPage();

	@QAFTestStep(description = "user clicks on new request and ie code update")
	public void user_clicks_on_new_request_and_ie_code_update() throws Exception {
		updateIECodePage.clickNewRequest();
		updateIECodePage.clickIECodeUpdateBtn();
	}

	@QAFTestStep(description = "user select the customer id as {customerId} and user clicks ie code radio button")
	public void user_select_the_customer_id_as(String customerId) throws Exception {
		updateIECodePage.clickCustomerId(customerId);
		updateIECodePage.clickIeCodeRadioBtn();
	}

	@QAFTestStep(description = "user enters the ie code as {iecode} then validate button will be enabled")
	public void user_enters_the_ie_code_as(String iecode)
			throws Exception {
		updateIECodePage.enterIECode(iecode);
		updateIECodePage.verifyValidateBtn();
	}

	@QAFTestStep(description = "user click on validate button and proceed button")
	public void user_click_on_validate_button_and_proceed_button() throws Exception {
		updateIECodePage.clickValidateBtn();
		updateIECodePage.verfiyValidatedSuccessMsg();
		updateIECodePage.clickProceedBtn();
		
	}

	@QAFTestStep(description = "user selects the rule,terms and conditions and user clicks submit button")
	public void user_selects_the_rule_and_terms_and_conditions() throws Exception {
		updateIECodePage.clickViewRuleBtn();
		updateIECodePage.clickRuleApplicable();
		updateIECodePage.clickSubmit();
	}

	@QAFTestStep(description = "Success message will be displayed and Back to overview button will be enabled")
	public void success_message_will_be_displayed_and_back_to_overview_button_will_be_enabled() throws Throwable {
		updateIECodePage.verifySuccessMsg();
		updateIECodePage.validateBackToOverview();
	}

}