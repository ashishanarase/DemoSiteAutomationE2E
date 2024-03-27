package com.DemoQA.TestCase;

import org.testng.annotations.Test;

import com.DemoQA.TestBase.TestBase;

public class TestCase extends TestBase {
	
	@Test
	public void TC01_openBrower() throws InterruptedException {
		d1.actionOnBrowser();
	}

}
