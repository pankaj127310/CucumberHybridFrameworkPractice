package utils;

import java.time.Duration;
import java.util.function.Function;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	private static final Function ExpectedCondtion = null;
	WebDriver driver;

	public ElementUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement waitforelement(WebElement element,long durationInSeconds)
	{
		WebElement WebElement = null;
		try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		WebElement= wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		return WebElement;
	}

	public void ClickOnElement(WebElement element, long durationInSeconds)
	{
	 WebElement Webelement=waitforelement(element,durationInSeconds);
	 Webelement.click();
	}
	
	public void typeTextIntoElement(WebElement element,String TestTobeType,long durationInSeconds)
	{
		
	 WebElement Webelement=waitforelement(element,durationInSeconds);
	 Webelement.click();
	 Webelement.clear();
	 Webelement.sendKeys(TestTobeType);
	}
	
	public void selectOptionInDropDown(WebElement element, String DropDownOption,long durationInSeconds)
	{
		WebElement Webelement=waitforelement(element,durationInSeconds);
		Select select=new Select(element);
		select.selectByVisibleText(DropDownOption);
	}
	
	public Alert waitforAlert(long durationInSeconds)
	{
		@Nullable
		Alert alert=null;
		try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		 alert = wait.until(ExpectedConditions.alertIsPresent());
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		return alert;
	}
	
	public void acceptAlert(long durationInSeconds)
	{
		Alert alert=waitforAlert(durationInSeconds);
		alert.accept();
	}
	
	public void DismissAlert(long durationInSeconds)
	{
		Alert alert=waitforAlert(durationInSeconds);
		alert.dismiss();
	}
	
	public WebElement waitforvisiblilityofelement(WebElement element,long durationInSeconds)
	{
		WebElement WebElement=null;
		try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		WebElement=wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		return WebElement;
	}
	
	public void mousehowerandclick(WebElement element,long durationInSeconds)
	{
		
		WebElement WebElement=waitforvisiblilityofelement(element,durationInSeconds);
		Actions act=new Actions(driver);
		act.moveToElement(WebElement).click().build().perform();
	}

	public void javascriptClick(WebElement element,long durationInSeconds)
	
	{
		WebElement webelement=waitforvisiblilityofelement(element,durationInSeconds);
		JavascriptExecutor je= ((JavascriptExecutor)driver);
		je.executeScript("arguments[0].click()", webelement);
		
	}
	
	public void javascriptType(WebElement element,String Texttobetype,long durationInSeconds)
	{
		WebElement webelement=waitforvisiblilityofelement(element,durationInSeconds);
		JavascriptExecutor je= ((JavascriptExecutor)driver);
		je.executeScript("arguments[0].value='"+Texttobetype+"'", webelement);
	}
	
	public String gettextfromelement(WebElement element,long durationInSeconds)
	{
		WebElement WebElement=waitforvisiblilityofelement(element,durationInSeconds);
		return WebElement.getText();
	}
	
	public boolean displaystatusofelement(WebElement element,long durationInSeconds)
	{
		try {
		WebElement WebElement=waitforvisiblilityofelement(element,durationInSeconds);
		return WebElement.isDisplayed();
		}catch(Throwable e)
		{
			return false;
		}
	}
}
