package Recipes;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DragAndDropTest extends BaseTest {

    @Test
    public void dragAndDropTest() throws IOException {

        //navigate to the Page
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        //Find the elements
        WebElement sourceObj = driver.findElement(By.cssSelector("#column-a"));
        WebElement destinationObj = driver.findElement(By.cssSelector("#column-b"));

        /* Do the action. */
        dragIT("#column-a","#column-b");

        /* Verify the drag and drop action success. */
        String dropStatusText = destinationObj.getText();
        Assert.assertEquals(dropStatusText, "A");
    }


    /* This method implement the drag and drop action use selenium webdriver. */
    // The strings need to be CSS Locations
    public void dragIT (String Fromlocator, String ToLocator) throws IOException {
        System.out.println("drag and drop started");

        String filePath = "resources/drag_and_drop.js";
        StringBuffer buffer = new StringBuffer();

        String line;
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        while((line = br.readLine())!=null)
            buffer.append(line);

        String javaScript = buffer.toString();
        //Command to execute
        String commandToExecute =  "$('"+Fromlocator+"').simulateDragDrop({ dropTarget: '"+ToLocator+"'});";

        javaScript = javaScript + commandToExecute;
        ((JavascriptExecutor)driver).executeScript(javaScript);

        System.out.println("drag and drop ended");


    }


}
