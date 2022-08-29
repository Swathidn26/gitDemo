package com.axisb.qaf.pages;

import static org.testng.Assert.assertEquals;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.utils.CommonUtility;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class DEHVendorCheckerFlowPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	DEHLoginPage dehgetotpPage = new DEHLoginPage();

	@FindBy(locator = "xpath=(//div[@id='actions'])[1]")
	private QAFWebElement actionSelect;

	@FindBy(locator = "xpath=(//div[@id='actions'])[2]")
	private QAFWebElement mutliActionSelect;

	@FindBy(locator = "xpath=//span[text()='Proceed']")
	private QAFWebElement proceedbtn;

	@FindBy(locator = "xpath=(//*[local-name()='svg' and @class='grid-table_remarksIcon__2A91w'] )[1]")
	private QAFWebElement remarkstext;

	@FindBy(locator = "xpath=//span[text()='Submit']")
	private QAFWebElement submitBtn;

	@FindBy(locator = "xpath=(//span[text()='Submit'])[2]")
	private QAFWebElement otpSubmitBtn;

	@FindBy(locator = "xpath=//span[text()='Refresh Balance']")
	private QAFWebElement refreshbalance;

	@FindBy(locator = "xpath=//input[@placeholder='Search']")
	private QAFWebElement searchInput;

	@FindBy(locator = "xpath=//span[text()='Advanced Search']")
	private QAFWebElement advancedSearch;

	@FindBy(locator = "xpath=//small[contains(text(),'Date range selected should be between')]")
	private QAFWebElement dateRangeMsg;

	@FindBy(locator = "xpath=//span[text()='Customize']")
	private QAFWebElement customizeBtn;

	@FindBy(locator = "xpath=//div[text()='RESET DATE']")
	private QAFWebElement dateReset;

	@FindBy(locator = "xpath=//span[text()='Approve']")
	private QAFWebElement approveOption;

	@FindBy(locator = "xpath=(//span[text()='Approve'])[2]")
	private QAFWebElement multiApproveOptions;

	@FindBy(locator = "xpath=//span[text()='Reject']")
	private QAFWebElement rejectOption;

	@FindBy(locator = "xpath=(//span[text()='Reject'])[2]")
	private QAFWebElement multirejectOption;

	@FindBy(locator = "xpath=//span[text()='Apply']")
	private QAFWebElement customApplyBtn;

	@FindBy(locator = "xpath=//span[text()='Reset']")
	private QAFWebElement customResetBtn;

	@FindBy(locator = "xpath=//input[@id='customize-search-text']")
	private QAFWebElement customSearch;

	@FindBy(locator = "xpath=//*[local-name()='svg' and @class='customise_crossIcon__3mULC']")
	private QAFWebElement customCloseBtn;

	@FindBy(locator = "xpath=//div[contains(@title,'Refresh Balance available only 3 times in a minute. Please try again after one minute')]")
	private QAFWebElement refreshMsg;

	@FindBy(locator = "xpath=(//*[local-name()='svg' and @class='dateIcon' ])[1]")
	private QAFWebElement startdateIcon;

	@FindBy(locator = "xpath=(//*[local-name()='svg' and @class='dateIcon' ])[2]")
	private QAFWebElement endDateIcon;

	@FindBy(locator = "xpath=//button[text()='Refresh']")
	private QAFWebElement refreshBtn;

	@FindBy(locator = "xpath=//p[contains(text(),'Request submitted successfully')]")
	private QAFWebElement successMsg;

	@FindBy(locator = "xpath =(//div[text()='Vendor Payment'])[1]//preceding::div[9]/span")
	private QAFWebElement searchText;

	public void clickAction() throws Exception {
		boolean actionflag = CommonUtility.cVerifyElementIsPresent(driver, actionSelect, 3);
		if (actionflag == true) {
			CommonUtility.cClick(driver, actionSelect);
		}
		Validator.assertTrue(actionflag, "failed to click on action button", "action button was clicked successfully");
	}

	public void selectBeneApprove() throws Exception {
		clickAction();
		boolean selectApproveflag = CommonUtility.cVerifyElementIsPresent(driver, approveOption, 3);
		if (selectApproveflag == true) {
			CommonUtility.cClick(driver, approveOption);
		}
		Validator.assertTrue(selectApproveflag, "failed to select approve option refer screenshot for more info",
				"selected approve option successfully");
	}

	public void mutlipleBeneApprove() throws Exception {
		selectBeneApprove();
		Thread.sleep(3000);
		CommonUtility.cClick(driver, mutliActionSelect);
		CommonUtility.cClick(driver, multiApproveOptions);
		Thread.sleep(3000);

	}

	public void selectBeneReject() throws Exception {
		clickAction();
		boolean rejectflag = CommonUtility.cVerifyElementIsPresent(driver, rejectOption, 3);
		if (rejectflag == true) {
			CommonUtility.cClick(driver, rejectOption);

		}
		Validator.assertTrue(rejectflag, "Failed to select reject option refer screenshot for more info",
				"Selected Reject option successfully");
	}

	public void mutlipleBeneReject() throws Exception {
		selectBeneReject();
		Thread.sleep(3000);
		CommonUtility.cClick(driver, mutliActionSelect);
		CommonUtility.cClick(driver, multirejectOption);
	}

	public void clickProceedBtn() throws Exception {
		boolean proceedBtnflag = CommonUtility.cVerifyElementIsPresent(driver, proceedbtn, 4);
		if (proceedbtn.isEnabled() && proceedBtnflag == true) {
			CommonUtility.cClick(driver, proceedbtn);
			Validator.assertTrue(proceedBtnflag,
					"failed to click on proceed button please refer screenshot for more info",
					"Proceed button was clicked successfully");
		} else {
			Validator.assertTrue(proceedBtnflag, " ", "failed to click on proceed button as the button is disabled");
		}
	}

	public void clickSubmitBtn() throws Exception {
		boolean submitflag = CommonUtility.cVerifyElementIsPresent(driver, submitBtn, 3);
		if (submitflag == true) {
			CommonUtility.cClick(driver, submitBtn);

		}
		Validator.assertTrue(submitflag, "unable to click on submit button please refer screenshot for more info",
				"Submit button clicked successfully");
	}

	public void enterOTP(Map<String, String> otpdetails) throws Exception {

		dehgetotpPage.enterOTP(dehgetotpPage.getOTP(otpdetails));
		CommonUtility.cClick(driver, otpSubmitBtn);
		Thread.sleep(10000);
	}

	public void clickforSubmission() throws Exception {
		clickProceedBtn();
		Thread.sleep(3000);
		clickSubmitBtn();
		Thread.sleep(3000);
	}

	public void displaySuccessMsg() throws Exception {
		boolean successMsgFlag = CommonUtility.cVerifyElementIsPresent(driver, successMsg, 3);
		if (successMsgFlag == true) {
			Validator.assertTrue(successMsgFlag, "Failed to display success message due to API issues",
					"Request Submission message is displayed successfully ");
		}
		Validator.assertTrue(successMsgFlag, "Failed to display success message due to API issues",
				"Request Submission message is displayed successfully ");
	}

	public void customizeOptions(List<Map<String, String>> options) throws Exception {
		boolean customFlag = CommonUtility.cVerifyElementIsPresent(driver, customizeBtn, 3);
		if (customFlag == true) {
			CommonUtility.cClick(driver, customizeBtn);
			Validator.assertTrue(customFlag,
					"Failed to click on Customize button, please refer screenshot for more info",
					"Customize button was clicked successfully");
			for (Map<String, String> cutsomoptions : options) {
				for (Map.Entry<String, String> entry : cutsomoptions.entrySet()) {
					String selectOptions = "//span/p[text()='" + entry.getValue() + "']";
					CommonUtility.cFindElement(driver, By.xpath(selectOptions), 3).click();

				}

			}
		}
		CommonUtility.cClick(driver, customApplyBtn);

	}

	public void searchtext()
			throws customElementNotFoundException, customElementNotClickableException, InterruptedException {
		Actions actions = new Actions(driver);
		String text = searchText.getText();
		CommonUtility.cSendKeys(driver, searchInput, text);
		Thread.sleep(3000);
		WebElement clickText = CommonUtility.cFindElement(driver, By.xpath("//p[contains(text(),'" + text + "')]"), 3);
		CommonUtility.cClick(driver, clickText);
		Thread.sleep(3000);
		CommonUtility.cFindElement(driver, By.xpath("//body"), 3).click();
		actions.moveByOffset(0, 0).click().build().perform();
		Thread.sleep(3000);
	}

	public void clickRefreshThrice() throws Exception {
		boolean refreshBtnFlag = CommonUtility.cVerifyElementIsPresent(driver, refreshbalance, 3);
		if (refreshBtnFlag == true) {
			for (int i = 0; i < 3; i++) {
				CommonUtility.cClick(driver, refreshbalance);
				Thread.sleep(2000);
			}
		}
		Validator.assertTrue(refreshBtnFlag, "Failed to click on refresh button", "Refrsh button clicked thrice");
	}

	public void refreshDisplayMsg() throws Exception {
		Actions action = new Actions(driver);
		WebElement refreshIcon = CommonUtility.cFindElement(driver,
				By.xpath("//div[contains(@title,'Refresh Balance available only 3 times in a minute.')]"), 3);
		action.moveToElement(refreshIcon).build().perform();
		boolean refreshflag = CommonUtility.cVerifyElementIsPresent(driver, refreshMsg, 3);
		if (refreshflag == true) {
			Assert.assertEquals(true, refreshMsg.isDisplayed());
		}
		Validator.assertTrue(refreshflag, "failed to display toast message",
				"Toast message displayed after clicking refresh button thrice");
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}

}
