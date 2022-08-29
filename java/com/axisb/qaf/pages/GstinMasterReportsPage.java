package com.axisb.qaf.pages;

import java.util.List;

import java.awt.Desktop.Action;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.util.PaneInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.utils.CommonUtility;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.util.ExpectedCondition;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

import io.cucumber.core.gherkin.Argument;
import io.cucumber.datatable.DataTable;

public class GstinMasterReportsPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "xpath=(//button[@type='button'])[1]")
	private QAFWebElement menuIcon;
	
	@FindBy(locator = "xpath=//span[text()='GSTIN Master Report']")
	private QAFWebElement reportsLink1;
	
	@FindBy(locator = "xpath=(//span[text()='Reports'])[2]")
	private QAFWebElement reportsLink2;

	@FindBy(locator = "xpath=(//*[text()='GSTIN Master Report'])[4]")
	private QAFWebElement gstinMasterReport;

	@FindBy(locator = "xpath=//div[@id='0']")
	private QAFWebElement newTemplate;

	@FindBy(locator = "xpath=(//*[text()='GSTIN Master Report'])[4]")
	private QAFWebElement uatgstinMasterReports;

	@FindBy(locator = "xpath=//*[@id='last1Week']/span")
	private QAFWebElement lastoneweekLink;

	@FindBy(locator = "xpath=//button[@id='last7Days']")
	private QAFWebElement last7days;

	@FindBy(locator = "xpath=//span[text()='Last 1 month']")
	private QAFWebElement lastOneMonth;

	@FindBy(locator = "xpath=//button[@id='last30Days']")
	private QAFWebElement last30days;

	@FindBy(locator = "xpath=//span[text()='Last 3 months']")
	private QAFWebElement lastThreeMonths;

	@FindBy(locator = "xpath=//button[@id='last90Days']")
	private QAFWebElement last90days;

	@FindBy(locator = "xpath=//span[text()='Generate Report']")
	private QAFWebElement generateReport;

	@FindBy(locator = "xpath=//span[text()='Download']")
	private QAFWebElement downloadBtn;

	@FindBy(locator = "xpath=//span[text()='PDF']")
	private QAFWebElement pdfFormat;

	@FindBy(locator = "xpath=//span[text()='Download report in .xls']")
	private QAFWebElement downloadThreeMoonths;

	@FindBy(locator = "xpath=(//input[@type='text'])[1]")
	private QAFWebElement startDate;

	@FindBy(locator = "xpath=(//input[@type='text'])[2]")
	private QAFWebElement endDate;

	@FindBy(locator = "xpath=//div/label[text()='PAN']/following-sibling::div/div")
	private QAFWebElement panNumber;

	@FindBy(locator = "xpath=//div/label[text()='State']/following-sibling::div/div")
	private QAFWebElement stateSelect;

	@FindBy(locator = "xpath=//div[@id='initiated_by']")
	private QAFWebElement selectInitiator;

	@FindBy(locator = "xpath=//div/label[text()='GSTIN']/following-sibling::div/div")
	private QAFWebElement gstinNumber;

	@FindBy(locator = "xpath=//div/label[text()='Status']/following-sibling::div/div")
	private QAFWebElement statusCheck;

	@FindBy(locator = "xpath=//span[text()='Custom Template']/preceding::span[1]")
	private QAFWebElement customTemplate;

	@FindBy(locator = "xpath=//span[text()='Delete']")
	private QAFWebElement deleteButton;

	@FindBy(locator = "xpath=//div[text()='Template deleted successfully']")
	private QAFWebElement deleteToastMsg;

	@FindBy(locator = "xpath=//span[text()='Save Template']")
	private QAFWebElement saveTemplate;

	@FindBy(locator = "xpath=(//input[@type='text'])[3]")
	private QAFWebElement templateName;

	@FindBy(locator = "xpath=//label[text()='Template Name']/following-sibling::div/input")
	private QAFWebElement newtemplate;

	@FindBy(locator = "xpath=//span[text()='Save as New template']/ancestor::button")
	private QAFWebElement saveAsNewTemplate;

	@FindBy(locator = "xpath=//span[text()='Customize']")
	private QAFWebElement customizebutton;

	@FindBy(locator = "xpath=//span[text()='Apply']/ancestor::button")
	private QAFWebElement applybutton;

	@FindBy(locator = "xpath=//span[text()='Save Changes']/ancestor::button")
	private QAFWebElement saveChanges;

	@FindBy(locator = "xpath=//span[text()='Reset']")
	private QAFWebElement resetbutton;

	@FindBy(locator = "xpath=//span[text()='Download report in .xls']/ancestor::button")
	private QAFWebElement threemonthdownloadbtn;

	public void clickGstinReports() throws Exception {
		CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 60);
		if (menuIcon.isDisplayed()) {
			CommonUtility.cClick(driver, menuIcon);
			clickReportsMenu();
			clickGSTINMasterReport();
		} else {
			clickReportsMenu();
			clickGSTINMasterReport();
		}

	}

	public void clickReportsMenu() throws Exception {
		boolean reportsflag1 = CommonUtility.cVerifyElementIsPresent(driver, reportsLink1, 3);
		boolean reportsflag2 = CommonUtility.cVerifyElementIsPresent(driver, reportsLink2, 3);
		if (reportsflag1||reportsflag2 == true) {
		try {
			CommonUtility.cClick(driver, reportsLink1);
		} catch (Exception e) {
			CommonUtility.cClick(driver, reportsLink2);
		}
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ESCAPE).build().perform();
			Validator.assertTrue(reportsflag1||reportsflag2, "Failed to click on GSTIN master reports",
					"Successfully clicked on GSTIN Master Reports");
		} else {
			Validator.assertTrue(reportsflag1||reportsflag2, "Failed to click on GSTIN master reports",
					"Successfully clicked on GSTIN Master Reports");
		}
	}

	public void clickGSTINMasterReport() throws Exception {
		boolean gstinmasterflag = CommonUtility.cVerifyElementIsPresent(driver, gstinMasterReport, 3);
		if (gstinmasterflag == true) {
			CommonUtility.cClick(driver, gstinMasterReport);
			Validator.assertTrue(gstinmasterflag, "Failed to click on master Reports",
					"Successfully clicked on Master Reports");
		} else {
			Validator.assertTrue(gstinmasterflag, "Failed to click on master Reports",
					"Successfully clicked on Master Reports");
		}
	}

	public void selectLastOneWeek() throws Exception {
		Boolean lastoneweekflag = CommonUtility.cVerifyElementIsPresent(driver, last7days, 3);
		if (lastoneweekflag == true) {
			CommonUtility.cMoveToElementByTarget(driver, last7days);
			CommonUtility.cClick(driver, last7days);
			Validator.assertTrue(lastoneweekflag, "Failed to click Last 7 days link",
					"Successfully clicked on Last 7 days link");
		} else {
			Validator.assertTrue(lastoneweekflag, "Failed to click Last 7 days link",
					"Successfully clicked on Last 7 days link");
		}
		clickGenerate();
	}

	public void selectLastOneMonth() throws Exception {
		boolean lastonemonthflag = CommonUtility.cVerifyElementIsPresent(driver, last30days, 3);
		if (lastonemonthflag == true) {
			CommonUtility.cMoveToElementByTarget(driver, last30days);
			CommonUtility.cClick(driver, last30days);
			Validator.assertTrue(lastonemonthflag, "Failed to click on last one month link",
					"Successfully clicked on Lst one month link");
		} else {
			Validator.assertTrue(lastonemonthflag, "Failed to click on last one month link",
					"Successfully clicked on Lst one month link");
		}
		clickGenerate();
	}

	public void selectLastThreeMonths() throws Exception {
		boolean last90daysflag = CommonUtility.cVerifyElementIsPresent(driver, last90days, 3);
		if (last90daysflag == true) {
			CommonUtility.cClick(driver, last90days);
			Validator.assertTrue(last90daysflag, "Failed to click on last 90 days button",
					"Successfully clicked on last 90 days link");
		} else {
			Validator.assertTrue(last90daysflag, "Failed to click on last 90 days button",
					"Successfully clicked on last 90 days link");
		}
		CommonUtility.cClick(driver, generateReport);

		if (threemonthdownloadbtn.isPresent()) {
			boolean threemonthsflag = CommonUtility.cVerifyElementIsPresent(driver, threemonthdownloadbtn, 2);
			if (threemonthsflag == true) {
				CommonUtility.cClick(driver, threemonthdownloadbtn);
				Validator.assertTrue(threemonthsflag, "Failed to click on download button",
						"Successfully clicked on download buton");
			} else {
				Validator.assertTrue(threemonthsflag, "Failed to click on download button",
						"Successfully clicked on download buton");
			}
			deleteBeforeDownload();
			boolean pdfflag = CommonUtility.cVerifyElementIsPresent(driver, pdfFormat, 2);
			if (pdfflag == true) {
				CommonUtility.cClick(driver, pdfFormat);
				Validator.assertTrue(pdfflag, "Failed to click on PDF button", "Successfully clicked on PDF buton");
			} else {
				Validator.assertTrue(pdfflag, "Failed to click on PDF button", "Successfully clicked on PDF buton");
			}
		} else {

			deleteBeforeDownload();
			clickToDownload();
		}
	}

	public void clickGenerate() throws Exception {
		boolean generateflag = CommonUtility.cVerifyElementIsPresent(driver, generateReport, 3);
		if (generateflag == true) {
			CommonUtility.cExplicitlyWait(driver, generateReport, 2);
			CommonUtility.cClick(driver, generateReport);
			Validator.assertTrue(generateflag, "Failed to click Generate Report",
					"Generate report button was clicked successfully");
		} else {
			Validator.assertTrue(generateflag, "Failed to click Generate Report",
					"Generate report button was clicked successfully");
		}
		deleteBeforeDownload();
		clickToDownload();
	}

	public void clickToDownload() throws Exception {
		deleteBeforeDownload();
		boolean downloadflag = CommonUtility.cVerifyElementIsPresent(driver, downloadBtn, 3);
		if (downloadflag == true) {
			CommonUtility.cClick(driver, downloadBtn);
			Validator.assertTrue(downloadflag,
					"Failed to click download button,please refer the screenshot for the reference",
					"Successfully clicked on download button");
		} else {
			Validator.assertTrue(downloadflag,
					"Failed to click download button,please refer the screenshot for the reference",
					"Successfully clicked on download button");
		}
		boolean pdfflag = CommonUtility.cVerifyElementIsPresent(driver, pdfFormat, 3);
		if (pdfflag == true) {
			CommonUtility.cClick(driver, pdfFormat);
			Validator.assertTrue(pdfflag, "Failed to click on PDF button", "Successfully clicked on PDF button");
		} else {
			Validator.assertTrue(pdfflag, "Failed to click on PDF button", "Successfully clicked on PDF button");
		}

	}

	public void verifyFileDownload() {
		boolean fileFoundFlag = false;
		File file = new File(System.getProperty("user.home") + "\\Downloads");
		File[] fileLists = file.listFiles();
		for (File file2 : fileLists) {
			if (file2.getName().contains("linked_gst_report")) {
				fileFoundFlag = true;
			}
		}
		if (fileFoundFlag) {
			Reporter.log("Generrated Report Downloaded Successfully");
		} else {
			Assert.assertFalse(false, "File Could not be downloaded!!");
			;
		}
	}

	public void deleteBeforeDownload() {
		File file = new File(System.getProperty("user.home") + "\\Downloads");
		File[] fileLists = file.listFiles();
		for (File file2 : fileLists) {
			if (file2.getName().contains("linked_gst_report")) {
				file2.delete();
			}
		}
	}

	public void selectdownloadthreeMonths()
			throws InterruptedException, customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, downloadThreeMoonths);
		CommonUtility.cExplicitlyWait(driver, downloadThreeMoonths, 2);
		CommonUtility.cClick(driver, pdfFormat);
		CommonUtility.cExplicitlyWait(driver, pdfFormat, 2);
	}

	public void startdateEndDate(List<Map<String, String>> date) throws Exception {
		boolean startdateflag = CommonUtility.cVerifyElementIsPresent(driver, startDate, 3);
		boolean endDateFlag = CommonUtility.cVerifyElementIsPresent(driver, endDate, 3);
		boolean generateflag = CommonUtility.cVerifyElementIsPresent(driver, generateReport, 3);
		if (startdateflag == true) {
			CommonUtility.cClick(driver, startDate);
			CommonUtility.cExplicitlyWait(driver, startDate, 2);
			startDate.sendKeys(Keys.CONTROL + "a");
			startDate.sendKeys(Keys.DELETE);
			CommonUtility.cExplicitlyWait(driver, startDate, 2);
			CommonUtility.cSendKeys(driver, startDate, date.get(0).get("start date"));
			CommonUtility.cExplicitlyWait(driver, startDate, 2);
			Validator.assertTrue(startdateflag, "Failed to enter start date", "Successfully entered Start date");
		} else {
			Validator.assertTrue(startdateflag, "Failed to enter start date", "Successfully entered Start date");
		}
		if (endDateFlag == true) {
			CommonUtility.cClick(driver, endDate);
			CommonUtility.cExplicitlyWait(driver, endDate, 2);
			endDate.sendKeys(Keys.CONTROL + "a");
			endDate.sendKeys(Keys.DELETE);
			CommonUtility.cExplicitlyWait(driver, endDate, 2);
			CommonUtility.cSendKeys(driver, endDate, date.get(0).get("end date"));
			CommonUtility.cExplicitlyWait(driver, endDate, 2);
			Validator.assertTrue(endDateFlag, "Failed to enter End date", "Successfully entered end date");
		} else {
			Validator.assertTrue(endDateFlag, "Failed to enter End date", "Successfully entered end date");
		}
		if (generateflag == true) {
			CommonUtility.cExplicitlyWait(driver, generateReport, 2);
			CommonUtility.cClick(driver, generateReport);
			Validator.assertTrue(generateflag, "Failed to click on generate report button",
					"Generate report button was clicked successfully");
		} else {
			Validator.assertTrue(generateflag, "Failed to click on generate report button",
					"Generate report button was clicked successfully");
		}
	}

	public void customizeColumns(List<Map<String, String>> columns) throws Exception {
		boolean customflag = CommonUtility.cVerifyElementIsPresent(driver, customizebutton, 3);

		if (customflag == true) {
			CommonUtility.cExplicitlyWait(driver, customizebutton, 3);
			CommonUtility.cClick(driver, customizebutton);
			for (Map<String, String> templateNames : columns) {
				for (Map.Entry<String, String> entry : templateNames.entrySet()) {
					String columnpath = "//input[@name='" + entry.getValue() + "']";
					driver.findElement(By.xpath(columnpath)).click();
				}
			}

			Validator.assertTrue(customflag, "failed to click custom button and select options",
					"Successfullcy selected the options after clicking on custom button");
		} else {
			Validator.assertTrue(customflag, "failed to click custom button and select options",
					"Successfullcy selected the options after clicking on custom button");
		}
		boolean applyflag = CommonUtility.cVerifyElementIsPresent(driver, applybutton, 3);
		if (applyflag == true) {
			CommonUtility.cExplicitlyWait(driver, applybutton, 2);
			CommonUtility.cClick(driver, applybutton);
			Validator.assertTrue(applyflag, "failed to click Apply button", "Successfullcy clicked on apply button");
		} else {
			Validator.assertTrue(applyflag, "failed to click Apply button", "Successfullcy clicked on apply button");
		}
		boolean savechangesflag = CommonUtility.cVerifyElementIsPresent(driver, saveChanges, 3);
		if (savechangesflag == true) {
			CommonUtility.cExplicitlyWait(driver, saveChanges, 2);
			CommonUtility.cClick(driver, saveChanges);
			Validator.assertTrue(savechangesflag, "failed to click Save changes", "Successfullcy clicked save changes");
		} else {
			Validator.assertTrue(savechangesflag, "failed to click Save changes", "Successfullcy clicked save changes");
		}

	}

	public void customizeChanges(List<Map<String, String>> customize) throws Exception {
		boolean templateflag = CommonUtility.cVerifyElementIsPresent(driver, newtemplate, 3);
		boolean saveAsNewTemplateflag = CommonUtility.cVerifyElementIsPresent(driver, saveAsNewTemplate, 2);
		if (templateflag == true) {
			CommonUtility.cClick(driver, newtemplate);
			CommonUtility.cSendKeys(driver, newtemplate, customize.get(0).get("template"));
			Validator.assertTrue(templateflag, "Failed to enter template name", "Successfully entered template name");
		} else {
			Validator.assertTrue(templateflag, "Failed to enter template name", "Successfully entered template name");
		}
		if (saveAsNewTemplateflag == true) {
			CommonUtility.cClick(driver, saveAsNewTemplate);
			Validator.assertTrue(saveAsNewTemplateflag, "Failed to click on Save as new Template",
					"Successfully clicked on save as new template ");
		} else {
			Validator.assertTrue(saveAsNewTemplateflag, "Failed to click on Save as new Template",
					"Successfully clicked on save as new template ");
		}

	}

	public void allDetails(List<Map<String, String>> details) throws Exception {
		Actions action = new Actions(driver);
		boolean startdateflag = CommonUtility.cVerifyElementIsPresent(driver, startDate, 3);
		boolean endDateFlag = CommonUtility.cVerifyElementIsPresent(driver, endDate, 3);
		if (startdateflag == true) {
			CommonUtility.cClick(driver, startDate);
			startDate.sendKeys(Keys.CONTROL + "a");
			startDate.sendKeys(Keys.DELETE);
			CommonUtility.cSendKeys(driver, startDate, details.get(0).get("start date"));
			Validator.assertTrue(startdateflag, "Failed to enter start date, please refer screenshot",
					"Start date entered successfully");
		} else {
			Validator.assertTrue(startdateflag, "Failed to enter start date, please refer screenshot",
					"Start date entered successfully");
		}
		if (endDateFlag == true) {
			CommonUtility.cClick(driver, endDate);
			endDate.sendKeys(Keys.CONTROL + "a");
			endDate.sendKeys(Keys.DELETE);
			CommonUtility.cSendKeys(driver, endDate, details.get(0).get("end date"));
			Validator.assertTrue(endDateFlag, "Failed to enter end date, please refer screenshot",
					"End date entered successfully");
		} else {
			Validator.assertTrue(endDateFlag, "Failed to enter end date, please refer screenshot",
					"End date entered successfully");
		}
		selectPan(details);
		action.sendKeys(Keys.ESCAPE).build().perform();
		selectState(details);
		action.sendKeys(Keys.ESCAPE).build().perform();
		selectGstin(details);
		action.sendKeys(Keys.ESCAPE).build().perform();
		selectStatus(details);
		action.sendKeys(Keys.ESCAPE).build().perform();

	}

	public void selectPan(List<Map<String, String>> panDetails) throws Exception {
		boolean panFlag = CommonUtility.cVerifyElementIsPresent(driver, panNumber, 3);
		if (panFlag == true) {
			CommonUtility.cClick(driver, panNumber);
			CommonUtility.cExplicitlyWait(driver, panNumber, 2);
			List<WebElement> panSelect = null;
			int counter = 0;
			try {
				panSelect = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);
			} catch (Exception e) {
				while ((panSelect == null || panSelect.size() < 1) && counter < 10) {
					try {
						counter++;
						CommonUtility.cClick(driver, panNumber);
						panSelect = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);
					} catch (Exception ex) {
						panSelect = null;
					}
				}
			}
			for (int i = 0; i < panSelect.size(); i++) {
				if(panSelect.get(i).isEnabled()) {
					CommonUtility.cClick(driver, panSelect.get(i));
				}
			}
			Validator.assertTrue(panFlag, "Failed to select Pan number, refer screenshot",
					"Successfully selected Pan number");
		} else {
			Validator.assertTrue(panFlag, "Failed to select Pan number, refer screenshot",
					"Successfully selected Pan number");
		}
	}

	public void selectState(List<Map<String, String>> stateDetails) throws Exception {
		boolean stateflag = CommonUtility.cVerifyElementIsPresent(driver, stateSelect, 3);
		if (stateflag == true) {
			CommonUtility.cClick(driver, stateSelect);
			CommonUtility.cExplicitlyWait(driver, stateSelect, 2);

			List<WebElement> stateList = null;
			int counter = 0;

			try {
				stateList = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);
			} catch (Exception e) {
				while ((stateList == null || stateList.size() < 1) && counter < 36) {
					try {
						counter++;
						CommonUtility.cClick(driver, stateSelect);
						stateList = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);
					} catch (Exception ex) {
						stateList = null;
					}
				}
			}
			for (int i = 0; i < stateList.size(); i++) {
				if (stateList.get(i).getText().contains(stateDetails.get(0).get("State"))) {
					CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, stateList.get(i));
					CommonUtility.cClick(driver, stateList.get(i));
				}
			}
			Validator.assertTrue(stateflag, "Failed to select State, refer screenshot", "Successfully selected State");
		} else {
			Validator.assertTrue(stateflag, "Failed to select State, refer screenshot", "Successfully selected State");
		}
	}

	public void initiatorName(List<Map<String, String>> initiatorDetails)
			throws InterruptedException, customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, selectInitiator);
		CommonUtility.cExplicitlyWait(driver, selectInitiator, 2);
		List<WebElement> initiatorList = driver.findElements(By.xpath("//*[@id='menu-initiated_by']/div[3]/ul/li"));
		for (WebElement initiator : initiatorList) {
			if (initiator.getText().contains(initiatorDetails.get(0).get("InitiatedBy"))) {
				CommonUtility.cClick(driver, initiator);
			}
			break;
		}
	}

	public void selectGstin(List<Map<String, String>> gstinDetails) throws Exception {
		boolean gstinNumberFlag = CommonUtility.cVerifyElementIsPresent(driver, gstinNumber, 3);
		if (gstinNumberFlag == true) {
			CommonUtility.cClick(driver, gstinNumber);
			CommonUtility.cExplicitlyWait(driver, gstinNumber, 2);
			List<WebElement> gstinList = null;
			int counter = 0;
			try {
				gstinList = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);
			} catch (Exception e) {
				while ((gstinList == null || gstinList.size() < 1) && counter < 20) {
					try {
						counter++;
						CommonUtility.cClick(driver, gstinNumber);
						gstinList = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);
					} catch (Exception ex) {
						gstinList = null;
					}
				}
			}
			for (int i = 0; i < gstinList.size(); i++) {
				if(gstinList.get(i).isEnabled()) {
					CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, gstinList.get(i));
					CommonUtility.cClick(driver, gstinList.get(i));
					break;
				}

			}
			Validator.assertTrue(gstinNumberFlag, "Failed to select GSTIN number, refer screenshot",
					"Successfully selected GSTIN Number");
		} else {
			Validator.assertTrue(gstinNumberFlag, "Failed to select GSTIN number, refer screenshot",
					"Successfully selected GSTIN Number");
		}
	}

	public void selectStatus(List<Map<String, String>> statusDetails) throws Exception {
		boolean statusflag = CommonUtility.cVerifyElementIsPresent(driver, statusCheck, 3);
		if (statusflag == true) {
			CommonUtility.cClick(driver, statusCheck);
			List<WebElement> statusList = null;
			int counter = 0;

			try {
				statusList = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);
			} catch (Exception e) {
				while ((statusList == null || statusList.size() < 1) && counter < 4) {
					try {
						counter++;
						CommonUtility.cClick(driver, statusCheck);
						statusList = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);
					} catch (Exception ex) {
						statusList = null;
					}
				}
			}
			for (int i = 0; i < statusList.size(); i++) {
				if (statusList.get(i).getText().contains(statusDetails.get(0).get("status"))) {
					CommonUtility.cMoveToElementByTarget(driver, statusList.get(i));
					Actions action = new Actions(driver);
					action.sendKeys(Keys.ESCAPE).build().perform();
					
				}
				
			}

			Validator.assertTrue(statusflag, "Failed to click on Status and select one",
					"Successfully clicked and selected Status");
		} 
		clickGenerate();
	}
	
	public void statusDate(List<Map<String, String>> date) throws Exception {
		boolean startdateflag = CommonUtility.cVerifyElementIsPresent(driver, startDate, 3);
		boolean endDateFlag = CommonUtility.cVerifyElementIsPresent(driver, endDate, 3);
		if (startdateflag == true) {
			CommonUtility.cClick(driver, startDate);
			CommonUtility.cExplicitlyWait(driver, startDate, 2);
			startDate.sendKeys(Keys.CONTROL + "a");
			startDate.sendKeys(Keys.DELETE);
			CommonUtility.cExplicitlyWait(driver, startDate, 2);
			CommonUtility.cSendKeys(driver, startDate, date.get(0).get("start date"));
			CommonUtility.cExplicitlyWait(driver, startDate, 2);
			Validator.assertTrue(startdateflag, "Failed to enter start date", "Successfully entered Start date");
		} else {
			Validator.assertTrue(startdateflag, "Failed to enter start date", "Successfully entered Start date");
		}
		if (endDateFlag == true) {
			CommonUtility.cClick(driver, endDate);
			CommonUtility.cExplicitlyWait(driver, endDate, 2);
			endDate.sendKeys(Keys.CONTROL + "a");
			endDate.sendKeys(Keys.DELETE);
			CommonUtility.cExplicitlyWait(driver, endDate, 2);
			CommonUtility.cSendKeys(driver, endDate, date.get(0).get("end date"));
			CommonUtility.cExplicitlyWait(driver, endDate, 2);
			Validator.assertTrue(endDateFlag, "Failed to enter End date", "Successfully entered end date");
		} else {
			Validator.assertTrue(endDateFlag, "Failed to enter End date", "Successfully entered end date");
		}
	}

	public void selectTemplate(List<Map<String, String>> template)
			throws customElementNotClickableException, customElementNotFoundException {
		List<WebElement> templateList = driver.findElements(By.xpath("//div[3]/div[2]/div/fieldset/div/label"));
		for (int i = 0; i < templateList.size(); i++) {
			if (templateList.get(i).getText().contains(template.get(0).get("Template"))) {
				CommonUtility.cClick(driver, templateList.get(i));
			}
		}
	}

	public void customizeTemplate(List<Map<String, String>> options) throws Exception {
		boolean customflag = CommonUtility.cVerifyElementIsPresent(driver, customTemplate, 3);
		if (customflag == true) {
			CommonUtility.cClick(driver, customTemplate);
			Thread.sleep(3000);
			selectOptions(options);
			Validator.assertTrue(customflag, "Failed to clicked on custom template", "Clicked custom template!!");
		} else {
			Validator.assertTrue(customflag, "Failed to clicked on custom template", "Clicked custom template!!");
		}
	}

	public void deleteTemplate(List<Map<String, String>> templates)
			throws InterruptedException, customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, customTemplate);
		Thread.sleep(3000);
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, newTemplate);
		for (Map<String, String> uattemplateNames : templates) {
			for (Map.Entry<String, String> entry : uattemplateNames.entrySet()) {
				String uattemplatexpath = "//span[contains(text(), '" + entry.getValue()
						+ "') and contains(@class, 'column')]";
				WebElement uattempxpath = driver.findElement(By.xpath(uattemplatexpath));
				CommonUtility.cClick(driver, uattempxpath);
				String uatdeletexpath = "//span[contains(text(), '" + entry.getValue()
						+ "') and contains(@class, 'column')]/following-sibling::span";
				driver.findElement(By.xpath(uatdeletexpath)).click();
			}
		}
	}

	public void clickDeleteButton() throws Exception {
		boolean deleteflag = CommonUtility.cVerifyElementIsPresent(driver, deleteButton, 3);
		if (deleteflag == true) {
			CommonUtility.cClick(driver, deleteButton);
			Validator.assertTrue(deleteflag, "Failed to click delete button, refer the screenshot formore info",
					"successfully clicked on Delete button");
		} else {
			Validator.assertTrue(deleteflag, "Failed to click delete button, refer the screenshot formore info",
					"successfully clicked on Delete button");
		}
	}

	public void getDeleteToastMsg() throws Exception {
		boolean deletetoastflag = CommonUtility.cVerifyElementIsPresent(driver, deleteToastMsg, 3);
		if (deletetoastflag == true) {
			Validator.assertTrue(deletetoastflag,
					"Failed to display Delete toast message, Refer the screenshot for more info",
					"Delete toast message was displayed successfully");
		}
		else {
			Validator.assertTrue(deletetoastflag,
					"Failed to display Delete toast message, Refer the screenshot for more info",
					"Delete toast message was displayed successfully");
		}
	}

	public void addTemplate() throws Exception {
		WebElement templateAdd = driver.findElement(By.xpath("(//*[text()='New Template'])[1]"));
		boolean templateaddflag = CommonUtility.cVerifyElementIsPresent(driver, templateAdd, 3);
		if (templateaddflag == true) {
			CommonUtility.cClick(driver, templateAdd);
			Validator.assertTrue(templateaddflag, "Failed to add template", "Template added successfully");
		} else {
			Validator.assertTrue(templateaddflag, "Failed to add template", "Template added successfully");
		}
	}

	public void saveNewTemplate(List<Map<String, String>> name) throws Exception {
		boolean savetemplateflag = CommonUtility.cVerifyElementIsPresent(driver, saveTemplate, 3);
		boolean templatenameflag = CommonUtility.cVerifyElementIsPresent(driver, templateName, 3);
		boolean saveasnewtemplatefag = CommonUtility.cVerifyElementIsPresent(driver, saveAsNewTemplate, 3);
		if (savetemplateflag == true) {
			CommonUtility.cClick(driver, saveTemplate);
			Validator.assertTrue(savetemplateflag, "Failed to click on save template",
					"Successfully clicked on save template");
		} else {
			Validator.assertTrue(savetemplateflag, "Failed to click on save template",
					"Successfully clicked on save template");
		}
		CommonUtility.cVerifyElementIsPresent(driver, templateName, 3);
		CommonUtility.cClick(driver, templateName);
		Thread.sleep(3000);
		CommonUtility.cSendKeys(driver, templateName, name.get(0).get("name"));
		Validator.assertTrue(true, "Failed to enter template name", "Successfully entered template name");
		CommonUtility.cVerifyElementIsPresent(driver, saveAsNewTemplate, 3);
		CommonUtility.cClick(driver, saveAsNewTemplate);
		Validator.assertTrue(true, "Failed to click on save as new template",
				"Save as new template was clicked successfully");
	}

	public void selectOptions(List<Map<String, String>> options)
			throws InterruptedException, customElementNotClickableException, customElementNotFoundException {
		for (Map<String, String> templateNames : options) {
			for (Map.Entry<String, String> entry : templateNames.entrySet()) {
				String optionpath = "//input[@name='" + entry.getValue() + "']";
				driver.findElement(By.xpath(optionpath)).click();
			}
		}
	}

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
	}
}
