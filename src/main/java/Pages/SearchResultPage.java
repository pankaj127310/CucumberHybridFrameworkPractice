package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Commonutils;
import utils.ElementUtils;

public class SearchResultPage {

	WebDriver driver;
	private ElementUtils elementutils;
	
	public SearchResultPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils=new ElementUtils(driver);

	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement ValidProduct;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement warningmessageText;
	
	public boolean displaystatusOfvalidproduct()
	{
		return elementutils.displaystatusofelement(ValidProduct, Commonutils.EXPLICIT_WAIT_TIME);
	}
	
	public String GetWarningText()
	{
		return elementutils.gettextfromelement(warningmessageText, Commonutils.EXPLICIT_WAIT_TIME);
	}
}
