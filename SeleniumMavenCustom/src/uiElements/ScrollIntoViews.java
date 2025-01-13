package uiElements;

import org.openqa.selenium.WebElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.annotations.Test;

public class ScrollIntoViews extends BaseTest{
	
	public void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-300)");
	}
	
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
	}
	
	public void scrollRight() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(300,0)");
	}
	
	public void scrollLeft() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(-300,0)");
	}
	
	public void pageUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}
	
	public void pageDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public void scrollToElement(WebElement webElement) {
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		jss.executeScript("arguments[0].scrollIntoView()",webElement);
	}
	
	public void jsclickElement(WebElement webelement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", webelement);
	}
	
	public void jsenterText(WebElement webelement, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		webelement.clear();
		js.executeScript("arguments[0].value=arguments[1]", webelement,value);
	}
	
	@Test
	public void TestFooterScroll() throws InterruptedException {
		driver.get(URL);
		driver.findElement(By.cssSelector("a[href*='challenging_dom']")).click();
		
		WebElement footerElement = driver.findElement(By.cssSelector("#page-footer"));
//		pageDown();
//		scrollToElement(footerElement);
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(footerElement));
		
		
		Thread.sleep(3000);
	}
}
