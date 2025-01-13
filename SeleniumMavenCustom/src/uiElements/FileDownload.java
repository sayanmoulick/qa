package uiElements;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

public class FileDownload extends BaseTest{
	
	@Test
	public void TestFileDownload(){
		driver.get(URL);
		driver.findElement(By.xpath("//a[contains(text(),'File Download')]")).click();
	
		driver.findElement(By.cssSelector("a[href*='sample.pdf']")).click();
		
		waitForDownloadToComplete("sample.pdf");
		
		driver.findElement(By.cssSelector("a[href*='boat.jpg']")).click();
		
		waitForDownloadToComplete("boat.jpg");
		
		driver.findElement(By.cssSelector("a[href*='random_data.txt']")).click();
		
		waitForDownloadToComplete("random_data.txt");
	}
	
	public void waitForDownloadToComplete(String filename) {
		String filepath = new String( System.getProperty("user.dir")+ File.separator + "downloads" + File.separator + filename);
		File file = new File(filepath);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(25)).pollingEvery(Duration.ofMillis(100));
		wait.until( x -> file.exists());
	}
}
