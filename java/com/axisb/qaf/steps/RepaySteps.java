package com.axisb.qaf.steps;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.axisb.qaf.exceptions.customElementFoundException;
import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.pages.AddNewBeneficiaryPage;
import com.axisb.qaf.pages.RepayPage;
import com.axisb.qaf.pages.SinglePaymentPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;


public class RepaySteps extends WebDriverTestCase {
	RepayPage RepayPage = new RepayPage();
	AddNewBeneficiaryPage addNewBeneficiaryPage = new AddNewBeneficiaryPage();
	@QAFTestStep(description = "user get details of payment and click on repay")
	public void user_get_details_of_payment_and_click_on_repay() throws Exception {
		RepayPage.repay();
	}
	
	@QAFTestStep(description = "user verifies payment details {0}")
	public void user_verifies_payment_details(List<Map<String, String>> paymentDetails) throws Exception {
		Thread.sleep(10000);
		RepayPage.verifyPaymentDetails(paymentDetails);
	}
	
	@QAFTestStep(description="user selects payment name to Repay {0}")
	public void userSelectsPaymentNameToRepay(List<Map<String, String>> paymentDetails) throws customElementFoundException, customElementNotClickableException, customElementNotFoundException, InterruptedException{
		RepayPage.paymentClick(paymentDetails);
	}
	
}
