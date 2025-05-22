import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        // counting the links on the webpage
        System.out.println(driver.findElements(By.tagName("a")).size());

        // counting the number of links in the footer section of the page
        WebElement footer = driver.findElement(By.id("gf-BIG")); // limiting webdriver scope
        System.out.println(footer.findElements(By.tagName("a")).size());

        // counting links in a particular column in footer
        WebElement column = footer.findElement(
                By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(column.findElements(By.tagName("a")).size());

        // click on each link in the column and check if pages are opening.
        int size = column.findElements(By.tagName("a")).size();
        for (int i = 0; i < size; i++) {
            String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
            column.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
        }
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
        driver.quit();
    }
}