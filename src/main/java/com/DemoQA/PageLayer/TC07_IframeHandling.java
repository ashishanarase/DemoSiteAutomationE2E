package com.DemoQA.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

public class TC07_IframeHandling extends TestBase {

	//Handling of Iframe on Google.com 

	public TC07_IframeHandling () {
		PageFactory.initElements(driver, this);
	}

	private String currentUrl = "https://google.com";

	//------------ Xpath Repository -------------

	@FindBy (xpath = "(//iframe[@frameborder='0'])[1]")
	private WebElement ele_frameElement_iframe;

	@FindBy (xpath = "//button[@class='M6CB1c rr4y5c']")
	private WebElement btn_signout_homePage;

	//------------ Action Methods -------------	

	public void iframeHandling() {

		try {

			driver.get(currentUrl);

			extentTest.get().log(Status.PASS, "Navigated to Google home page");

			driver.switchTo().frame(ele_frameElement_iframe);

			extentTest.get().log(Status.PASS, "Switched on iFrame of Google home page");

			action.clickButton(btn_signout_homePage);

			extentTest.get().log(Status.PASS, "Clicked on sign out button on iFrame of Google home page");

			extentTest.get().log(Status.PASS, "Method executed successfully : iframeHandling();");

		} 
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Method failed : iframeHandling();");
			throw e; // Re-throw the exception to be caught globally
		}
	}

//Class Brace	
}	
