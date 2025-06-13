package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractMethod;

public class LandingPage extends AbstractMethod {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        // initialization code
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElement userEmail = driver.findElement(By.id("userEmail"));
    // Page Factory
    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(id = "login")
    WebElement submitButton;

    @FindBy(css = "[class*='flyInOut']")
    WebElement errorMessage;

    public ProductCatalogue loginApplication(String email, String pswd) {
        userEmail.sendKeys(email);
        userPassword.sendKeys(pswd);
        submitButton.click();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        return productCatalogue;
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client");
    }

    public String getErrorMessage() {
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }
}
