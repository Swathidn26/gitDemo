package com.axisb.qaf.pages;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.axisb.qaf.exceptions.customElementFoundException;
import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.utils.CommonUtility;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class UpcomingTransactionPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "xpath=//span[text()='Single Payments']")
	private QAFWebElement singlePayment;

	@FindBy(locator = "xpath=//span[text()='Payments']")
	private QAFWebElement paymentslink;

	@FindBy(locator = "xpath=//li[text()='View/ Cancel Transaction']")
	private QAFWebElement cancelTransaction;

	@FindBy(locator = "xpath=//div[@id='tranRuleId']")
	private QAFWebElement ruleclick;

	@FindBy(locator = "xpath=//*[@id='menu-']/div[3]/ul/li")
	private QAFWebElement ruleSelect;

	@FindBy(locator = "xpath=//label[contains(text(), 'Approver 1')]/following-sibling::div/div")
	private QAFWebElement approver;

	@FindBy(locator = "xpath=((//tbody/tr/td/span[text()='VENDOR'])[1]//following::td/div/*[local-name()='svg' and @aria-hidden='true'])[1]")
	private QAFWebElement newoptionselect;

	@FindBy(locator = "xpath=//p[text()='Select Transaction Dates']")
	private QAFWebElement transactionDateSelect;

	@FindBy(locator = "xpath=((//span/input[@type='checkbox'])[2]//following::*[local-name()='svg' and @aria-hidden='true'])[1]")
	private QAFWebElement upcomingtranscheckbox;

	@FindBy(locator = "xpath=//textarea[@id='userRemark']")
	private QAFWebElement remarktext;

	@FindBy(locator = "xpath=//span[text()='Proceed']//parent::button")
	private QAFWebElement proceedbutton;

	@FindBy(locator = "xpath=(//span[text()='Proceed']//parent::button)[2]")
	private QAFWebElement proceedConfirm;

	@FindBy(locator = "xpath=//p[text()='Transaction cancelled successfully']")
	private QAFWebElement successMessage;

	@FindBy(locator = "xpath=(//div[contains(@class,'styles_monthSwitcher')]//div//following::button)[1]")
	private QAFWebElement nextMonthSwticher;

	@FindBy(locator = "xpath=((//td//span[text()='VENDOR'])[1]/../preceding-sibling::td)[4]//button")
	private QAFWebElement recurringelement;

	@FindBy(locator = "xpath=(//span[text()='VENDOR'])[1]")
	private QAFWebElement rowPresent;

	@FindBy(locator = "xpath=//*[contains(@class, 'month-switcher_month')]")
	private QAFWebElement monthswitcherName;

	public void newrecurringPayment() throws customElementNotClickableException, customElementNotFoundException,
			InterruptedException, customElementFoundException {
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, nextMonthSwticher);
		Thread.sleep(5000);
		WebElement rowpresent = CommonUtility.cFindElement(driver, By.xpath("(//span[text()='VENDOR'])[1]"), 40);
		if (rowpresent.isDisplayed()) {
			List<WebElement> newrows = CommonUtility.cFindElements(driver, By.xpath("\"//div[contains(text(),'Upcoming Transactions')]/parent::div/following-sibling::div[1]/div/table/tbody/tr/table/tbody/tr"), 5);
			for (int i = 1; i <= newrows.size(); i++) {
				String xpathTansactiondateicon = "//div[contains(text(),'Upcoming Transactions')]/parent::div/following-sibling::div[1]/div/table/tbody/tr["
						+ i + "]/table/tbody/tr/td[4]/button";
				String xpathselectcancel = "//div[contains(text(),'Upcoming Transactions')]/parent::div/following-sibling::div[1]/div/table/tbody/tr["
						+ i + "]/table/tbody/tr/td/following::td[3]/div/*[local-name()='svg' and @aria-hidden='true']";
				WebElement transactionType = CommonUtility.cFindElement(driver, By.xpath(xpathTansactiondateicon), 5);
				WebElement viewCancelTrasac = CommonUtility.cFindElement(driver, By.xpath(xpathselectcancel), 5);
				if (transactionType.isDisplayed()) {
					CommonUtility.cClick(driver, viewCancelTrasac);
					CommonUtility.cMoveToElementByTarget(driver, cancelTransaction);
					Thread.sleep(4000);
				}
				break;
			}

		} else
			try {
				{
					CommonUtility.cClick(driver, nextMonthSwticher);
					CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 20);
				}
			} catch (customElementNotClickableException e) {
				CommonUtility.cClick(driver, nextMonthSwticher);
			}
	}

	public void newScehdulePayment() throws Exception {
		CommonUtility.cExplicitlyWaitForAbsence(driver, By.xpath("//div[contains(@class='loader')]"), 40);
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, nextMonthSwticher);
		Thread.sleep(8000);
		boolean rowpresentflag = CommonUtility.cVerifyElementIsPresent(driver, rowPresent, 10);
		Boolean scheduledTransactionFlag = false;
		String monthName = monthswitcherName.getText();
		Calendar calActual = Calendar.getInstance();
		Calendar calYearAfter = Calendar.getInstance();
		calActual.setTime(new SimpleDateFormat("MMM yyyy").parse(monthName));
		calYearAfter.setTime(new SimpleDateFormat("MMM yyyy").parse(monthName));
		calYearAfter.add(Calendar.YEAR, 1);
		while ((!rowpresentflag || !scheduledTransactionFlag) && calActual.before(calYearAfter)) {
			if (rowpresentflag == true) {
				List<WebElement> newrows = driver.findElements(By.xpath(
						"//div[contains(text(),'Upcoming Transactions')]/parent::div/following-sibling::div[1]/div/table/tbody/tr/table/tbody/tr"));
				for (int i = 0; i < newrows.size(); i++) {
					String xpathTansactiondateicon = "(//div[contains(text(),'Upcoming Transactions')]/parent::div/following-sibling::div[1]/div/table/tbody/tr/table/tbody/tr/td[4])["
							+ (i + 1) + "]/button";
					String xpathselectcancel = "//div[contains(text(),'Upcoming Transactions')]/parent::div/following-sibling::div[1]/div/table/tbody/tr["
							+ (i + 1)
							+ "]/table/tbody/tr/td/following::td[3]/div/*[local-name()='svg' and @aria-hidden='true']";
					try {
						CommonUtility.cFindElement(driver, By.xpath(xpathTansactiondateicon), 2);
					} catch (Exception e1) {
						scheduledTransactionFlag = true;
						rowpresentflag = true;
					}
					System.out.println(scheduledTransactionFlag);
					if (scheduledTransactionFlag) {

						WebElement viewCancelTrasac = CommonUtility.cFindElement(driver, By.xpath(xpathselectcancel),
								2);
						CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, viewCancelTrasac);

						try {
							CommonUtility.cClick(driver, viewCancelTrasac);

							CommonUtility.cMoveToElementFromSourceToTarget(driver, viewCancelTrasac, cancelTransaction);

						} catch (Exception e) {

							CommonUtility.cMoveToElementByTarget(driver, viewCancelTrasac);
							CommonUtility.cMoveToElementByTarget(driver, cancelTransaction);
						}

					}
				}
			}

			else {
				CommonUtility.cClick(driver, nextMonthSwticher);
				CommonUtility.cWaitForLoaderAbsenceWithTripleDot(driver, 30);
				Thread.sleep(5000);
				monthName = monthswitcherName.getText();
				calActual.setTime(new SimpleDateFormat("MMM yyyy").parse(monthName));
				rowpresentflag = CommonUtility.cVerifyElementIsPresent(driver, rowPresent, 10);
			}
		}

		if (!rowpresentflag && !scheduledTransactionFlag
				&& (calActual.after(calYearAfter) || calActual.equals(calYearAfter))) {
			Validator.assertTrue(false, "No Scheduled Transaction found for this Corpoarate in 1 year span.", "");
		}
	}

	public void selectOption() throws Exception {
		CommonUtility.cExplicitlyWaitForAbsence(driver, By.xpath("//div[contains(@class='loader')]"), 100);
		Thread.sleep(10000);
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, newoptionselect);
		boolean optionsflag = CommonUtility.cVerifyElementIsPresent(driver, newoptionselect, 10);
		if (optionsflag == true) {
			try {
				Thread.sleep(5000);
				CommonUtility.cClick(driver, newoptionselect);
				Validator.assertTrue(optionsflag, "Failed to click on the options to view cancel transaction",
						"Option clicked successfully to view cancel transaction");
			} catch (Exception e) {
				Thread.sleep(5000);
				CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, newoptionselect);
				CommonUtility.cClick(driver, newoptionselect);
			}
		} else {
			Validator.assertTrue(optionsflag, "Failed to click on the options to view cancel transaction",
					"Option clicked successfully to view cancel transaction");
		}
		boolean transactionflag = CommonUtility.cVerifyElementIsPresent(driver, cancelTransaction, 5);
		if (transactionflag == true) {
			CommonUtility.cMoveToElementByTarget(driver, cancelTransaction);
			Thread.sleep(4000);
			Validator.assertTrue(transactionflag, "Failed to click on cancel transaction",
					"Cancel transaction was clicked successfully");
		} else {
			Validator.assertTrue(transactionflag, "Failed to click on cancel transaction",
					"Cancel transaction was clicked successfully");
		}
	}

	public void cancelTransaction() throws Exception {
		boolean transactionflag = CommonUtility.cVerifyElementIsPresent(driver, upcomingtranscheckbox, 3);
		if (transactionflag == true) {
			CommonUtility.cMoveToElementByTarget(driver, upcomingtranscheckbox);
			Thread.sleep(4000);
			Validator.assertTrue(transactionflag, "Failed to select Next Upcoming transaction",
					"Next Upcoming transaction Transaction was selected successfully");
		} 
	}

	public void viewModifyRule(List<Map<String, String>> details) throws Exception {
		ruleSelect(details);
		approverSelect(details);
		enterRemarks(details);
	}

	public void ruleSelect(List<Map<String, String>> rulesdetails) throws Exception {
		boolean rulesflag = CommonUtility.cVerifyElementIsPresent(driver, ruleclick, 3);
		if (rulesflag == true) {
			CommonUtility.cClick(driver, ruleclick);
			Validator.assertTrue(rulesflag, "Failed to click on rules", "Rule was clicked successfully");
		}

		List<WebElement> rules = null;
		int count = 0;
		try {
			rules = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 4);
		} catch (Exception e) {
			while ((rules == null || rules.size() < 1) && count < 10) {
				try {
					count++;
					CommonUtility.cClick(driver, ruleclick);
					rules = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 4);

				} catch (Exception ex) {
					rules = null;
				}
			}
		}
		for (int i = 0; i < rules.size(); i++) {
			if (rules.get(i).getText().contains(rulesdetails.get(0).get("rule"))) {
				CommonUtility.cClick(driver, rules.get(i));
			}
			break;
		}
	}

	public void approverSelect(List<Map<String, String>> approverclick) throws Exception {
		boolean approverflag = CommonUtility.cVerifyElementIsPresent(driver, approver, 3);
		if (approverflag == true) {
			CommonUtility.cMoveToElementByTarget(driver, approver);
			Validator.assertTrue(approverflag, "Failed to click on approver", "Approver was clicked successfully");
		} else {
			Validator.assertTrue(approverflag, "Failed to click on approver", "Approver was clicked successfully");
		}

		List<WebElement> approvers = null;
		int count = 0;
		try {
			approvers = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);
		} catch (Exception e) {
			while ((approvers == null || approvers.size() < 1) && count < 5) {
				try {
					count++;
					CommonUtility.cClick(driver, approver);
					approvers = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);
				} catch (Exception ex) {
					approvers = null;
				}
			}
		}
		for (int i = 0; i < approvers.size(); i++) {
			if (approvers.get(i).getText().contains(approverclick.get(0).get("Approver"))) {
				CommonUtility.cClick(driver, approvers.get(i));
			}
			break;
		}
	}

	public void enterRemarks(List<Map<String, String>> remarks) throws Exception {
		boolean remarkflag = CommonUtility.cVerifyElementIsPresent(driver, remarktext, 3);
		if (remarkflag == true) {
			CommonUtility.cClick(driver, remarktext);
			CommonUtility.cSendKeys(driver, remarktext, remarks.get(0).get("Remark"));
			Validator.assertTrue(remarkflag, "Failed to enter Remarks", "Remarks text was entered successfully");
		} else {
			Validator.assertTrue(remarkflag, "Failed to enter Remarks", "Remarks text was entered successfully");
		}

	}

	public void clickProceed() throws Exception {
		boolean proceedflag = CommonUtility.cVerifyElementIsPresent(driver, proceedbutton, 3);
		if (proceedflag == true) {
			CommonUtility.cClick(driver, proceedbutton);
			Validator.assertTrue(proceedflag, "Failed to click on proceed button",
					"Proceed button was clicked successfully");
		} else {
			Validator.assertTrue(proceedflag, "Failed to click on proceed button",
					"Proceed button was clicked successfully");
		}
		boolean proceedconfirmflag = CommonUtility.cVerifyElementIsPresent(driver, proceedConfirm, 3);
		if (proceedconfirmflag == true) {
			CommonUtility.cClick(driver, proceedConfirm);
			Validator.assertTrue(proceedconfirmflag, "Failed to click on proceed button to confirm cancellation",
					"Proceed button was clicked successfully to confirm cancellation");
		} else {
			Validator.assertTrue(proceedconfirmflag, "Failed to click on proceed button to confirm cancellation",
					"Proceed button was clicked successfully to confirm cancellation");
		}
	}

	public void displaySuccessMessage() throws Exception {
		boolean successflag = CommonUtility.cVerifyElementIsPresent(driver, successMessage, 10);
		if (successflag == true) {
			Validator.assertTrue(successflag, "Failed to diplay Success Message",
					"Success message displayed successfully");
		} else {
			Validator.assertTrue(successflag, "Failed to diplay Success Message",
					"Success message displayed successfully");
		}
	}

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub

	}

}
