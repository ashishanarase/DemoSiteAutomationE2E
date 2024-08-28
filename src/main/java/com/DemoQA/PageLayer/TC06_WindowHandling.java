package com.DemoQA.PageLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.TestBase.TestBase;

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

//
//public void WindowHandling () throws InterruptedException {
//
//	WebDriverManager.chromedriver().browserVersion(browserVersion).setup(); //.browserVersion(browserVersion)
//	WebDriver driver = new ChromeDriver();
//
//
//	driver.manage().window().maximize();
//	driver.manage().deleteAllCookies();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//	//Base Code
//	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//
//	Thread.sleep(1000);
//
//	WebElement btn_handle1_homePage = driver.findElement(By.xpath("(//a[@target='_blank'])[1]"));
//	WebElement btn_handle2_homePage = driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
//	WebElement btn_handle3_homePage = driver.findElement(By.xpath("(//a[@target='_blank'])[3]"));
//	WebElement btn_handle4_homePage = driver.findElement(By.xpath("(//a[@target='_blank'])[4]"));
//
//	String parentHandle = driver.getWindowHandle();
//	Thread.sleep(1000);
//	btn_handle1_homePage.click();
//	Thread.sleep(2000);
//	btn_handle2_homePage.click();
//	Thread.sleep(2000);
//	btn_handle3_homePage.click();
//	Thread.sleep(2000);
//	btn_handle4_homePage.click();
//
//	Set <String> handles = driver.getWindowHandles();
//	//We can convert the Set to a List or iterate over it to access elements
//	List <String> handlesList = new ArrayList<String>(handles);
//
//	System.out.println(handles);
//	for (int i = 0; i<=handles.size();i++) {
//
//		if (i==3) {
//
//			String desiredHandle = handlesList.get(i);
//
//			String title = driver.switchTo().window(desiredHandle).getTitle();
//			System.out.println(title);
//			if (title.contains("Facebook")) {
//				System.out.println("Switched to Desired Window");
//				Thread.sleep(3000);				
//			}
//		}
//	}
//
//	driver.switchTo().window(parentHandle);
//
//	driver.close();
//
//}
//
//}
