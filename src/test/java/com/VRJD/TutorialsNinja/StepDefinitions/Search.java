package com.VRJD.TutorialsNinja.StepDefinitions;

import org.junit.Assert;
import com.VRJD.TutorialsNinja.PageObjects.HomePage;
import com.VRJD.TutorialsNinja.PageObjects.SearchResultPage;
import com.VRJD.TutorialsNinja.TestBase.BaseClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search extends BaseClass {

	private HomePage homePage;
	private SearchResultPage searchResultPage;

	@Given("User opens the Application")
	public void user_opens_the_application() {
		setUp();
	}

	@When("User enters valid product {string} into Search Box field")
	public void user_enters_valid_product_into_search_box_field(String productName) {
		homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBox(productName);
	}

	@And("User clicks on Search button")
	public void user_clicks_on_search_button() {
		searchResultPage = homePage.clickOnSearchButton();
	}

	@Then("User should get Valid Product displayed in Search Results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		Assert.assertTrue(searchResultPage.displayStatusOfValidProduct());
	}

	@When("User enters Invalid product {string} into Search Box field")
	public void user_enters_invalid_product_into_search_box_field(String productName) {
		homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBox(productName);
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		Assert.assertEquals("There is no product that matches the search criteria.", searchResultPage.getMessageText());
	}

	@When("User donot enter any product name into Search Box field")
	public void user_donot_enter_any_product_name_into_search_box_field() {
		homePage = new HomePage(driver);
	}

}
