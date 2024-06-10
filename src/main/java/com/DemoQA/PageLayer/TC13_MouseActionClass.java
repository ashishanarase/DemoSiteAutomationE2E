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
	
	@FindBy (xpath = "//button[@aria-label=\"Products\"]")
	private WebElement btn_products_homePage;
	
	@FindBy (xpath = "//button[@aria-label=\"Products\"]")
	private WebElement element_moveFrom_homePage;
	
	@FindBy (xpath = "//button[@aria-label=\"Products\"]")
	private WebElement element_moveTo_homePage;
	
	//------------ Action Methods -------------	
	
	public void mouseActionClass() throws InterruptedException {
		
		driver.get("https://www.browserstack.com/guide");
		
		Actions action = new Actions (driver);
		
		//Conventional click
		action.click(btn_products_homePage).build().perform();
		
		Thread.sleep(2000);
		
		//Right click
		action.contextClick(btn_products_homePage).build().perform();
		
		Thread.sleep(2000);
		
		//Double click
		action.doubleClick(btn_products_homePage).build().perform();
		
		Thread.sleep(2000);
		
		//Mouse over 
		action.moveToElement(btn_products_homePage).build().perform();
		
		Thread.sleep(2000);
		
		//Drag and Drop
		action.dragAndDrop(element_moveFrom_homePage, element_moveTo_homePage).build().perform();
		
		Thread.sleep(2000);
		
		//Click and Hold
		action.clickAndHold(element_moveFrom_homePage).build().perform();
		
		Thread.sleep(2000);
		
		//Releases the left click (which is in the pressed state)
		action.release().build().perform();
		
		
		
	}

}
