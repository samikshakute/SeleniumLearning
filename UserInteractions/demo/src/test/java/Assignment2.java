// Frame Handling Assignment

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame(driver.findElement(By.name("frame-top")));
        driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
        System.out.println(driver.findElement(By.id("content")).getText());
        driver.close();
    }
}