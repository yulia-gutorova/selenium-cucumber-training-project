package selenium_tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.stream.Stream;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ParameterizedTestInputForms extends SeleniumSetUppClass{

    public  static Stream <Arguments> data()
    {
        return Stream.of(
                Arguments.of("1", "2", "3"),
                Arguments.of("-1","-2","-3"),
                Arguments.of("-100","2","-98"),
                Arguments.of("-26464643","26464643","0"),
                Arguments.of("jdbcjfwhe","-2","NaN"),
                Arguments.of("jdnfhiew","-oiokl","NaN")
        );
    }

    

    String SITE_URL = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";

    @DisplayName("Open a website")
    @Test
    @Order(1)
    public void a_openPage() {
        driver.get(SITE_URL);
        Assertions.assertEquals(SITE_URL, driver.getCurrentUrl());
        BasePage.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement close = driver.findElement(By.id("at-cv-lightbox-close"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("at-cv-lightbox-close")));
        close.click();
        BasePage.sleep(1000);

        Assertions.assertEquals(SITE_URL, driver.getCurrentUrl());
    }


    @ParameterizedTest(name = "{index} => param1= {0}, param2= {1}, summa= {2}")
    @MethodSource("data")
    @DisplayName("Enter two messages with different parameters")
    @Order(2)
    public void  b_enterValues(String arg1, String arg2, String summa)
    {
        WebElement enterValueA = driver.findElement(By.id(("sum1")));

        Actions actions = new Actions(driver);
        actions.moveToElement(enterValueA);

        enterValueA.clear();
        enterValueA.sendKeys(arg1);
        BasePage.sleep(1000);

        WebElement enterValueB = driver.findElement(By.id(("sum2")));
        enterValueB.clear();
        enterValueB.sendKeys(arg2);
        BasePage.sleep(1000);

        WebElement getTotal = driver.findElement(By.xpath("//button[@onclick='return total()']"));
        getTotal.click();
        BasePage.sleep(1000);

        WebElement total = driver.findElement(By.id("displayvalue"));
        Assertions.assertEquals(summa, total.getText());
    }

}
