import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.fail;

public class LoginPositiveTest {
    WebDriver driver;
    String url;
    String mail = "abc@yahoo.com";
    String expectedMassage;
    final String password = "Pass@word123";

    @BeforeEach
    public void starter() {
        driver = new ChromeDriver();
        url = "http://localhost:8080/";
        String[] part = mail.split("@");
        expectedMassage = "Welcome " + part[0] + "!";

    }

    @AfterEach
    public void quite() {
        driver.quit();
    }


    @Test
    public void validInputTest() {
        try {
            driver.get(url);
        } catch (Exception ex) {
            fail("can not access " + url);
        }
        WebElement emailAddressBar = driver.findElement(By.id("email"));
        emailAddressBar.sendKeys(mail);
        WebElement passwordBar = driver.findElement(By.id("password"));
        passwordBar.sendKeys(password);
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
        loginButton.click();
        WebElement massage = driver.findElement(By.className("welcome"));
        Assertions.assertEquals(expectedMassage,massage.getText());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
