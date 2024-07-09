package com.DemoQA.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.DemoQA.TestBase.TestBase;

public class TC16_SSLCertificate extends TestBase {

	public TC16_SSLCertificate () {
		PageFactory.initElements(driver, this);
	}

	//------------ Xpath Repository -------------

	
	//------------ Action Methods -------------	

	public void sslCertificateMethod() throws InterruptedException {

		//Create instance of ChromeOptions Class
		ChromeOptions handlingSSL = new ChromeOptions();

		//Using the accept insecure cert method with true as parameter to accept the untrusted certificate
		handlingSSL.setAcceptInsecureCerts(true);

		//Creating instance of Chrome driver by passing reference of ChromeOptions object
		WebDriver driver1 = new ChromeDriver(handlingSSL);

		//Launching the URL
		driver1.get("https://expired.badssl.com/");
		
		Thread.sleep(3000);
		
		System.out.println("The page title is : " +driver.getTitle());
		
	}

}


