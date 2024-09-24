package com.DemoQA.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;


public class TC02_HomePage extends TestBase {
	
	//Login and Logout on Demo Website
	
	public TC02_HomePage () {
		PageFactory.initElements(driver, this);
	}


	//------------ Xpath Repository -------------
	// Using @FindBy to locate a single element by ID, Xpath etc
	@FindBy(xpath = "//input[@name='username']")
	private WebElement txtBox_userName_loginPage;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement txtBox_passWord_loginPage;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btn_login_loginPage;

	@FindBy(xpath = "(//img[@alt='profile picture'])[1]/following::i[1]")
	private WebElement dd_logOut_dashboard;

	@FindBy(xpath = "(//a[@role='menuitem'])[4]")
	private WebElement btn_logOut_dashboard;

	
	//---------------------Methods-----------------
	public void login(String userName, String passWord) {

		try {
			
			action.titleValidation("OrangeHRM");
			
			action.enterText(txtBox_userName_loginPage, userName);
			
			action.enterText(txtBox_passWord_loginPage, passWord);
			
			action.clickButton(btn_login_loginPage);
			
			boolean value = true;
			if (value = true) {
				extentTest.get().log(Status.PASS, "Login successful");
			} 
		} 
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Login failed !");
			  throw e; // Re-throw the exception to be caught globally
		}

	}

	public void logOut(){

		try {

			Thread.sleep(2000);
			
			action.clickButton(dd_logOut_dashboard);
		
			action.clickButton(btn_logOut_dashboard);
			
			boolean value = true;
			if (value = true) {
				extentTest.get().log(Status.PASS, "LogOut successful");
			} 
		} 
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "LogOut failed !");	
			throw new RuntimeException("LogOut failed due to an Exception : ", e); // Re-throw the exception to be caught globally
		}
	}
}
