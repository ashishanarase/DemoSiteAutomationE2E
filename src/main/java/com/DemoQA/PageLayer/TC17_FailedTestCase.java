package com.DemoQA.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

public class TC17_FailedTestCase extends TestBase {

	public TC17_FailedTestCase () {
		PageFactory.initElements(driver, this);
	}


	// Using @FindBy to locate a single element by ID, Xpath etc

	@FindBy(xpath = "//input[@name='username']")
	private WebElement txtBox_userName_loginPage;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement txtBox_passWord_loginPage;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btn_login_loginPage;

	@FindBy(xpath = "//h6[text()='dashboard']//following::i[1]")
	private WebElement dd_logOut_dashboard;

	@FindBy(xpath = "(//a[@role='menuitem'])[4]")
	private WebElement btn_logOut_dashboard;

	@FindBy(xpath = "(//span[text()='Required'])[1]")
	private WebElement txt_requiredUsername_loginPage;

	@FindBy(xpath = "(//span[text()='Required'])[2]")
	private WebElement txt_requiredPassword_loginPage;

	@FindBy(xpath = "//p[text()='Invalid credentials']")
	private WebElement txt_invalidCredentials_loginPage;


	//---------------------Methods-----------------


	public void loginExpectedToFail(String userName, String passWord) {
		try {

			action.clickButton(btn_login_loginPage);

			action.enterText(txtBox_userName_loginPage, userName);

			action.enterText(txtBox_passWord_loginPage, passWord);

			action.clickButton(btn_login_loginPage);

			Assert.assertTrue(txt_invalidCredentials_loginPage.isSelected());

			extentTest.get().log(Status.PASS, "Method executed successfully : loginExpectedToFail();");

		} 
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Method failed : loginExpectedToFail();");
			throw e; // Re-throw the exception to be caught globally
		}
	}
}
