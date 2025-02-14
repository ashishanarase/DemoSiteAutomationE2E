package com.DemoQA.PageLayer;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC22_SoftAsserationExample {

	@Test
	public void testSoftAssertions() {

		SoftAssert softAssert = new SoftAssert();

		System.out.println("Executing Step 1");
		softAssert.assertEquals(2 + 2, 5, "Step 1 Failed: 2+2 is not 5");

		System.out.println("Executing Step 2");
		softAssert.assertTrue(3 > 5, "Step 2 Failed: 3 is not greater than 5");

		System.out.println("Executing Step 3");
		softAssert.assertFalse("Hello".contains("Hi"), "Step 3 Failed: 'Hello' should not contain 'Hi'");

		// Collect and Report Failures
		softAssert.assertAll();  // 🚨 Reports all failures at once
	}
}

