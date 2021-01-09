package Recipes;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class RadioButtonsTests extends BaseTest {

    @Test
    public void radioButtonCheckTests(){

        //Navigate to the page
        driver.get("https://formy-project.herokuapp.com/radiobutton");

        //Find the button
        WebElement firstButton = driver.findElement(By.id("radio-button-1"));
        WebElement secondButton = driver.findElement(By.xpath("//input[@value= \"option2\"]"));
        WebElement thirdButton = driver.findElement(By.xpath("//input[@value= \"option3\"]"));

        // Select the first button
        firstButton.click();

        // Assert that the first button is selected
        assertTrue(firstButton.isSelected());

        // Select the second button
        selectbyIndex(1);

        // Assert that the second button is selected
        assertTrue(secondButton.isSelected());

        // Select the third button
        selectbyText("Radio button 3");

        // Assert that the third button is selected
        assertTrue(thirdButton.isSelected());

        System.out.println("STOP");
    }
    // Select item by index
    public void selectbyIndex(Integer index){
        List<WebElement> itemList = driver.findElements(By.cssSelector(".form-check-input"));
        if (!itemList.get(index).isSelected()){
            itemList.get(index).click();
        }

    }

    public void selectbyText(String text){
        int i = 0;
        List<WebElement> itemList = driver.findElements(By.cssSelector(".form-check-input"));
        List<WebElement> labelsList = driver.findElements(By.cssSelector(".form-check-label"));

        for (WebElement valueTEST : labelsList) {
// Search for the value and select it when found
            if (valueTEST.getText().equals(text)) {
                System.out.println("Found at position " + i);
                if (!itemList.get(i).isSelected()) {
                    itemList.get(i).click();
                }
                break;
            }
            i++;
        }
    }
}


