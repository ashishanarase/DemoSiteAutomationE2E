package com.DemoQA.PageLayer;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.DemoQA.TestBase.TestBase;


public class TC01_HomePage extends TestBase {

	//------------ Xpath Repository -------------

	@FindBy (xpath = "//h5[text()=\"Elements\"]")
	private WebElement btn_elements_homePage;
	
	@FindBy (xpath = "//h5[text()=\"Forms\"]")
	private WebElement btn_forms_homePage;
	
	@FindBy (xpath = "//h5[text()=\"Alerts, Frame & Windows\"]")
	private WebElement btn_alertsFrameWindows_homePage;
	
	@FindBy (xpath = "//h5[text()=\"Widgets\"]")
	private WebElement btn_widgets_homePage;
	
	@FindBy (xpath = "//h5[text()=\"Interactions\"]")
	private WebElement btn_interactions_homePage;
	
	@FindBy (xpath = "//h5[text()=\"Book Store Application\"]")
	private WebElement btn_bookStoreApplication_homePage;

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
	
	public void titleValidation (String expectedTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Tab Title Validated");
		}
		else {
			System.out.println("Tab Title not matching with expected title");
		}
	}
	
	public void navigateToElements () {
		btn_elements_homePage.click();
	}
	
	public void navigateToForms () {
		btn_forms_homePage.click();
	}
	
	public void navigateToAlerts () {
		btn_alertsFrameWindows_homePage.click();
	}
	
	public void navigateToWidgets () {
		btn_widgets_homePage.click();
	}
	
	public void navigateToInteractions () {
		btn_interactions_homePage.click();
	}

	public void navigateToBookStoreApp () {
	btn_bookStoreApplication_homePage.click();
	}
}
