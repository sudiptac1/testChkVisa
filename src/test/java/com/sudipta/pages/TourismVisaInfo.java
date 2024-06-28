package com.sudipta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TourismVisaInfo {

    public WebElement getYvisaElement(WebDriver driver) {

        WebElement confirmTextElement = driver.findElement(By.cssSelector("h2.gem-c-heading.gem-c-heading--font-size-27.govuk-\\!-margin-bottom-6"));
        return confirmTextElement;

    }
}
