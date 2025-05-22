import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();
        Select dropdown = new Select(driver.findElement(By.cssSelector("select.form-control")));
        dropdown.selectByIndex(2);
        driver.findElement(By.cssSelector("input[type='checkbox']")).click();
        driver.findElement(By.id("signInBtn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
        List<WebElement> elements = driver.findElements(By.cssSelector(".card-footer .btn-info"));
        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).click();
        }
        driver.findElement(By.cssSelector(".nav-item .btn-primary")).click();
    }
}
