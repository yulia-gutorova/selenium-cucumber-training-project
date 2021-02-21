package selenium_tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SeleniumTestAlertBoxes extends SeleniumSetUppClass{

    String SITE_URL = "https://www.seleniumeasy.com/test/javascript-alert-box-demo.html";
    Actions actions = new Actions (driver);

    @Test
    @Order(1)
    @DisplayName("Open home page")
    public void a_openPage ()
    {
        driver.get(SITE_URL);
        BasePage.sleep(1000 );
    }

    @Test
    @Order(2)
    @DisplayName("Confirm Java Script Alert Box")
    public  void b_JavaScriptAlertBox()
    {
        WebElement alertBox = driver.findElement(By.xpath("//button[@class='btn btn-default']"));

        actions.moveToElement(alertBox).click().build().perform();
        BasePage.sleep(1000);
        //Switching to Alert
        Alert alert = driver.switchTo().alert();
        BasePage.sleep(1000);

        //Capturing Alert message
        String expectedMessage = "I am an alert box!";
        Assertions.assertTrue(driver.switchTo().alert().getText().contains(expectedMessage));

        //Click on the OK button of the Alert
        driver.switchTo().alert().accept();
        BasePage.sleep(1000);
    }

    @Test
    @Order(3)
    @DisplayName("Click on the OK button of the Java Script Confirm Box")
    public  void c_JavaScriptConfirmBoxClickOk ()
    {
        //driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();

        actions.moveToElement(driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"))).click().build().perform();
        BasePage.sleep(1000);
        Alert alert = driver.switchTo().alert();
        BasePage.sleep(1000);
        Assertions.assertTrue(driver.switchTo().alert().getText().contains("Press a button!"));

        driver.switchTo().alert().accept();
        BasePage.sleep(1000);

        Assertions.assertTrue(driver.findElement(By.id("confirm-demo")).getText().contains("You pressed OK!"));

        driver.navigate().refresh();
        BasePage.sleep(1000);
    }

    @Test
    @Order(4)
    @DisplayName("Click on the Cancel button of the Java Script Confirm Box")
    public  void d_JavaScriptConfirmBoxClickCancel ()
    {
        //driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();

        actions.moveToElement(driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"))).click().build().perform();
        BasePage.sleep(1000);
        Alert alert = driver.switchTo().alert();
        BasePage.sleep(1000);
        Assertions.assertTrue(driver.switchTo().alert().getText().contains("Press a button!"));

        driver.switchTo().alert().dismiss();
        BasePage.sleep(1000);

        Assertions.assertTrue(driver.findElement(By.id("confirm-demo")).getText().contains("You pressed Cancel!"));

        driver.navigate().refresh();
        BasePage.sleep(1000);
    }



}
