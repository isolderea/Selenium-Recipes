package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {

    protected WebDriver driver;
    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/");
        driver.manage().window().maximize();
        //Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}