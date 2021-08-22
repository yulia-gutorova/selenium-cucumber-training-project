package Krishna_Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium_tests.BasePage;

import java.sql.SQLOutput;
import java.util.List;

public class TableTest extends RegisterPageTest{

    public static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        BasePage.sleep(1000);

        driver.get("https://editor.datatables.net/");
        sleep(1000);

        WebElement firstNameInTable= driver.findElement(By.xpath("//*[@id='row_5']/td[2]"));
        System.out.println("First name is: " + firstNameInTable.getText());

}}
