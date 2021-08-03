package resources;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import pageObjects.landingPage;


public class base {
	
	public WebDriver driver;
	public Properties prop;
	

	public WebDriver initializeDriver() throws IOException {
		
		Properties prop=new Properties();
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Usuario\\Desktop\\chromedriver.exe");
			
			Map<String, Object> prefs = new HashMap<String, Object>();

			// add key and value to map as follow to switch off browser notification
			// Pass the argument 1 to allow and 2 to block
			prefs.put("profile.default_content_setting_values.notifications", 2);

			// Create an instance of ChromeOptions
			ChromeOptions options = new ChromeOptions();

			// set ExperimentalOption - prefs
			options.setExperimentalOption("prefs", prefs);
			
			driver = new ChromeDriver(options);
		}
		else if(browserName.equals("firefox") ) {
			
			driver =new FirefoxDriver();
		}
		else if (browserName.equals("IE")) {
			
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public String url() throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:/Users/Usuario/eclipse-workspace/SeleniumTest/src/main/java/resources/data.properties");
		prop.load(fis);
		String url=prop.getProperty("url");
		
		return url;
		
	}
	
	public void logIn() {
		
		landingPage lp = new landingPage(driver);
		lp.getUsername();
		lp.getPassword();
		lp.getLogin();
	}
	
	

}
