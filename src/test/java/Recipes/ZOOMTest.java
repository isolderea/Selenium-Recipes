package Recipes;

import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class ZOOMTest extends BaseTest {

    @Test
    public void zoomTest() {

        System.out.println("zooming started");
        zoom("50");
        zoom("180");
        System.out.println("zooming ended");


    }

    public void zoom (String level){
        System.out.println("zooming");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = \""+level+"%\";");

    }


}
