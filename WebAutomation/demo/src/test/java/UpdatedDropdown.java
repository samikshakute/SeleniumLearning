import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("divpaxinfo")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        Thread.sleep(1000);
        int i = 0;
        while (i < 4) {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        // using assertions
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        // Handling dynamic dropdowns
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
        driver.findElement(By.xpath("//a[@value='PNQ']")).click();
        // parent child relationship xpath
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
        // driver.findElement(By.xpath("//a[@value='DEL']")).click();

        // Handling Auto Suggestive Dropdowns

        driver.findElement(By.id("autosuggest")).sendKeys("Ind");
        Thread.sleep(1000);
        // List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item'] //a"));
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for(WebElement option : options) {
            if(option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            }
        }
    }
}
