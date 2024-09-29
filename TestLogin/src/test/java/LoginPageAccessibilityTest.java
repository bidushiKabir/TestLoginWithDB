
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.fail;

public class LoginPageAccessibilityTest {
    WebDriver driver;
    String url;

    @BeforeEach
    public void starter() {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
        url = "http://localhost:8080/";
    }

    @AfterEach
    public void quite() {
        driver.quit();
    }

    @Test
    public void webpageAccessible() {
        try {
            //String url = "http://localhost:8080/";
            driver.get(url);
        } catch (Exception ex) {
            fail("Error");
        }

        try {
            WebElement loginHeader = driver.findElement(By.xpath("/html/body/div/h2"));
            String actual = loginHeader.getText();
            String target = "Login";
            Assertions.assertEquals(target, actual);
        } catch (Exception ex) {
            fail("can not login header");
        }


    }
}
