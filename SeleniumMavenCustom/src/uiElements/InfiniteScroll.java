package uiElements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class InfiniteScroll extends BaseTest{

	@Test
	public void TestInfinteScroll() throws InterruptedException{
		driver.get(URL);
		driver.findElement(By.xpath("//a[contains(text(),'Infinite Scroll')]")).click();
		long lenOfPage = (Long) ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);var lenOfPage=document.body.scrollHeight;return lenOfPage;");
		boolean scrolled = true;
		long lastCount = 0;
		System.out.println(lenOfPage);
		
		while(scrolled==true) {
			Thread.sleep(1500);
			lastCount=lenOfPage;
			lenOfPage = (Long) ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);var lenOfPage=document.body.scrollHeight;return lenOfPage;");
			System.out.println(lenOfPage);
			/*
			if (lastCount==lenOfPage) {
				scrolled=false;
			}
			*/
			// TO STOP
			if(lastCount > 20000) {
				scrolled=false;
			}

		}
		
		Thread.sleep(3000);
		driver.quit();
	}
}
