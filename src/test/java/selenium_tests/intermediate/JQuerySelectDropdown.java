package selenium_tests.intermediate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import selenium_tests.BasePage;
import selenium_tests.SeleniumSetUppClass;

import java.util.List;

public class JQuerySelectDropdown extends SeleniumSetUppClass {

    String SITE_URL = "https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html";
    Actions actions = new Actions (driver);

    @Test
    @Order(1)
    @DisplayName("Open the page")
    public void openPage()
    {
        driver.get(SITE_URL);
        Assertions.assertEquals(SITE_URL, driver.getCurrentUrl());
        BasePage.sleep(1000);
    }

    @Test
    @Order(2)
    @DisplayName("Drop Down with Search Box")
    public void testDropDownWithSearchBox()
    {
        WebElement selectCountry = driver.findElement(By.xpath("//span[@aria-labelledby='select2-country-container']"));
        actions.moveToElement(selectCountry).click().build().perform();
        //selectCountry.click();
        BasePage.sleep(3000);
        //WebElement writeCountry = driver.findElement(By.cssSelector(".select2-dropdown.select2-dropdown--below  input[role='textbox']"));//select2-dropdown.select2-dropdown--above  input[role='textbox']
        //writeCountry.sendKeys("Au");
        WebElement writeCountry = driver.findElement(By.xpath("//span[@class= 'select2-container select2-container--default select2-container--open']"));

        BasePage.sleep(5000);

        //select2-container select2-container--default select2-container--open
        actions.moveToElement(writeCountry).sendKeys("Au").sendKeys(Keys.ENTER).click().build().perform();
        BasePage.sleep(5000);

        String str = driver.findElement(By.id("select2-country-container")).getText();
        System.out.println("Text: " + str);

    }


}
