import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandlingCalendar {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.cssSelector("a[value='PNQ']")).click();
        driver.findElement(By.xpath("//div[@id='dropdownGroup1'] //a[@value='BLR']")).click();
        driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']")).click();

        // Validating ui elements that are disabled or enabled in selenium webdriver
        System.out.println(driver.findElement(By.xpath("//label[@for='ctl00_mainContent_rbtnl_Trip_1']")).getDomAttribute("class"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.xpath("//label[@for='ctl00_mainContent_rbtnl_Trip_1']")).getDomAttribute("class"));
        if(driver.findElement(By.xpath("//label[@for='ctl00_mainContent_rbtnl_Trip_1']")).getDomAttribute("class").contains("select-label")) {
            System.out.println("Enabled");
            Assert.assertTrue(true);
        } else {
            System.out.println("Disabled");
            Assert.assertTrue(false);
        }
    }
}