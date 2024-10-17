package com.DemoQA.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

public class TC19_LoginLogoutDataDriven extends TestBase{

	public TC19_LoginLogoutDataDriven () {
		PageFactory.initElements(driver, this);
	}

	//Required variables
	private String currentUrl = "https://www.saucedemo.com";


	//------------ Xpath Repository -------------
	// Using @FindBy to locate a single element by ID, Xpath etc
	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement txtBox_userName_homePage;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement txtBox_passWord_homePage;

	@FindBy(id="login-button")
	private WebElement btn_login_homePage;



	//---------------------Methods-----------------
	public void navigateToProduct() {

		try {

			driver.get(currentUrl);



		} 
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Method failed : navigateToProduct();");
			throw e; // Re-throw the exception to be caught globally
		}

	}


}
