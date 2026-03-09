package stepdefination;

//import org.junit.Assert.*;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Assert;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Driver_factory.DriverFactory;
import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Commonutils;


public class Login {

	WebDriver driver;
	private LoginPage loginpage;
	private AccountPage accountpage;
	private Commonutils Comutils;
	
	
	@Given("User navigates to Login page.")
	public void user_navigates_to_login_page() {
		driver=DriverFactory.getDriver();
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMyAccount();
		loginpage=homepage.SelectLoginOption();
	}

	@When("^User enteres valid email address (.+) into the email field$")
	public void User_enteres_valid_email_into_email_address_field(String emailtext)
	{
		loginpage.EnterEmailAddress(emailtext);
	}

	@And("^User has entered Valid Password (.+) into the password$")
	public void user_has_entered_valid_password_into_the_password(String passwordText) {
		loginpage.EnterPassword(passwordText);
	}

	@When("User Clicks on Login Button")
	public void user_clicks_on_login_button() {

		accountpage=loginpage.ClickOnLoginButton();
	}

	@Then("User should get login successfully")
	public void user_should_get_login_successfully() {

		Assert.assertTrue(accountpage.DisplayStatusEditYourAccountInformation());
		
	}

	@When("User enteres Invalid email address into the email field")
	public void user_enteres_invalid_email_address_into_the_email_field() {
		Comutils =new Commonutils();
	    loginpage.EnterEmailAddress(Comutils.GetEmailTimeStamp());
	}

	@When("User has entered InValid Password {string} into the password")
	public void user_has_entered_in_valid_password_into_the_password(String InvalidPassword) {

		loginpage.EnterPassword(InvalidPassword);
	}

	@Then("User should get proper warning message for credential mismatch.")
	public void user_should_get_proper_warning_message_for_credential_mismatch() {

		Assert.assertTrue(loginpage.GetWarningmessage().contains("Warning: No match for E-Mail Address and/or Password."));
	}
}
