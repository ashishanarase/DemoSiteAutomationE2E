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
			
			extentTest.get().log(Status.INFO, "Clicking on simple alert to do accept action");
			
			action.clickButton(btn_simpleAlert_homePage);
			
			extentTest.get().log(Status.INFO, "Capturing the alert message");
			//To capture the alert message
			String alertMessage1 = driver.switchTo().alert().getText();
			
			extentTest.get().log(Status.PASS, "Simple alert message captured successfully : "+alertMessage1);
			
			//To click on the OK button of alert popup
			driver.switchTo().alert().accept();
			
			extentTest.get().log(Status.PASS, "Simple Alert successfully closed with OK button");
			
			extentTest.get().log(Status.INFO, "Clicking on simple alert to do dismiss action");
			
			action.clickButton(btn_simpleAlert_homePage);
			
			driver.switchTo().alert().dismiss();
			
			extentTest.get().log(Status.PASS, "Simple Alert successfully closed with Cancel button");			
			
			extentTest.get().log(Status.INFO, "Clicking on promt alert to do sendkeys action");
			
			action.clickButton(btn_promtAlert_homePage);
			
			String alertMessage2 = driver.switchTo().alert().getText();
			
			extentTest.get().log(Status.PASS, "Promt alert message captured successfully : "+alertMessage2);
			
			//To send some text inputs in textBox present on prompt alert 
			driver.switchTo().alert().sendKeys("Automation Entered Text");
			
			driver.switchTo().alert().accept();
			
			extentTest.get().log(Status.INFO, "Prompt Alert successfully closed with OK button");
					
			boolean value = true;
			if (value = true) {
				extentTest.get().log(Status.PASS, "Alert handling successful");
			}  

		}
		catch(Exception e) {
			extentTest.get().log(Status.FAIL, "Alert handling failed !");
			throw e;
		}		
	} 
}