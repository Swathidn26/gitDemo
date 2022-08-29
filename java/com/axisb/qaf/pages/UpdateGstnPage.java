package com.axisb.qaf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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

public class UpdateGstnPage extends WebDriverBaseTestPage<WebDriverTestPage>{

	@FindBy(locator="xpath=//p[contains(text(),'GSTN Update')]")
	private QAFWebElement update_gstn_link;

	@FindBy(locator="xpath=(//input[@type='checkbox']/parent::div)[6]")
	private QAFWebElement select_first_gstn;

	@FindBy(locator="xpath=(//input[@type='checkbox']/parent::div)[7]")
	private QAFWebElement select_second_gstn;

	@FindBy(locator="xpath=//span[contains(text(),'Cancel')]")
	private QAFWebElement cancel_button;

	@FindBy(locator="xpath=//div[contains(text(),'SET AS DEFAULT')]/parent::div")
	private QAFWebElement set_as_default_link;

	@FindBy(locator="xpath=//span[contains(text(),'Yes')]")
	private QAFWebElement popup_yes_btn;

	@FindBy(locator="xpath=//div[contains(text(),'Overview')]")
	private QAFWebElement overview_page;

	@FindBy(locator = "//*[@id='mui-component-select-ruleId']")
	private QAFWebElement ruleApplicable;

	@FindBy(locator = "//*[@id='menu-ruleId']/div[3]/ul/li")
	private QAFWebElement genBtn;

	@FindBy(locator = "//span[contains(text(),'Submit')]")
	private QAFWebElement submit_btn;

	@FindBy(locator = "//p[contains(text(),'Request Submitted Successfully')]")
	private QAFWebElement success_msg;

	public void clickPopupYes() throws Exception {
		CommonUtility.cExplicitlyWait(driver, popup_yes_btn, 15);
		CommonUtility.cClick(driver, popup_yes_btn);
	}

	public void validateOverviewPage() throws Exception {
		boolean overviewPageFlag = CommonUtility.cVerifyElementIsPresent(driver, overview_page, 10);
		Validator.assertTrue(overviewPageFlag,
				"[Overview page not displayed! Please look into the screenshot more details]",
				"Overview Screen is displayed successfully");
	}

	public void verifySuccessMsgGstnUpdate() throws Throwable {
		CommonUtility.cExplicitlyWaitForAbsence(driver, By.xpath("//div[contains(@class='loader')]"), 60);
		CommonUtility.cExplicitlyWait(driver, success_msg, 60);
		boolean updateGstnSuccessFlag = CommonUtility.cVerifyElementIsPresent(driver, success_msg, 10);
		Validator.assertTrue(updateGstnSuccessFlag,
				"[API failure! Update GSTN Validation Failed!]",
				"GSTN Update is completed successfully");
	}

	public void verifySubmit() throws Exception {
		Boolean submitBtnFlag = CommonUtility.cVerifyElementIsPresent(driver, submit_btn, 25);
		Validator.assertTrue(submitBtnFlag,
				"[Submit button is enabled without selecting terms and conditions! Please look into the screenshot more details]",
				"Submit button is disabled successfully without selecting terms and conditions");
	}

	public void clickRuleGen() throws Exception {
		Thread.sleep(2000);
		CommonUtility.cClick(driver, ruleApplicable);
		CommonUtility.cClick(driver, genBtn);
		Thread.sleep(2000);
	}

	public void clickUpdateGstnBtn() throws Exception {
		CommonUtility.cClick(driver, update_gstn_link);
	}

	public void clickFirstGstn() throws Exception {
		CommonUtility.cClick(driver, select_first_gstn);
	}

	public void clickSecondGstn() throws Exception {
		CommonUtility.cClick(driver, select_second_gstn);
	}

	public void clickCancel() throws Exception {
		CommonUtility.cClick(driver, cancel_button);
	}

	public void clickDefaultGstn() throws Exception {
		CommonUtility.cExplicitlyWait(driver, set_as_default_link, 20);
		CommonUtility.cMoveToElementFromSourceToTarget(driver, set_as_default_link, set_as_default_link);
	}

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
	}

}
