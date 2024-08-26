package com.DemoQA.PageLayer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.TestBase.TestBase;

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
	
	public void clickOperationType() throws InterruptedException {
		btn_handle1_homePage.click();
		Thread.sleep(2000);
		System.out.println("Click performed using conventional Click(); method");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btn_handle2_homePage);
		Thread.sleep(2000);
		System.out.println("Click performed using Javascript Executor class");
		
		Actions actions = new Actions(driver);
		actions.click(btn_handle3_homePage).perform();
		Thread.sleep(2000);
		System.out.println("Click performed using Actions class");
		
		btn_handle4_homePage.sendKeys(Keys.ENTER);
		Thread.sleep(2000);	
		System.out.println("Click performed using Enter Key");
	}

}
