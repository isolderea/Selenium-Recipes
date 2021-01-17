package Recipes;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class IFrameTests extends BaseTest {


    @Test
    public void iframeTests() {

    // Navigate to the page
    driver.get("https://the-internet.herokuapp.com/iframe");

    //Identify the iframe
    WebElement iframe = driver.findElement(By.id("mce_0_ifr"));

    //Switch to the iframe
    driver.switchTo().frame(iframe);

    //Identify and send data to the Text area
    WebElement textArea = driver.findElement(By.id("tinymce"));
    String test1Text = "Test1";
    String test2Text = "Test2";
    textArea.clear();
    textArea.sendKeys(test1Text);

    //Check that the text was entered
    assertTrue(textArea.getText().contains(test1Text));

    //Activate the BOLD option
    driver.switchTo().parentFrame();
    List<WebElement> textOptions = driver.findElements(By.cssSelector(".tox-icon.tox-tbtn__icon-wrap"));
    textOptions.get(2).click();

    //Send data to the Text Area
    driver.switchTo().frame(iframe);
    textArea.sendKeys(test2Text);

    //Check that the text was entered
    assertTrue(textArea.getText().contains(test2Text));

    System.out.println("Stop");
    }
}
