package com.toysrus.automation.steps.flyouts;

import com.toysrus.automation.steps.common.*;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flyout__FindAStore extends AbstractPage_StepDefs {


    public class Selectors {
        public static final String container__find_a_store = ".ispu-modal";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    Selectors selector = new Selectors();

    @Then("^the Find a Store flyout is displayed$")
    public void theFindAStoreFlyoutIsDisplayed() throws Throwable {
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.container__find_a_store)));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }


}