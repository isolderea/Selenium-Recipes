package Recipes;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class WaitTest extends BaseTest {


    @Test
    public void waitTests() {

        //Implicit waits - Base Test

        //Navigate to the site
        driver.get("http://automationpractice.com/index.php");

        //Identify 1 element
        WebElement searchBar = driver.findElement(By.id("search_query_top"));
        WebElement searchButton = driver.findElement(By.name("submit_search"));

        //Perform a search
        searchBar.sendKeys("Printed");
        searchButton.click();

        //Explicit waits
        WebDriverWait wait = new WebDriverWait(driver,10);
        List<WebElement> container = driver.findElements(By.cssSelector(".product-image-container"));
        wait.until(ExpectedConditions.elementToBeClickable(container.get(2)));
        container.get(2).click();

    }
}
