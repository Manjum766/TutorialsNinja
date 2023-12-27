package com.VRJD.TutorialsNinja.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

	WebDriver driver;

	// Constructor : Maintain the WebDriver Instance across all the Classes
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Web Elements
	@FindBy(linkText = "HP LP3065")
	private WebElement validHPProduct;

	@FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
	private WebElement messageText;

	@FindBy(linkText = "Samsung SyncMaster 941BW")
	private WebElement samsungProduct_Lnk;

	@FindBy(xpath = "//span[text()='Add to Cart']/..")
	private WebElement addToCart_Btn;

	// Action Methods
	public boolean displayStatusOfValidProduct() {
		return validHPProduct.isDisplayed();
	}

	public String getMessageText() {
		return messageText.getText();
	}

}
