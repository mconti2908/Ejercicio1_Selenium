package MauroC.SeleniumTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AccountObjects;
import pageObjects.homePage;
import pageObjects.landingPage;
import pageObjects.tabs;
import resources.base;

public class AccountEdit extends base{
	

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(url());
		logIn();
	}
	
	
	@Test
	public void editAccount() throws InterruptedException {
		
		
		homePage hp = new homePage(driver);
		tabs tabs = new tabs(driver);
		AccountObjects ao=new AccountObjects(driver);

		hp.getSpaceBar();
		hp.getService();
			
			
	tabs.getServiceTab(tabs.Account);
	
	ao.clickArrow();
	
	ao.clickEdit();
	
	ao.enterObject(ao.Type);
	ao.SelectObject("Installation Partner").click();
	
	ao.enterObject(ao.Rating);
	 ao.SelectItem("Rating", "Hot");
	 
	 ao.Uoportunity();
	 ao.SelectItem("Upsell Opportunity", "No");
	    
		
     ao.clickSave();
     
     Thread.sleep(6000);
     
     
     ao.clickArrow();
 	
 	ao.clickEdit();
     
 	ao.enterObject(ao.Rating); 
 	Assert.assertTrue(ao.ItemSelected("Rating", "Hot"), "le errast pibe");
 	
 	ao.enterObject(ao.Type);
 	Assert.assertTrue(ao.ItemSelected("Type", "Installation Partner"), "le errast pibe");
 	
 	ao.Uoportunity();
 	Assert.assertTrue(ao.ItemSelected("Upsell Opportunity", "No"), "le errast pibe");	
 	
 	ao.NumberOfEmployees().clear();
 	ao.NumberOfEmployees().sendKeys("1431655766");
 	ao.clickSave();
 	Assert.assertEquals(ao.returnMessage(ao.Message), ao.Employee_Alert);
 	
 	
		
	}
	
	@AfterTest
	public void finish()  {
		
		
		driver.close();
	}
	
	
	

}
