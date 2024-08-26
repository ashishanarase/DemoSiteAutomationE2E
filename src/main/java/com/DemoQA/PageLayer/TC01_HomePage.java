package com.DemoQA.PageLayer;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.TestBase.TestBase;


public class TC01_HomePage extends TestBase {
	
	//Dimension Class and Point Class usage
	//Login and Logout on Demo Website
	
	public TC01_HomePage () {
		PageFactory.initElements(driver, this);
	}

	//------------ Xpath Repository -------------

	@FindBy (xpath = "//input[@placeholder='Username']")
	private WebElement txtBox_userName_homePage;
	
	@FindBy (xpath = "//input[@placeholder='Password']")
	private WebElement txtBox_password_homePage;
	
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement btn_login_homePage;
		
	@FindBy (xpath = "//span[@class='oxd-userdropdown-tab']")
	private WebElement btn_userName_dashboard;
	
	@FindBy (xpath = "(//a[@role='menuitem'])[4]")
	private WebElement btn_logOut_dashboard;
	
	//------------ Action Methods -------------	

	public void actionOnBrowser() throws InterruptedException {

		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
		Dimension d = new Dimension(980, 580);
		driver.manage().window().setSize(d);

		Point positon = driver.manage().window().getPosition();
		System.out.println(positon);
		Point p = new Point (0,0);
		driver.manage().window().setPosition(p);

		Thread.sleep(3000);
		
		driver.manage().window().maximize();
		
	}

	public void login () {
		txtBox_userName_homePage.sendKeys("Admin");
		txtBox_password_homePage.sendKeys("admin123");
		btn_login_homePage.click();
	}
	
	public void logOut () {
		btn_userName_dashboard.click();
		btn_logOut_dashboard.click();
	}
	
}
