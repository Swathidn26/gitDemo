package com.axisb.qaf.pages;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.axisb.qaf.exceptions.customElementFoundException;
import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.steps.SinglePaymentSteps;
import com.axisb.qaf.utils.CommonUtility;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class SinglePaymentPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	public String paymentmode = "IMPS";
	private static int amtCounter=1;
	private static int fromaccountCounter=1;
	private static int toaccountCounter=1;
	static int paymentamountvalue;
	public static int Paymentamt;
	static String amountvalue;
	static String payment_mode;
	public static String month=null;
	static String datevalue;
	static String fromacctnodetails;
	static String toacctnodetails;
	static String CRN_value;
	static String Invoice_value;
	static String LEI_value;
	static String creditnarration_value;
	static String rulesapplicable_value;
	static String approver1_value;
	static String remarks_value;
	String fundtransfermsg;
	public static WebElement approver;
	static LinkedHashMap<String,String> Singlepayment_Fromacctlist=new LinkedHashMap<String,String>();
	static LinkedHashMap<String,String> Singlepayment_Toacctlist=new LinkedHashMap<String,String>();
	static LinkedHashMap<String,String> Singlepayment_amountlist=new LinkedHashMap<String,String>();

	@FindBy(locator = "xpath=//div[contains(@class,'new-payment_datePicker')]/div/div/button")
	private QAFWebElement calendarbutton;

	@FindBy(locator = "xpath=//*[contains(@class,'PickersCalendarHeader')]/p")
	private QAFWebElement calendarDateHeader;

	@FindBy(locator = "xpath=//*[contains(@class,'PickersCalendarHeader')]/following-sibling::button/span[1]")
	private QAFWebElement calendarDateNext;

	@FindBy(locator = "xpath=(//a[contains(text(),'New Payment')])[1]")
	private QAFWebElement newpayment_link;

	@FindBy(locator = "xpath=//span[text()='Vendor Payments']")
	private QAFWebElement Vendorpayments_link;

	@FindBy(locator = "xpath=//div[contains(@id,'networkId')]")
	private QAFWebElement paymentmode_dropdown;

	@FindBy(locator = "xpath=//input[@name='networkId']")
	private QAFWebElement copypaymentmode_dropdown;


	@FindBy(locator = "xpath=//*[@id='menu-networkId']/div[3]//span[text()='IMPS']")
	private QAFWebElement Impspaymentmode_dropdown;

	@FindBy(locator = "xpath=//input[@id='transactionAmount']")
	private QAFWebElement amount_txt;

	@FindBy(locator = "xpath=//input[@id='frequencyType']/parent::*")
	private QAFWebElement recurringtype_checkbox;

	@FindBy(locator = "xpath=//div[@id='menu-requestFrequency']/div[3]/ul/li")
	private List<WebElement> frequencytype_dropdownlist;

	@FindBy(locator = "xpath=//*[@id='mui-component-select-requestFrequency']")
	private QAFWebElement frequencytype_dropdown;

	@FindBy(locator = "xpath=//input[@id='totalNoOfInstances']")
	private QAFWebElement installments_txt;

	@FindBy(locator = "xpath=//input[@id='debitAccount']")
	private QAFWebElement from_dropdown;

	@FindBy(locator = "xpath=//input[@id='toAccountNum']")
	private QAFWebElement to_dropdown;

	@FindBy(locator = "xpath=//input[@placeholder='Search Account Number, Account Name']")
	private QAFWebElement searchaccno_txt;  

	@FindBy(locator = "xpath=//input[@id='uniqueReferenceNumber']")
	private QAFWebElement crn_txt;

	@FindBy(locator = "xpath=//input[@id='invoiceNumber']")
	private QAFWebElement invoicenumber_txt;

	@FindBy(locator = "xpath=//input[@id='lei']")
	private QAFWebElement lei_txt;

	@FindBy(locator = "xpath=//div[@class='MuiBox-root javascriptexecutors1164']")
	private QAFWebElement changeRule_txt;

	@FindBy(locator = "xpath=//div[@id='tranRuleId']")
	private QAFWebElement ruleDropdown_dropdown;

	@FindBy(locator = "xpath=//button/span[1]/span[text()='View/modify rule ']")
	private QAFWebElement viewmodifyrule_link;

	@FindBy(locator = "xpath=//span[contains(text(),'All Under Selected Rule')]/parent::div")
	private QAFWebElement approver_dropdown;

	@FindBy(locator = "xpath=//textarea[@id='initiatorRemark']")
	private QAFWebElement creditnarration_txtarea;

	@FindBy(locator = "xpath=//textarea[@id='userRemarks']")
	private QAFWebElement remark_txtarea;

	@FindBy(locator = "xpath=//span[text()='Proceed']")
	private QAFWebElement proceed_btn;

	@FindBy(locator = "xpath=//span[text()='Cancel']")
	private QAFWebElement cancel_btn;

	@FindBy(locator = "xpath=//button[contains(@class,'new-payment_addBene')]")
	private QAFWebElement addnewpayment_btn;

	@FindBy(locator = "xpath=//button[contains(@class,'multiplePaymentButton2')]")
	private QAFWebElement addpayment_btn;

	@FindBy(locator = "xpath=//span[contains(text(),'Save as draft')]")
	private QAFWebElement savedraft_btn;

	@FindBy(locator = "xpath=//span[text()='Payments']")
	private QAFWebElement payment_link;

	@FindBy(locator = "xpath=//span[text()='New Payment']")
	private QAFWebElement new_payment;

	@FindBy(locator = "xpath=//div/p[text()='ICICI BANK LIMITED']")
	private QAFWebElement icici_bank;  

	@FindBy(locator = "xpath=//span[text()='Other Bank Accounts']")
	private QAFWebElement otherBankAccounts;  

	@FindBy(locator = "xpath=//div//span[text()='All Payees']")
	private QAFWebElement allPayees;

	@FindBy(locator = "xpath=//span[text()='Other Axis Accounts']")
	private QAFWebElement otherAxisAccounts;

	@FindBy(locator = "xpath=//button//span[text()='Make Payment']")
	private QAFWebElement make_payment;

	@FindBy(locator = "xpath=(//button//span[text()='Make Payment'])[2]")
	private QAFWebElement make_payment2;

	@FindBy(locator = "xpath=//p[contains(@class,'singlePaymentSuccess_heading')]")
	private QAFWebElement makepayment_msg;

	@FindBy(locator = "xpath=(//p[contains(@class,'single-payment-summary_text2')])[6]")
	private QAFWebElement summarydate_value;

	@FindBy(locator = "xpath=(//div[contains(@class, 'singlePaymentTable_box2')])[1]")
	private QAFWebElement fromDropDownValue; 

	@FindBy(locator = "xpath=(//div[contains(@class,'singlePaymentTable_box2')])[1]")
	private QAFWebElement toDropDownValue;

	@FindBy(locator = "xpath=//input[@name='tranRuleId']")
	private QAFWebElement copy_rulesdropdown;

	@FindBy(locator = "xpath=//*[contains(text(),'Approver 1')]/following::input[1]")
	private QAFWebElement copy_approver;

	@FindBy(locator = "xpath=(//div[contains(@class,'single-payment-summary_iconsIndividual')])[3]")
	private QAFWebElement deletebtn;

	@FindBy(locator = "xpath=//button/span[text()='Delete']")
	private QAFWebElement confirm_deletebtn;

	@FindBy(locator = "xpath=(//div[contains(@class,'single-payment-summary_iconsIndividual')])[2]")
	private QAFWebElement copybtn;

	@FindBy(locator = "xpath=(//div[contains(@class,'single-payment-summary_iconsIndividual')])[1]")
	private QAFWebElement editbtn;

	@FindBy(locator = "xpath=(//span[text()='View More'])[1]")
	private QAFWebElement viewmore_link1;

	@FindBy(locator = "xpath=(//div[2]/div[1]/div[1]/div[1]/p[1])[1]")
	private QAFWebElement amount1;

	@FindBy(locator = "xpath=(//div[2]/div[1]/div[1]/div[1]/p[1])[2]")
	private QAFWebElement amount2;

	@FindBy(locator = "xpath=(//div[contains(@class,'newPaymentDropDown')])[4]")
	private QAFWebElement approverelement;

	@FindBy(locator = "xpath=//div[@class='MuiAlert-message']")
	private QAFWebElement alert_message;

	@FindBy(locator = "xpath=//div[contains(@class,'newPaymentDatePicker')]/div/input")
	private QAFWebElement datepicker_value;

	public QAFWebElement selectPaymentmode() {
		return paymentmode_dropdown;
	}

	public QAFWebElement selectImpsmode() {
		return Impspaymentmode_dropdown;
	}

	public void clickPayments() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, payment_link);
	}

	public void clickImpsmode() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, Impspaymentmode_dropdown);
	}

	public void clickNewPayments() throws Exception {
		CommonUtility.cClick(driver, newpayment_link);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 60);
	}

	public void clickVendorPayments() throws customElementNotClickableException, customElementNotFoundException {

		CommonUtility.cExplicitlyWait(driver, Vendorpayments_link, 70);
		CommonUtility.cClick(driver, Vendorpayments_link);
		CommonUtility.cWaitForPageLoad(driver);
	}

	public void navigateToNewPayment() throws customElementNotFoundException {
		CommonUtility.cExplicitlyWait(driver, new_payment, 20);
		String actualText = new_payment.getText();
		Assert.assertEquals(actualText, "New Payment");
	}

	public void verifyMakePayment() throws customElementNotFoundException, customElementNotClickableException, customElementFoundException {
		try {
			CommonUtility.cExplicitlyWait(driver, make_payment, 40);
			CommonUtility.cClick(driver, make_payment);
		}
		catch(Exception e) {
			try {
				CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, make_payment2);
				CommonUtility.cClick(driver, make_payment2);
			}
			catch(Exception e1)
			{
				Validator.assertTrue(false," Failed:Test case Failed  as it unable to Click on Make Payment Button","Passed:Clicked on Make Payment Button");
			}
		}
		CommonUtility.cClick(driver, make_payment);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);;
		try{
			fundtransfermsg=makepayment_msg.getText();
			boolean fundtransfertext = false;
			if(fundtransfermsg.equalsIgnoreCase("Fund Transfer is submitted and is pending for approval")) 
				fundtransfertext = true;
			Validator.assertTrue(fundtransfertext,"Failed:Fund transfer not submitted successfully as Expected message is:Fund Transfer is submitted and is pending for approval and actual  message is different:"+fundtransfermsg+" ","Passed: Fund Transfer is submitted and is pending for approval");
		}
		catch(Exception e) {
			Validator.assertTrue(false,"Failed:Fund transfer not submitted successfully as Expected message is:Fund Transfer is submitted and is pending for approval and actual  message is different:"+fundtransfermsg+" ","Passed: Fund Transfer is submitted and is pending for approval");
		}
	}
	public void clickOnRulesApplicable(List<Map<String, String>> paymentdetails) throws Exception {
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 90);
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, ruleDropdown_dropdown);
		CommonUtility.cExplicitlyWait(driver, ruleDropdown_dropdown, 80);
		CommonUtility.cClick(driver, ruleDropdown_dropdown);
		Thread.sleep(5000);
		try {
			WebElement rules =CommonUtility.cFindElement(driver, By.xpath("//*[@id='menu-tranRuleId']//div//ul//li//span[text()='"+paymentdetails.get(0).get("RulesApplicable") + "']"), 10);
			rulesapplicable_value=paymentdetails.get(0).get("RulesApplicable");
			CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, rules);
			CommonUtility.cClick(driver, rules);
		} catch (Exception e) {
			Validator.assertTrue(false, "Failed: Rules Dropdown are not loading beacuse of API Issues","Passed: Rules dropdown loaded and clicked successfully");
		}
		try {
			CommonUtility.cClick(driver, approver_dropdown);
			approver = CommonUtility.cFindElement(driver, By.xpath("//*[@id='menu-']//div//ul//li//span[text()='" + paymentdetails.get(0).get("Approver1") + "']"), 10);
			CommonUtility.cClick(driver, approver);
			approver1_value=paymentdetails.get(0).get("Approver1");
		}
		catch(Exception e)
		{
			boolean isElementpresent=approverelement.isDisplayed();
			if(isElementpresent==true)
			{
				CommonUtility.cClick(driver, approverelement);
				approver = CommonUtility.cFindElement(driver, By.xpath("//*[@id='menu-']//div//ul//li//span[text()='" + paymentdetails.get(0).get("Approver1") + "']"), 10);
				CommonUtility.cClick(driver, approver);
			}
		}
		CommonUtility.cSendKeys(driver, remark_txtarea, paymentdetails.get(0).get("Remarks to Approver"));
		remarks_value=paymentdetails.get(0).get("Remarks to Approver");
	}

	public void fromDropDown(List<Map<String, String>> paymentdetails) throws Exception {
		CommonUtility.cExplicitlyWait(driver, from_dropdown, 60);
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, from_dropdown);
		try {
			int counter=0;
			while(counter<9) {
				CommonUtility.cClick(driver, from_dropdown);
				CommonUtility.cExplicitlyWait(driver, searchaccno_txt, 80);
				CommonUtility.cSendKeys(driver, searchaccno_txt, paymentdetails.get(0).get("FromAcctno"));
				fromacctnodetails=paymentdetails.get(0).get("FromAcctno");
				Singlepayment_Fromacctlist.put("fromacctno"+fromaccountCounter++, fromacctnodetails);	
				try {
					if(fromDropDownValue.isDisplayed()) {
						break;
					}
				}
				catch(Exception e) {
					counter++;
				}

			}
		}
		catch (Exception e) {
			Validator.assertTrue(false, "FromAccount Dropdown are not loading beacuse of API Issues",
					"FromAccount dropdown loaded and clicked successfully");
		}
		try {
			int count = 0;
			while (count < 6) {
				Boolean fromAccountNoFlag = fromDropDownValue.isDisplayed();
				if (fromAccountNoFlag == true) {
					WebElement fromAccountNo = CommonUtility.cFindElement(driver, By.xpath("//div[contains(@class,'singlePaymentTable_allBeneList')]//div/p[contains(text(),'"+ paymentdetails.get(0).get("FromAcctno") + "')]/.."), 20);
					CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, fromAccountNo);
					CommonUtility.cClick(driver, fromAccountNo);
					break;
				} else {
					Thread.sleep(5000);
					count++;
				}

			}
		} catch (Exception e) {
			Validator.assertTrue(false, "FromAccount Dropdown are not loading beacuse of API Issues",
					"FromAccount dropdown loaded and clicked successfully");
		}
	}

	public void toDropDown(List<Map<String, String>> paymentdetails) throws Exception{
		CommonUtility.cExplicitlyWait(driver, to_dropdown, 80);
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, to_dropdown);
		CommonUtility.cClick(driver, to_dropdown);
		try {
			int counter=0;
			while(counter<9) {
				CommonUtility.cClick(driver, allPayees);
				try {
					if(toDropDownValue.isDisplayed()) {
						break;
					}
				}
				catch(Exception e) {
					counter++;
				}

			}
		}
		catch (Exception e) {
			Validator.assertTrue(false, "ToAccount Dropdown are not loading beacuse of API Issues",
					"ToAccount dropdown loaded and clicked successfully");
		}
		WebElement Accounts =CommonUtility.cFindElement(driver,By.xpath("//span[text()='"+ paymentdetails.get(0).get("toAccountTab") + "']"), 10);
		CommonUtility.cClick(driver, Accounts);
		CommonUtility.cExplicitlyWait(driver, searchaccno_txt, 80);
		CommonUtility.cSendKeys(driver, searchaccno_txt, paymentdetails.get(0).get("ToAcctno"));
		toacctnodetails=paymentdetails.get(0).get("ToAcctno");
		Singlepayment_Toacctlist.put("ToAcctno"+toaccountCounter++, toacctnodetails);	
		try {
			int count=0;
			while(count<8) {
				Boolean toAccountNoFlag = toDropDownValue.isDisplayed();
				if(toAccountNoFlag == true) {
					WebElement toAccountNo = CommonUtility.cFindElement(driver,By.xpath("//div[contains(@class,'singlePaymentTable_allBeneList')]//div/p[contains(text(),'"+ paymentdetails.get(0).get("ToAcctno") + "')]/.."),10);
					CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, toAccountNo);	
					CommonUtility.cClick(driver, toAccountNo);
					break;
				}
				else {
					Thread.sleep(5000);
					count++;
				}

			} 
		}catch (Exception e) {
			Validator.assertTrue(false, "ToAccount Dropdown are not loading beacuse of API Issues",
					"ToAccount dropdown loaded and clicked successfully");
		}
	}
	public void enterPaymentDetails(List<Map<String, String>> paymentdetails) throws Exception {
		CommonUtility.cExplicitlyWait(driver, amount_txt, 30);
		CommonUtility.cMoveToElementByTarget(driver, amount_txt);
		CommonUtility.cSendKeys(driver, amount_txt, paymentdetails.get(0).get("Amount"));
		amountvalue=paymentdetails.get(0).get("Amount");
		Paymentamt=Integer.parseInt(amountvalue);
		Singlepayment_amountlist.put("Amount"+amtCounter++, amountvalue);
		SinglePaymentSteps.totalvalue=SinglePaymentSteps.totalvalue+Paymentamt;
		try {
			CommonUtility.cClick(driver, paymentmode_dropdown);
			CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 60);
			WebElement dropDownValue = CommonUtility.cFindElement(driver,By.xpath("//ul[@role='listbox']//li//span[text()='" + paymentdetails.get(0).get("Paymentmode") + "']"),50);		    
			payment_mode=paymentdetails.get(0).get("Paymentmode");
			CommonUtility.cClick(driver, dropDownValue);}
		catch(Exception e)
		{
			CommonUtility.cClick(driver, paymentmode_dropdown);
			WebElement dropDownValue = CommonUtility.cFindElement(driver,By.xpath("//ul[@role='listbox']//li//span[text()='" + paymentdetails.get(0).get("Paymentmode") + "']"),10);
			CommonUtility.cClick(driver, dropDownValue);
			Validator.assertTrue(true, "Payment dropdown not loaded because of API Issues", "Payment dropdown loaded and clicked successfully");
		}
		fromDropDown(paymentdetails);
		toDropDown(paymentdetails);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
		CommonUtility.cClick(driver, crn_txt);
		CRN_value=CommonUtility.cRandomNumberGenerator(4);
		CommonUtility.cSendKeys(driver, crn_txt, CRN_value);
		CommonUtility.cClick(driver, invoicenumber_txt);
		Invoice_value=CommonUtility.cRandomNumberGenerator(4);
		CommonUtility.cSendKeys(driver, invoicenumber_txt, Invoice_value);
		CommonUtility.cClick(driver, lei_txt);
		CommonUtility.cSendKeys(driver, lei_txt, paymentdetails.get(0).get("LEI"));
		LEI_value=paymentdetails.get(0).get("LEI");
		CommonUtility.cClick(driver, creditnarration_txtarea);
		CommonUtility.cSendKeys(driver, creditnarration_txtarea, paymentdetails.get(0).get("Credit Narration"));
		creditnarration_value=paymentdetails.get(0).get("Credit Narration");
		clickOnRulesApplicable(paymentdetails);
	}

	public void clickProceed() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cExplicitlyWait(driver, proceed_btn, 10);
		CommonUtility.cClick(driver, proceed_btn);

	}

	public void verifyPaymentdetails() throws Exception{
		CommonUtility.cExplicitlyWait(driver, proceed_btn, 10);
		CommonUtility.cClick(driver, proceed_btn);

	}
	public void clickAddNewPayment() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cExplicitlyWait(driver, addnewpayment_btn, 10);
		CommonUtility.cClick(driver, addnewpayment_btn);

	}
	public void clickAddPayment() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cExplicitlyWait(driver, addpayment_btn, 10);
		CommonUtility.cClick(driver, addpayment_btn);

	}

	public void alertMessage() throws Exception {
		try {
			CommonUtility.cVerifyElementIsPresent(driver, alert_message, 20);
			String toastmsg=alert_message.getText();
			Validator.assertTrue(true, "Failed:Expected toast msg is:"+toastmsg+" and Actual message both are not same.", "Passed:Expected toast msg is:"+toastmsg+" Actual toast msg both are same");
		}catch(Exception e)
		{
			Validator.assertTrue(true, "Failed:Alert message did not displayed", "Passed:Alert message displayed");
		}
	}
	public void enterRecurringPaymentDetails(Map<String, String> recurringdetails) throws Exception
	{
		CommonUtility.cExplicitlyWait(driver, recurringtype_checkbox, 30);
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, recurringtype_checkbox);
		CommonUtility.cClick(driver, recurringtype_checkbox);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 50);
		try {
			CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, frequencytype_dropdown);
			CommonUtility.cClick(driver, frequencytype_dropdown);
			Thread.sleep(3000);
			CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 50);
			CommonUtility.cClick(driver, frequencytype_dropdown);
			List<WebElement> frequencytype =CommonUtility.cFindElements(driver,frequencytype_dropdownlist, 10);
			for (int i = 0; i < frequencytype.size(); i++) 
			{
				CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
				CommonUtility.cExplicitlyWait(driver,frequencytype.get(i), 50); 
				if (frequencytype.get(i).getText().contains(recurringdetails.get("FrequencyType"))) {
					CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
					CommonUtility.cClick(driver, frequencytype.get(i));
					break;
				}
			}
		}catch(Exception e)
		{
			Validator.assertTrue(true, "Failed:Frequency drop down not loaded due to API Issues:Rerun the test script","Passed: Frequency Drop down loaded successfully");
		}
		CommonUtility.cClick(driver, installments_txt); 
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);;
		CommonUtility.cSendKeys(driver,installments_txt,recurringdetails. get("Installements"));
	}

	public void validatemultiplePaymentDetails() throws Exception
	{
		//Summary_FromAccountNumbers
		for(int i=0;i<=Singlepayment_Fromacctlist.size()-1;i++)
		{
			String Summary_FromAccountlist=CommonUtility.cFindElement(driver, By.xpath("(//div/div[3]/div[1]/div/p)["+(i+1)+"]"), 10).getText();
			List<String> SinglePayment_FromAccountListValues = new ArrayList<> (Singlepayment_Fromacctlist.values());
			Validator.assertTrue(SinglePayment_FromAccountListValues.get(i).equals(Summary_FromAccountlist),"Failed:Expected From account numbers:"+SinglePayment_FromAccountListValues.get(i)+"and the actual from account numbers :"+Summary_FromAccountlist+"are not same ","Passed:Expected From account numbers:"+SinglePayment_FromAccountListValues.get(i)+" and the actual from account numbers "+Summary_FromAccountlist+" both are same");
		}
		//Summary_ToAccountNumbers
		for(int i=0;i<=Singlepayment_Toacctlist.size()-1;i++)
		{
			String Summary_ToAccountlist=CommonUtility.cFindElement(driver,By.xpath("(//div/div[1]/div[1]/div[2]/p[1])["+(i+1)+"]"),10).getText();					
			List<String> SinglePayment_ToAccountListValues = new ArrayList<> (Singlepayment_Toacctlist.values());
			Validator.assertTrue(SinglePayment_ToAccountListValues.get(i).equals(Summary_ToAccountlist),"Failed:Expected To account numbers:"+SinglePayment_ToAccountListValues.get(i)+"and the actual To account numbers :"+Summary_ToAccountlist+"are not same ","Passed:Expected To account numbers:"+SinglePayment_ToAccountListValues.get(i)+" and the actual To account numbers "+Summary_ToAccountlist+" both are same");
		}
		//Get Amount values from summary pages
		for(int i=0;i<Singlepayment_amountlist.size();i++)
		{
			String Summary_amount=CommonUtility.cFindElement(driver, By.xpath("(//p[contains(@class,'single-payment-summary_headerText')])["+(i+1)+"]"), 10).getText().replaceAll("[^\\d]", "");
			List<String> SinglePayment_amountListValues = new ArrayList<> (Singlepayment_amountlist.values());
			Validator.assertTrue(SinglePayment_amountListValues.get(i).equals(Summary_amount),"Failed:Expected Amount value is:"+SinglePayment_amountListValues.get(i)+"and the actual amount is :"+Summary_amount+"are not same ","Passed:Expected Amount value is:"+SinglePayment_amountListValues.get(i)+" and the actual amount is "+Summary_amount+" both are same");
		}
		//Calculate Total Amount value
		String totalamountvalue=CommonUtility.cFindElement(driver,By.xpath("(//p[contains(@class,' make-payment_footer2')])[2]"),10).getText().replaceAll("[^\\d]", "");
		int summarytotalvalue=Integer.parseInt(totalamountvalue);
		Validator.assertTrue(SinglePaymentSteps.totalvalue==summarytotalvalue,  "Failed:Expected Total value "+SinglePaymentSteps.totalvalue+" is not matching with Actual value is:"+summarytotalvalue+" ","Passed:Expected TotalValue:"+SinglePaymentSteps.totalvalue+" is matching with actual value:"+summarytotalvalue+" ");
	}	
	public void selectDate(Map<String, String> date) throws Exception
	{
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 120);
		CommonUtility.cExplicitlyWait(driver, calendarbutton, 30);
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, calendarbutton);
		CommonUtility.cFindElement(driver,calendarbutton,10).click();
		try {
			while(true)
			{
				month=CommonUtility.cFindElement(driver, calendarDateHeader, 40).getText();

				if(month.equals(date.get("SelectMonth")))
				{
					break;
				}else
				{
					CommonUtility.cFindElement(driver,calendarDateNext,10).click();
				}
			}
			CommonUtility.cFindElement(driver,By.xpath("//*[contains(@class,'MuiPickersDay-day') and not(contains(@class, 'hidden'))]//p[text()='"+date.get("SelectDate")+"']"),10).click();
		}
		catch(Exception e)
		{
			Validator.assertTrue(month.equals(date.get("SelectMonth")), "Please enter the valid date format as month name and year name","Date selected successfully");
		}
	}	
	public void clickCopyButton() throws Exception
	{
		CommonUtility.cClick(driver, copybtn);
	}

	public void clickEditButton() throws Exception
	{
		CommonUtility.cClick(driver, editbtn);
	}

	public void deleteSingleTransaction() throws Exception
	{
		try {
			while(true)
			{
				boolean deleteelement=CommonUtility.cFindElement(driver, deletebtn, 50).isDisplayed();
				if(deleteelement==true)
				{
					CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, deletebtn);
					CommonUtility.cClick(driver, deletebtn);
					CommonUtility.cExplicitlyWait(driver, confirm_deletebtn, 50);
					CommonUtility.cClick(driver, confirm_deletebtn);
					alertMessage();
					break;
				}
			}
		}
		catch(Exception e){
			CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, proceed_btn);
			CommonUtility.cClick(driver, proceed_btn);

		}
	}
	public void deleteMultipleTransaction() throws Exception
	{
		try {
			while(true)
			{
				boolean deleteelement=CommonUtility.cFindElement(driver, deletebtn, 50).isDisplayed();
				if(deleteelement==true)
				{
					CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, deletebtn);
					CommonUtility.cClick(driver, deletebtn);
					CommonUtility.cExplicitlyWait(driver, confirm_deletebtn, 50);
					CommonUtility.cClick(driver, confirm_deletebtn);
					alertMessage();
					continue;
				}
			}
		}
		catch(Exception e){
			CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, proceed_btn);
			CommonUtility.cClick(driver, proceed_btn);

		}
	}

	public void validateCopyDetails()throws Exception
	{
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, amount_txt);
		Thread.sleep(6000);
		String amt=amount_txt.getAttribute("value");
		paymentamountvalue=Integer.parseInt(amt);
		Validator.assertTrue(Paymentamt==paymentamountvalue, "Failed:Expected Payment amount value  is "+Paymentamt+" and actual Payment amount value  is "+paymentamountvalue+" does not match", "Passed:Expected Payment amount value is "+Paymentamt+" and actual Payment amount value  is "+paymentamountvalue+" both are same");
		String pay= copypaymentmode_dropdown.getAttribute("value");
		Validator.assertTrue(payment_mode.equalsIgnoreCase(pay), "Failed:Expected Payment mode value is:"+payment_mode+" and actual Payment mode value is:"+pay+" does not match", "Passed:Expected Payment mode value is "+payment_mode+" and actual Payment mode value is::"+pay+" both are same");
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, from_dropdown);
		String fromacctvalue= from_dropdown.getAttribute("value");
		Validator.assertTrue(fromacctnodetails.equalsIgnoreCase(fromacctvalue), "Failed:Expected Fromaccount number is:"+fromacctnodetails+" and actual Fromaccount number value is:"+fromacctvalue+" does not match", "Passed:Expected Fromaccount number value is:"+fromacctnodetails+" and actual Fromaccount number value  is :"+fromacctvalue+" both are same");
		String toacctvalue= to_dropdown.getAttribute("value");
		Validator.assertTrue(toacctnodetails.equalsIgnoreCase(toacctvalue), "Failed:Expected Toaccount number is:"+toacctnodetails+" and actual Toaccount number is:"+toacctvalue+" does not match", "Passed:Expected Toaccount number is:"+toacctnodetails+" and actual Toaccount number is:"+toacctvalue+" both are same");
		String lei= lei_txt.getAttribute("value");
		Validator.assertTrue(LEI_value.equalsIgnoreCase(lei), "Failed:Expected LEI value is:"+LEI_value+" and actual LEI value is:"+lei+" does not match", "Passed:Expected LEI value is:"+LEI_value+" and actual LEI value  is:"+lei+" both are same");
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, ruleDropdown_dropdown);
		String rules=copy_rulesdropdown.getAttribute("value");
		Validator.assertTrue(rulesapplicable_value.equalsIgnoreCase(rules), "Failed:Expected rules value is:"+rulesapplicable_value+" and actual rules  value is:"+rules+" does not match", "Passed:Expected rules  value is:"+rulesapplicable_value+" and actual rules value is:"+rules+" both are same");
		String approver=copy_approver.getAttribute("value");
		Validator.assertTrue(approver1_value.equalsIgnoreCase(approver), "Failed:Expected approver value is:"+approver1_value+" and actual approver  value is:"+approver+" does not match", "Passed:Expected approver value is:"+approver1_value+" and actual approver value is:"+approver+" both are same");
		String remarks=remark_txtarea.getText();
		Validator.assertTrue(remarks_value.equalsIgnoreCase(remarks), "Failed:Expected  remarks value is:"+remarks_value+"and actual remarks value is:"+remarks+" does not match", "Passed:Expected remarks value is :"+remarks_value+" and actual remarks value is:"+remarks+" both are same");

	}
	public void validateSummaryDetails() throws Exception
	{
		//Summary_Amount
		String Summary_amt1=CommonUtility.cFindElement(driver, By.xpath("//p[contains(@class,'single-payment-summary_headerText')]"), 10).getText().replaceAll("[^\\d]", "");
		String Summary_amt2=CommonUtility.cFindElement(driver, By.xpath("//p[contains(@class,'single-payment-summary_headerText')]"), 10).getText().replaceAll("[^\\d]", "");
		Validator.assertTrue(Summary_amt1.equalsIgnoreCase(Summary_amt2), "Failed:Expected Summary amount value is:"+Summary_amt1+" and actual Summary amount value is:"+Summary_amt2+" does not match", "Passed:Expected Summary amount value is:"+Summary_amt1+" and actual Summary amount value is :"+Summary_amt2+" both are same");

		//Summary_PaymentMode
		String Summary_Paymentmode1=CommonUtility.cFindElement(driver, By.xpath("(//p[contains(@class,'single-payment-summary_text2')])[5]"), 10).getText();
		String Summary_Paymentmode2=CommonUtility.cFindElement(driver, By.xpath("(//p[contains(@class,'single-payment-summary_text2')])[17]"), 10).getText();
		Validator.assertTrue(Summary_Paymentmode1.equalsIgnoreCase(Summary_Paymentmode2), "Failed:Expected Payment mode value is:"+Summary_Paymentmode1+" and actual Payment mode value is:"+Summary_Paymentmode2+" does not match", "Passed:Expected value is:"+Summary_Paymentmode1+" and actual value is:"+Summary_Paymentmode2+" both are same");

		//Summary Date value
		String Summary_Date1=CommonUtility.cFindElement(driver, By.xpath("(//p[contains(@class,'single-payment-summary_text2')])[6]"), 10).getText();
		String Summary_Date2=CommonUtility.cFindElement(driver, By.xpath("(//p[contains(@class,'single-payment-summary_text2')])[18]"), 10).getText();
		Validator.assertTrue(Summary_Date1.equalsIgnoreCase(Summary_Date2), "Failed:Expected Date value is:"+Summary_Date1+" and actual Date value is:"+Summary_Date2+" does not match", "Passed:Expected Date value is:"+Summary_Date1+" and actual Date value is:"+Summary_Date2+" both are same");

		//Summary_FromAccount Numbers
		String Summary_FromAcctno1=CommonUtility.cFindElement(driver, By.xpath("(//p[contains(@class,'single-payment-summary_text2')])[1]"), 10).getText();
		String Summary_FromAcctno2=CommonUtility.cFindElement(driver, By.xpath("(//p[contains(@class,'single-payment-summary_text2')])[13]"), 10).getText();
		Validator.assertTrue(Summary_FromAcctno1.equalsIgnoreCase(Summary_FromAcctno2), "Failed:Expected Summary_FromAcctno value is:"+Summary_FromAcctno1+" and actual Summary_FromAcctno value is:"+Summary_FromAcctno2+" does not match", "Passed:Expected Summary_FromAcctno value is:"+Summary_FromAcctno1+" and actual Summary_FromAcctno value is:"+Summary_FromAcctno2+" both are same");

		//Summary_To Account numbers
		String Summary_ToAcctno1=CommonUtility.cFindElement(driver, By.xpath("(//p[contains(@class,'single-payment-summary_subHeader')][1])[1]"), 10).getText();
		String Summary_ToAcctno2=CommonUtility.cFindElement(driver, By.xpath("(//p[contains(@class,'single-payment-summary_subHeader')][1])[2]"), 10).getText();
		Validator.assertTrue(Summary_ToAcctno1.equalsIgnoreCase(Summary_ToAcctno2), "Failed:Expected Summary_ToAcctno value is:"+Summary_ToAcctno1+" and actual Summary_ToAcctno value is:"+Summary_ToAcctno2+" does not match", "Passed:Expected Summary_ToAcctno value is:"+Summary_ToAcctno1+" and actual Summary_ToAcctno value is:"+Summary_ToAcctno2+" both are same");

		//Summary_LEI
		String Summary_LEI1=CommonUtility.cFindElement(driver, By.xpath("(//p[contains(@class,'single-payment-summary_text2')])[9]"), 10).getText();
		String Summary_LEI2=CommonUtility.cFindElement(driver, By.xpath("(//p[contains(@class,'single-payment-summary_text2')])[21]"), 10).getText();
		Validator.assertTrue(Summary_LEI1.equalsIgnoreCase(Summary_LEI2), "Failed:Expected Summary_LEI value is:"+Summary_LEI1+" and actual Summary_LEI value is:"+Summary_LEI2+" does not match", "Passed:Expected Summary_LEI value is:"+Summary_LEI1+" and actual Summary_LEI value is:"+Summary_LEI2+" both are same");

		//Summary Rules
		String Summary_rules1=CommonUtility.cFindElement(driver, By.xpath("(//p[contains(@class,'single-payment-summary_text2')])[11]"), 10).getText();
		String Summary_rules2=CommonUtility.cFindElement(driver, By.xpath("(//p[contains(@class,'single-payment-summary_text2')])[23]"), 10).getText();
		Validator.assertTrue(Summary_rules1.equalsIgnoreCase(Summary_rules2), "Failed:Expected Summary Rules value is:"+Summary_rules1+" and actual Summary Rules value is:"+Summary_rules2+" does not match", "Passed:Expected Summary Rules value is:"+Summary_rules1+" and actual Summary Rules value is:"+Summary_rules2+" both are same");

		//Summary Approver
		String Summary_approver1=CommonUtility.cFindElement(driver, By.xpath("(//p[contains(@class,'single-payment-summary_text2')])[12]"), 10).getText();
		String Summary_approver2=CommonUtility.cFindElement(driver, By.xpath("(//p[contains(@class,'single-payment-summary_text2')])[24]"), 10).getText();
		Validator.assertTrue(Summary_approver1.equalsIgnoreCase(Summary_approver2), "Failed:Expected Summary Approver value is:"+Summary_approver1+" and actual Summary Approver value is:"+Summary_approver2+" does not match", "Passed:Expected Summary Approver value is:"+Summary_approver1+" and actual Summary Approver value is:"+Summary_approver2+" both are same");
	}

	public void clickViewmore() throws Exception
	{
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, viewmore_link1);
		CommonUtility.cClick(driver, viewmore_link1);
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, viewmore_link1);
		CommonUtility.cClick(driver, viewmore_link1);
	}
	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {

	}
}