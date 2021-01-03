package Recipes;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class DropdownTests extends BaseTest {

    @Test
    public void dropDownTests(){

        driver.get("https://formy-project.herokuapp.com/dropdown");
        // Click the button
        clickDropdown();
        // Click on the option that we want
        String text = "Buttons"; //link text and URL check text
        //selectByLink(text);
        selectByIndex(1);
        System.out.println("stop");

        // Check that the correct page loaded
        assertTrue(driver.getCurrentUrl().contains(text.toLowerCase()));
    }

    public void clickDropdown(){

        WebElement dropDownButton = driver.findElement(By.id("dropdownMenuButton"));
        dropDownButton.click();

    }

    public void selectByLink(String linkText){
        WebElement optionSelected = driver.findElement(By.linkText(linkText));
        optionSelected.click();
    }
    public void selectByIndex(Integer listItem){
        List<WebElement> optionsAvailable = driver.findElements(By.cssSelector(".dropdown-menu.show a.dropdown-item"));
        optionsAvailable.get(listItem).click();
    }
}
