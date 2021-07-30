package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPage {
	
	public WebDriver driver;
	
	@FindBy(css = "#username")
	WebElement username;
	
	@FindBy(css = "#password")
	WebElement password;
	
	@FindBy(css = "#Login")
	WebElement Login;
	
	
	String name = "mconti2908@tcs.com";
	String pass = "@MauCon2908";
	
	public landingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
public void getUsername() {
		
		 username.sendKeys(name);
	}
	
public void getPassword() {
		
		password.sendKeys(pass);
	}

	public void getLogin() {
		
		 Login.click();
	}
	
  

}
