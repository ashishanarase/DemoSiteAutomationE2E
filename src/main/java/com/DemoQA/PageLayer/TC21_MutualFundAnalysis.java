package com.DemoQA.PageLayer;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

import utilityPackage.DataProvider;

public class TC21_MutualFundAnalysis extends TestBase {

	//this is sample class

	public TC21_MutualFundAnalysis () {
		PageFactory.initElements(driver, this);
	}

	//Required variables
	private String currentUrl = "https://upstox.com/mutual-funds/";

	private String filePath = userDirectory+"DataFiles\\MutualFundTracker.xlsx";

	private String fundName1; 
	private String fundName2; 
	private String fundName3; 
	private String fundName4; 

	private String highValue1; 
	private String highValue2; 
	private String highValue3; 
	private String highValue4;

	private String currentValue1; 
	private String currentValue2; 
	private String currentValue3; 
	private String currentValue4;





	//------------ Xpath Repository -------------

	// Using @FindBy to locate a single element by ID
	@FindBy(xpath = "//input[@id='navbar-search-input']")
	private WebElement txtBox_searchBox_homePage;

	@FindBy(xpath = "//button[@class='tabItem activeTabItem']/following::div[3]")
	private WebElement dd_option1_homePage;	
	
	@FindBy(xpath = "//h2[text()='Fund Info']")
	private WebElement txt_fundInfo_homePage;

	@FindBy(xpath = "//div[text()='NAV']/following::div[1]")
	private WebElement txt_dateStamp_homePage;

	@FindBy(xpath = "//div[text()='NAV']/following::div[3]")
	private WebElement txt_currentNAV_homePage;

	@FindBy(xpath = "//div[@class='resultInfo']")
	private WebElement dd__homePage;

	//------------ Action Methods -------------	

	public void analysisOne() {


		try {

			driver.get(currentUrl);

			fundName1 = action.readExcel(filePath, 2, 2);

			fundName2 = action.readExcel(filePath, 2, 3);

			fundName3 = action.readExcel(filePath, 2, 4);

			fundName4 = action.readExcel(filePath, 2, 5);


			highValue1 = action.readExcel(filePath, 3, 2);

			highValue2 = action.readExcel(filePath, 3, 3);

			highValue3 = action.readExcel(filePath, 3, 4);

			highValue4 = action.readExcel(filePath, 3, 5);

			System.out.println(fundName1);

			System.out.println(fundName2);

			System.out.println(fundName3);

			System.out.println(fundName4);


			System.out.println(highValue1);

			System.out.println(highValue2);

			System.out.println(highValue3);

			System.out.println(highValue4);


			action.enterText(txtBox_searchBox_homePage, fundName1);

			Thread.sleep(2000);

			action.jClickButton(dd_option1_homePage);
			
			action.jScrollToView(txt_fundInfo_homePage);

			String dateStamp = txt_dateStamp_homePage.getText();

			String textNAV = txt_currentNAV_homePage.getText();

			int currentNAV = Integer.parseInt(dateStamp.substring(1));
				
			System.out.println(dateStamp);

			System.out.println(currentNAV);

		} 
		
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Method failed : logOut();");
			throw new RuntimeException("Method failed : logOut(); due to an Exception : ", e); // Re-throw the exception to be caught globally
		}
	}


//Class Brace
}
