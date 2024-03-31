package com.DemoQA.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.TestBase.TestBase;

public class TC02_ElementHandeling extends TestBase {
	
	public TC02_ElementHandeling () {
		PageFactory.initElements(driver, this);
	}
	
	//------------ Xpath Repository -------------
	
	@FindBy (xpath = "//input[@id=\"userName\"]")
	private WebElement txtbox_fullName_elementPage;
		
	
	
	//------------ Action Methods -------------	
	
	public void actionOnElements() {
		
		
		
	}

}
