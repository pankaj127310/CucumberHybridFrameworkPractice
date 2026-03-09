package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Driver_factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class Myhooks {

	WebDriver driver;
	private ConfigReader Configreader;
	
	@Before
	public void setup()
	{
		Properties prop= new ConfigReader().initializeProperties();
		driver=DriverFactory.initializeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));

	}

	@After
	public void tearDown(Scenario scenario)
	{
		
		String ScenarioName=scenario.getName().replaceAll(" ", "_");
		
		if(scenario.isFailed())
		{
			byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot, "image/png", ScenarioName);
		}
		driver.quit();
	}

}
