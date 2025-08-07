package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractMethod;

public class CartPage extends AbstractMethod {
    WebDriver driver;

    @FindBy(css = "div[class='cartSection'] h3")
    List<WebElement> cartProducts;

    @FindBy(css = ".totalRow button")
    WebElement checkout;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyProductIsDisplayed(String productName) {
        boolean match = cartProducts.stream()
                .anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        return match;
    }

    public CheckoutPage goToCheckOutPage() {
        waitForWebElementToAppear(checkout);
        checkout.click();
        return new CheckoutPage(driver);
    }

}