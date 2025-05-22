import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println(driver.getCurrentUrl());

        driver.navigate().to("https://www.selenium.dev/");
        System.out.println(driver.getCurrentUrl());

        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());

        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());
    }
}