package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.CartPage;
import pageobjects.ProductCatalogue;
import testComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest {
    @Test(groups = { "ErrorHandling" })
    public void loginErrorValidation() {
        landingPage.loginApplication("wrong_email@example.com", "WrongPassword");
        String errorMessage = landingPage.getErrorMessage();
        Assert.assertEquals("Incorrect email or password.", errorMessage);
    }

    @Test
    public void productErrorValidation() {
        String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue = landingPage.loginApplication("harry18@gmail.com", "Harry@123");
        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.goToCartPage();
        cartPage.goToCheckOutPage();
        boolean match = cartPage.verifyProductIsDisplayed("ZARA COAT 322");
        Assert.assertFalse(match);
    }
}