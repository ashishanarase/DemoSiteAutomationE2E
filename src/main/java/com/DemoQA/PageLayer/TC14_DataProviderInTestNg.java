package com.DemoQA.PageLayer;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.DemoQA.TestBase.TestBase;

public class TC14_DataProviderInTestNg extends TestBase {

	//this is sample class

	public TC14_DataProviderInTestNg () {
		PageFactory.initElements(driver, this);
	}

	//------------ Xpath Repository -------------

	// Using @FindBy to locate a single element by ID
	@FindBy(xpath = "//input[@placeholder=\"Username\"]")
	private WebElement txtBox_userName_homePage;

	@FindBy(xpath = "//input[@placeholder=\"Password\"]")
	private WebElement txtBox_passWord_homePage;

	@FindBy(id="login-button")
	private WebElement btn_login_homePage;

	//------------ Action Methods -------------	

	@DataProvider (name = "loginCasesData")
	public Object [][] loginCasesData() {

		Object [][] data = new Object[3][2];
		
		data[0][0] = "standard_user";
		data[0][1] = "secret_sauce";

		data[1][0] = "locked_out_user";
		data[1][1] = "secret_sauce";

		data[2][0] = "problem_user";
		data[2][1] = "secret_sauce";


		// Another Way to pass data
		//	Object [][] data = {{"standard_user","secret_sauce"},{"locked_out_user","secret_sauce"},{"problem_user","secret_sauce"}};

		return data;		
	}

	public void dataProviderMethod(String userName, String passWord) throws InterruptedException {

		driver.get("https://www.saucedemo.com");

		txtBox_userName_homePage.sendKeys(userName);

		Thread.sleep(2000);

		txtBox_passWord_homePage.sendKeys(passWord);

		Thread.sleep(2000);

		btn_login_homePage.click();

	}

}
