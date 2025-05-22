import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class AutomationTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        // Flight Booking: Dropdowns
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select currency = new Select(staticDropdown);
        currency.selectByVisibleText("USD");
        System.out.println("Selected Currency: " + currency.getFirstSelectedOption().getText());
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("(//a[@value='BLR'])[1]")).click();
        driver.findElement(By.xpath("(//a[@value='DEL'])")).click();
        System.out.println("Selected Route: Bengaluru to Delhi");
        // GreenKart: Cart Additions
        driver.get("https://rahulshettyacademy.com/seleniumPractise");
        Thread.sleep(3000);
        String[] itemsNeeded = {
                "Broccoli",
                "Cucumber"
        };
        List<String> itemsNeededList = Arrays.asList(itemsNeeded);
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        int j = 0;
        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText();
            String[] splitName = name.split("-");
            String formattedName = splitName[0].trim();
            if (itemsNeededList.contains(formattedName)) {
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                j++;
                if (j == itemsNeeded.length) {
                    break;
                }
            }
        }
    }
}