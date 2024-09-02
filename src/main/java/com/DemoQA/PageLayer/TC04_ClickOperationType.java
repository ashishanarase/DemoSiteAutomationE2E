package com.DemoQA.PageLayer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

public class TC04_ClickOperationType extends TestBase {

	//Different ways to perform click on webelement
	
	public TC04_ClickOperationType () {
		PageFactory.initElements(driver, this);
	}
	
	//------------ Xpath Repository -------------
	
		@FindBy (xpath = "(//a[@target='_blank'])[1]")
		private WebElement btn_handle1_homePage;
		
		@FindBy (xpath = "(//a[@target='_blank'])[2]")
		private WebElement btn_handle2_homePage;
		
		@FindBy (xpath = "(//a[@target='_blank'])[3]")
		private WebElement btn_handle3_homePage;
		
		@FindBy (xpath = "(//a[@target='_blank'])[4]")
		private WebElement btn_handle4_homePage;
		
	
	//------------ Action Methods -------------	
	
	public void clickOperationType() {
		
		try {
			
		action.clickButton(btn_handle1_homePage);
		
		extentTest.get().log(Status.PASS, "Click performed using conventional click(); method");		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btn_handle2_homePage);
		
		extentTest.get().log(Status.PASS, "Click performed using Javascript executor interface");
		
		Actions actions = new Actions(driver);
		actions.click(btn_handle3_homePage).perform();
		extentTest.get().log(Status.PASS, "Click performed using Actions class");
				
		btn_handle4_homePage.sendKeys(Keys.ENTER);
		extentTest.get().log(Status.PASS, "Click performed using Enter key");
		
		
		boolean value = true;
		if (value = true) {
			extentTest.get().log(Status.PASS, "Click operation type successful");
		} 
	} 
		catch(Exception e){
			extentTest.get().log(Status.FAIL, "Click operation type failed !");
			throw e;
		}
	}

}
