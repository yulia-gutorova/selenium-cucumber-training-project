package cucumber_steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium_tests.BasePage;

public class PropmtJavascriptAlert_steps {

    WebDriver driver;
    WebDriverWait wait;


    @Given("I am on the Alert box page")
    public void iAmOnTheAlertBoxPage(String url) {
        System.out.print("1.  ");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        Assertions.assertEquals(url, driver.getCurrentUrl());
        BasePage.sleep(1000);

    }

    @When("I click on the Click for Prompt Box")
    public void iClickOnThrClickForPromptBox() {
        System.out.print("2.  ");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']"))).click().build().perform();
        //driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']")).click();
        BasePage.sleep(3000);
    }

    @And("I input text {string}")
    public void iInputText(String name) {
        System.out.print("3.  ");

        Alert alert = driver.switchTo().alert();
        //driver.switchTo().alert().sendKeys("Yulia");

        System.out.println("Send keys: " + name );
        BasePage.sleep(2000);
    }

    @And("I click on the OK button")
    public void iClickOnTheOKButton() {
        System.out.print("4.  ");
        driver.switchTo().alert().accept();
        BasePage.sleep(2000);
    }

    @Then("Alert will return text as output {string}")
    public void alertWillReturnTextAsOutput(String expectedMessage) {
        System.out.print("5.  ");
        String actualMessage = driver.findElement(By.id("prompt-demo")).getText();
        //Assertions.assertTrue(actualMessage.contains(expectedMessage));
        System.out.println("Actual message: " + actualMessage);
        BasePage.sleep(1000);
        driver.quit();
    }
}
