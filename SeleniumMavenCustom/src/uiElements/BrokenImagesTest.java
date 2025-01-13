package uiElements;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class BrokenImagesTest extends BaseTest{


	private int validImageCount = 1;
//	private WebDriver driver;
//	private static String URL;
	
	@Test
	public void TestBrokenImages() throws InterruptedException, ClientProtocolException, IOException {
//		driver = Webdriver.initilizeDriver();
//		URL = FrameworkUtils.readConfigurationFile("URL");
		driver.get(URL);
		driver.findElement(By.cssSelector("a[href*='broken_images']")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'Broken Images')]")).click();
		List<WebElement> imageElemenets = driver.findElements(By.cssSelector("div.example img"));
		for (WebElement image : imageElemenets) {
			validateImage(image);
		}
		System.out.println("No. of broken images are : " + validImageCount);
		
	}

	private void validateImage(WebElement image) throws ClientProtocolException, IOException {

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet getRequest = new HttpGet(image.getAttribute("src"));
		HttpResponse response = client.execute(getRequest);
		if (response.getStatusLine().getStatusCode() == 200) {
			validImageCount++;
		}
	}

}
