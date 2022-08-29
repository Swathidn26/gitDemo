package com.axisb.qaf.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.axisb.qaf.pages.*;
import com.axisb.qaf.exceptions.customElementFoundException;
import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.utils.CommonUtility;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

public class BeneficiaryManagementPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	public static String beneficiaryName;
	@FindBy(locator = "xpath=(//a[text()='Beneficiary Management'])[1]")
	private QAFWebElement beneficiary_management_tab1;

	@FindBy(locator = "xpath=(//a[text()='Beneficiary Management'])[2]")
	private QAFWebElement beneficiary_management_tab2;

	@FindBy(locator = "xpath=//p[contains(text(),'Disabled Beneficiaries')]")
	private QAFWebElement disabledbeneficaries_link;

	@FindBy(locator = "xpath=//*[@id='cardCmp']//p[text()='Total Beneficiaries']")
	private QAFWebElement total_link;

	@FindBy(locator = "xpath=//p[contains(text(),'Pending  Beneficiaries')]")
	private QAFWebElement pendingbeneficaries_link;

	@FindBy(locator = "xpath=//*[@id='mui-component-select-ruleId']")
	private QAFWebElement ruleapplicable_dropdown;

	@FindBy(locator = "xpath=//*[@id='menu-ruleId']//div[3]/ul/li/span")
	private QAFWebElement ruleapplicable_dropdownvalue;

	@FindBy(locator = "xpath=(//div[@aria-haspopup='listbox'])[2]")
	private QAFWebElement approver_dropdown;

	@FindBy(locator = "xpath=//*[@id='menu-']/div[3]/ul/li[1]/span[1]")
	private QAFWebElement approver_dropdownvalue;

	@FindBy(locator = "xpath=//span[text()='Apply Rule']")
	private QAFWebElement applyrule_btn;

	@FindBy(locator = "xpath=//span[text()='Close']")
	private QAFWebElement close_btn;

	@FindBy(locator = "xpath=//span[text()='Yes']")
	private QAFWebElement yes_btn;

	@FindBy(locator = "xpath=(//button[contains(@class,'OTPBeneManagement_closeWindowIcon__2Ef_n')]/span)[1]")
	private QAFWebElement otpclose_btn;

	@FindBy(locator = "xpath=//table/tbody/tr/table/tbody/tr/td[2]")
	private List<WebElement> benelist; 

	@FindBy(locator = "xpath=//table/tbody/tr/table/tbody/tr")
	private List<WebElement> tableBenelist;

	@FindBy(locator = "xpath=//table/tbody/tr[2]/table/tbody/tr/td[1]")
	private QAFWebElement favourite_beneficiary;

	@FindBy(locator = "xpath=//div/h3[text()='Enter One-Time Password']")
	private QAFWebElement otp_verify;

	@FindBy(locator = "xpath=//div[@class='MuiAlert-message']")
	private QAFWebElement alert_message;

	@FindBy(locator = "xpath=//*[@id='cardCmp']//p[text()='Total Beneficiaries']/..//h3")
	private QAFWebElement tot_bene_count;

	@FindBy(locator = "xpath=//table/tbody/tr[2]/table/tbody/tr/td[2]")
	private QAFWebElement beneNameValue;

	@FindBy(locator = "xpath=//button//span[text()='Make Payment']")
	private QAFWebElement make_payment;

	@FindBy(locator = "xpath=//div//p[text()='Fund Transfer is submitted and is pending for approval']")
	private QAFWebElement verify_make_payment;

	/**************** Beneficiaries Count Verification ***************************/

	@FindBy(locator = "xpath=//p[contains(text(),'Total Beneficiaries')]/preceding::h3[1]")
	private QAFWebElement total_Beneficiaries_Count;

	@FindBy(locator = "xpath=//p[contains(text(),'Disabled Beneficiaries')]/preceding::h3[1]")
	private QAFWebElement disabled_Beneficiaries_Count;

	@FindBy(locator = "xpath=//p[contains(text(),'Pending  Beneficiaries')]/preceding::h3[1]")
	private QAFWebElement pending_Beneficiaries_Count;

	@FindBy(locator = "xpath=//span[text()='Proceed']")
	private QAFWebElement proceed_btn;
	String tableRow = "//table/tbody/tr/table/tbody/tr";

	public void verify_beneficiaries_total_count() throws Exception {
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 120);
		int total_Bene_Count = Integer.parseInt(total_Beneficiaries_Count.getText());
		List<WebElement> bene_table_row_count = driver.findElements(By.xpath(tableRow));
		int total_bene_table_Count = bene_table_row_count.size();
		boolean benecountEquals=total_bene_table_Count==total_Bene_Count?true:false;
		Validator.assertTrue(benecountEquals,"[Failed! Overall 	Beneficiary total Count : " +total_Bene_Count+ " Not Matching the number of beneficiaries displayed : " + total_bene_table_Count+"]",
				"Passed! Overall Beneficiary total count : " +total_Bene_Count+ " Matching the number of beneficiaries displayed : " + total_bene_table_Count);
	}

	public void verify_disabled_beneficiaries_total_count() throws Exception {
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, disabledbeneficaries_link);
		CommonUtility.cClick(driver, disabledbeneficaries_link);
		int disabled_Bene_Count = Integer.parseInt(disabled_Beneficiaries_Count.getText());
		List<WebElement> disabled_bene_table_row_count = driver.findElements(By.xpath(tableRow));
		int total_bene_table_Count = disabled_bene_table_row_count.size();
		boolean benecountEquals=total_bene_table_Count==disabled_Bene_Count?true:false;
		Validator.assertTrue(benecountEquals, "[Failed! Overall Disabled beneficiary total count : " +disabled_Bene_Count+ " Not Matching the number of disabled beneficiaries displayed : " + total_bene_table_Count+"]",
				"Passed! Overall Disabled beneficiary total count : " +disabled_Bene_Count+ " Matching the number of disbaled beneficiaries displayed : " + total_bene_table_Count);
	}

	public void verify_pending_beneficiaries_total_count() throws Exception {
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, pendingbeneficaries_link);
		CommonUtility.cClick(driver, pendingbeneficaries_link);
		Thread.sleep(4000);
		int pending_Bene_Count = Integer.parseInt(pending_Beneficiaries_Count.getText());
		List<WebElement> bene_table_row_count = driver.findElements(By.xpath(tableRow));
		int total_bene_table_Count = bene_table_row_count.size();
		boolean benecountEquals=total_bene_table_Count==pending_Bene_Count?true:false;
		Validator.assertTrue(benecountEquals, "[Failed! Overall Pending beneficiary total Count : " +pending_Bene_Count+ " Not Matching the number of pending beneficiaries displayed : " + total_bene_table_Count+"]",
				"Passed! Overall Pending beneficiary total count : " +pending_Bene_Count+ " Matching the number of pending beneficiaries displayed : " + total_bene_table_Count);
	}

	public void clickBeneManagement() throws customElementNotClickableException, customElementNotFoundException,
	customElementFoundException, Exception {
		CommonUtility.cWaitForPageLoad(driver);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 120);
		try {
			CommonUtility.cClick(driver, beneficiary_management_tab1);
		} catch (Exception e) {
			CommonUtility.cClick(driver, beneficiary_management_tab2);
		}
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 120);
	}
	public void clickCloseButton()
			throws customElementNotClickableException, customElementNotFoundException, InterruptedException {
		CommonUtility.cExplicitlyWait(driver, otpclose_btn, 10);
		CommonUtility.cClick(driver, otpclose_btn);
	}

	public void clickDisabledBeneficaries()
			throws customElementNotClickableException, customElementNotFoundException, InterruptedException {
		CommonUtility.cClick(driver, disabledbeneficaries_link);
	}

	public void clickTotalBeneficaries()
			throws customElementNotClickableException, customElementNotFoundException, InterruptedException {
		CommonUtility.cClick(driver, total_link);
	}

	public void clickPendingBeneficaries()
			throws customElementNotClickableException, customElementNotFoundException, InterruptedException {
		CommonUtility.cClick(driver, pendingbeneficaries_link);
	}

	public void selectDisabledBeneficary() throws Exception {
		try {
			clickDisabledBeneficaries();
			CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 120);
		} catch (Exception e) {
			for (int i = 0; i < 3; i++) {
				clickDisabledBeneficaries();
				CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 120);
				if (beneNameValue.isDisplayed()) {
					break;
				}
			}
		}
		CommonUtility.cFindElements(driver, benelist, 2);
		for (int i = 2; i <= benelist.size(); i++) {
			WebElement beneDetails = CommonUtility.cFindElement(driver,
					By.xpath("//table/tbody/tr[" +i+ "]/table/tbody/tr/td[2]"), 10);
			String beneName = beneDetails.getText();
			try {
				Boolean flag = CommonUtility.cVerifyElementIsPresent(driver,
						CommonUtility.cFindElement(driver, By.xpath(
								"//table/tbody/tr[" +i+ "]/table/tbody/tr/td[7]//span[text()='Disabled']"), 20),
						20);
				if (flag == true) {
					WebElement ToEnable = CommonUtility.cFindElement(driver,
							By.xpath("//table/tbody/tr[" +i+ "]/table/tbody/tr/td[7]"), 20);
					CommonUtility.cMoveToElementByTarget(driver, ToEnable);
					CommonUtility.cClick(driver, yes_btn);
					break;
				}
			} catch (Exception e) {
				continue;
			}
			if (CommonUtility.cVerifyElementIsPresent(driver, CommonUtility.cFindElement(driver,
					By.xpath("//table/tbody/tr[" +i+ "]/table/tbody/tr/td[7]//span[text()='Disabled']"), 20),
					20) == false) {
				Validator.assertTrue(false, "Test Failed! Unable to do the Disabled Beneficiaries " + beneName
						+ " at index " + i
						+ " as Enable.As no transactions were present. Please check the screenshot for more info.",
						"Test Passed! Successfully did the Beneficiary " + beneName + " at index" + i + "as Enabled.");
			}
		}
	}
	

	public void selectEnabledBeneficary() throws Exception {
		clickTotalBeneficaries();
		CommonUtility.cFindElements(driver, benelist, 2);
		for (int i = 2; i <= benelist.size(); i++) {
			WebElement beneDetails = CommonUtility.cFindElement(driver,
					By.xpath("//table/tbody/tr[" + i + "]/table/tbody/tr/td[2]"), 20);
			String beneName = beneDetails.getText();
			try {
				WebElement ToEnable = CommonUtility.cFindElement(driver,
						By.xpath("//table/tbody/tr[" + i + "]/table/tbody/tr/td[7]"), 20);
				Actions actions = new Actions(driver);
				actions.moveToElement(ToEnable).perform();
				Boolean flag = CommonUtility.cVerifyElementIsPresent(driver,
						CommonUtility.cFindElement(driver,
								By.xpath("//table/tbody/tr[" + i + "]/table/tbody/tr/td[7]//span[text()='Enabled']"), 20),20);
				if (flag == true) {
					CommonUtility.cMoveToElementByTarget(driver, ToEnable);
					CommonUtility.cClick(driver, yes_btn);
					Validator.assertTrue(true, "Test Failed! Unable to do the Enabled Beneficiaries " + beneName
							+ " at index " + i
							+ " as Disable.As no transactions were present. Please check the screenshot for more info.",
							"Test Passed! Successfully did the Beneficiary " + beneName + " at index" + i
									+ "as Disabled.");
					break;
				}
			} catch (Exception e) {
				continue;
			}
			if (CommonUtility.cVerifyElementIsPresent(driver,CommonUtility.cFindElement(driver,By.xpath("//table/tbody/tr[" + i + "]/table/tbody/tr/td[7]//span[text()='Enabled']"), 20),20) == false) {
				Validator.assertTrue(false, "Test Failed! Unable to do the Enabled Beneficiaries " + beneName
						+ " at index " + i
						+ " as Disable.As no transactions were present. Please check the screenshot for more info.",
						"Test Passed! Successfully did the Beneficiary " + beneName + " at index" + i + "as Disabled.");
			}
		}
	}
	public void deleteBeneficary(Map<String, String> deletedbeneDetails) throws Exception {
		CommonUtility.cWaitForPageLoad(driver);
		clickTotalBeneficaries();
		CommonUtility.cFindElements(driver, benelist, 2);
		for (int i = 2; i <=benelist.size(); i++) {
			String beneName = CommonUtility.cFindElement(driver, By.xpath("//table/tbody/tr[" + i + "]/table/tbody/tr/td[2]"), 20).getText();
			try {
				WebElement kebabMenu = CommonUtility.cFindElement(driver, By.xpath("//table/tbody/tr[" + i + "]/table/tbody/tr/td[8]/div/div"), 10);
				CommonUtility.cMoveToElementByTarget(driver, kebabMenu);
				WebElement deleteButton = CommonUtility.cFindElement(driver, By.xpath("//table/tbody/tr[" + i + "]/table/tbody/tr/td[8]/div/div//li[text()='Delete']"), 20);
				CommonUtility.cClick(driver, deleteButton);
				break;
			}
			catch(Exception e) {
				continue;
			}
			}
		CommonUtility.cClick(driver, ruleapplicable_dropdown);
		CommonUtility.cExplicitlyWait(driver, ruleapplicable_dropdownvalue, 5);
		CommonUtility.cClick(driver, ruleapplicable_dropdownvalue);
		CommonUtility.cExplicitlyWait(driver, approver_dropdown, 5);
		CommonUtility.cClick(driver, approver_dropdown);
		CommonUtility.cExplicitlyWait(driver, approver_dropdownvalue, 5);
		CommonUtility.cClick(driver, approver_dropdownvalue);
		CommonUtility.cClick(driver, applyrule_btn);
		CommonUtility.cClick(driver, yes_btn);
	}
	
	public void markFavouriteBeneficary() throws Exception {
		CommonUtility.cWaitForPageLoad(driver);
		CommonUtility.cFindElements(driver, tableBenelist, 2);
		for (int i = 2; i < tableBenelist.size(); i=i+2) {
			try {
				if(CommonUtility.cVerifyElementIsPresent(driver, CommonUtility.cFindElement(driver, By.xpath("//table/tbody/tr[" + i + "]/table/tbody/tr/td[1]//*[local-name()='svg']/*[local-name()='path' and @fill='#ED1164']/../../../.."), 10), 10) || CommonUtility.cVerifyElementIsPresent(driver, CommonUtility.cFindElement(driver, By.xpath("//table/tbody/tr["+i+"]/table/tbody/tr/td[contains(@class,'table_disabletext_')]"), 10), 10) == true)
				{
					continue;
				}
			}
			catch(Exception e) 
			{
				try {
					WebElement unStarred = CommonUtility.cFindElement(driver,By.xpath("//table/tbody/tr["+i+"]/table/tbody/tr/td[1]//*[local-name()='svg']/*[local-name()='path' and @fill='#404040']/../../../.."),10);
					Boolean flag = CommonUtility.cVerifyElementIsPresent(driver, unStarred, 20);
					if(flag==true) {
						WebElement star = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/table/tbody/tr/td[1]"));
						WebElement beneName = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/table/tbody/tr/td[2]"));
						beneficiaryName= beneName.getText();
						CommonUtility.cExplicitlyWait(driver, star, 50);
						CommonUtility.cClick(driver, star);
						Thread.sleep(3000);
						alertMessage();
						CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 20);
						WebElement afterStarClick = CommonUtility.cFindElement(driver,By.xpath("//table/tbody/tr[" + i + "]/table/tbody/tr/td[1]//*[local-name()='svg']/*[local-name()='path' and @fill='#ED1164']/../../../.."),10);
						Boolean starFlag = CommonUtility.cVerifyElementIsPresent(driver, afterStarClick, 20)? true :false;
						Validator.assertTrue(starFlag, "Test Failed! Unable to click on star mark", "Test Passed! successfully clicked on star mark");
						Validator.assertTrue(true, "Test Failed! Unable to mark the Beneficiary "+beneficiaryName+" at index "+i+" as favourite. Please check the screenshot for more info.", "Test Passed! Successfully marked the Beneficiary "+beneficiaryName+" at index" +i+ "as favourite.");
						break;
					}
				}
				catch(Exception e1) {
					Validator.assertTrue(false, "Test Failed! Unable to mark the Beneficiary "+beneficiaryName+" at index "+i+" as favourite. Please check the screenshot for more info.", "Test Passed! Successfully marked the Beneficiary "+beneficiaryName+" at index" +i+ "as favourite.");
				}
			}

		}
	}
	public void markUnFavouriteBeneficary() throws Exception {
		CommonUtility.cWaitForPageLoad(driver);
		CommonUtility.cFindElements(driver, tableBenelist, 2);
		for (int i = 2; i < tableBenelist.size(); i=i+2) {
			try {
				if(CommonUtility.cVerifyElementIsPresent(driver, CommonUtility.cFindElement(driver, By.xpath("//table/tbody/tr[" + i + "]/table/tbody/tr/td[1]//*[local-name()='svg']/*[local-name()='path' and @fill='#404040']/../../../.."), 10), 10) || CommonUtility.cVerifyElementIsPresent(driver, CommonUtility.cFindElement(driver, By.xpath("//table/tbody/tr["+i+"]/table/tbody/tr/td[contains(@class,'table_disabletext_')]"), 10), 10) == true)
				{
					continue;
				}
			}
			catch(Exception e) 
			{
				try {
					WebElement Starred = CommonUtility.cFindElement(driver,By.xpath("//table/tbody/tr[" + i + "]/table/tbody/tr/td[1]//*[local-name()='svg']/*[local-name()='path' and @fill='#ED1164']/../../../.."),10);
					Boolean flag = CommonUtility.cVerifyElementIsPresent(driver, Starred, 20);
					if(flag==true) {
						WebElement star = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/table/tbody/tr/td[1]"));
						WebElement beneName = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/table/tbody/tr/td[2]"));
						beneficiaryName= beneName.getText();
						CommonUtility.cExplicitlyWait(driver, star, 50);
						CommonUtility.cClick(driver, star);
						Thread.sleep(3000);
						alertMessage();
						CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 20);
						WebElement afterStarClick = CommonUtility.cFindElement(driver,By.xpath("//table/tbody/tr[" + i + "]/table/tbody/tr/td[1]//*[local-name()='svg']/*[local-name()='path' and @fill='#404040']/../../../.."),10);
						Boolean unStarFlag = CommonUtility.cVerifyElementIsPresent(driver, afterStarClick, 20)? true :false;
						Validator.assertTrue(unStarFlag, "Test Failed! Unable to click on star mark", "Test Passed! successfully clicked on star mark");
						Validator.assertTrue(true, "Test Failed! Unable to mark the Beneficiary "+beneficiaryName+" at index "+i+" as unFavourite. Please check the screenshot for more info.", "Test Passed! Successfully marked the Beneficiary "+beneficiaryName+" at index" +i+ "as unFavourite.");
						break;
					}
				}
				catch(Exception e1) {
					Validator.assertTrue(false, "Test Failed! Unable to mark the Beneficiary "+beneficiaryName+" at index "+i+" as unFavourite. Please check the screenshot for more info.", "Test Passed! Successfully marked the Beneficiary "+beneficiaryName+" at index" +i+ "as unFavourite.");
				}
			}

		}
	}	

	public void verifyOtp()	throws Exception {
		CommonUtility.cExplicitlyWait(driver, otp_verify, 8);
		Boolean otp = CommonUtility.cVerifyElementIsPresent(driver, otp_verify, 20);
		try{
			Validator.assertTrue(otp, "Failed! OTP Screen is not displaying", "passed! OTP Screen is Displaying");
			clickCloseButton();
		}
		catch(Exception e) {
			Validator.assertTrue(otp, "Failed! OTP Screen is not displaying", "passed! OTP Screen is Displaying");
		}
	}

	public void alertMessage() throws customElementNotFoundException {
		CommonUtility.cExplicitlyWait(driver, alert_message, 15);
		try {
			Boolean alert = alert_message.isDisplayed();
			Validator.assertTrue(alert, "Failed! Alert message is not displaying", "Passed!"+alert_message.getText());
		}
		catch(Exception e) {
			Validator.assertTrue(false, "Failed! Alert message is not displaying", "Passed!"+alert_message.getText());
		}
	}

	public void makePayment(Map<String, String> makePayment) throws customElementNotClickableException,
	customElementNotFoundException, InterruptedException, customElementFoundException {
		clickTotalBeneficaries();
		CommonUtility.cFindElements(driver, benelist, 2);
		for (int i = 2; i <=benelist.size(); i++) {
			String beneName = CommonUtility.cFindElement(driver, By.xpath("//table/tbody/tr[" + i + "]/table/tbody/tr/td[2]"), 10).getText();	
			if (makePayment.get("BeneficiaryName").equalsIgnoreCase(beneName)) {
				WebElement kebabMenu = driver
						.findElement(By.xpath("//table/tbody/tr[" + i + "]/table/tbody/tr/td[8]/div/div"));
				CommonUtility.cMoveToElementByTarget(driver, kebabMenu);
				WebElement makePaymentButton = driver.findElement(
						By.xpath("//table/tbody/tr[" + i + "]/table/tbody/tr/td[8]/div/div/div/div/ul/li[1]"));
				CommonUtility.cClick(driver, makePaymentButton);
				break;
			}
		}
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 120);

	}
	public void verifyMakePayment()throws Exception {
		CommonUtility.cClick(driver, proceed_btn);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 120);
		CommonUtility.cClick(driver, make_payment);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 120);
		Boolean makePayment = CommonUtility.cVerifyElementIsPresent(driver, verify_make_payment, 20);              
		Validator.assertTrue(makePayment, "Failed! Fund Transfer is not submitted due to Duplicate CRN value", "passed! Fund Transfer is submitted and is pending for approval");
		}
	public void deletePaymentBeneficary(Map<String, String> deletedbeneDetails) throws Exception{
		CommonUtility.cWaitForPageLoad(driver);
		clickTotalBeneficaries();
		CommonUtility.cFindElements(driver, benelist, 2);
		for (int i = 2; i < benelist.size(); i++) {
			String beneName = CommonUtility.cFindElement(driver, By.xpath("//table/tbody/tr[" + i + "]/table/tbody/tr/td[2]"), 20).getText();
			if (deletedbeneDetails.get("BeneficiaryName").equalsIgnoreCase(beneName)) {
				WebElement kebabMenu = CommonUtility.cFindElement(driver, By.xpath("//table/tbody/tr[" + i + "]/table/tbody/tr/td[8]/div/div"), 10);
				CommonUtility.cMoveToElementByTarget(driver, kebabMenu);
				WebElement deleteButton = CommonUtility.cFindElement(driver, By.xpath("//table/tbody/tr[" + i + "]/table/tbody/tr/td[8]/div/div//li[text()='Delete']"), 20);
				CommonUtility.cClick(driver, deleteButton);
				break;
			}
		}
		CommonUtility.cClick(driver, ruleapplicable_dropdown);
		CommonUtility.cExplicitlyWait(driver, ruleapplicable_dropdownvalue, 5);
		CommonUtility.cClick(driver, ruleapplicable_dropdownvalue);
		CommonUtility.cExplicitlyWait(driver, approver_dropdown, 5);
		CommonUtility.cClick(driver, approver_dropdown);
		CommonUtility.cExplicitlyWait(driver, approver_dropdownvalue, 5);
		CommonUtility.cClick(driver, approver_dropdownvalue);
		CommonUtility.cClick(driver, applyrule_btn);
		CommonUtility.cClick(driver, yes_btn);
	}

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub
	}
}