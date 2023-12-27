package com.VRJD.TutorialsNinja.Utilities;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import com.VRJD.TutorialsNinja.TestBase.BaseClass;

public class ElementUtils extends BaseClass {

	String exeFilePath = System.getProperty("user.dir") + "\\Documents\\FileUpload.exe";
	String pdfFilePath = System.getProperty("user.dir") + "\\Documents\\Test.pdf";

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Method for clicking on WebElements such as Button, RadioButton, CheckBox etc
	 * 
	 * @param element
	 * @param durationInSeconds
	 */
	public void clickOnElement(WebElement element, long durationInSeconds) {
		try {
			WebElement webElement = waitForElement(element, durationInSeconds);
			webElement.click();
			logger.info("Click action performed on WebElement successfully");
		} catch (Exception e) {
			logger.error("Failed to click on Element due to some Exception", e);
		}
	}

	/**
	 * Method for entering value into Text Field
	 * 
	 * @param element
	 * @param textToBeTyped
	 * @param durationInSeconds
	 */
	public void typeTextIntoElement(WebElement element, String textToBeTyped, long durationInSeconds) {
		try {
			WebElement webElement = waitForElement(element, durationInSeconds);
			webElement.click();
			webElement.clear();
			webElement.sendKeys(textToBeTyped);
			logger.info("Entered value '" + textToBeTyped + "' into the text field");
		} catch (Exception e) {
			logger.error("Failed to enter value '" + textToBeTyped + "' into the text field", e);
		}
	}

	/**
	 * Method to wait for particular time till the element is clickable
	 * 
	 * @param element
	 * @param durationInSeconds
	 * @return
	 */
	public WebElement waitForElement(WebElement element, long durationInSeconds) {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return webElement;
	}

	/**
	 * Method for selecting the value using displayed text
	 * 
	 * @param element
	 * @param dropDownOption
	 * @param durationInSeconds
	 */
	public void selectOptionInDropdown(WebElement element, String dropDownOption, long durationInSeconds) {
		try {
			WebElement webElement = waitForElement(element, durationInSeconds);
			Select select = new Select(webElement);
			select.selectByVisibleText(dropDownOption);
			logger.info("Successfully selected value '" + dropDownOption + "' in the dropdown");
		} catch (Exception e) {
			logger.error("Failed to select value '" + dropDownOption + "' from the drop down", e);
			e.printStackTrace();
		}
	}

	public void acceptAlert(long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.accept();
	}

	public void dismissAlert(long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();
	}

	public Alert waitForAlert(long durationInSeconds) {
		Alert alert = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return alert;
	}

	public void mouseHoverAndClick(WebElement element, long durationInSeconds) {
		element = waitForVisibilityOfElement(element, durationInSeconds);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}

	public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return webElement;
	}

	public void javaScriptClick(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", webElement);
	}

	public void javaScriptClick(WebElement element, String textToBeTyped, long durationInSeconds) {
		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].value='" + textToBeTyped + "'", webElement);
	}

	public String getTextFromElement(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForElement(element, durationInSeconds);
		return webElement.getText();
	}

	/**
	 * Method for verifying the element is Visible and returning true or false
	 * 
	 * @param element
	 * @param durationInSeconds
	 * @return
	 */
	public boolean displayStatusOfElement(WebElement element, long durationInSeconds) {
		try {
			WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
			return webElement.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	// ======================= WEBDRIVER WAITS ======================= //

	/**
	 * Method to wait for particular time till the Element is Visible
	 * 
	 * @param element
	 * @return
	 */
	public WebElement waitTillElementVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	/**
	 * Method to wait for particular time till the Element is Visible
	 * 
	 * @param element
	 * @param seconds
	 */
	public void waitTillElementVisible(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Method to wait for particular time till the Element is Not Visible
	 * 
	 * @param element
	 * @param seconds
	 */
	public static void waitTillElementInVisible(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitForInvisibility(WebElement webElement, int maxSeconds) {
		Long startTime = System.currentTimeMillis();
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			while (System.currentTimeMillis() - startTime < maxSeconds * 1000 && webElement.isDisplayed()) {
			}
		} catch (NoSuchElementException e) {
			return;
		} catch (StaleElementReferenceException e) {
			return;
		} finally {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
	}

	/**
	 * Method to wait for particular time till the Element is Clickable
	 * 
	 * @param element
	 */
	public static void elementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// ======================= JAVA SCRIPT EXECUTOR ======================= //

	/**
	 * Method for clicking on WebElement using Java Script
	 * 
	 * @param element
	 */
	public static void clickElementUsingJavaScript(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			logger.error("Failed to click on Element due to some Exception", e);
		}
	}

	/**
	 * Method for scrolling the web page until the specific element is in View
	 */
	public static void scrollIntoViewUsingJavaScript(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method for scrolling up the web page by specified pixel
	 */
	public static void scrollUpUsingJavaScript() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-2000)");
	}

	/**
	 * Method for scrolling down the web page by specified pixel
	 */
	public static void scrollDownUsingJavaScript() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,10000)");
	}

	/**
	 * Method for scrolling the document in the window by specified value
	 */
	public static void scrollByUsingJavaScript() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	/**
	 * Method for Zooming Page by 75 Percentage
	 */
	public static void zoomBy75Percentage() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.body.style.zoom = '0.75'");
	}

	// ======================= ACTION CLASS ======================= //

	/**
	 * Method for performing mouse Hover action
	 * 
	 * @param element
	 */
	public void mouseHover(WebElement element) {
		try {
			Actions builder = new Actions((driver));
			builder.moveToElement(element).build().perform();
			Thread.sleep(3000);
			logger.info("Mouse Hover on the WebElement Successfully");
		} catch (Exception e) {
			logger.error("Fialed to Mouse Hover on WebElement", e);
		}
	}

	/**
	 * Method for performing mouse Hover action and click on the WebElement
	 * 
	 * @param element
	 */
	public void mouseHoverAndClick(WebElement element) {
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(element).click().perform();
			logger.info("Mouse Hover on the WebElement and performed click action Successfully");
		} catch (Exception e) {
			logger.error("Fialed to Mouse Hover and click on the WebElement", e);
		}
	}

	/**
	 * Method for performing Double Click action on the WebElement
	 * 
	 * @param element
	 */
	public static void doubleClick(WebElement element) {
		try {
			Actions builder = new Actions(driver);
			builder.doubleClick(element).perform();
			logger.info("Successfully performed Double Click on the WebElement");
		} catch (Exception e) {
			logger.error("Failed to perform Double Click Action on the WebElement", e);
			e.printStackTrace();
		}
	}

	/**
	 * Method for Drag and Drop actions on the WebElement
	 * 
	 * @param sourceElement
	 * @param targetElement
	 */
	public void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
		try {
			Actions builder = new Actions((driver));
			builder.dragAndDrop(sourceElement, targetElement).build().perform();
			logger.info("Successfully performed Drag and Drop Action on the WebElement");
		} catch (Exception e) {
			logger.error("Failed to perform Drag and Drop Action on the WebElement", e);
		}
	}

	// ======================= SELECT CLASS ======================= //

	/**
	 * Method for selecting the value using Displayed Text
	 * 
	 * @param element
	 * @param text
	 */
	public void selectUsingVisibleText(WebElement element, String text) {
		try {
			waitTillElementVisible(element);
			String labelName = element.getAttribute("name");
			Select dropDown = new Select(element);
			dropDown.selectByVisibleText(text);
			logger.info("Successfully selected value '" + text + "' in the '" + labelName + "' dropdown");
		} catch (Exception e) {
			logger.error("Failed to select value '" + text + "' from the drop down", e);
			e.printStackTrace();
		}
	}

	/**
	 * Method for printing all the options available in the drop down
	 * 
	 * @param element
	 */
	public static void getOptions(WebElement element) {
		Select objSelect = new Select(element);
		List<WebElement> DropDownValues = objSelect.getOptions();
		for (WebElement options : DropDownValues) {
			System.out.println(options.getText());
		}
	}

	/**
	 * Method for retrieving the currently selected Option from the drop down
	 * 
	 * @param element
	 * @return
	 */
	public static String getFirstSelectedOption(WebElement element) {
		Select objSelect = new Select(element);
		WebElement option = objSelect.getFirstSelectedOption();
		String selectedoption = option.getText();
		System.out.println("Selected element: " + selectedoption);
		return selectedoption;
	}

	/**
	 * Method to verify value is present inside drop down
	 * 
	 * @param element
	 * @param value
	 * @return
	 * @throws InterruptedException
	 */
	public boolean verifyDropDownValuePresent(WebElement element, String value) throws InterruptedException {
		boolean blnPass = false;
		waitTillElementVisible(element);
		Select objSelect = new Select(element);
		List<WebElement> lstvaluesInSelect = objSelect.getOptions();
		for (WebElement option : lstvaluesInSelect) {
			if (option.getText().equals(value)) {
				blnPass = true;
			}
		}
		if (blnPass) {
			return true;
		} else {
			return false;
		}
	}

	// ======================= ALERT CLASS ======================= //

	/**
	 * Method for switching to alert and accepting it
	 */
	public void acceptAlert() {
		driver.switchTo().alert().accept();
		logger.info("Handled the alert successfully");
	}

	/**
	 * Method for switching to alert and rejecting it
	 */
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
		logger.info("Handled the alert successfully");
	}

	/**
	 * Method for switching to alert and getting text
	 * 
	 * @return
	 */
	public String getAlertText() {
		String text = driver.switchTo().alert().getText();
		return text;
	}

	// ======================= VERIFICATION ======================= //

	/**
	 * Method for verifying the element is Visible
	 * 
	 * @param element
	 */
	public void verifyElementPresent(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.info(element + "was found");
		} catch (Exception e) {
			logger.error("Unable to find the element" + element + ":" + e);
		}
	}

	/**
	 * Method for verifying the element is Visible and returning true or false
	 * 
	 * @param element
	 * @return
	 */
	public static boolean checkElementIsVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.isDisplayed();
	}

	/**
	 * Method for validating the element is Editable
	 * 
	 * @param element
	 */
	public static void Enabled(WebElement element) {
		Assert.assertEquals(true, element.isEnabled(), "Element is not Editable");
		Assert.assertEquals(true, element.isDisplayed(), "Element is not Displayed");
	}

	/**
	 * Method for validating the field is Enabled
	 * 
	 * @param enabled
	 * @param element
	 * @param elementName
	 * @throws InterruptedException
	 */
	public void checkEnabled(String enabled, WebElement element, String elementName) throws InterruptedException {
		if (enabled.equalsIgnoreCase("yes")) {
			Assert.assertTrue(element.isEnabled(), elementName + " is Disabled");
		} else if (enabled.equalsIgnoreCase("no")) {
			Assert.assertFalse(element.isEnabled(), elementName + " is Enabled");
		}
	}

	/**
	 * Method for validating the element is Non-Editable
	 * 
	 * @param element
	 */
	public static void NonEditable(WebElement element) {
		String readonly = element.getAttribute("readonly");
		Assert.assertNull(readonly, "Text field is Editable");
	}

	/**
	 * Method for verifying if 2 Strings are equal
	 * 
	 * @param firstString
	 * @param secondString
	 */
	public static void verifyStringsAreEqual(String firstString, String secondString) {
		logger.info(firstString + "<equals>" + secondString);
		Assert.assertEquals(firstString, secondString);
	}

	// ======================= ROBOT CLASS ======================= //

	/**
	 * Method for performing Zoom Out Action using Robot Class
	 * 
	 * @throws AWTException
	 */
	public static void zoomOutUsingRobotClass() throws AWTException {
		Robot robot = new Robot();
		for (int i = 1; i <= 3; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_MINUS);
		}
	}

	/**
	 * Method to 'Upload File' using 'Robot Class'
	 * 
	 * @param filePath
	 * @throws AWTException
	 */
	public void uploadFileUsingRobotClass(String filePath) throws AWTException {
		StringSelection stringSelection = new StringSelection(filePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		Robot robot;
		try {
			robot = new Robot();
			robot.delay(3000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.delay(3000);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.delay(3000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(3000);
			System.out.println("!!! Document Uploaded Successfully !!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ======================= AUTO IT ======================= //

	/**
	 * Method to 'Upload File' using 'Auto IT'
	 */
	public void uploadFileUsingAutoIT() {
		try {
			Runtime.getRuntime().exec(exeFilePath + " " + pdfFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
