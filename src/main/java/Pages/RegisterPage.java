package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Commonutils;
import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elementutils;

	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils=new ElementUtils(driver);
	}
		
	@FindBy(id="input-firstname")
	private WebElement FirstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement LastNameField;
	
	@FindBy(id="input-email")
	private WebElement EmailField;
	
	@FindBy(id="input-telephone")
	private WebElement TelephoneField;
	
	@FindBy(id="input-password")
	private WebElement PasswordField;
	
	@FindBy(id="input-confirm")
	private WebElement ConfirmPasswordField;
	
	@FindBy(name="agree")
	private WebElement PrivacyPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement ContinueButton;
	
	@FindBy(xpath="//input[@name='newsletter' and @value='1']")
	private WebElement NewsLetter;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement WarningMessage;

	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstnamewarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastnamewarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailwarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephonewarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordwarning;
	
	
	public void EnterFirstName(String firstName)
	{
		elementutils.typeTextIntoElement(FirstNameField,firstName ,Commonutils.EXPLICIT_WAIT_TIME);
	}
	
	public void EnterLastName(String lastName)
	{
		elementutils.typeTextIntoElement(LastNameField,lastName ,Commonutils.EXPLICIT_WAIT_TIME);

	}
	
	public void EnterEmail(String email)
	{
		elementutils.typeTextIntoElement(EmailField,email ,Commonutils.EXPLICIT_WAIT_TIME);

	}
	
	public void EnterTelephone(String telephone)
	{
		elementutils.typeTextIntoElement(TelephoneField,telephone ,Commonutils.EXPLICIT_WAIT_TIME);		
	}
	
	public void EnterPassword(String password)
	{
		elementutils.typeTextIntoElement(PasswordField,password ,Commonutils.EXPLICIT_WAIT_TIME);		
	}
	
	public void ConfirmPassword(String password)
	{
		elementutils.typeTextIntoElement(ConfirmPasswordField,password ,Commonutils.EXPLICIT_WAIT_TIME);		
	}
	
	public void SelectPrivatePolicy()
	{
		elementutils.ClickOnElement(PrivacyPolicy, Commonutils.EXPLICIT_WAIT_TIME);

	}
	
	public AccountSuccesPage ClicksOnContinueButton()
	{
		elementutils.ClickOnElement(ContinueButton, Commonutils.EXPLICIT_WAIT_TIME);
		return new AccountSuccesPage(driver);
	}
	
	public void SelectNewsLetter()
	{
		elementutils.ClickOnElement(NewsLetter, Commonutils.EXPLICIT_WAIT_TIME);
	}
	public String getwarningmessage()
	{
		return elementutils.gettextfromelement(WarningMessage, Commonutils.EXPLICIT_WAIT_TIME);
	}
	
	public String getFirstnamewarning()
	{
		return elementutils.gettextfromelement(firstnamewarning, Commonutils.EXPLICIT_WAIT_TIME);
	}
	public String getLastnamewarning()
	{
		return elementutils.gettextfromelement(lastnamewarning, Commonutils.EXPLICIT_WAIT_TIME);
	}
	public String getemailwarning()
	{
		return elementutils.gettextfromelement(emailwarning, Commonutils.EXPLICIT_WAIT_TIME);

	}
	public String gettelephonewarning()
	{
		return elementutils.gettextfromelement(telephonewarning, Commonutils.EXPLICIT_WAIT_TIME);
	}
	public String getpasswordwarning()
	{
		return elementutils.gettextfromelement(passwordwarning, Commonutils.EXPLICIT_WAIT_TIME);
	}
}
