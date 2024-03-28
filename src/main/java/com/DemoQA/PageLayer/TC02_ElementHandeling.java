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
		
	@FindBy (xpath= "//input[@id=\"userEmail\"]")
	private WebElement txtbox_userEmail_elementPage;
	
	@FindBy (xpath= "//label[text()=\"Current Address\"]//following::textarea[1]")
	private WebElement txtbox_currentAddress_elementPage;
	
	@FindBy (xpath= "//label[text()=\"Permanent Address\"]//following::textarea[1]")
	private WebElement txtbox_permanentAddress_elementPage;
	
	@FindBy (xpath = "//button[@id=\"submit\"]")
	private WebElement btn_submit_elementPage;
	
	//------------ Action Methods -------------	
	
	public void actionOnElements() {
		
		txtbox_fullName_elementPage.sendKeys("Ashish Anarase");
		txtbox_userEmail_elementPage.sendKeys("anaraseashish@gmail.com");
		txtbox_currentAddress_elementPage.sendKeys("Andheri East, Mumbai, Maharashtra");
		txtbox_permanentAddress_elementPage.sendKeys("India, World");
		btn_submit_elementPage.submit();
	}

}
