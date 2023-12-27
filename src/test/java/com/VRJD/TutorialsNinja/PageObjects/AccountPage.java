package com.VRJD.TutorialsNinja.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VRJD.TutorialsNinja.Utilities.CommonUtils;
import com.VRJD.TutorialsNinja.Utilities.ElementUtils;

public class AccountPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	// Constructor : Maintain the WebDriver Instance across all the Classes
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	// Web Elements
	@FindBy(linkText = "Edit your account information")
	private WebElement editYourAccountInformation_Lnk;

	// Action Methods
	public boolean displayStatusOfEditYourAccountInformation() {
		return elementUtils.displayStatusOfElement(editYourAccountInformation_Lnk,
				CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
