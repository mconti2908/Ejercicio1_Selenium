package excercises;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelDriven.DataDriven;
import excelDriven.testSample;
import pageObjects.AccountObjects;
import pageObjects.homePage;
import pageObjects.iframe;
import pageObjects.landingPage;
import pageObjects.tabs;
import resources.base;

public class newAccount extends base {
	
	WebDriver driver;
	 
	
	@BeforeTest
	public void initialize() throws IOException {
		
		
		driver = initializeDriver();
		driver.get(url());
		
		logIn();
		
	}
	
	@Test(dataProvider = "dataprovider")
	public void account(
			String name, String phone, String fax,
			String account, String Website, String Site) throws InterruptedException, IOException {

		
		homePage hp = new homePage(driver);
		tabs tabs = new tabs(driver);
		AccountObjects ao=new AccountObjects(driver);
        testSample ts=new testSample();
	
         ts.getexcel("Rating", 0);
		hp.getSpaceBar();
		hp.getService();
			
			
	tabs.getServiceTab(tabs.Account);
		
		
	ao.getNewButton();
			
		
		
	 ao.getRatingClick().click();
	 ao.SelectItem("Rating", "Warm");
	 
	 	
	
		ao.getName().sendKeys(name);
		ao.getPhone().sendKeys(phone);
		ao.getFax().sendKeys(fax);
		ao.getAccountNumber().sendKeys(account);
		ao.getWebsite().sendKeys(Website);
		ao.getSite().sendKeys(Site);
		ao.getTickerSymbol().sendKeys(Website);
		
		ao.getObject("Type");
		ao.SelectObject("Prospect").click();
		
		ao.getObject("Ownership");
		ao.SelectObject("Public").click();
		
		
		ao.getObject("Industry");
		ao.SelectObject("Chemicals").click();
		 
		
		ao.NumberOfEmployees().sendKeys("8");
		ao.AnualRevenue().sendKeys("80000");
		ao.sic().sendKeys("11200");
		
		
		ao.CompleteDir("Billing Street","Colonia 1370");
		ao.CompleteDir("Shipping Street","Shipping Adress");
		
		
		ao.CompleteInfo("Billing Zip/Postal Code", "11200"); 
		ao.CompleteInfo("Shipping Zip/Postal Code", "11200"); 
		ao.CompleteInfo("Billing City", "Montevideo");
		ao.CompleteInfo("Billing State/Province", "Montevideo");
		ao.CompleteInfo("Shipping City", "Montevideo");
		ao.CompleteInfo("Shipping State/Province", "Montevideo");
		ao.CompleteInfo("Billing Country", "Uruguay");
		ao.CompleteInfo("Shipping Country", "Uruguay");
		
		
		ao.comboboxClick("Customer Priority");
		ao.comboboxSelect("Medium");
		
		
		//ao.comboboxClick("SLA");
		//ao.comboboxSelect("Platinum");
		ao.comboboxClick("SLA");
		ao.SelectItem("SLA", "Gold");
		

		//ao.Uoportunity();
		//ao.comboboxSelect("Maybe");
		ao.Uoportunity();
		ao.SelectItem("Upsell Opportunity", "Yes");
		
		ao.Active();
		ao.SelectItem("Active", "Yes");
		
		ao.CompleteInfo("SLA Serial Number", "bla bla");
		
		ao.CompleteInfo("Number of Locations", "9");
		
		ao.CompleteDir("Description", "Estoy completando otro campo que se pide");
		
		ao.selectCal("August", "2022","29","08");
		
		ao.clickSandN();
		

	}
	
	@AfterTest
	public void finish()  {
		
		
		driver.close();
	}
	
	@DataProvider
	public Object[][] dataprovider() {

		Object[][] provider = new Object[1][6];
		
		
		provider[0][0] = "Jorge";
		provider[0][1] = "+598965463973";
		provider[0][2] = "No tengo";
		provider[0][3] = "1294584";
		provider[0][4] = "mapa.com";
		provider[0][5] = "jorga";
		

		return provider;

	}
	
	

	

}
