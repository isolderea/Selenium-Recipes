package Recipes;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class DatesTests extends BaseTest {

    @Test
    public void dateTest(){

        //Navigate to the page
        driver.get("https://formy-project.herokuapp.com/datepicker");

        //Find the date picker
        WebElement datePicker = driver.findElement(By.id("datepicker"));
        WebElement dateLabel = driver.findElement(By.xpath("//h1"));

        //Enter value
        String dateToEnter = "01/01/1980";
        datePicker.click();
        datePicker.sendKeys(dateToEnter);
        dateLabel.click();

        //Get the entered value

        String valuePresent = datePicker.getAttribute("value");

        //Check if the value is there
        assertEquals(dateToEnter,valuePresent);
    }
}
