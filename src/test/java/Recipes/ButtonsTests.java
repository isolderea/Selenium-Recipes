package Recipes;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class ButtonsTests extends BaseTest {

    @Test
    public void buttonTest(){

        //Navigate to the Page
        driver.get("https://formy-project.herokuapp.com/buttons");

        //Finding the buttons
        WebElement successButton = driver.findElement(By.cssSelector(".btn.btn-lg.btn-success"));
        WebElement linkButton = driver.findElement(By.cssSelector(".btn.btn-lg.btn-link"));

        WebElement dropdownButton = driver.findElement(By.id("datepicker"));
        WebElement dropdownButto2n = driver.findElement(By.cssSelector("#datepicker"));

        //Click the button
        dropdownButton.click();

        // Colors to check
        String backgroundColor = "rgba(40, 167, 69, 1)";
        String linkColor = "rgba(0, 123, 255, 1)";

        //Check the colors
        String seleniumBackgroundColor = successButton.getCssValue("background-color");
        String seleniumLinkColor = linkButton.getCssValue("color");


        assertEquals(backgroundColor,seleniumBackgroundColor);
        assertEquals(linkColor,seleniumLinkColor);

    }
}
