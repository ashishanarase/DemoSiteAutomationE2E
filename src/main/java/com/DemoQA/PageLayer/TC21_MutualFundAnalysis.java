package com.DemoQA.PageLayer;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

import io.opentelemetry.sdk.metrics.data.Data;
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

	private String value1; 
	private String value2; 
	private String value3; 
	private String value4;

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

	public void analysisOne() throws Exception {


		try {

			fundName1 = action.readExcel(filePath, 2, 2);

			fundName2 = action.readExcel(filePath, 2, 3);

			fundName3 = action.readExcel(filePath, 2, 4);

			fundName4 = action.readExcel(filePath, 2, 5);


			value1 = action.readExcel(filePath, 3, 2);
			
			value2 = action.readExcel(filePath, 3, 3);
			
			value3 = action.readExcel(filePath, 3, 4);

			value4 = action.readExcel(filePath, 3, 5);
			
			double highValue1 = Double.parseDouble(value1);
			
			double highValue2 = Double.parseDouble(value2);
			
			double highValue3 = Double.parseDouble(value3);
			
			double highValue4 = Double.parseDouble(value4);
			
			
			
			
			//First
			driver.get(currentUrl);
			action.enterText(txtBox_searchBox_homePage, fundName1);

			Thread.sleep(2000);

			action.jClickButton(dd_option1_homePage);
			
			action.jScrollToView(txt_fundInfo_homePage);

			String textNAV1 = txt_currentNAV_homePage.getText();
			
			double currentNAV1 = Double.parseDouble(textNAV1.substring(1));	
			
			action.writeExcelDouble(filePath, 4, 2, currentNAV1);
			
			double highFromDown1 = (highValue1-currentNAV1)/highValue1;
			
			double roundedValue1 = DataProvider.extractTwoDecimalValue(highFromDown1);
			
			action.writeExcelDouble(filePath, 5, 2, roundedValue1);
			
			
			
			//Second
			driver.get(currentUrl);
			
			action.enterText(txtBox_searchBox_homePage, fundName2);

			Thread.sleep(2000);

			action.jClickButton(dd_option1_homePage);
			
			action.jScrollToView(txt_fundInfo_homePage);

			String textNAV2 = txt_currentNAV_homePage.getText();
			
			double currentNAV2 = Double.parseDouble(textNAV2.substring(1));	
			
			action.writeExcelDouble(filePath, 4, 3, currentNAV2);
			
			double highFromDown2 = (highValue2-currentNAV2)/highValue2;
			
			double roundedValue2 = DataProvider.extractTwoDecimalValue(highFromDown2);
			
			action.writeExcelDouble(filePath, 5, 3, roundedValue2);
			
			
			
			//Third
			driver.get(currentUrl);
			
			action.enterText(txtBox_searchBox_homePage, fundName3);

			Thread.sleep(2000);

			action.jClickButton(dd_option1_homePage);
			
			action.jScrollToView(txt_fundInfo_homePage);

			String textNAV3 = txt_currentNAV_homePage.getText();
			
			double currentNAV3 = Double.parseDouble(textNAV3.substring(1));	
			
			action.writeExcelDouble(filePath, 4, 4, currentNAV3);
			
			double highFromDown3 = (highValue3-currentNAV3)/highValue3;
			
			double roundedValue3 = DataProvider.extractTwoDecimalValue(highFromDown3);
			
			action.writeExcelDouble(filePath, 5, 4, roundedValue3);
			
			
					
			//Fourth
			driver.get(currentUrl);
			
			action.enterText(txtBox_searchBox_homePage, fundName4);

			Thread.sleep(2000);

			action.jClickButton(dd_option1_homePage);
			
			action.jScrollToView(txt_fundInfo_homePage);

			String textNAV4 = txt_currentNAV_homePage.getText();
			
			double currentNAV4 = Double.parseDouble(textNAV4.substring(1));	
			
			action.writeExcelDouble(filePath, 4, 5, currentNAV4);
			
			double highFromDown4 = (highValue4-currentNAV4)/highValue4;
			
			double roundedValue4 = DataProvider.extractTwoDecimalValue(highFromDown4);
			
			action.writeExcelDouble(filePath, 5, 5, roundedValue4);	
			
			
			String timeStamp = DataProvider.getCurrentTimeStamp("dd-MMM-yyyy");
			
			action.writeExcelString(filePath, 2, 7, timeStamp);
			
			

		} 
		
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Method failed : logOut();");
			throw  e; // Re-throw the exception to be caught globally
		}
	}


//Class Brace
}
