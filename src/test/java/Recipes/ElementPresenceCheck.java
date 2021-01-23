package Recipes;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class ElementPresenceCheck extends BaseTest {

    @Test
    public void elementPresenceTest(){
    driver.get("https://formy-project.herokuapp.com/form");

    //Indentify the element
    // Correct id is first-name
    //Send keys to the element
        if(isElementPresent(By.id("first-name"))){
            WebElement elementToBeFound = driver.findElement(By.id("first-name"));
            elementToBeFound.sendKeys("Test");
        } else{
            System.out.println("The element is not there so we do not send any text");
        }

    }

    private boolean isElementPresent(By by){
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }
}


