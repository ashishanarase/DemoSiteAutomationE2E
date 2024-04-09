package com.DemoQA.PageLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.TestBase.TestBase;

public class TC03_WindowHandling extends TestBase {
	
	//Difference between getWindowHandle & getWindowHandles 
	//Window switch using Desired Index value and Title out of multiple windows
	
	public TC03_WindowHandling () {
		PageFactory.initElements(driver, this);
	}

	//------------ Xpath Repository ------------
	@FindBy (xpath = "(//a[@target=\"_blank\"])[1]")
	private WebElement btn_handle1_homePage;
	
	@FindBy (xpath = "(//a[@target=\"_blank\"])[2]")
	private WebElement btn_handle2_homePage;
	
	@FindBy (xpath = "(//a[@target=\"_blank\"])[3]")
	private WebElement btn_handle3_homePage;
	
	@FindBy (xpath = "(//a[@target=\"_blank\"])[4]")
	private WebElement btn_handle4_homePage;
	

	//------------ Action Methods ------------
	
	public void WindowHandling () throws InterruptedException {
				
		Thread.sleep(1000);
		String parentHandle = driver.getWindowHandle();
		Thread.sleep(1000);
		btn_handle1_homePage.click();
		Thread.sleep(2000);
		btn_handle2_homePage.click();
		Thread.sleep(2000);
		btn_handle3_homePage.click();
		Thread.sleep(2000);
		btn_handle4_homePage.click();
		
		
		Set <String> handles = driver.getWindowHandles();
		List <String> handlesList = new ArrayList<String>(handles);
		
		System.out.println(handlesList);
		
		for (String desiredHandle : handlesList) {
			String title = driver.switchTo().window(desiredHandle).getTitle();
			System.out.println(title);
			if (title.contains("Facebook")) {
				System.out.println("Switched to Desired Window");
				Thread.sleep(3000);				
			}
		}
		
		driver.switchTo().window(parentHandle);
		
		driver.close();
		
	}
	
}
