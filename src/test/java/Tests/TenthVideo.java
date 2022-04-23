package Tests;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import Pages.FilterPage;
import Pages.HomePage;
import Pages.VideoPage;


public class TenthVideo  extends Testbase {
	HomePage  HPObject;
	FilterPage  FPObject;
	VideoPage  VPObject;
	
	CSVReader reader;
	
	
	@Test
	public void UserCanaSearchforvideo()
	{
			HPObject= new HomePage(driver);
			HPObject.searchvideo("Selenium Tutorial");
			FPObject= new FilterPage(driver);
			FPObject.FilterByVideo();
			String ActualTitle = FPObject.getVideoTitlebyindex(9);
			String Url= FPObject.ClickVideo(9);
			VPObject= new VideoPage(driver);
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			System.out.println(Url);
			//String  ExpectedTitle= VPObject.getVideoTitle();
			System.out.println(ActualTitle);
			//System.out.println(ExpectedTitle);
			//Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

}
