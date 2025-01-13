package uiElements;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import base.Webdriver;
import utils.FrameworkUtils;

public class BaseTest {
	protected WebDriver driver;
	protected static String URL;
	
	public WebDriver getDriver() {
        return this.driver;
    }
	
	@BeforeSuite
	public void lauchApplication() throws NoSuchFieldException {

	}
	
	/*****************************************************************************************************************/
	@AfterSuite
	public void quitDrivers() {
		

	}
	/************************************************************************************************************************/
	/*
	 * method.getName() returns the name of the current test method during run time.
	 * */
	@BeforeMethod
	public void beforeMethod(Method method) {
		

	}
	
	/****************************************************************************************************************/
	
	@AfterMethod
	public void afterMethod(Method method) {
		

	}

	/****************************************************************************************************************/
	
	@BeforeClass
	public void beforeClass() {
		driver = Webdriver.initilizeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		URL = FrameworkUtils.readConfigurationFile("URL");
//		driver.get(URL);
	}

	
/****************************************************************************************************************/	
	@AfterClass
	public void closeApplication(){
		driver.quit();

	}
/****************************************************************************************************************/

}
