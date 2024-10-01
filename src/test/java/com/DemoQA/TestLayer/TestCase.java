package com.DemoQA.TestLayer;

import java.io.IOException;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.DemoQA.PageLayer.TC14_DataProviderInTestNg;
import com.DemoQA.TestBase.TestBase;
import utilityPackage.ListenerClass;
import utilityPackage.CommonMethods;

@Listeners(ListenerClass.class)
public class TestCase extends TestBase{


	@Test (priority=1, enabled=true, 
			description = "Test to verify browser resizing and positioning operations")
	public void TC01_ActionOnBrowser() {
		//Dimension Class and Point Class usage
		d1.actionOnBrowser();
		
	}

	@Test (priority=2, enabled=true, invocationCount = 1,
			description = "Test to verify the login and logout functionality of the application")
	public void TC02_LoginLogOut() {
		//Login and Logout on Demo Website
		d2.login(userName,passWord);
		
		d2.logOut();
	}

	@Test (priority=3, enabled=true,
			description = "Test to verify interactions with various types web elements")
	public void TC03_WebElementAction () {
		//Different Type of element and Handling them
		d2.login(userName,passWord);
		
		d3.actionOnElements();
		
		d2.logOut();
	}

	@Test (priority=4,enabled=true,
			description = "Test to verify different ways of performing click operations on a web element")
	public void TC04_ClickOperationType(){
		//Different ways to perform click on webelement
		d4.clickOperationType();			
	}

	@Test (priority=5, enabled=true,
			description = "Test to verify dynamic table handling by fetching the number of rows and columns")
	public void TC05_DynamicTableStructure() {
		//Get the number of Rows and Columns from table dynamically 
		d5.dynamicTableStructure();			
	}

	@Test (priority=6, enabled=true,
			description = "Test to verify window handling operations including switching between multiple windows")
	public void TC06_WindowHandling() {
		//Difference between getWindowHandle & getWindowHandles 
		//Window switch using Desired Index value and Title out of multiple windows
		d6.windowHandling();				
	}

	@Test (priority=7, enabled=true,
			description = "Test to handle and interact with an iFrame element within a webpage")
	public void TC07_IFrameHandling(){
		//Handled Iframe on Google.com 
		d7.iframeHandling();

	}

	@Test (priority=8, enabled=true,
			description = "Test to dynamically fetch the count of search results and cart value validation")
	public void TC08_SearchResultAndCartValidation(){
		//Fetch the search result count dynamically in run time. 
		//Assume here we can send any input in search box and code should work properly.
		d8.searchResultCount();
		
		d8.cartValue();
	}

	@Test (priority=9, enabled=true,
			description = "Test to verify handling of different types of alert pop-ups in the browser")
	public void TC09_AlertHandling() {
		//Different Type of Alert and Handling them
		d9.alertHandling();
	}

	@Test (priority=10, enabled=true,
			description = "Test to verify the handling of dropdown menus and extracting options using the Select class")
	public void TC10_DropdownHandling(){
		//DropdownHandling and Get Dropdown Options Using Select Class 
		d10.dropdownHandling();
	}

	@Test (priority=11, enabled=true,
			description = "Test to verify the use of different explicit wait conditions in Selenium")
	public void TC11_ExplicitWaitConditions() {
		//Different ExplicitWait Conditions handling
		d11.explicitWaitConditions();
	}

	@Test (priority=12, enabled=true,
			description = "Test to verify broken link validation by checking the status of URLs")
	public void TC12_BrokenLinkValidation() {
		//Broken Link Validation 
		d12.brokenLinkValidation("https://www.cricbuzz.com");
	}

	@Test (priority=13, enabled=true,
			description = "Test to verify the usage of the Mouse Actions class for performing complex user interactions")
	public void TC13_MouseAction() {
		//Mouse Action class usages 
		d13.mouseAction();
	}

	@Test (priority=14, enabled=true,
			dataProvider= "loginCasesData", dataProviderClass = TC14_DataProviderInTestNg.class,
			description = "Test to verify the login functionality using different data sets through a DataProvider")
	public void TC14_DataProviderMethod(String userName, String passWord) {
		//DataProvider Class
		d14.dataProviderMethod(userName, passWord);
	}

	@Test (priority=15, enabled=true,
			description = "Test to verify handling of multiple browser tabs and windows")
	public void TC15_MultipleTabAndWindows(){
		//Handling multiple Tab and Windows
		d15.multipleWindow();
		d15.multipleTab();
	}

	@Test (priority=16, enabled=true,
			description = "Test to verify the acceptance and handling of SSL certificates in the browser")
	public void TC16_sslCertificateMethod() {
		//Accepting SSL Certificate
		d16.sslCertificateMethod();
	}

	@Test(priority = 17, enabled = true, 
			description = "Test to verify that user should NOT be able to login with invalid credentials_TestShouldFail")
	public void TC17_FailedTestCase()  {

		d17.loginExpectedToFail(invalidUserName, invalidPassword);		
	}	
	
	
	@Test(priority = 18, enabled = true, 
			description = "Test to ensure that the user can download PDF and validate data")	
	public void TC18_PdfDownloadAndValidation()  {

		d18.navigateToProduct();
		
		d18.productDetails();
		
		d18.downloadTearsheet();
		
	}	
	
	
	
	
//Upcoming test case work - data driven test for validation on login saucelab web site https://www.saucedemo.com/
//dependsOnMethods = {"TC02_LoginLogOut"} annotation for Employeer Credentials creation for newly added emp 	
//	Optimise broken link validation print and handle null pointer exception and Print count of Valid and broken links
	
	//Modify Explicite wait with having all condition handled in automations
	//Timeout annotation not worked on TC01
	//Optimize code for image comparison as it not working after taking live image 
	
	//Add title of tab in config file
	//Check for how to allow popup permission
	//remove boolean value parameter from every method
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test(priority = 25, enabled = true, 
			description = "Test to verify that actual image is matches with the expected image using pixel to pixel mapping")
	public void TC25_ImageComparison() throws Exception  {

		Thread.sleep(4000);
		
		String actualPath = CommonMethods.takeScreenShot(driver, "ImageCompare_"); 
		
		Thread.sleep(2000);
	
		//	String expectedPath = "D:\\Ashish-All Data\\Data\\Automation Project BackUp\\DemoPro_DataFiles\\OrangeHRM_Blue.jpg";
		
		String expectedPath = "D:\\Ashish-All Data\\Data\\Automation Project BackUp\\DemoPro_DataFiles\\OrangeHRM_Orange.jpg";
		
		CommonMethods.imageComparison(expectedPath, actualPath);
		
	}	
	
	

	@Test(priority = 26, enabled = false, 
			description = "This test will be marked as skipped in test report_TestShouldSkipped")
	public void TC26_SkippedTestCase() {

		boolean condition = true; // You can set this condition dynamically -true always
		if (condition) {
			throw new SkipException("Skipping this test because the condition is true");
		}
		// Code that won't be executed if the test is skipped
		System.out.println("This test should be skipped.");
	}
	
	
	@Test (priority = 27, enabled = false,
			description = "Test test will be marked as with some Error_TestShouldPass")
	public void TC27_WarningTestCase() {

		d2.login(userName,passWord);

		action.titleValidation("OrangeHRM New Changes");

		d2.logOut();			
	}


}
