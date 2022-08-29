package com.axisb.qaf.steps;
import java.util.List;
import java.util.Map;
import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.pages.AddNewBeneficiaryPage;
import com.axisb.qaf.pages.AddToMasterPage;
import com.axisb.qaf.pages.LoginPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import io.cucumber.datatable.DataTable;

public class AddtoMasterSteps extends WebDriverTestCase {

	AddToMasterPage addtoMasterPage = new AddToMasterPage();
	AddNewBeneficiaryPage addNewBeneficiaryPage = new AddNewBeneficiaryPage();
	LoginPage loginPage = new LoginPage();

	@QAFTestStep(description = "user enters {string} ssoKey")
	public void enterUserID(String userid) throws InterruptedException {
		/* loginPage.loginUsingSSO(userid); */
	}

	@QAFTestStep(description = "user clicks on payments and click new payments and GST ePayments")
	public void user_clicks_on_payments_and_click_new_payments_and_gst_e_payments() throws Exception {
		addtoMasterPage.clickGstPayments();
	}

	@QAFTestStep(description = "user clicks on register gstin")
	public void user_clicks_on_register_gstin() throws Exception {
		addtoMasterPage.clickRegisterGSTIN();
	}

	@QAFTestStep(description = "user clicks on Discover GSTIN")
	public void user_clicks_on_discover_gstin() throws Exception {
		addtoMasterPage.discoverGSTIN();
	}

	@QAFTestStep(description = "Toast message is displayed")
	public void toast_message_is_displayed() {
		addtoMasterPage.verifydiscovermessage();
	}

	@QAFTestStep(description = "user clicks on view modify selects rule and approver and add remarks and click save{0}")
	public void user_clicks_on_view_modify_selects_rule_and_approver_and_add_remark_and_click_save(
			List<Map<String, String>> ruleapplicableDetails) throws Exception {
		addtoMasterPage.clickViewRule(ruleapplicableDetails);
	}

	@QAFTestStep(description = "User selects gstin and clicks add to master button")
	public void user_search_pan_and_selects_gstin() throws Exception {
		addtoMasterPage.selectPanGstin();
	}

	@QAFTestStep(description = "success Toast message is displayed")
	public void success_toast_message_is_displayed() throws Exception {
		addtoMasterPage.getAddtoMasterToastMsg();
	}

}
