// Window Handling Assignment

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.partialLinkText("Click")).click();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parent = it.next();
        String child = it.next();
        driver.switchTo().window(child);
        System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
        driver.switchTo().window(parent);
        System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
        driver.quit();
    }
}
