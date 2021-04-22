package cucumber_steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium_tests.BasePage;

//Bootstrap Modal Example for Automation
//Single modal example

public class BootstrapModals_steps {

     WebDriver driver;
     //Actions actions = new Actions(driver);

//------------------- Scenario 1 ---------------------------------
//------------------- Single Modal Window  -----------------------

    @Given("I am on the Bootstrap Modal Example home page")
    public void iAmOnTheBootstrapModalExampleHomePage(String url) {
        System.out.print("1.  ");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        Assertions.assertEquals(url, driver.getCurrentUrl());
        BasePage.sleep(1000);
    }

    @When("I click on *Launch modal* button")
    public void iClickOnButtonLaunchModal(String button) {
        System.out.print("2. ");
        driver.findElement(By.cssSelector(button )).click();
        BasePage.sleep(1000);
    }

    @And("I will see Single Boots Modal window")
    public void iWillSeeBootsModalWindow() {
        System.out.print("3. ");
        BasePage.sleep(1000);
        Assertions.assertTrue(driver.findElement(By.xpath("//h4[contains(text(),'Modal Title')]")).isDisplayed());
    }

    @And("I click on {string} button in Single Boots Modal Window")
    public void iClickOnButtonInBootsModalWindow(String modalButton) {
        System.out.print("4. ");
        driver.findElement(By.cssSelector(modalButton)).click();
        BasePage.sleep(1000);
    }

    @Then("Single Boots Modal Window should close")
    public void bootsModalWindowWillClose() {
        System.out.print("5. ");
        Assertions.assertFalse(driver.findElement(By.xpath("//h4[contains(text(),'Modal Title')]")).isDisplayed());
        BasePage.sleep(1000);
        driver.quit();
    }

//------------------- Scenario 2 ---------------------------------
//----------------Multiple Modal Window - Close Window  ----------

/*    @Given("I am on the Bootstrap Modal Example home page new")
    public void iAmOnTheBootstrapModalExampleHomePageNew(String url) {
        System.out.print("1.  ");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        Assertions.assertEquals(url, driver.getCurrentUrl());
        BasePage.sleep(1000);
}

    @When("I click on *Launch modal* button new")
    public void iClickOnLaunchModalButtonNew(String button) {
        System.out.print("2. ");
        driver.findElement(By.cssSelector(button )).click();
        BasePage.sleep(1000);
    }*/

    @And("I will see a Multiple Boots Modal Window")
    public void iWillSeeAMultipleBootsModalWindow() {
        System.out.print("3. ");
        BasePage.sleep(1000);
        Assertions.assertTrue(driver.findElement(By.xpath("//h4[contains(text(),'First Modal')]")).isDisplayed());
    }

    @And("I click on {string} in Multiple Boots Modal Window")
    public void iClickOnInMultipleBootsModalWindow(String modalButton) {
        System.out.print("4. ");
        driver.findElement(By.cssSelector(modalButton)).click();
        BasePage.sleep(1000);
    }

    @Then("Multiple Boots Modal Window should close")
    public void multipleBootsModalWindowShouldClose() {
        System.out.print("5. ");
        Assertions.assertFalse(driver.findElement(By.xpath("//h4[contains(text(),'First Modal')]")).isDisplayed());
        BasePage.sleep(1000);
        driver.quit();
    }



}
