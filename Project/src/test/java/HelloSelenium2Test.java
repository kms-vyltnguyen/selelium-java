import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class HelloSelenium2Test {
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void smarterTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://kobiton.com/");
        driver.quit();
    }
}
