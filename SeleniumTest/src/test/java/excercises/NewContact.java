package excercises;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AccountObjects;
import pageObjects.ContactObjects;
import pageObjects.homePage;
import pageObjects.landingPage;
import pageObjects.tabs;
import resources.base;

public class NewContact extends base {
	
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(url());
		logIn();
	}
	
	@Test
	public void Contact() throws InterruptedException {
		
		homePage hp = new homePage(driver);
		tabs tabs = new tabs(driver);
		AccountObjects ao=new AccountObjects(driver);
		ContactObjects co = new ContactObjects(driver);
		

		hp.getSpaceBar();
		hp.getService();
		
		tabs.ContactLink.sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
		
		Set<String> windows = driver.getWindowHandles(); 

		Iterator<String> it = windows.iterator();

		String parentId = it.next();

		String childId = it.next();

		driver.switchTo().window(childId);
		
		co.clickNew();
		
		co.clickItem(co.salutation);
	
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		 js.executeScript("arguments[0].click();", co.SelectSalutation());
	
		
		co.WriteItem(co.LastName, "Conti");
		
		co.AccountName.sendKeys("jorge");
		co.Account.click();
		
		
		
		
		ao.clickSandN();
		
		Thread.sleep(3000);
		co.ClickCancel();
		
		driver.switchTo().window(parentId);
		
		
		
		
	}
	
	@AfterTest
	public void finish()  {
		
		
		driver.quit();
	}

}
