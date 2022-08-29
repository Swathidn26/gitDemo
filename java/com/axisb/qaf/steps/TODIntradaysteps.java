package com.axisb.qaf.steps;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.axisb.qaf.exceptions.customElementFoundException;
import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.pages.TodIntradayFlowPage;
import com.axisb.qaf.pages.UpdateIECodePage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;

import io.cucumber.datatable.DataTable;

public class TODIntradaysteps extends WebDriverTestBase {
	TodIntradayFlowPage todIntradayFlowPage = new TodIntradayFlowPage();
	UpdateIECodePage updateIECodePage = new UpdateIECodePage();
	
	@QAFTestStep(description="user clicks on initiate new request and click Intraday/TOD request")
	public void user_clicks_on_initiate_new_request_and_click_intraday_or_tod_request() throws  Exception {
		todIntradayFlowPage.clickNewRequest();
	    todIntradayFlowPage.clickTODorIntraday();    
	}

	@QAFTestStep(description="select customerID eligible for intraday or TOD{0}")
	public void select_customer_id_eligible_for_intraday_or_tod(List<Map<String,String>> customer) throws Exception {
		todIntradayFlowPage.selectCustomerID(customer);    
	}

	@QAFTestStep(description="SR type should be Intraday by default")
	public void sr_type_should_be_intraday_by_default() throws customElementNotFoundException, InterruptedException {
		todIntradayFlowPage.intradaydefaulted();
	}
	
	@QAFTestStep(description="select customerID and fill the form to proceed{0}")
	public void select_customer_id_and_fill_the_form_to_proceed(List<Map<String,String>> formData) throws InterruptedException, customElementNotClickableException, customElementNotFoundException, Exception {
		todIntradayFlowPage.selectCustomerID(formData);
		todIntradayFlowPage.fillIntradayForm(formData);
	}
	
	@QAFTestStep(description="user enters RM email IDs{0}")
	public void user_enters_rm_s_email_ids(List<Map<String,String>> emailIds) throws customElementNotClickableException, customElementNotFoundException {
		todIntradayFlowPage.enterEmailId(emailIds);
	}
	
	@QAFTestStep(description="review page should be available with rule and T&C")
	public void review_page_should_be_available_with_rule_and_t_c() throws Exception {
		todIntradayFlowPage.selectRuleandTC();
	}
	
	@QAFTestStep(description="request should be submitted successfully")
	public void request_should_be_submitted_successfully() throws Exception {
		todIntradayFlowPage.validateSuccessPage();
	}
	

	@QAFTestStep(description="entity name, ID or TOD account number, charges account number is prefilled")
	public void entity_name_id_or_tod_account_number_charges_account_number_should_be_prefilled() {
		todIntradayFlowPage.validatePreFilledDetailForm();
	}
	
	@QAFTestStep(description="verify required date cannot be more than {int} days from current date")
	public void verify_required_date_cannot_be_more_than_days_from_current_date(Integer days) throws Exception {
		todIntradayFlowPage.validateMaxDateAvailable(days);
	}

	@QAFTestStep(description="regularization date is not editable")
	public void verify_regularization_date_is_not_editable() throws Exception {
		todIntradayFlowPage.validateRegularizationDate();
	}
	
	@QAFTestStep(description="fill request for {int} day ahead from today's date{1}")
	public void submit_request_for_day_from_today_s_date(Integer day, List<Map<String,String>> formData) throws Exception {
		todIntradayFlowPage.submitWithMaxDate_Intraday(day, formData);
	}
	
	@QAFTestStep(description="verify message after adding maximum RM mail IDs{0}")
	public void verify_message_after_adding_maximum_rm_mail_i_ds(List<Map<String,String>> emailIds) throws Exception {
			todIntradayFlowPage.verifyMaxEmailIDs(emailIds);
	}
	
	@QAFTestStep(description="verify proceed button is disabled without adding RM mail ID")
	public void verify_proceed_button_is_disabled_without_adding_rm_mail_id() throws Exception {
		todIntradayFlowPage.verifyDisabledProceedBtn();
	}

	@QAFTestStep(description="select customerID having dormant or frozen account{0}")
	public void select_customer_id_having_dormant_or_frozen_account(List<Map<String,String>> customer) throws Exception {
		todIntradayFlowPage.selectCustomerID(customer);
	}
	
	@QAFTestStep(description="verify frozen or dormant message is displayed")
	public void verify_frozen_or_dormant_message_is_displayed() throws Exception {
		todIntradayFlowPage.verifyDormantFrozenMessage();
	}
	
	@QAFTestStep(description="select TOD and fill the form to proceed{0}")
	public void select_tod_and_fill_the_form_to_proceed(List<Map<String,String>> formData) throws Exception {
		todIntradayFlowPage.clickTODRadioBtn();
		todIntradayFlowPage.fillTODForm(formData);
	}
	
	@QAFTestStep(description="mode of regularization is disabled and selected by default")
	public void verify_mode_of_regularization_is_disabled_and_selected_by_default() throws Exception {
		todIntradayFlowPage.verifyModeofRegularization();
	}
	
	@QAFTestStep(description="select TOD request")
	public void select_tod_request() throws customElementNotClickableException, customElementNotFoundException {
		todIntradayFlowPage.clickTODRadioBtn();
	}

	@QAFTestStep(description="fill TOD request for {int} day ahead from today's date and regularization cannot be same as required date{1}")
	public void fill_tod_request_for_day_ahead_from_today_s_date_and_regularization_cannot_be_same_as_required_date(Integer day, List<Map<String,String>> formData) throws Exception {
		todIntradayFlowPage.fillFormandValidateDates(day, formData);
	}

	@QAFTestStep(description="verify regularization date can be {int} days from required date")
	public void verify_regularization_date_can_be_days_from_required_date(Integer day) throws Exception {
		todIntradayFlowPage.selectMaxTODRegularizationDate(day);
	}
	
	@QAFTestStep(description="click on back to overview button")
	public void click_on_back_to_overview_button() {
		todIntradayFlowPage.clickBackToOverview();
	}

	@QAFTestStep(description="user should be taken to overview page with submitted form ID in overview table")
	public void user_should_be_taken_to_overvierw_page_with_submitted_form_id_in_overview_table() throws Exception {
		todIntradayFlowPage.verifyOverviewPage();
	}
}
