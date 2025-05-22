import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[3]/input")).click();
        String option = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[3]")).getText();
        WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
        Select s = new Select(dropdown);
        s.selectByVisibleText(option);
        driver.findElement(By.id("name")).sendKeys(option);
        driver.findElement(By.id("alertbtn")).click();
        String text = driver.switchTo().alert().getText();
        if(text.contains(option)) {
            System.out.println("Alert message captured successfully.");
        } else {
            System.out.println("Alert failed!");
        }
        driver.switchTo().alert().accept();
        driver.quit();
    }
}
/*
 1. Select any checkbox.
 2. Grab the label of the selected checkbox. (put into a variable)
 3. Select an option in dropdown. Here option should come from step 2 (Do not hard code text. drive it dynamically from step2)
 4. Enter the step2 grabbed label text in the editbox.
 5. click verify and then verify if text grabbed from step 2 is present in the pop up message.
 (Do not hardcode the label part)
 */
