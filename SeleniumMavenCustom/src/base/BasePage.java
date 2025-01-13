package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FrameworkConstants;

public class BasePage {

	protected static WebDriver driver;
	protected WebDriverWait wait;
	protected static String URL;
	
	public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.TIMEOUT));
    }
	
	protected void waitForElementToAppear(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	protected void waitForElementToDisappear(By locator) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	protected void waitForTextToDisappear(By locator, String text) {
		wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
	}

	public static String takeScreenShot(String methodName, long timeStamp, WebDriver driver) {
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
