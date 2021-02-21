package selenium_tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SeleniumTestWindowPopup extends SeleniumSetUppClass {

    String SITE_URL = "https://www.seleniumeasy.com/test/window-popup-modal-demo.html";
    Actions actions = new Actions(driver);


    @Test
    @Order(1)
    @DisplayName("Open the page")
    public void openPage()
    {
        driver.get(SITE_URL);
        Assertions.assertEquals(SITE_URL, driver.getCurrentUrl());
        BasePage.sleep(1000);
    }

    @Test
    @Order(2)
    @DisplayName("Single Window Popup Twitter")
    public void singleWindowPopup()
    {
        WebElement followOnTwitter = driver.findElement(By.xpath("//a[@title='Follow @seleniumeasy on Twitter']"));
        actions.moveToElement(followOnTwitter).click().build().perform();

        String mainWindow = driver.getWindowHandle();
        BasePage.sleep(2000);

        Set<String> allWindows = driver.getWindowHandles();

        for (String currentWindow: allWindows)
        {
          if (!currentWindow.equals(mainWindow))
          {
              driver.switchTo().window(currentWindow);
              BasePage.sleep(2000);
              driver.close();
          }
        }
        driver.switchTo().window(mainWindow);

    }

    @Test
    @DisplayName("Single Window Popup Facebook")
    @Order(3)
    public void likeUsOnFacebook()
    {
        WebElement likeUsOnFacebook = driver.findElement(By.xpath("//a[@title='Follow @seleniumeasy on Facebook']"));
        actions.moveToElement(likeUsOnFacebook).click().build().perform();
        String mainWindow = driver.getWindowHandle();
        BasePage.sleep(2000);

        Set<String> allWindows = driver.getWindowHandles();

        for (String currentWindow: allWindows)
        {
            if (!currentWindow.equals(mainWindow))
            {
                driver.switchTo().window(currentWindow);
                driver.manage().window().maximize();
                BasePage.sleep(5000);
                //WebDriverWait wait= new WebDriverWait(driver,5);
                //WebElement cookies = driver.findElement(By.xpath("//button[@title='Accept All']"));
                //cookies.click();
                BasePage.sleep(5000);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
    }

}
