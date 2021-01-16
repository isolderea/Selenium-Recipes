package Recipes;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class ModalTest extends BaseTest {


    @Test
    public void modalDialogTest() {

    // Navigate to the page
    driver.get("https://formy-project.herokuapp.com/modal");

    //Identify the button to open the modal
    WebElement openModalButton = driver.findElement(By.id("modal-button"));

    //Click the button
    openModalButton.click();

    //Identify the elements from the modal
    WebElement modalHeader = driver.findElement(By.cssSelector(".modal-header"));
    WebElement modalBody = driver.findElement(By.cssSelector(".modal-body"));
    WebElement modalOKButton = driver.findElement(By.id("ok-button"));
    WebElement modalCloseButton = driver.findElement(By.id("close-button"));

    //Wait that the modalLoaded
    WebDriverWait wait = new WebDriverWait(driver, 20);
    WebElement element = wait.until(ExpectedConditions.visibilityOf(modalHeader));

    // Store the text from the element
    String headerText = modalHeader.getText();
    String bodyText = modalBody.getText();

    System.out.println("Stop");

    //Check the text from the elements
    assertEquals("Modal title\n" +                "×",headerText);
    assertEquals("Some text here",bodyText);

    //Close the model
    modalCloseButton.click();

    }
}
