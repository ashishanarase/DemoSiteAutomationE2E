package com.DemoQA.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.TestBase.TestBase;

public class TC02_WebElementTypes extends TestBase {
	
	//Different Type of Xpath and Handling them
	
	public TC02_WebElementTypes () {
		PageFactory.initElements(driver, this);
	}
	
	//------------ Xpath Repository -------------
	
	@FindBy (xpath = "//input[@placeholder=\"Search\"]")  //tagname[@attribute="value"]
	private WebElement txtBox_searchBox_dashboard;
	
	@FindBy (xpath = "//span[text()=\"Admin\"]")      	 //tagname[text()="text_value"]
	private WebElement txtBox_fullName_dashboard;
		
	@FindBy (xpath = "//span[text()=\"Admin\"]")      	 //tagname[contains(text(),"text_value")]
	private WebElement txtBox_fullName1_dashboard;
	
														//tagname[contains(attribute,"text_value")]
	
	//------------ Action Methods -------------	
	
	public void actionOnElements() {
		txtBox_searchBox_dashboard.sendKeys("Admin");
		txtBox_fullName_dashboard.click();
		
		
	}

}
