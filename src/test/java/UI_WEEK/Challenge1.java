package UI_WEEK;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class Challenge1 extends BaseTest {


    @Test
    public void challengeTest() {

    // Navigate to the page
    driver.get("https://automationintesting.online/#/admin");

    //Identify our WebElements
    WebElement username = driver.findElement(By.id("username"));
    WebElement password = driver.findElement(By.id("password"));
    WebElement login = driver.findElement(By.id("doLogin"));

    // Perform the login
    String Username = "admin";
    String Password = "password";

    username.sendKeys(Username);
    password.sendKeys(Password);

    login.click();

    //Check that the button is displayed
    WebElement button = driver.findElement(By.id("createRoom"));
    assertTrue(button.isDisplayed());
    }
}
