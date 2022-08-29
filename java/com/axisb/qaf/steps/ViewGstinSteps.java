package com.axisb.qaf.steps;

import java.awt.AWTException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.pages.ViewGstinPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class ViewGstinSteps extends WebDriverTestCase {

	ViewGstinPage viewGstinPage = new ViewGstinPage();

	@QAFTestStep(description="user clicks on View GSTIN,approved tab select gstin and click delink button")
	public void user_clicks_on_view_gstin() throws Exception{
		viewGstinPage.clickViewGstin();
	}
	
	@QAFTestStep(description="user clicks on view rule, select rules, approver and enter Remarks{0}")
	public void user_clicks_on_view_rule_and_click_delink(List<Map<String,String>>ruleapply) throws Exception {
		viewGstinPage.delinkConfirm(ruleapply);
	}
	
	@QAFTestStep(description="user click on Delink button")
	public void user_click_on_delink_button() throws Exception {
       viewGstinPage.clickDelinktoConfirm();
	}
	
	@QAFTestStep(description="Delink toastmessage is displayed")
	public void delink_toastmessage_is_displayed() throws Exception {
		viewGstinPage.getDelinkToastMsg();
	}

// Pending tab step implementation 
	
	@QAFTestStep(description= "user clicks on View GSTIN,pending tab select gstin and click remind")
	public void user_clicks_pending_tab_select_gstin_and_click_remind() throws Exception {
		viewGstinPage.clickRemindButton();
	}

	@QAFTestStep(description= "remind toastmessage is displayed")
	public void remind_toastmessage_is_displayed() throws Exception {
		viewGstinPage.remindToastMsg();
	}

	@QAFTestStep(description="user clicks on View GSTIN, penidng tab select gstins and click delete")
	public void user_clicks_penidng_tab_select_gstins_and_click_delete() throws Exception {
	    viewGstinPage.deleteGstin();
	}
	
	@QAFTestStep(description="delete toastmessage is displayed")
	public void delete_toastmessage_is_displayed() throws Exception {
	    viewGstinPage.getDeleteToastMsg();
	}

	@QAFTestStep(description="user clicks on View GSTIN,Rejected tab and select gstindetail  and click remove from list")
	public void user_clicks_rejected_tab_and_select_gstindetail_and_click_remove_from_list() throws Exception {
	    viewGstinPage.RemoveRejectedGstin();
	}

	@QAFTestStep(description="reject toastmessage is displayed")
	public void reject_toastmessage_is_displayed() throws Exception {
	    viewGstinPage.rejectToastMsg();
	}
	
	@QAFTestStep(description="user clicks on View GSTIN,Delinked tab and select gstin and click relink")
	public void user_clicks_Delinked_tab_and_select_gstin_and_click_relink() throws Exception {
		viewGstinPage.relinkGstin();
	}
	
	@QAFTestStep(description="user selects rules and approver enter Remarks{0}")
	public void user_selects_rule_and_approver_enter_remarks_and_selects_relink(List<Map<String,String>> relinkRule) throws Exception {
		viewGstinPage.relinkConfirmrule(relinkRule);
	}
	@QAFTestStep(description="user click on Relink button")
	public void user_click_on_Relink_button() throws Exception {
		viewGstinPage.clickRelinktoConfirm();
	}
	@QAFTestStep(description="relink toast message is displayed")
	public void relink_toast_message_is_displayed(){
		
	}
}
