package com.axisb.qaf.pages;

import java.util.List;
import java.util.Map;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import com.axisb.qaf.utils.CommonUtility;
import com.axisb.qaf.exceptions.customElementFoundException;
import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

public class NeftRtgsPaymentPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	@FindBy(locator = "xpath=//span[text()='Payments']")
	private QAFWebElement paymentslink;

	@FindBy(locator = "xpath=//span[text()='GST Payments via NEFT/RTGS']")
	private QAFWebElement neftPayments;

	@FindBy(locator = "xpath=(//div[@col-id='cpin']//input)[2]")
	private QAFWebElement cpin;
	
	@FindBy(locator="xpath=(//div[@col-id='cpin']//input)[3]")
	private QAFWebElement cpin2;

	@FindBy(locator = "xpath=//input[contains(@class, 'amountField')]")
	private QAFWebElement amount;
	
	@FindBy(locator="xpath=(//input[contains(@class, 'amountField')])[2]")
	private QAFWebElement amount2;

	@FindBy(locator = "xpath=(//div[@col-id='remark']//input)[2]")
	private QAFWebElement remarkText;

	@FindBy(locator="xpath=(//div[@col-id='remark']//input)[3]")
	private QAFWebElement remarkText2;
	
	@FindBy(locator = "xpath=//span[text()='VIEW/MODIFY RULE']")
	private QAFWebElement viewModifyRule;
	
	@FindBy(locator = "xpath=(//span[text()='VIEW/MODIFY RULE'])[2]")
	private QAFWebElement viewModifyRule2;

	@FindBy(locator = "xpath=//div[@id='Rule Applicable']")
	private QAFWebElement clickRule;

	@FindBy(locator = "xpath=//span[text()='Save']")
	private QAFWebElement ruleSave;

	@FindBy(locator = "xpath=//span[text()='Make Payment']")
	private QAFWebElement makePaymentBtn;

	@FindBy(locator = "xpath=//span[text()='Continue']")
	private QAFWebElement continueBtn;

	@FindBy(locator = "xpath=//span[contains(text(), 'Your request is submitted to the checker for further action.')]")
	private QAFWebElement submitMessage;
	
	@FindBy(locator = "xpath=//span[contains(text(),'Your requests are submitted to the checker for further action.')]")
	private QAFWebElement multiplerowsubmitMessage;

	@FindBy(locator = "xpath=//*[@id='menu-']/div[3]")
	private QAFWebElement selectDebitAcc;

	@FindBy(locator = "xpath=(//div[@id='actions'])[1]/parent::div")
	private QAFWebElement clickDebit;
	
	@FindBy(locator = "xpath=(//div[@id='actions'])[3]/parent::div")
	private QAFWebElement clickDebit2;

	@FindBy(locator = "xpath=//label[contains(text(), 'Approver')]/following-sibling::div/div")
	private QAFWebElement clickApprove;

	@FindBy(locator = "xpath=//textarea[@id='remarkApp']")
	private QAFWebElement appRemarkText;

	@FindBy(locator = "xpath=(//*[contains(text(), 'New Payments')])[1]")
	private QAFWebElement newPaymentsTab;

 // new scenarios 
	
	@FindBy(locator="xpath=//span[text()='Add A Row']")
	private QAFWebElement addRow;
	
	@FindBy(locator="xpath=//*[local-name()='svg' and @data-action='delete']/ancestor::button")
	private QAFWebElement deleterow;
	
	@FindBy(locator="xpath=//span[text()='Yes']/ancestor::button")
	private QAFWebElement yesButton;
	
	@FindBy(locator="xpath=//div[text()='The record is deleted']")
	private QAFWebElement deletToastMessage;
	
	@FindBy(locator="xpath=//button[@title='Save as Draft']/span//*[local-name()='svg']")
	private QAFWebElement saveasdraft;

	@FindBy(locator="xpath=//div[text()='The record is saved as draft']")
	private QAFWebElement saveasdraftToast;
	
	@FindBy(locator="xpath=//span[text()='Customize']")
	private QAFWebElement customButton;
	
	@FindBy(locator="xpath=//span[text()='Apply']")
	private QAFWebElement applyButton;
	
	@FindBy(locator="xpath=//span[text()='Reset']")
	private QAFWebElement resetButton;
	
	@FindBy(locator="xpath=//span[contains(text(),'Drafts')]")
	private QAFWebElement drafts;
	

	public void clickNeftPayments() throws Exception {
		Boolean paymentstab = CommonUtility.cVerifyElementIsPresent(driver, newPaymentsTab, 3); 
		if(paymentstab==true) {
			CommonUtility.cClick(driver, newPaymentsTab);
			CommonUtility.cMoveToElementFromSourceToTarget(driver, newPaymentsTab, neftPayments);
			CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 5);
			CommonUtility.cWaitForPageLoad(driver);
			CommonUtility.cExplicitlyWait(driver, cpin, 20);
			Validator.assertTrue(paymentstab, "payments tab was unable to click due to server issue.Please refer screenshot for further info", "Payments tab was clicked and successfully navigated to NEFTPayments");
		}
		else {
			Validator.assertTrue(paymentstab, "payments tab was unable to click due to server issue.Please refer screenshot for further info", "Payments tab was clicked and successfully navigated to NEFTPayments");
		}
	}	
	
	
	/*
	 * This method is used to enter cpin, Amount, selecting debit account
	 *
	 * @param cpinInput
	 */
	public void paymentDetails(List<Map<String, String>> cpinDetails) throws InterruptedException, customElementNotClickableException, customElementNotFoundException, Exception {
		Boolean cpindetailflag= CommonUtility.cVerifyElementIsPresent(driver, cpin, 3); 
		if(cpindetailflag==true) {
		CommonUtility.cClick(driver,cpin);
		CommonUtility.cExplicitlyWaitForAbsence(driver, By.xpath("//div[contains(@class,'loader')]"), 20);
		CommonUtility.cExplicitlyWait(driver, cpin, 5);
		
		//Random CPIN generation
		Random random = new Random();
			String cpinNumber=String.valueOf(random.longs(100000L,99999999999999l, 999999999999999l).findAny().getAsLong());
				for (int i = 0; i < cpinNumber.length(); i++) {
					char c = cpinNumber.charAt(i);
					String s = new StringBuilder().append(c).toString();
					CommonUtility.cSendKeys(driver, cpin, s);
				}
				Validator.assertTrue(cpindetailflag, "Failed to enter CPIN into the field", "CPIN entered successfully");
		}
		else {
			Validator.assertTrue(cpindetailflag, "Failed to enter CPIN into the field", "CPIN entered successfully");
		}
			
				Boolean amountflag =  CommonUtility.cVerifyElementIsPresent(driver, amount, 3);
				if(amountflag==true) {
				CommonUtility.cSendKeys(driver,amount,cpinDetails.get(0).get("Amount"));
				Validator.assertTrue(amountflag, "Failed to enter Amount in the amount field", "Amount entered successfully!!");
				}
				else
				{
					Validator.assertTrue(amountflag, "Failed to enter Amount in the amount field", "Amount entered successfully!!");
				}
				debitAccountSelect(cpinDetails);
		}
		
		public void debitAccountSelect(List<Map<String, String>> debitAccount) throws InterruptedException, customElementNotFoundException, customElementNotClickableException, Exception {
		Boolean debitaccountflag= CommonUtility.cVerifyElementIsPresent(driver, clickDebit, 3);
		if(debitaccountflag==true) {
		CommonUtility.cExplicitlyWaitForAbsence(driver, By.xpath("//div[contains(@class,'loader')]"), 50);
		WebElement debitclick = CommonUtility.cFindElement(driver, clickDebit, 10);
		CommonUtility.cMoveToElementByTarget(driver, debitclick);
		CommonUtility.cClick(driver, debitclick);
		CommonUtility.cExplicitlyWait(driver,selectDebitAcc, 3);
		Validator.assertTrue(debitaccountflag, "failed to click on debit account", "clicked on debit account successfully");
		}
		else {
			Validator.assertTrue(debitaccountflag, "failed to click on debit account", "clicked on debit account successfully");
		}
		
		WebElement debitclick = CommonUtility.cFindElement(driver, clickDebit, 10);
		List<WebElement> selectDebitAccount=null;
		int counter=0;
		
		try {
			selectDebitAccount = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);

		}catch(Exception e) {
			while((selectDebitAccount==null || selectDebitAccount.size()<1) && counter<10) {
				try {
					counter++;
					CommonUtility.cClick(driver, debitclick);
					selectDebitAccount = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);
				}catch(Exception ex) {
					selectDebitAccount= null;
				}
			}
		}
		for (int i = 0; i < selectDebitAccount.size(); i++) {
			if(selectDebitAccount.get(i).isEnabled()) {
				CommonUtility.cClick(driver, selectDebitAccount.get(i));
				CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 5);
				break;
			}
		}
		
		Boolean remarksflag= CommonUtility.cVerifyElementIsPresent(driver, remarkText, 3);
		if(remarksflag==true) {
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, remarkText);
		CommonUtility.cSendKeys(driver, remarkText, debitAccount.get(0).get("Remarks"));
		CommonUtility.cExplicitlyWaitForAbsence(driver, By.xpath("//div[contains(@class,'loader')]"), 50);
		Thread.sleep(5000);
		Validator.assertTrue(debitaccountflag, "failed to enter remarks, refer screenshot for further info ", "entered remarks successfully!!");
	}
		else
		{
			Validator.assertTrue(debitaccountflag, "failed to enter remarks, refer screenshot for further info ", "entered remarks successfully!!");
		}
	}
     
	public void clicknewrule(List<Map<String, String>> newruleAdd) throws InterruptedException, Exception {
    	  clickviewModifyRule();
    	  modifyRule(newruleAdd);
      }

	public void modifyRule(List<Map<String, String>> ruleDetails) throws InterruptedException, customElementNotClickableException, customElementNotFoundException, Exception {
		Boolean ruleflag = CommonUtility.cVerifyElementIsPresent(driver, clickRule, 3);
		if(ruleflag==true) {
		CommonUtility.cExplicitlyWaitForAbsence(driver, By.xpath("//div[contains(@class,'loader')]"), 20);
		try {
			CommonUtility.cClick(driver, clickRule);
		}catch(Exception e) {
			CommonUtility.cExplicitlyWaitForAbsence(driver, By.xpath("//div[contains(@class,'loader')]"), 20);
			CommonUtility.cClick(driver, clickRule);
		}
		
		List<WebElement> ruleSelect = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);
		boolean flagSelected=false;
		for (int i = 0; i < ruleSelect.size(); i++) {
			if (ruleSelect.get(i).getText().contains(ruleDetails.get(0).get("rule"))) {
				CommonUtility.cClick(driver, ruleSelect.get(i));
				flagSelected=true;
				break;
			}
		}
		if(flagSelected==false) {
			ruleSelect = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);
			for (int i = 0; i < ruleSelect.size(); i++) {
				if (ruleSelect.get(i).getText().contains(ruleDetails.get(0).get("rule"))) {
					CommonUtility.cClick(driver, ruleSelect.get(i));
					flagSelected=true;
					break;
				}
			}
			
			}
		WebElement clickApprover = CommonUtility.cFindElement(driver, clickApprove, 5);
		CommonUtility.cClick(driver, clickApprover);
		
		boolean flagApprover=false;
		List<WebElement> approverSelect = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);
		for (int i = 0; i < approverSelect.size();i++) {
			if (approverSelect.get(i).getText().contains(ruleDetails.get(0).get("Approver"))) {
				CommonUtility.cClick(driver, approverSelect.get(i));
				flagApprover=true;
				break;
			}
		}
		if(flagApprover==false) {
			approverSelect = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);
			for (int i = 0; i < approverSelect.size();i++) {
				if (approverSelect.get(i).getText().contains(ruleDetails.get(0).get("Approver"))) {
					CommonUtility.cClick(driver, approverSelect.get(i));
					flagApprover=true;
					break;
				}
			}	
		}
		boolean remarksflag = CommonUtility.cVerifyElementIsPresent(driver, appRemarkText, 3);
		if(remarksflag==true) {
		WebElement remarktext = CommonUtility.cFindElement(driver, appRemarkText, 5);
		CommonUtility.cSendKeys(driver, remarktext, ruleDetails.get(0).get("Remark"));
		Validator.assertTrue(ruleflag, "failed due to server issue", "Remarks entered successfully!!");
		}
		boolean saveflag = CommonUtility.cVerifyElementIsPresent(driver, ruleSave, 3);
		if(saveflag==true) {
		CommonUtility.cClick(driver,ruleSave);
		Validator.assertTrue(ruleflag, "failed to save rule and approver due to server issue", "rule and approver saved successfully");
		}
		else
		{
			Validator.assertTrue(ruleflag, "failed to save rule and approver due to server issue", "rule and approver saved successfully");
		}
		
	}
	}
	public QAFWebElement eneterRemarks() {
		return remarkText;
	}

	public void clickContinueBtn() throws Exception {
		Boolean continueflag = CommonUtility.cVerifyElementIsPresent(driver, continueBtn, 3);
		if(continueflag==true) {
		CommonUtility.cClick(driver,continueBtn);
		Validator.assertTrue(continueflag, "failed to click on continue button to proceed.Please refere screenshot for more info", "Successfully clicked on continue button");
	}
		else {
			Validator.assertTrue(continueflag, "failed to click on continue button to proceed.Please refere screenshot for more info", "Successfully clicked on continue button");
		}
	}
	
	public void clickMakePayment() throws Exception {
		Boolean makepaymentflag = CommonUtility.cVerifyElementIsPresent(driver, makePaymentBtn, 3);
		if(makepaymentflag==true) {
		CommonUtility.cClick(driver,makePaymentBtn);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 8);
		Validator.assertTrue(makepaymentflag, "failed to click Make Payment.Please refer screenshot", "Make Payment button was clicked uccessfully!!");
		}
		else {
			Validator.assertTrue(makepaymentflag, "failed to click Make Payment.Please refer screenshot", "Make Payment button was clicked uccessfully!!");
		}
	}

	public void submissionMessage() throws Exception {
		//Waiting for the Loader to Load. Need to Use By Variable.
		CommonUtility.cExplicitlyWaitForAbsence(driver, By.xpath("//div[contains(@class='loader')]"), 40);
		 Boolean submitflag= CommonUtility.cVerifyElementIsPresent(driver, submitMessage, 30);
		 if(submitflag==true) {
			 Validator.assertTrue(submitflag, "NEFT payment failed .Please refer to screenshot for more info", "New Payment Via NEFT/RTFS successfully completed!!");
		 }
		 else {
			 CommonUtility.cVerifyElementIsPresent(driver, submitMessage, 30);
			 Validator.assertTrue(submitflag, "NEFT payment failed .Please refer to screenshot for more info", "New Payment Via NEFT/RTFS successfully completed!!");

		 }
	}

	public void multiplerowSubmissionMsg() throws Exception {
		CommonUtility.cExplicitlyWaitForAbsence(driver, By.xpath("//div[contains(@class='loader')]"), 40);
		boolean multiplerowflag = CommonUtility.cVerifyElementIsPresent(driver, multiplerowsubmitMessage, 40);
		if(multiplerowflag==true) {
//			CommonUtility.cExplicitlyWaitForAbsence(driver, By.xpath("//div[contains(@class='loader')]"), 30);
			Validator.assertTrue(multiplerowflag, "submision message is not displayed", "New Payment Via NEFT/RTFS successfully completed!!");
		}
			else {
				CommonUtility.cExplicitlyWaitForAbsence(driver, By.xpath("//div[contains(@class='loader')]"), 30);
			Validator.assertTrue(multiplerowflag, "submision message is not displayed", "New Payment Via NEFT/RTFS successfully completed!!");
		}
	}
	
     public void addNewRow() throws Exception {
    	 Boolean addnewrowflag= CommonUtility.cVerifyElementIsPresent(driver, addRow, 3);
    	 if(addnewrowflag==true) {
    	 CommonUtility.cClick(driver, addRow);
    	 Validator.assertTrue(addnewrowflag, "failed to click add new row button", "Add new Row button was clicked succesfully!!");
    	 }
    	 else {
    		 Validator.assertTrue(addnewrowflag, "failed to click add new row button", "Add new Row button was clicked succesfully!!");
    	 }
     }
     
     public void deleteNeftRow() throws Exception {
    	Boolean deleteflag = CommonUtility.cVerifyElementIsPresent(driver, deleterow, 3);
    	if(deleteflag==true) {
    	CommonUtility.cExplicitlyWait(driver, deleterow, 3);
    	CommonUtility.cMoveToElementByTarget(driver, deleterow);
    	Thread.sleep(3000);
    	CommonUtility.cClick(driver, deleterow);
    	try {
    		CommonUtility.cExplicitlyWait(driver, yesButton, 3);
    		yesButton.click();
    		Validator.assertTrue(deleteflag, "delete button is not clicked due to server issue", "delete button was clicked successfully");
    	}
    	catch(Exception e){
    		yesButton.click();
    	}
    	}
    	else {
    		Validator.assertTrue(deleteflag, "delete button is not clicked due to server issue", "delete button was clicked successfully");
    	}
    	}
     
     public void deletToastMessage() throws Exception {
    	 boolean deletetoastflag = CommonUtility.cVerifyElementIsPresent(driver, deletToastMessage, 3);
    	 if(deletetoastflag==true) {
    	 CommonUtility.cExplicitlyWait(driver, deletToastMessage, 3);
    	 Validator.assertTrue(deletetoastflag, "Toast Message is not displayed due to API issue!!", "Row deleted Successfully!!");
    	 }
    	 else
    	 {
        	 Validator.assertTrue(deletetoastflag, "Toast Message is not displayed due to API issue!!", "Row deleted Successfully!!");
    	 }
     }

     public void saveAsDraftRecord() throws Exception {
    	Boolean saveasdraftflag= CommonUtility.cVerifyElementIsPresent(driver, saveasdraft, 3);
    	if(saveasdraftflag==true) {
    		CommonUtility.cExplicitlyWait(driver, saveasdraft, 3);
   		 CommonUtility.cMoveToElementByTarget(driver, saveasdraft);
   		Validator.assertTrue(saveasdraftflag, "failed to click saved as draft button", " saved as draft button clicked successfully");
    	}
    	else {
    		Validator.assertTrue(saveasdraftflag, "failed to click saved as draft button", "saved as draft button clicked successfully");
    	}
    	Boolean yesflag = CommonUtility.cVerifyElementIsPresent(driver, yesButton, 3);
    	if(yesflag==true) {
   		CommonUtility.cExplicitlyWait(driver, yesButton, 2);
		yesButton.click();
		Validator.assertTrue(saveasdraftflag, "failed to click yes button to confirm", "clicked yes button to confirm save as draft");
    	}
    	else {
    		Validator.assertTrue(saveasdraftflag, "failed to click yes button to confirm", "clicked yes button to confirm save as draft");
    	}
     }
     
     public void saveasDraftToastMessage() throws Exception {
    	 Boolean savetoastflag = CommonUtility.cVerifyElementIsPresent(driver, saveasdraftToast, 3);
    	 if(savetoastflag==true) {
    		 CommonUtility.cExplicitlyWait(driver, saveasdraftToast, 2);
        	 Validator.assertTrue(saveasdraftToast.isDisplayed(), "Save as draft toast message is not displayed ", "Row is saved as Draft successfully!!");
    	 }
    	 else {
        	 Validator.assertTrue(saveasdraftToast.isDisplayed(), "Save as draft toast message is not displayed ", "Row is saved as Draft successfully!!");
    	 }
    	
     }
     
     public void customizeColumns(List<Map<String,String>> options) throws Exception {
    	boolean customflag= CommonUtility.cVerifyElementIsPresent(driver, customButton, 3);
    	if(customflag==true) {
    	 CommonUtility.cClick(driver, customButton);
    	 for (Map<String, String> customNames : options) {
 			for (Map.Entry<String, String> entry : customNames.entrySet()) {
 				String optionpath = "//p[contains(text(),'" + entry.getValue() + "')]";
 				driver.findElement(By.xpath(optionpath)).click();
 			}
 		}
    	 CommonUtility.cClick(driver, applyButton);
    	 Validator.assertTrue(customflag, "Failed to click on custom button.Please refer screenshot for more info", "customization success");
 	}
    	else {
    		Validator.assertTrue(customflag, "Failed to click on custom button.Please refer screenshot for more info", "customization success");
    	}
     }
     
     public void newrowDetails(List<Map<String,String>> addrowDetails) throws InterruptedException, Exception {
    	Boolean cpinflag = CommonUtility.cVerifyElementIsPresent(driver, cpin2, 3);
    	if(cpinflag==true) {
    	CommonUtility.cClick(driver,cpin2);
 		CommonUtility.cExplicitlyWaitForAbsence(driver, By.xpath("//div[contains(@class,'loader')]"), 20);
 		CommonUtility.cExplicitlyWait(driver, cpin2, 5);
 		Random random = new Random();
		String cpinNumber=String.valueOf(random.longs(100000L,99999999999999l, 999999999999999l).findAny().getAsLong());
			for (int i = 0; i < cpinNumber.length(); i++) {
				char c = cpinNumber.charAt(i);
				String s = new StringBuilder().append(c).toString();
				CommonUtility.cSendKeys(driver, cpin2, s);
			}
			CommonUtility.cSendKeys(driver,amount2,addrowDetails.get(0).get("Amount"));
			debitAccountSelectnewRow(addrowDetails);
			Validator.assertTrue(cpinflag, "failed to enter Amount.Please refer screenshot for more info", "Amount entered successfully");
    	}
    	else {
    		Validator.assertTrue(cpinflag, "failed to enter Amount.Please refer screenshot for more info", "Amount entered successfully");
    	}
    		}
     
     public void debitAccountSelectnewRow(List<Map<String, String>> debitAccount) throws InterruptedException, customElementNotFoundException, customElementNotClickableException, Exception {
 		Boolean detailsflag = CommonUtility.cVerifyElementIsPresent(driver, clickDebit2, 3);
 		if(detailsflag==true) {
    	 CommonUtility.cExplicitlyWaitForAbsence(driver, By.xpath("//div[contains(@class,'loader')]"), 50);
 		WebElement debitclick = CommonUtility.cFindElement(driver, clickDebit2, 10);
 		CommonUtility.cMoveToElementByTarget(driver, debitclick);
 		CommonUtility.cClick(driver, debitclick);
 		try {
 			CommonUtility.cExplicitlyWait(driver,selectDebitAcc, 3);
 		}catch(Exception e) {
 			CommonUtility.cClick(driver, debitclick);
 			CommonUtility.cExplicitlyWait(driver,selectDebitAcc, 3);
 		}
 		List<WebElement> selectDebitAccount=null;
 		int counter=0;
 		try {
 			selectDebitAccount = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);

 		}catch(Exception e) {
 			while((selectDebitAccount==null || selectDebitAccount.size()<1) && counter<10) {
 				try {
 					counter++;
 					CommonUtility.cClick(driver, debitclick);
 					selectDebitAccount = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);
 				}catch(Exception ex) {
 					selectDebitAccount= null;
 				}
 			}
 		}
 		for (int i = 0; i < selectDebitAccount.size(); i++) {
 			if(selectDebitAccount.get(i).isEnabled()) {
 				CommonUtility.cClick(driver, selectDebitAccount.get(i));
 				break;
 			}

 		}
 		Validator.assertTrue(detailsflag, "Failed to select Debit Acount", "Debit Account was selected successfully");
 		}
 		else
 		{
 			Validator.assertTrue(detailsflag, "Failed to select Debit Acount", "Debit Account was selected successfully");
 		}
 		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, remarkText2);
 		CommonUtility.cSendKeys(driver, remarkText2, debitAccount.get(0).get("Remarks"));
 		
 	}

     public void clickviewModifyRule() throws Exception {
    	Boolean clickruleflag = CommonUtility.cVerifyElementIsPresent(driver, viewModifyRule, 10);
    	if(clickruleflag==true) {
    		 CommonUtility.cExplicitlyWaitForAbsence(driver, By.xpath("//div[contains(@class,'loader')]"), 30);
//    		CommonUtility.cMoveToElementByTarget(driver, viewModifyRule);
    		 try {
    			CommonUtility.cClick(driver, viewModifyRule);
    		 }
    		 catch(Exception e) {
    			 CommonUtility.cExplicitlyWaitForAbsence(driver, By.xpath("//div[contains(@class,'loader')]"), 30);
    			 CommonUtility.cClick(driver, viewModifyRule);
    		 }
    			Validator.assertTrue(clickruleflag, "unable to click modify rule", "modify rule clicked successfully");
     }
    	else {
    		Validator.assertTrue(clickruleflag, "unable to click modify rule", "modify rule clicked successfully");
    	}
     }
     
     
     public void clickaddrowModifyrule() throws Exception
     {
    	 boolean addrowflag= CommonUtility.cVerifyElementIsPresent(driver, viewModifyRule2, 3);
    	 if(addrowflag==true) {
    		 CommonUtility.cMoveToElementByTarget(driver, viewModifyRule2);
    		 CommonUtility.cClick(driver, viewModifyRule2);
    		 Validator.assertTrue(addrowflag, "failed to click view/modify rule", "View/Modify rule clicked successfully!!");
    	 }
    	 else
    	 {
    		 Validator.assertTrue(addrowflag, "failed to click view/modify rule", "View/Modify rule clicked successfully!!");
    	 }
     }
     
    public void newRowModifyRule(List<Map<String,String>> addrowRule) throws InterruptedException, Exception  {
    	clickaddrowModifyrule();
    	modifyRule(addrowRule);
    }
     
	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub
	}
}
