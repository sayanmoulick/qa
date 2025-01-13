package uiElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;

import org.testng.Assert;

public class KeyPress extends BaseTest{

	@Test
	public void TestKeyPress() {
		driver.get(URL);
		driver.findElement(By.cssSelector("a[href*='key_presses']")).click();
//		driver.findElement(By.xpath("//a[contains(text(), 'Key Presses')]")).click();
//		
		Actions action = new Actions(driver);
		KeyPressEnter(action);
		
		KeyPressShift(action);
		
		KeyPressNumber(action);
		
		KeyPressNumberPad(action);
	}
	
	public void KeyPressEnter(Actions act) {
		act.sendKeys(Keys.ENTER).perform();
		String result = driver.findElement(By.cssSelector("p#result")).getText();
		Assert.assertEquals(result, "You entered: ENTER");
	}
	
	public void KeyPressShift(Actions act) {
		act.sendKeys(Keys.SHIFT).perform();
		String result = driver.findElement(By.cssSelector("p#result")).getText();
		Assert.assertEquals(result, "You entered: SHIFT");
	}
	
	public void KeyPressTab(Actions act) {
		act.sendKeys(Keys.TAB).perform();
		String result = driver.findElement(By.cssSelector("p#result")).getText();
		Assert.assertEquals(result, "You entered: TAB");
	}
	
	public void KeyPressEsc(Actions act) {
		act.sendKeys(Keys.ESCAPE).perform();
		String result = driver.findElement(By.cssSelector("p#result")).getText();
		Assert.assertEquals(result, "You entered: ESCAPE");
	}
	
	public void KeyPressNumber(Actions act) {
		act.sendKeys("2").perform();
		String result = driver.findElement(By.cssSelector("p#result")).getText();
		Assert.assertEquals(result, "You entered: 2");
	}
	
	public void KeyPressNumberPad(Actions act) {
		act.sendKeys(Keys.NUMPAD6).perform();
		String result = driver.findElement(By.cssSelector("p#result")).getText();
		Assert.assertEquals(result, "You entered: NUMPAD6");
	}
	
	public void KeyPressAlphabet(Actions act) {
		act.sendKeys("A").perform();
		String result = driver.findElement(By.cssSelector("p#result")).getText();
		Assert.assertEquals(result, "You entered: A");
	}
	
	public void KeyPressArrow(Actions act) {
		act.sendKeys(Keys.ARROW_LEFT).perform();
		String result = driver.findElement(By.cssSelector("p#result")).getText();
		Assert.assertEquals(result, "You entered: LEFT");
	}
	
	public void KeyPressCapslock(Actions act) {}
	
	public void KeyPressNumlock(Actions act) {}
	
	public void KeyPressCharacter(Actions act) {}
	
}
