package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Pagebase {


	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement SearchTxt;
	
	@FindBy(xpath = "//button[@id='search-icon-legacy']")
	private WebElement SearchBTN;
	

	public void searchvideo(String Title)
	{
		clearText(SearchTxt);
		setTextElementText(SearchTxt, Title);
		clickButton(SearchBTN);
	}

}
