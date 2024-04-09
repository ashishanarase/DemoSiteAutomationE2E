package com.DemoQA.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.ExtentReports;


public class TC06_ExtentReportExample extends TestBase {

	//Extent Report Example

	public TC06_ExtentReportExample () {
		PageFactory.initElements(driver, this);
	}
	//------------ Xpath Repository -------------

	@FindBy (xpath = " ")
	private WebElement txtbox_userName_homePage;

	//------------ Action Methods -------------	

	/* public void extentReportExample() {
		
		ExtentHtmlReporter report  = new ExtentHtmlReporter("ExtentReport.html");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);

		ExtentTest test = extent.createTest("This is sample Test");

		String url = "https://www.google.com/";
		driver.get(url);
		test.pass("This step shows usage of pass (details)=Navigated to google");

		WebElement txtBox_search_homePage = driver.findElement(By.xpath("//textarea[@role=\"combobox\"]"));
		txtBox_search_homePage.sendKeys("Automation Test");
		test.pass("This step shows usage of pass (details)=Entered text to SearchBox");


		WebElement btn_search_homePage = driver.findElement(By.xpath("(//input[@name=\"btnK\"])[1]"));
		btn_search_homePage.click();

		test.log(Status.INFO, "This step shows usage of log (status, details)");

		test.info("This step shows usage of info (details)");

		test.pass("This step shows usage of pass (details)");

		driver.quit();
		test.pass("Browser Closed");
		test.info("Test Completed");
		extent.flush();
		//		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.jpg").build().);
	}  */
}
