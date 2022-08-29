package com.axisb.qaf.steps;

import java.util.List;
import java.util.Map;
import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.pages.AddNewBeneficiaryPage;
import com.axisb.qaf.pages.SinglePaymentPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;


public class SinglePaymentSteps extends WebDriverTestCase {
	SinglePaymentPage singlePaymentPage = new SinglePaymentPage();
	AddNewBeneficiaryPage addNewBeneficiaryPage = new AddNewBeneficiaryPage();
	
	public static int totalvalue=0;
	
	@QAFTestStep(description="user clicks on NewPayment tab")
	public void userClicksOnNewPaymentTab() throws Exception{
		singlePaymentPage.clickNewPayments();
		singlePaymentPage.clickVendorPayments();
		Reporter.logWithScreenShot("Passed");
	}
	
	@QAFTestStep(description = "navigates to Single Payment Page")
	public void user_should_navigate_to_single_payment_page() throws customElementNotFoundException {
		singlePaymentPage.navigateToNewPayment();
	}

	@QAFTestStep(description = "user select IMPS Payment mode")
	public void user_select_imps_payment_mode() {
		singlePaymentPage.selectPaymentmode();
		singlePaymentPage.selectImpsmode();
	}

	@QAFTestStep(description = "enters below payment details{0}")
	public void userEnterPaymentDetails(List<Map<String, String>> PaymentDetails) throws Exception {
		Thread.sleep(9000);
		singlePaymentPage.enterPaymentDetails(PaymentDetails);	
	}
	
	@QAFTestStep(description="user clicks on Recurring Payment checkbox and select frequency type and installments{0}")
	public void userClicksOnRecurringPaymentCheckboxAndSelectFrequencyTypeAndInstallments(Map<String, String> recurringdetails) throws Exception{
		singlePaymentPage.enterRecurringPaymentDetails(recurringdetails);
	}
	@QAFTestStep(description="user selects any date after the current date{0}")
	public void userSelectsAnyDateAfterTheCurrentDate(Map<String, String> date) throws Exception{
		singlePaymentPage.selectDate(date);
	}
	@QAFTestStep(description = "user verifies Bank Payment is successfully completed")
	public void userVerifiesBankPayment() throws Exception {
		singlePaymentPage.verifyMakePayment();	
	}
	@QAFTestStep(description = "user clicks on Proceed Button")
	public void clickProceed() throws Exception {
		singlePaymentPage.clickProceed();	
	}
	@QAFTestStep(description = "user clicks on Proceed Button and Add New Payment Button")
	public void userClicksOnAddNewPaymentButton() throws Exception {
		singlePaymentPage.clickProceed();
		singlePaymentPage.clickAddNewPayment();
	}

	@QAFTestStep(description="user clicks on AddPayment Button and user validate multiple payment details")
	public void userClicksOnAddPaymentButton() throws Exception{
		singlePaymentPage.clickAddPayment();
		singlePaymentPage.validatemultiplePaymentDetails();
	}
	
	@QAFTestStep(description="user clicks on Copy and Validate copied details")
	public void userClicksOnCopyAndValidateCopiedDetails()throws Exception{
		singlePaymentPage.clickCopyButton();
		singlePaymentPage.validateCopyDetails();
	}
	@QAFTestStep(description="user clicks on Proceed Button and Validate summary page displayed details")
	public void userClicksOnProceedButtonAndValidateSummaryPageDisplayedDetails()throws Exception{
		singlePaymentPage.clickProceed();
		singlePaymentPage.clickViewmore();
		singlePaymentPage.validateSummaryDetails();
	}
	
	@QAFTestStep(description="user clicks on Edit and fill the remaining details{0}")
	public void enterRemainingDetails(List<Map<String, String>> PaymentDetails) throws Exception
	{
		singlePaymentPage.clickEditButton();
		singlePaymentPage.fromDropDown(PaymentDetails);
		singlePaymentPage.toDropDown(PaymentDetails);
		singlePaymentPage.clickOnRulesApplicable(PaymentDetails);
		
	}
	@QAFTestStep(description="user delete any one payments and verify delete toast message")
	public void userDeleteAnyOnePaymentsAndVerifyDeleteToastMessage() throws Exception{
		singlePaymentPage.deleteSingleTransaction();
	}
	@QAFTestStep(description="user clicks deletes all existing payments and verify delete toast message")
	public void clickDelete() throws Exception
      {
		singlePaymentPage.deleteMultipleTransaction();
      }
}