package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    public WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {

        //System.setProperty("webdriver.chrome.driver", "resources/chromedriver88.exe");
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/");

        driver.manage().window().maximize();

        //Implicit wait setup
        //driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Thread.sleep(5000);

    }

    @AfterClass
    public void tearDown(){
        this.driver.quit();
    }
}