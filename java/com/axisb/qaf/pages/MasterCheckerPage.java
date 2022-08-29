package com.axisb.qaf.pages;

import static org.testng.Assert.assertEquals;

import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.utils.CommonUtility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qmetry.qaf.automation.step.WebElementStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class MasterCheckerPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 50);

	@FindBy(locator = "xpath=//*[@id='payments']/div/span")
	private QAFWebElement payments;

	@FindBy(locator = "xpath=(//*[@id=\"paymentsSub6\"])[1]")
	private QAFWebElement pendingApproval;

	@FindBy(locator = "xpath=//span[contains(text(),'Statutory')]/ancestor::button")
	private QAFWebElement statutory;

	@FindBy(locator = "xpath=//span[contains(text(),'Proceed')]")
	private QAFWebElement proceedBtn;

	@FindBy(locator = "xpath=//span[contains(text(),'Submit')]")
	private QAFWebElement submitBtn;

	@FindBy(locator = "xpath=(//span[text()='Submit'])[2]")
	private QAFWebElement otpSubmit;

	@FindBy(locator = "xpath=//p[text()='Your Request Is Submitted']")
	private QAFWebElement SubmitSuccess;

	@FindBy(locator = "xpath=//*[@id=\"__next\"]/div/main/main/div/div[1]/div[1]/div/div/p")
	private QAFWebElement confirmMsg;

	@FindBy(locator = "xpath=//*[@id='alert-dialog-slide-description']/div[2]/div")
	private QAFWebElement otp_enter;
	
	@FindBy(locator="xpath=//span[text()='Back to Dashboard']")
	private QAFWebElement backToDashboard;
	
//	@FindBy(locator="xpath=//span[text()='GST Payments']")
//	private QAFWebElement gstePayments;
	
	@FindBy(locator="xpath=//span[text()='Payments']/ancestor::a")
	private QAFWebElement paymentsLink;
	
	@FindBy(locator="xpath=//span[text()='GST Payments']/ancestor::a")
	private QAFWebElement gstpaymentsLink;
	
	@FindBy(locator="xpath=((//div[@id='actions'])[1]//ancestor::div)[21]")
	private QAFWebElement actionselect;
	
	@FindBy(locator="xpath=//span[text()='Approve']")
	private QAFWebElement approveSelecet;
	
	@FindBy(locator="xpath=//span[text()='Reject']")
	private QAFWebElement rejectSelect;
	
	
	public void gstPayments() throws Exception {
		boolean statutoryflag = CommonUtility.cVerifyElementIsPresent(driver, statutory, 3);
		if(statutoryflag==true) {
		CommonUtility.cClick(driver, statutory);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 20);
		Validator.assertTrue(statutoryflag, "Failed to click on Statutory tab", "Successfully clicked on Statutory tab");
		}
		else {
			Validator.assertTrue(statutoryflag, "Failed to click on Statutory tab", "Successfully clicked on Statutory tab");
		}
	}

	public void selectGstinApprove() throws Exception {
		boolean actionflag = CommonUtility.cVerifyElementIsPresent(driver, actionselect, 3);
		if(actionflag==true) {
		CommonUtility.cMoveToElementByTarget(driver, actionselect);
		Thread.sleep(3000);
		CommonUtility.cClick(driver, actionselect);
		Validator.assertTrue(actionflag, "Failed to click on Action tab", "Action tab was clicked successfully");
		}
		else {
			Validator.assertTrue(actionflag, "Failed to click on Action tab", "Action tab was clicked successfully");
		}
		Thread.sleep(3000);
		
		boolean approveflag = CommonUtility.cVerifyElementIsPresent(driver, approveSelecet, 3);
		if(approveflag==true) {
		CommonUtility.cClick(driver, approveSelecet);
		Validator.assertTrue(approveflag, "Failed to select Approve option from dropdown", "Approve was selected successfully from dropdown");
		}
		else {
			Validator.assertTrue(approveflag, "Failed to select Approve option from dropdown", "Approve was selected successfully from dropdown");
		}
		
		boolean proceedflag = CommonUtility.cVerifyElementIsPresent(driver, proceedBtn, 3);
		if(proceedflag==true) {
		CommonUtility.cClick(driver, proceedBtn);
		Validator.assertTrue(proceedflag, "Failed to click Proceed button", "Proceed button was clicked successfully");
		}
		else {
			Validator.assertTrue(proceedflag, "Failed to click Proceed button", "Proceed button was clicked successfully");
		}
		boolean submitflag = CommonUtility.cVerifyElementIsPresent(driver, submitBtn, 3);
		if(submitflag==true) {
		CommonUtility.cClick(driver, submitBtn);
		Validator.assertTrue(submitflag, "Failed to click on submit button", "Submit button was clicked successfully");
		}
		else {
			Validator.assertTrue(submitflag, "Failed to click on submit button", "Submit button was clicked successfully");
		}
	}

	public void selectGstinReject() throws Exception {
		boolean actionflag = CommonUtility.cVerifyElementIsPresent(driver, actionselect, 3);
		if(actionflag==true) {
		CommonUtility.cMoveToElementByTarget(driver, actionselect);
		Thread.sleep(3000);
		CommonUtility.cClick(driver, actionselect);
		Validator.assertTrue(actionflag, "Failed to click on Action tab", "Action tab was clicked successfully");
		}
		else {
			Validator.assertTrue(actionflag, "Failed to click on Action tab", "Action tab was clicked successfully");
		}
		boolean rejectflag = CommonUtility.cVerifyElementIsPresent(driver, rejectSelect, 3);
		if(rejectflag==true) {
		CommonUtility.cClick(driver, rejectSelect);
		Validator.assertTrue(rejectflag, "Failed to select Reject from dropdown", "Reject option was selected successfully");
		}
		else {
			Validator.assertTrue(rejectflag, "Failed to select Reject from dropdown", "Reject option was selected successfully");
		}
		boolean proceedflag = CommonUtility.cVerifyElementIsPresent(driver, proceedBtn, 3);
		if(proceedflag==true) {
		CommonUtility.cClick(driver, proceedBtn);
		Validator.assertTrue(proceedflag, "Failed to click Proceed button", "Proceed button was clicked successfully");
		}
		else {
			Validator.assertTrue(proceedflag, "Failed to click Proceed button", "Proceed button was clicked successfully");
		}
		boolean submitflag = CommonUtility.cVerifyElementIsPresent(driver, submitBtn, 3);
		if(submitflag==true) {
		CommonUtility.cClick(driver, submitBtn);
		Validator.assertTrue(submitflag, "Failed to click on submit button", "Submit button was clicked successfully");
		}
		else {
			Validator.assertTrue(submitflag, "Failed to click on submit button", "Submit button was clicked successfully");
		}
	}

	public QAFWebElement enter_Otp() {
		return otp_enter;
	}

	public void submitButton(String otp_Details) throws InterruptedException {
		submitBtn.click();
		Thread.sleep(2000);
		WebElement otpclick = driver.findElement(By.xpath("//*[@id='alert-dialog-slide-description']/div[2]/div/div[1]/input"));
		otpclick.click();
		otpclick.sendKeys(otp_Details);
		Thread.sleep(3000);
		otpSubmit.click();
		Assert.assertEquals(true, SubmitSuccess.isDisplayed());
		Thread.sleep(2000);
		backToDashboard.click();
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	}

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub
	}
}
