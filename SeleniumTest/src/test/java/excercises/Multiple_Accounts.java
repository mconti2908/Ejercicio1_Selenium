package excercises;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountObjects;
import pageObjects.homePage;
import pageObjects.tabs;
import resources.base;

public class Multiple_Accounts extends base{
	
	WebDriver driver;
	
	

	@BeforeMethod
	public void initialize() throws IOException {
		
		
		driver = initializeDriver();
		driver.get(url());
		logIn();
	}
	
	
	@Test(dataProvider = "InsertarDatos")
	public void account(
			String name, String phone, String fax,
			String account, String Website, String Site) throws InterruptedException {
		homePage hp = new homePage(driver);
		tabs tabs = new tabs(driver);
		AccountObjects ao=new AccountObjects(driver);

		hp.getSpaceBar();
		hp.getService();
			
			
	tabs.getServiceTab(tabs.Account);
		
		
	ao.getNewButton();
			
		
		
	// ao.enterObject(ao.Rating);
	 //ao.SelectItem("Rating", "Warm");
	 
	 	
	
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
	
	@AfterMethod
	public void finish()  {
		
		
		driver.close();
	}
	
	
	@DataProvider(name="InsertarDatos")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "Mauro", "+59892463973", "No tengo", "2033985", "mconti.com", "mconti" },
            { "Fabri", "+5989345973", "No tengo", "1053725", "fdominguez.com", "fdominguez" },
            { "Bhupesh", "+57099955", "no tain", "1832930", "bhopana.com", "rbhopana" }
        };
	}

}
