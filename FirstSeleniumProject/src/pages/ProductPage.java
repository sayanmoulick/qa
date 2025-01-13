package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
	private WebDriver driver;

    // Locators
    private By productAddToCartButton = By.xpath("//div[@class='product'][contains(text(),'Sample Product')]//button[contains(text(),'Add to Cart')]");
    private By cartButton = By.id("cartButton");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart() {
        WebElement addToCartButton = driver.findElement(productAddToCartButton);
        addToCartButton.click();
    }

    public void goToCart() {
        WebElement cartButtonElement = driver.findElement(cartButton);
        cartButtonElement.click();
    }
}
