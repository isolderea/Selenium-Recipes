package Recipes;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ScrapeTemplate1 extends BaseTest {


    @Test
    public void testSimpleAlert() {

    // Navigate to the page
    //driver.get("https://www.facebook.com/pg/workfunny/photos/?tab=album&album_id=2159106390875910&ref=page_internal");
    driver.get("https://www.facebook.com/pg/workfunny/photos/?tab=album&album_id=2159099824209900&ref=page_internal");

    //Identify our WebElements
    List<WebElement> list = driver.findElements(By.cssSelector("._2eea > a"));

        int i;
        for (i=0; i<list.size(); i++) {
            System.out.println("Link to item is " + list.get(i).getAttribute("href"));

        }

    }
}
