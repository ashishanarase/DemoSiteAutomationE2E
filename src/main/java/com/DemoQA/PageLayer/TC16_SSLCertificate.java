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
import com.aventstack.extentreports.Status;

public class TC16_SSLCertificate extends TestBase {

	public TC16_SSLCertificate () {
		PageFactory.initElements(driver, this);
	}

	private String currentUrl = "https://expired.badssl.com";

	//------------ Xpath Repository -------------


	//------------ Action Methods -------------	

	public void sslCertificateMethod() {
		try {
			//Create instance of ChromeOptions Class
			ChromeOptions handlingSSL = new ChromeOptions();

			//Using the accept insecure cert method with true as parameter to accept the untrusted certificate
			handlingSSL.setAcceptInsecureCerts(true);

			//Creating instance of Chrome driver by passing reference of ChromeOptions object
			WebDriver driver1 = new ChromeDriver(handlingSSL);

			//Launching the URL
			driver1.get(currentUrl);

			Thread.sleep(3000);

			extentTest.get().log(Status.INFO, "The page title is : " + driver.getTitle());

			extentTest.get().log(Status.PASS, "Method executed successfully : sslCertificateMethod();");

			driver1.quit();
		} 
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Method failed : sslCertificateMethod();");
			throw new RuntimeException("Method failed : sslCertificateMethod(); due to an Exception : ", e); // Re-throw the exception to be caught globally
			
		}

	}
}


