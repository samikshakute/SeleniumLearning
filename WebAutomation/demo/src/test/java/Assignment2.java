import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.name("name")).sendKeys("Samiksha");
        driver.findElement(By.name("email")).sendKeys("sam18@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("1234");
        driver.findElement(By.id("exampleCheck1")).click();
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).click();
        driver.findElement(By.name("bday")).sendKeys("18/01/2002");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        System.out.println(driver.findElement(By.className("alert")).getText());
        driver.close();
    }
}