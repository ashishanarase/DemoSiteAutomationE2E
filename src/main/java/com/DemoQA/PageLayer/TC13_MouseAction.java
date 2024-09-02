package com.DemoQA.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

public class TC13_MouseAction extends TestBase {

	//this is sample class

	public TC13_MouseAction() {
		PageFactory.initElements(driver, this);
	}
	
	private String currentUrl = "https://webdriveruniversity.com/Actions/index.html";

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

	public void mouseAction() {

		try {

			driver.get(currentUrl);

			Actions actions = new Actions (driver);

			//Conventional click
			actions.click(btn_link1_homePage).build().perform();
			
			extentTest.get().log(Status.PASS, "Actions class : Object is clicked using click() method");

			//Right click
			actions.contextClick().build().perform();

			extentTest.get().log(Status.PASS, "Actions class : Right click using contextClick() method");
			
			//Double click
			actions.doubleClick(btn_doubleClick_homePage).build().perform();

			extentTest.get().log(Status.PASS, "Actions class : Double click using doubleClick() method");
			
			//Mouse over 
			actions.moveToElement(btn_hover1_homePage).build().perform();
			
			extentTest.get().log(Status.PASS, "Actions class : Moved to element using moveToElement() method");

			//Drag and Drop
			actions.dragAndDrop(btn_dragFrom_homePage, btn_dragTo_homePage).build().perform();

			extentTest.get().log(Status.PASS, "Actions class : Drag and drop using dragAndDrop() method");
			
			//Click and Hold
			actions.clickAndHold(btn_clickAndHold_homePage).build().perform();
			
			extentTest.get().log(Status.PASS, "Actions class : Hold on element using clickAndHold() method");


			extentTest.get().log(Status.PASS, "Object is clicked and Hold");

			//Releases the left click (which is in the pressed state)
			actions.release().build().perform();

			extentTest.get().log(Status.PASS, "Object is released at desired place");

			boolean value = true;
			if (value = true) {
				extentTest.get().log(Status.PASS, "Mouse action successful");
			}  

		}
		catch(Exception e) {
			extentTest.get().log(Status.FAIL, "Mouse action failed !");
			throw e;
		}		

	}

}
