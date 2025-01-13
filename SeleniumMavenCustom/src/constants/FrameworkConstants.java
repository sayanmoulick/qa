package constants;

import java.io.File;

public class FrameworkConstants {
	public static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + File.separator + "/src/resources/Config.properties";
	public static final String CHROME_DRIVER_KEY = "webdriver.chrome.driver";
	public static final String CHROME_DRIVER_PATH = "/home/sayan/Documents/automation_testing/webdriver/chrome/chromedriver-linux64-126.0.6478.62/chromedriver";
	public static final String EDGE_DRIVER_KEY = "webdriver.edge.driver";
	public static final String EDGE_DRIVER_PATH = "./Browser_Drivers/edege";
	public static final String FIREFOX_DRIVER_KEY = "webdriver.gecko.driver";
	public static final String FIREFOX_DRIVER_PATH= "./Browser_Drivers/geckodriver";
	public static final int OBJECT_LOAD_TIME_OUT = 60;
	public static final int PAGE_LOAD_TIME_OUT = 180;
	public static final int TIMEOUT = 5;
	public static final int POLLING = 100;
}
