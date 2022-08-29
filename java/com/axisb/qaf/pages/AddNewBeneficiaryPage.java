package com.axisb.qaf.pages;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

public class AddNewBeneficiaryPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	@FindBy(locator = "xpath=//span[text()='Payments']")
	private QAFWebElement payment_link;
	@FindBy(locator = "xpath=//label[@id='IFSCCode-label']")
	private QAFWebElement ifsccode_label;
	@FindBy(locator = "xpath=//input[@id='corpId']")
	private QAFWebElement corpid_txt;
	@FindBy(locator = "xpath=//input[@id='userId']")
	private QAFWebElement corpuname_txt;
	@FindBy(locator = "xpath=//button[@class='login_Loginbutton__28Ifz']")
	private QAFWebElement login_btn;
	@FindBy(locator = "xpath=//span[contains(text(),'Add Beneficiary')]/../..")
	private QAFWebElement addbene_link;
	@FindBy(locator = "xpath=//input[@value='AXIS']/parent::span")
	private QAFWebElement axisbank_radiobtn;
	@FindBy(locator = "xpath=//input[@value='AXIS']/ancestor::span[contains(@class,'checked')]")
	private QAFWebElement axisbank_radiobtn_checked;
	@FindBy(locator = "xpath=//*[@id='beneAccountNumber']")
	private QAFWebElement beneaccno_txt;
	@FindBy(locator = "xpath=//*[@id='confirmBeneAN']")
	private QAFWebElement confirmbeneaccno_txt;
	@FindBy(locator = "xpath=(//a[text()='Beneficiary Management'])[1]")
	private QAFWebElement bene_link;
	@FindBy(locator = "xpath=//input[@name='Add to favourites']")
	private QAFWebElement addtofaviourtes_checkbox;
	@FindBy(locator = "xpath=//input[@id='beneAccountName']")
	private QAFWebElement beneacctname_txt;
	@FindBy(locator = "xpath=//div[@id='benetype']")
	private QAFWebElement benetype_dropdown;
	@FindBy(locator = "xpath=//span[text()='Individual / Govt. Entity']")
	private QAFWebElement benetypevalue_dropdown;
	@FindBy(locator = "xpath=//input[@id='lei']")
	private QAFWebElement lei_txt;
	@FindBy(locator = "xpath=//div[@id='accountCategory']/span[contains(text(),'Select')]")
	private QAFWebElement acccategory_dropdown;
	@FindBy(locator = "xpath=//span[text()='Salary']")
	private QAFWebElement acccategoryvalue_dropdown;
	@FindBy(locator = "xpath=//input[@id='beneficiaryCode']")
	private QAFWebElement benecode_txt;
	@FindBy(locator = "xpath=//*[@id='ad1']/div[2]/span[1]/parent::div")
	private QAFWebElement additionaldetails_btn;
	@FindBy(locator = "xpath=//input[@id='mobileNumber']")
	private QAFWebElement mobileno_btn;
	@FindBy(locator = "xpath=//input[@id='email']")
	private QAFWebElement email_txt;
	@FindBy(locator = "xpath=//input[@id='addressLineOne']")
	private QAFWebElement addresslineone_txt;
	@FindBy(locator = "xpath=//input[@id='addressLineTwo']")
	private QAFWebElement addresslinetwo_txt;
	@FindBy(locator = "//input[@id='mui-79865']")
	private QAFWebElement city_txt;
	@FindBy(locator = "//input[@id='mui-91613']")
	private QAFWebElement state_txt;
	@FindBy(locator = "xpath=//input[@id='pincode']")
	private QAFWebElement pincode_txt;
	@FindBy(locator = "xpath=//textarea[@name='remarks']")
	private QAFWebElement remarks_txtarea;
	@FindBy(locator = "xpath=//span[text()='Proceed']/parent::button")
	private QAFWebElement proceed_btn;
	@FindBy(locator = "xpath=//span[text()='Submit']/parent::button")
	private QAFWebElement submit_btn;
	@FindBy(locator = "xpath=//*[text()= 'and is pending for approval']")
	private QAFWebElement beneficiary_txt;
	@FindBy(locator = "xpath=//span[text()='Cancel']")
	private QAFWebElement cancel_btn;
	@FindBy(locator = "xpath=//span[text()='Save as draft']")
	private QAFWebElement saveasdraft_btn;
	@FindBy(locator = "xpath=//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text ifsc-modal_findIFSCBtn__2g2lF']")
	private QAFWebElement ifsc_link;
	@FindBy(locator = "xpath=//input[@placeholder='City']")
	private QAFWebElement citytxt;
	@FindBy(locator = "xpath=//input[@placeholder='Bank Name']")
	private QAFWebElement bankname_txt;
	@FindBy(locator = "xpath=//input[@placeholder='Branch']")
	private QAFWebElement branch_txt;
	@FindBy(locator = "xpath=//span[text()='Select IFSC']")
	private QAFWebElement ifsc_btn;
	@FindBy(locator = "xpath=//input[@name='ifscCode']")
	private QAFWebElement ifsccode_txt;
	@FindBy(locator = "xpath=//div[@id='mui-component-select-ruleId']")
	private QAFWebElement rules_dropdown;
	@FindBy(locator = "xpath=//span[text()='2 GENERAL']")
	private QAFWebElement dropdownvalue_dropdown;
	@FindBy(locator = "xpath=//li[@data-value='APPROVER3']")
	private QAFWebElement approvervalue_dropdown;
	@FindBy(locator = "xpath=(//div[@aria-haspopup='listbox'])[5]")
	private QAFWebElement approver;

	LoginPage loginpage = new LoginPage();
	JavascriptExecutor  js=(JavascriptExecutor)driver;

	public void openUrl(Map<String, String> dataTable) throws Exception {
		loginpage.loginUsingSSO(dataTable);
		driver.manage().window().maximize();

	}

	public void login(List<Map<String, String>> loginDetails) throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cSendKeys(driver, corpid_txt, loginDetails.get(0).get("corpid"));
		CommonUtility.cSendKeys(driver, corpuname_txt, loginDetails.get(0).get("corpuname"));
	}

	public void clickLoginButton() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, login_btn);
	}

	public void clickPayments() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, payment_link);
	}

	public void clickBeneManagement() throws Exception  {
		try{
			CommonUtility.cClick(driver, bene_link);
			CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
		}
		catch(Exception e)
		{
			CommonUtility.cFindElement(driver, By.xpath("(//a[@id='paymentsSub3'])[1]"), 10).click();
		}
	}
	public void clickAddBeneficiary() throws Exception {
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
		CommonUtility.cClick(driver, addbene_link);
	}

	public void clickProceed() throws Exception   {
		try {
			CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
		CommonUtility.cClick(driver,proceed_btn);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
		}catch(Exception e)
		{
			Reporter.logWithScreenShot("Unable to click on proceed as Rules are not loaded");
		}
	}

	public void clickSubmit() throws Exception {
		try{
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
		CommonUtility.cClick(driver,submit_btn);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);;
		}catch(Exception e)
		{
			Reporter.logWithScreenShot("Unable to click on submit as Rules are not loaded");
		}
	}
	
	
	public void verifyBeneficiaryText() throws Exception{
		CommonUtility.cWaitForPageLoad(driver);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);;
		String benetext = beneficiary_txt.getText();
		Assert.assertTrue(benetext.contains("and is pending for approval"));
	}
	public void clickAxisBank() throws Exception{
		CommonUtility.cClickUsingJavaScriptExecutor(driver, axisbank_radiobtn);
	}
	public void enterAddNewBeneficiaryDetails(List<Map<String, String>> beneficiarydetails) throws Exception {
		CommonUtility.cWaitForPageLoad(driver);
		boolean axis_radiobutton=false;
		try {
			axis_radiobutton=CommonUtility.cFindElement(driver, axisbank_radiobtn_checked, 10).isEnabled();
		}
		catch(Exception e)
		{
			axis_radiobutton=false;
		}
		if(axis_radiobutton==false)
		{
			String beneaccountnumber=CommonUtility.cRandomNumberGenerator(10);
			CommonUtility.cSendKeys(driver, beneaccno_txt, beneaccountnumber);
			CommonUtility.cSendKeys(driver, confirmbeneaccno_txt, beneaccountnumber);
			if (ifsccode_label.isPresent()) {
				CommonUtility.cSendKeys(driver, ifsccode_txt, beneficiarydetails.get(0).get("IFSCCode"));
			}
			js.executeScript("window.scrollBy(0,100)", "");
			CommonUtility.cExplicitlyWait(driver, beneacctname_txt, 10);
			if(beneacctname_txt.isEnabled())
			{
			CommonUtility.cSendKeys(driver, beneacctname_txt, beneficiarydetails.get(0).get("BeneAcctname"));
			}
		}
		else {
			CommonUtility.cSendKeys(driver,beneaccno_txt,beneficiarydetails.get(0).get("BeneAccno"));
			CommonUtility.cSendKeys(driver,confirmbeneaccno_txt,beneficiarydetails.get(0).get("confirmBeneAccno"));
			
		}

	
	WebElement benetypeelement = null;
	try {
		CommonUtility.cExplicitlyWait(driver, benetype_dropdown, 50);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
		CommonUtility.cClick(driver, benetype_dropdown);
		String benetypevalue=beneficiarydetails.get(0).get("BeneType"); 
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
		benetypeelement=CommonUtility.cFindElement(driver, By.xpath("//span[text()='"+benetypevalue+"']"), 10);
		CommonUtility.cClick(driver, benetypeelement);
	} catch (Exception e) {
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, benetype_dropdown);
		CommonUtility.cClick(driver, benetype_dropdown);
		String benetypevalue=beneficiarydetails.get(0).get("BeneType"); 
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
		benetypeelement=CommonUtility.cFindElement(driver, By.xpath("//span[text()='"+benetypevalue+"']"), 10);
		CommonUtility.cClick(driver, benetypeelement);
	}
	CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
	if(axis_radiobutton==false && beneficiarydetails.get(0).get("BeneType").contains("Non-Individual"))
	{
		
		CommonUtility.cExplicitlyWait(driver, lei_txt, 10);
		if(lei_txt.isEnabled())
		{
			CommonUtility.cSendKeys(driver,lei_txt,beneficiarydetails.get(0).get("LEI"));
		}
		
	}
	CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
	CommonUtility.cClick(driver, acccategory_dropdown);
	CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
	String value=beneficiarydetails.get(0).get("AccountCategory");
	CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
    WebElement accCategory_element=CommonUtility.cFindElement(driver,By.xpath("//span[text()='"+value+"']"), 40);
    accCategory_element.click();
    CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
	CommonUtility.cSendKeys(driver, benecode_txt,CommonUtility.cRandomNumberGenerator(8));
	try {
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
		CommonUtility.cClickUsingJavaScriptExecutor(driver, additionaldetails_btn);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
	}catch(Exception e)
	{
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
		CommonUtility.cClick(driver, additionaldetails_btn);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
	}
	CommonUtility.cSendKeys(driver, mobileno_btn, beneficiarydetails.get(0).get("Mobileno"));
	CommonUtility.cSendKeys(driver, email_txt, beneficiarydetails.get(0).get("Email"));
	CommonUtility.cSendKeys(driver, addresslineone_txt, beneficiarydetails.get(0).get("AddressLine1"));
	CommonUtility.cSendKeys(driver, addresslinetwo_txt, beneficiarydetails.get(0).get("AddressLine2"));
	CommonUtility.cSendKeys(driver, pincode_txt, beneficiarydetails.get(0).get("Pincode"));
	CommonUtility.cWaitForPageLoad(driver);
	CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
	try {
	CommonUtility.cClick(driver, rules_dropdown);
	CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
	CommonUtility.cClick(driver, dropdownvalue_dropdown);
	CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
	}
	catch(Exception e)
	{
		Validator.assertTrue(false, "Failed: Rules Dropdown are not loading beacuse Test Data is already used please change Test data",
				"Passed: Rules dropdown loaded and clicked successfully");
	}
	try {
	CommonUtility.cClick(driver, approver);
	List<WebElement> approver1value = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"),
			5);
	for (int i = 0; i < approver1value.size(); i++) {
		if (approver1value.get(i).getText().contains(beneficiarydetails.get(0).get("Approver"))) {
			CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
			CommonUtility.cClick(driver, approver1value.get(i));
			break;
		}
	}}catch(Exception e)
	{
		Reporter.logWithScreenShot("Test Data is already used");
	}
	CommonUtility.cSendKeys(driver, remarks_txtarea, beneficiarydetails.get(0).get("Remarks"));
}
@Override
protected void openPage(PageLocator arg0, Object... arg1) {

}
}