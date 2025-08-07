package abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjects.CartPage;
import pageobjects.OrderPage;

public class AbstractMethod {
    WebDriver driver;

    public AbstractMethod(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[routerlink*='cart']")
    WebElement cartHeader;

    @FindBy(css = "[routerlink*='myorders']")
    WebElement orderHeader;

    @FindBy(css = ".ngx-spinner-overlay")
    WebElement spinnerOverlay;

    public void waitForElementToAppear(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForWebElementToAppear(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForElementToDisappear(WebElement element) throws InterruptedException {
        // Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    // public CartPage goToCartPage() throws InterruptedException {
    // waitForElementToDisappear(spinnerOverlay);
    // cartHeader.click();
    // return new CartPage(driver);
    // }

    public CartPage goToCartPage() throws InterruptedException {
        Thread.sleep(1000); // Wait for spinner to disappear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cartHeader)); // Ensure button is clickable
        cartHeader.click();
        return new CartPage(driver);
    }

    public OrderPage goToOrderPage() {
        orderHeader.click();
        return new OrderPage(driver);
    }
}