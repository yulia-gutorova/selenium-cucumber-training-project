package cucumber_steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium_tests.BasePage;

import java.util.ArrayList;
import java.util.List;

public class BootstrapAlertMessages_steps {
    WebDriver driver;
    WebElement element;

    @Given("I am on the Bootstrap Alert messages home page")
    public void iAmOnTheBootstrapAlertMessagesHomePage(String url) {
        System.out.println("---------- Bootstrap Alert messages ---------\n");
        System.out.print("1. ");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        BasePage.sleep(1000);
        driver.get(url);
        BasePage.sleep(1000);
        Assertions.assertEquals(url, driver.getCurrentUrl());
        BasePage.sleep(1000);
    }

/*    @When("I click on {string}, {string} is visible, I wait {string}")
    public void iClickOnIsVisibleIWait(String button, String message, String seconds) {
        System.out.println("2. ");
        String style = driver.findElement(By.xpath(message)).getAttribute("style");
        System.out.println("Style2: " + style);
        Assertions.assertFalse(driver.findElement(By.xpath(message)).isDisplayed());

        driver.findElement(By.id(button)).click();
        BasePage.sleep(1000);

        style = driver.findElement(By.xpath(message)).getAttribute("style");
        System.out.println("Style2: " + style);
        WebElement element = driver.findElement(By.xpath(message));
        Assertions.assertTrue(driver.findElement(By.xpath(message)).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath(message)).getAttribute("style").contains("display: block;"));
        int sec = Integer.parseInt(seconds);

        WebDriverWait wait = new WebDriverWait(driver, sec);
        wait.until((ExpectedConditions.invisibilityOf(element)));
    }

    @Then("Message {string} will not visible")
    public void messageWillNotVisible(String message) {
        System.out.println("3. ");
        String style = driver.findElement(By.xpath(message)).getAttribute("style");
        System.out.println("Style4: " + style);
        Assertions.assertFalse(driver.findElement(By.xpath(message)).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath(message)).getAttribute("style").contains("display: none;"));
        driver.quit();
    }*/

    @When("I click on button {string}")
    public void iClickOn(String button) {
        System.out.print("2. ");
        driver.findElement(By.id(button)).click();
        BasePage.sleep(1000);
    }

    @And("Bootstrap Alert message {string} is visible")
    public void bootstrapAlertIsVisible(String message) {
        System.out.print("3. ");
        element = driver.findElement(By.xpath(message));
        Assertions.assertTrue(element.isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath(message)).getAttribute("style").contains("display: block;"));
    }

    @And("I wait {string} seconds")
    public void iWait(String seconds) {
        System.out.print("4. ");
        int sec = Integer.parseInt(seconds);
        WebDriverWait wait = new WebDriverWait(driver, sec);
        wait.until((ExpectedConditions.invisibilityOf(element)));
    }

    @Then("Bootstrap Alert {string} will not visible")
    public void bootstrapAlertWillNotVisible(String message) {
        System.out.print("5. ");
        Assertions.assertFalse(driver.findElement(By.xpath(message)).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath(message)).getAttribute("style").contains("display: none;"));
    }

    @And("I close driver")
    public void iCloseDriver() {
        System.out.print("6. ");
        driver.close();
    }


/*    @When("I get the list of Bootstrap Alert messages")
    public void iGetTheListOfBootstrapAlertMessages() {
        System.out.print("2.  ");
        bootstrapMessages = driver.findElements(By.xpath("//div[@class='col-md-4']"));
        Assertions.assertNotNull(bootstrapMessages);
        BasePage.sleep(2000);
    }

    @Then("I have the list of Bootstrap Alert messages")
    public void iHaveTheListOfBootstrapAlertMessages() {
        System.out.print("3.  ");
        BasePage.sleep(2000);
        for (WebElement element : bootstrapMessages)
        {
            messages.add(element.getText());
            System.out.println("Element\n:" + element.getText());
        }
        driver.quit();
    }*/


}

