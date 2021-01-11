package Recipes;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class NavigationTests extends BaseTest {

    @Test
    public void navigationTests(){

        //Open a page
        driver.get("https://formy-project.herokuapp.com/autocomplete");

        //Navigate to page
        driver.navigate().to("https://formy-project.herokuapp.com/buttons");

        // Check if we are on the correct page
        String currentPage = driver.getCurrentUrl().toString();
        //System.out.println(currentPage);
        assertTrue(currentPage.contains("buttons"));

        //Go back to the previous page
        driver.navigate().back();

        // Check if we are on the correct page
        String currentPage2 = driver.getCurrentUrl().toString();
        //System.out.println(currentPage2);
        assertTrue(currentPage2.contains("autocomplete"));

        // Go forward
        driver.navigate().forward();

        // Check if we are on the correct page
        String currentPage3 = driver.getCurrentUrl().toString();
        //System.out.println(currentPage3);
        assertTrue(currentPage3.contains("buttons"));

        //Refresh page
        driver.navigate().refresh();

        // Check if we are on the correct page
        String currentPage4 = driver.getCurrentUrl().toString();
        //System.out.println(currentPage4);
        assertTrue(currentPage4.contains("buttons"));


    }
}
