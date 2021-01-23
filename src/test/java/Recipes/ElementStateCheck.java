package Recipes;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ElementStateCheck extends BaseTest {


    @Test
    public void testElementState() {

    // Navigate to the page
    driver.get("https://formy-project.herokuapp.com/enabled");

    //Identify the Webelements
        WebElement disabledElement = driver.findElement(By.id("disabledInput"));
        WebElement enabledElement  = driver.findElement(By.id("input"));

    //Input text in the Element that is enabled
    System.out.println("Is disabledElement enabled?" + disabledElement.isEnabled());
    System.out.println("Is disabledElement disabled?" + disabledElement.isDisplayed());
    System.out.println("Is enabledElement enabled?" + enabledElement.isEnabled());
    System.out.println("Is enabledElement disabled?" + enabledElement.isDisplayed());

    if (disabledElement.isEnabled()){
        disabledElement.sendKeys("I am enabled");
    } else {
        System.out.println("Element is not Enabled");
    }

    if (enabledElement.isEnabled()){
        enabledElement.sendKeys("I am enabled");
    } else {
        System.out.println("Element is not Enabled");
    }

    System.out.println("Test is done");

    }
}
