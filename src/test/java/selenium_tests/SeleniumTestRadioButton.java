package selenium_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class SeleniumTestRadioButton extends  SeleniumSetUppClass{
    String SITE_URL = "https://www.seleniumeasy.com/test/basic-radiobutton-demo.html";

    @Test
    @DisplayName("Open the page")
    public void openPage()
    {
        driver.get(SITE_URL);
        Assertions.assertEquals(SITE_URL, driver.getCurrentUrl());
        BasePage.sleep(1000);

        Assertions.assertEquals(SITE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Radio Button Demo - Click on button to get the selected value")
    public void b_clickOnRadioButton()
    {
        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='optradio']"));

        radioButtons.stream().forEach
                ( button->
                        {
                            button.click();
                            driver.findElement(By.id("buttoncheck")).click();
                            BasePage.sleep(2000);
                            switch (button.getAttribute("value"))
                            {
                                case "Male":
                                    Assertions.assertTrue(driver.findElement(By.xpath("//p[@class='radiobutton']")).getText().contains("Radio button 'Male' is checked"));
                                    break;
                                case "Female":
                                    Assertions.assertTrue(driver.findElement(By.xpath("//p[@class='radiobutton']")).getText().contains("Radio button 'Female' is checked"));
                                    break;
                            }
                        }
                );
    }

    @Test
    @DisplayName("Group Radio Buttons Demo - Click on button to get the selected value from group")
    public void c_clickOnGroupsRadioButton()
    {
        List <WebElement> sex = driver.findElements(By.xpath("//input[@name='gender']"));
        List <WebElement> ageGroup = driver.findElements(By.xpath("//input[@name='ageGroup']"));

        sex.stream().forEach(sexRadioButton ->
        {
            sexRadioButton.click();
            BasePage.sleep(1000);

            ageGroup.stream().forEach(ageGroupButton ->
            {
                ageGroupButton.click();
                BasePage.sleep(1000);

                driver.findElement(By.xpath("//button[@onclick='getValues();']")).click();
                BasePage.sleep(1000);

                WebElement groupRadioButton = driver.findElement(By.xpath("//p[@class='groupradiobutton']"));
                groupRadioButton.click();

                if (sexRadioButton.getAttribute("value").equals("Male"))
                {
                    switch (ageGroupButton.getAttribute("value"))
                    {
                        case "0 - 5":
                            Assertions.assertTrue(groupRadioButton.getText().contains("Sex : Male\n" + "Age group: 0 - 5"));
                            break;
                        case "5 - 15":
                            Assertions.assertTrue(groupRadioButton.getText().contains("Sex : Male\n" + "Age group: 5 - 15"));
                            break;

                        case "15 - 50":
                            Assertions.assertTrue(groupRadioButton.getText().contains("Sex : Male\n" + "Age group: 15 - 50"));
                            break;
                    }
                }
                else
                {
                    switch (ageGroupButton.getAttribute("value"))
                    {
                        case "0 - 5":
                            Assertions.assertTrue(groupRadioButton.getText().contains("Sex : Female\n" + "Age group: 0 - 5"));
                            break;
                        case "5 - 15":
                            Assertions.assertTrue(groupRadioButton.getText().contains("Sex : Female\n" + "Age group: 5 - 15"));
                            break;

                        case "15 - 50":
                            Assertions.assertTrue(groupRadioButton.getText().contains("Sex : Female\n" + "Age group: 15 - 50"));
                            break;
                    }
                }
            });
        });
    }

}
