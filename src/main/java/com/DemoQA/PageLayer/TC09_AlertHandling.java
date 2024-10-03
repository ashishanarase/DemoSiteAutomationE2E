package com.DemoQA.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

public class TC09_AlertHandling extends TestBase {

	//Different Type of Alert and Handling them

	public TC09_AlertHandling () {
		PageFactory.initElements(driver, this);
	}

	//------------ Required Variables -----------
	
	private String textForSendKeys =  "Automation Entered Text";
	
	//------------ Xpath Repository -------------

	@FindBy (xpath = "//button[@onclick='windowAlertFunction()']")       	
	private WebElement btn_simpleAlert_homePage;

	@FindBy (xpath = "//button[@onclick='promptAlertFunction()']")      		 //tagname[text()="text_value"]
	private WebElement btn_promtAlert_homePage;

	@FindBy (xpath = "//span[text()='Admin']")      		 //tagname[text()="text_value"]
	private WebElement txtBox_fullName1_dashboard;

	//------------ Action Methods -------------	

	public void alertHandling() {

		try {

			driver.get("https://selectorshub.com/xpath-practice-page/");

			extentTest.get().log(Status.PASS, "Navigated to SelectorsHub xPath page");

			extentTest.get().log(Status.INFO, "Clicking on element to get simple alert");

			action.clickButton(btn_simpleAlert_homePage);

			action.alertAccept();

			extentTest.get().log(Status.PASS, "Validation successful : Simple alert (Accept)");

			extentTest.get().log(Status.INFO, "Clicking on element to get simple alert");

			action.clickButton(btn_simpleAlert_homePage);

			action.alertDismiss();
			
			extentTest.get().log(Status.PASS, "Validation successful : Simple alert (Dismiss)");

			extentTest.get().log(Status.INFO, "Clicking on element to get promt alert");

			action.clickButton(btn_promtAlert_homePage);

			action.alertSendkeysAccept(textForSendKeys);

			extentTest.get().log(Status.PASS, "Validation successful : Prompt alert (Accept)");
		
			extentTest.get().log(Status.PASS, "Method executed successfully : alertHandling();");

		} 
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Method failed : alertHandling();");
			throw e; // Re-throw the exception to be caught globally
		}
	} 

//Class Brace	
}