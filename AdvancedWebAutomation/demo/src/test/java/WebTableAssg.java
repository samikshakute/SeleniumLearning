import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableAssg {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> numOfRows = driver.findElements(By.cssSelector(".table-display tr"));
        System.out.println(numOfRows.size());
        List<WebElement> numOfCols = driver.findElements(By.cssSelector(".table-display th"));
        System.out.println(numOfCols.size());
        List<WebElement> data = driver.findElements(By.cssSelector(".table-display tr:nth-child(3) td"));
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i).getText());
        }
        driver.close();
    }
}
