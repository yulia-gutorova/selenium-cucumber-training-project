package Krishna_Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import selenium_tests.BasePage;

import java.util.List;

public class RegisterPageTest {

    public static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        BasePage.sleep(1000);

        driver.get("http://demo.automationtesting.in/Register.html");
        sleep(1000);

/*        //Find web element "Full Name" by absolut xpath
        //WebElement fullName = driver.findElement(By.xpath("html/body/section/div/div/div[2]/form/div[1]/label"));
        //cssSelector
        WebElement fullName = driver.findElement(By.cssSelector("[class='col-md-3 col-xs-3 col-sm-3 control-label'"));
        System.out.println("Full ame element, get text: " + fullName.getText());

        //Find element First Name by xpath
        //WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        //cssSelector
        WebElement  firstName = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        firstName.sendKeys("Uggla");
        firstName.clear();
        sleep(1000);
        firstName.sendKeys("UGGLA");
        sleep(1000);

        //Find element Last Name by placeholder
        //WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name'][@ng-model='LastName']"));
        //cssSelector
        WebElement lastName = driver.findElement(By.cssSelector("[placeholder='Last Name'][ng-model='LastName']"));
        lastName.sendKeys("Gut");
        sleep(1000);

        //Find element Address by xpath
        //WebElement address = driver.findElement(By.xpath("//label[contains(text(), 'Address')]"));
        //cssSelector
        WebElement address = driver.findElement(By.cssSelector("[class='col-md-3 col-xs-3 col-sm-3 control-label']"));
        System.out.println("Address element, get text: " + address.getText());
        sleep(1000);

        //Send the address to the address field
        //WebElement addressField = driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
        //cssSelector
        WebElement addressField = driver.findElement(By.cssSelector("textarea[ng-model^='Adress']"));
        addressField.sendKeys("Sweden, Stockholm");
        sleep(1000);

        //Find email element by xpath
        WebElement emailAddress = driver.findElement(By.xpath("//label[starts-with(text(), 'Email')]"));
        System.out.println("Email Address element, get text: " + emailAddress.getText());
        sleep(1000);

        //Send the email to the email field
        //WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        //cssSelector
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.sendKeys("my.emailgmail.com");
        sleep(1000);

        //Find phone element
        WebElement phone = driver.findElement(By.xpath("//label[contains(text(), 'Phone*')]"));
        System.out.println("Phone element, get text: " + phone.getText());
        sleep(1000);

        //Send the phone to the phone field
        //WebElement phoneField = driver.findElement(By.xpath("//input[@ng-model='Phone']"));
        //cssSelector
        WebElement phoneField = driver.findElement(By.cssSelector("input[type$='tel']"));
        phoneField.sendKeys("1234567890");
        sleep(1000);

        //Find gender element
        WebElement gender = driver.findElement(By.xpath("//label[text()='Gender*']"));
        System.out.println("Gender element, get text: " + gender.getText());
        sleep(1000);

//------------- Radio Buttons ---------------------------
        //Get a list of radio buttons
        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
        radioButtons.get(0).click();
        System.out.println("Radio Button value is: " + radioButtons.get(0).getAttribute("value") );
        sleep(1000);
        radioButtons.get(1).click();
        System.out.println("Radio Button value is: " + radioButtons.get(1).getAttribute("value") );
        sleep(1000);

//------------- checkBoxes---------------------------
        //Get a list of checkboxes
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        checkBoxes.forEach
                ( button->
                {
                    button.click();
                    System.out.println("Checkbox " + button.getAttribute("value") + " is clicked");
                    BasePage.sleep(1000);
                });
//-------------------------------------------------------------

//-----------Choose the language ------------------------------
        //Click on the language field
        WebElement language = driver.findElement(By.id("msdd"));
        //Actions actions = new Actions(driver);
        //actions.moveToElement(languages);
        //scroll down the web page on 1000 pixels
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        sleep(1000);
        language.click();
        sleep(1000);

       //Get a list of languages
        List<WebElement> languages = driver.findElements(By.xpath("//li[@class='ng-scope']"));
        System.out.println("Amount of languages is: " + languages.size());
        //Print all languages
        languages.forEach(l ->
        {
            String lan = l.getText();
            System.out.print(lan + " ");
            if (lan.equals("Catalan")||lan.equals("Arabic"))
            {l.click();}
        });
        sleep(3000);
        driver.findElement(By.xpath("//div[@class='ui-autocomplete-multiselect-item'][text()='Arabic']/span")).click();
        sleep(3000);*/


//-------------------------------------------------------------
//-----------Select dropdown box ??
//Elements have  to be <select> type

    WebElement countryDropDown = driver.findElement(By.id("countries"));
    Actions actions = new Actions(driver);
    actions.moveToElement(countryDropDown);
    sleep(1000);
    Select countries = new Select (countryDropDown);
    countries.selectByIndex(1);
    sleep(3000);
    countries.selectByVisibleText("Andorra");
    sleep(3000);

//Click on refresh button
        driver.findElement(By.id("Button1")).click();
        sleep(3000);

        driver.quit();
    }

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
