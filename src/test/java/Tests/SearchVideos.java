package Tests;


import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import Pages.FilterPage;
import Pages.HomePage;
import Pages.VideoPage;

public class SearchVideos extends Testbase
{
	HomePage  HPObject;
	FilterPage  FPObject;
	VideoPage  VPObject;

	CSVReader reader;
	
	
	@Test
	public void UserCanaSearchfor3rdvideo() throws  IOException, Exception 
	{
		String csvfile = System.getProperty("user.dir")+"/src/test/java/Data/VideoTitles.csv";
		reader = new CSVReader(new FileReader(csvfile));
		String[] SearchTitles;
		while((SearchTitles = reader.readNext()) != null)
		{
			HPObject= new HomePage(driver);
			String SearchTitle = SearchTitles[0];
			HPObject.searchvideo(SearchTitle);
			FPObject= new FilterPage(driver);
			FPObject.FilterByVideo();
			String ActualTitle = FPObject.getVideoTitlebyindex(2);
			FPObject.ClickVideo(2);
			VPObject= new VideoPage(driver);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String  ExpectedTitle= VPObject.getVideoTitle();
			System.out.println(ExpectedTitle);
			Assert.assertEquals(ActualTitle, ExpectedTitle);
		}
	}
	
	@Test
	public void UserCanaSearchfor10thvideo()
	{
			HPObject= new HomePage(driver);
			HPObject.searchvideo("Selenium Tutorial");
			FPObject= new FilterPage(driver);
			FPObject.FilterByVideo();
			String ActualTitle = FPObject.getVideoTitlebyindex(9);
			FPObject.ClickVideo(9);
			VPObject= new VideoPage(driver);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String  ExpectedTitle= VPObject.getVideoTitle();
			System.out.println(ExpectedTitle);
			Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
}
