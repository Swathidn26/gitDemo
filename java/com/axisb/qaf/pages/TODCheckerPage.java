package com.axisb.qaf.pages;

import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.utils.CommonUtility;
import com.qmetry.qaf.automation.core.AutomationError;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class TODCheckerPage extends WebDriverBaseTestPage<WebDriverTestPage> {


	@FindBy(locator = "//div[@class='serviceRequestNumber']/ancestor::span/../div/div/div[2]")
	private QAFWebElement pendingRequest;
	
	@FindBy(locator = "//*[contains(text(),'I accept')]/../div/span/span")
	private QAFWebElement tncCheckBox;
	
	@FindBy(locator = "//span[text()='terms and conditions']/parent::a")
	private QAFWebElement tncLink;
	
	@FindBy(locator = "//span[text()='Approve']/ancestor::button[not(contains(@class,'disableProceedButton'))]")
	private QAFWebElement approveBtn;
	
	@FindBy(locator = "//span[text()='Reject']/ancestor::button[not(contains(@class,'disableReferback'))]")
	private QAFWebElement rejectBtn;
	
	@FindBy(locator = "//span[text()='Approve']/ancestor::button[(contains(@class,'disableProceedButton'))]")
	private QAFWebElement disabledApproveBtn;
	
	@FindBy(locator = "//span[text()='Reject']/ancestor::button[(contains(@class,'disableReferback'))]")
	private QAFWebElement disabledRejectBtn;

	@FindBy(locator = "//h3[contains(@class,DialogBox)]")
	private QAFWebElement otpScreen;
	
	@FindBy(locator="//div[contains(@class,'Alert-message')]")
	private QAFWebElement toastMsgBox;
	
	@FindBy(locator="//*[@id='filled-multiline-static']")
	private QAFWebElement remarkTextArea;
	
	@FindBy(locator="//span[text()='Submit']")
	private QAFWebElement submitBtn;
	
	@FindBy(locator = "//div[@class='serviceRequestNumber'][1]")
	private QAFWebElement reqNumber;
	
	@FindBy(locator = "//*[text()='Customer ID']/../div[2]")
	private QAFWebElement custIDSR;
	
	@FindBy(locator = "//*[text()='Request Details']")
	private QAFWebElement requestDetailsSR;
	
	@FindBy(locator = "//*[text()='Amount']/div[2]")
	private QAFWebElement amountSR;
	
	@FindBy(locator = "//*[text()='Initiated By'][1]/../div[2]")
	private QAFWebElement initiatedBySR;

	@FindBy(locator = "//*[text()='Request Number']/parent::div/../../div[2]/div[2]")
	private QAFWebElement headerCheckBox;
	
	@FindBy(locator="//*[text()='PENDING']")
	private QAFWebElement anyPendingRequest;

	public void clickFirstPendingRequest() throws Exception {
		if(CommonUtility.cVerifyElementIsVisible(driver, anyPendingRequest, 5))
		{
		CommonUtility.cScrollIntoViewUsingJavascriptExecutor(driver, pendingRequest);
		boolean flag = CommonUtility.cVerifyElementIsPresent(driver, pendingRequest, 5);
		Validator.assertTrue(flag, "Test Failed! No pending request present in the table", "Pending request is present");
		try {
			CommonUtility.cClick(driver, pendingRequest);
		} catch (customElementNotClickableException e) {
			Validator.assertTrue(false, "Test Failed! No pending request present in the table", "Pending request is present");
		} }
		else {
			throw new AutomationError("No Pending request found for approving. Please create request from MAKER flow");
		}
	}
	
	public void verifyTnC() throws Exception {
		driver.switchTo().defaultContent();
						
		boolean flag4 = CommonUtility.cVerifyElementIsPresent(driver, rejectBtn, 5);
		Validator.assertTrue(flag4, "Test Failed! Reject button is not present/ disabled. Check in Screenshot", "Reject button is present and enabled");
		
		boolean flag1 = CommonUtility.cVerifyElementIsVisible(driver, tncCheckBox, 10);
		Validator.assertTrue(flag1, "Test Failed! T&C checkBox is not present", "T&C Check box is present");
		
		boolean flag2 = CommonUtility.cVerifyElementIsPresent(driver, tncLink, 5);
		Validator.assertTrue(flag2, "Test Failed! T&C link is not present", "T&C link is present");

	}
	
	public void verifyDisabledApproveButtons() throws Exception{
		boolean flag3 = CommonUtility.cVerifyElementIsPresent(driver, disabledApproveBtn, 5);
		Validator.assertTrue(flag3, "Test Failed! Approve button is not present/ not disabled. Check in Screenshot", "Approve button is present and disabled");
	
	}

	
	public void clickTnCApprove() throws customElementNotClickableException, customElementNotFoundException {
		try {
			CommonUtility.cClick(driver, tncCheckBox);
			CommonUtility.cClick(driver, approveBtn);
		} catch (customElementNotClickableException e) {
			Validator.assertTrue(false, "Test Failed!  No data for Pending/ No T&C check box visible. Check in Screenshot", "Pass");
		} 
	}
	
	public void validateOTPScreen() throws Exception {
		boolean flag1=CommonUtility.cVerifyElementIsPresent(driver, otpScreen, 3);
		Validator.assertTrue(flag1, "Test Failed! OTP screen is not displayed", "OTP screen is displayed");
	}
	
	public void verifySuccesMessage() throws customElementNotFoundException {
		CommonUtility.cExplicitlyWait(driver, toastMsgBox, 2);
		String message = toastMsgBox.getText();
		boolean flag = message.equals("Successfully sent the reason for rejection");
		Validator.assertTrue(flag, "Test Failed! Actual Toast message displayed: "+message +" Expected toast message: [Successfully sent the reason for rejection]", "Test Passed. Toast message displayed: : "+message);
	}
	
	public void addRemarks() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, rejectBtn);
		CommonUtility.cSendKeys(driver, remarkTextArea, "Test");	
	}
	
	public void clickSubmit() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, submitBtn);
	}

	public void clickReject() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cClick(driver, rejectBtn);	
	}

	public void clickFirstRequest() throws customElementNotClickableException, customElementNotFoundException {
		CommonUtility.cExplicitlyWait(driver, reqNumber, 3);
		CommonUtility.cClick(driver, reqNumber);
		
	}

	public void verifyServiceOverviewScreen() throws Exception {
		CommonUtility.cExplicitlyWait(driver, custIDSR, 5);
		
		String cid = custIDSR.getText();
		boolean flag1 = !custIDSR.getText().isBlank();
		Validator.assertTrue(flag1, "Test Failed! customer ID is not populated", "customer ID is populated");
		
		boolean flag2 = CommonUtility.cVerifyElementIsVisible(driver, requestDetailsSR, 0);
		Validator.assertTrue(flag2, "Test Failed! Request detail section is not present", "Request detail section is present");
		
		String amt = amountSR.getText();
		boolean flag3 = !amountSR.getText().isBlank();
		Validator.assertTrue(flag3, "Test Failed! Amount is not populated", "Amount is populated");
		
		String by = initiatedBySR.getText();
		boolean flag4 = !initiatedBySR.getText().isBlank();
		Validator.assertTrue(flag4, "Test Failed! Initiated by is not populated", "Initiated by is populated");
		
	}

	public void clickHeaderCheckBox() throws Exception {
		if(CommonUtility.cVerifyElementIsVisible(driver, anyPendingRequest, 5)){
		try {
			CommonUtility.cClick(driver, headerCheckBox);
		} catch (customElementNotClickableException e) {
			Validator.assertTrue(false, "Test Failed!  No data for Pending", "Pass");
		}
		}
		else {
			throw new AutomationError("No Pending request found for approving. Please create request from MAKER flow");
		}
	}

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}	

}
