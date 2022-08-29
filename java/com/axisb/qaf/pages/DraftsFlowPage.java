package com.axisb.qaf.pages;

import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class DraftsFlowPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	public static String draftDate1;
	public static String draftDate2;
	public static String draftDate3;
	public static String sortBy1;
	public static String sortBy2;
	public String actualDraftName;
	public Map<String, Date> unsortedMap;
	public Map<String, Date> sortedMapOldToNew;
	public Map<String, Date> sortedMapDisplayedNewToOld;

	@FindBy(locator = "xpath=//a[contains(text(),'Payments Overview')]")
	private QAFWebElement payments_overview;

	@FindBy(locator = "xpath=//div[@id='mainTab']//div[text()='Pending']")
	private QAFWebElement pending_link;

	@FindBy(locator = "//table/tbody/tr/table/tbody/tr/td[2]")
	private List<WebElement> drafts_list;

	@FindBy(locator = "xpath=//span[contains(text(),'Save as draft')]")
	private QAFWebElement savedraft_btn;

	@FindBy(locator = "xpath=//div[@class='MuiAlert-message']")
	private QAFWebElement alert_message;

	@FindBy(locator = "xpath=//div/span[contains(text(), 'Drafts')]")
	private QAFWebElement drafts_tab;

	@FindBy(locator = "xpath=//span[text()='Save as draft']")
	private QAFWebElement save_as_draft;

	@FindBy(locator = "xpath=//button//span[text()='Yes']")
	private QAFWebElement yes_btn;

	@FindBy(locator = "xpath=(// span[text()='Proceed'])[2]")
	private QAFWebElement proceed2;

	@FindBy(locator = "xpath=//p[text()='Payments']")
	private QAFWebElement paymentsTab;

	@FindBy(locator = "xpath=//div[@id='editPageHandler']")
	private List<WebElement> editPageHandler;

	@FindBy(locator = "xpath=//div[@id='editPageHandlerGst']")
	private List<WebElement> editPageHandlerGst;

	@FindBy(locator = "xpath=//div[@id='deleteDraftsHandler']")
	private QAFWebElement deletePayment;

	@FindBy(locator = "xpath=//p[contains(text(),'Saved on')]")
	private static List<WebElement> allDraftDate;

	@FindBy(locator = "xpath=//p[contains(@class,'draftsrecords_amount__1QXKt')]")
	private static List<WebElement> allDraftAmount;

	@FindBy(locator = "xpath=//p//span[contains(text(),'Sort by:')]")
	private QAFWebElement sortBy;
	
	@FindBy(locator = "xpath=//*[@id='mui-component-select-networkId']")
	private QAFWebElement paymentmode_dropdown;

	@FindBy(locator = "xpath=//input[@id='transactionAmount']")
	private QAFWebElement amount_txt;

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {

	}
	public void initiateNewPayment(List<Map<String, String>> paymentDetails) throws Exception {
		SinglePaymentPage s = new SinglePaymentPage();
		s.clickNewPayments();
		s.clickVendorPayments();
		Thread.sleep(9000);
		s.enterPaymentDetails(paymentDetails);
	}
	public void alertMessage() throws Exception {
		Boolean alertFlag = CommonUtility.cVerifyElementIsPresent(driver, alert_message, 20);
		Validator.assertTrue(alertFlag, "Unable to fetch the alert message after clicking on Delete Draft button"+alert_message.getText(), alert_message.getText());
	}
	public void verifySaveAsDraftSuccessMsg() throws Exception {
		String toastMessage = CommonUtility.cFindElement(driver, By.xpath("//*[contains(@class,'Alert-message')]"), 20).getText();	
		boolean SuccessFlag = false;
		if(toastMessage.equalsIgnoreCase(("Transaction Saved Successfully"))) 
			SuccessFlag = true;
		Validator.assertTrue(SuccessFlag,
				"Transaction failed! Message displayed as :"+toastMessage +" instead of success",
				"Transaction Saved Successfully");	
	}
	public void saveAsDraft()throws Exception {
		CommonUtility.cExplicitlyWait(driver, save_as_draft, 15);
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 120);
		CommonUtility.cClickUsingJavaScriptExecutor(driver, save_as_draft);
//		CommonUtility.cClick(driver, save_as_draft);
		CommonUtility.cExplicitlyWait(driver, yes_btn, 15);
		CommonUtility.cClick(driver, yes_btn);
	}

	public void verifyDrafts(List<Map<String, String>> expectedDraftName) throws Exception {
		Thread.sleep(10000);
		CommonUtility.cExplicitlyWait(driver, drafts_tab, 10);
		CommonUtility.cClick(driver, drafts_tab);
		CommonUtility.cWaitForPageLoad(driver);
		Thread.sleep(10000);
		try {
			String drafts = "(//*[text()='" + expectedDraftName.get(0).get("DraftsName") + "'])[1]";
			WebElement draftName = CommonUtility.cFindElement(driver, By.xpath(drafts), 10);
			CommonUtility.cExplicitlyWait(driver, draftName, 15);
			actualDraftName = draftName.getText();
			boolean draftFlag = actualDraftName.contains(expectedDraftName.get(0).get("DraftsName"));
			Validator.assertTrue(draftFlag, expectedDraftName.get(0).get("DraftsName") + " and " + actualDraftName + "are not matching",
					"Verified successfully" + expectedDraftName.get(0).get("DraftsName") + " is saved as Draft");
		} catch (Exception e) {
			Validator.assertTrue(false, expectedDraftName + " and " + actualDraftName + "are not matching",
					"Verified successfully" + expectedDraftName.get(0).get("DraftsName") + " is saved as Draft");
		}
	}
	public void proceed()
			throws customElementNotFoundException, customElementNotClickableException, InterruptedException {
		CommonUtility.cExplicitlyWait(driver, proceed2, 25);
		CommonUtility.cClick(driver, proceed2);
		Thread.sleep(5000);
	}	
	public void enterErrorPaymentDetails(List<Map<String, String>> paymentdetails) throws Exception {
		SinglePaymentPage s = new SinglePaymentPage();
		s.clickNewPayments();
		s.clickVendorPayments();
		Reporter.logWithScreenShot("Passed");
		Thread.sleep(9000);
		CommonUtility.cExplicitlyWait(driver, amount_txt, 15);
		CommonUtility.cMoveToElementByTarget(driver, amount_txt);
		CommonUtility.cSendKeys(driver, amount_txt, paymentdetails.get(0).get("Amount"));
		CommonUtility.cClick(driver, paymentmode_dropdown);
		WebElement dropDownValue = CommonUtility.cFindElement(driver,
				By.xpath("//ul[@role='listbox']//li//span[text()='" + paymentdetails.get(0).get("Paymentmode") + "']"),
				10);
		CommonUtility.cClick(driver, dropDownValue);
		s.fromDropDown(paymentdetails);
		s.toDropDown(paymentdetails);
	}

	public void deleteDrafts(List<Map<String, String>> expectedValue)
			throws InterruptedException, customElementNotFoundException, customElementNotClickableException {
		Thread.sleep(10000);
		CommonUtility.cExplicitlyWait(driver, drafts_tab, 10);
		CommonUtility.cClick(driver, drafts_tab);
		CommonUtility.cWaitForPageLoad(driver);
		Thread.sleep(10000);
		int totalPayments = editPageHandler.size() + editPageHandlerGst.size();
		int payments = Integer.parseInt(paymentsTab.getText().replaceAll("[^0-9]", ""));
		for (int i = 1; i < totalPayments; i++) {
			if (totalPayments == payments) {
				Validator.assertTrue(true, "Total payments and payments are not equal",
						"Total Payments and payments are equal");
			}
			String drafts = "//p[contains(text(),'" + expectedValue.get(0).get("DraftsName") + "')]";
			WebElement draftName = CommonUtility.cFindElement(driver, By.xpath(drafts), 10);
			CommonUtility.cExplicitlyWait(driver, draftName, 15);
			String actualValue = draftName.getText();
			if (actualValue.contains(expectedValue.get(0).get("DraftsName"))) {
				CommonUtility.cClick(driver, deletePayment);
				CommonUtility.cExplicitlyWait(driver, yes_btn, 25);
				CommonUtility.cClick(driver, yes_btn);
				break;
			}
		}
	}

	public void sortDrafts() throws InterruptedException, customElementNotFoundException,
			customElementNotClickableException, ParseException, customElementFoundException {
		Thread.sleep(10000);
		CommonUtility.cExplicitlyWait(driver, drafts_tab, 10);
		CommonUtility.cExplicitlyWaitForAbsence(driver, By.xpath("//div/span[contains(text(), 'Drafts')]"), 20);
		CommonUtility.cClick(driver, drafts_tab);
		CommonUtility.cWaitForPageLoad(driver);
		Thread.sleep(10000);
		ArrayList<Date> obtainedListDate = new ArrayList<Date>();
		for (int i = 0; i < allDraftDate.size(); i++) {
			String date = allDraftDate.get(i).getText();
			String date1 = date.toString().replace("Saved on", "").trim();
			String date2 = date1.substring(0, 10);
			Date formattedDate = new SimpleDateFormat("dd/MM/yyyy").parse(date2);
			obtainedListDate.add(formattedDate);
		}
		ArrayList<String> obtainedListName = new ArrayList<String>();
		for (int i = 0; i < allDraftAmount.size(); i++) {
			String amount = allDraftAmount.get(i).getText();
			obtainedListName.add(amount);
		}
		unsortedMap = new LinkedHashMap<String, Date>();
		for (int i = 0; i < obtainedListDate.size(); i++) {

			unsortedMap.put(obtainedListName.get(i) + "index" + i, obtainedListDate.get(i));

		}
	}

	public void sortDraftsOldToNew()
			throws customElementNotClickableException, customElementNotFoundException, ParseException {
		List<Entry<String, Date>> entryList = new ArrayList<Entry<String, Date>>(unsortedMap.entrySet());
		Collections.reverse(entryList);
		sortedMapOldToNew = new LinkedHashMap<String, Date>();
		for (Entry<String, Date> entry : entryList) {

			sortedMapOldToNew.put(entry.getKey(), entry.getValue());
		}
		CommonUtility.cClick(driver, sortBy);
		ArrayList<Date> SortedListDateOldToNewDisplayed = new ArrayList<Date>();
		for (int i = 0; i < allDraftDate.size(); i++) {
			String date = allDraftDate.get(i).getText();
			String date1 = date.toString().replace("Saved on", "").trim();
			String date2 = date1.substring(0, 10);
			Date formattedDate = new SimpleDateFormat("dd/MM/yyyy").parse(date2);
			SortedListDateOldToNewDisplayed.add(formattedDate);
		}
		ArrayList<String> SortedListNameOldToNewDisplayed = new ArrayList<String>();
		for (int i = 0; i < allDraftAmount.size(); i++) {
			String amount = allDraftAmount.get(i).getText();
			SortedListNameOldToNewDisplayed.add(amount);
		}
		Map<String, Date> sortedMapDisplayedOldToNew = new LinkedHashMap<String, Date>();
		for (int i = 0; i < SortedListDateOldToNewDisplayed.size(); i++) {
			sortedMapDisplayedOldToNew.put(SortedListNameOldToNewDisplayed.get(i) + "index" + i,
					SortedListDateOldToNewDisplayed.get(i));
		}
		List<String> amountListSorted = new ArrayList<String>(sortedMapOldToNew.keySet());
		List<Date> dateListSorted = new ArrayList<Date>(sortedMapOldToNew.values());
		List<String> amountListSortedD = new ArrayList<String>(sortedMapDisplayedOldToNew.keySet());
		List<Date> dateListSortedD = new ArrayList<Date>(sortedMapDisplayedOldToNew.values());
		boolean sortedFlag = true;
		String errorMsg = "";
		for (int i = 0; i < amountListSorted.size(); i++) {
			String amount = amountListSorted.get(i).replaceAll("index.*", "");
			String amountSD = amountListSortedD.get(i).replaceAll("index.*", "");
			if (dateListSorted.get(i).equals(dateListSortedD.get(i)) && amount.equals(amountSD)) {
				continue;
			} else {
				sortedFlag = false;
				errorMsg = "Sorting doesn't match at index:" + (i + 1) + " for Amount/Beneficiary as: " + amountSD
						+ " and Date as  " + dateListSortedD.get(i);
				Validator.assertTrue(false, errorMsg,
						"Verified successfully and List of data are in ascending order for sorting order as Old to New");
			}
		}
		Validator.assertTrue(sortedFlag, errorMsg,
				"Verified successfully and List of data are in ascending order for sorting order as Old to New");

	}

	public void sortDraftsNewToOld()
			throws customElementNotClickableException, customElementNotFoundException, ParseException {
		List<Entry<String, Date>> entryListNew = new ArrayList<Entry<String, Date>>(sortedMapOldToNew.entrySet());
		Collections.reverse(entryListNew);
		Map<String, Date> sortedMapNewToOld = new LinkedHashMap<String, Date>();
		for (Entry<String, Date> entry : entryListNew) {
			sortedMapNewToOld.put(entry.getKey(), entry.getValue());
		}
		CommonUtility.cClick(driver, sortBy);
		ArrayList<Date> SortedListDateNewToOldDisplayed = new ArrayList<Date>();
		for (int i = 0; i < allDraftDate.size(); i++) {
			String date = allDraftDate.get(i).getText();
			String date1 = date.toString().replace("Saved on", "").trim();
			String date2 = date1.substring(0, 10);
			Date formattedDate = new SimpleDateFormat("dd/MM/yyyy").parse(date2);
			SortedListDateNewToOldDisplayed.add(formattedDate);
		}
		ArrayList<String> SortedListNameNewToOldDisplayed = new ArrayList<String>();
		for (int i = 0; i < allDraftAmount.size(); i++) {
			String amount = allDraftAmount.get(i).getText();
			SortedListNameNewToOldDisplayed.add(amount);
		}
		sortedMapDisplayedNewToOld = new LinkedHashMap<String, Date>();
		for (int i = 0; i < SortedListDateNewToOldDisplayed.size(); i++) {

			sortedMapDisplayedNewToOld.put(SortedListNameNewToOldDisplayed.get(i) + "index" + (i + 1),
					SortedListDateNewToOldDisplayed.get(i));

		}
		List<String> amountListSortedNO = new ArrayList<String>(sortedMapNewToOld.keySet());
		List<Date> dateListSortedNO = new ArrayList<Date>(sortedMapNewToOld.values());
		List<String> amountListSortedDNO = new ArrayList<String>(sortedMapDisplayedNewToOld.keySet());
		List<Date> dateListSortedDNO = new ArrayList<Date>(sortedMapDisplayedNewToOld.values());
		boolean sortedFlagNO = true;
		String errorMsgNO = "";
		for (int i = 0; i < amountListSortedNO.size(); i++) {
			String amountNO = amountListSortedNO.get(i).replaceAll("index.*", "");
			String amountSDNO = amountListSortedDNO.get(i).replaceAll("index.*", "");
			if (dateListSortedNO.get(i).equals(dateListSortedDNO.get(i)) && amountNO.equals(amountSDNO)) {
				continue;
			} else {
				sortedFlagNO = false;
				errorMsgNO = "Sorting doesn't match at index:" + (i + 1) + " for Amount/Beneficiary as: " + amountSDNO
						+ " and Date as  " + dateListSortedDNO.get(i);
				Validator.assertTrue(false, errorMsgNO,
						"Verified successfully and List of data are in ascending order for sorting order as Old to New");
			}
		}
		Validator.assertTrue(sortedFlagNO, errorMsgNO,
				"Verified successfully and List of data are in ascending order for sorting order as Old to New");

	}

	public void sortedMaps() throws customElementNotFoundException, customElementNotClickableException {
		sortBy1 = sortBy.getText();
		CommonUtility.cExplicitlyWait(driver, sortBy, 20);
		CommonUtility.cClick(driver, sortBy);
		sortBy2 = sortBy.getText();
		Boolean sortFlag = sortBy1 == sortBy2 ? true : false;
		if (sortFlag == false) {
			Validator.assertTrue(true, "Sort by:New to Old and Sort by:Old to New are equal",
					"Sort by:New to Old and Sort by:Old to New are not equal");
		} else {
			Validator.assertTrue(false, "Sort by:New to Old and Sort by:Old to New are equal",
					"Sort by:New to Old and Sort by:Old to New are not equal");
		}

	}

}