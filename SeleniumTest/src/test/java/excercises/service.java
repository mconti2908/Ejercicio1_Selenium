package excercises;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.iframe;
import pageObjects.landingPage;
import pageObjects.tabs;
import resources.base;

public class service extends base {

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(url());
		logIn();
	}

	@Test(dataProvider = "dataprovider")
	public void Service(String email, String password) throws InterruptedException {

		homePage hp = new homePage(driver);
		tabs tabs = new tabs(driver);
		iframe iframe = new iframe(driver);

		hp.getSpaceBar();
		hp.getService();

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
			

			Thread.sleep(2000L);

			if (iframe.getIframes().size() > 0) {
				if (iframe.getIframes().size() > 1) {
					driver.switchTo().frame(1);
				} else {
					driver.switchTo().frame(0);
				}

				//Thread.sleep(3000L);
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

		}}

	}
	
	@AfterTest
	public void finish()  {
		
		
		driver.close();
	}

	@DataProvider
	public Object[][] dataprovider() {

		Object[][] provider = new Object[1][2];
		provider[0][0] = "mconti2908@tcs.com";
		provider[0][1] = "@MauCon2908";

		return provider;

	}
}
