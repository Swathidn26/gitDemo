23e44epackage com.axisb.qaf.pages;
import java.awt.Desktop.Action;
import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.utils.CommonUtility;
import java.awt.Window;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.util.ExpectedCondition;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

import io.cucumber.core.gherkin.Argument;
import io.cucumber.datatable.DataTable;

public class AddToMasterPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	String url = "https://qadigicorps.axisb.com/sso/%7B%22parameters%22%3A%5B%7B%22page%22%3A%22SP1M%22%2C%22value%22%3A%22605d4eea9528ed2e5dbb720a40226fffb789326badfb75c1ea73201ec112834b24efb94fed011c7f43c4f4ca83120dc744cf3dfcba98e3148836c76e0bc3345b39acb19c17b059296763a09293203478bdd1d7984c07c62a2068ab214b41e6a6075b7773ff38ec1010dfd1d305a57440aee93121cfc788ff0c4071d5c24b74ae%22%2C%22role%22%3A%22ENTERER%22%2C%22key%22%3A%22ssoparam%22%7D%5D%7D%0A";

	@FindBy(locator = "xpath=//span[text()='Statutory']")
	private QAFWebElement statutorylink;

	@FindBy(locator = "xpath=//span[text()='Register GSTIN']")
	private QAFWebElement registerGstin;

	@FindBy(locator = "xpath=//span[text()='Payments']")
	private QAFWebElement paymentslink;

	@FindBy(locator = "xpath=(//a[@id='paymentsSub7'])[1]")
	private QAFWebElement newPayments;

	@FindBy(locator = "xpath=//span[contains(text(),'GST ePayments')]")
	private QAFWebElement gstePayments;

	@FindBy(locator = "xpath=//span[text()='Discover GSTIN']")
	private QAFWebElement discgstin;

	@FindBy(locator = "xpath=//div[contains(text(),'GSTINs discovered from the PAN is succesfully added to the table.')]")
	private QAFWebElement discoverMsg;

	@FindBy(locator = "xpath=//div[contains(text(),'All GSTINs associated with the PAN is already linked to the Axis Master')]")
	private QAFWebElement discoverToastMSG;

	@FindBy(locator = "xpath=//div[contains(text(),'GSTINs discovered from the PAN is succesfully added to the table.') or contains(text(),'All GSTINs associated with the PAN is already linked to the Axis Master')]")
	private QAFWebElement discoverToastMSGWithCondition;

	@FindBy(locator = "xpath=div[contains(text(),'GSTINs discovered from the PAN is succesfully added to the table.') or contains(text(),'All GSTINs associated with the PAN is already linked to the Axis Master')]")
	private QAFWebElement discoverToastMsgWith;

	@FindBy(locator = "xpath=div[contains(text(),'GSTINs discovered from the PAN is succesfully added to the table.') or contains(text(),'All GSTINs associated with the PAN is already linked to the Axis Master')]")
	private QAFWebElement discoverToastMsgWithOR;

	@FindBy(locator = "xpath=//span[contains(text(),'View/Modify Rule')]")
	private QAFWebElement viewrule;

	@FindBy(locator = "xpath=//div[@id='Rule Applicable']")
	private QAFWebElement ruleapp;

	@FindBy(locator = "xpath=//button[@class='MuiButtonBase-root MuiIconButton-root dashboardTable_iconStyle__1Xo5o MuiIconButton-sizeSmall']")
	private QAFWebElement downarrow;

	@FindBy(locator = "xpath=(//span[text()='2 GEN'])[2]")
	private QAFWebElement ruleselect;

	@FindBy(locator = "xpath=//*[@id='remarkApp']")
	private QAFWebElement remarktext;

	@FindBy(locator = "xpath=//*[text()='Save']")
	private QAFWebElement savebtn;

	@FindBy(locator = "xpath=//input[@aria-label='Select Row checkbox']")
	private QAFWebElement selectPanGstin;

	@FindBy(locator = "xpath=//span[text()='Add to Master']")
	private QAFWebElement addtoMasterbtn;

	@FindBy(locator = "xpath=//div[contains(text(),'Sent for Approval The request to link the selected GSTIN are sent for approval to the checker successfully.')]")
	private QAFWebElement addtoMasterToastMsg;

	@FindBy(locator = "xpath=//input[@class='jss166']")
	private QAFWebElement selectall;

	@FindBy(locator = "xpath=//div[@class='MuiGrid-root dashboardTable_QxMYX MuiGrid-container']")
	private QAFWebElement arrowkey;

	@FindBy(locator = "xpath=//div/label[text()='Approver 1']/following-sibling::div")
	private QAFWebElement approverlink;

	@FindBy(locator = "xpath=(//span[contains(text(),'APPROVER')])[4]")
	private QAFWebElement approverSelect;

	@FindBy(locator = "xpath=(//*[contains(text(), 'New Payments')])[1]")
	private QAFWebElement newPaymentsTab;

	@FindBy(locator = "xpath=//*[@id='__next']//div[4]//div[2]/div/div[1]/div[1]/div/button/span[1]")
	private QAFWebElement pangstin;

	@FindBy(locator = "xpath= (//*[@id='__next']//div[4]/span/div[1]/div[2]/div/div[2]//div[2]/div[2]/div//div[1]/span/span[1]/input)[1]")
	private QAFWebElement gstinselected;

	// register GSTIN methods

	public void clickSelectAll() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, selectall);
	}

	public void clickGstPayments() throws Exception {
		boolean newpaymentFlag = CommonUtility.cVerifyElementIsPresent(driver, newPaymentsTab, 4);
		if (newpaymentFlag == true) {
			CommonUtility.cClick(driver, newPaymentsTab);
			Validator.assertTrue(newpaymentFlag, "Failed to click on new payment",
					"New payment tab was clicked successfully");
		} else {
			Validator.assertTrue(newpaymentFlag, "Failed to click on new payment",
					"New payment tab was clicked successfully");
		}
		boolean gstPaymentflag = CommonUtility.cVerifyElementIsPresent(driver, gstePayments, 4);
		if (gstPaymentflag == true) {
			CommonUtility.cMoveToElementFromSourceToTarget(driver, newPaymentsTab, gstePayments);
			Validator.assertTrue(gstPaymentflag, "Failed to click on GST ePayments",
					"GST ePayments was clicked successfully");
		} else {
			Validator.assertTrue(gstPaymentflag, "Failed to click on GST ePayments",
					"GST ePayments was clicked successfully");
		}
	}

	public void clickViewRule(List<Map<String, String>> ruleapplicableDetails) throws Exception {
		CommonUtility.cExplicitlyWaitForAbsence(driver, By.xpath("//div[contains(@class,'loader')]"), 30);
		boolean viewruleFlag = CommonUtility.cVerifyElementIsPresent(driver, viewrule, 4);
		if (viewruleFlag == true) {
			CommonUtility.cClick(driver, viewrule);
			Validator.assertTrue(viewruleFlag, "Failed to click on View/Modify rule",
					"View/Modify rule was clicked successfully");
		} else {
			Validator.assertTrue(viewruleFlag, "Failed to click on View/Modify rule",
					"View/Modify rule was clicked successfully");
		}
		boolean ruleappFlag = CommonUtility.cVerifyElementIsPresent(driver, ruleapp, 10);
		if (ruleappFlag == true) {
			CommonUtility.cMoveToElementByTarget(driver, ruleapp);
			CommonUtility.cClick(driver, ruleapp);
			Validator.assertTrue(ruleappFlag, "Failed to click on Rule ", "Rule option was clicked successfully");
		} else {
			Validator.assertTrue(ruleappFlag, "Failed to click on Rule ", "Rule option was clicked successfully");
		}
		ruleSelect(ruleapplicableDetails);
		selectApprover(ruleapplicableDetails);

		boolean remarkFlag = CommonUtility.cVerifyElementIsPresent(driver, remarktext, 4);
		if (remarkFlag == true) {
			CommonUtility.cSendKeys(driver, remarktext, ruleapplicableDetails.get(0).get("remarks"));
			Validator.assertTrue(remarkFlag, "Failed to enter Remarks in the text field",
					"Remarks entered successfully in the text field");
		} else {
			Validator.assertTrue(remarkFlag, "Failed to enter Remarks in the text field",
					"Remarks entered successfully in the text field");
		}
		boolean saveBtnFlag = CommonUtility.cVerifyElementIsPresent(driver, savebtn, 4);
		if (saveBtnFlag == true) {
			CommonUtility.cMoveToElementByTarget(driver, savebtn);
			Validator.assertTrue(saveBtnFlag, "Failed to click on Save button", "Save button was clicked successfully");
		} else {
			Validator.assertTrue(saveBtnFlag, "Failed to click on Save button", "Save button was clicked successfully");
		}
	}

	public QAFWebElement setRemark() {
		return remarktext;
	}

	public void clickRegisterGSTIN() throws Exception {
		boolean registerGstinFlag = CommonUtility.cVerifyElementIsPresent(driver, registerGstin, 3);
		if (registerGstinFlag == true) {
			CommonUtility.cClick(driver, registerGstin);
			Validator.assertTrue(registerGstinFlag, "Failed to click on Register GSTIN",
					"Register GSTIN was clicked successfully");
		} else {
			Validator.assertTrue(registerGstinFlag, "Failed to click on Register GSTIN",
					"Register GSTIN was clicked successfully");
		}
	}

	public void discoverGSTIN() throws Exception {
		boolean discoverflag = CommonUtility.cVerifyElementIsPresent(driver, discgstin, 3);
		if (discoverflag == true) {
			CommonUtility.cClick(driver, discgstin);
			Validator.assertTrue(discoverflag, "Failed to click on Discover GSTIN",
					"Discover GSTIN was clicked successfully");
		} else {
			Validator.assertTrue(discoverflag, "Failed to click on Discover GSTIN",
					"Discover GSTIN was clicked successfully");
		}
	}

	public void verifydiscovermessage() {
		Assert.assertEquals(discoverToastMSGWithCondition.isDisplayed(), true);
	}

	public void verfyAddToMasterBtn() {
		Assert.assertTrue(true);
	}

	public void getAddtoMasterToastMsg() throws Exception {
		boolean addtoMasterToastFlag = CommonUtility.cVerifyElementIsPresent(driver, addtoMasterToastMsg, 4);
		if (addtoMasterToastFlag == true) {
			Validator.assertTrue(addtoMasterToastFlag, "Failed to display Add to Master Toast Message",
					"Add to master Toast message was displayed successfully");
		} else {
			Validator.assertTrue(addtoMasterToastFlag, "Failed to display Add to Master Toast Message",
					"Add to master Toast message was displayed successfully");
		}
	}

	public void selectPanGstin() throws Exception {
		boolean pangstinFlag = CommonUtility.cVerifyElementIsPresent(driver, pangstin, 4);
		if (pangstinFlag == true) {
			CommonUtility.cMoveToElementByTarget(driver, pangstin);
			Validator.assertTrue(pangstinFlag, "Failed to click on Pan number", "Pan number was clicked successfully");
		} else {
			Validator.assertTrue(pangstinFlag, "Failed to click on Pan number", "Pan number was clicked successfully");
		}
		boolean gstinselectFlag = CommonUtility.cVerifyElementIsPresent(driver, gstinselected, 4);
		if (gstinselectFlag == true) {
			CommonUtility.cMoveToElementByTarget(driver, gstinselected);
			Validator.assertTrue(gstinselectFlag, "Failed to click on GSTIN", "GSTIN was selected successfully");
		} else {
			Validator.assertTrue(gstinselectFlag, "Failed to click on GSTIN", "GSTIN was selected successfully");
		}
		boolean addtoMasterFlag = CommonUtility.cVerifyElementIsPresent(driver, addtoMasterbtn, 4);
		if (addtoMasterFlag == true) {
			CommonUtility.cClick(driver, addtoMasterbtn);
			Validator.assertTrue(addtoMasterFlag, "Failed to click on Add to Master button",
					"Add to master button was clicked successfully");
		} else {
			Validator.assertTrue(addtoMasterFlag, "Failed to click on Add to Master button",
					"Add to master button was clicked successfully");
		}
	}

	public void ruleSelect(List<Map<String, String>> ruledropdown)
			throws customElementNotClickableException, customElementNotFoundException {
		List<WebElement> selectRule = null;
		int counter = 0;
		try {
			selectRule = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);

		} catch (Exception e) {
			while ((selectRule == null || selectRule.size() < 1) && counter < 1) {
				try {
					counter++;
					CommonUtility.cClick(driver, ruleapp);
					selectRule = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);
				} catch (Exception ex) {
					selectRule = null;
				}
			}
		}
		for (int i = 0; i < selectRule.size(); i++) {
			if (selectRule.get(i).getText().contains(ruledropdown.get(0).get("rule"))) {
				CommonUtility.cClick(driver, selectRule.get(i));
				break;
			}
		}

	}

	public void selectApprover(List<Map<String, String>> approverDetails) throws Exception {
		boolean approvelinkFlag = CommonUtility.cVerifyElementIsPresent(driver, approverlink, 4);
		if (approvelinkFlag == true) {
			CommonUtility.cClick(driver, approverlink);
			Validator.assertTrue(approvelinkFlag, "Failed to click on Approver dropdown",
					"Approver dropdown was clicked successfully");
		} else {
			Validator.assertTrue(approvelinkFlag, "Failed to click on Approver dropdown",
					"Approver dropdown was clicked successfully");
		}
		List<WebElement> approverselect = null;
		int counter = 0;
		try {
			approverselect = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);
		} catch (Exception e) {
			while ((approverselect == null || approverselect.size() < 1) && counter < 10) {
				try {
					counter++;
					CommonUtility.cClick(driver, approverlink);
					approverselect = CommonUtility.cFindElements(driver, By.xpath("//*[@id='menu-']/div[3]/ul/li"), 5);
				} catch (Exception ex) {
					approverselect = null;

				}
			}
		}
		for (int i = 0; i < approverselect.size(); i++) {
			if (approverselect.get(i).getText().contains(approverDetails.get(0).get("approver"))) {
				CommonUtility.cClick(driver, approverselect.get(i));
			}
		}
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
	}
}
