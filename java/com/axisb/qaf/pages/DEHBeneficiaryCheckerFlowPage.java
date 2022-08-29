package com.axisb.qaf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.axisb.qaf.utils.CommonUtility;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class DEHBeneficiaryCheckerFlowPage extends WebDriverBaseTestPage<WebDriverTestPage>  {

	

@FindBy(locator = "xpath=//div[text()='Beneficiary']")
private QAFWebElement beneficiaryTab;

@FindBy(locator="xpath=(//div[@col-id='beneCode'])[2]")
private QAFWebElement benecodetext;

@FindBy(locator = "xpath=//input[@placeholder='Search']")
private QAFWebElement searchInput;

public void clickBeneficiaryTab() throws customElementNotClickableException, customElementNotFoundException, InterruptedException {
CommonUtility.cClick(driver, beneficiaryTab);
Thread.sleep(3000);
}


public void searchbenetext() throws customElementNotClickableException, customElementNotFoundException, InterruptedException {
	Actions actions = new Actions(driver);
	String text = benecodetext.getText();
	CommonUtility.cSendKeys(driver, searchInput, text);
	Thread.sleep(3000);
	WebElement clickText = CommonUtility.cFindElement(driver, By.xpath("//p[contains(text(),'"+text+"')]"), 3);
	CommonUtility.cClick(driver, clickText);
	Thread.sleep(3000);
	CommonUtility.cFindElement(driver, By.xpath("//body"), 3).click();
	actions.moveByOffset(0, 0).click().build().perform();
	Thread.sleep(3000);
}
	
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
}
