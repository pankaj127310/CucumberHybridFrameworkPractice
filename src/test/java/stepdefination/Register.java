package stepdefination;

import java.util.Date;
import java.util.Map;
import static org.junit.Assert.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Driver_factory.DriverFactory;
import Pages.AccountSuccesPage;
import Pages.HomePage;
import Pages.RegisterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Commonutils;
//import junit.framework.Assert.*;


public class Register {

	WebDriver driver;
	private RegisterPage registerpage;
	private AccountSuccesPage accountsuccespage;
	private Commonutils Comutils;

	@Given("User navigates to Register Account page.")
	public void user_navigates_to_register_account_page() {
		driver=DriverFactory.getDriver();
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMyAccount();
		registerpage=homepage.ClickOnRegister();
	}

	@When("User enters the details into the below fields")
	public void user_enters_the_details_into_the_below_fields(DataTable dataTable) {
		Map<String, String> datamap = dataTable.asMap(String.class,String.class);
		Comutils =new Commonutils();
		registerpage.EnterFirstName(datamap.get("firstName"));
		registerpage.EnterLastName(datamap.get("lastName"));
		registerpage.EnterEmail(Comutils.GetEmailTimeStamp());
		registerpage.EnterTelephone(datamap.get("telephone"));
		registerpage.EnterPassword(datamap.get("password"));
		registerpage.ConfirmPassword(datamap.get("password"));
	}
	
	@When("User enters the details into the below fields with duplicate email")
	public void user_enters_the_details_into_the_below_fields_with_duplicate_email(DataTable dataTable) {
		Map<String, String> datamap = dataTable.asMap(String.class,String.class);

		registerpage.EnterFirstName(datamap.get("firstName"));
		registerpage.EnterLastName(datamap.get("lastName"));
		registerpage.EnterEmail(datamap.get("email"));
		registerpage.EnterTelephone(datamap.get("telephone"));
		registerpage.EnterPassword(datamap.get("password"));
		registerpage.ConfirmPassword(datamap.get("password"));

	}

	@When("User selects Privacy policy")
	public void user_selects_privacy_policy() {
		
		registerpage.SelectPrivatePolicy();
			
	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		accountsuccespage=registerpage.ClicksOnContinueButton();
	}

	@Then("User Account should get created successfully.")
	public void user_account_should_get_created_successfully() {
		
	    assertEquals("Your Account Has Been Created!", accountsuccespage.getPageHeading());
	}

	@When("User selects Yes for NewsLetter")
	public void user_selects_yes_for_news_letter() {

		registerpage.SelectNewsLetter();
	}

	@Then("User should get proper warning about duplicate email.")
	public void user_should_get_proper_warning_about_duplicate_email() {

		Assert.assertTrue(registerpage.getwarningmessage().contains("Warning: E-Mail Address is already registered!"));
	}
	
	

	@When("User enters dont the details into the below fields.")
	public void user_enters_dont_the_details_into_the_below_fields() {
		

		registerpage.EnterFirstName("");
		registerpage.EnterLastName("");
		registerpage.EnterEmail("");
		registerpage.EnterTelephone("");
		registerpage.EnterPassword("");
		registerpage.ConfirmPassword(""); 
	}

	@Then("User should get proper warning.")
	public void user_should_get_proper_warning() {
		
		Assert.assertTrue(registerpage.getwarningmessage().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerpage.getFirstnamewarning());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerpage.getLastnamewarning());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerpage.getemailwarning());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerpage.gettelephonewarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerpage.getpasswordwarning());

	}
}
