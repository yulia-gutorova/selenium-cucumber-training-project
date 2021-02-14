package selenium_tests;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@TestMethodOrder(MethodOrderer.MethodName.class)

public class SeleniunTestSelectDropDownList extends SeleniumSetUppClass{

    String  SITE_URL = "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";

    @Test
    @DisplayName("Open a page")
    public void a_openPage()
    {
        driver.get(SITE_URL);
        BasePage.sleep(1000);
        Assertions.assertEquals(SITE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Select value from drop down list")
    public void b_selectListDemo()
    {
        WebElement dropDownList = driver.findElement(By.id("select-demo"));
        Select selectDropDownElements = new Select(dropDownList);
        List <WebElement> options = selectDropDownElements.getOptions();
        options.remove(0);

        options.forEach(option -> {
            selectDropDownElements.selectByVisibleText(option.getText());
            BasePage.sleep(1000);
            String expectedString = "Day selected :- " + option.getText();
            String actualString = driver.findElement(By.xpath("//p[@class='selected-value']")).getText();
            Assert.assertEquals(expectedString, actualString);
        });
    }

    @Test
    @DisplayName("Multi Select List Demo")
    public void c_selectListDemo()
    {
        System.out.println("Multi Select List Demo");
        WebElement multiSelectList = driver.findElement(By.id("multi-select"));
        Select selectDropDownElements = new Select(multiSelectList);
        List <WebElement> values = selectDropDownElements.getOptions();

        values.forEach(value -> {
            selectDropDownElements.selectByVisibleText(value.getText());
            BasePage.sleep(1000);

            driver.findElement(By.xpath("//button[@value='Print First']")).click();
            BasePage.sleep(1000);

            String expectedStringFirstSelected = "First selected option is : " + value.getText();
            String actualStringFirstSelected = driver.findElement(By.xpath("//p[@class='getall-selected']")).getText();
            BasePage.sleep(1000);

            driver.findElement(By.xpath("//button[@value='Print All']")).click();
            BasePage.sleep(1000);

            String expectedStringGetAllSelected = "Options selected are : " + value.getText();
            String actualStringGetAllSelected  = driver.findElement(By.xpath("//p[@class='getall-selected']")).getText();
            BasePage.sleep(1000);

            Assert.assertEquals(expectedStringFirstSelected, actualStringFirstSelected);
            Assert.assertEquals(expectedStringGetAllSelected, actualStringGetAllSelected);

        });

    }
}
