package uiElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DynamicContent extends BaseTest{

	@Test
	public void TestDynamicContent() throws InterruptedException {	
		driver.get(URL);		
		driver.findElement(By.xpath("//a[contains(text(),'Dynamic Content')]")).click();
		//To get direct descendants with 'row' class of div elements
		List<WebElement> dynamicContent = driver.findElements(By.cssSelector("div#content>div.row"));
		//To get the text from the 2nd row of dynamic content
		System.out.println(dynamicContent.get(1).findElement(By.cssSelector("div:nth-child(2)")).getText());		
		Thread.sleep(6000);
		driver.quit();
	}
}
