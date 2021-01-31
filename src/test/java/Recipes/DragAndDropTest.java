package Recipes;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest {

    @Test
    public void dragAndDropTest() {

        //navigate to the Page
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        //Find the elements
        WebElement sourceObj = driver.findElement(By.id("column-a"));
        WebElement destinationObj = driver.findElement(By.id("column-b"));

        /* Do the action. */
        dragDrop(sourceObj,destinationObj);

        /* Verify the drag and drop action success. */
        String dropStatusText = destinationObj.getText();
        Assert.assertEquals(dropStatusText, "Dropped!");
    }


    /* This method implement the drag and drop action use selenium webdriver. */
    public void dragDrop(WebElement srcElement, WebElement targetElement) {
        try {
            /* First ensure both source web element and target web element are all displayed. */
            if (srcElement.isDisplayed() && targetElement.isDisplayed()) {

                /* Create the actions object which carry out the drag and drop action. */
                Actions actionObj = new Actions(this.driver);

                /* Drag source web element and Drop it to the destination. */
                actionObj.dragAndDrop(srcElement, targetElement).build().perform();
            } else {
                System.out.println("Please make sure the web element is displayed for drag and drop. ");
            }
        } catch (StaleElementReferenceException ex) {
            /* This exception means the source or target web element has be changed (delete or updated) in the page DOM tree. */
            ex.printStackTrace();
        } catch (NoSuchElementException ex) {
            /* This exception means can not find the source or target web element in the web page. */
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
