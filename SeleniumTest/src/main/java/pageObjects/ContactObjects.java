package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactObjects {
 WebDriver driver;
	public ContactObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@title='New']")
	WebElement New;
	
	@FindBy(xpath="//input[@name='salutation']")
	public WebElement salutation;
	
	@FindBy(xpath="//input[@name='lastName']")
	public WebElement LastName;
	
	@FindBy(xpath = "//button[@name='CancelEdit']")
	private WebElement Cancel;
	
	@FindBy(xpath = "//label[contains(text(),'Salutation')]/following-sibling::div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[@data-value='Mr.']")
	private WebElement Mr;
	
	@FindBy(xpath = "//label[contains(text(),'Account Name')]/following-sibling::div/div/lightning-base-combobox/div/div/input")
	public WebElement AccountName;
	
	@FindBy(xpath = "//strong[contains(text(),'Jorge')]")
	public WebElement Account;
	
	
	
	public void clickNew() {
	
	New.click();	
	}
	
	public void clickItem(WebElement we) throws InterruptedException {
		we.click();
		Thread.sleep(2000);
	}
	
	public WebElement SelectSalutation() {
		return Mr;
		}
	
	
	public void WriteItem(WebElement we, String S) {
		we.click();
		we.sendKeys(S);
	}
	
	public void ClickCancel() {
		Cancel.click();
	}
}
