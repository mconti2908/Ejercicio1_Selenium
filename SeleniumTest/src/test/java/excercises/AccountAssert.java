package excercises;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AccountObjects;
import pageObjects.homePage;
import pageObjects.landingPage;
import pageObjects.tabs;
import resources.base;

public class AccountAssert extends base {
	
	

	@BeforeTest
	public void initialize() throws IOException  {
		driver = initializeDriver();
		driver.get(url());
		logIn();
	}
	
	@Test
	public void accountfalse() {
		
		
		homePage hp = new homePage(driver);
		tabs tabs = new tabs(driver);
		AccountObjects ao=new AccountObjects(driver);
		
		
		
		hp.getSpaceBar();
		hp.getService();
		
		tabs.getServiceTab(tabs.Account);
		
		ao.getNewButton();
		
		ao.clickSandN();
		
		
		
		
		
		Assert.assertEquals(ao.aleeert().isDisplayed(), true, "bien jugado");	
	}
	
	@AfterTest
	public void finish()  {
		
		
		driver.close();
	}

}
