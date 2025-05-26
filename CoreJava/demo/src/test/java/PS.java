import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PS {

    @AfterMethod
    public void afterRun() {
        System.out.println("Run me last!");
    }

    public void doThis() {
        System.out.println("Running Test!");
    }

    @BeforeMethod
    public void beforeRun() {
        System.out.println("Run me first!");
    }

}