package base;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import constants.FrameworkConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.FrameworkUtils;

public class Webdriver{
	protected static WebDriver driver;
	private static String URL;
	
	public static WebDriver initilizeDriver() {

		URL = FrameworkUtils.readConfigurationFile("URL");
		if (URL.trim().length() > 0) {
			String browserName = FrameworkUtils.readConfigurationFile("BrowserName");
			if (browserName.trim().equalsIgnoreCase("firefox")) {
				System.setProperty(FrameworkConstants.FIREFOX_DRIVER_KEY, FrameworkConstants.FIREFOX_DRIVER_PATH);
				try {
					driver = new FirefoxDriver();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.manage().window().maximize();
			} else if (browserName.trim().equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();
//				System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY, FrameworkConstants.CHROME_DRIVER_PATH);
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "downloads");
				options.setExperimentalOption("prefs", prefs);
				
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				
				/*
				 * driver.manage().window().setSize(new Dimension(1440,900)); // customized
				 * driver.manage().window().fullscreen(); //full screen
				 */
			} else if (browserName.trim().equalsIgnoreCase("edge")) {
				System.setProperty(FrameworkConstants.EDGE_DRIVER_KEY, FrameworkConstants.EDGE_DRIVER_PATH);
				driver = new EdgeDriver();
				driver.manage().window().maximize();
			} else {
				System.out.println("Invalid BrowserName");
				throw new IllegalStateException("Failed to invoke WebBrowser.Invalid BrowserName..");
			}
		}
		return driver;

	}

//
//		driver.get("https://rahulshettyacademy.com");
//
//		System.out.println(driver.getTitle());
//
//		System.out.println(driver.getCurrentUrl());

//		ChromeOptions options = new ChromeOptions();
//
//		Proxy proxy = new Proxy();
//
//		proxy.setHttpProxy("ipaddress:4444");
//
//		options.setCapability("proxy", proxy);
//


	// FirefoxOptions options1 = new FirefoxOptions();

	// options1.setAcceptInsecureCerts(true);

	// EdgeOptions options2 = new EdgeOptions();

//		options.setAcceptInsecureCerts(true);
//
//
//		System.out.println(driver.getTitle());

}
