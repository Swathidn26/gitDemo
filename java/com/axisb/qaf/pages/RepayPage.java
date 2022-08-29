package com.axisb.qaf.pages;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.axisb.qaf.exceptions.customElementFoundException;
import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.utils.CommonUtility;
import com.qmetry.qaf.automation.core.AutomationError;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class RepayPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	public static String payTo;
	public static String amount_text;
	public static String status_field;
	public static String beneficiary_Bank;
	public static String debit_Account;
	public static String repay_button;
	
	@FindBy(locator = "xpath=//a[@class=' togg_menu']//span[text()='Payments']")
	private QAFWebElement payments_menu;

	@FindBy(locator = "xpath=//a[contains(text(),'Payments Overview')]")
	private QAFWebElement payments_overview; 
	
	@FindBy(locator = "xpath=//div[@id='mainTab']//div[text()='Pending']")
	private QAFWebElement pending_link; 

	@FindBy(locator = "xpath=//div[@id='mainTab']//div[text()='Successful']")
	private QAFWebElement successful_link;  
	
	@FindBy(locator = "xpath=//div[@id='mainTab']//div[text()='Rejected']")
	private QAFWebElement rejected_link;
	
	@FindBy(locator = "//table/tbody/tr/table/tbody/tr/td[2]")
	private List<WebElement> benelist; 
	
	@FindBy(locator = "xpath=//p[text()='Pay To']/following-sibling::p")
	private QAFWebElement pay_to; 
	
	@FindBy(locator = "xpath=//p[text()='Amount']/following-sibling::p")
	private QAFWebElement amount; 
	
	@FindBy(locator = "xpath=//p[text()='Status']/following-sibling::p")
	private QAFWebElement status; 
	
	@FindBy(locator = "xpath=//*[text()='Beneficiary Bank']/parent::div/following-sibling::div/div")
	private QAFWebElement beneficiary_bank; 
	
	@FindBy(locator = "xpath=//*[text()='Debit Account']/parent::div/following-sibling::div/div")
	private QAFWebElement debit_account; 
	
	@FindBy(locator = "xpath=//button/span[text()='Repay']")
	private QAFWebElement repay_btn; 

	@FindBy(locator = "xpath=//input[@id='transactionAmount']")
	private QAFWebElement amount_txt;
	
	@FindBy(locator = "xpath=//input[@id='frequencyType']")
	private QAFWebElement frequency_checkbox;
	
	@FindBy(locator = "xpath=//input[@id='totalNoOfInstances']")
	private QAFWebElement installments_txt;
	
	@FindBy(locator = "xpath=//input[@id='debitAccount']")
	private QAFWebElement from_dropdown;
	
	@FindBy(locator = "xpath=//input[@id='toAccountNum']")
	private QAFWebElement to_dropdown;
	
	@FindBy(locator = "xpath=//div[@id='tranRuleId']")
	private QAFWebElement ruleDropdown_dropdown;
	
	@FindBy(locator = "xpath=//div[3]/div[3]/div[2]/div/div[1]/div/div/div")
	private QAFWebElement approver_dropdown;

	@FindBy(locator = "xpath=//span[text()='Proceed']")
	private QAFWebElement proceed_btn;
	
	@FindBy(locator = "xpath=//div[text()='Recent Activity']/../div[4]/button[1]/span")
	private QAFWebElement filterList;
	
	@FindBy(locator = "xpath=//*[contains(text(),'Rejected')]/../div[1]")
	private QAFWebElement reject_count;
	
	@FindBy(locator = "xpath=//*[text()='Successful']/../div[1]")
	private QAFWebElement success_count;
	
	@FindBy(locator = "xpath=//small[contains(@class,'payment_error')]")
	private QAFWebElement fromAccountLimitError;
	
	@FindBy(locator = "xpath=//small[contains(@class,'error')]/span")
	private QAFWebElement fromAccountInsufficientError;
	
	@FindBy(locator = "xpath=//div[@id='mainTab']//div[text()='Failed']")
	private QAFWebElement failed_link;
	
	@FindBy(locator = "xpath=//*[contains(text(),'Failed')]/../div[1]")
	private QAFWebElement fail_count;
	
	public void paymentClick(List<Map<String,String>> paymentDetails)
			throws customElementFoundException, customElementNotClickableException, customElementNotFoundException, InterruptedException {
		CommonUtility.cWaitForPageLoad(driver);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 120);
		Thread.sleep(10000);
		if (paymentDetails.get(0).get("Scenario").equalsIgnoreCase("Successful")) {
			CommonUtility.cClick(driver, successful_link);
			String count = success_count.getText();
			if(count.equals("0"))
				throw new AutomationError("No success data available for this corporate in overview table");	
		}
		else if(paymentDetails.get(0).get("Scenario").equalsIgnoreCase("Rejected")){
			CommonUtility.cClick(driver, rejected_link);
			CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 10);
			String reject = reject_count.getText();
			if(reject.equals("0"))
			{
				throw new AutomationError("No rejected data available for this corporate in overview table");
			}		
		}
		else {
			CommonUtility.cClick(driver, failed_link);
			CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 10);
			String fail = fail_count.getText();
			if(fail.equals("0"))
			{
				throw new AutomationError("No failed data available for this corporate in overview table");
			}		
		}
		
		String reqTab = filterList.getText();
		if(reqTab.contains("Vendor"))
		{
			WebElement payment = CommonUtility.cFindElement(driver, By.xpath("//table/tbody/tr[1]/table/tbody/tr/td[2]"), 0);
			CommonUtility.cClick(driver, payment);		
		}else {
			throw new AutomationError("No "+paymentDetails.get(0).get("Scenario") + " vendor data found");
		}
	}
	
	public void repay() throws customElementNotClickableException, customElementNotFoundException {
		payTo = pay_to.getText();
		amount_text = amount.getText();
		status_field = status.getText();
		beneficiary_Bank = beneficiary_bank.getText();
		debit_Account = debit_account.getText();
		CommonUtility.cExplicitlyWait(driver, repay_btn, 10);
		CommonUtility.cClick(driver, repay_btn); 
	}
	
	public void verifyPaymentDetails(List<Map<String,String>> paymentDetails) throws Exception {
		CommonUtility.cExplicitlyWait(driver, amount_txt, 10);
		String amount = amount_txt.getAttribute("value");
		boolean flag1 = amount_text.replace("INR ", "").equals(amount);
		Validator.assertTrue(flag1, "Expected amount: "+ amount+ " Actual amount: "+amount_text+" Amount prepopulation mismatch", "Expected amount: "+ amount+ " Actual amount: "+amount_text+ " Amount prepopulated as expected");	
		
		String toAccount = to_dropdown.getAttribute("value");
		boolean flag2 =	toAccount.contains(payTo);
		Validator.assertTrue(flag2, "Expected To Account : "+payTo+ " Actual To Account: "+to_dropdown+" To account prepopulation mismatch", "Expected To Account : "+payTo+ " Actual To Account: "+to_dropdown+ " To account prepopulated as expected");
		
		String fromAccount = from_dropdown.getAttribute("value");
		boolean flag3 = fromAccount.contains(debit_Account);
		Validator.assertTrue(flag3, "Expected debit Account : "+debit_Account+ " Actual debit Account: "+fromAccount+" Debit account prepopulation mismatch", "Expected debit Account : "+debit_Account+ " Actual debit Account: "+fromAccount+ " Debit account prepopulated as expected");
		
	
		if(CommonUtility.cVerifyElementIsVisible(driver, fromAccountLimitError, 2))
		{
			throw new AutomationError("Flow cannot be continued due to error message :"+ fromAccountLimitError.getText());
		}
		else if(CommonUtility.cVerifyElementIsVisible(driver, fromAccountInsufficientError, 2)){
			throw new AutomationError("Flow cannot be continued due to error message :"+ fromAccountInsufficientError.getText());
		}
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 120);
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, ruleDropdown_dropdown);
		CommonUtility.cExplicitlyWait(driver, ruleDropdown_dropdown, 50);
		Thread.sleep(20000);
		CommonUtility.cClick(driver, ruleDropdown_dropdown);
		Thread.sleep(10000);
		CommonUtility.cClick(driver, ruleDropdown_dropdown); 
		Thread.sleep(10000);
		try {
		WebElement rulesApplicable = CommonUtility.cFindElement(driver, By.xpath("//*[@id='menu-tranRuleId']//div//ul//li//span[text()='"+paymentDetails.get(0).get("RulesApplicable")+"']"), 0);
		CommonUtility.cClick(driver, rulesApplicable);
		CommonUtility.cClick(driver, approver_dropdown);
		} catch (NoSuchElementException e) {
			Validator.assertTrue(false, "Rules drop down not loaded", "Rule selected");
		} 
		Thread.sleep(5000);
		WebElement approver = CommonUtility.cFindElement(driver, By.xpath("//*[@id='menu-']//div//ul//li//span[text()='"+paymentDetails.get(0).get("Approver1")+"']") , 0);
		CommonUtility.cClick(driver, approver);
		CommonUtility.cClick(driver, proceed_btn);
	}
	
	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}	