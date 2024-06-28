package com.sudipta.stepDefintions;

import com.sudipta.pages.TourismVisaInfo;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

import org.junit.Assert;

import java.util.Properties;


public class StepDefinitions {

    private static WebDriver driver = new ChromeDriver();
    private static Properties prop = new Properties();

    @BeforeAll
    static void setup() throws Exception {

        WebDriverManager.chromedriver().setup();

    }

    @Given("User has visted the website")
    public void user_has_visted_the_website() {
        driver.get("https://www.gov.uk/check-uk-visa");
    }

    @Given("User clicks the start now button")
    public void user_click_the_start_now_button() {

        WebElement startNowButton = driver.findElement(By.linkText("Start now"));
        startNowButton.click();

    }

    @Given("User selects the \"([^\\\"]*)\" and continue$")
    public void user_click_the_country(String agr1) {

        WebElement selectElement = driver.findElement(By.name("response"));
        Select select = new Select(selectElement);

        select.selectByVisibleText("Australia");

        WebElement continueButton = driver.findElement(By.cssSelector("button.gem-c-button.govuk-button.gem-c-button--bottom-margin"));
        continueButton.click();

    }

    @Given("User selects tourism for visiting the country and continue")
    public void user_select_tourism() {

        WebElement radioTourismButton = driver.findElement(By.cssSelector("input#response-0"));
        radioTourismButton.click();

        WebElement continueButton = driver.findElement(By.cssSelector("button.gem-c-button.govuk-button.gem-c-button--bottom-margin"));
        continueButton.click();

    }

    @Given("User will not need a visa to come to the UK for tourism")
    public void user_not_needed_Visa_Tourism() {

        TourismVisaInfo tpage = new TourismVisaInfo();
        WebElement confirmYTextElement = tpage.getYvisaElement(driver);
        String actualText = confirmYTextElement.getText();

        String expectedText = "You will not need a visa to come to the UK";

        Assert.assertEquals(actualText, expectedText);

        driver.quit();

    }


    @AfterAll
    static void last() {

        // driver.quit();
    }
}