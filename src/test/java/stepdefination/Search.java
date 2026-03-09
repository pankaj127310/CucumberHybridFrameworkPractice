package stepdefination;

//import org.junit.Assert.*;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Driver_factory.DriverFactory;
import Pages.HomePage;
import Pages.SearchResultPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Search {

	WebDriver driver;
	
	private HomePage homepage;
	private SearchResultPage searchresult;
	
	@Given("User opens the application.")
	public void user_opens_the_application() {

		driver= DriverFactory.getDriver();

	}

	@When("User enteres valid product {string} into searchbox field")
	public void user_enteres_valid_product_into_searchbox_field(String ProductName) {

		homepage=new HomePage(driver);
		homepage.enterProductIntoSearchBox(ProductName);
	}

	@When("User clicks on search button.")
	public void user_clicks_on_search_button() {
		
		searchresult=homepage.ClickOnSearchButton();
	}

	@Then("User should get valid product displayed in searchbox results")
	public void user_should_get_valid_product_displayed_in_searchbox_results() {
		
		Assert.assertTrue(searchresult.displaystatusOfvalidproduct());
	Assert.fail(); //intentiannly failed for taking screen shot of failed scenario
	}

	@When("User enteres Invalid product {string} into searchbox field")
	public void user_enteres_invalid_product_into_searchbox_field(String InvalidProductName) {

		homepage=new HomePage(driver);
		homepage.enterProductIntoSearchBox(InvalidProductName);
	}

	@Then("User should get a message about no product matching.")
	public void user_should_get_a_message_about_no_product_matching() {
		
		
		Assert.assertEquals("There is no product that matches the search criteria.",searchresult.GetWarningText());
	}

	@When("User dont enteres any product name into searchbox field")
	public void user_dont_enteres_any_product_name_into_searchbox_field() {
		homepage=new HomePage(driver);
		homepage.ClickOnSearchButton();
	}

} 
