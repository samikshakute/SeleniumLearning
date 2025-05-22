import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        // Click on the first table header to potentially sort the table
        driver.findElement(By.xpath("//tr/th[1]")).click();

        // Retrieve all table data elements in the first column
        List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));

        // Extract text from each table data element and store in a list
        List<String> newList = items.stream()
                .map(s -> s.getText()) // Map each element to its text content
                .collect(Collectors.toList()); // Collect the results into a list

        // Sort the list of text in ascending order
        List<String> sortedList = newList.stream()
                .sorted() // Sort the list in natural order
                .collect(Collectors.toList()); // Collect the sorted results into a list

        // Assert that the original list is equal to the sorted list, verifying that the
        // table is sorted
        Assert.assertTrue(newList.equals(sortedList));

        List<String> price;
        // scan the name column with getText ->Beans->print the price of the Rice
        do {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream().filter(s -> s.getText().contains("Rice"))
                    .map(s -> getPriceVeggie(s)).collect(Collectors.toList());
            price.forEach(a -> System.out.println(a));
            if (price.size() < 1) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        } while (price.size() < 1);
        driver.quit();
    }

    private static String getPriceVeggie(WebElement s) {
        String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return pricevalue;
    }
}
