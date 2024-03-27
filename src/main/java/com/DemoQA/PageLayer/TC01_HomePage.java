package com.DemoQA.PageLayer;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.DemoQA.TestBase.TestBase;

public class TC01_HomePage extends TestBase {

	//------------ Xpath Repository -------------

	@FindBy (xpath = " ")
	private WebElement txtbox_userName_homePage;

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

	}

}
