package com.DemoQA.PageLayer;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

public class TC01_ActionOnBrowser extends TestBase {

	public TC01_ActionOnBrowser() {
		PageFactory.initElements(driver, this);
	}
	//------------ Xpath Repository -------------



	//------------ Action Methods -------------	


	public void actionOnBrowser() throws Exception {

		try {

			Dimension size = driver.manage().window().getSize();

			extentTest.get().log(Status.PASS, "Current size of browser : "+size);

			Dimension d = new Dimension(222, 989);

			driver.manage().window().setSize(d);

			Dimension sizeSet = driver.manage().window().getSize();

			extentTest.get().log(Status.PASS, "Set size of browser : "+sizeSet);

			Thread.sleep(3000);

			Point positon = driver.manage().window().getPosition();

			extentTest.get().log(Status.PASS, "Current position of browser : "+positon);

			Point p = new Point (0,0);

			driver.manage().window().setPosition(p);

			Point positonSet = driver.manage().window().getPosition();

			extentTest.get().log(Status.PASS, "Set position of browser : "+positonSet);

			Thread.sleep(3000);

			driver.manage().window().maximize();

			boolean value = true;
			if (value = true) {
				extentTest.get().log(Status.PASS, "Action on browser successful");
			} 
		} 
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Action on browser failed !");
			throw e; // Re-throw the exception to be caught globally
		}

	}
}