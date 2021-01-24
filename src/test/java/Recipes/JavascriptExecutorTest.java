package Recipes;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavascriptExecutorTest extends BaseTest {

    @Test
    public void javasciptExecutorScrollTest() {

    // Setup the possibility of running javascript
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

    // Scroll to the bottom of the page
    javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    // Scroll on a page by x pixels
    // in our example x is 10
    javascriptExecutor.executeScript("window.scrollBy(0,10)");

    // Scroll to a Webelement
     WebElement elementToScrollTO = driver.findElement(By.partialLinkText("Page Scroll"));
     javascriptExecutor.executeScript("arguments[0].scrollIntoView();", elementToScrollTO);

    }
}
