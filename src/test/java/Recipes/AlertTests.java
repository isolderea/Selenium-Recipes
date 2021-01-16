package Recipes;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class AlertTests extends BaseTest {


    @Test
    public void testSimpleAlert() {

    // Navigate to the page
    driver.get("https://formy-project.herokuapp.com/switch-window");

    //Identify our WebElements
        WebElement alertButton = driver.findElement(By.id("alert-button"));
        WebElement windowButton = driver.findElement(By.id("new-tab-button"));

    // Click on the button to show the Alert
        alertButton.click();
    //Identify that there is an Alert
        Alert alert = driver.switchTo().alert();
    //Get and check the text from the Alert
        String textAlert = alert.getText();
        System.out.println("Text from the Alert is :" + textAlert);

        assertEquals(textAlert,"This is a test alert!");
    //Close the Alert
        alert.accept();
        windowButton.click();
    }
}
