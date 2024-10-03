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

			action.jClickButton(btn_handle2_homePage);
			
			action.actionClick(btn_handle3_homePage);
			
			action.enterKeys(btn_handle4_homePage, Keys.ENTER);

			extentTest.get().log(Status.PASS, "Method executed successfully : clickOperationType();");

		} 
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Method failed : clickOperationType();");
			throw e; // Re-throw the exception to be caught globally
		}
	}

//Class Brace	
}
