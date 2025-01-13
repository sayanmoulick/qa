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

import uiElements.BaseTest;

public class ScreenShotListener extends BaseTest implements ITestListener {
	@Override
	public void onStart(ITestContext contextStart) {
		System.out.println("onStart method started");
	}

	@Override
	public void onFinish(ITestContext contextFinish) {
		System.out.println("onFinish method finished");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Method failed with certain success percentage" + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Method failed" + result.getName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Method skipped" + result.getName());

	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Method started" + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();
        
		takeScreenShot(result.getMethod().getMethodName(),result.getEndMillis(),driver);
		
//		System.out.println("Method passed" + result.getName() + "Driver" + driver);
	}
	
	
	private void takeScreenShot(String methodName, long timeStamp, WebDriver driver) {
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
    }
}
