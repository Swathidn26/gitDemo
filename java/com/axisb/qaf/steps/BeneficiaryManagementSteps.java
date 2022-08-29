package com.axisb.qaf.steps;

import java.util.List;
import java.util.Map;

import com.axisb.qaf.exceptions.customElementFoundException;
import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.pages.AddNewBeneficiaryPage;
import com.axisb.qaf.pages.BeneficiaryManagementPage;
import com.axisb.qaf.pages.SinglePaymentPage;
import com.axisb.qaf.utils.CommonUtility;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class BeneficiaryManagementSteps extends WebDriverTestCase {
	
	AddNewBeneficiaryPage addNewBeneficiaryPage=new AddNewBeneficiaryPage();
	BeneficiaryManagementPage beneficiarymanagementpage=new BeneficiaryManagementPage();
	SinglePaymentPage singlePaymentPage = new SinglePaymentPage();
	
	@QAFTestStep(description = "user enter corpid and corpuname{0}")
	public void user_enter_corpid_and_corpuname(List<Map<String, String>> loginDetails)throws Exception {
		addNewBeneficiaryPage.login(loginDetails);
	}

	@QAFTestStep(description = "clicks on login button")
	public void clicks_on_login_button() throws Exception {
		addNewBeneficiaryPage.clickLoginButton();
	}

	@QAFTestStep(description = "user clicks on Payments tab")
	public void user_clicks_on_payments_tab()throws Exception {
		addNewBeneficiaryPage.clickPayments();
	}
	@QAFTestStep(description = "user clicks on VendorPayment")
	public void user_clicks_on_vendor_payment() throws Exception{
		addNewBeneficiaryPage.clickPayments();
	}

	@QAFTestStep(description ="user clicks on Beneficiary Management link")
	public void user_clicks_on_beneficiary_management_link() throws Exception {
		beneficiarymanagementpage.clickBeneManagement();
	}
	
	@QAFTestStep(description ="user clicks on disabled beneficiary tab")
	public void user_clicks_on_disabled_beneficiaries_tab() throws Exception {
		beneficiarymanagementpage.clickDisabledBeneficaries();
	}
	
	@QAFTestStep(description ="user clicks on pending beneficiary tab")
	public void user_clicks_on_pending_beneficiaries_tab() throws Exception {
		beneficiarymanagementpage.clickPendingBeneficaries();
	}
	
	@QAFTestStep(description ="user verifies the beneficiary tab total count")
	public void beneficiary_tab_total_count() throws Exception {
		beneficiarymanagementpage.verify_beneficiaries_total_count();
	}
	
	@QAFTestStep(description ="user verifies the disabled beneficiary tab total count")
	public void disabled_Beneficiary_tab_total_count() throws Exception {
		beneficiarymanagementpage.verify_disabled_beneficiaries_total_count();
	}
	
	@QAFTestStep(description ="user verifies the pending beneficiary tab total count")
	public void pending_Beneficiary_tab_total_count() throws Exception {
		beneficiarymanagementpage.verify_pending_beneficiaries_total_count();
	}
	
	
	
	
	
	@QAFTestStep(description="user select disabled Beneficiaries in the Disabled Beneficiary tab and make Enable")
	public void userSelectDisabledBeneficiariesInTheDisabledBeneficiaryTabAndMakeEnable() throws Exception{
		beneficiarymanagementpage.selectDisabledBeneficary();
	}
	
	@QAFTestStep(description="user select any Beneficairies from the Bene List which makepayment is done and Deletes it{0}")
public void userSelectAnyBeneficairiesFromTheBeneListWhichMakePaymentIsDoneAndDeletesIt(Map<String, String> deletedbenedetails) throws Exception{
		beneficiarymanagementpage.deletePaymentBeneficary(deletedbenedetails);
	}
	
	@QAFTestStep(description="user select any Beneficairies from the Bene List Deletes it{0}")
	public void userSelectAnyBeneficairiesFromTheBeneListAndDeletesIt(Map<String, String> deletedbenedetails) throws Exception{
			beneficiarymanagementpage.deleteBeneficary(deletedbenedetails);
		}
	
	@QAFTestStep(description="user select any Beneficairies from the Bene List and makePayment{0}")
	public void userSelectAnyBeneficairiesFromTheBeneListAndMakePayment(Map<String, String> makePayment) throws Exception{
			beneficiarymanagementpage.makePayment(makePayment);
		}
	@QAFTestStep(description="user select enabled Beneficiaries in the Total Beneficiary tab and make Disable")
	public void userSelectEnabledBeneficiariesInTheTotalBeneficiariesTabAndMakeDisable() throws Exception{
		beneficiarymanagementpage.selectEnabledBeneficary();	
	}
	@QAFTestStep(description="user select any Beneficairies from the Bene List and mark as Favourite")
	public void userSelectAnyBeneficairiesFromTheBeneListAndMarkAsFavourite() throws Exception{
		
		beneficiarymanagementpage.markFavouriteBeneficary();

	}
	
	@QAFTestStep(description="user select any Beneficairies from the Bene List and mark as UnFavourite")
	public void userSelectAnyBeneficairiesFromTheBeneListAndMarkAsUnFavourite() throws Exception{
		
		beneficiarymanagementpage.markUnFavouriteBeneficary();

	}
	@QAFTestStep(description="user verifies otp screen is visible")
	public void userVerifiesOtpScreenIsVisible() throws Exception{
		beneficiarymanagementpage.verifyOtp();
	}
	@QAFTestStep(description="user verifies alert message is visible")
	public void userVerifiesAlertMessageIsVisible() throws Exception{
		
		beneficiarymanagementpage.alertMessage();

	}
	@QAFTestStep(description = "enters below payment details{0}")
	public void userEnterPaymentDetails(List<Map<String, String>> PaymentDetails) throws Exception {
		Thread.sleep(9000);
		singlePaymentPage.enterPaymentDetails(PaymentDetails);	
	}
	
	@QAFTestStep(description = "user verifies summary page and clicks make payment")
	public void userVerifiesSummaryPageAndClicksMakePayment() throws Exception {
		Thread.sleep(9000);
		beneficiarymanagementpage.verifyMakePayment();	
	}
}