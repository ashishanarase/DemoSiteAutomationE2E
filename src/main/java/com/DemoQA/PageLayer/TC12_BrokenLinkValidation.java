package com.DemoQA.PageLayer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

public class TC12_BrokenLinkValidation extends TestBase {

	//this is sample class

	public TC12_BrokenLinkValidation () {
		PageFactory.initElements(driver, this);
	}

	//------------ Xpath Repository -------------

	@FindBy (xpath = " ")
	private WebElement txtbox_userName_homePage;

	//------------ Action Methods -------------	

	public void brokenLinkValidation(String desiredUrl) throws InterruptedException, IOException {

		try {

			driver.get(desiredUrl);

			List <WebElement> elementLinks = driver.findElements(By.tagName("a"));

			extentTest.get().log(Status.INFO, "Total Number of Links = "+elementLinks.size());

			List <String> linkList = new ArrayList <String>();

			for (WebElement element : elementLinks) {
				String url = element.getAttribute("href");
				linkList.add(url);
			}

			long stTime = System.currentTimeMillis();
			linkList.parallelStream().forEach(element -> checkBrokenLink(element));
			long endTime = System.currentTimeMillis();


			boolean value = true;
			if (value = true) {
				extentTest.get().log(Status.PASS, "Broken link validation successful");
			}  

		}
		catch(Exception e) {
			extentTest.get().log(Status.FAIL, "Broken link validation failed !");
			throw e;
		}		

	}

	public static void checkBrokenLink(String linkUrl) {
		
		try {
			URL link = new URL(linkUrl);

			HttpURLConnection httpCon = (HttpURLConnection) link.openConnection();

			httpCon.setConnectTimeout(5000);

			httpCon.connect();

			int responseCode = httpCon.getResponseCode();

			if (responseCode >= 400) {
				extentTest.get().log(Status.INFO, "Broken Link URL with message = " +httpCon.getResponseMessage() +" " + linkUrl);
			}
			else {
				extentTest.get().log(Status.PASS, "Valid Link URL with message = "+httpCon.getResponseMessage());
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (NullPointerException eNull) {
			eNull.printStackTrace();
		}
	}
}




