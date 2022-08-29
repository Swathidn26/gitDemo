package com.axisb.qaf.steps;

import java.util.List;
import java.util.Map;

import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.pages.DEHBeneficiaryCheckerFlowPage;
import com.axisb.qaf.pages.DEHVendorCheckerFlowPage;
import com.qmetry.qaf.automation.step.QAFTestStep;

public class DEHBeneficiaryCheckerFlowSteps {

	
	DEHVendorCheckerFlowPage dehvendorcheckerflow = new DEHVendorCheckerFlowPage();
	DEHBeneficiaryCheckerFlowPage dehbeneficiarycheckerflow = new DEHBeneficiaryCheckerFlowPage();
	
	@QAFTestStep(description = "user lands on Payments page and navigates to Beneficiary to approve")
	public void user_lands_on_payments_page_and_navigates_to_beneficiary_to_approve() throws Exception {
		dehbeneficiarycheckerflow.clickBeneficiaryTab();
		dehvendorcheckerflow.selectBeneApprove();

	}
	
	@QAFTestStep(description = "user lands on Payments page and navigates to Beneficiary to  reject")
	public void user_lands_on_payments_page_and_navigates_to_beneficiary_to_reject() throws Exception {
		dehbeneficiarycheckerflow.clickBeneficiaryTab();
		dehvendorcheckerflow.selectBeneReject();
		
	}
	
	@QAFTestStep(description = "user lands on Payments page and navigates to Beneficiary and customizes by selecting columns options{0}")
	public void user_lands_on_payments_page_and_navigates_to_beneficiary_and_customizes_by_selecting_columns_options(List<Map<String, String>> options) throws Exception {
		dehbeneficiarycheckerflow.clickBeneficiaryTab();
		dehvendorcheckerflow.customizeOptions(options);
	}
	
	
	
	@QAFTestStep(description = "user lands on Payments page and navigates to Beneficiary and enters details in search bar and gets the data")
	public void user_lands_on_payments_page_and_navigates_to_beneficiary_and_enters_details_in_search_bar_and_gets_the_data() throws customElementNotFoundException, customElementNotClickableException, InterruptedException {
		dehbeneficiarycheckerflow.clickBeneficiaryTab();
		dehbeneficiarycheckerflow.searchbenetext();
	}
	
	
	@QAFTestStep(description = "user lands on Payments page and navigates to Beneficiary and  clicks on refresh button thrice")
	public void user_lands_on_payments_page_and_navigates_to_beneficiary_and_clicks_on_refresh_button_thrice() throws Exception {
		dehbeneficiarycheckerflow.clickBeneficiaryTab();
		dehvendorcheckerflow.clickRefreshThrice();

	}
	
	@QAFTestStep(description = "user lands on Payments page and navigates to Beneficiary and selects mutliple request to approve")
	public void user_lands_on_payments_page_and_navigates_to_beneficiary_and_selects_mutliple_request_to_approve() throws Exception {
		dehbeneficiarycheckerflow.clickBeneficiaryTab();
		dehvendorcheckerflow.mutlipleBeneApprove();
		
	}

	@QAFTestStep(description = "user lands on Payments page and navigates to Beneficiary and selects mutliple request to reject")
	public void user_lands_on_payments_page_and_navigates_to_beneficiary_and_selects_mutliple_request_to_reject() throws Exception {
		dehbeneficiarycheckerflow.clickBeneficiaryTab();
		dehvendorcheckerflow.mutlipleBeneReject();

	}
}
