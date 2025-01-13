package uiElements;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.*;
import org.testng.Assert;

public class DynamicLoading extends BaseTest{
	private By hello_text = By.cssSelector("#finish > h4");
	
	 @Test
	 public void TestDLExampleOne() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 driver.get(URL);
		 driver.findElement(By.xpath("//a[contains(text(),'Dynamic Loading')]")).click();
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='/dynamic_loading/1']")));
		 driver.findElement(By.cssSelector("a[href*='/dynamic_loading/1']")).click();
		 driver.findElement(By.cssSelector("#start > button")).click();
		 
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(hello_text));
		 
		 String expected_displayed_text = "Hello World!";
		 String actual_displayed_text = driver.findElement(hello_text).getText();
		 Assert.assertEquals(actual_displayed_text, expected_displayed_text, "[ERR] The text is not displayed!");
	 }
	 
	 @Test
	 public void TestDLExampleTwo() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 driver.get(URL);
		 driver.findElement(By.xpath("//a[contains(text(),'Dynamic Loading')]")).click();
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='/dynamic_loading/2']")));
		 driver.findElement(By.cssSelector("a[href*='/dynamic_loading/2']")).click();
		 driver.findElement(By.cssSelector("#start > button")).click();
		 
 wait.until(ExpectedConditions.visibilityOfElementLocated(hello_text));
		 
		 String expected_displayed_text = "Hello World!";
		 String actual_displayed_text = driver.findElement(hello_text).getText();
		 Assert.assertEquals(actual_displayed_text, expected_displayed_text, "[ERR] The text is not displayed!");
	 }
	 
	 @Test
		public void test() throws InterruptedException {	
		 	driver.get(URL);
		 	driver.findElement(By.xpath("//a[contains(text(),'Dynamic Loading')]")).click();
			hiddenElementCheck(driver);
			renderedElementCheck(driver);	
			driver.quit();
		}
		
		private void hiddenElementCheck(WebDriver driver) {
			driver.findElement(By.partialLinkText("Example 1")).click();
			driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
			waitForloadingToComplete(driver);
			System.out.println(driver.findElement(By.cssSelector("div#finish>h4")).getText());		
		}
		
		private void renderedElementCheck(WebDriver driver) {
			driver.findElement(By.partialLinkText("Example 2")).click();
			driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
			waitForloadingToComplete(driver);
			System.out.println(driver.findElement(By.cssSelector("div#finish>h4")).getText());		
		}

		private void waitForloadingToComplete(WebDriver driver) {
			System.out.println("Loading check");
			FluentWait<WebDriver> fw = new FluentWait<WebDriver>(driver)
										.withTimeout(Duration.ofSeconds(30))
										.pollingEvery(Duration.ofMillis(500))
										.ignoring(Exception.class);
			
			Function<WebDriver, Boolean> func = new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					WebElement loadingIcon = driver.findElement(By.cssSelector("div#loading"));
					String displayValue = loadingIcon.getCssValue("display");
					if(displayValue.equals("none")) {
						return true;
					}
					return false;
				}
			};
			
			fw.until(func);		
		}
}
