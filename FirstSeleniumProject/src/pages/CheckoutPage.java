package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
	private WebDriver driver;

    // Locators
    private By cardNumberField = By.id("cardNumber");
    private By expiryDateField = By.id("expiryDate");
    private By cvvField = By.id("cvv");
    private By payButton = By.id("payButton");
    private By paymentSuccessMessage = By.id("paymentSuccessMessage");
    private By stockStatus = By.id("stockStatus");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterPaymentDetails(String cardNumber, String expiryDate, String cvv) {
        driver.findElement(cardNumberField).sendKeys(cardNumber);
        driver.findElement(expiryDateField).sendKeys(expiryDate);
        driver.findElement(cvvField).sendKeys(cvv);
    }

    public void clickPayButton() {
        driver.findElement(payButton).click();
    }

    public boolean isPaymentSuccessful() {
        return driver.findElement(paymentSuccessMessage).isDisplayed();
    }

    public String getStockStatus() {
        return driver.findElement(stockStatus).getText();
    }
}
