package cucumber_steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import selenium_tests.BasePage;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.Assertions;

import java.util.List;


public class SubmitInputForms_Steps {

    public static WebDriver driver;
    public  Select select;
    List <WebElement> nameOfStates;
    WebElement radiobutton;

   @Before
    public void setUpp()
    {
        System.out.println("---------- Cucumber test Submit input forms ---------\n");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        BasePage.sleep(1000);

    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Given("I'm on the homepage")
    public void iMOnTheHomepage(String url) {
        System.out.print("1.  ");
        driver.get(url);
        BasePage.sleep(1000);
        Assertions.assertEquals(url, driver.getCurrentUrl());
        BasePage.sleep(1000);
        Assertions.assertEquals(url, driver.getCurrentUrl());
    }

    @When("I input First name as {string}")
    public void iInputFirstNameAs(String firstName) {
        System.out.print("2.  ");
        driver.findElement(By.name("first_name")).sendKeys(firstName);
        BasePage.sleep(1000);
    }

    @And("I input Last name as {string}")
    public void iInputLastNameAs(String lastName) {
        System.out.print("3.  ");
        driver.findElement(By.name("last_name")).sendKeys(lastName);
        BasePage.sleep(1000);
    }

    @And("I input E-mail as {string}")
    public void iInputEMailAs(String email) {
        System.out.print("4.  ");
        driver.findElement(By.name("email")).sendKeys(email);
        BasePage.sleep(1000);
    }
    @And("I input Phone as {string}")
    public void iInputPhoneAs(String phone) {
        System.out.print("5.  ");
        driver.findElement(By.name("phone")).sendKeys(phone);
        BasePage.sleep(1000);
    }

    @And("I input Address as {string}")
    public void iInputAddressAs(String address) {
        System.out.print("6.  ");
        driver.findElement(By.name("address")).sendKeys(address);
        BasePage.sleep(1000);
    }

    @And("I input City as {string}")
    public void iInputCityAs(String city) {
        System.out.print("7.  ");
        driver.findElement(By.name("city")).sendKeys(city);
        BasePage.sleep(1000);
    }

    @And("I choose state")
    public void iChoseState(String state) {
        System.out.print("8.  ");
        WebElement states = driver.findElement(By.name("state"));
        select = new Select(states);
        select.selectByVisibleText("Alabama");
        BasePage.sleep(1000);
    }

    @And("I input Zip code as {string}")
    public void iInputZipCodeAs(String zipCode) {
        System.out.print("9.  ");
        driver.findElement(By.name("zip")).sendKeys(zipCode);
        BasePage.sleep(1000);
    }

    @And("I input Website as")
    public void iInputWebsiteAs(String website) {
        System.out.print("10. ");
        driver.findElement(By.name("website")).sendKeys(website);
        BasePage.sleep(1000);
    }

    @And("I choose hosting {string}")
    public void iChooseHosting(String radioButton) {
        System.out.print("11. ");
        radiobutton = driver.findElement(By.xpath(radioButton ));
        radiobutton.click();
        BasePage.sleep(1000);
    }

    @And("I write project description as {string}")
    public void iWriteProjectDescriptionAs(String description) {
        System.out.print("12. ");
        driver.findElement(By.name("comment")).sendKeys( description);
        BasePage.sleep(1000);
    }

    @And("I click on the button Send")
    public void iClickOnTheButtonSend() {
        System.out.print("13. ");
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        BasePage.sleep(3000);
    }

    @Then("I will see that all the fields have default values")
    public void iWillSeeThatTextFieldFirstNameIsEmpty() {
        System.out.print("14. ");
        Assertions.assertEquals("First Name", driver.findElement(By.name("first_name")).getAttribute("placeholder"));
        Assertions.assertEquals("Last Name", driver.findElement(By.name("last_name")).getAttribute("placeholder"));
        Assertions.assertEquals("E-Mail Address", driver.findElement(By.name("email")).getAttribute("placeholder"));
        Assertions.assertEquals("(845)555-1212", driver.findElement(By.name("phone")).getAttribute("placeholder"));
        Assertions.assertEquals("Address", driver.findElement(By.name("address")).getAttribute("placeholder"));
        Assertions.assertEquals("city", driver.findElement(By.name("city")).getAttribute("placeholder"));
        WebElement states = driver.findElement(By.name("state"));
        select = new Select(states);
        nameOfStates = select.getOptions();
        String valueByDefault = nameOfStates.get(0).getText();
        Assertions.assertEquals("Please select your state", valueByDefault);
        Assertions.assertEquals("Zip Code", driver.findElement(By.name("zip")).getAttribute("placeholder"));
        Assertions.assertEquals("Website or domain name", driver.findElement(By.name("website")).getAttribute("placeholder"));
        Assertions.assertEquals("Website or domain name", driver.findElement(By.name("website")).getAttribute("placeholder"));
        Assertions.assertFalse(driver.findElement(By.xpath("//input[@value='yes']")).isSelected());
        Assertions.assertFalse(driver.findElement(By.xpath("//input[@value='no']")).isSelected());
        Assertions.assertEquals("Project Description", driver.findElement(By.name("comment")).getAttribute("placeholder"));
    }

}
