package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    protected WebDriver driver;
    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver88.exe");

        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        //Thread.sleep(5000);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}