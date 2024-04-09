package com.DemoQA.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.TestBase.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC07_IframeHandling extends TestBase {

	public TC07_IframeHandling () {
		PageFactory.initElements(driver, this);
	}

	//------------ Xpath Repository -------------

	@FindBy (xpath = "(//iframe[@frameborder=\"0\"])[1]")
	private WebElement ele_frameElement_iframe;

	@FindBy (xpath = "//button[@class='M6CB1c rr4y5c']")
	private WebElement btn_signout_homePage;

	//------------ Action Methods -------------	

	public void iframeHandling() throws InterruptedException {

		driver.get("https://google.com");

		Thread.sleep(2000);
		//switch to frame
		//WebElement ele_frameElement_iframe = driver.findElement(By.xpath("(//iframe[@frameborder='0'])[1]"));

		driver.switchTo().frame(ele_frameElement_iframe);

		//driver.findElement(By.xpath("//button[@class='M6CB1c rr4y5c']")).click();
		
		btn_signout_homePage.click();

		driver.quit();
	}
}