package com.axisb.qaf.steps;

import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.pages.AddNewBeneficiaryPage;
import com.axisb.qaf.pages.EpaymentMakerPage;
import com.axisb.qaf.pages.UpdateGstnPage;
import com.axisb.qaf.pages.UpdateIECodePage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class UpdateGstnSteps extends WebDriverTestCase {
	AddNewBeneficiaryPage addNewBeneficiaryPage=new AddNewBeneficiaryPage();
	EpaymentMakerPage ePaymentMaker=new EpaymentMakerPage();
	UpdateIECodePage updateIECodePage = new UpdateIECodePage();
	UpdateGstnPage updateGstnPage = new UpdateGstnPage();

	@QAFTestStep(description="user click on new request and gstn update")
	public void user_click_on_new_request_and_gstn_update() throws Exception {
		updateIECodePage.clickNewRequest();
		updateGstnPage.clickUpdateGstnBtn();}

	@QAFTestStep(description="user select the customer id as {customerId} and select one gstn")
	public void user_select_the_customer_id_as_and_select_one_gstn(String customerId) throws Exception {
		updateIECodePage.clickCustomerId(customerId);
		updateGstnPage.clickFirstGstn();
		updateGstnPage.clickDefaultGstn();
	}

	@QAFTestStep(description="user click on proceed button")
	public void user_click_on_proceed_button() throws Exception {
		updateIECodePage.clickProceedBtn();
	}

	@QAFTestStep(description="user click on proceed,selects the rule,terms and conditions and user clicks cancel button")
	public void user_click_on_proceed_selects_the_rule_terms_and_conditions_and_user_clicks_cancel_button() throws Exception {
		updateIECodePage.clickViewRuleBtn();
		updateIECodePage.clickRuleApplicable();
		updateGstnPage.clickCancel();
	}

	@QAFTestStep(description="pop up should be displayed whether to quit and and redirected to overview page.")
	public void pop_up_should_be_displayed_whether_to_quit_and_and_redirected_to_overview_page() throws Exception {
		updateGstnPage.clickPopupYes();
		updateGstnPage.validateOverviewPage();
	}

	@QAFTestStep(description="user click on proceed,selects the rule and does not click terms and conditions")
	public void user_click_on_proceed_selects_the_rule_and_does_not_click_terms_and_conditions() throws Exception {
		updateIECodePage.clickViewRuleBtn();
		updateGstnPage.clickRuleGen();
	}

	@QAFTestStep(description="submit button will not be enabled")
	public void submit_button_will_not_be_enabled() throws Exception {
		updateGstnPage.verifySubmit();
	}

	@QAFTestStep(description="user select the customer id as {customerId} and select one gstn as deafult")
	public void user_select_the_customer_id_as_and_select_one_gstn_as_deafult(String customerId) throws Exception {
		updateIECodePage.clickCustomerId(customerId);
		updateGstnPage.clickFirstGstn();
		updateGstnPage.clickDefaultGstn();
	}

	@QAFTestStep(description="user click on proceed,selects the rule,terms and conditions and user clicks submit button")
	public void user_click_on_proceed_selects_the_rule_terms_and_conditions_and_user_clicks_submit_button() throws Exception {
		updateIECodePage.clickViewRuleBtn();
		updateIECodePage.clickRuleApplicable();
		updateIECodePage.clickSubmit();
	}

	@QAFTestStep(description="Success message will be displayed and Back to overview will be enabled")
	public void success_message_will_be_displayed_and_back_to_overview_will_be_enabled() throws Throwable {
		updateGstnPage.verifySuccessMsgGstnUpdate();
		updateGstnPage.validateOverviewPage();
	}

	@QAFTestStep(description="user select the customer id as {customerId} and selects two gstns with no gstn as deafult")
	public void user_select_the_customer_id_as_and_selects_two_gstns_with_no_gstn_as_deafult(String customerId) throws Exception {
		updateIECodePage.clickCustomerId(customerId);
		updateGstnPage.clickFirstGstn();
		updateGstnPage.clickSecondGstn();
	}
}
