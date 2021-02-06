package selenium_tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumSetUppClass {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void setUpp()
    {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        BasePage.sleep(1000);
    }

    @AfterAll
    public static void tearDown()
    {
        driver.quit();
    }
}
