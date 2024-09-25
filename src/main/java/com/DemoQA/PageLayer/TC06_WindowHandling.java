package com.DemoQA.PageLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

public class TC06_WindowHandling extends TestBase {

	//Difference between getWindowHandle & getWindowHandles 
	//Window switch using Desired Index value and Title out of multiple windows

	public TC06_WindowHandling () {
		PageFactory.initElements(driver, this);
	}

	//------------ Xpath Repository ------------
	@FindBy (xpath = "(//a[@target='_blank'])[1]")
	private WebElement btn_handle1_homePage;

	@FindBy (xpath = "(//a[@target='_blank'])[2]")
	private WebElement btn_handle2_homePage;

	@FindBy (xpath = "(//a[@target='_blank'])[3]")
	private WebElement btn_handle3_homePage;

	@FindBy (xpath = "(//a[@target='_blank'])[4]")
	private WebElement btn_handle4_homePage;


	//------------ Action Methods ------------

	public void windowHandling (){

		try {

			String parentHandle = driver.getWindowHandle();

			action.clickButton(btn_handle1_homePage);

			action.clickButton(btn_handle2_homePage);

			action.clickButton(btn_handle3_homePage);

			action.clickButton(btn_handle4_homePage);

			Set <String> handles = driver.getWindowHandles();
			List <String> handlesList = new ArrayList<String>(handles);

			for (String desiredHandle : handlesList) {
				String title = driver.switchTo().window(desiredHandle).getTitle();
				System.out.println(title);
				if (title.contains("Facebook")) {
					extentTest.get().log(Status.PASS, "Switched to fesired tab");
					Thread.sleep(3000);		
				}
			}

			driver.switchTo().window(parentHandle);

			driver.close();

			extentTest.get().log(Status.PASS, "Method executed successfully : windowHandling();");

		} 
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Method failed : windowHandling();");
			throw new RuntimeException("Method failed : windowHandling(); due to an Exception : ", e); // Re-throw the exception to be caught globally
		}

	}

}
