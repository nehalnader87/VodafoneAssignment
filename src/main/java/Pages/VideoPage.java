package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VideoPage extends Pagebase{

	public VideoPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
		super(driver);		
	}
	
	@FindBy(xpath="//*[@id=\"container\"]/h1/yt-formatted-string")
	WebElement VideoTitle;
	
	public String getVideoTitle()
	{
		String Title= VideoTitle.getText();
		System.out.println(Title);
		return Title;
	}

}
