package com.DemoQA.TestCase;

import org.testng.annotations.Test;

import com.DemoQA.TestBase.TestBase;

import utilityPackage.commonMethods;

public class TestCase extends TestBase {
	
	@Test (priority=0, enabled=true, timeOut = 30000)
	public void actionOnBrowser() throws InterruptedException {
		//Dimension Class and Point Class usage
		d1.actionOnBrowser();
		commonMethods.titleValidation("OrangeHRM");	
	}
	
	@Test (priority=1, invocationCount = 2)
	public void loginLogOut() throws InterruptedException {
		//Login and Logout on Demo Website
		d1.login();
		commonMethods.titleValidation("OrangeHRM");
		d1.logOut();
	}
	
	@Test (priority=2, dependsOnMethods = {"loginLogOut"})
	public void webElementAction () {
		//Different Type of Xpath and Handling them
		d1.login();
		commonMethods.titleValidation("OrangeHRM");
		d2.actionOnElements();
		d1.logOut();
	}
	
	@Test (priority=3, description = "Difference between getWindowHandle & getWindowHandles")
	public void windowHandling() throws InterruptedException  {
		//Difference between getWindowHandle & getWindowHandles 
		//Window switch using Desired Index value and Title out of multiple windows
		d3.WindowHandling();				
	}
	
	@Test (priority=4)
	public void clickOperationType() throws InterruptedException  {
		//Different ways to perform click on webelement
		d4.clickOperationType();			
	}
	
	@Test (priority=5)
	public void dynamicTableStructure() throws InterruptedException  {
		//Get the number of Rows and Columns from table dynamically 
		d5.dynamicTableStructure();			
	}
	

}
