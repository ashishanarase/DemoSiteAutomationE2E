package com.DemoQA.PageLayer;

import java.util.Set;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;
import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

public class TC15_MultipleWindowsAndTabHandling extends TestBase {

	//this is sample class

	public TC15_MultipleWindowsAndTabHandling () {
		PageFactory.initElements(driver, this);
	}

	private String currentUrl = "https://www.google.com/";
	private String currentUrl2 = "https://www.lambdatest.com/";
	private String currentUrl3 = "https://www.youtube.com/";
	private String currentUrl4 ="https://www.flipkart.com/";

	//------------ Xpath Repository -------------

	// Using @FindBy to locate a single element by ID



	//------------ Action Methods -------------	

	public void multipleWindow() {

		try{

			driver.get(currentUrl);

			// Opens a new window and switches to new window
			String title1 = driver.getTitle();

			extentTest.get().log(Status.PASS, "Script focus on : "+ title1);

			Thread.sleep(2000);

			driver.switchTo().newWindow(WindowType.WINDOW);

			// Opens LambdaTest homepage in the newly opened window
			driver.get(currentUrl2);

			String title2 = driver.getTitle();

			extentTest.get().log(Status.PASS, "Script focus on : "+ title2);

			Thread.sleep(2000);

			Set <String> list = driver.getWindowHandles();

			extentTest.get().log(Status.PASS, "List of window handles : "+ list);

			extentTest.get().log(Status.PASS, "Method executed successfully : multipleWindow();");

		} 
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Method failed : multipleWindow();");
			throw new RuntimeException("Method failed : multipleWindow(); due to an Exception : ", e); // Re-throw the exception to be caught globally
		}

	}

	public void multipleTab() {
		try {

			driver.get(currentUrl3);

			// Opens a new window and switches to new window
			String title1 = driver.getTitle();

			extentTest.get().log(Status.INFO, "Script focus on : "+ title1);

			driver.switchTo().newWindow(WindowType.TAB);

			// Opens Flipkart homepage in the newly opened window
			driver.get(currentUrl4);

			String title2 = driver.getTitle();

			extentTest.get().log(Status.INFO, "Script focus on : "+ title2);

			Set <String> list = driver.getWindowHandles();

			extentTest.get().log(Status.INFO, "List of tab handles : "+ list);

			extentTest.get().log(Status.PASS, "Method executed successfully : multipleTab();");

		} 
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Method failed : multipleTab();");
			throw e; // Re-throw the exception to be caught globally
		}

	}


//Class Brace	
}
