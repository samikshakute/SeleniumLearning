import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };
        addItems(driver, itemsNeeded);
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
        driver.close();
    }

    public static void addItems(WebDriver driver, String[] itemsNeeded) {
        int j = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < products.size(); i++) {
            // Brocolli - 1 Kg
            // Brocolli, 1 kg

            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();

            // format it to get actual vegetable name
            // convert array into array list for easy search
            // check whether name you extracted is present in arrayList or not

            List<String> itemsNeededList = Arrays.asList(itemsNeeded);
            if (itemsNeededList.contains(formattedName)) {
                j++;
                // click on Add to cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == itemsNeeded.length) {
                    break;
                }
            }
        }
    }
}
/*
 * Implicit Wait
 * Pros: Readable and optimized code.
 * Cons: Performance issues are not caught as it is applied on each element in the DOM.
 */