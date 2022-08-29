package com.axisb.qaf.steps;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.axisb.qaf.exceptions.customElementFoundException;
import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.pages.*;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class DraftsFlowSteps extends WebDriverTestCase {
	DraftsFlowPage draftsFlowPage = new DraftsFlowPage();
	AddNewBeneficiaryPage addNewBeneficiaryPage = new AddNewBeneficiaryPage();
	PaymentOverviewPage paymentOverviewPage = new PaymentOverviewPage();
	
	@QAFTestStep(description="user selects payment from Statutory payments and clicks on Recall Transaction{0}")
	public void userSelectsPaymentFromStatutoryPaymentsAndClicksOnRecallTransaction(Map<String, String> statutoryDetails)
		throws Exception{
		paymentOverviewPage.clickOnStatutoryTab();
		paymentOverviewPage.doStatutoryRecallTrasnsaction(statutoryDetails);
	}
	
	@QAFTestStep(description="user verifies payment is added to Drafts {0}")
	public void userVerifiesPaymentIsAddedToDrafts(List<Map<String, String>> expectedDraftName) throws Exception{
		draftsFlowPage.verifyDrafts(expectedDraftName);
	}
	
	@QAFTestStep(description = "user initiate new payment details{0}")
	public void userInitiateNewPaymentDetails(List<Map<String,String>> paymentDetails) throws Exception {
		draftsFlowPage.initiateNewPayment(paymentDetails);
	}
	
	@QAFTestStep(description = "user initiate new Error payment details{0}")
	public void userInitiateNewErrorPaymentDetails(List<Map<String,String>> paymentDetails) throws Exception {
		draftsFlowPage.enterErrorPaymentDetails(paymentDetails);
	}
	
	@QAFTestStep(description="user clicks on save as draft")
	public void userClicksOnSaveAsDraft() throws Exception{
		draftsFlowPage.saveAsDraft();
		draftsFlowPage.verifySaveAsDraftSuccessMsg();
	}
	
	@QAFTestStep(description="user clicks on proceed")
	public void userClicksOnProceed() throws Exception{
		draftsFlowPage.proceed();
	}
	
	@QAFTestStep(description="user selects any draft and delete {0}")
	public void userSelectsAnyDraftAndDelete(List<Map<String,String>> expectedValue) throws InterruptedException, customElementNotFoundException, customElementNotClickableException{
		draftsFlowPage.deleteDrafts(expectedValue);
	}
	
	@QAFTestStep(description="user verifies payment deleted")
	public void userVerifiesPaymentDeleted() throws Exception{
		draftsFlowPage.alertMessage();
	}
	
	@QAFTestStep(description="user selects Drafts tab and sort it from Old to New")
	public void userSelectsDraftsTabAndSortItFromOldToNew() throws Exception, InterruptedException, customElementNotFoundException, customElementNotClickableException{
		draftsFlowPage.sortDrafts();
		draftsFlowPage.sortDraftsOldToNew();
	}
	
	@QAFTestStep(description="user selects Drafts tab and sort it from New to Old")
	public void userSelectsDraftsTabAndSortItFromNewToOld() throws Exception, InterruptedException, customElementNotFoundException, customElementNotClickableException{
		draftsFlowPage.sortDrafts();
		draftsFlowPage.sortDraftsOldToNew();
		draftsFlowPage.sortDraftsNewToOld();
	}
	  @QAFTestStep(description="user verifies if saved Drafts are in sorted order") 
	  public void userVerifiesIfSavedDraftsAreInSortedOrder() throws Exception{
	    draftsFlowPage.sortedMaps(); }
	 
	
	@QAFTestStep(description="user clicks on Beneficiary Management")
	public void userClicksOnBeneficiaryManagement()throws Exception{
		addNewBeneficiaryPage.clickBeneManagement();
	}
	
	@QAFTestStep(description = "user clicks on AddNewBeneficiary")
	public void user_clicks_on_add_new_beneficiary() throws Exception {
		addNewBeneficiaryPage.clickAddBeneficiary();

	}
	
	@QAFTestStep(description = "user enter otherbank  details")
	public void userSelectsOnAxisBankAccount() throws Exception {
		addNewBeneficiaryPage.clickAxisBank();
	}
	
	@QAFTestStep(description = "user enter otherbank  details{0}")
	public void userEnterOtherbankDetails(List<Map<String, String>> addNewBeneficiaryPageisbank) throws Exception {
		addNewBeneficiaryPage.enterAddNewBeneficiaryDetails(addNewBeneficiaryPageisbank);
	}
	@QAFTestStep(description="user verifies RecallTransaction Success Message")
	public void userVerifiesRecallTransactionSuccessMessage() throws Exception{
		paymentOverviewPage.verifyRecallTransactionSuccessMsg();
	}	
}