package com.DemoQA.PageLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

	private String currentUrl = "https://webdriveruniversity.com/index.html";
	
	private String expectedTxt_holdElement = "Well done! keep holding that click now.....";
	
	private String txt_desiredTitle = "Actions";
	
	private int value1 = 100; 
	
	private int value2 = 200;

	//------------ Xpath Repository -------------

	@FindBy (xpath = "//h1[text()='ACTIONS']")
	private WebElement btn_actionUrl_homePage;

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

	@FindBy (id="click-box")
	private WebElement text_holdClick_homePage;

	@FindBy (xpath = "//b[text()='DRAG ME TO MY TARGET!']")
	private WebElement btn_dragFrom_homePage;

	@FindBy (xpath = "//b[text()='DROP HERE!']")
	private WebElement btn_dragTo_homePage;

	@FindBy (xpath = "//p[text()='Click and Hold!']")
	private WebElement btn_clickAndHold_homePage;

	//------------ Action Methods -------------	

	public void mouseAction() {

		try {

			driver.get(currentUrl);
			
			action.actionClick(btn_actionUrl_homePage);			
			
			Set <String> handles = driver.getWindowHandles();
			List <String> handlesList = new ArrayList<String>(handles);

			for (String desiredHandle : handlesList) {
				String title = driver.switchTo().window(desiredHandle).getTitle();
				
				if (title.contains(txt_desiredTitle)) {
	
				}
			}

			action.actionDoubleClick(btn_doubleClick_homePage);

			action.actionMouseOver(btn_hover1_homePage);	
			
			action.actionMouseOver(btn_hover2_homePage);	
			
			action.actionMouseOver(btn_hover3_homePage);	

			action.actionDragDrop(btn_dragFrom_homePage, btn_dragTo_homePage);

			action.jScrollToView(btn_clickAndHold_homePage);
			
			action.actionHold(btn_clickAndHold_homePage);		

			action.textValidation(text_holdClick_homePage, expectedTxt_holdElement);

			action.actionRelease(text_holdClick_homePage);
			
			action.actionMoveToCoordinate(value1, value2);

			extentTest.get().log(Status.PASS, "Method executed successfully : mouseAction();");

		} 
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Method failed : mouseAction();");
			throw e; // Re-throw the exception to be caught globally
		}

	}

}
