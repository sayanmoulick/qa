package uiElements;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import org.testng.annotations.Test;
import org.testng.Assert;

public class DragAndDrop extends BaseTest{

	@Test
	public void TestDragAndDrop() throws InterruptedException {
		driver.get(URL);
		
		driver.findElement(By.xpath("//a[contains(text(),'Drag and Drop')]")).click();
	
		WebElement elementA = driver.findElement(By.cssSelector("div#column-a"));
		WebElement elementB = driver.findElement(By.cssSelector("div#column-b"));
		
		Actions action = new Actions(driver);
		
		action.dragAndDrop(elementA, elementB).build().perform();
		
		int x=elementB.getLocation().getX();
		int y=elementB.getLocation().getY();
		
		String elementAheaderText = driver.findElement(By.cssSelector("div#column-a header")).getText();
		String elementBheaderText = driver.findElement(By.cssSelector("div#column-b header")).getText();
		
		Assert.assertEquals(elementAheaderText, "B");
		Assert.assertEquals(elementBheaderText, "A");
		
		Thread.sleep(4000);
	}
}
