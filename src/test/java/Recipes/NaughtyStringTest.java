package Recipes;

import base.BaseTest;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class NaughtyStringTest extends BaseTest {

    @Test
    public void stringsTest() throws IOException, ParseException {

        //Navigate to the page
        driver.get("https://formy-project.herokuapp.com/form");

        //Identify the elements and submit the form
        WebElement firstName = driver.findElement(By.id("first-name"));
        WebElement submitButton = driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary"));



        //Work with the List of Naughty string

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("resources/ListOfString.json");

        Object jsonParse = jsonParser.parse(reader);
        JSONArray stringArray = (JSONArray) jsonParse;

        for (int i = 0;i<stringArray.size();i++){

            String value = (String) stringArray.get(i);
            firstName.sendKeys(value);
            submitButton.click();
            driver.navigate().back();

        }


    }


}
