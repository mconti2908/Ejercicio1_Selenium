package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountObjects<fecha> {
	public WebDriver driver;

	@FindBy(xpath="//div[contains(text(),'New')]")
	public List<WebElement> NewsText;
	
	@FindBy(xpath="//div[text()='New']/ancestor::a")
	public WebElement ButtonNew;
	
	@FindBy(xpath="//label[contains(text(),'Rating')]/following-sibling::div/lightning-base-combobox/div/div/input")
	public WebElement Rating;
	
	@FindBy(xpath="//label[contains(text(),'Type')]/following-sibling::div/lightning-base-combobox/div/div/input")
	public WebElement Type;
	
	@FindBy(xpath="//lightning-base-combobox-item[@role='option']")
	public List<WebElement> RatingList;
	
	@FindBy(xpath="//input[@name='Name']")
	public WebElement Name;
	
	@FindBy(xpath="//input[@name='Phone']")
	public WebElement Phone;
	
	@FindBy(xpath="//input[@name='Fax']")
	public WebElement Fax;
	
	@FindBy(xpath="//input[@name='AccountNumber']")
	public WebElement AccountNumber;
	
	@FindBy(xpath="//input[@name='Website']")
	public WebElement Website;
	
	@FindBy(xpath="//input[@name='Site']")
	public WebElement Site;
	
	@FindBy(xpath="//input[@name='TickerSymbol']")
	public WebElement TickerSymbol;
	
	@FindBy(xpath= "//input[@name='NumberOfEmployees']")
	public WebElement NofEmployees;
	
	@FindBy(xpath= "//input[@name='AnnualRevenue']")
	public WebElement AnualRevenue;
	
	@FindBy(xpath= "//input[@name='Sic']")
	public WebElement sic;
	
	@FindBy(xpath = "//button[@name='SaveAndNew']")
	private WebElement SAN;
	
	@FindBy(xpath = "//div[@class='slds-select_container']/select")
	private WebElement SelYear;
	
	@FindBy(xpath = "//input[@name='SLAExpirationDate__c']")
	private WebElement Calendar;
	
	@FindBy(xpath = "//h2[@data-index]")
	private WebElement Month;
	
	@FindBy(xpath = "//button[@title='Next Month']")
	private WebElement nextMonth;
	
	@FindBy(xpath =  "//div[text()='Complete this field.']")
	WebElement alertaa;
	
	@FindBy(xpath =  "//a[@role='button']/span/span")
	WebElement arrow;
	
	@FindBy(xpath =  "//a[@title='Edit']")
	WebElement Edit;
	
	@FindBy(xpath =  "//button[@name='SaveEdit']")
	WebElement Save;
	
	@FindBy(xpath = "//div[text()='Employees: value outside of valid range on numeric field: 1431655766']")
	public WebElement Message;
	
	@FindBy(xpath = "//li[text()='Number out of range: 81431655766']")
	public WebElement Snag;
	
	

	public String Employee_Alert = "Employees: value outside of valid range on numeric field: 1431655766";
	
	public String Employee_Alert_Snag = "Number out of range: 1431655766";
	
	public AccountObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
public List<WebElement> CountNewsText() {
		
		return NewsText;
	}

public void getNewButton() {
	
	 ButtonNew.click();;
}

public WebElement getRatingClick() {
	
	return Rating;
}

public List<WebElement> getRatingList() {
	
	return RatingList;
}

public WebElement getName() {
	
	return Name;
}

public WebElement getPhone() {
	
	return Phone;
}

public WebElement getFax() {
	
	return Fax;
}

public WebElement getAccountNumber() {
	
	return AccountNumber;
}

public WebElement getWebsite() {
	
	return Website;
}

public WebElement getSite() {
	
	return Site;
}

public WebElement getTickerSymbol() {
	
	return TickerSymbol;
}
	
	public void getObject(String h) {
		 driver.findElement(By.xpath("//label[contains(text(),'"+ h + "')]/following-sibling::div/lightning-base-combobox/div/div/input")).click();
		
	}
	
	public WebElement SelectObject(String h) {
		 return driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='"+h+"']"));
		}
	
	
	public void CompleteDir(String h, String s) {
		  driver.findElement(By.xpath("//label[contains(text(),'" + h + "')]/following-sibling::div/textarea")).sendKeys(s) ;
		}
	
	public void CompleteInfo(String h, String s) {
		  driver.findElement(By.xpath("//label[contains(text(),'" + h + "')]/following-sibling::div/input")).sendKeys(s) ;
		}
	
	public WebElement NumberOfEmployees() {
		 return NofEmployees;
		}
	
	public WebElement AnualRevenue() {
		 return AnualRevenue;
		}
	
	public WebElement sic() {
		 return sic;
		}
	
	public void comboboxClick(String s) {
		driver.findElement(By.xpath("//label[contains(text(),'"+s+"')]/following-sibling::div/lightning-base-combobox/div/div/input")).click();
	}
	
	public void comboboxSelect(String s) {
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='"+s+"']")).click();
	}
	
	public void Uoportunity() {
	
	
	String pathElement ="//label[.='Upsell Opportunity'] ";
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath(pathElement)));
	
	
	
	
	String combbopth = "//label[.='Upsell Opportunity'] /following-sibling::div //lightning-base-combobox";
	driver.findElement(By.xpath(combbopth)).click();}
	
	public void Active() {
		
		
		String pathElement ="//label[.='Active'] ";
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath(pathElement)));
		
		
		
		
		String combbopth = "//label[.='Active'] /following-sibling::div //lightning-base-combobox";
		driver.findElement(By.xpath(combbopth)).click();}
	
	public void SelectItem(String b, String c) {
	
	driver.findElement(By.xpath("//label[contains(text(),'"+b+"')]/following-sibling::div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[@data-value='"+c+"']")).click();
	}
	
	public boolean ItemSelected(String b, String c) {
		
		return driver.findElement(By.xpath("//label[contains(text(),'"+b+"')]/following-sibling::div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[@data-value='"+c+"']/span/lightning-icon")).isDisplayed();
		}
	
	public void selectCal(String month, String year, String Day, String Mnumber) {
		
		Calendar.click();
		Select sel=new Select(SelYear);
		String date = year+"-"+Mnumber+"-"+Day;
		
		while(!Month.getText().equalsIgnoreCase(month)) {
			nextMonth.click();
		}
		sel.selectByValue(year);
		driver.findElement(By.xpath("//td[@data-value='"+ date +"']")).click();
	}
	
	
	
	public void clickSandN() {
		SAN.click();
		
		
	}
	
	public WebElement aleeert() {
		return alertaa;
		
		
	}
	
	public void clickArrow() {
		arrow.click();
	}
	
	public void clickEdit() {
		Edit.click();
	}
	
	public void clickSave() {
		Save.click();
	}
	
	public void enterObject(WebElement we) {
		we.sendKeys(Keys.ENTER);
	}
	
	public String returnMessage(WebElement we){
		return we.getText();
	}
	
	
	
	
	
}
