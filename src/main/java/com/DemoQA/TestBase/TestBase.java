package com.DemoQA.TestBase;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.DemoQA.PageLayer.TC00_SampleClass;
import com.DemoQA.PageLayer.TC01_HomePage;
import com.DemoQA.PageLayer.TC02_WebElementTypes;
import com.DemoQA.PageLayer.TC03_WindowHandling;
import com.DemoQA.PageLayer.TC04_ClickOperationType;
import com.DemoQA.PageLayer.TC05_DynamicTableStructure;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Logger logger;
	
	static String demoUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	static String desiredBrowser = "chrome";       // firefox
	static String browserVersion = "123.0.6312.59";

	public TC00_SampleClass d0;
	public TC01_HomePage d1;
	public TC02_WebElementTypes d2;
	public TC03_WindowHandling d3;
	public TC04_ClickOperationType d4;
	public TC05_DynamicTableStructure d5;

	@BeforeMethod
	public void startBrowser () {		

		//obj references
		d0 = new TC00_SampleClass();
		d1 = new TC01_HomePage();
		d2 = new TC02_WebElementTypes ();
		d3 = new TC03_WindowHandling ();
		d4 = new TC04_ClickOperationType ();
		d5 = new TC05_DynamicTableStructure ();
		
		if (desiredBrowser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().browserVersion(browserVersion).setup(); //.browserVersion(browserVersion)
			driver = new ChromeDriver();
			logger = LogManager.getLogger(getClass());

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.get(demoUrl);
		}
		
		else if (desiredBrowser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.get(demoUrl);
		}
	}
	
	@AfterMethod	
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(1000);
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);
		driver.quit();
	}


}
