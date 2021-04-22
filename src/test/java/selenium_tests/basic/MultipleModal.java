package selenium_tests.basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium_tests.BasePage;
import selenium_tests.SeleniumSetUppClass;

import java.util.List;
import java.util.Set;

public class MultipleModal extends SeleniumSetUppClass {

    public static WebDriver driver;
    //String SITE_URL = "https://www.seleniumeasy.com/test/bootstrap-modal-demo.html#myModal"


   @Test
    public void example()
     {
     WebDriverManager.chromedriver().setup();
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     BasePage.sleep(1000);
     driver.get("https://www.seleniumeasy.com/test/bootstrap-modal-demo.html#myModal");
     BasePage.sleep(1000);

     //Choose all Close buttons
     List<WebElement> closeButtons = driver.findElements(By.xpath("//a[contains(text(), 'Close')]"));
     System.out.println("Close buttons: " + closeButtons.size());

     //Choose all X buttons
     List <WebElement> xButtons = driver.findElements(By.xpath("//button[@class='close']"));
     System.out.println("X buttons: " + xButtons.size());


     //Click on Launch modal button in the main window
     driver.findElement(By.cssSelector("div:nth-of-type(2) > .col-md-4.text-left > .panel.panel-default > .panel-body > .btn.btn-primary")).click();
     BasePage.sleep(1000);

     //Click on Launch modal  button in the first pop up window
     driver.findElement(By.xpath("//a[@href='#myModal2']")).click();
     BasePage.sleep(1000);
     //Click on Close button in the second pop up window
     closeButtons.get(2).click();

     //Click on Launch modal  button in the first pop up window
     driver.findElement(By.xpath("//a[@href='#myModal2']")).click();
     BasePage.sleep(1000);
     //Click on x button in the second pop up window
     xButtons.get(0).click();

     //Click on Launch modal  button in the first pop up window
     driver.findElement(By.xpath("//a[@href='#myModal2']")).click();
     BasePage.sleep(1000);


     //Click on Close button in the second modal window


    /* driver.findElement(By.cssSelector("[class] .row:nth-child(3) div:nth-child(3) .modal-footer .btn:nth-of-type(1)")).click();
         "//a[contains(text(), 'Close')]"
         WebElement modal = driver.findElement(By.xpath("//div[contains(@class,'modal-body')]"));
         WebElement radio = modal.findElement(By.xpath(".//label[@class='radiogroup-element' and contains(@style,'block') and text()='Create the account myself']/input[@type='radio']"));
         radio.click();

     //Click on Launch modal  button in the first pop up window
     driver.findElement(By.xpath("//a[@href='#myModal2']")).click();
     //Click on X button
     driver.findElement(By.cssSelector(".fade.modal.rotate .close")).click();

     String mainWindow = driver.getWindowHandle();
     Set<String> allWindows = driver.getWindowHandles();
     System.out.println("Amount of windows " + allWindows.size());*/


     }




}
