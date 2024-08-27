package com.DemoQA.TestCase;

import java.io.IOException;
import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.DemoQA.PageLayer.TC14_DataProviderInTestNg;
import com.DemoQA.TestBase.TestBase;
import utilityPackage.ListenerClass;
import utilityPackage.CommonMethods;

@Listeners(ListenerClass.class)
public class TestCase extends TestBase {
	
	@Test (priority=0, enabled=true, timeOut = 30000,
			description = "Test to verify that user should be able to do the browser specific action")
	public void actionOnBrowser() throws InterruptedException {
		//Dimension Class and Point Class usage
		d1.actionOnBrowser();
		CommonMethods.titleValidation("OrangeHRM");	
	}
	
	@Test (priority=1, invocationCount = 2,
			description = "Test to verify that user should be able to do the browser specific action")
	public void loginLogOut() throws InterruptedException {
		//Login and Logout on Demo Website
		d1.login();
		CommonMethods.titleValidation("OrangeHRM");
		d1.logOut();
	}
	
	@Test (priority=2, dependsOnMethods = {"loginLogOut"},
			description = "Test to verify that user should be able to do the browser specific action")
	public void webElementAction () {
		//Different Type of Xpath and Handling them
		d1.login();
		CommonMethods.titleValidation("OrangeHRM");
		d2.actionOnElements();
		d1.logOut();
	}
	
	@Test (priority=3,
			description = "Difference between getWindowHandle & getWindowHandles")
	public void windowHandling() throws InterruptedException  {
		//Difference between getWindowHandle & getWindowHandles 
		//Window switch using Desired Index value and Title out of multiple windows
		d3.WindowHandling();				
	}
	
	@Test (priority=4,
			description = "Test to verify that user should be able to do the browser specific action")
	public void clickOperationType() throws InterruptedException  {
		//Different ways to perform click on webelement
		d4.clickOperationType();			
	}
	
	@Test (priority=5,
			description = "Test to verify that user should be able to do the browser specific action")
	public void dynamicTableStructure() throws InterruptedException  {
		//Get the number of Rows and Columns from table dynamically 
		d5.dynamicTableStructure();			
	}
	
	@Test (priority=6,
			description = "Test to verify that user should be able to do the browser specific action")
	public void extentReportExample() throws InterruptedException  {
		//Extent Report Example
		d6.extentReportExample();
		
	}
	
	@Test (priority=7,
			description = "Test to verify that user should be able to do the browser specific action")
	public void iFrameHandling() throws InterruptedException  {
		//Handled Iframe on Google.com 
		d7.iframeHandling();
		
	}
	
	@Test (priority=8,
			description = "Test to verify that user should be able to do the browser specific action")
	public void fetchSearchResultCount() throws InterruptedException  {
		//Fetch the search result count dynamically in run time. 
		//Assume here we can send any input in search box and code should work properly.
		d8.fetchSearchResultCount();
	}
	
	@Test (priority=9,
			description = "Test to verify that user should be able to do the browser specific action")
	public void alertHandling() throws InterruptedException  {
		//Different Type of Alert and Handling them
		d9.alertHandling();
	}
	
	@Test (priority=10,
			description = "Test to verify that user should be able to do the browser specific action")
	public void dropdownHandling() throws InterruptedException  {
		//DropdownHandling and Get Dropdown Options Using Select Class 
		d10.dropdownHandling();
	}

	@Test (priority=11,
			description = "Test to verify that user should be able to do the browser specific action")
	public void explicitWaitConditions() throws InterruptedException  {
		//Different ExplicitWait Conditions handling
		d11.explicitWaitConditions();
	}
	
	@Test (priority=12,
			description = "Test to verify that user should be able to do the browser specific action")
	public void brokenLinkValidation() throws InterruptedException, IOException  {
		//Broken Link Validation 
		d12.brokenLinkValidation("https://www.amazon.in");
	}
	
	@Test (priority=13,
			description = "Test to verify that user should be able to do the browser specific action")
	public void mouseActionClass() throws InterruptedException  {
		//Mouse Action class usages 
		d13.mouseActionClass();
	}
	
	@Test (priority=14, 
			dataProvider= "loginCasesData", dataProviderClass = TC14_DataProviderInTestNg.class,
			description = "Test to verify that user should be able to do the browser specific action")
	public void dataProviderMethod(String userName, String passWord) throws InterruptedException {
		//DataProvider Class
		d14.dataProviderMethod(userName, passWord);
	}
	
	@Test (priority=15,
			description = "Test to verify that user should be able to do the browser specific action")
	public void multipleTabAndWindows() throws InterruptedException  {
		//Handling multiple Tab and Windows
		d15.multipleWindow();
		d15.multipleTab();
	}
	
	@Test (priority=16,
			description = "Test to verify that user should be able to do the browser specific action")
	public void sslCertificateMethod() throws InterruptedException  {
		//Accepting SSL Certificate
		d16.sslCertificateMethod();
	}
	
}
