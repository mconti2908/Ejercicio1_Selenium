package pageObjects;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class tabs {
	public WebDriver driver;
	
	
	@FindBy(xpath = "//div[@title='New Dashboard']")
	public List<WebElement> Dashboards;
	
	@FindBy(xpath= "//div[@title='New Dashboard']/ancestor::a")
	WebElement Dashboard;
	
	@FindBy(xpath = "//div[text()='New Report']")
	public List<WebElement> Reports;
	
	@FindBy(xpath= "//div[text()='New Report']/ancestor::a")
	WebElement Report;
	
	@FindBy(xpath= "//div[text()='New']/ancestor::a")
	WebElement New;
	
	@FindBy(xpath= "//button[contains(text(),'Cancel')]")
	WebElement CancelButton;
	
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	public List<WebElement> Cancells;
	
	@FindBy(xpath= "//button[contains(@title,'Cancel')]")
	WebElement CancelledButton;
	
	@FindBy(xpath = "//button[contains(@title,'Cancel')]")
	public List<WebElement> CancellsTitle;
	
	@FindBy(xpath= "//*[@data-id='Account']")
	public WebElement Account;
	
	@FindBy(xpath = "//a[@title='Accounts']")
	public List<WebElement> AccountsCount;
	
	@FindBy(xpath= "//*[@data-id='Contact']")
	public WebElement Contact;
	
	@FindBy(xpath= "//*[@data-id='Contact']/a")
	public WebElement ContactLink;
	
	

	
	
	public tabs(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public List<WebElement> getDashboards() {
		
		return Dashboards;
	}
	
	public WebElement getDashboard(){
		
		return Dashboard;
	}
	
	
public List<WebElement> getReports() {
		
		return Reports;
	}
	
	public WebElement getReport(){
		
		return Report;
	}
	
public void getNew(){
		
		 New.click();
	}

public WebElement getCancel(){
	
	return CancelButton;
}

public List<WebElement> CountCancells() {
	
	return Cancells;
}

public WebElement getCancelledButton(){
	
	return CancelledButton;
}

public List<WebElement> CountCancellsTitle() {
	
	return CancellsTitle;
}


public void getServiceTab(WebElement we){
	
	 we.click();
}

String chords = "Keys.chord(Keys.CONTROL,Keys.ENTER)";
public void clickServiceTab(WebElement we){
	
	we.sendKeys(chords);
	
	 
}





}
