package com.axisb.qaf.steps;


import java.util.List;
import java.util.Map;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.pages.AddNewBeneficiaryPage;
import com.axisb.qaf.pages.AddToMasterPage;
import com.axisb.qaf.pages.GstinMasterReportsPage;
import com.axisb.qaf.pages.LoginPage;

import io.cucumber.datatable.DataTable;

public class GstinMasterReportsSteps extends WebDriverTestCase {

	GstinMasterReportsPage gstinmasterreportspage = new GstinMasterReportsPage();

	@QAFTestStep(description = "user clicks on Reports,GSTIN Master Reports")
	public void user_clicks_on_reports_and_clicks_gstin_master_reports() throws Exception {
		gstinmasterreportspage.clickGstinReports();
	}
	
	@QAFTestStep(description = "user selects Last one week from Calendar,clicks on Generate Reports, download to download the reports in PDF format")
	public void user_selects_last_weak_from_calendar() throws Exception {
		gstinmasterreportspage.selectLastOneWeek();
	}

	@QAFTestStep(description ="user selects Last one Month from Calendar,clicks on Generate Reports,download to download the reports in PDF format")
	public void user_selects_last_month_from_calendar() throws Exception {
		gstinmasterreportspage.selectLastOneMonth();
	}

	@QAFTestStep(description ="user selects Last three Months from Calendar,clicks on Generate Reports,download to download three months reports in PDF format")
	public void user_selects_last_three_months_from_calendar() throws Exception {
		gstinmasterreportspage.selectLastThreeMonths();
	}

	@QAFTestStep(description ="user enters start date and end date,clicks on Generate Reports{0}")
	public void user_enters_start_date_and_end_date(List<Map<String,String>> date) throws Exception {
		gstinmasterreportspage.startdateEndDate(date);
	}

	@QAFTestStep(description= "user clicks on customize button to select columns and clicks on save changes{0}")
	public void user_clicks_on_customize_button_to_select_columns_and_clicks_on_save_changes(List<Map<String,String>> columns) throws Exception {
		gstinmasterreportspage.customizeColumns(columns);
	}

	@QAFTestStep(description= "user enters template name and clicks on save as new template:{template}")
	public void user_enters_template_name_and_clicks_on_save_as_new_template(List<Map<String,String>> customize) throws Exception {
		gstinmasterreportspage.customizeChanges(customize);
	}

	@QAFTestStep(description = "user enters start date end date Pan State InitiatedBy Gstin status Template{0}")
	public void user_enters_enters_details_such_as_start_date_end_date_from_calendar(List<Map<String, String>> details)
			throws Exception {
		gstinmasterreportspage.allDetails(details);
	}
	
	@QAFTestStep(description ="user clicks on Generate Reports, download to download the reports in PDF format")
	public void user_clicks_on_generate_reports_download_to_download_the_reports_in_pdf_format() throws Exception {
		gstinmasterreportspage.clickGenerate();
	}

	@QAFTestStep(description = "user clicks on custom template,selects options to add to template{0}")
	public void user_clicks_on_custom_template(List<Map<String,String>> options) throws Exception {
		gstinmasterreportspage.customizeTemplate(options);
	}

	@QAFTestStep(description ="user clicks on save button and enters name and clicks on save as new template:{name}")
	public void user_clicks_on_save_button_and_enters_name_and_clicks_on_save_as_new_template(List<Map<String,String>> name) throws Exception {
		gstinmasterreportspage.saveNewTemplate(name);
	}

	@QAFTestStep(description = "user clicks on custom template,selects a Template and clicks on delete icon:{Template}")
	public void user_selects_a_Template_and_clicks_on_delete_icon(List<Map<String, String>> templates)
			throws InterruptedException, customElementNotClickableException, customElementNotFoundException {
		gstinmasterreportspage.deleteTemplate(templates);
	}

	@QAFTestStep(description = "user clicks on Delete button")
	public void user_clicks_on_delete_button() throws Exception {
		gstinmasterreportspage.clickDeleteButton();
	}

	@QAFTestStep(description = "template successfully deleted toast message is displayed")
	public void template_successfully_deleted_toast_message_is_displayed() throws Exception {
		gstinmasterreportspage.getDeleteToastMsg();
	}
	
	@QAFTestStep(description ="user clicks on download to download the reports in PDF format")
	public void user_clicks_on_download_to_download_the_reports_in_PDF_format() throws Exception {
		gstinmasterreportspage.clickToDownload();
	}
	
	@QAFTestStep(description ="user verifies the pdf downloaded")
	public void user_verifies_the_pdf_downloaded() {
		gstinmasterreportspage.verifyFileDownload();
	}
	
	@QAFTestStep(description ="user selects start data and end date and successful status, clicks on Generate Reports,download to download three months reports in PDF format{0}")
	public void user_selects_successful_status_clicks_on_generate_reports_download_to_download_three_months_reports_in_pdf_format(List<Map<String, String>>  success) throws Exception {
	   gstinmasterreportspage.statusDate(success);
		gstinmasterreportspage.selectStatus(success);    
	}

	@QAFTestStep(description ="user selects start data and end date and pending status, clicks on Generate Reports,download to download three months reports in PDF format{0}")
	public void user_selects_start_data_and_end_date_and_pending_status_clicks_on_generate_reports_download_to_download_three_months_reports_in_pdf_format(List<Map<String, String>>  pending) throws Exception {
		gstinmasterreportspage.statusDate(pending);
		gstinmasterreportspage.selectStatus(pending);
	}

	@QAFTestStep(description ="user selects start data and end date and expired status, clicks on Generate Reports,download to download three months reports in PDF format{0}")
	public void user_selects_start_data_and_end_date_and_expired_status_clicks_on_generate_reports_download_to_download_three_months_reports_in_pdf_format(List<Map<String, String>>  expired) throws Exception {
		gstinmasterreportspage.statusDate(expired);
		gstinmasterreportspage.selectStatus(expired);
	}
}