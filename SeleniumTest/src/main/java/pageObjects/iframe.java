package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class iframe {
	
	public WebDriver driver;
	
	public iframe(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(tagName = "iframe")
	public List<WebElement> iframes;
	
public List<WebElement> getIframes() {
		
		return iframes;
	}

}
