package com.DemoQA.TestCase;

import org.testng.annotations.Test;

import com.DemoQA.TestBase.TestBase;

import utilityPackage.commonMethods;

public class TestCase extends TestBase {
	
	@Test (priority=0, enabled=true, timeOut = 30000)
	public void actionOnBrowser() throws InterruptedException {
		d1.actionOnBrowser();
		commonMethods.titleValidation("OrangeHRM");	
	}
	
	@Test (priority=1, invocationCount = 2)
	public void loginLogOut() throws InterruptedException {
		d1.login();
		commonMethods.titleValidation("OrangeHRM");
		d1.logOut();
	}
	
	@Test (priority=2, dependsOnMethods = {"loginLogOut"})
	public void webElementAction () {
		d1.login();
		commonMethods.titleValidation("OrangeHRM");
		d2.actionOnElements();
		d1.logOut();
	}
	
	@Test (priority=3, description = "Difference between getWindowHandle & getWindowHandles")
	public void windowHandling() throws InterruptedException  {
		d3.WindowHandling();				
	}
	
	@Test (priority=4)
	public void clickOperationType() throws InterruptedException  {
		d4.clickOperationType();			
	}
	

}
