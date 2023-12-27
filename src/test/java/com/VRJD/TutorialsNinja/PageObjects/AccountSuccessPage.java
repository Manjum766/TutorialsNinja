package com.VRJD.TutorialsNinja.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VRJD.TutorialsNinja.Utilities.CommonUtils;
import com.VRJD.TutorialsNinja.Utilities.ElementUtils;

public class AccountSuccessPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	// Constructor : Maintain the WebDriver Instance across all the Classes
	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	// Web Elements
	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement pageHeading;

	// Action Methods
	public String getPageHeading() {
		return elementUtils.getTextFromElement(pageHeading, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
