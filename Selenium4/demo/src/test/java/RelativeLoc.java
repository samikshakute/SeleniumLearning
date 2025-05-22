import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLoc {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
        System.out.println(driver.findElement(RelativeLocator.with(By.tagName("label")).above(nameEditBox)).getText());
        WebElement dob = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        WebElement radioButton = driver.findElement(By.id("inlineRadio1"));
        System.out.println(driver.findElement(RelativeLocator.with(By.tagName("label")).toLeftOf(radioButton)).getText());
        System.out.println(driver.findElement(RelativeLocator.with(By.tagName("label")).toRightOf(radioButton)).getText());
        driver.findElement(RelativeLocator.with(By.tagName("input")).below(dob)).click();
        driver.quit();
    }
}