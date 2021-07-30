package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import resources.base;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.AccountObjects;
import pageObjects.ContactObjects;
import pageObjects.homePage;
import pageObjects.iframe;
import pageObjects.tabs;

@RunWith(Cucumber.class)
public class CommonStepDefinition extends base{
	static WebDriver driver;

	
	 
	@Given("^Initialize the browser with chrome$")
	    public void initialize_the_browser_with_chrome() throws Throwable { 
		driver = initializeDriver();
	    }

	    @When("^User enters username and password and logs in$")
	    public void user_enters_username_and_password_and_logs_in() throws Throwable {
	    	logIn();
	    }

	    @Then("^Click Flat Icon$")
	    public void click_flat_icon() throws Throwable {
	    	homePage hp = new homePage(driver);
			 hp.getSpaceBar();
	    }

	    @And("^Navigate to the Site$")
	    public void navigate_to_something_site() throws Throwable {
	    	driver.get(url());
	    }

	    @And("^Select service$")
	    public void select_service() throws Throwable {
	    	homePage hp = new homePage(driver);
	    	hp.getService();
	    }
	    
	   @When("^User Navigate arround tabs and press new and cancell buttons$")
	    public void user_navigate_arround_tabs_and_press_new_and_cancell_buttons() throws Throwable {
		   homePage hp = new homePage(driver);
			tabs tabs = new tabs(driver);
			iframe iframe = new iframe(driver);
			
		   for (int i = 1; i < hp.getTabs().size(); i++) {
				WebElement Test = hp.getTabs().get(i);
				Test.click();

				if (hp.getNew().size() > 0) {

					if (tabs.getDashboards().size() > 0) {
						tabs.getDashboard().click();
					} else {
						if (tabs.getReports().size() > 0) {
							tabs.getReport().click();
						} else {
							tabs.getNew();
						}
					}
				}

				Thread.sleep(3000L);

				if (iframe.getIframes().size() > 0) {
					if (iframe.getIframes().size() > 1) {
						driver.switchTo().frame(1);
					} else {
						driver.switchTo().frame(0);
					}

					Thread.sleep(3000L);
					Actions a = new Actions(driver);
					a.click(tabs.getCancel()).build().perform();
					driver.switchTo().defaultContent();
				}
				if (tabs.CountCancells().size() > 0) {
					tabs.getCancel().click();
				}
				if (tabs.CountCancellsTitle().size() > 0) {
					tabs.getCancelledButton().click();
				}

			}
	    } 

	    @And("^close the driver$")
	    public void close_the_driver() throws Throwable {
	        driver.close();
	    } 
	    
	    @Given("^User clicks on Account Tab$")
	    public void user_clicks_on_account_tab() throws Throwable {
	    	tabs tabs = new tabs(driver);
	    	tabs.getServiceTab(tabs.Account);
	    }

	    @When("^Create a New Account with (.+), (.+), (.+), (.+), (.+), (.+)$")
	    public void create_a_new_account_with_(String name, String phone, String fax, String account, String Website, String Site) throws Throwable {
	    	AccountObjects ao=new AccountObjects(driver);
	    	
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
	   		
	   		
	   		
	   		ao.comboboxClick("SLA");
	   		ao.SelectItem("SLA", "Gold");
	   		
	   		ao.Uoportunity();
	   		ao.SelectItem("Upsell Opportunity", "Yes");
	   		
	   		ao.Active();
	   		ao.SelectItem("Active", "Yes");
	   		
	   		ao.CompleteInfo("SLA Serial Number", "bla bla");
	   		
	   		ao.CompleteInfo("Number of Locations", "9");
	   		
	   		ao.CompleteDir("Description", "Estoy completando otro campo que se pide");
	   		
	   		ao.selectCal("August", "2022","29","08");
	    }  

	    @And("^click New Account$")
	    public void click_new_account() throws Throwable {
	    	AccountObjects ao=new AccountObjects(driver);
	    	ao.getNewButton();
	    }

	    @Then("^Click Save and New$")
	    public void click_save_and_new() throws Throwable {
	    	AccountObjects ao=new AccountObjects(driver);
	    	ao.clickSandN();
	    } 
	    
	    @When("^fills only one place$")
	    public void fills_only_one_place() throws Throwable {
	        System.out.println("I am not filling anything");
	    }
	    
	    @And("^it takes an error$")
	    public void it_takes_an_error() throws Throwable {
	    	AccountObjects ao=new AccountObjects(driver);
	    	Assert.assertEquals(ao.aleeert().isDisplayed(), true, "Well played");	
	    } 
	    
	    @Given("^User clicks on contact record Tab and open a new window$")
	    public void user_clicks_on_contact_record_tab_and_open_a_new_window() throws Throwable {
	    	tabs tabs = new tabs(driver);
	    	tabs.ContactLink.sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
	    }

	    @When("^clicks to create a new contact record$")
	    public void clicks_to_create_a_new_contact_record() throws Throwable {
	    	ContactObjects co = new ContactObjects(driver);
	    	co.clickNew();
	    }

	    @Then("^Saves the contact record$")
	    public void saves_the_contact_record() throws Throwable {
	    	AccountObjects ao=new AccountObjects(driver);
	    	ContactObjects co = new ContactObjects(driver);
	    	ao.clickSandN();
	    	Thread.sleep(3000);
			co.ClickCancel();
	    }

	    @And("^switch to the new Window$")
	    public void switch_to_the_new_window() throws Throwable {
	    	Set<String> windows = driver.getWindowHandles(); 

			Iterator<String> it = windows.iterator();

			String parentId = it.next();

			String childId = it.next();

			driver.switchTo().window(childId);
	    }

	    @And("^fill the contact record$")
	    public void fill_the_contact_record() throws Throwable {
	    	ContactObjects co = new ContactObjects(driver);
	    	
	    	co.clickItem(co.salutation);
	    	
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			 js.executeScript("arguments[0].click();", co.SelectSalutation());
		
			
			co.WriteItem(co.LastName, "Conti");
			
			co.AccountName.sendKeys("jorge");
			co.Account.click();
	    }

	    @And("^switch to original window$")
	    public void switch_to_original_window() throws Throwable {
	    	Set<String> windows = driver.getWindowHandles(); 

			Iterator<String> it = windows.iterator();

			String parentId = it.next();

			String childId = it.next();

			driver.switchTo().window(childId); 
	    	
	    	driver.switchTo().window(parentId);
	    }
	    
	    @When("^user edits some records$")
	    public void user_edits_some_records() throws Throwable {
	    	AccountObjects ao=new AccountObjects(driver);
	    	
	    	ao.enterObject(ao.Type);
	    	ao.SelectObject("Installation Partner").click();
	    	
	    	ao.enterObject(ao.Rating);
	    	 ao.SelectItem("Rating", "Hot");
	    	 
	    	 ao.Uoportunity();
	    	 ao.SelectItem("Upsell Opportunity", "No");
	    	    
	    		
	         ao.clickSave();
	         
	         
	    }

	    @Then("^verify if it is saved$")
	    public void verify_if_it_is_saved() throws Throwable {
	    	AccountObjects ao=new AccountObjects(driver);
	    	Thread.sleep(6000);
	        
	        
	        ao.clickArrow();
	    	
	    	ao.clickEdit();
	        
	    	ao.enterObject(ao.Rating); 
	    	Assert.assertTrue(ao.ItemSelected("Rating", "Hot"), "le errast pibe");
	    	
	    	ao.enterObject(ao.Type);
	    	Assert.assertTrue(ao.ItemSelected("Type", "Installation Partner"), "le errast pibe");
	    	
	    	ao.Uoportunity();
	    	Assert.assertTrue(ao.ItemSelected("Upsell Opportunity", "No"), "le errast pibe");	
	    }

	    @And("^click edit account$")
	    public void click_edit_account() throws Throwable {
	    	AccountObjects ao=new AccountObjects(driver);
	    	ao.clickArrow();
	    	
	    	ao.clickEdit();
	    }
	    
	    @And("^change the number of employees$")
	    public void change_the_number_of_employees() throws Throwable {
	    	AccountObjects ao=new AccountObjects(driver);
	    	ao.NumberOfEmployees().clear();
	     	ao.NumberOfEmployees().sendKeys("1431655766");
	    }

	    @And("^click save and verify if the mistake is correct$")
	    public void click_save_and_verify_if_the_mistake_is_correct() throws Throwable {
	    	AccountObjects ao=new AccountObjects(driver);
	    	ao.clickSave();
	     	Assert.assertEquals(ao.returnMessage(ao.Message), ao.Employee_Alert);
	    }
	    
	    @And("^quit the driver$")
	    public void quit_the_driver() throws Throwable {
	        driver.quit();
	    }


}
