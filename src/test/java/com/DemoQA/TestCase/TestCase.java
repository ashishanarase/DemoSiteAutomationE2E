package com.DemoQA.TestCase;

import java.io.IOException;
import java.util.Set;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.DemoQA.PageLayer.TC14_DataProviderInTestNg;
import com.DemoQA.TestBase.TestBase;
import utilityPackage.ListenerClass;
import utilityPackage.CommonMethods;

@Listeners(ListenerClass.class)
public class TestCase extends TestBase{


	@Test (priority=1, enabled=false, timeOut = 30000,
			description = "Test to verify browser resizing and positioning operations")
	public void TC01_ActionOnBrowser() throws InterruptedException {
		//Dimension Class and Point Class usage
		d1.actionOnBrowser();
		CommonMethods.titleValidation("OrangeHRM");	
	}

	@Test (priority=2, enabled=true, invocationCount = 1,
			description = "Test to verify the login and logout functionality of the application")
	public void TC02_LoginLogOut() throws InterruptedException {
		//Login and Logout on Demo Website
		d2.login(userName,passWord);
		CommonMethods.titleValidation("OrangeHRM");
		d2.logOut();
	}

	@Test (priority=3, enabled=false, dependsOnMethods = {"loginLogOut"},
			description = "Test to verify interactions with various web elements such as buttons and text fields")
	public void TC03_WebElementAction () {
		//Different Type of Xpath and Handling them
		d2.login(userName,passWord);
		CommonMethods.titleValidation("OrangeHRM");
		d3.actionOnElements();
		d2.logOut();
	}



	@Test (priority=4,enabled=false,
			description = "Test to verify different ways of performing click operations on a web element")
	public void TC04_ClickOperationType() throws InterruptedException  {
		//Different ways to perform click on webelement
		d4.clickOperationType();			
	}

	@Test (priority=5, enabled=false,
			description = "Test to verify dynamic table handling by fetching the number of rows and columns")
	public void TC05_DynamicTableStructure() throws InterruptedException  {
		//Get the number of Rows and Columns from table dynamically 
		d5.dynamicTableStructure();			
	}

	@Test (priority=6, enabled=false,
			description = "Test to verify window handling operations including switching between multiple windows")
	public void TC06_WindowHandling() throws InterruptedException  {
		//Difference between getWindowHandle & getWindowHandles 
		//Window switch using Desired Index value and Title out of multiple windows
		d6.WindowHandling();				
	}

	@Test (priority=7, enabled=false,
			description = "Test to handle and interact with an iFrame element within a webpage")
	public void TC07_IFrameHandling() throws InterruptedException  {
		//Handled Iframe on Google.com 
		d7.iframeHandling();

	}

	@Test (priority=8, enabled=false,
			description = "Test to dynamically fetch and validate the count of search results")
	public void TC08_FetchSearchResultCount() throws InterruptedException  {
		//Fetch the search result count dynamically in run time. 
		//Assume here we can send any input in search box and code should work properly.
		d8.fetchSearchResultCount();
	}

	@Test (priority=9, enabled=false,
			description = "Test to verify handling of different types of alert pop-ups in the browser")
	public void TC09_AlertHandling() throws InterruptedException  {
		//Different Type of Alert and Handling them
		d9.alertHandling();
	}

	@Test (priority=10, enabled=false,
			description = "Test to verify the handling of dropdown menus and extracting options using the Select class")
	public void TC10_DropdownHandling() throws InterruptedException  {
		//DropdownHandling and Get Dropdown Options Using Select Class 
		d10.dropdownHandling();
	}

	@Test (priority=11, enabled=false,
			description = "Test to verify the use of different explicit wait conditions in Selenium")
	public void TC11_ExplicitWaitConditions() throws InterruptedException  {
		//Different ExplicitWait Conditions handling
		d11.explicitWaitConditions();
	}

	@Test (priority=12, enabled=false,
			description = "Test to verify broken link validation by checking the status of URLs")
	public void TC12_BrokenLinkValidation() throws InterruptedException, IOException  {
		//Broken Link Validation 
		d12.brokenLinkValidation("https://www.amazon.in");
	}

	@Test (priority=13, enabled=false,
			description = "Test to verify the usage of the Mouse Actions class for performing complex user interactions")
	public void TC13_MouseActionClass() throws InterruptedException  {
		//Mouse Action class usages 
		d13.mouseActionClass();
	}

	@Test (priority=14, enabled=false,
			dataProvider= "loginCasesData", dataProviderClass = TC14_DataProviderInTestNg.class,
			description = "Test to verify the login functionality using different data sets through a DataProvider")
	public void TC14_DataProviderMethod(String userName, String passWord) throws InterruptedException {
		//DataProvider Class
		d14.dataProviderMethod(userName, passWord);
	}

	@Test (priority=15, enabled=false,
			description = "Test to verify handling of multiple browser tabs and windows")
	public void TC15_MultipleTabAndWindows() throws InterruptedException  {
		//Handling multiple Tab and Windows
		d15.multipleWindow();
		d15.multipleTab();
	}

	@Test (priority=16, enabled=false,
			description = "Test to verify the acceptance and handling of SSL certificates in the browser")
	public void TC16_sslCertificateMethod() throws InterruptedException  {
		//Accepting SSL Certificate
		d16.sslCertificateMethod();
	}

	@Test(priority = 17, enabled = true, 
			description = "Test to verify that user should NOT be able to login with invalid credentials_TestShouldFail")
	public void TC17_FailedTestCase()  {

		d17.loginExpectedToFail(invalidUserName, invalidPassword);		
	}	
	
	
//Upcoming test case work - data driven test for validation on login saucelab web site
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Test(priority = 10, enabled = true, 
			description = "This test will be marked as skipped in test report_TestShouldSkipped")
	public void TC11_SkippedTestCase() {

		boolean condition = true; // You can set this condition dynamically -true always
		if (condition) {
			throw new SkipException("Skipping this test because the condition is true");
		}
		// Code that won't be executed if the test is skipped
		System.out.println("This test should be skipped.");
	}
	
	
	@Test (priority = 11, enabled = true,
			description = "Test test will be marked as with some Error_TestShouldPass")
	public void TC12_ErrorTestCase() {

		d2.login(userName,passWord);

		CommonMethods.titleValidation("OrangeHRM New Changes");

		d2.logOut();			
	}


}
