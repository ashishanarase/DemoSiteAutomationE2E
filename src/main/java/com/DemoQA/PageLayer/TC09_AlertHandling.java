package com.DemoQA.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.TestBase.TestBase;

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
		
		public void alertHandling() throws InterruptedException {
			
			driver.get("https://selectorshub.com/xpath-practice-page/");
			
			btn_simpleAlert_homePage.click();
			
			Thread.sleep(2000);
			
			//To capture the alert message
			String alertMessage1 = driver.switchTo().alert().getText();
			System.out.println(alertMessage1);
			
			//To click on the OK button of alert popup
			driver.switchTo().alert().accept();
			System.out.println("Simple Alert successfully closed with OK button");
			
			Thread.sleep(2000);
			
			btn_simpleAlert_homePage.click();
			
			Thread.sleep(2000);
			
			//To click on the Cancel button of alert popup
			driver.switchTo().alert().dismiss();
			System.out.println("Simple Alert successfully closed with Cancel button");
			
			btn_promtAlert_homePage.click();
			
			Thread.sleep(2000);
			
			String alertMessage2 = driver.switchTo().alert().getText();
			System.out.println(alertMessage2);
			
			//To send some text inputs in textBox present on prompt alert 
			driver.switchTo().alert().sendKeys("Automation Entered Text");
			
			Thread.sleep(2000);
			
			driver.switchTo().alert().accept();
			System.out.println("Prompt Alert successfully closed with OK button");
					
			
		}

	}