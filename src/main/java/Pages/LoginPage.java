package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Commonutils;
import utils.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	private ElementUtils elementutils;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils=new ElementUtils(driver);
	}

	@FindBy(id="input-email")//<--pagefactory given by selenium to support POM Design pattern
	private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement LoginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement WarningMsg;
	
	
	public void EnterEmailAddress(String emailText)
	{
		elementutils.typeTextIntoElement(emailField,emailText ,Commonutils.EXPLICIT_WAIT_TIME);

	}
	

	public void EnterPassword(String EnterValidPassword)
	{
		elementutils.typeTextIntoElement(passwordField,EnterValidPassword ,Commonutils.EXPLICIT_WAIT_TIME);

	}
	
	public AccountPage ClickOnLoginButton()
	{
		elementutils.ClickOnElement(LoginButton, Commonutils.EXPLICIT_WAIT_TIME);
		return new AccountPage(driver);
	}
	
	public String GetWarningmessage()
	{
		return elementutils.gettextfromelement(WarningMsg, Commonutils.EXPLICIT_WAIT_TIME);
	}
}
