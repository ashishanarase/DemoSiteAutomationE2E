package utilityPackage;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerClass extends TestBase implements ITestListener {
	
    public static ExtentReports extent;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
   
    public static void setDriver(WebDriver driverInstance) {
        driver = driverInstance;
        CommonMethods.setDriver(driverInstance); // Set the driver for CommonMethods
    }

    @Override
    public void onStart(ITestContext context) {
        // Initialize ExtentReports before any test starts
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(userDirectory+"Report\\ExtentReport_"+DetailsDataProvider.getCurrentTimeStamp()+".html");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Demo Automation Project");
        htmlReporter.config().setReportName("Demo Automation Report_"+DetailsDataProvider.getCurrentTimeStamp());

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "AshishAnarase");
        extent.setSystemInfo("User Name", "ashish.anarase");
        extent.setSystemInfo("Environment", "Demo Automation");
    }

    @Override
    public void onFinish(ITestContext context) {
        // Close ExtentReports after all tests are done
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Start a new extentTest for each test method
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);

        test.log(Status.INFO, "Test Started : " + result.getMethod().getMethodName());
        test.log(Status.INFO, "Test Description : " + result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "TestCase Passed : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().log(Status.FAIL, "TestCase Failed : " + result.getName());
        extentTest.get().log(Status.FAIL, "TestCase Failed : " + result.getThrowable());

        try {
            String screenshotPath = CommonMethods.takeScreenShot(driver, result.getName());
            extentTest.get().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "TestCase Skipped : " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Optional implementation
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }
}