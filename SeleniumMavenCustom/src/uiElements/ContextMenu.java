package uiElements;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

//import java.io.IOException;
//
//import org.apache.http.client.ClientProtocolException;

import org.testng.annotations.*;

public class ContextMenu extends BaseTest{
	
	@Test
	public void TestContextMenu() throws InterruptedException {
		driver.get(URL);
		driver.findElement(By.xpath("//a[contains(text(),'Context Menu')]")).click();
		WebElement contextBox = driver.findElement(By.cssSelector("#hot-spot"));
		Actions actions = new Actions(driver);
		actions.moveToElement(contextBox);
		actions.contextClick(contextBox).build().perform();
		Thread.sleep(2000);
		/*
		WebElement menuItem = driver.findElement(By.cssSelector("menuitem[label='the-internet']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", menuItem);
		Thread.sleep(2000);
		*/
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	}

}
