package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class homePage {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//button[contains(@class, 'slds-button slds-icon-waffle_')]")
	WebElement space_bar;
	
	@FindBy(xpath = "//p[contains(text(),'Service')]")
	WebElement service;
	
	@FindBy(xpath = "//one-app-nav-bar-item-root[@role='listitem']")
	public List<WebElement> tabs;
	
	@FindBy(xpath = "//div[contains(text(),'New')]")
	public List<WebElement> News;
	
	
	

	
	
	public homePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
public void getSpaceBar() {
		
		 space_bar.click();
	}

public void getService() {
	
	 service.click();
}


public List<WebElement> getTabs() {
	
	return tabs;
}

public List<WebElement> getNew() {
	
	return News;
}

}
