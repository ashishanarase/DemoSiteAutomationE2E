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
	
	private String timeStamp;
	
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

	private String lastValue1; 
	private String lastValue2; 
	private String lastValue3; 
	private String lastValue4;

	private String highValue1; 
	private String highValue2; 
	private String highValue3; 
	private String highValue4;

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

/*	public void analysisOne() throws Exception {


		try {
			
			timeStamp = DataProvider.getCurrentTimeStamp("dd-MMM-yyyy");

			fundName1 = action.readExcel(filePath, 2, 2);

			fundName2 = action.readExcel(filePath, 2, 3);

			fundName3 = action.readExcel(filePath, 2, 4);

			fundName4 = action.readExcel(filePath, 2, 5);


			value1 = action.readExcel(filePath, 3, 2);

			value2 = action.readExcel(filePath, 3, 3);

			value3 = action.readExcel(filePath, 3, 4);

			value4 = action.readExcel(filePath, 3, 5);


			lastValue1 = action.readExcel(filePath, 7, 2);

			lastValue2 = action.readExcel(filePath, 7, 3);

			lastValue3 = action.readExcel(filePath, 7, 4);

			lastValue4 = action.readExcel(filePath, 7, 5);


			double highValue1 = Double.parseDouble(value1);

			double highValue2 = Double.parseDouble(value2);

			double highValue3 = Double.parseDouble(value3);

			double highValue4 = Double.parseDouble(value4);


			double lastPurchased1 = Double.parseDouble(lastValue1);

			double lastPurchased2 = Double.parseDouble(lastValue2);

			double lastPurchased3 = Double.parseDouble(lastValue3);

			double lastPurchased4 = Double.parseDouble(lastValue4);


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

			lastPurchased1 = (currentNAV1-lastPurchased1)/lastPurchased1;

			double roundedPercent1 = DataProvider.extractTwoDecimalValue(lastPurchased1);

			action.writeExcelDouble(filePath, 8, 2, roundedPercent1);

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

			lastPurchased2 = (currentNAV2-lastPurchased2)/lastPurchased2;

			double roundedPercent2 = DataProvider.extractTwoDecimalValue(lastPurchased2);

			action.writeExcelDouble(filePath, 8, 3, roundedPercent2);



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

			lastPurchased3 = (currentNAV3-lastPurchased3)/lastPurchased3;

			double roundedPercent3 = DataProvider.extractTwoDecimalValue(lastPurchased3);

			action.writeExcelDouble(filePath, 8, 4, roundedPercent3);



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

			lastPurchased4 = (currentNAV4-lastPurchased4)/lastPurchased4;

			double roundedPercent4 = DataProvider.extractTwoDecimalValue(lastPurchased4);

			action.writeExcelDouble(filePath, 8, 5, roundedPercent4);


			
			//Updating current high changed
			if (currentNAV1>highValue1) {

				action.writeExcelDouble(filePath, 3, 2, currentNAV1);
				
				action.writeExcelString(filePath, 6, 2, timeStamp);

			}

			if (currentNAV2>highValue2) {

				action.writeExcelDouble(filePath, 3, 3, currentNAV2);
				
				action.writeExcelString(filePath, 6, 3, timeStamp);

			}

			if (currentNAV3>highValue3) {

				action.writeExcelDouble(filePath, 3, 4, currentNAV3);
				
				action.writeExcelString(filePath, 6, 4, timeStamp);

			}

			if (currentNAV4>highValue4) {

				action.writeExcelDouble(filePath, 3, 5, currentNAV4);
				
				action.writeExcelString(filePath, 6, 5, timeStamp);

			}

			//Last Date Updating

			

			action.writeExcelString(filePath, 2, 7, timeStamp);



		} 

		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Method failed : logOut();");
			throw  e; // Re-throw the exception to be caught globally
		}
	}
*/
	
	
	
	public void analyzeFunds() throws Exception {
	    try {
	        timeStamp = DataProvider.getCurrentTimeStamp("dd-MMM-yyyy");

	        // Read fund details and last purchased values into arrays
	        String[] fundNames = {
	            action.readExcel(filePath, 2, 2),
	            action.readExcel(filePath, 2, 3),
	            action.readExcel(filePath, 2, 4),
	            action.readExcel(filePath, 2, 5)
	        };

	        double[] highValues = {
	            Double.parseDouble(action.readExcel(filePath, 3, 2)),
	            Double.parseDouble(action.readExcel(filePath, 3, 3)),
	            Double.parseDouble(action.readExcel(filePath, 3, 4)),
	            Double.parseDouble(action.readExcel(filePath, 3, 5))
	        };

	        double[] lastPurchasedValues = {
	            Double.parseDouble(action.readExcel(filePath, 7, 2)),
	            Double.parseDouble(action.readExcel(filePath, 7, 3)),
	            Double.parseDouble(action.readExcel(filePath, 7, 4)),
	            Double.parseDouble(action.readExcel(filePath, 7, 5))
	        };

	        // Iterate over funds and perform analysis
	        for (int i = 0; i < fundNames.length; i++) {
	            analyzeSingleFund(fundNames[i], highValues[i], lastPurchasedValues[i], i + 2);
	        }

	        // Update last date
	        action.writeExcelString(filePath, 2, 7, timeStamp);

	    } catch (Exception e) {
	        extentTest.get().log(Status.FAIL, "Method failed : analyzeFunds()");
	        throw e; // Re-throw the exception to be caught globally
	    }
	}

	private void analyzeSingleFund(String fundName, double highValue, double lastPurchased, int columnIndex) throws Exception {
	    driver.get(currentUrl);

	    // Search and navigate to the fund
	    action.enterText(txtBox_searchBox_homePage, fundName);
	    Thread.sleep(2000);
	    action.jClickButton(dd_option1_homePage);
	    action.jScrollToView(txt_fundInfo_homePage);

	    // Fetch current NAV
	    String textNAV = txt_currentNAV_homePage.getText();
	    double currentNAV = Double.parseDouble(textNAV.substring(1));

	    // Write current NAV to Excel
	    action.writeExcelDouble(filePath, 4, columnIndex, currentNAV);

	    // Calculate and write high from down
	    double highFromDown = (highValue - currentNAV) / highValue;
	    action.writeExcelDouble(filePath, 5, columnIndex, DataProvider.extractTwoDecimalValue(highFromDown));

	    // Calculate and write last purchased percentage change
	    double lastPurchasedChange = (currentNAV - lastPurchased) / lastPurchased;
	    action.writeExcelDouble(filePath, 8, columnIndex, DataProvider.extractTwoDecimalValue(lastPurchasedChange));

	    // Update high value and timestamp if the current NAV exceeds the high value
	    if (currentNAV > highValue) {
	        action.writeExcelDouble(filePath, 3, columnIndex, currentNAV);
	        action.writeExcelString(filePath, 6, columnIndex, timeStamp);
	    }
	}


	//Class Brace
}
