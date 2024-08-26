package com.DemoQA.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.TestBase.TestBase;

public class TC13_MouseActionClass extends TestBase {
	
	//this is sample class
	
	public TC13_MouseActionClass () {
		PageFactory.initElements(driver, this);
	}
	
	//------------ Xpath Repository -------------
	
	@FindBy (xpath = "//button[text()='Hover Over Me First!']")
	private WebElement btn_hover1_homePage;
	
	@FindBy (xpath = "//button[text()='Hover Over Me Second!']")
	private WebElement btn_hover2_homePage;
	
	@FindBy (xpath = "//button[text()='Hover Over Me Third!']")
	private WebElement btn_hover3_homePage;
	
	@FindBy (xpath = "//a[text()='Link 1']")
	private WebElement btn_link1_homePage;
		
	@FindBy (id = "double-click")
	private WebElement btn_doubleClick_homePage;
		
	@FindBy (xpath = "//b[text()='DRAG ME TO MY TARGET!']")
	private WebElement btn_dragFrom_homePage;
	
	@FindBy (xpath = "//b[text()='DROP HERE!")
	private WebElement btn_dragTo_homePage;
	
	@FindBy (xpath = "Click and Hold!")
	private WebElement btn_clickAndHold_homePage;
	
	//------------ Action Methods -------------	
	
	public void mouseActionClass() throws InterruptedException {
		
		driver.get("https://webdriveruniversity.com/Actions/index.html");
		
		Actions action = new Actions (driver);
		
		//Conventional click
	//	action.click(btn_link1_homePage).build().perform();
		
		Thread.sleep(2000);
		
		//Right click
	//	action.contextClick().build().perform();
		
		Thread.sleep(2000);
		
		//Double click
		action.doubleClick(btn_doubleClick_homePage).build().perform();
		
		Thread.sleep(2000);
		
		//Mouse over 
		action.moveToElement(btn_hover1_homePage).build().perform();
		
		Thread.sleep(2000);
		
		//Drag and Drop
	//	action.dragAndDrop(btn_dragFrom_homePage, btn_dragTo_homePage).build().perform();
		
		Thread.sleep(2000);
		
		//Click and Hold
		action.clickAndHold(btn_clickAndHold_homePage).build().perform();
		
		System.out.println("Object is clicked and Hold");
		
		Thread.sleep(2000);
		
		//Releases the left click (which is in the pressed state)
		action.release().build().perform();
	
		
	}

}
