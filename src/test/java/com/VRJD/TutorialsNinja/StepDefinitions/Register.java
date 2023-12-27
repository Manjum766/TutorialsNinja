package com.VRJD.TutorialsNinja.StepDefinitions;

import java.util.Map;

import org.junit.Assert;
import com.VRJD.TutorialsNinja.PageObjects.AccountSuccessPage;
import com.VRJD.TutorialsNinja.PageObjects.HomePage;
import com.VRJD.TutorialsNinja.PageObjects.RegisterPage;
import com.VRJD.TutorialsNinja.TestBase.BaseClass;
import com.VRJD.TutorialsNinja.Utilities.CommonUtils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register extends BaseClass {

//	WebDriver driver;
	CommonUtils commonUtils;
	private RegisterPage registerPage;
	private HomePage homePage;
	private AccountSuccessPage accountSuccessPage;

	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
//		driver = DriverFactory.getDriver();
		setUp();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage = homePage.selectRegisterOption();
	}

	@When("User enters details into below fields")
	public void user_enters_details_into_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		registerPage.enterFirstName(dataMap.get("FirstName"));
		registerPage.enterLastName(dataMap.get("LastName"));
		commonUtils = new CommonUtils();
		registerPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
		registerPage.enterTelephone(dataMap.get("Telephone"));
		registerPage.enterPassword(dataMap.get("Password"));
		registerPage.enterConfirmPassword(dataMap.get("Password"));
	}

	@And("User selects the Privacy Policy")
	public void user_selects_the_privacy_policy() {
		registerPage.selectPrivacyPolicy();
	}

	@And("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		accountSuccessPage = registerPage.clickOnContinueButton();
	}

	@Then("User account should be created successfully")
	public void user_account_should_be_created_successfully() {
		Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getPageHeading());
	}

	@And("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		registerPage.selectYesNewsLetterOption();
	}

	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		registerPage.enterFirstName(dataMap.get("FirstName"));
		registerPage.enterLastName(dataMap.get("LastName"));
		registerPage.enterEmailAddress(dataMap.get("Email"));
		registerPage.enterTelephone(dataMap.get("Telephone"));
		registerPage.enterPassword(dataMap.get("Password"));
		registerPage.enterConfirmPassword(dataMap.get("Password"));
	}

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
		Assert.assertTrue(
				registerPage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
		registerPage.enterFirstName("");
		registerPage.enterLastName("");
		registerPage.enterEmailAddress("");
		registerPage.enterTelephone("");
		registerPage.enterPassword("");
		registerPage.enterConfirmPassword("");
	}

	@Then("User should get proper warning message for every mandatory field")
	public void user_should_get_proper_warning_message_for_every_mandatory_field() {
		Assert.assertTrue(
				registerPage.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!",
				registerPage.getFirstNameWarningMessageText());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",
				registerPage.getLastNameWarningMessageText());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.getEmailWarningMessageText());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",
				registerPage.getTelephoneWarningMessageText());
		Assert.assertEquals("Password must be between 4 and 20 characters!",
				registerPage.getPasswordWarningMessageText());
	}

}
