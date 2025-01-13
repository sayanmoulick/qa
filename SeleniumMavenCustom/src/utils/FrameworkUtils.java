package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import constants.FrameworkConstants;

public class FrameworkUtils {
	public static Properties properties;
	
	public static String readConfigurationFile(String configKey) {
		properties = new Properties();
		System.out.println(">");
		try {
			System.out.println(">>");
			properties.load(new FileInputStream(FrameworkConstants.CONFIG_FILE_PATH));
			System.out.println(">>>");
		} catch (Exception e) {
			System.out.println("Error reading configuration file with exception :" + e);
		}
		return properties.getProperty(configKey).trim();
	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		// read json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		// String to HashMap- Jackson Databind

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

		// {map, map}

	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
}
