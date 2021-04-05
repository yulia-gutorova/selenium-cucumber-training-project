package selenium_tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium_tests.BasePage;
import selenium_tests.SeleniumSetUppClass;


@TestMethodOrder(MethodOrderer.MethodName.class)

public class SeleniumSimpleFormDemoTest extends SeleniumSetUppClass {

    String SITE_URL = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";

    @DisplayName("Open a page")
    @Test
    public void a_openPage()
    {
        driver.get(SITE_URL);
        Assertions.assertEquals(SITE_URL, driver.getCurrentUrl());
        BasePage.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement close = driver.findElement(By.id("at-cv-lightbox-close"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("at-cv-lightbox-close")));
        close.click();
        BasePage.sleep(1000);

        Assertions.assertEquals(SITE_URL, driver.getCurrentUrl());
    }

    @DisplayName("Test that the logotype of the website and the sponsor logo  are present")
    @Test
    public void b_isPresent()
    {
       WebElement seleniumEasyPicture =  driver.findElement(By.xpath("//img[@role='presentation']"));
       WebDriverWait wait = new WebDriverWait(driver, 5);
       WebElement sponsoredBy =  driver.findElement(By.xpath("//img[@class='cbt']"));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//img[@class='cbt']"))));

        Assertions.assertTrue(seleniumEasyPicture.isDisplayed());
        Assertions.assertTrue(sponsoredBy.isDisplayed());
    }

    @Test
    @DisplayName("Enter a single message")
    public void c_enterMessage()
    {
        WebElement enterMessage = driver.findElement(By.xpath("//input[@placeholder='Please enter your Message']"));
        enterMessage.sendKeys("abc");
        BasePage.sleep(1000);

        WebElement showMessage = driver.findElement(By.xpath("//button[@onclick='showInput();']"));
        showMessage.click();
        BasePage.sleep(1000);

        WebElement yourMessage = driver.findElement(By.id("display"));

        Assertions.assertEquals("abc", yourMessage.getText());
    }

    @Test
    @DisplayName("Enter two messages")
    public void d_enterValues()
    {
        WebElement enterValueA = driver.findElement(By.id(("sum1")));
        enterValueA.sendKeys("1");
        BasePage.sleep(1000);

        WebElement enterValueB = driver.findElement(By.id(("sum2")));
        enterValueB.sendKeys("2");
        BasePage.sleep(1000);

        WebElement getTotal = driver.findElement(By.xpath("//button[@onclick='return total()']"));
        getTotal.click();
        BasePage.sleep(1000);

        WebElement total = driver.findElement(By.id("displayvalue"));
        Assertions.assertEquals("3", total.getText());
    }


}
