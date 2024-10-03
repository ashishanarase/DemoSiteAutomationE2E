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
	private String optionCount = "5";
	private String optionValue = "search-alias=software";
	private String optionText = "Music";

	//------------ Xpath Repository -------------

	//@FindBy (xpath="//div[@id='nav-search-dropdown-card']/descendant::select")
	@FindBy (xpath = "//select[@id='searchDropdownBox']")
	private WebElement btn_allOption_homePage;

	//------------ Action Methods -------------	

	public void dropdownHandling() {

		try {

			driver.get(currentUrl);

			extentTest.get().log(Status.PASS, "Navigated to Amazon home page");

			List<String> optionList = action.selectGetOptions(btn_allOption_homePage);

			int count = optionList.size();

			extentTest.get().log(Status.INFO, "Total option available in dropdown : "+count);

			for (int i = 0; i<count ; i++) {
				String option = optionList.get(i);
				extentTest.get().log(Status.INFO, "Option "+i+" : "+option);
			}

			action.selectDropdown(btn_allOption_homePage, optionCount);

			driver.navigate().refresh(); 

			driver.get(currentUrl);

			action.selectDropdown(btn_allOption_homePage, optionValue);

			driver.navigate().refresh(); 

			driver.get(currentUrl);

			action.selectDropdown(btn_allOption_homePage, optionText);

			extentTest.get().log(Status.PASS, "Method executed successfully : dropdownHandling();");

		} 
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Method failed : dropdownHandling();");
			throw e; // Re-throw the exception to be caught globally
		}

	}


//Class Brace	
}