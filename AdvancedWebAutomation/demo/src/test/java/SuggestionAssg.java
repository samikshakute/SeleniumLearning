import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SuggestionAssg {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("autocomplete")).sendKeys("ind");
        Thread.sleep(3000);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        System.out.println(driver.findElement(By.id("autocomplete")).getDomProperty("value"));
        driver.close();
    }
}