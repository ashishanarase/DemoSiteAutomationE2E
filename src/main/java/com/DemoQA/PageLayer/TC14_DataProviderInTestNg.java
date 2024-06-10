package com.DemoQA.PageLayer;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.DemoQA.TestBase.TestBase;

public class TC14_DataProviderInTestNg extends TestBase {
	
	//this is sample class
	
	public TC14_DataProviderInTestNg () {
		PageFactory.initElements(driver, this);
	}
	
	//------------ Xpath Repository -------------
	
	// Using @FindBy to locate a single element by ID
 //   @FindBy(xpath = " ")
//    private WebElement prefix_name_page;

   
    
	//------------ Action Methods -------------	
	
	@DataProvider
	public void loginCasesData() {
		
	}
	
	
	public void dataProviderMethod(String userName, String passWord) {
		
		driver.get("https://www.saucedemo.com");
		
		Duration time = driver.manage().timeouts().getPageLoadTimeout();
		
		System.out.println(time);
	}

}
