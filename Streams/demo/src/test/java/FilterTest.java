import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.id("search-field")).click();
        driver.findElement(By.id("search-field")).sendKeys("Rice");
        List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));

        // Use Java streams to filter the list of vegetables and include only those containing "Rice"
        List<WebElement> filteredList = veggies.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());

        // Assert that the size of the original list is equal to the size of the filtered list
        // Note: This assertion may fail if there are other vegetables containing "Rice" that are not visible
        Assert.assertEquals(veggies.size(), filteredList.size());
        driver.close();
    }
} 
