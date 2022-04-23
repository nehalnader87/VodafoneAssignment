package Pages;

import java.util.List;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FilterPage extends Pagebase {

	public FilterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//tp-yt-paper-button[@aria-label='Search filters']")
	private WebElement Filter;
	
	@FindBy(xpath = "//yt-formatted-string[contains(text(),'Video')]")
	private WebElement VideoFilter;
	
	@FindBy(xpath="//a[@id='video-title']")
	List<WebElement>  Videos ;

	public void FilterByVideo()
	{
		clickButton(Filter);
		clickButton(VideoFilter);
	}
	
	public String getVideoTitlebyindex(int index)
	{
		String title = Videos.get(index).getAttribute("title");
		System.out.println(title);
		return title;
	}
	
	public void ClickVideo(int index)
	{
		clickButton(Videos.get(index));
	}

}
