package com.DemoQA.PageLayer;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

public class TC01_ActionOnBrowser extends TestBase {

	//Extent Report Example

	public TC01_ActionOnBrowser() {
		PageFactory.initElements(driver, this);
	}
	//------------ Xpath Repository -------------

	@FindBy (xpath = " ")
	private WebElement txtbox_userName_homePage;

	//------------ Action Methods -------------	

	public void actionOnBrowser() throws InterruptedException {
		try {
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

			boolean value = true;
			if (value = true) {
				extentTest.get().log(Status.PASS, "Action On Browser Successful");
			} 
		} 
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Action On Browser Failed !");	
			throw e; // Re-throw the exception to be caught globally
		}

	}
} 

