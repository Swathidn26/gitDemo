package com.axisb.qaf.steps;

import java.util.List;
import java.util.Map;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.pages.AddNewBeneficiaryPage;
import com.axisb.qaf.pages.LoginPage;
import com.axisb.qaf.pages.DEHLoginPage;
import com.axisb.qaf.pages.LoginwithOTPPage;

public class AddNewBeneficiarySteps extends WebDriverTestCase {
	AddNewBeneficiaryPage addNewBeneficiaryPage = new AddNewBeneficiaryPage();
	LoginwithOTPPage loginOTPPage = new LoginwithOTPPage();
	LoginPage loginPage = new LoginPage();
	DEHLoginPage dehLoginPage = new DEHLoginPage();

	@QAFTestStep(description = "user is on Login page{0}")
	public void user_is_on_Login_page(Map<String, String> loginDetails) throws Exception {
		if (loginDetails.get("Environment") == null) {
			addNewBeneficiaryPage.openUrl(loginDetails);
		} else if (loginDetails.get("Environment").equals("UAT")
				&& loginDetails.get("Path").equalsIgnoreCase("GST Payment")) {
			loginOTPPage.openUrl(loginDetails, loginOTPPage.getGstPaymentsLinkIDP());
			
		} else if (loginDetails.get("Environment").equals("UAT")
				&& loginDetails.get("Path").equalsIgnoreCase("Single Payment")) {
			loginOTPPage.openUrl(loginDetails, loginOTPPage.getSinglePaymentsLinkIDP());
			
		} else if (loginDetails.get("Environment").equals("UAT")
				&& loginDetails.get("Path").equalsIgnoreCase("Service Request")) {
			loginOTPPage.openUrl(loginDetails, loginOTPPage.getServiceRequestLinkIDP());
			
		} else if (loginDetails.get("Environment").equals("UAT") && loginDetails.get("Path").equalsIgnoreCase("TOD")) {
			loginOTPPage.openUrl(loginDetails, loginOTPPage.getTodIntradayLinkIDP());
			
		} else if (loginDetails.get("Environment").equals("UAT")
				&& loginDetails.get("Path").equalsIgnoreCase("Commercial Cards")) {
			loginOTPPage.openUrl(loginDetails, loginOTPPage.getCommercialCardLinkIDP());
			
		} else if (loginDetails.get("Environment").equals("UAT")
				&& loginDetails.get("Path").equalsIgnoreCase("Treasury")) {
			loginOTPPage.openUrl(loginDetails, loginOTPPage.getForexLinkIDP());

		}  else if (loginDetails.get("Environment").equals("DEHQA")
				&& loginDetails.get("Path").equalsIgnoreCase("Dashboard")) {
			dehLoginPage.openUrl(loginDetails, dehLoginPage.getDashboardMenu());

		} else if (loginDetails.get("Environment").equals("DEHQA")
				&& loginDetails.get("Path").equalsIgnoreCase("Service")) {
			dehLoginPage.openUrl(loginDetails, dehLoginPage.getServiceMenu());

		} else if (loginDetails.get("Environment").equals("DEHQA")
				&& loginDetails.get("Path").equalsIgnoreCase("Payments")) {
			dehLoginPage.openUrl(loginDetails, dehLoginPage.getPaymentsMenu());

		} else if (loginDetails.get("Environment").equals("DEHQA")
				&& loginDetails.get("Path").equalsIgnoreCase("Drafts")) {
			dehLoginPage.openUrl(loginDetails, dehLoginPage.getDraftsMenu());

		} else if (loginDetails.get("Environment").equals("DEHQA")
				&& loginDetails.get("Path").equalsIgnoreCase("Reports")) {
			dehLoginPage.openUrl(loginDetails, dehLoginPage.getReportsMenu());

		} else if (loginDetails.get("Environment").equals("DEHQA")
				&& loginDetails.get("Path").equalsIgnoreCase("Treasury")) {
			dehLoginPage.openUrl(loginDetails, dehLoginPage.getTreasuryMenu());

		} else if (loginDetails.get("Environment").equals("DEHQA")
				&& loginDetails.get("Path").equalsIgnoreCase("Commercial Cards")) {
			dehLoginPage.openUrl(loginDetails, dehLoginPage.getCommercialCardMenu());
			
		} else if (loginDetails.get("Environment").equals("DEHDEV")
				&& loginDetails.get("Path").equalsIgnoreCase("Dashboard")) {
			dehLoginPage.openUrl(loginDetails, dehLoginPage.getDashboardMenu());

		}else if (loginDetails.get("Environment").equals("DEHDEV")
				&& loginDetails.get("Path").equalsIgnoreCase("Service")) {
			dehLoginPage.openUrl(loginDetails, dehLoginPage.getServiceMenu());

		} else if (loginDetails.get("Environment").equals("DEHDEV")
				&& loginDetails.get("Path").equalsIgnoreCase("Payments")) {
			dehLoginPage.openUrl(loginDetails, dehLoginPage.getPaymentsMenu());

		} else if (loginDetails.get("Environment").equals("DEHDEV")
				&& loginDetails.get("Path").equalsIgnoreCase("Drafts")) {
			dehLoginPage.openUrl(loginDetails, dehLoginPage.getDraftsMenu());

		} else if (loginDetails.get("Environment").equals("DEHDEV")
				&& loginDetails.get("Path").equalsIgnoreCase("Reports")) {
			dehLoginPage.openUrl(loginDetails, dehLoginPage.getReportsMenu());

		} else if (loginDetails.get("Environment").equals("DEHDEV")
				&& loginDetails.get("Path").equalsIgnoreCase("Treasury")) {
			dehLoginPage.openUrl(loginDetails, dehLoginPage.getTreasuryMenu());

		} else if (loginDetails.get("Environment").equals("DEHDEV")
				&& loginDetails.get("Path").equalsIgnoreCase("Commercial Cards")) {
			dehLoginPage.openUrl(loginDetails, dehLoginPage.getCommercialCardMenu());
		
		}else {
			loginPage.loadAPI(loginDetails);
			addNewBeneficiaryPage.openUrl(loginDetails);
		}
	}

	public void userEnterCorpidAndCorpuname(List<Map<String, String>> loginDetails)
			throws customElementNotClickableException, customElementNotFoundException {
		addNewBeneficiaryPage.login(loginDetails);
	}

	@QAFTestStep(description = "clicks on login button")
	public void clicks_on_login_button() throws customElementNotClickableException, customElementNotFoundException {
		addNewBeneficiaryPage.clickLoginButton();
	}

	@QAFTestStep(description = "user should navigate to Dashboard page")
	public void user_should_navigate_to_dashboard_page() {
	}

	@QAFTestStep(description = "user clicks on Payments tab")
	public void user_clicks_on_payments_tab()
			throws customElementNotClickableException, customElementNotFoundException {
		addNewBeneficiaryPage.clickPayments();
	}

	@QAFTestStep(description = "user clicks on Beneficiary Management tab and clicks on Add New Beneficiary link")
	public void user_clicks_on_beneficiary_management_tab_and_clicks_on_add_new_beneficiary_link() throws Exception {
		addNewBeneficiaryPage.clickBeneManagement();
		addNewBeneficiaryPage.clickAddBeneficiary();
	}

	@QAFTestStep(description = "user should navigate to Beneficiary page")
	public void user_should_navigate_to_beneficiary_page() {
	}

	@QAFTestStep(description = "user clicks on AddNewBeneficiary")
	public void user_clicks_on_add_new_beneficiary() throws Exception {
		addNewBeneficiaryPage.clickAddBeneficiary();

	}

	@QAFTestStep(description = "user selects on AxisBank Account")
	public void userSelectsOnAxisBankAccount() throws Exception {
		addNewBeneficiaryPage.clickAxisBank();
	}

	@QAFTestStep(description = "user enter following details{0}")
	public void userEnterFollowingDetails(List<Map<String, String>> addNewBeneficiaryPageisbank) throws Exception {
		addNewBeneficiaryPage.enterAddNewBeneficiaryDetails(addNewBeneficiaryPageisbank);
	}

	@QAFTestStep(description = "user enter otherbank  details{0}")
	public void user_enter_otherbank_details(List<Map<String, String>> otherbank) throws Exception {
		addNewBeneficiaryPage.enterAddNewBeneficiaryDetails(otherbank);
	}

	@QAFTestStep(description = "user clicks on Proceed and Submit Button")
	public void user_clicks_on_proceed_and_submit_button() throws Exception {
		addNewBeneficiaryPage.clickProceed();
		addNewBeneficiaryPage.clickSubmit();
	}

	@QAFTestStep(description = "user Should able to see Beneficiary Managament Button")
	public void user_should_on_Beneficiary_button() throws Exception {
		addNewBeneficiaryPage.verifyBeneficiaryText();
	}

	@QAFTestStep(description = "Beneficary  should be created")
	public void beneficary_should_be_created() {
	}

}
