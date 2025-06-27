package stepdefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.ConfirmationPage;
import pageobjects.LandingPage;
import pageobjects.ProductCatalogue;
import testComponents.BaseTest;

public class StepImplementation extends BaseTest {
    public LandingPage landingPage;
    public ProductCatalogue productCatalogue;
    public ConfirmationPage confirmationPage;

    @Given("I Landed on Ecommerce page")
    public void i_landed_on_Ecommerce_page() throws IOException {
        landingPage = launchApplication();
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void logged_in_with_username_and_password(String email, String password) {
        productCatalogue = landingPage.loginApplication(email, password);
    }

    @When("^I add (.+) to Cart$")
    public void i_add_product_to_cart(String productName) throws InterruptedException {
        productCatalogue.getProducList();
        productCatalogue.addProductToCart(productName);
    }

    @And("^Checkout (.+) and submit the order$")
    public void checkout_and_submit_the_order(String productName) throws InterruptedException {
        CartPage cartPage = productCatalogue.goToCartPage();
        boolean match = cartPage.verifyProductIsDisplayed(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckOutPage();
        checkoutPage.selectCountry("india");
        confirmationPage = checkoutPage.submitOrder();
    }

    @Then("{string} message is displayed on ConfirmationPage")
    public void message_is_displayed_on_ConfirmationPage(String string) {
        String confirmMessage = confirmationPage.verifyConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
        driver.close();
    }

    @Then("{string} message is displayed")
    public void something_message_is_displayed(String string) {
        Assert.assertEquals(string, landingPage.getErrorMessage());
        driver.close();
    }
}