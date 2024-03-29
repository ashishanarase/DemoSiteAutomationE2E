package com.DemoQA.TestBase;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.DemoQA.PageLayer.TC00_SampleClass;
import com.DemoQA.PageLayer.TC01_HomePage;
import com.DemoQA.PageLayer.TC02_ElementHandeling;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	
	static String demoUrl = "https://demoqa.com/";
	static String desiredBrowser = "chrome";       // firefox
	static String browserVersion = "123.0.6312.59";

	public TC00_SampleClass d0;
	public TC01_HomePage d1;
	public TC02_ElementHandeling d2;
	//public TC03_Page3 d3;

	@BeforeMethod
	public void startBrowser () {
		if (desiredBrowser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().browserVersion(browserVersion).setup(); //.browserVersion(browserVersion)
			driver = new ChromeDriver();

			d0 = new TC00_SampleClass();
			d1 = new TC01_HomePage();
			d2 = new TC02_ElementHandeling ();

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.get(demoUrl);
		}
		
		else if (desiredBrowser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			d0 = new TC00_SampleClass();
			d1 = new TC01_HomePage();
			d2 = new TC02_ElementHandeling ();

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.get(demoUrl);
		}
	}
	
	@AfterMethod	
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}


}
