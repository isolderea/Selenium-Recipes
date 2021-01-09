package Recipes;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckboxTests extends BaseTest {


    @Test
    public void radioButtonCheckTests(){

        //Navigate to the page
        driver.get("https://formy-project.herokuapp.com/checkbox");

        //Identify the Element
        WebElement checkBox1 = driver.findElement(By.id("checkbox-1"));
        WebElement checkBox2 = driver.findElement(By.id("checkbox-2"));
        WebElement checkBox3 = driver.findElement(By.id("checkbox-3"));

        // Check the Element - click
        //checkBox1.click();;
        //checkBox2.click();
        //checkBox3.click();
        selectAllValues();

        //Assert the element state - checked or not checked
        assertTrue(checkBox1.isSelected());
        assertTrue(checkBox2.isSelected());
        assertTrue(checkBox3.isSelected());

        // UnCheck the Element - click
        checkBox1.click();
        // Click the second checkbox
        selectByIndex(1);
        //Click based on Text
        selectByText("Checkbox3");

        //Assert the element state - checked or not checked
        assertFalse(checkBox1.isSelected());
        assertFalse(checkBox2.isSelected());
        assertFalse(checkBox3.isSelected());
    }

    public void selectByIndex(Integer index){
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input"));
        checkboxes.get(index).click();
    }

    public void selectAllValues(){
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input"));
        for (int i = 0; i < checkboxes.size(); i++) {
            checkboxes.get(i).click();

        }
    }

    public void selectByText(String textToSelect){
        int i = 0;
        List<WebElement> Labels = driver.findElements(By.cssSelector(".col-sm-8"));
        List<WebElement> rdButtons = driver.findElements(By.xpath("//input"));
        for (WebElement value : Labels) {
            if (value.getText().equals(textToSelect)) {
                System.out.println("The text was found at index " + i);
                rdButtons.get(i).click();
                break;
            }
            i++;
        }
    }
}

