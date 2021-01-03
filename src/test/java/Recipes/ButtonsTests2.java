package Recipes;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.support.ui.Select;


import static org.junit.Assert.assertFalse;

public class ButtonsTests2 extends BaseTest {

    @Test
    public void buttonTest(){

        //Navigate to the Page
        driver.get("https://formy-project.herokuapp.com/dropdown");

        //Finding the buttons
        WebElement dropdownButton = driver.findElement(By.id("dropdownMenuButton"));
        Select objSelect = new Select();

// Verify Dropdown does not support multiple selection
        assertFalse(dropdownButton.isMultiple());
// Verify Dropdown has four options for selection
        assertEquals(4, dropdownButton.getOptions().size());

    }
}
