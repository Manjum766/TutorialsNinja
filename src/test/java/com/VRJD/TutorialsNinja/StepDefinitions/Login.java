package com.VRJD.TutorialsNinja.StepDefinitions;

import org.junit.Assert;
import com.VRJD.TutorialsNinja.PageObjects.AccountPage;
import com.VRJD.TutorialsNinja.PageObjects.HomePage;
import com.VRJD.TutorialsNinja.PageObjects.LoginPage;
import com.VRJD.TutorialsNinja.TestBase.BaseClass;
import com.VRJD.TutorialsNinja.Utilities.CommonUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends BaseClass {

	private CommonUtils commonUtils;
	private LoginPage loginPage;
	private AccountPage accountPage;

	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		setUp();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.selectLoginOption();
	}

	@When("User enters valid email address {string} into email field")
	public void user_enters_valid_email_address_into_email_field(String emailAddress) {
		loginPage.enterEmailAddress(emailAddress);
	}

	@And("User enters valid password {string} into password field")
	public void user_enters_password_into_password_field(String password) {
		commonUtils = new CommonUtils();
		loginPage.enterPassword(commonUtils.decodeBase64Value(password));
	}

	@When("^User enters email address (.+) into email field$")
	public void user_enters_email_address_into_email_field(String emailAddress) {
		loginPage.enterEmailAddress(emailAddress);
	}

	@And("^User enters password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String password) {
		loginPage.enterPassword(password);
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		accountPage = loginPage.clickOnLoginButton();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformation());
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		commonUtils = new CommonUtils();
		loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String password) {
		loginPage.enterPassword(password);
	}

	@Then("User should get proper warning message about credentials mismatch")
	public void user_should_get_proper_warning_message_about_credentials_mismatch() {
		Assert.assertTrue(
				loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User donot enter email address into email field")
	public void user_donot_enter_email_address_into_email_field() {
		loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress("");
	}

	@When("User donot enter password into password field")
	public void user_donot_enter_password_into_password_field() {
		loginPage.enterPassword("");
	}

}
