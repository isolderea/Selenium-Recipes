package Recipes;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;


public class TextAreaTests extends BaseTest {

    @Test
    public void enterTextTest(){
    driver.get("https://formy-project.herokuapp.com/form");

    WebElement textBox1 = driver.findElement(By.id("first-name"));
    String textToEnter = "test for video";

    //Clear the textbox1
    textBox1.clear();

    //Enter value in textBox1
    textBox1.sendKeys(textToEnter);

    //Get the value of the textbox
    String valueTextBox = textBox1.getAttribute("value");

    //Assert that the texts match
    assertEquals(textToEnter,valueTextBox);

    }
}

