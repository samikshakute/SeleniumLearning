import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutor {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        // Cast the WebDriver instance to a JavaScriptExecutor instance
        JavascriptExecutor js = (JavascriptExecutor)driver;
        // Scrolling the browser window
        js.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(5000);
        // Scrolling a element
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        List<WebElement> list = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)")); 
        int sum  = 0;
        for(int i = 0; i < list.size(); i++) {
            sum = sum + Integer.parseInt(list.get(i).getText());
        }
        System.out.println("Sum  = " + sum);
        int actualSum = Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());
        Assert.assertEquals(sum, actualSum);
        driver.quit();
    }
}
