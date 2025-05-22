import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandlingCheckboxes {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
        System.out.println(driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected());
        // using assertions
        Assert.assertFalse(driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected());
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected());
        System.out.println(driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected());
        driver.close();
    }
}
