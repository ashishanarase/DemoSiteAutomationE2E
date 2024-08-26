package com.DemoQA.PageLayer;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.DemoQA.TestBase.TestBase;

public class TC10_DropdownHandling extends TestBase {

	//DropdownHandling and Get Dropdown Options Using Select Class 

	public TC10_DropdownHandling () {
		PageFactory.initElements(driver, this);
	}


	//------------ Xpath Repository -------------

	@FindBy (xpath = "//select[@id='searchDropdownBox']")
	private WebElement btn_allOption_homePage;

	//------------ Action Methods -------------	

	public void dropdownHandling() throws InterruptedException {
		driver.get("https://www.amazon.in/");

		Select sObject = new Select(btn_allOption_homePage);

		List<WebElement> list = sObject.getOptions();

		int count = list.size();

		System.out.println(count);

		for (int i = 0; i<count ; i++) {
			String dropdownList = list.get(i).getText();
			System.out.println(dropdownList);
		}

		btn_allOption_homePage.click();

		sObject.selectByIndex(5);
		Thread.sleep(2000);
		String dropdownOption1 = list.get(5).getText();
		System.out.println("Dropdown Option with Index method selected = "+dropdownOption1);

		driver.navigate().refresh(); 
		driver.get("https://www.amazon.in/");

		btn_allOption_homePage.click();

		sObject.selectByValue("search-alias=software");
		Thread.sleep(2000);
		System.out.println("Dropdown Option with Text Value selected = Software");

		driver.navigate().refresh(); 
		driver.get("https://www.amazon.in/");

		btn_allOption_homePage.click();

		sObject.selectByVisibleText("Music");
		Thread.sleep(2000);
		System.out.println("Dropdown Option with Visible text selected = Music");
	}

}