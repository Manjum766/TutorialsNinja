package com.VRJD.TutorialsNinja.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VRJD.TutorialsNinja.Utilities.CommonUtils;
import com.VRJD.TutorialsNinja.Utilities.ElementUtils;

public class HomePage {

	WebDriver driver;
	private ElementUtils elementUtils;

	// Constructor : Maintain the WebDriver Instance across all the Classes
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	// Web Elements
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccount_DropMenu;

	@FindBy(linkText = "Login")
	private WebElement login_Option;

	@FindBy(linkText = "Register")
	private WebElement register_Option;

	@FindBy(name = "search")
	private WebElement search_TxtBx;

	@FindBy(xpath = "//button[contains(@class,'btn-default')]")
	private WebElement search_Btn;

	// Action Methods
	public void clickOnMyAccount() {
		elementUtils.clickOnElement(myAccount_DropMenu, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public LoginPage selectLoginOption() {
		elementUtils.clickOnElement(login_Option, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);
	}

	public RegisterPage selectRegisterOption() {
		elementUtils.clickOnElement(register_Option, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterPage(driver);
	}

	public void enterProductIntoSearchBox(String productName) {
		elementUtils.typeTextIntoElement(search_TxtBx, productName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public SearchResultPage clickOnSearchButton() {
		elementUtils.clickOnElement(search_Btn, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new SearchResultPage(driver);
	}
}
