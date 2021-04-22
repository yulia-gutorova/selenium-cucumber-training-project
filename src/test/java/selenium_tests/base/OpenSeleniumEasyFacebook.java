package selenium_tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium_tests.BasePage;

public class OpenSeleniumEasyFacebook {

    String SITE_URL = "https://www.facebook.com/seleniumeasy";

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

/*    @AfterAll
    public static void tearDown()
    {
        driver.quit();
    }*/


    @Test
    @Order(1)
    @DisplayName("Open the page")
    public void openPage()
    {
        driver.get(SITE_URL);
        Assertions.assertEquals(SITE_URL, driver.getCurrentUrl());
        BasePage.sleep(1000);

        WebDriverWait wait= new WebDriverWait(driver,5);
        //WebElement cookies = driver.findElement(By.xpath("//button[@title='Accept All']"));
        //cookies.click();
        BasePage.sleep(1000);
    }
}
