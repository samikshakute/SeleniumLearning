import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        Actions a = new Actions(driver);

        // Moves to specific element
        WebElement move = driver.findElement(By.cssSelector("div[id='nav-link-accountList'] a"));

        // Perform a series of actions:
        // 1. Move to the search box element
        // 2. Click on the search box
        // 3. Press the Shift key
        // 4. Send the keys "hello" to the search box
        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello");

        // Perform a context click (right-click) on the element
        a.moveToElement(move).contextClick().build().perform();

        // Close the window
        driver.close();
    }
}
