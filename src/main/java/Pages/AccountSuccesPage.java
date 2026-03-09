package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Commonutils;
import utils.ElementUtils;

public class AccountSuccesPage {

	WebDriver driver;
	
	private ElementUtils elementutils;

	public AccountSuccesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils=new ElementUtils(driver);

	}
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement pagehandling;
	
	public String getPageHeading()
	{
	  /*  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement heading = wait.until(
	            ExpectedConditions.refreshed(
	                    ExpectedConditions.visibilityOf(pagehandling)));
	*/
		return elementutils.gettextfromelement(pagehandling, Commonutils.EXPLICIT_WAIT_TIME);
	
	}
}
