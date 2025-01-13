package uiElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Hover extends BaseTest{
	
	@Test
	public void TestHover() throws InterruptedException{
		driver.get(URL);
		driver.findElement(By.xpath("//a[contains(text(),'Hovers')]")).click();
		List<WebElement> images = driver.findElements(By.cssSelector(".figure"));
		Actions action = new Actions(driver);
		for(WebElement image:images) {
			action.moveToElement(image).perform();

			Assert.assertEquals(image.findElement(By.cssSelector(".figcaption")).isDisplayed(), true);
			
		}
		
		Thread.sleep(3000);
	}
}
