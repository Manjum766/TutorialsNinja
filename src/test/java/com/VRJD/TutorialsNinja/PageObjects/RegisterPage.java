package com.VRJD.TutorialsNinja.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VRJD.TutorialsNinja.Utilities.CommonUtils;
import com.VRJD.TutorialsNinja.Utilities.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	// Constructor : Maintain the WebDriver Instance across all the Classes
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	// Web Elements
	@FindBy(id = "input-firstname")
	private WebElement firstName_TxtBx;

	@FindBy(id = "input-lastname")
	private WebElement lastName_TxtBx;

	@FindBy(id = "input-email")
	private WebElement email_TxtBx;

	@FindBy(id = "input-telephone")
	private WebElement telephone_TxtBx;

	@FindBy(id = "input-password")
	private WebElement password_TxtBx;

	@FindBy(id = "input-confirm")
	private WebElement confirmPassword_TxtBx;

	@FindBy(name = "agree")
	private WebElement privacyPolicy_ChkBx;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continue_Btn;

	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement yes_RBtn;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warning_Msg;

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstName_Warning_Msg;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastName_Warning_Msg;

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement email_Warning_Msg;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephone_Warning_Msg;

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement password_Warning_Msg;

	// Action Methods
	public void enterFirstName(String firstName) {
		elementUtils.typeTextIntoElement(firstName_TxtBx, firstName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterLastName(String lastName) {
		elementUtils.typeTextIntoElement(lastName_TxtBx, lastName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterEmailAddress(String emailAddress) {
		elementUtils.typeTextIntoElement(email_TxtBx, emailAddress, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterTelephone(String telephone) {
		elementUtils.typeTextIntoElement(telephone_TxtBx, telephone, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterPassword(String password) {
		elementUtils.typeTextIntoElement(password_TxtBx, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterConfirmPassword(String password) {
		elementUtils.typeTextIntoElement(confirmPassword_TxtBx, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void selectPrivacyPolicy() {
		elementUtils.clickOnElement(privacyPolicy_ChkBx, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public AccountSuccessPage clickOnContinueButton() {
		elementUtils.clickOnElement(continue_Btn, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountSuccessPage(driver);
	}

	public void selectYesNewsLetterOption() {
		elementUtils.clickOnElement(yes_RBtn, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getWarningMessageText() {
		return elementUtils.getTextFromElement(warning_Msg, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getFirstNameWarningMessageText() {
		return elementUtils.getTextFromElement(firstName_Warning_Msg, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getLastNameWarningMessageText() {
		return elementUtils.getTextFromElement(lastName_Warning_Msg, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getEmailWarningMessageText() {
		return elementUtils.getTextFromElement(email_Warning_Msg, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getTelephoneWarningMessageText() {
		return elementUtils.getTextFromElement(telephone_Warning_Msg, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getPasswordWarningMessageText() {
		return elementUtils.getTextFromElement(password_Warning_Msg, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
