package listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BasePage;
import uiElements.BaseTest;

public class ExtentReportListener extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent = getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //Thread safe
	
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);//unique thread id(ErrorValidationTest)->test
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());
		
		//Screenshot, Attach to report
		Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();
        
        String filePath = takeScreenShot(result.getMethod().getMethodName(),result.getEndMillis(),driver);
				
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}
	
	public static ExtentReports getReportObject()
	{
		String path =System.getProperty("user.dir")+ File.separator + "reports" + File.separator + "index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sayan Moulick");
		return extent;
	}
	
	private String takeScreenShot(String methodName, long timeStamp, WebDriver driver) {
        File screenShotName;
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//      String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        screenShotName = new File(System.getProperty("user.dir") + File.separator + 
				"screenshots" + File.separator + methodName + "_" + timeStamp + ".png");
        try {
            FileUtils.copyFile(scrFile, screenShotName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return System.getProperty("user.dir") + File.separator + 
		"screenshots" + File.separator + methodName + "_" + timeStamp + ".png";
    }
}
