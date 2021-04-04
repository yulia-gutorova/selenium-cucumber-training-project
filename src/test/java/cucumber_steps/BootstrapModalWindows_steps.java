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
import org.openqa.selenium.interactions.Actions;
import selenium_tests.BasePage;

//Bootstrap Modal Example for Automation
//Single modal example

public class BootstrapModalWindows_steps {

     WebDriver driver;
     //Actions actions = new Actions(driver);

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

    @When("I click on button *Launch modal*")
    public void iClickOnButtonLaunchModal(String button) {
        System.out.print("2. ");
        driver.findElement(By.xpath(button)).click();
        BasePage.sleep(1000);
    }

    @And("I will see Boots Modal window")
    public void iWillSeeBootsModalWindow() {
        System.out.print("3. ");
        BasePage.sleep(1000);
        Assertions.assertTrue(driver.findElement(By.xpath("//h4[contains(text(),'Modal Title')]")).isDisplayed());
    }

    @And("I click on button in Boots Modal Window {string}")
    public void iClickOnButtonInBootsModalWindow(String modalButton) {
        System.out.print("4. ");
        driver.findElement(By.cssSelector(modalButton)).click();
        BasePage.sleep(1000);
    }

    @Then("Boots Modal Window will close")
    public void bootsModalWindowWillClose() {
        System.out.print("5. ");
        Assertions.assertFalse(driver.findElement(By.xpath("//h4[contains(text(),'Modal Title')]")).isDisplayed());
        BasePage.sleep(1000);
        driver.quit();
    }
}
