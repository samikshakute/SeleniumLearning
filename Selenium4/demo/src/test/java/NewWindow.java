import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class NewWindow {
    public static void main(String[] args) throws IOException, InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentId = it.next();
        String childId = it.next();

        // Switching window
        driver.switchTo().window(childId);
        driver.get("https://rahulshettyacademy.com/");
        Thread.sleep(5000);
        String courseName = driver.findElements(By.cssSelector("a[href*='/p']")).get(1).getText();
        driver.switchTo().window(parentId);
        WebElement name = driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(courseName);

        // Screenshot
        File file = name.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(file, new File("nameInput.png"));

        // Get Height and Width
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());

        driver.quit();
    }
}
