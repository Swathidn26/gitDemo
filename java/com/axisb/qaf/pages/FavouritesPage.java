package com.axisb.qaf.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.axisb.qaf.utils.CommonUtility;
import com.qmetry.qaf.automation.core.AutomationError;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class FavouritesPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	@FindBy(locator = "xpath=//input[@id='transactionAmount']")
	private QAFWebElement amount_txt;
	@FindBy(locator = "xpath=//div[contains(@id,'networkId')]")
	private QAFWebElement paymentmode_dropdown;
	@FindBy(locator = "xpath=//input[@id='frequencyType']")
	private QAFWebElement frequency_checkbox;
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
	@FindBy(locator = "xpath=//span[text()='Payments']")
	private QAFWebElement payment_link;
	@FindBy(locator = "xpath=//label[@id='IFSCCode-label']")
	private QAFWebElement ifsccode_label;
	@FindBy(locator = "xpath=//span[text()='VIEW ALL']")
	private QAFWebElement viewall_link;
	@FindBy(locator = "xpath=//span[text()='All Favourites']")
	private QAFWebElement allfavorites_msg;
	@FindBy(locator = "xpath=//span[text()='Cancel']")
	private QAFWebElement cancel_btn;
	@FindBy(locator = "xpath=//button[contains(@class,'disableElevation')]/span[text()='Delete']")
	private QAFWebElement confirmDelete_btn;
	@FindBy(locator = "xpath=//td[text()='DOWNLOAD']/following-sibling::td/button[2]")
	private QAFWebElement favouriteDelete_btn;
	@FindBy(locator = "xpath=//span[text()='All Favourites']")
	private QAFWebElement allfavourites_message;
	@FindBy(locator = "xpath=//table/tbody/tr/td[2]")
	private List<WebElement> beneName_list;
	@FindBy(locator = "xpath=//*[text()='Successful']/parent::div")
	private QAFWebElement successful_link;
	@FindBy(locator = "xpath=//table/tbody/tr/table/tbody/tr/td[2]")
	private List<WebElement> successfulbeneName_list;
	@FindBy(locator = "xpath=//table/tbody/tr/table/tbody/tr/td[1]")
	private List<WebElement> starmark;
	@FindBy(locator = "xpath=//span[text()='Make Payment']/parent::button")
	private QAFWebElement makepayment_button;
	@FindBy(locator = "xpath=//*[contains(text(),'Fund Transfer is submitted and is pending for approval')]")
	private QAFWebElement fundtransfer_txt;
	@FindBy(locator = "xpath=//span[contains(text(),'Beneficiary')]/parent::button")
	private QAFWebElement beneficiary_tab;
	@FindBy(locator = "xpath=//input[@id='frequencyType']")
	private QAFWebElement recurringpayment_checkbox;
	@FindBy(locator = "xpath=//div[@id='menu-requestFrequency']/div[3]/ul/li")
	private List<WebElement> frequencytype_dropdown;
	@FindBy(locator = "xpath=//input[@id='totalNoOfInstances']/parent::div")
	private QAFWebElement installments_textfield;
	@FindBy(locator = "xpath=//*[@id='mui-component-select-requestFrequency']")
	private QAFWebElement frequencytypea;
	@FindBy(locator = "xpath=//div/div/div[2]/div[4]/div/div[5]")
	private QAFWebElement debitaccount;
	@FindBy(locator = "xpath=//div[text()='Recurring']")
	private QAFWebElement paymenttype_textfield;
	@FindBy(locator = "xpath=//p[text()='Amount']/following-sibling::p")
	private QAFWebElement amount_textfield;
	@FindBy(locator = "xpath=//p[text()='Pay To']/following-sibling::p")
	private QAFWebElement payTo_textfield;
	@FindBy(locator = "xpath=//span[contains(@class,'TransactionDetails_crossIcon')]")
	private QAFWebElement transactioncrossicon_textfield;

	@FindBy(locator = "xpath=//*[contains(@class,'headerSinglePayment')]/p")
	private QAFWebElement payeename;
	@FindBy(locator = "xpath=//*[@name='Add to favourites']/parent::span")
	private QAFWebElement addToFavouites_checkbox;

	@FindBy(locator = "xpath=//table/tbody/tr[1]/td[6]/button[2]")
	private QAFWebElement deletefavourite_btn;

	@FindBy(locator = "xpath=(//*[contains(@class,'Alert-message')])[1]")
	private QAFWebElement toastMsgBox;

	@FindBy(locator = "xpath=//table/tbody/tr/table/tbody/tr/td[1]//*[local-name()='svg']/*[local-name()='path' and @fill='#ED1164']")
	private QAFWebElement marked_favourite;

	@FindBy(locator = "xpath=//table/tbody/tr/table/tbody/tr[1]/td[2]")
	private QAFWebElement payTo_favouritename;


	@FindBy(locator = "xpath=//table/tbody/tr[1]/td[6]/button[1]/span")
	private QAFWebElement pay_btn;

	@FindBy(locator = "xpath=//table/tbody/tr/table/tbody/tr/td[1]//*[local-name()='svg']/*[local-name()='path' and @fill='#ED1164']/following::td[1]")
	private List<WebElement> marked_favouritetext;
	
	@FindBy(locator = "xpath=//*[(text()='Total Favourites: 0')]")
	private WebElement zero_Favourite;
	
	private static String payto=null;
	private static String actualamount=null;
	private static String debitamountvalue=null;
	static String benename;

	SinglePaymentPage singlepaymentpage = new SinglePaymentPage();

	public void markasFavouriteVendor(Map<String, String> vendorlist)throws Exception
	{
		WebElement favouritevendor=CommonUtility.cFindElement(driver, By.xpath("//*[text()='"+vendorlist.get("VendorName")+"']/following-sibling::td[text()='"+vendorlist.get("Amount")+"']/following-sibling::td[text()='"+vendorlist.get("Date")+"']/parent::tr/td[1]"), 30);
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, favouritevendor);
		CommonUtility.cExplicitlyWait(driver, favouritevendor, 30);
		CommonUtility.cClick(driver, favouritevendor);
	}

	public void markasFavouriteBeneficiary(Map<String, String> benelist)throws Exception
	{
		WebElement favouritebeneficiary=CommonUtility.cFindElement(driver,By.xpath("//*[text()='"+benelist.get("BeneficiaryName")+"']/following-sibling::td[text()='"+benelist.get("Date")+"']/parent::tr/td[1]"),10);
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, favouritebeneficiary);
		CommonUtility.cExplicitlyWait(driver, favouritebeneficiary, 30);
		CommonUtility.cClick(driver, favouritebeneficiary);
		Validator.assertTrue(true, "Test case failed as it is Unable to click on Star Mark", "Clicked on Star Mark");
	}

	public void markasFavourite() throws Exception
	{
		List<WebElement> element=CommonUtility.cFindElements(driver, By.xpath("//div[5]/div/table/tbody/tr/table/tbody/tr/td[2]"), 20);

		for(int i=1;i<=element.size();i++)
		{
			try {
				if(CommonUtility.cFindElement(driver, By.xpath("//table/tbody/tr["+i+"]/table/tbody/tr/td[1]//*[local-name()='svg']/*[local-name()='path' and @fill='#ED1164']/../../../.."), 10).isDisplayed())
				{
					continue;

				}}
			catch(Exception e) 
			{
				if(CommonUtility.cFindElement(driver,By.xpath("//table/tbody/tr["+i+"]/table/tbody/tr/td[1]//*[local-name()='svg']/*[local-name()='path' and @fill='#404040']/../../../.."),10).isDisplayed())
				{
					CommonUtility.cFindElement(driver, By.xpath("//div[5]/div/table/tbody/tr["+i+"]/table/tbody/tr/td[1]"), 10).click();
					break;
				}
				Validator.assertFalse(false, "Test data is not avaialble", " Clicked on Start mark");
			}}

	}

	public void markasUnFavourite() throws Exception
	{
		List<WebElement> element=CommonUtility.cFindElements(driver, By.xpath("//div[5]/div/table/tbody/tr/table/tbody/tr/td[2]"), 20);

		for(int i=1;i<=element.size();i++)
		{
			try {
				if(CommonUtility.cFindElement(driver, By.xpath("//table/tbody/tr["+i+"]/table/tbody/tr/td[1]//*[local-name()='svg']/*[local-name()='path' and @fill='#404040']/../../../.."), 10).isDisplayed())
				{
					continue;
				}}
			catch(Exception e) 
			{
				if(CommonUtility.cFindElement(driver, By.xpath("//table/tbody/tr["+i+"]/table/tbody/tr/td[1]//*[local-name()='svg']/*[local-name()='path' and @fill='#ED1164']/../../../.."), 10).isDisplayed())
				{
					CommonUtility.cFindElement(driver, By.xpath("//div[5]/div/table/tbody/tr["+i+"]/table/tbody/tr/td[1]"), 10).click();
					break;
				}
				Validator.assertFalse(false, "Test data is not avaialble", " Clicked on Start mark");
			}}
	}
	public void selectVendor(Map<String, String> vendorlist)throws Exception
	{
		boolean elementpresent=true;
		try {
			if(elementpresent)
			{
				CommonUtility.cFindElement(driver, By.xpath("//*[text()='"+vendorlist.get("VendorName")+"']/following-sibling::td[text()='"+vendorlist.get("Amount")+"']/following-sibling::td[text()='"+vendorlist.get("Date")+"']/parent::tr//*[local-name()='svg']/*[local-name()='path' and @fill='#ED1164']"), 10);
				Validator.assertFalse(false, "Test case failed as it is Not marked as favourite", "Already marked as favourite please use other test data");
			}}
		catch(Exception e)
		{
			elementpresent=false;
			markasFavouriteVendor(vendorlist);
			Validator.assertTrue(true, "Test case failed as it is Unable to click on Star Mark", "Clicked on Star Mark");

		}
	}

	public void selectBeneficiary(Map<String, String> benelist) throws Exception {
		boolean elementpresent=true;
		try {
			if(elementpresent)
			{
				CommonUtility.cFindElement(driver,By.xpath("//*[text()='"+benelist.get("BeneficiaryName")+"']/following-sibling::td[text()='"+benelist.get("Date")+"']/parent::tr//*[local-name()='svg']/*[local-name()='path' and @fill='#ED1164']"),10);
				Validator.assertFalse(false, "Test case failed as it is Not marked as favourite", "Already marked as favourite please use other test data");

			}}catch(Exception e)
		{
				elementpresent=false;
				markasFavouriteBeneficiary(benelist);
				Validator.assertTrue(true, "Test case failed as it is Unable to click on Star Mark", "Clicked on Star Mark");

		}
	}

	public void clickBeneficiaryTab() throws Exception {
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
		if(CommonUtility.cVerifyElementIsPresent(driver, beneficiary_tab, 2))
		CommonUtility.cClick(driver, beneficiary_tab);
		else
		throw new AutomationError("No beneficiary data / tab present for this corporate");
	}

	public void clickSuccessfullink() throws Exception {
		Thread.sleep(1000);
        CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
		CommonUtility.cClick(driver, successful_link);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);

	}

	public void clickViewAll() throws Exception {
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 90);
		if(CommonUtility.cVerifyElementIsPresent(driver, zero_Favourite, 5)) {
			throw new AutomationError("No beneficiary/ vendor marked as favourite for this corp user");
		}else {
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, viewall_link);
		CommonUtility.cClick(driver, viewall_link);
		}
	}

	public void verifyAllFavouritesText() throws Exception {
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 20);
		String favouritesmsg = allfavourites_message.getText();
		Validator.assertTrue(favouritesmsg.contains("All Favourites"), "Actual message : "+favouritesmsg + "is not as expected", favouritesmsg+ "message is diplayed as expected");
	}
	public void deleteanyFavourite() throws Exception 
	{
		CommonUtility.cExplicitlyWait(driver, deletefavourite_btn, 20);
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, deletefavourite_btn);
		CommonUtility.cFindElement(driver, deletefavourite_btn, 30).click();

	}
	public void deleteFavourite(Map<String, String> favouriteslist) throws Exception {
		List<WebElement> element=CommonUtility.cFindElements(driver, By.xpath("//table/tbody/tr/td[2]"), 0);
		for (int i = 1; i < element.size(); i++) {
			String benename[]= CommonUtility.cFindElement(driver,By.xpath("//table/tbody/tr[" + i + "]/td[2]"),10).getText().split("\\r\\n|\\n|\\r");
			String benenamevalue=benename[0];
			if (favouriteslist.get("BeneName").equals(benenamevalue)) {
				WebElement deleteFavourite=CommonUtility.cFindElement(driver, By.xpath("//table/tbody/tr[" + i + "]/td[6]/button[2]"),10);
				CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, deleteFavourite);
				CommonUtility.cClick(driver, deleteFavourite);
			}
		}
	}

	public void selectFavourite()throws Exception 
	{
		CommonUtility.cFindElement(driver, pay_btn, 10).click();
	}

	public void makePayment() throws Exception {
		List<WebElement> element = CommonUtility.cFindElements(driver, By.xpath("//table/tbody/tr/td[2]"), 10);
		for (int i = 1; i <=element.size(); i++) {
			String[] beneName=CommonUtility.cFindElement(driver,By.xpath("//table/tbody/tr[" + i + "]/td[2]"),10).getText().split("\\r\\n|\\n|\\r");
			String beneValue=beneName[0];
			if (benename.equalsIgnoreCase(beneValue)) {
				WebElement paybutton = CommonUtility.cFindElement(driver,By.xpath("//table/tbody/tr[" + i +"]/td[6]/button[1]"),10);
				CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, paybutton);
				CommonUtility.cClick(driver, paybutton); 
				Validator.assertTrue(true, "Test case failed  as it Unable to clicked on pay button", "clicked on pay button"); 
				break; 
			}

		}
	}
	public void favouriteVendorTransactionDetails() throws Exception
	{
		boolean markedfavouite=marked_favourite.isDisplayed();
		if(markedfavouite==true)
		{
			CommonUtility.cExplicitlyWait(driver, payTo_favouritename, 30);
			CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, payTo_favouritename);
			CommonUtility.cFindElement(driver,payTo_favouritename,10).click();
			CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, payTo_textfield);
			payto=CommonUtility.cFindElement(driver, payTo_textfield, 10).getText();
			CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, amount_textfield);
			actualamount=CommonUtility.cFindElement(driver, amount_textfield, 10).getText().replaceAll("[^0-9]", "");
			CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, debitaccount);
			String debitamount[]=CommonUtility.cFindElement(driver, debitaccount, 10).getText().split("\n");
			debitamountvalue=debitamount[1];
			CommonUtility.cClick(driver,transactioncrossicon_textfield);
		}else
		{
			Validator.assertTrue(true, "Favourite vendor is not available", "Clicked on Favourite vendor");
		}

	}

	public void VendorTransactionDetails() throws Exception
	{
			if(marked_favouritetext.size()>0)
			{
				for(int i=0;i<marked_favouritetext.size();i++)
				{
					benename=marked_favouritetext.get(i).getText();
					marked_favouritetext.get(i).click();
					break;
				}

			}
			else
				throw new AutomationError("No beneficiary data / tab present for this corporate"); 
			
		CommonUtility.cExplicitlyWait(driver, payTo_textfield, 10);
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, payTo_textfield);
		payto=CommonUtility.cFindElement(driver, payTo_textfield, 10).getText();
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, amount_textfield);
		actualamount=CommonUtility.cFindElement(driver, amount_textfield, 10).getText().replaceAll("[^0-9]", "");
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, debitaccount);
		String debitamount[]=CommonUtility.cFindElement(driver, debitaccount, 10).getText().split("\n");
		debitamountvalue=debitamount[1];
		CommonUtility.cClick(driver,transactioncrossicon_textfield);
	}

	public void favouriteVendorTransactionDetails(Map<String, String> favouritevendorlist) throws Exception
	{
		WebElement favouritevendor=CommonUtility.cFindElement(driver,By.xpath("//*[text()='"+favouritevendorlist.get("VendorName")+"']/following-sibling::td[text()='"+favouritevendorlist.get("Amount")+"']/following-sibling::td[text()='"+favouritevendorlist.get("Date")+"']/parent::tr"),10);
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, favouritevendor);
		CommonUtility.cClick(driver, favouritevendor);
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, payTo_textfield);
		payto=CommonUtility.cFindElement(driver, payTo_textfield, 10).getText();
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, amount_textfield);
		actualamount=CommonUtility.cFindElement(driver, amount_textfield, 10).getText().replaceAll("[^0-9]", "");
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, debitaccount);
		String debitamount[]=CommonUtility.cFindElement(driver, debitaccount, 10).getText().split("\n");
		debitamountvalue=debitamount[1];
		CommonUtility.cClick(driver,transactioncrossicon_textfield);
	}

	public void enterPaymentDetails(List<Map<String, String>> paymentdetails) throws Exception {
		String crn_textfield = CommonUtility.cFindElement(driver, crn_txt, 10).getAttribute("value");
		Validator.assertTrue(crn_textfield.isEmpty(), "Test case failed as CRN value pre-populated:"+crn_textfield, "CRN value is blank as expected");
		CommonUtility.cClick(driver, crn_txt);
		CommonUtility.cSendKeys(driver, crn_txt, CommonUtility.cRandomNumberGenerator(4));
		String invoice_textfield = CommonUtility.cFindElement(driver, invoicenumber_txt, 10).getAttribute("value");
		Validator.assertTrue(invoice_textfield.isEmpty(),"Test case failed as invoice value pre-populated:"+invoice_textfield,"invoice value is blank as expected");
		CommonUtility.cClick(driver, invoicenumber_txt);
		CommonUtility.cSendKeys(driver, invoicenumber_txt, CommonUtility.cRandomNumberGenerator(4));
		String lei_textfield = CommonUtility.cFindElement(driver, lei_txt, 10).getAttribute("value");
		Validator.assertTrue(lei_textfield.isEmpty(),"Test case failed as LEI value pre-populated:"+lei_textfield,"LEI value is blank as expected"); 
		CommonUtility.cClick(driver, lei_txt);
		CommonUtility.cSendKeys(driver, lei_txt, paymentdetails.get(0).get("LEI"));
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, creditnarration_txtarea);
		CommonUtility.cClick(driver, creditnarration_txtarea);
		CommonUtility.cSendKeys(driver, creditnarration_txtarea, paymentdetails.get(0).get("Credit Narration"));
		singlepaymentpage.clickOnRulesApplicable(paymentdetails);
		CommonUtility.cClick(driver, makepayment_button);
	}
	public void editPaymentDetails(List<Map<String, String>> paymentdetails) throws Exception 
	{
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
		CommonUtility.cClick(driver, amount_txt);
		CommonUtility.cClearUsingJavaScriptExecutor(driver, amount_txt);
		CommonUtility.cClearUsingJavaScriptExecutor(driver, amount_txt);
		CommonUtility.cSendKeys(driver, amount_txt, paymentdetails.get(0).get("Amount"));
		Thread.sleep(5000); 
		String value=installments_textfield.getAttribute("class");
		boolean flag= !(value.contains("Mui-disabled"));
		if(flag)
		{
			CommonUtility.cClick(driver, frequencytypea);
			List<WebElement> frequencytype=new ArrayList<>();
			try {
				frequencytype=CommonUtility.cFindElements(driver,frequencytype_dropdown, 10);
			}catch(Exception e)
			{
				CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
				CommonUtility.cClick(driver, frequencytypea);
				try {
					frequencytype=CommonUtility.cFindElements(driver,frequencytype_dropdown, 10);

				}catch(Exception e1){
					Validator.assertTrue(true, "Test failed as Frequency Dropdown is not loading beacuse of API Issues","Frequency Dropdown loaded and clicked successfully");
				}
			}
			for (int i = 0; i < frequencytype.size(); i++) 
			{
				CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
				CommonUtility.cExplicitlyWait(driver,frequencytype.get(i), 20); 
				if (frequencytype.get(i).getText().contains(paymentdetails.get(0).get("FrequencyType"))) {
					CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
					CommonUtility.cClick(driver, frequencytype.get(i));
					break;
				}
			}
			Thread.sleep(8000);
			CommonUtility.cClick(driver, installments_textfield); 
			CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
			CommonUtility.cClearUsingJavaScriptExecutor(driver, installments_textfield);
			CommonUtility.cClearUsingJavaScriptExecutor(driver, installments_textfield);
			CommonUtility.cSendKeys(driver,installments_textfield,paymentdetails.get(0). get("Installements")); 
		}
		singlepaymentpage.fromDropDown(paymentdetails);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
		CommonUtility.cClick(driver, crn_txt);
		CommonUtility.cSendKeys(driver, crn_txt, CommonUtility.cRandomNumberGenerator(4));
		CommonUtility.cClick(driver, invoicenumber_txt);
		try {
			CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
			CommonUtility.cClick(driver, invoicenumber_txt);
			CommonUtility.cSendKeys(driver, invoicenumber_txt,CommonUtility.cRandomNumberGenerator(4)); 
		}catch(Exception e)
		{
			CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
			CommonUtility.cClick(driver, invoicenumber_txt);
			CommonUtility.cSendKeys(driver, invoicenumber_txt,CommonUtility.cRandomNumberGenerator(4));
		}
		CommonUtility.cClick(driver,lei_txt); 
		CommonUtility.cSendKeys(driver, lei_txt, paymentdetails.get(0).get("LEI")); 
		CommonUtility.cClick(driver,creditnarration_txtarea); 
		CommonUtility.cSendKeys(driver,creditnarration_txtarea, paymentdetails.get(0).get("Credit Narration"));
		singlepaymentpage.clickOnRulesApplicable(paymentdetails);
		CommonUtility.cClick(driver, makepayment_button);
	}

	public void verifyfundTransferText() throws Exception
	{
		Thread.sleep(2000);
		boolean fundertransfertxt = fundtransfer_txt.isDisplayed();
		Validator.assertTrue(fundertransfertxt, "Failed! Fund Transfer is not submitted", "passed! Fund Transfer is submitted and is pending for approval");
	}
	public void clickConfirmDelete() throws Exception {
		CommonUtility.cClick(driver, confirmDelete_btn);
	}

	public void verifyRemovedToastMessage() throws Exception {
		String toastMessage = toastMsgBox.getText();	
		boolean addedfavouritemsg = false;
		if(toastMessage.contains("removed from favourites")) 
			addedfavouritemsg = true;
		Validator.assertTrue(addedfavouritemsg,"Actual Toast message : "+toastMessage+" is not as expected" , toastMessage + " Toastmessage is displayed as expected");
	}
	public void verifyRemovedToastMessage(String beneName) throws Exception {
		WebElement favouritebeneName = CommonUtility.cFindElement(driver,(By.xpath("//div[text()='" + beneName + " removed from favourites']/parent::div")),10);
		boolean toastMessageFavorite=CommonUtility.cVerifyElementIsPresent(driver, favouritebeneName, 10);
		Validator.assertTrue(toastMessageFavorite, "Toast message is not displayed", beneName+"removed from favourites");
	}
	public void verifyAddedToastMessage() throws Exception {
		String toastMessage = toastMsgBox.getText();	
		boolean addedfavouritemsg = false;
		if(toastMessage.contains("added as a favourite")) 
			addedfavouritemsg = true;
		Validator.assertTrue(addedfavouritemsg,"Actual Toast message : " +toastMessage + " is not as expected" , toastMessage + " Toastmessage is displayed as expected");

	}
	public void verifyAddedToastMessage(String benename) throws Exception {
		WebElement favouritevendorName=CommonUtility.cFindElement(driver,(By.xpath("//div[1]/div/div/div[text()='" + benename + " added as a favourite']")),10);
		boolean toastMessageFavorite=CommonUtility.cVerifyElementIsPresent(driver, favouritevendorName, 10);
		Validator.assertTrue(toastMessageFavorite, "Toast message is not dispalyed",benename+"added as a favourite");
	}
	public void verifyPrefilledDetails() throws Exception
	{
		CommonUtility.cExplicitlyWait(driver, amount_txt, 10);
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, amount_txt);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
		String amounttxtfield = CommonUtility.cFindElement(driver, amount_txt, 20).getAttribute("value").replace(",", "");
		Validator.assertTrue(amounttxtfield.equals(actualamount),"Test case failed as amount value is not equal Actual value is::"+amounttxtfield+",Expected value is:"+actualamount, "Amount value is equal:"+actualamount);
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, from_dropdown);
		CommonUtility.cExplicitlyWait(driver, from_dropdown, 90);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
		Thread.sleep(5000);
		String fromdropdown = CommonUtility.cFindElement(driver, from_dropdown, 10).getAttribute("value");
		Validator.assertTrue(fromdropdown.equalsIgnoreCase(debitamountvalue),"Test case failed as debit account numbers are not equal Actual value is:"+fromdropdown+" Expected value is:"+debitamountvalue,"Debit account numbers are equal:"+debitamountvalue);
		Thread.sleep(1000); 
		CommonUtility.cExplicitlyWait(driver, payeename, 30);
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, payeename);
		String Payeename=CommonUtility.cFindElement(driver, payeename, 10).getText();
		Validator.assertTrue(Payeename.contains(payto),"Test case failed as payeename is displayed incorrectly Actual value is:"+payto+" Expected value is:"+Payeename,"Payeename is displayed correctly:"+Payeename); { 
		}
	}
	public  void enterBeneficiaryPaymentDetails(List<Map<String, String>> paymentdetails) throws Exception
	{
		CommonUtility.cExplicitlyWait(driver, amount_txt, 15);
		CommonUtility.cMoveToElementByTarget(driver, amount_txt);
		CommonUtility.cClearUsingJavaScriptExecutor(driver, amount_txt);
		CommonUtility.cSendKeys(driver, amount_txt, paymentdetails.get(0).get("Amount"));
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
		CommonUtility.cClick(driver, paymentmode_dropdown);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 50);
		WebElement dropDownValue = CommonUtility.cFindElement(driver, By.xpath("//ul[@role='listbox']//li//span[text()='" + paymentdetails.get(0).get("Paymentmode") + "']"),10);
		CommonUtility.cClick(driver, dropDownValue);
		singlepaymentpage.fromDropDown(paymentdetails);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 70);
		CommonUtility.cClick(driver, crn_txt);
		CommonUtility.cSendKeys(driver, crn_txt, CommonUtility.cRandomNumberGenerator(4));
		CommonUtility.cClick(driver, invoicenumber_txt);
		CommonUtility.cSendKeys(driver, invoicenumber_txt, CommonUtility.cRandomNumberGenerator(4));
		CommonUtility.cClick(driver, lei_txt);
		CommonUtility.cSendKeys(driver, lei_txt, paymentdetails.get(0).get("LEI"));
		CommonUtility.cClick(driver, creditnarration_txtarea);
		CommonUtility.cSendKeys(driver, creditnarration_txtarea, paymentdetails.get(0).get("Credit Narration"));
		singlepaymentpage.clickOnRulesApplicable(paymentdetails);
		CommonUtility.cClick(driver, makepayment_button);
	}

	public void clickFavouitesCheckbox() throws Exception
	{
		CommonUtility.cClick(driver, addToFavouites_checkbox);
	}
	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {

	}
}
