package selenium_tests;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class BasePage {

    public static WebDriver driver;

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void openHomePage(String url)
    {
        driver.get(url);
    }

}
