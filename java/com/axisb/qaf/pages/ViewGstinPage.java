package com.axisb.qaf.pages;

import static org.testng.Assert.assertEquals;

import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.utils.CommonUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class ViewGstinPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	WebDriverWait wait = new WebDriverWait(driver, 50);

	@FindBy(locator = "xpath=//span[text()='View GSTIN']")
	private QAFWebElement viewgstinbtn;

	@FindBy(locator = "xpath=//span[text()='Approved']")
	private QAFWebElement approvedbtn;

	@FindBy(locator = "xpath=//span[text()='Delink']")
	private QAFWebElement delinkbtn;

	@FindBy(locator = "xpath=//span[text()='Pending']")
	private QAFWebElement pendingLink;

	@FindBy(locator = "xpath = //*[@id='myGrid']/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div[1]")
	private QAFWebElement pendinggstin;

	@FindBy(locator = "xpath=//span[text()='Remind']")
	private QAFWebElement remindbtn;

	@FindBy(locator = "xpath=//span[text()='Delete']")
	private QAFWebElement deletebtn;

	@FindBy(locator = "xpath=(//span[text()='Delete'])[2]")
	private QAFWebElement confirmDelete;

	@FindBy(locator = "xpath=//*[contains(text(),'You have deleted the pending GSTIN approval.It has also been removed from the checker's approval queue.')]")
	private QAFWebElement deleteToastMsg;

	@FindBy(locator = "xpath=//div[contains(text(),'You have deleted the pending GSTIN approval.It has also been removed from the checker's approval queue.')]")
	private QAFWebElement deletedtoastMsg;

	@FindBy(locator = "xpath=//span[text()='Rejected']")
	private QAFWebElement rejectedLink;

	@FindBy(locator = "xpath=//span[text()='Remove from List']")
	private QAFWebElement removebtn;

	@FindBy(locator = "xpath=//span[text()='Yes']")
	private QAFWebElement buttonYes;

	@FindBy(locator = "xpath=//div[contains(text(),'The GSTIN is removed from the list.')]")
	private QAFWebElement rejectToastMessage;

	@FindBy(locator = "xpath=//span[text()='Delinked']")
	private QAFWebElement Delinkedlink;

	@FindBy(locator = "xpath=(//span[text()='Delink'])[2]")
	private QAFWebElement clickdelink;

	@FindBy(locator = "xpath=//span[text()='Relink']")
	private QAFWebElement relinkbtn;

	@FindBy(locator = "xpath=(//span[text()='Relink'])[2]")
	private QAFWebElement clickRelink;

	@FindBy(locator = "xpath=//div[contains(text(),'Your request to relink GSTIN is sent successfully to the checker for approval.')]")
	private QAFWebElement relinktoast;

	@FindBy(locator = "xpath=//div[text()='Your request to delink GSTIN is sent successfully to the checker for approval.']")
	private QAFWebElement delinkToastMsg;

	@FindBy(locator = "xpath=//span[contains(text(),'View/modify rule')]")
	private QAFWebElement viewModifyRule;

	@FindBy(locator = "xpath=//span[text()='Yes']")
	private QAFWebElement clickYesButton;

	@FindBy(locator = "xpath=//div[text()='You have sent a Reminder to Checker']")
	private QAFWebElement remindtoastMsg;

	@FindBy(locator = "xpath=//textarea[@id='remarkApp']")
	private QAFWebElement remarkstext;
	
	@FindBy(locator="xpath=//*[@id='myGrid']/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]")
	private QAFWebElement gstinrelink;
	
	@FindBy(locator="xpath=//*[@id='myGrid']/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div[1]/div[1]")
	private QAFWebElement rejectgstin;

	public QAFWebElement enterRemark() {
		return remarkstext;
	}

	public void viewGstinTab() throws Exception {
		boolean viewgstinflag = CommonUtility.cVerifyElementIsPresent(driver, viewgstinbtn, 3);
		if (viewgstinflag == true) {
			CommonUtility.cClick(driver, viewgstinbtn);
			Validator.assertTrue(viewgstinflag, "Failed to click on View GSTIN", "Succesfully clicked on View GSTIN");
		} else {
			Validator.assertTrue(viewgstinflag, "Failed to click on View GSTIN", "Succesfully clicked on View GSTIN");
		}
	}

	public void clickViewGstin() throws Exception {
		viewGstinTab();
		delinkGstin();
	}

	public void delinkGstin() throws Exception {
		boolean approveflag = CommonUtility.cVerifyElementIsPresent(driver, approvedbtn, 3);
		if (approveflag == true) {
			CommonUtility.cClick(driver, approvedbtn);
			Validator.assertTrue(approveflag, "Failed to click on Approve tab", "Successfully clicked on Approve tab");
			Thread.sleep(5000);
		} else {
			Validator.assertTrue(approveflag, "Failed to click on Approve tab", "Successfully clicked on Approve tab");
		}
		WebElement gstindelink = driver
				.findElement(By.xpath("//*[@id='myGrid']/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div[1]/div[1]"));
		boolean gstinflag = CommonUtility.cVerifyElementIsPresent(driver, gstindelink, 3);
		if (gstinflag == true) {
			CommonUtility.cClick(driver, gstindelink);
			Validator.assertTrue(gstinflag, "Failed to select GSTIN", "GSTIN was successfully selected");
		} else {
			Validator.assertTrue(gstinflag, "Failed to select GSTIN", "GSTIN was successfully selected");
		}
		boolean delinkflag = CommonUtility.cVerifyElementIsPresent(driver, delinkbtn, 3);
		if (delinkflag == true) {
			CommonUtility.cClick(driver, delinkbtn);
			Validator.assertTrue(delinkflag, "failed to click on Delink button",
					"Delink button was clicked successfully");
		} else {
			Validator.assertTrue(delinkflag, "failed to click on Delink button",
					"Delink button was clicked successfully");
		}
	}

	public void ruleAndApprover(List<Map<String, String>> ruleapply) throws Exception {
		boolean viewruleflag = CommonUtility.cVerifyElementIsPresent(driver, viewModifyRule, 3);
		if (viewruleflag == true) {
			CommonUtility.cClick(driver, viewModifyRule);
			Validator.assertTrue(viewruleflag, "Failed to click on View/Modify rule",
					"View/Modify Rule was clicked successfully");
		} else {
			Validator.assertTrue(viewruleflag, "Failed to click on View/Modify rule",
					"View/Modify Rule was clicked successfully");
		}
		WebElement ruleclick = driver.findElement(By.xpath("(//*[@id='Rule Applicable'])[2]"));
		boolean ruleclickflag = CommonUtility.cVerifyElementIsPresent(driver, ruleclick, 5);
		if (ruleclickflag == true) {
			CommonUtility.cClick(driver, ruleclick);
			Validator.assertTrue(ruleclickflag, "Failed to select rule from dropdown",
					"Successfully selected rule from dropdown");
		} else {
			Validator.assertTrue(ruleclickflag, "Failed to select rule from dropdown",
					"Successfully selected rule from dropdown");
		}
		List<WebElement> rules = null;
		int counter = 0;
		try {
			rules = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);
		} catch (Exception e) {
			while ((rules == null || rules.size() < 1) && counter < 4) {
				try {
					counter++;
					CommonUtility.cClick(driver, ruleclick);
					rules = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);
				} catch (Exception ex) {
					rules = null;
				}
			}
		}
		for (int i = 0; i < rules.size(); i++) {
			if (rules.get(i).getText().contains(ruleapply.get(0).get("rules"))) {
				CommonUtility.cClick(driver, rules.get(i));
				break;
			}
		}
		WebElement approverclick = driver
				.findElement(By.xpath("//div/label[text()='Approver 1']/following-sibling::div/div"));
		boolean approveflag = CommonUtility.cVerifyElementIsPresent(driver, approverclick, 3);
		if (approveflag == true) {
			CommonUtility.cClick(driver, approverclick);
			Validator.assertTrue(approveflag, "Failed to click Approver link",
					"Approver link was clicked successfully");
		} else {
			Validator.assertTrue(approveflag, "Failed to click Approver link",
					"Approver link was clicked successfully");
		}
		List<WebElement> selectapprover = null;
		int count = 0;
		try {
			selectapprover = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);
		} catch (Exception e) {
			while ((selectapprover == null || selectapprover.size() < 1) && count < 5) {
				try {
					count++;
					CommonUtility.cClick(driver, approverclick);
					selectapprover = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);
				} catch (Exception ex) {
					selectapprover = null;
				}
			}
		}
		for (int j = 0; j < selectapprover.size(); j++) {
			if (selectapprover.get(j).getText().contains(ruleapply.get(0).get("approver"))) {
				CommonUtility.cClick(driver, selectapprover.get(j));
				break;
			}
		}
	}

	public void enterRemarkText(List<Map<String, String>> remark) throws Exception {
		boolean remarkflag = CommonUtility.cVerifyElementIsPresent(driver, remarkstext, 3);
		if (remarkflag == true) {
			CommonUtility.cSendKeys(driver, remarkstext, remark.get(0).get("Remarks"));
			Validator.assertTrue(remarkflag, "Failed to enter Remarks in the text area",
					"Remarks was entered successfully");
		} else {
			Validator.assertTrue(remarkflag, "Failed to enter Remarks in the text area",
					"Remarks was entered successfully");
		}
	}

	public void delinkConfirm(List<Map<String, String>> confirmRule) throws Exception {
		ruleAndApprover(confirmRule);
		enterRemarkText(confirmRule);
		Thread.sleep(3000);
	}

	public void clickDelinktoConfirm() throws Exception {
		boolean delinkflag = CommonUtility.cVerifyElementIsPresent(driver, clickdelink, 3);
		if (delinkflag == true) {
			CommonUtility.cClick(driver, clickdelink);
			Validator.assertTrue(delinkflag, "Failed to click on confirm delink button",
					"Successfully clicked on Confirm Delink button");
		} else {
			Validator.assertTrue(delinkflag, "Failed to click on confirm delink button",
					"Successfully clicked on Confirm Delink button");
		}
	}

	public void getDelinkToastMsg() throws Exception {
		boolean delinktoastflag = CommonUtility.cVerifyElementIsPresent(driver, delinkToastMsg, 20);
		if (delinktoastflag == true) {
			Validator.assertTrue(delinktoastflag, "Failed to Display Delink Toast Message",
					"Delink toast message was successfully displayed");
		} else {
			Validator.assertTrue(delinktoastflag, "Failed to Display Delink Toast Message",
					"Delink toast message was successfully displayed");
		}
	}

	public void clickRemindButton() throws Exception {
		viewGstinTab();
		boolean pendingflag = CommonUtility.cVerifyElementIsPresent(driver, pendingLink, 3);
		if (pendingflag == true) {
			CommonUtility.cClick(driver, pendingLink);
			Validator.assertTrue(pendingflag, "failed to click on Pending Tab", "Successfully clicked on Pending Tab");
		} else {
			Validator.assertTrue(pendingflag, "failed to click on Pending Tab", "Successfully clicked on Pending Tab");
		}
		WebElement remindgstin = driver
				.findElement(By.xpath("//*[@id='myGrid']/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div[1]"));
		boolean remindgstinflag = CommonUtility.cVerifyElementIsPresent(driver, remindgstin, 3);
		if (remindgstinflag == true) {
			CommonUtility.cClick(driver, remindgstin);
			Validator.assertTrue(remindgstinflag, "Failed to select gstin to send reminder",
					"GSTIN was selected successfully to send reminder");
		} else {
			Validator.assertTrue(remindgstinflag, "Failed to select gstin to send reminder",
					"GSTIN was selected successfully to send reminder");
		}
		boolean remindBtnFlag = CommonUtility.cVerifyElementIsPresent(driver, remindbtn, 3);
		if (remindBtnFlag == true) {
			CommonUtility.cClick(driver, remindbtn);
			Validator.assertTrue(remindBtnFlag, "Failed to click on remind Button",
					"Successfully clciked on Remind Button");
		} else {
			Validator.assertTrue(remindBtnFlag, "Failed to click on remind Button",
					"Successfully clciked on Remind Button");
		}
		boolean clickyesFlag = CommonUtility.cVerifyElementIsPresent(driver, clickYesButton, 3);
		if (clickyesFlag == true) {
			CommonUtility.cClick(driver, clickYesButton);
			Validator.assertTrue(clickyesFlag, "Failed to click on Yes Button", "Successfully clicked on Yes Button");
		} else {
			Validator.assertTrue(clickyesFlag, "Failed to click on Yes Button", "Successfully clicked on Yes Button");
		}
	}

	public void remindToastMsg() throws Exception {
		boolean remindToastflag = CommonUtility.cVerifyElementIsPresent(driver, remindtoastMsg, 4);
		if (remindToastflag == true) {
			Validator.assertTrue(remindToastflag, "Failed to display remind Toast message",
					"Successfully displayed Remind toast Message");
		} else {
			Validator.assertTrue(remindToastflag, "Failed to display remind Toast message",
					"Successfully displayed Remind toast Message");
		}
	}

	public void deleteGstin() throws Exception {
		viewGstinTab();
		boolean pendingflag = CommonUtility.cVerifyElementIsPresent(driver, pendingLink, 3);
		if (pendingflag == true) {
			CommonUtility.cClick(driver, pendingLink);
			Validator.assertTrue(pendingflag, "failed to click on Pending Tab", "Successfully clicked on Pending Tab");
		} else {
			Validator.assertTrue(pendingflag, "failed to click on Pending Tab", "Successfully clicked on Pending Tab");
		}
		WebElement deletegstin = driver
				.findElement(By.xpath("//*[@id='myGrid']/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div[1]"));
		boolean deleteflag = CommonUtility.cVerifyElementIsPresent(driver, deletegstin, 3);
		if (deleteflag == true) {
			CommonUtility.cClick(driver, deletegstin);
			Validator.assertTrue(deleteflag, "Failed to select GSTIN to delete",
					"GSTIN was successfully selected to delete");
		} else {
			Validator.assertTrue(deleteflag, "Failed to select GSTIN to delete",
					"GSTIN was successfully selected to delete");
		}
		boolean deleteBtnFlag = CommonUtility.cVerifyElementIsPresent(driver, deletebtn, 4);
		if (deleteBtnFlag == true) {
			CommonUtility.cClick(driver, deletebtn);
			Validator.assertTrue(deleteBtnFlag, "Failed to click on delete Button",
					"Successfully clicked on Delete Button");
		} else {
			Validator.assertTrue(deleteBtnFlag, "Failed to click on delete Button",
					"Successfully clicked on Delete Button");
		}
		boolean confirmflag = CommonUtility.cVerifyElementIsPresent(driver, confirmDelete, 4);
		if (confirmflag == true) {
			CommonUtility.cClick(driver, confirmDelete);
			Validator.assertTrue(confirmflag, "Failed to click on confirm delete button",
					"successfully clicked on confirm delete button");
		} else {
			Validator.assertTrue(confirmflag, "Failed to click on confirm delete button",
					"successfully clicked on confirm delete button");
		}
	}

	public void getDeleteToastMsg() throws Exception {
		boolean deletetoastflag = CommonUtility.cVerifyElementIsPresent(driver, deleteToastMsg, 4);
		if (deletetoastflag == true) {
			Validator.assertTrue(deletetoastflag, "Failed to display delete Toast message",
					"Delete Toast Message was succesfully displayed");
			Thread.sleep(5000);
		} else {
			Validator.assertTrue(deletetoastflag, "Failed to display delete Toast message",
					"Delete Toast Message was succesfully displayed");
		}
	}

	public void RemoveRejectedGstin() throws Exception {
		viewGstinTab();
		boolean rejectTabFlag = CommonUtility.cVerifyElementIsPresent(driver, rejectedLink, 4);
		if (rejectTabFlag == true) {
			CommonUtility.cClick(driver, rejectedLink);
			Validator.assertTrue(rejectTabFlag, "Failed to click on reject Tab", "Successfully clicked on Reject Tab");
		} else {
			Validator.assertTrue(rejectTabFlag, "Failed to click on reject Tab", "Successfully clicked on Reject Tab");
		}
		boolean rejectgstinFlag = CommonUtility.cVerifyElementIsPresent(driver, rejectgstin, 4);
		if (rejectgstinFlag == true) {
			CommonUtility.cClick(driver, rejectgstin);
			Validator.assertTrue(rejectgstinFlag, "Failed to select GSTIN to remove from list",
					"GSTIN was selected successfully to remove from list");
		} else {
			Validator.assertTrue(rejectgstinFlag, "Failed to select GSTIN to remove from list",
					"GSTIN was selected successfully to remove from list");
		}
		boolean removeflag = CommonUtility.cVerifyElementIsPresent(driver, removebtn, 4);
		if (removeflag == true) {
			CommonUtility.cClick(driver, removebtn);
			Validator.assertTrue(removeflag, "Failed to click on Remove from List button",
					"Successfully clicked on Remove from List");
		} else {
			Validator.assertTrue(removeflag, "Failed to click on Remove from List button",
					"Successfully clicked on Remove from List");
		}
		boolean confirmYesFlag = CommonUtility.cVerifyElementIsPresent(driver, buttonYes, 4);
		if (confirmYesFlag == true) {
			CommonUtility.cClick(driver, buttonYes);
			Validator.assertTrue(confirmYesFlag, "Failed to click on Confirm Yes button",
					"Successfully clicked on Confirm Yes Button");
		} else {
			Validator.assertTrue(confirmYesFlag, "Failed to click on Confirm Yes button",
					"Successfully clicked on Confirm Yes Button");
		}
	}

	public void rejectToastMsg() throws Exception {
		boolean rejecttoastflag = CommonUtility.cVerifyElementIsPresent(driver, rejectToastMessage, 4);
		if (rejecttoastflag == true) {
			Validator.assertTrue(rejecttoastflag, "Failed to display Remove from list Toast Message",
					"GSTIN removed from list Toat Message was displayed successfully");
		} else {
			Validator.assertTrue(rejecttoastflag, "Failed to display Remove from list Toast Message",
					"GSTIN removed from list Toat Message was displayed successfully");
		}
	}

	public void relinkGstin() throws Exception {
		viewGstinTab();
		boolean delinktabFlag = CommonUtility.cVerifyElementIsPresent(driver, Delinkedlink, 4);
		if (delinktabFlag == true) {
			CommonUtility.cClick(driver, Delinkedlink);
			Validator.assertTrue(delinktabFlag, "Failed to click on Delink Tab",
					"Successfully clicked on Delinked Tab");
		} else {
			Validator.assertTrue(delinktabFlag, "Failed to click on Delink Tab",
					"Successfully clicked on Delinked Tab");
		}
		boolean gstinDelinkFlag = CommonUtility.cVerifyElementIsPresent(driver, gstinrelink, 4);
		if (gstinDelinkFlag == true) {
			CommonUtility.cClick(driver, gstinrelink);
			Validator.assertTrue(gstinDelinkFlag, "Failed to select GSTIN to relink",
					"GSTIN was selected successfully to Relink");
		} else {
			Validator.assertTrue(gstinDelinkFlag, "Failed to select GSTIN to relink",
					"GSTIN was selected successfully to Relink");
		}
		boolean relinkBtnFlag = CommonUtility.cVerifyElementIsPresent(driver, relinkbtn, 4);
		if (relinkBtnFlag == true) {
			CommonUtility.cClick(driver, relinkbtn);
			Validator.assertTrue(relinkBtnFlag, "Failed to click on Relink button",
					"Relink buttonn was clicked successfully");
		} else {
			Validator.assertTrue(relinkBtnFlag, "Failed to click on Relink button",
					"Relink buttonn was clicked successfully");
		}
	}

	public void relinkConfirmrule(List<Map<String, String>> relinkRule) throws Exception {
		ruleAndApprover(relinkRule);
		Thread.sleep(3000);
	}

	public void clickRelinktoConfirm() throws Exception {
		boolean relinkConfirmFlag = CommonUtility.cVerifyElementIsPresent(driver, relinkbtn, 4);
		if (relinkConfirmFlag == true) {
			CommonUtility.cMoveToElementByTarget(driver, relinkbtn);
			Validator.assertTrue(relinkConfirmFlag, "Failed to click on Confirm Relink button",
					"Confirm Relink button was clicked successfully");
		} else {
			Validator.assertTrue(relinkConfirmFlag, "Failed to click on Confirm Relink button",
					"Confirm Relink button was clicked successfully");
		}
	}

	public void relinkToastMessage() throws Exception {
		boolean relinkToastFlag = CommonUtility.cVerifyElementIsPresent(driver, relinktoast, 4);
		if (relinkToastFlag == true) {
			Validator.assertTrue(relinkToastFlag, "Failed to display Relink Toast Message",
					"Relink toast Message was Displayed succesfully");
		} else {
			Validator.assertTrue(relinkToastFlag, "Failed to display Relink Toast Message",
					"Relink toast Message was Displayed succesfully");
		}
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
	}
}