package Tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class Testbase {

	public static WebDriver  driver;
	
	@BeforeTest
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName) 
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		  driver= new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.navigate().to("https://www.youtube.com/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void stopDriver() 
	{
		driver.quit();
	}

	@AfterMethod
	public void screenshotOnFailure(ITestResult result) 
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");
			Utilities.Helper.captureScreenshot(driver, result.getName());
		}
	}
}
