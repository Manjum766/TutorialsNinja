package com.VRJD.TutorialsNinja.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VRJD.TutorialsNinja.Utilities.CommonUtils;
import com.VRJD.TutorialsNinja.Utilities.ElementUtils;

public class LoginPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	// Constructor : Maintain the WebDriver Instance across all the Classes
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	// Web Elements
	@FindBy(id = "input-email")
	private WebElement email_TxtBx;

	@FindBy(id = "input-password")
	private WebElement password_TxtBx;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement login_Btn;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warning_Msg;

	// Action Methods
	public void enterEmailAddress(String emailAddress) {
		elementUtils.typeTextIntoElement(email_TxtBx, emailAddress, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterPassword(String password) {
		elementUtils.typeTextIntoElement(password_TxtBx, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public AccountPage clickOnLoginButton() {
		elementUtils.clickOnElement(login_Btn, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountPage(driver);
	}

	public String getWarningMessageText() {
		return elementUtils.getTextFromElement(warning_Msg, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
