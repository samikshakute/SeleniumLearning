import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeSum {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> nums = driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum = sum + Integer.parseInt(nums.get(i).getText());
        }
        System.out.println(sum);
        driver.close();
    }
}