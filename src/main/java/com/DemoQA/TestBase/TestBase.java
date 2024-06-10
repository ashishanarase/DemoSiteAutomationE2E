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
import com.DemoQA.PageLayer.TC06_ExtentReportExample;
import com.DemoQA.PageLayer.TC07_IframeHandling;
import com.DemoQA.PageLayer.TC08_SearchResultCount;
import com.DemoQA.PageLayer.TC09_AlertHandling;
import com.DemoQA.PageLayer.TC10_DropdownHandling;
import com.DemoQA.PageLayer.TC11_ExplicitWaitConditions;
import com.DemoQA.PageLayer.TC12_BrokenLinkValidation;
import com.DemoQA.PageLayer.TC13_MouseActionClass;
import com.DemoQA.PageLayer.TC14_DataProviderInTestNg;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Logger logger;
	
	static String demoUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	static String desiredBrowser = "chrome";       // firefox
	static String browserVersion = "123.0.6312.107";

	public TC00_SampleClass d0;
	public TC01_HomePage d1;
	public TC02_WebElementTypes d2;
	public TC03_WindowHandling d3;
	public TC04_ClickOperationType d4;
	public TC05_DynamicTableStructure d5;
	public TC06_ExtentReportExample d6;
	public TC07_IframeHandling d7;
	public TC08_SearchResultCount d8;
	public TC09_AlertHandling d9;
	public TC10_DropdownHandling d10;
	public TC11_ExplicitWaitConditions d11;
	public TC12_BrokenLinkValidation d12;
	public TC13_MouseActionClass d13;
	public TC14_DataProviderInTestNg d14;

	@BeforeMethod
	public void startBrowser () {		

		
		if (desiredBrowser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().browserVersion(browserVersion).setup(); //.browserVersion(browserVersion)
			driver = new ChromeDriver();
			logger = LogManager.getLogger(getClass());
			
		}
		
		else if (desiredBrowser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger = LogManager.getLogger(getClass());
		}
		
			//obj references
			d0 = new TC00_SampleClass();
			d1 = new TC01_HomePage();
			d2 = new TC02_WebElementTypes ();
			d3 = new TC03_WindowHandling ();
			d4 = new TC04_ClickOperationType ();
			d5 = new TC05_DynamicTableStructure ();
			d6 = new TC06_ExtentReportExample ();
			d7 = new TC07_IframeHandling ();
			d8 = new TC08_SearchResultCount ();
			d9 = new TC09_AlertHandling ();
			d10 = new TC10_DropdownHandling ();
			d11 = new TC11_ExplicitWaitConditions();
			d12 = new TC12_BrokenLinkValidation ();
			d13 = new TC13_MouseActionClass ();
			d14 = new TC14_DataProviderInTestNg ();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.navigate().refresh();
			driver.navigate();
			

			driver.get(demoUrl);
		}
	
	
	@AfterMethod	
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}


}
