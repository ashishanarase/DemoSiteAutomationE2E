package com.DemoQA.TestCase;

import org.testng.annotations.Test;

import com.DemoQA.TestBase.TestBase;

public class TestCase extends TestBase {
	
	@Test
	public void TC01_openBrower() throws InterruptedException {
		d1.actionOnBrowser();
		d1.titleValidation("DEMOQA");		
	}
	@Test 
	public void TC02_elementAction() {
		d1.titleValidation("DEMOQA");
		d1.navigateToElements();
		d2.actionOnElements();
	}

}
