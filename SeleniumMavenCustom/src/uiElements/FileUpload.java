package uiElements;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class FileUpload extends BaseTest {

	@Test
	public void TestFileUpload() throws InterruptedException{
		driver.get(URL);
		driver.findElement(By.xpath("//a[contains(text(),'File Upload')]")).click();
		WebElement uploadFileLink = driver.findElement(By.cssSelector("input#file-upload"));
		uploadFileLink.sendKeys(System.getProperty("user.dir") + File.separator + "src" + File.separator + "resources" + File.separator + "Feed _ LinkedIn_delloite.pdf");
		WebElement uploadSubmit = driver.findElement(By.cssSelector("input[type='submit']"));
		uploadSubmit.click();
		
		Thread.sleep(5000);
	}
}
