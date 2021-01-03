package Recipes;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class SelectTests extends BaseTest {

    @Test
    public void SelectTests(){

        //Navigate to the Page
        driver.get("https://formy-project.herokuapp.com/form");

        //Identify Select
        Select selectDropDown = new Select(driver.findElement(By.id("select-menu")));

        //Check if multiple select is available
        assertFalse(selectDropDown.isMultiple());

        //Check the number of options
        assertEquals(5,selectDropDown.getOptions().size());

        //Select a value by index
        selectDropDown.selectByIndex(4);
        assertEquals("10+",selectDropDown.getFirstSelectedOption().getText());

        // Select a value by value/text
        selectDropDown.selectByVisibleText("0-1");
        assertEquals("0-1",selectDropDown.getFirstSelectedOption().getText());

    }
}
