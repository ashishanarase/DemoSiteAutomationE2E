package com.DemoQA.TestBase;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.DemoQA.PageLayer.TC02_HomePage;
import com.DemoQA.PageLayer.TC03_WebElementTypes;
import com.DemoQA.PageLayer.TC06_WindowHandling;
import com.DemoQA.PageLayer.TC04_ClickOperationType;
import com.DemoQA.PageLayer.TC05_DynamicTableStructure;
import com.DemoQA.PageLayer.GenericActionTemplate;
import com.DemoQA.PageLayer.TC01_ActionOnBrowser;
import com.DemoQA.PageLayer.TC07_IframeHandling;
import com.DemoQA.PageLayer.TC08_SearchResultCount;
import com.DemoQA.PageLayer.TC09_AlertHandling;
import com.DemoQA.PageLayer.TC10_DropdownHandling;
import com.DemoQA.PageLayer.TC11_ExplicitAndFluentWaits;
import com.DemoQA.PageLayer.TC12_BrokenLinkValidation;
import com.DemoQA.PageLayer.TC13_MouseAction;
import com.DemoQA.PageLayer.TC14_DataProviderInTestNg;
import com.DemoQA.PageLayer.TC15_MultipleWindowsAndTabHandling;
import com.DemoQA.PageLayer.TC16_SSLCertificate;
import com.DemoQA.PageLayer.TC17_FailedTestCase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilityPackage.ConfigLoader;
import utilityPackage.DataProvider;

public class TestBase {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static ExtentReports extent;
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	static String appUrl;
	protected static String userDirectory;
	static String desiredBrowser = "chrome";       // firefox
	static String browserVersion = "127.0.6533.122";

	// Fetch login credentials from configuration file
	protected String userName;
	protected String passWord;
	protected String invalidUserName;
	protected String invalidPassword;
	protected String resetUserName;

	// Fetch employee details from dataprovider class
	String[] nameDetails;
	protected String firstName;
	protected String middleName;
	protected String lastName;
	protected String employeeID;

	public static GenericActionTemplate action;
	public TC01_ActionOnBrowser d1;
	public TC02_HomePage d2;
	public TC03_WebElementTypes d3;	
	public TC04_ClickOperationType d4;
	public TC05_DynamicTableStructure d5;
	public TC06_WindowHandling d6;
	public TC07_IframeHandling d7;
	public TC08_SearchResultCount d8;
	public TC09_AlertHandling d9;
	public TC10_DropdownHandling d10;
	public TC11_ExplicitAndFluentWaits d11;
	public TC12_BrokenLinkValidation d12;
	public TC13_MouseAction d13;
	public TC14_DataProviderInTestNg d14;
	public TC15_MultipleWindowsAndTabHandling d15;
	public TC16_SSLCertificate d16;
	public TC17_FailedTestCase d17;

	@BeforeSuite
	public void dataGeneration() {
		//Used to generate employee data randomly for each test run
		DataProvider.getNameDetails();
		
		extent = new ExtentReports();

		// Load environment-specific properties from ConfigLoader
		String environment = System.getProperty("environment", "prod");    //prod //test
		ConfigLoader.loadConfig(environment);
		userDirectory = ConfigLoader.getProperty("userDirectory");
		appUrl = ConfigLoader.getProperty("appUrl");

		// Fetch login credentials from configuration file
		userName = ConfigLoader.getProperty("username");
		passWord = ConfigLoader.getProperty("password");
		invalidUserName = ConfigLoader.getProperty("invalidUserName");
		invalidPassword = ConfigLoader.getProperty("invalidPassword");
		resetUserName = ConfigLoader.getProperty("resetUserName");

		// Fetch employee details from dataprovider class
		nameDetails = DataProvider.getNameDetails();
		firstName = nameDetails[0];
		middleName = nameDetails[1];
		lastName = nameDetails[2];
		employeeID = nameDetails[3];  
	}
	@BeforeMethod
	public void startBrowser () {	

		if (desiredBrowser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); //.browserVersion(browserVersion)
			driver = new ChromeDriver();

		}

		else if (desiredBrowser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		//obj references
		action = new GenericActionTemplate();
		d1  = new TC01_ActionOnBrowser();
		d2  = new TC02_HomePage();
		d3  = new TC03_WebElementTypes();		
		d4  = new TC04_ClickOperationType();
		d5  = new TC05_DynamicTableStructure();
		d6  = new TC06_WindowHandling();		
		d7  = new TC07_IframeHandling();
		d8  = new TC08_SearchResultCount();
		d9  = new TC09_AlertHandling();
		d10 = new TC10_DropdownHandling();
		d11 = new TC11_ExplicitAndFluentWaits();
		d12 = new TC12_BrokenLinkValidation();
		d13 = new TC13_MouseAction();
		d14 = new TC14_DataProviderInTestNg();
		d15 = new TC15_MultipleWindowsAndTabHandling();
		d16 = new TC16_SSLCertificate();
		d17 = new TC17_FailedTestCase();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	

		driver.get(appUrl);
	}


	@AfterMethod	
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}


}
