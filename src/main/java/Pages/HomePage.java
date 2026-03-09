package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Commonutils;
import utils.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	private ElementUtils elementutils;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils=new ElementUtils(driver);
	}

	@FindBy(xpath="//span[text()='My Account']")//<--pagefactory given by selenium to support POM Design pattern
	private WebElement myAccountDropMenu;
	
	
	@FindBy(linkText="Login")//<--pagefactory given by selenium to support POM Design pattern
	private WebElement LoginOption;
	
	@FindBy(linkText="Register")
	private WebElement RegisterOption;
	
	@FindBy(name="search")
	private WebElement SearchBoxField;
	
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement SearchButton;
	
	public SearchResultPage ClickOnSearchButton()
	{
		elementutils.ClickOnElement(SearchButton, Commonutils.EXPLICIT_WAIT_TIME);
		return new SearchResultPage(driver);
	}
	
	public void enterProductIntoSearchBox(String ProductName)
	{
		elementutils.typeTextIntoElement(SearchBoxField,ProductName ,Commonutils.EXPLICIT_WAIT_TIME);

	}
	
	public void clickOnMyAccount()
	{
		
		elementutils.ClickOnElement(myAccountDropMenu, Commonutils.EXPLICIT_WAIT_TIME);
	}
	
	public LoginPage SelectLoginOption()
	{
		elementutils.ClickOnElement(LoginOption, Commonutils.EXPLICIT_WAIT_TIME);
		return new LoginPage(driver);
	}
	
	public RegisterPage ClickOnRegister()
	{
		
		elementutils.ClickOnElement(RegisterOption, Commonutils.EXPLICIT_WAIT_TIME);
		return new RegisterPage(driver);
	}
}
