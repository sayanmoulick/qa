package uiElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utils.FrameworkUtils;

public class DropDown extends BaseTest{

	@Test
	public void TestDropDown() throws InterruptedException {
		driver.get(URL);
		driver.findElement(By.xpath("//a[contains(text(),'Dropdown')]")).click();
		// wait for visibility
		WebElement dropdown = driver.findElement(By.id("dropdown"));
		
		Select select = new Select(dropdown);
		select.selectByValue("2");
		
//		select.selectByIndex(2);
		
//		select.selectByVisibleText("Option 2");
		/*
		List<WebElement> allOptions = select.getOptions();
		for(WebElement option : allOptions) {
			if (option.getText().equals("Option 2")) {
				option.click();
			}
		}
		
		for (int j = 0; j < allOptions.size(); j++) {
			if (allOptions.get(j).getText().equals("Option 2")) {
				allOptions.get(j).click();
			}
	    }
		*/
		Thread.sleep(3000);
	}
}
