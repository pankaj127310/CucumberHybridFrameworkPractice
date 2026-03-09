package Driver_factory;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.Commonutils;
import utils.ConfigReader;

public class DriverFactory {

	static WebDriver driver = null;
	public static WebDriver initializeBrowser(String BrowserName)
	{

		if(BrowserName.equals("chrome"))
		{
			  driver=new ChromeDriver();
		}else
			if(BrowserName.equals("Edge"))
			{
				  driver=new EdgeDriver();
			}else
				if(BrowserName.equals("FireFox"))
				{
					  driver=new FirefoxDriver();
				}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Commonutils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Commonutils.IMPLICIT_WAIT_TIME));
		
		return driver;
	}
	public static WebDriver getDriver()
	{
		return driver;
	}
}
