package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

//import com.crm.qa.util.WebEventListener;
import com.crm.qa.utilities.TestUtil;

public class TestBase {
	public static WebDriver driver; //Can be used throughout the program
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebDriverListener eventListener;
	
	
	
	public TestBase() {
		try {
			prop=new Properties();
			//FileInputStream ip=new FileInputStream("D:\\Selenium Proj\\PracticeSelenium\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		}
		 catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();

        }
     }
	
	public static void intialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			driver= new ChromeDriver();
		}else
		{
			if(browserName.equals("FF")) {
				driver = new FirefoxDriver();
			}
		}
		
		//WebdriverFrieEvent -> generate selenium action logs
		
//		//e_driver = new EventFiringWebDriver(driver);
//		///e_driver = new EventFiringDecorator<WebDriver>(driver);
//		// Now create object of EventListerHandler to register it with EventFiringWebDriver
//		eventListener = new WebEventListener();
//		e_driver.register(eventListener);
//		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_TIMOUT));
		driver.get(prop.getProperty("url"));
	}
	
	
}