package com.DemoQA.TestBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.DemoQA.PageLayer.TC00_SampleClass;
import com.DemoQA.PageLayer.TC01_HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;

	static String demoUrl = "https://demoqa.com";
	static String desiredBrowser = "chrome";       // firefox
	static String browserVersion = "122.0.6261.131";

	public TC00_SampleClass d0;
	public TC01_HomePage d1;

	@BeforeTest
	public void startBrowser () {
		if (desiredBrowser=="chrome") {
			WebDriverManager.chromedriver().browserVersion(browserVersion).setup();
			driver = new ChromeDriver();

			d0 = new TC00_SampleClass();
			d1 = new TC01_HomePage();

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.get(demoUrl);
		}
		
		else if (desiredBrowser=="firefox") {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			d0 = new TC00_SampleClass();
			d1 = new TC01_HomePage();

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.get(demoUrl);
		}
	}
	
	@AfterTest	
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}


}
