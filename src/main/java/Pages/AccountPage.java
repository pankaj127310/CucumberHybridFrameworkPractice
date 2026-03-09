package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Commonutils;
import utils.ElementUtils;

public class AccountPage {

	WebDriver driver;
	private ElementUtils elementutils;

	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils=new ElementUtils(driver);

	}
	
	@FindBy(linkText="Edit your account information")
	private WebElement Edityouraccountinformation;
	
	public boolean DisplayStatusEditYourAccountInformation()
	{
		return elementutils.displaystatusofelement(Edityouraccountinformation,Commonutils.EXPLICIT_WAIT_TIME);
		
	}
}
