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
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium_tests.BasePage;

import java.util.concurrent.TimeUnit;


public class AjaxFormSubmit_Steps{

     WebDriver driver;
     WebDriverWait wait;

    @Given("I am on the homepage")
    public void iAmOnTheHomepage(String url) {
        System.out.println("---------- Ajax Form Submit with Loading icon ---------\n");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        BasePage.sleep(1000);
        System.out.print("1.  ");
        driver.get(url);
        BasePage.sleep(1000);
        Assertions.assertEquals(url, driver.getCurrentUrl());
        BasePage.sleep(1000);
    }

    @When("I input {string} in the field Name")
    public void iInputInTheFieldName(String name) {
        System.out.print("2.  ");
        driver.findElement(By.id("title")).sendKeys(name);
        BasePage.sleep(1000);
        //???System.out.println("Name: " + driver.findElement(By.id("title")).getText());
        BasePage.sleep(1000);
    }
    @When("I miss field Name")
    public void iMissFieldName() {
        System.out.print("2.  ");
    }

    @And("I input {string} in Comment")
    public void iInputInComment(String comment) {
        System.out.print("3.  ");
        driver.findElement(By.id("description")).sendKeys(comment);
        BasePage.sleep(1000);
    }

    @And("I click on the {string} button")
    public void iClickOnTheButton(String id) {
        System.out.print("4.  ");
        driver.findElement(By.id(id)).click();
        BasePage.sleep(1000);
    }


    @Then("I will see a successMessage {string}")
    public void iWillSeeASuccessMessage(String successMessage) {
        System.out.print("5.  ");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String mess = driver.findElement(By.id("submit-control")).getText();
        Assertions.assertTrue(mess.contains(successMessage));

    }

/*    @And("{string} is visible in the Name field and {string} is visible in the Comment field")
    public void isVisibleInTheNameFieldAndIsVisibleInTheCommentField(String name, String comment) {
        //driver.findElement(By.id("title"))
        //driver.findElement(By.id("description"))
        System.out.print("6.  ");
        //System.out.println("Name" + driver.findElement(By.id("title")).getText());
        //System.out.println("Comment" + driver.findElement(By.id("description")).getText());
        //Assertions.assertTrue(driver.findElement(By.id("title")).getText().contains(name));
        //Assertions.assertTrue(driver.findElement(By.id("description")).getText().contains(comment));
        driver.quit();
    }*/

    @Then("field Name borders will turn red")
    public void fieldNameBordersWillTurnRed() {
        System.out.print("5.  ");
        String expectedAttribute = "border: 1px solid rgb(255, 0, 0);";
        String actualAttribute = driver.findElement(By.id("title")).getAttribute("style");
        Assertions.assertTrue(actualAttribute.contains(expectedAttribute));
    }

    @And("button {string} is still visible")
    public void buttonIsStillVisible(String id) {
        System.out.print("6.  ");
        Assertions.assertTrue(driver.findElement(By.id(id)).isDisplayed());
        driver.quit();
    }


}
