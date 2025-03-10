package com.DemoQA.PageLayer;

import static org.testng.Assert.assertFalse;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

public class TC20_PixelToPixelMapping {

	WebDriver driver;

	String fileName = "ohrm_logo.png";	

	@FindBy (xpath="//img[@title='int-qus-home']")
	private WebElement element;

	public String path = "D:\\Ashish-All Data\\Data\\Automation Project BackUp\\DemoPro_DataFiles\\"+fileName;


	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void imageComparision() throws Exception {

		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		//		driver.get("https://automationtesting.in/");
		//		
		//		Thread.sleep(4000);
		//			

		BufferedImage expectedImage = ImageIO.read(new File(path));

		//Screenshot logoImage = new AShot().takeScreenshot(driver, element);

		Screenshot logoImage = new AShot()
				.coordsProvider(new WebDriverCoordsProvider())
				.takeScreenshot(driver, element);

		BufferedImage actualImage = logoImage.getImage();

		//System.out.println(actualPath);

		ImageDiffer imgDiffer = new ImageDiffer();

		ImageDiff difference = imgDiffer.makeDiff(expectedImage, actualImage);

		if (difference.hasDiff()==true) {
			System.out.println(true);
		}
		else {
			System.out.println(false);
		}

	}


	@Test
	public void imageComparision2() throws Exception {

		String exPath = "D:\\Ashish-All Data\\Data\\Automation Project BackUp\\DemoPro_DataFiles\\OrangeHRM_Orange.jpg";

		String acPath = "D:\\Ashish-All Data\\Data\\Automation Project BackUp\\DemoPro_DataFiles\\OrangeHRM_Orange - Copy.jpg";


		BufferedImage expectedImage = ImageIO.read(new File(exPath));		

		BufferedImage actualImage = ImageIO.read(new File(acPath));

		ImageDiffer imgDiffer = new ImageDiffer();

		ImageDiff difference = imgDiffer.makeDiff(expectedImage, actualImage);

		assertFalse(difference.hasDiff(), "Ekdam Same");

		if (difference.hasDiff()==true) {
			System.out.println("Not Same");
		}
		else {
			System.out.println("Ekdam Same");
		}

		driver.quit();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}


//Class Brace	
}

