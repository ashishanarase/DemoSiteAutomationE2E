package com.DemoQA.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.TestBase.TestBase;

public class TC00_SampleClass extends TestBase {
	
	public TC00_SampleClass (){
		PageFactory.initElements(driver, this);
	}
	
	//------------ Xpath Repository -------------
	
	@FindBy (xpath = " ")
	private WebElement txtbox_userName_homePage;
	
	//------------ Action Methods -------------	
	
	public void sampleMethod() {
		
	}

}
