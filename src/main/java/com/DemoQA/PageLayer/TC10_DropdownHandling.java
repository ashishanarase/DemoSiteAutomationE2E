package com.DemoQA.PageLayer;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

public class TC10_DropdownHandling extends TestBase {

	//DropdownHandling and Get Dropdown Options Using Select Class 

	public TC10_DropdownHandling () {
		PageFactory.initElements(driver, this);
	}

	private String currentUrl = "https://www.amazon.in";

	//------------ Xpath Repository -------------

	@FindBy (xpath = "//select[@id='searchDropdownBox']")
	private WebElement btn_allOption_homePage;

	//------------ Action Methods -------------	

	public void dropdownHandling() throws InterruptedException {

		try {

			driver.get(currentUrl);

			extentTest.get().log(Status.PASS, "Navigated to Amazon home page");

			Select sObject = new Select(btn_allOption_homePage);

			List<WebElement> list = sObject.getOptions();

			int count = list.size();

			System.out.println(count);

			extentTest.get().log(Status.INFO, "Total option available in dropdown : "+count);

			for (int i = 0; i<count ; i++) {
				String dropdownList = list.get(i).getText();
				extentTest.get().log(Status.INFO, "Option "+i+" : "+dropdownList);
			}

			action.clickButton(btn_allOption_homePage);

			sObject.selectByIndex(5);

			String dropdownOption1 = list.get(5).getText();

			extentTest.get().log(Status.INFO, "Dropdown option with 'selectByIndex' method selected : "+dropdownOption1);

			driver.navigate().refresh(); 

			driver.get(currentUrl);

			action.clickButton(btn_allOption_homePage);

			sObject.selectByValue("search-alias=software");

			extentTest.get().log(Status.INFO, "Dropdown option with 'selectByValue' method selected : Software");

			driver.navigate().refresh(); 

			driver.get(currentUrl);

			action.clickButton(btn_allOption_homePage);

			sObject.selectByVisibleText("Music");

			extentTest.get().log(Status.INFO, "Dropdown option with 'selectByVisibleText' method selected : Music");


			boolean value = true;
			if (value = true) {
				extentTest.get().log(Status.PASS, "Dropdown handling successful");
			}  

		}
		catch(Exception e) {
			extentTest.get().log(Status.FAIL, "Dropdown handling failed !");
			throw e;
		}		

	}

}