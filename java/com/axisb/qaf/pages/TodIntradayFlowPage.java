package com.axisb.qaf.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.utils.CommonUtility;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;


public class TodIntradayFlowPage extends WebDriverBaseTestPage<WebDriverTestPage>{

	@FindBy(locator = "//*[text()='Intraday / TOD Request']")
	private QAFWebElement intradayTODRequest;

	@FindBy(locator = "//*[@id='mui-component-select-customerId']")
	private QAFWebElement customerIDBox;

	@FindBy(locator = "//*[text()='Intraday']/../span/span/input")
	private QAFWebElement intradayRadioBtn;
		
	@FindBy(locator = "//*[text()='Intraday']/../span/span")
	private QAFWebElement intradayText;

	@FindBy(locator = "//*[text()='TOD']")
	private QAFWebElement todText;

	@FindBy(locator="//*[text()='TOD']/../span/span/input")
	private QAFWebElement todRadioBtn;

	@FindBy(locator="//*[@id='mui-component-select-purpose']")
	private QAFWebElement purposeDD;

	@FindBy(locator="//*[text()='Working Capital Requirement']")
	private QAFWebElement workingCapitalOption;

	@FindBy(locator="//*[text()='Exchange Obligation']")
	private QAFWebElement exchangeObligationOption;

	@FindBy(locator="//*[text()='Amount*']/../div/input")
	private QAFWebElement amountTextBox;

	@FindBy(locator="//*[@value='INTRADAY']/ancestor::span[contains(@class,'checked')]")
	private QAFWebElement intradayChecked;

	@FindBy(locator="//*[text()='Required Date*']/../div/div/button")
	private QAFWebElement reqDateBtn;
	
	@FindBy(locator="//*[text()='Regularization Date*']/../div/div/button")
	private QAFWebElement regDateBtn;

	@FindBy(locator="//*[text()='Regularization Date*']/../div/input")
	private QAFWebElement regDate;

	@FindBy(locator="//*[@id='mui-component-select-RegMode']")
	private QAFWebElement modeOfRegularizationDD;
	
	@FindBy(locator="//*[@id='mui-component-select-RegMode' and @aria-disabled='true']")
	private QAFWebElement modeOfRegularizationTOD;
	
	@FindBy(locator="//*[text()='Exchange Release']")
	private QAFWebElement exchangeReleaseOption;

	@FindBy(locator="//*[text()='Fund Transfer']")
	private QAFWebElement fundTransferOption;

	@FindBy(locator="//*[text()='Exchange Payout']")
	private QAFWebElement exchangePayoutOption;

	@FindBy(locator="//*[text()='Charges Account Number*']/../div[2]")
	private QAFWebElement chargesAccountNumber;
	
	@FindBy(locator="//*[contains(text(),'ID/TOD')]/../div[2]")
	private QAFWebElement IDTODAccountNumber;

	@FindBy(locator="//*[text()='Relationship Manager (Email IDs)*']/parent::div")
	private QAFWebElement rmMailIds;

	@FindBy(locator="//*[text()='Relationship Manager (Email IDs)*']/../div/input")
	private QAFWebElement rmMailIdsTextBox;

	@FindBy(locator="//*[text()='Proceed']/ancestor::button")
	private QAFWebElement proceedBtn;

	@FindBy(locator="//*[text()='Proceed']/ancestor::button[contains(@class,'XoSGtE8i_YYumsphkKUk')]")
	private QAFWebElement proceedBtnDisabled;
		
	@FindBy(locator="//*[text()='Select rule to proceed']/../../div[2]/button")
	private QAFWebElement selectRuleBtn;

	@FindBy(locator="//*[contains(text(),'accept')]/../div/span/span")
	private QAFWebElement tcCheckBox;

	@FindBy(locator="//*[text()='Slab']/../../../div[2]/div//fieldset//label")
	private QAFWebElement ruleRadioBtn;

	@FindBy(locator="//*[text()='close']/../../button[2]")
	private QAFWebElement ruleApply;

	@FindBy(locator="//*[text()='Submit']/ancestor::button")
	private QAFWebElement submitBtn;

	@FindBy(locator="//*[text()='Request Submitted Successfully']")
	private QAFWebElement successMessage;

	@FindBy(locator="//*[text()='Back to Service Overview']/parent::button")
	private QAFWebElement backToServiceBtn;

	@FindBy(locator="//*[text()='Entity Name']/../div/input")
	private QAFWebElement entityNameBox;

	@FindBy(locator="//*[text()='Regularization Date*']/../div/input[contains(@class,'disabled')]")
	private QAFWebElement regularizationDateDisabled;

	@FindBy(locator="//*[text()='Relationship Manager (Email IDs)*']/parent::div/../../../../div[2]/div[1]")
	private QAFWebElement mailErrorMessage;

	@FindBy(locator="//*[@id='__next']/div/main/div[3]/main/div[3]/div[3]/div/div[3]/div[2]")
	private QAFWebElement dormantMessage;

	@FindBy(locator="//*[text()='Required Date*']/../div/input")
	private QAFWebElement requiredDateTextBox;
	
	@FindBy(locator="//*[contains(text(),'Service Request')]/../../../div[3]/div/div/div/div[1]")
	private QAFWebElement applicationNo;
	
	@FindBy(locator="//h2[text()='Service Overview']")
	private QAFWebElement serviceOverviewHeader;
	
	@FindBy(locator = "//span[contains(text(),'Close')]")
	private QAFWebElement close_account_dormat_link;
	
	@FindBy(locator = "//span[contains(text(),'New Request')]")
	private QAFWebElement newRequest_Btn;
	
	private static String formID =null;
	
	Calendar calendar = Calendar.getInstance();
	Calendar calendar1 = Calendar.getInstance();

	public void clickNewRequest() throws customElementNotClickableException, customElementNotFoundException, Exception {
		Thread.sleep(10000);
		try {
			if (close_account_dormat_link.isDisplayed()) {
				CommonUtility.cClick(driver, close_account_dormat_link);
			}
		} catch (Exception e) {
			try {
				CommonUtility.cExplicitlyWait(driver, close_account_dormat_link, 10);
				if (close_account_dormat_link.isDisplayed()) {
					CommonUtility.cClick(driver, close_account_dormat_link);
				}
			} catch (Exception e1) {
			}
		}
		Thread.sleep(2000);
		CommonUtility.cClick(driver, newRequest_Btn);
		Thread.sleep(2000);
	}
	
	public void clickTODorIntraday() throws Exception
	{	
		try {
			if(CommonUtility.cVerifyElementIsPresent(driver, intradayTODRequest, 2))
			{
				CommonUtility.cClick(driver, intradayTODRequest);	
			} else
			{
					CommonUtility.cExplicitlyWait(driver, intradayTODRequest, 5);
					CommonUtility.cClick(driver, intradayTODRequest);	
			}
		} catch (Exception e) {
			Validator.assertTrue(CommonUtility.cVerifyElementIsPresent(driver, intradayTODRequest, 0), "Intraday TOD link is not present under Initiate new request " , "Passed. Able to click Intraday/TOD link under initiate new request");
		} 


	}
	public void selectCustomerID(List<Map<String, String>> formData) throws InterruptedException, customElementNotClickableException, customElementNotFoundException, Exception{
		Thread.sleep(15000);
		String account = formData.get(0).get("CustomerID");
		String entity = formData.get(0).get("EntityName");
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 30);
		boolean flag1 = CommonUtility.cVerifyElementIsVisible(driver, customerIDBox, 2);
		Validator.assertTrue(flag1, "Test failed! CustomerID selection page not loaded. Please refer screenshot", "Passed. Able to click customer ID selector");
		CommonUtility.cClick(driver, customerIDBox);
		
		try {
			CommonUtility.cClick(driver, CommonUtility.cFindElement(driver, By.xpath("//*[text()='"+account+"']"), 10));
			CommonUtility.cWaitForLoaderAbsenceWithSpinner(driver, 20);
			}
			catch(Exception e)
			{
				CommonUtility.cWaitForLoaderAbsenceWithSpinner(driver, 20);
				try {
					CommonUtility.cClick(driver, CommonUtility.cFindElement(driver, By.xpath("//*[text()='"+account+"']"), 10));
					CommonUtility.cWaitForLoaderAbsenceWithSpinner(driver, 20);
					} catch(Exception e1)
					{
						Validator.assertTrue(false, "Required customer ID removed or cutomer ID api not loaded", "Required Customer ID is present");
					}
			}
				
		try {

			WebElement entityName = driver.findElement(By.xpath("//*[text()='Entity Name']/../div/input[contains(@value,'"+entity+"')]"));
			CommonUtility.cExplicitlyWaitElementToBeVisible(driver, entityName, 2);

		} catch(Exception e) {
			CommonUtility.cWaitForLoaderAbsenceWithSpinner(driver, 20);
			CommonUtility.cClick(driver, customerIDBox);
			CommonUtility.cWaitForLoaderAbsenceWithSpinner(driver, 20);
			CommonUtility.cClick(driver, CommonUtility.cFindElement(driver, By.xpath("//*[text()='"+account+"']"), 10));
			CommonUtility.cWaitForLoaderAbsenceWithSpinner(driver, 20);
			QAFWebElement entityName = (QAFWebElement) CommonUtility.cFindElement(driver, By.xpath("//*[text()='Entity Name']/../div/input[contains(@value,'"+entity+"')]"), 10);
			boolean flag = CommonUtility.cVerifyElementIsPresent(driver, entityName, 1);
			Validator.assertTrue(flag, "Entity name is not pre-populated as per requirement", "Entity name is prepopulated");
		}
	}
	public void intradaydefaulted() throws customElementNotFoundException {
		
		Boolean check = false;
		try {
			CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, intradayText);
			if(CommonUtility.cVerifyElementIsPresent(driver, intradayChecked, 2)) {
				check=true;
			} 
			Validator.assertTrue(check, " Intra Day radio button is not present/ checked.", "Intraday radio button is successfully validated as checked");

		}catch(Exception e) {
			Validator.assertTrue(check, " Intra Day radio button not defaulted.", "Intraday radio button is successfully validated as checked");

		}
	}

	public void fillIntradayForm(List<Map<String, String>> formData) throws Exception {
		calendar.add(Calendar.DATE, 0);
		SimpleDateFormat sdfReg = new SimpleDateFormat("dd/MM/yyyy");
		String amount = formData.get(0).get("RequestedAmount");
		
		CommonUtility.cClick(driver, reqDateBtn);	
		try {
			selectDateinCalendar(calendar);
		} catch (Exception e) {
			Validator.assertTrue(false, "Test Failed! Issue with calendar", "Passed");
		}
		selectPurpose(formData.get(0).get("purpose"));
		CommonUtility.cClick(driver, amountTextBox);
		CommonUtility.cSendKeys(driver, amountTextBox, amount);
		CommonUtility.cClick(driver, modeOfRegularizationDD); // Added as its a defect
		selectMode(formData.get(0).get("mode"));
		
		String IDacc=IDTODAccountNumber.getText();
		String chargesAccount = chargesAccountNumber.getText();
			
		String regDateValueActual = regDate.getAttribute("value");
		String regDateValueExpected = sdfReg.format(calendar.getTime());
		
		Validator.assertTrue(!IDacc.isBlank(), "Test Failed!!  ID / TOD Account Number is not prepopulated", "ID / TOD Account Number is prepopulated");
		Validator.assertTrue(!chargesAccount.isBlank(), "Test Failed!!  Charges Account Number is not prepopulated", "Charges Account Number is prepopulated");	
		boolean flag = regDateValueActual.equals(regDateValueExpected);
		Validator.assertTrue(flag, "Test failed ! "+regDateValueActual+" :Regularization date is not same as Required date : "+regDateValueExpected, "Regularization date is same as required date: "+regDateValueActual);
		}

	public void enterEmailId(List<Map<String,String>> emailIds) throws customElementNotClickableException, customElementNotFoundException {
		addEmail(emailIds);		
		CommonUtility.cClick(driver, proceedBtn);

	}

	public void selectRuleandTC() throws Exception {
		CommonUtility.cClick(driver, selectRuleBtn);
		CommonUtility.cWaitForLoaderAbsenceWithSpinner(driver, 20);
		boolean flag = CommonUtility.cVerifyElementIsPresent(driver, ruleRadioBtn, 2);
		Validator.assertTrue(flag, "Rules api is not loaded", "Rules page loaded successfully");
		CommonUtility.cClick(driver, ruleRadioBtn);
		CommonUtility.cClick(driver, ruleApply);
		CommonUtility.cClick(driver, tcCheckBox);
		CommonUtility.cClick(driver, submitBtn);
	}

	public void validateSuccessPage() throws Exception {
		boolean submitflag= CommonUtility.cVerifyElementIsPresent(driver, successMessage, 15);
		Validator.assertTrue(submitflag, "Test Failed ! Technical error found. Please check screenshot. "," Success message is displayed");
		Validator.assertTrue(backToServiceBtn.isDisplayed(), "Back to service button is not displayed"," Back to service button is displayed");
	}

	public void validatePreFilledDetailForm() {
		String entity= entityNameBox.getAttribute("value");
		String idAccount = IDTODAccountNumber.getText();				
		String chargesAccount = chargesAccountNumber.getText();
			
		boolean flag1 = !entity.isBlank();
		boolean flag2 =!idAccount.isBlank();
		boolean flag3 =!chargesAccount.isBlank();
		Validator.assertTrue(flag1, "Entity box is not pre filled after customer ID Selection", "Entity box is pre filled after customer ID Selection");
		Validator.assertTrue(flag2, "ID/ TOD account name text box is not pre filled after customer ID Selection", "ID/ TOD account name text box is pre filled after customer ID Selection");
		Validator.assertTrue(flag3, "Charges account name is not pre filled after customer ID Selection", "Charges account name is pre filled after customer ID Selection");
	}

	
	public void validateMaxDateAvailable(int daysFromCurrentDate) throws Exception {
		SimpleDateFormat sdfD = new SimpleDateFormat("d");
		SimpleDateFormat sdfMy = new SimpleDateFormat("MMMM yyyy");

		calendar.add(Calendar.DATE, daysFromCurrentDate+1);
		CommonUtility.cClick(driver, reqDateBtn);

		String curMY = sdfMy.format(calendar1.getTime());
		String reqMY =sdfMy.format(calendar.getTime());
	//	System.out.println("*** current month year : "+ curMY + "/ Required Month year : " + reqMY);***
		if(curMY.equals(reqMY))
			{
			WebElement disabledDate = driver.findElement(By.xpath("//p[text()='"+sdfD.format(calendar.getTime())+"']/ancestor::button[not(contains(@class,'hidden')) and contains(@class,'Disabled')]"));
			Validator.assertTrue(disabledDate.isDisplayed(), daysFromCurrentDate+1+" day from current date is not disabled", "Calendar is disabled as per requirement");	
			}
		else
		{
			QAFWebElement calendarNextBtn = (QAFWebElement) CommonUtility.cFindElement(driver, By.xpath("//p[text()='"+sdfMy.format(calendar1.getTime())+"']/../../button[2]"), 10);
			CommonUtility.cClick(driver, calendarNextBtn);
			Thread.sleep(4000);
			WebElement disabledDate = driver.findElement(By.xpath("//p[text()='"+sdfD.format(calendar.getTime())+"']/ancestor::button[not(contains(@class,'hidden')) and contains(@class,'Disabled')]"));
			Validator.assertTrue(disabledDate.isDisplayed(), daysFromCurrentDate+1+" day from current date is not disabled", "Calendar is disabled as per requirement");
		}
	}

	public void validateRegularizationDate() throws Exception {
		boolean flag = CommonUtility.cVerifyElementIsVisible(driver, regularizationDateDisabled, 2);
		Validator.assertTrue(flag, "Regularization Date is not disabled for Intraday", "Regularization Date is disabled for Intraday");

	}	

	public void submitWithMaxDate_Intraday(Integer day, List<Map<String,String>> formData) throws Exception {
		calendar.add(Calendar.DATE, day);
		String amount = formData.get(0).get("RequestedAmount");
		
			try {
				selectDateinCalendar(calendar);
			} catch (Exception e) {
				Validator.assertTrue(false, "Test Failed! Issue with calendar", "Passed");
			}
		
		selectPurpose(formData.get(0).get("purpose"));
		CommonUtility.cClick(driver, amountTextBox);
		CommonUtility.cSendKeys(driver, amountTextBox, amount);	
		CommonUtility.cClick(driver, modeOfRegularizationDD); // Added as its a defect
		selectMode(formData.get(0).get("mode"));


	}
	
	public void verifyMaxEmailIDs(List<Map<String, String>> emailIds) throws Exception {
		addEmail(emailIds);
		String errorMessage = mailErrorMessage.getText();
		boolean flag = errorMessage.equals("Maximum limit reached");
		Validator.assertTrue(flag, "Test failed! "+ errorMessage + " was displayed", errorMessage + " :error message was displayed as expected");
	}
	
	public void fillTODForm(List<Map<String, String>> formData) throws Exception {
		calendar.add(Calendar.DATE, 0);
		calendar1.add(Calendar.DATE, 1);
		SimpleDateFormat sdfD = new SimpleDateFormat("d");
		SimpleDateFormat sdfReg = new SimpleDateFormat("dd/MM/yyyy");
		String amount = formData.get(0).get("RequestedAmount");
		//****** Select required Date ********
		CommonUtility.cClick(driver, reqDateBtn);	
		try {
			selectDateinCalendar(calendar);
		} catch (Exception e) {
			Validator.assertTrue(false, "Test Failed! Issue with calendar", "Passed");
		}
		selectPurpose(formData.get(0).get("purpose"));
		//****** Select regularization Date ********
		CommonUtility.cClick(driver, regDateBtn);
		try {
			selectDateinCalendar(calendar1);
		} catch (Exception e) {
			Validator.assertTrue(false, "Test Failed! Issue with calendar/ Request submission past the cut off time", "Passed");
		}
		enterAmount(amount);				
		String IDacc=IDTODAccountNumber.getText();
		String chargesAccount = chargesAccountNumber.getText();	
		
		Validator.assertTrue(!IDacc.isBlank(), "Test Failed!!  ID / TOD Account Number is not prepopulated", "ID / TOD Account Number is prepopulated");
		Validator.assertTrue(!chargesAccount.isBlank(), "Test Failed!!  Charges Account Number is not prepopulated", "Charges Account Number is prepopulated");			
	}

	public void fillFormandValidateDates(Integer day, List<Map<String, String>> formData) throws Exception {
		SimpleDateFormat sdfD = new SimpleDateFormat("d");
		calendar.add(Calendar.DATE, day);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.add(Calendar.DATE, day+1);
	// Selecting maximum required date available for TOD ***
		try {
			selectDateinCalendar(calendar);
		} catch (Exception e) {
			Validator.assertTrue(false, "Test Failed! Issue with calendar", "Passed");
		}
		CommonUtility.cClick(driver, regDateBtn);
		
		// Validating selected required date is disabled in regularization date calender for TOD ***
			WebElement disabledDate = driver.findElement(By.xpath("//p[text()='"+sdfD.format(calendar.getTime())+"']/ancestor::button[not(contains(@class,'hidden')) and contains(@class,'Disabled')]"));
		//	System.out.println("***Disabled date check:  "+sdfD.format(calendar.getTime())); ***
			Thread.sleep(1000);
			boolean flag= CommonUtility.cVerifyElementIsPresent(driver, disabledDate, 1);
			Validator.assertTrue(flag, "Required date is not disabled in Regularization date box", "Calendar is disabled as per requirement");
		
		// Selecting regularization date as next day from required date available ***
		try {
			selectDateinCalendar(calendar2);
		} catch (Exception e) {
			Validator.assertTrue(false, "Test Failed! Issue with calendar", "Passed");
		}				
		String amount = formData.get(0).get("RequestedAmount");
		selectPurpose(formData.get(0).get("purpose"));
		enterAmount(amount);
	}

	public void selectMaxTODRegularizationDate(Integer day) throws Exception {
		
		SimpleDateFormat reqDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String requiredDate = CommonUtility.cFindElement(driver, requiredDateTextBox, 1).getAttribute("value");
		Date date = reqDateFormat.parse(requiredDate);
		
		calendar.setTime(date);
		calendar.add(Calendar.DATE, day);
		
		CommonUtility.cClick(driver, regDateBtn);
		verifyDisabledRegularizationDate(day+1);
		
		// selecting regularization date as 15 days from maximum available required date ***
		try {
			selectDateinCalendar(calendar);
		} catch (Exception e) {
			Validator.assertTrue(false, "Test Failed! Issue with calendar/ Request submission past the cut off time", "Passed");
		}		
	}

	public void verifyDisabledProceedBtn() throws Exception {
		boolean flag= CommonUtility.cVerifyElementIsVisible(driver, proceedBtnDisabled, 1);
		Validator.assertTrue(flag, "Test failed ! proceed button is enabled without adding RM email", "Proceed button is disabled without adding RM email as per requirement");
		
	}
	
	public void verifyDormantFrozenMessage() throws Exception {
		Thread.sleep(5000);
		String message = dormantMessage.getText();
		boolean flag= message.equals("The request cannot be completed because ID/TOD and/or Charges accounts are dormant, inactive or frozen. Please contact your RM.");
		Validator.assertTrue(flag, "Test Failed!  "+ message + " : Dormant message displayed is not matching the requirement", message +" : Dormant message is displayed as per requirement");
		
	}
	
	public void clickTODRadioBtn() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, todText);
		
	}
	
	public void verifyModeofRegularization() throws Exception {
		boolean flag= CommonUtility.cVerifyElementIsVisible(driver, modeOfRegularizationTOD, 2);
		Validator.assertTrue(flag, "Test Failed! mode of regularization is not disabled for TOD flow", "mode of regularization is disabled as per requirement");
		boolean flag1 = CommonUtility.cVerifyElementIsVisible(driver, exchangePayoutOption, 2);
		Validator.assertTrue(flag1, "Test Failed! mode of regularization is not defaulted to exchange payout option", "mode of regularization is selected by default");
	}
	
	public void clickBackToOverview() {
		formID = applicationNo.getText();
	//	System.out.println("*** Application number submitted: "+formID);***
	}
	
	public void verifyOverviewPage() throws Exception {
		CommonUtility.cClick(driver, backToServiceBtn);
		try {
			CommonUtility.cClick(driver, close_account_dormat_link);
		} catch (Exception e) {
			CommonUtility.cExplicitlyWait(driver, close_account_dormat_link, 10);
			CommonUtility.cClick(driver, close_account_dormat_link);
		}
		boolean flag = CommonUtility.cVerifyElementIsPresent(driver, serviceOverviewHeader, 2);
		Validator.assertTrue(flag, "Not redirected to Overview page ", "Service Overview page is successfully displayed");
		WebElement appNo;
		try {
			appNo = CommonUtility.cFindElement(driver, By.xpath("//div[contains(text(),'"+formID+"')]") , 3);
			boolean flag1=CommonUtility.cVerifyElementIsVisible(driver, appNo, 1);
			Validator.assertTrue(flag1, "Overview page does not contain submitted form " +formID+" entry ", "Overview page contain submitted form entry");
		} catch (customElementNotFoundException e) {
			boolean flag1=false;
			Validator.assertTrue(flag1, "Overview page does not contain submitted form " +formID+" entry ", "Overview page contain submitted form entry");
		}
	}

	//private methods below ***
	private void selectDateinCalendar(Calendar calendar) throws Exception {
		SimpleDateFormat sdfMy = new SimpleDateFormat("MMMM yyyy");
		SimpleDateFormat sdfD = new SimpleDateFormat("d");
		
		String date = sdfD.format(calendar.getTime());		
		
		try
		{
			QAFWebElement monthYear = (QAFWebElement) CommonUtility.cFindElement(driver, By.xpath("//p[text()='"+sdfMy.format(calendar.getTime())+"']"), 10);
			CommonUtility.cExplicitlyWait(driver, monthYear, 1);
			driver.findElement(By.xpath("//p[text()='"+date+"']/ancestor::button[not(contains(@class,'hidden'))]")).click();
		} catch(Exception e)
		{
			QAFWebElement calendarNextBtn = (QAFWebElement) CommonUtility.cFindElement(driver, By.xpath("//p[text()='"+sdfMy.format(calendar1.getTime())+"']/../../button[2]"), 10);
			CommonUtility.cClick(driver, calendarNextBtn);
			driver.findElement(By.xpath("//p[text()='"+date+"']/ancestor::button[not(contains(@class,'hidden'))]")).click();
		}
	}
	
	private void selectMode(String mode) throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, modeOfRegularizationDD);
		switch(mode)
		{
		case "Exchange Release":
			CommonUtility.cClick(driver, exchangeReleaseOption); break;

		case "Fund Transfer":
			CommonUtility.cClick(driver, fundTransferOption); break;

		case "Exchange Payout":
			CommonUtility.cClick(driver, exchangePayoutOption); break;

		default:
			CommonUtility.cClick(driver, exchangeReleaseOption);
		}

	}
	private void selectPurpose(String purpose) throws customElementNotClickableException, customElementNotFoundException
	{
		CommonUtility.cClick(driver, purposeDD);
		switch(purpose)
		{
		case "Working Capital Requirement":
			CommonUtility.cClick(driver, workingCapitalOption); break;

		case "Exchange Obligation":
			CommonUtility.cClick(driver, exchangeObligationOption); break;

		default:
			CommonUtility.cClick(driver, workingCapitalOption); 
		}
	}
	
	private void addEmail(List<Map<String, String>> emailIds) throws customElementNotClickableException, customElementNotFoundException {
		for (Map<String, String> mail : emailIds) {
			for (Map.Entry<String, String> email : mail.entrySet()) {

				CommonUtility.cClick(driver, rmMailIds);
				CommonUtility.cSendKeys(driver, rmMailIdsTextBox, email.getValue());
				rmMailIdsTextBox.sendKeys(Keys.ENTER);
			}
		}
	}
	
	private void enterAmount(String amount) throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, amountTextBox);
		CommonUtility.cSendKeys(driver, amountTextBox, amount);
	}
	
	private void verifyDisabledRegularizationDate(int i) throws Exception {
		SimpleDateFormat sdfMy = new SimpleDateFormat("MMMM yyyy");
		SimpleDateFormat sdfD = new SimpleDateFormat("d");
		
		String date1 = sdfD.format(calendar.getTime());
		int date = Integer.parseInt(date1)+1;
		WebElement disabledRegDate;
		try {
			QAFWebElement monthYear = (QAFWebElement) CommonUtility.cFindElement(driver, By.xpath("//p[text()='"+sdfMy.format(calendar.getTime())+"']"), 5);
			CommonUtility.cExplicitlyWait(driver, monthYear, 1);
			disabledRegDate = CommonUtility.cFindElement(driver, By.xpath("//p[text()='"+date+"']/ancestor::button[contains(@class,'Disabled')]"), 1);
			boolean flag = CommonUtility.cVerifyElementIsVisible(driver, disabledRegDate, 1);
			Validator.assertTrue(flag, "Test Failed! 16th day from required date is not disabled", "Calender is as per requirement");
			
		} catch (customElementNotFoundException e) {
			QAFWebElement calendarNextBtn = (QAFWebElement) CommonUtility.cFindElement(driver, By.xpath("//p[text()='"+sdfMy.format(calendar1.getTime())+"']/../../button[2]"), 5);
			CommonUtility.cClick(driver, calendarNextBtn);
			disabledRegDate = CommonUtility.cFindElement(driver, By.xpath("//p[text()='"+date+"']/ancestor::button[contains(@class,'Disabled')]"), 1);
			boolean flag = CommonUtility.cVerifyElementIsVisible(driver, disabledRegDate, 1);
			Validator.assertTrue(flag, "Test Failed! 16th day from required date is not disabled", "Calender is as per requirement");
		}	
		CommonUtility.cClick(driver, amountTextBox);	
	}
	
	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub

	}
}
