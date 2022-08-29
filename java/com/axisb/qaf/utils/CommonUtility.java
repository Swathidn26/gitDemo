/*******************Documentation*****************************
 *************************************************************
Project Name= Axis Bank Digital Platform
Author=Soumi Banerjee
Date=03-Feb-2022
Description= Common Utility that can be used in order to avoid redundancy in the code.
Methods=
# cClick(WebDriver, WebElement)
# cClickUsingJavaScriptExecutor(WebDriver, WebElement)
# cExplicitlyWait(WebDriver, By, int)
# cExplicitlyWait(WebDriver, WebElement, int)
# cExplicitlyWaitForWebElements(WebDriver, By, int)
# cExplicitlyWaitForWebElements(WebDriver, List<WebElement>, int)
# cFindElement(WebDriver, By, int)
# cFindElement(WebDriver, WebElement, int)
# cFindElements(WebDriver, By, int)
# cFindElements(WebDriver, List<WebElement>, int)
# cHighlightElement(WebDriver, WebElement)
# cScrollIntoViewUsingJavascriptExecutor(WebDriver, WebElement)
# cSelectElementFromDropdownUsingJavaScriptExecutor(WebDriver, WebElement, String)
# cSelectElementFromDrpdownUsingJavaScriptExecutorByIndex(WebDriver, WebElement, int)
# cSelectFromDropdownByIndex(WebDriver, WebElement, int)
# cSelectFromDropdownByValue(WebDriver, WebElement, String)
# cSelectFromDropdownByVisibleText(WebDriver, WebElement, String)
# cSendKeys(WebDriver, WebElement, String)
# cSendKeysUsingJavaScriptExecutor(WebDriver, WebElement, String)
# cWaitForDropDwnToLoad(WebDriver, WebElement)
# cWaitForPageLoad(WebDriver)
# cMoveToElementByTarget(WebDriver, WebElement)
# cMoveToElementFromSourceToTarget(WebDriver, WebElement, WebElement)

How to Use=
1. Extend the CommonUtility Class using the "extends" keyword and Directly call the Functions(Recommended)
2. Create an object of the CommonUtility class and access the Methods using Object name and dot Operator.
 ****************************************************************
 ****************************************************************/

package com.axisb.qaf.utils;

import java.io.FileReader;
import java.io.IOException;
import java.security.Key;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.axisb.qaf.exceptions.customElementFoundException;
import com.axisb.qaf.exceptions.customElementNotClickableException;
import com.axisb.qaf.exceptions.customElementNotFoundException;
import com.qmetry.qaf.automation.util.FileUtil;
import com.qmetry.qaf.automation.util.Reporter;

enum TimeoutsEnum {
	HIGH(60), MED(20), LOW(10), VERYLOW(3);

	private int time;

	TimeoutsEnum(int time) {
		this.time = time;
	}

	public int getTime() {
		return this.time;
	}

	public int setTime() {
		return this.time;
	}
}

public class CommonUtility {

	public static FileReader read = null;
	public static Properties property= null;

	public static void cExplicitlyWait(WebDriver driver, WebElement eleIdentifier, int timeOutInSeconds)
			throws customElementNotFoundException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.pollingEvery(Duration.ofSeconds(2));
			wait.ignoring(Exception.class);
			wait.until(ExpectedConditions.elementToBeClickable(eleIdentifier));
		} catch (Exception e) {
			Reporter.log("Report-Wait timeout!! Couldn't find Element-" + e.getMessage());
			throw new customElementNotFoundException(e.getMessage());
		}
	}
	//To Verify if a Element is Present and Enabled after certain Timeout
		public static Boolean cVerifyElementIsPresent(WebDriver driver, WebElement eleIdentifier, int timeOutInSeconds)
				throws Exception {
			try {
				CommonUtility.cExplicitlyWait(driver, eleIdentifier, timeOutInSeconds);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
 
    public static void cExplicitlyWaitForWebElements(WebDriver driver, List<WebElement> eleIdentifier,
			int timeOutInSeconds) throws customElementNotFoundException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.pollingEvery(Duration.ofSeconds(2));
			wait.ignoring(Exception.class);
			wait.until(ExpectedConditions.elementToBeClickable(eleIdentifier.get(0)));
		} catch (Exception e) {
			Reporter.log("Report-Wait timeout!! Couldn't find Element-" + e.getMessage());
			throw new customElementNotFoundException(e.getMessage());
		}
	}

	public static void cExplicitlyWaitForWebElements(WebDriver driver, By eleIdentifier, int timeOutInSeconds)
			throws customElementNotFoundException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.pollingEvery(Duration.ofSeconds(2));
			wait.ignoring(Exception.class);
			wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(eleIdentifier, 0));
		} catch (Exception e) {
			Reporter.log("Report-Wait timeout!! Couldn't find Element-" + e.getMessage());
			throw new customElementNotFoundException(e.getMessage());
		}
	}

	public static void cExplicitlyWait(WebDriver driver, By eleIdentifier, int timeOutInSeconds)
			throws customElementNotFoundException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.pollingEvery(Duration.ofSeconds(2));
			wait.ignoring(Exception.class);
			wait.until(ExpectedConditions.elementToBeClickable(eleIdentifier));
		} catch (Exception e) {
			Reporter.log("Report-Wait timeout!! Couldn't find Element-" + e.getMessage());
			throw new customElementNotFoundException(e.getMessage());
		}
	}

	public static void cClick(WebDriver driver, WebElement eleIdentifier)
			throws customElementNotClickableException, customElementNotFoundException {
		try {
			cScrollIntoViewUsingJavascriptExecutor(driver, eleIdentifier);
			cHighlightElement(driver, eleIdentifier);
			cFindElement(driver, eleIdentifier, TimeoutsEnum.LOW.getTime()).click();
		} catch (Exception e) {
			try {
				cHighlightElement(driver, eleIdentifier);
				cClickUsingJavaScriptExecutor(driver, eleIdentifier);
			} catch (Exception e1) {
				throw new customElementNotClickableException(e1.getMessage());
			}
		}
	}

	public static void cWaitForLoaderAbsenceWithTripleDot(WebDriver driver,int timeOutInSeconds) throws customElementFoundException {
		try {
			cFindElement(driver, By.xpath("//div[contains(@class,'loader')]"), 5);
		} catch (Exception e) {
		}
		cExplicitlyWaitForAbsence(driver, By.xpath("//div[contains(@class,'loader')]"), timeOutInSeconds);
	}
	
	public static void cWaitForLoaderAbsenceWithSpinner(WebDriver driver,int timeOutInSeconds) throws customElementFoundException {
		try {
			cFindElement(driver, By.xpath("//div[contains(@class,'loading')]"), 5);
		} catch (Exception e) {
		}
		cExplicitlyWaitForAbsence(driver, By.xpath("//div[contains(@class,'loading')]"), timeOutInSeconds);
	}
	

	public static void cClickUsingJavaScriptExecutor(WebDriver driver, WebElement eleIdentifier)
			throws customElementNotFoundException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement toBeClicked = cFindElement(driver, eleIdentifier, TimeoutsEnum.LOW.getTime());
		js.executeScript("arguments[0].click();", toBeClicked);
	}
	
	public static void cClearUsingJavaScriptExecutor(WebDriver driver, WebElement eleIdentifier) throws Exception
	{try {
		cHighlightElement(driver, eleIdentifier);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='';", eleIdentifier);
	}catch(Exception e)
	{
		throw new Exception(e.getMessage());
	}}

	public static void cSendKeys(WebDriver driver, WebElement eleIdentifier, String strText)
			throws customElementNotClickableException, customElementNotFoundException {
		try {
			cHighlightElement(driver, eleIdentifier);
			cFindElement(driver, eleIdentifier, TimeoutsEnum.LOW.getTime()).clear();
			cFindElement(driver, eleIdentifier, TimeoutsEnum.LOW.getTime()).sendKeys(strText);
			;
		} catch (Exception e) {
			try {
				cHighlightElement(driver, eleIdentifier);
				cSendKeysUsingJavaScriptExecutor(driver, eleIdentifier, strText);
			} catch (Exception e1) {
				throw new customElementNotClickableException(e1.getMessage());
			}
		}
	}

	public static void cSendKeysUsingJavaScriptExecutor(WebDriver driver, WebElement eleIdentifier, String strText)
			throws customElementNotFoundException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement toBeFound = cFindElement(driver, eleIdentifier, TimeoutsEnum.LOW.getTime());
		cScrollIntoViewUsingJavascriptExecutor(driver, eleIdentifier);
		cHighlightElement(driver, eleIdentifier);
		cFindElement(driver, eleIdentifier, TimeoutsEnum.LOW.getTime()).clear();
		String script = "arguments[0].value='" + strText + "';";
		js.executeScript(script, toBeFound);
	}

	public static void cSelectFromDropdownByIndex(WebDriver driver, WebElement eleIdentifier, int index)
			throws customElementNotClickableException, customElementNotFoundException {
		try {
			cHighlightElement(driver, eleIdentifier);
			Select objSelect = new Select(cFindElement(driver, eleIdentifier, TimeoutsEnum.LOW.getTime()));
			objSelect.selectByIndex(index);

		} catch (Exception e) {
			try {
				cHighlightElement(driver, eleIdentifier);
				cSelectElementFromDrpdownUsingJavaScriptExecutorByIndex(driver, eleIdentifier, index);
			} catch (Exception e1) {
				throw new customElementNotClickableException(e1.getMessage());
			}
		}
	}

	public static void cSelectFromDropdownByValue(WebDriver driver, WebElement eleIdentifier, String strText)
			throws customElementNotClickableException, customElementNotFoundException {
		try {
			cHighlightElement(driver, eleIdentifier);
			Select objSelect = new Select(cFindElement(driver, eleIdentifier, TimeoutsEnum.LOW.getTime()));
			objSelect.selectByValue(strText);

		} catch (Exception e) {
			try {
				cHighlightElement(driver, eleIdentifier);
				cSelectElementFromDropdownUsingJavaScriptExecutor(driver, eleIdentifier, strText);
			} catch (Exception e1) {
				throw new customElementNotClickableException(e1.getMessage());
			}
		}
	}

	public static void cSelectFromDropdownByVisibleText(WebDriver driver, WebElement eleIdentifier, String strText)
			throws customElementNotClickableException, customElementNotFoundException {
		try {
			cHighlightElement(driver, eleIdentifier);
			Select objSelect = new Select(cFindElement(driver, eleIdentifier, TimeoutsEnum.LOW.getTime()));
			objSelect.selectByVisibleText(strText);

		} catch (Exception e) {
			try {
				cHighlightElement(driver, eleIdentifier);
				cSelectElementFromDropdownUsingJavaScriptExecutor(driver, eleIdentifier, strText);
			} catch (Exception e1) {
				throw new customElementNotClickableException(e1.getMessage());
			}
		}
	}

	public static void cSelectElementFromDropdownUsingJavaScriptExecutor(WebDriver driver, WebElement eleIdentifier,
			String strText) throws customElementNotFoundException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement toBeFound = cFindElement(driver, eleIdentifier, TimeoutsEnum.LOW.getTime());
		js.executeScript(
				"var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }",
				toBeFound, strText);
	}

	public static void cSelectElementFromDrpdownUsingJavaScriptExecutorByIndex(WebDriver driver,
			WebElement eleIdentifier, int index) throws customElementNotFoundException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement toBeFound = cFindElement(driver, eleIdentifier, TimeoutsEnum.LOW.getTime());
		String script = "var select = arguments[0]; select.options[" + index + "].selected = true;";
		js.executeScript(script, toBeFound);
	}

	public static void cHighlightElement(WebDriver driver, WebElement eleIdentifier)
			throws customElementNotFoundException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement toBeHighlighted = cFindElement(driver, eleIdentifier, TimeoutsEnum.LOW.getTime());
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
				toBeHighlighted);

	}

	public static void cScrollIntoViewUsingJavascriptExecutor(WebDriver driver, WebElement eleIdentifier)
			throws customElementNotFoundException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement elementToFind = cFindElement(driver, eleIdentifier, TimeoutsEnum.LOW.getTime());
		js.executeScript("arguments[0].scrollIntoView({block: 'center' , inline: 'nearest'});", elementToFind);
		cExplicitlyWait(driver, eleIdentifier, TimeoutsEnum.LOW.getTime());
	}

	public static WebElement cFindElement(WebDriver driver, WebElement eleIdentifier, int timeOutInSeconds)
			throws customElementNotFoundException {
		try {
			cExplicitlyWait(driver, eleIdentifier, timeOutInSeconds);
			return eleIdentifier;
		} catch (Exception e) {
			Reporter.log("Report-Couldn't find Element");
			throw new customElementNotFoundException(e.getMessage());
		}

	}

	public static WebElement cFindElement(WebDriver driver, By eleIdentifier, int timeOutInSeconds)
			throws customElementNotFoundException {
		try {
			cExplicitlyWait(driver, eleIdentifier, timeOutInSeconds);
			WebElement locatedElement = driver.findElement(eleIdentifier);
			return locatedElement;
		} catch (Exception e) {
			Reporter.log("Report-Couldn't find Element");
			throw new customElementNotFoundException(e.getMessage());
		}

	}

	public static List<WebElement> cFindElements(WebDriver driver, List<WebElement> eleIdentifier, int timeOutInSeconds)
			throws customElementNotFoundException {
		try {
			cExplicitlyWaitForWebElements(driver, eleIdentifier, timeOutInSeconds);
			return eleIdentifier;
		} catch (Exception e) {
			Reporter.log("Report-Couldn't find Element");
			throw new customElementNotFoundException(e.getMessage());
		}

	}

	public static List<WebElement> cFindElements(WebDriver driver, By eleIdentifier, int timeOutInSeconds)
			throws customElementNotFoundException {
		try {
			cExplicitlyWaitForWebElements(driver, eleIdentifier, timeOutInSeconds);
			List<WebElement> locatedElements = driver.findElements(eleIdentifier);
			return locatedElements;
		} catch (Exception e) {
			Reporter.log("Report-Couldn't find Element");
			throw new customElementNotFoundException(e.getMessage());
		}

	}

	public static void cWaitForPageLoad(WebDriver driver) {

		Wait<WebDriver> wait = new WebDriverWait(driver, TimeoutsEnum.HIGH.getTime());
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				Reporter.log("Current Window State       : "
						+ String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
				return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});
	}

	public static void cWaitForDropDwnToLoad(WebDriver driver, WebElement eleIdentifier)
			throws customElementNotFoundException {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofMillis(TimeoutsEnum.MED.getTime())).pollingEvery(Duration.ofSeconds(2));

		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					WebElement elemntTobeSelected = cFindElement(driver, eleIdentifier, TimeoutsEnum.LOW.getTime());
					Select select = new Select(elemntTobeSelected);
					if (select.getOptions().size() > 1) {
						return true;
					}
					return false;
				} catch (Exception e) {
					return false;
				}

			}
		};

		wait.until(function);
	}

	public static void cMoveToElementFromSourceToTarget(WebDriver driver, WebElement elementSource,
			WebElement elementTarget) throws customElementNotFoundException {
		Actions actions = new Actions(driver);
		actions.moveToElement(elementSource).perform();
		actions.click().perform();
		cExplicitlyWait(driver, elementTarget, TimeoutsEnum.LOW.getTime());
		actions.moveToElement(elementTarget);
		actions.click().build().perform();
	}

	public static void cMoveToElementByTarget(WebDriver driver, WebElement elementTarget)
			throws customElementNotFoundException {
		Actions actions = new Actions(driver);
		cExplicitlyWait(driver, elementTarget, TimeoutsEnum.LOW.getTime());
		actions.moveToElement(elementTarget);
		actions.click().build().perform();
	}

	public static void cExplicitlyWaitForAbsence(WebDriver driver, By eleIdentifier, int timeOutInSeconds)
			throws customElementFoundException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.pollingEvery(Duration.ofSeconds(2));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(eleIdentifier));
			wait.ignoring(Exception.class);
		} catch (Exception e) {
			Reporter.log("Report-Wait timeout!! Element still exists in the Page-" + e.getMessage());
		}
	}

	public static boolean cPageContainsText(WebDriver driver, String text) throws customElementNotFoundException {
		if (driver.getPageSource().contains(text)) {
			return true;

		} else {
			return false;
		}

	}

	/** Method to Load Properties from application.properties file **/
	public static void cLoadProperties(String filePath) throws IOException {
		read = new FileReader(filePath);
		property= new Properties();
		property.load(read);
	}

	/** Method to Decrypt Passwords from application.properties file **/
	public static String cEncryptPassword(String key, String password) throws Exception {
		Key secretKey= new SecretKeySpec(key.getBytes(), "AES");
		Cipher cipher=Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		String encrypted=new String(Base64.getEncoder().encodeToString(cipher.doFinal(password.getBytes())));
		return encrypted;

	}
	/**
	 * Method to Encrypt Password in application.properties file
	 */
	public static String cDecryptPassword(String key, String encryptedPassword) throws Exception {
		Key secretKey= new SecretKeySpec(key.getBytes(), "AES");
		Cipher cipher=Cipher.getInstance("AES");		
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		String decrypted=new String(cipher.doFinal(Base64.getDecoder().decode(encryptedPassword)));
		return decrypted;
	}
	
	public static void cExplicitlyWaitElementToBeVisible(WebDriver driver, WebElement eleIdentifier, int timeOutInSeconds)
			throws customElementNotFoundException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.pollingEvery(Duration.ofSeconds(2));
			wait.ignoring(Exception.class);
			wait.until(ExpectedConditions.visibilityOf(eleIdentifier));
		} catch (Exception e) {
			Reporter.log("Report-Wait timeout!! Couldn't find Element-" + e.getMessage());
			throw new customElementNotFoundException(e.getMessage());
		}
	}
	
	/**
	 * Method to create Random Numbers
	 * @param noOfDigit= Total number of digits of the Random Number required
	 * @return A String of Random Numbers which can be easily converted to any data types eg- int, long, BigInteger etc
	 */
	public static String cRandomNumberGenerator(int noOfDigit) {
		String randomNumber=RandomStringUtils.randomNumeric(noOfDigit);
		return randomNumber;
	}

	//To Verify if a Element is Present for disabled element
	public static Boolean cVerifyElementIsVisible(WebDriver driver, WebElement eleIdentifier, int timeOutInSeconds)
			throws Exception {
		try {
            CommonUtility.cExplicitlyWaitElementToBeVisible(driver, eleIdentifier, timeOutInSeconds);
            return true;
        } catch (Exception e) {
            return false;
        }
	}
	public static String cCaptureScreenshot(WebDriver driver, String destinationPath) throws Exception {
		TakesScreenshot screenShotTaker=(TakesScreenshot) driver;
		File source=screenShotTaker.getScreenshotAs(OutputType.FILE);
		File destination =new File(destinationPath);
		FileUtil.copyFile(source, destination);
		return destinationPath;
		
	}
	public static void cCreateFolder(String folderPath) throws Exception {
		File file = new File(folderPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		if(!file.exists()) {
			throw new Exception("Folder Creation Failed for- "+folderPath);
		}
	}
	
	public static File cGetLastModifiedFile(String folderPath) throws Exception {
		File file = new File(folderPath);
		File[] files=file.listFiles(File::isFile);
		long lastModifiedTime=Long.MIN_VALUE;
		File latestFile=null;
		if(file!=null) {
			for (File eachfile : files) {
				if(eachfile.lastModified()>lastModifiedTime) {
					latestFile=eachfile;
					lastModifiedTime=eachfile.lastModified();
				}
			}
		}

		return latestFile;
	}
	
	public static String cGetFolderNamewithPartialName(String directory, String partialFolderName) throws Exception {
		File file = new File(directory);
		File[] files=file.listFiles(File::isDirectory);
		String filename="";
		if(file!=null) {
			for (File eachfile : files) {
				if(eachfile.getName().contains(partialFolderName)) {
					filename=eachfile.getName();
					break;
				}
			}
		}
		return filename;
	}
	
	public static String cEncodeImageFileToBase64String(String ImageFilePath) throws Exception {
		File file=new File(ImageFilePath);
		FileInputStream fis=new FileInputStream(file);
		byte[] byteArray=new byte[(int)file.length()];
		fis.read(byteArray);
		fis.close();
		return new String(org.apache.commons.codec.binary.Base64.encodeBase64(byteArray), "UTF-8");

	}
	
}
