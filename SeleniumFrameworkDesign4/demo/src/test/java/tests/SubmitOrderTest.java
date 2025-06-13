package tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.ConfirmationPage;
import pageobjects.OrderPage;
import pageobjects.ProductCatalogue;
import testComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
    String productName = "ZARA COAT 3";

    @Test(dataProvider = "getData", groups = { "Purchase" })
    public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {
        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));

        productCatalogue.getProducList();
        productCatalogue.addProductToCart(input.get("productName"));
        CartPage cartPage = productCatalogue.goToCartPage();

        boolean match = cartPage.verifyProductIsDisplayed(input.get("productName"));
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckOutPage();
        checkoutPage.selectCountry("india");

        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String confirmMessage = confirmationPage.verifyConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    @Test(dependsOnMethods = { "submitOrder" })
    public void verifyOrderHistory() throws InterruptedException {
        ProductCatalogue productCatalogue = landingPage.loginApplication("samikshak@gmail.com", "Sam@12345");
        OrderPage orderPage = productCatalogue.goToOrderPage();
        Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        // HashMap<String, String> map = new HashMap<String, String>();
        // map.put("email", "samikshak@gmail.com");
        // map.put("password", "Sam@12345");
        // map.put("productName", "ZARA COAT 3");

        // HashMap<String, String> map1 = new HashMap<String, String>();
        // map1.put("email", "harry18@gmail.com");
        // map1.put("password", "Harry@123");
        // map1.put("productName", "ADIDAS ORIGINAL");

        List<HashMap<String, String>> data = getJSONDataToMap(
                System.getProperty("user.dir") + "/src/test/java/data/PurchaseOrder.json");

        return new Object[][] { { data.get(0) }, { data.get(1) } };
    }
}
