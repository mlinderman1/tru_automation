package com.toysrus.automation.steps.pages;

import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.common.Common_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;
import com.toysrus.automation.utils.LocatorProps;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class Page__OrderConfirmation extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String container__page__order_confirmation = "#nongoodbye_order_confirmation";
        public static final String text__order_confirmation_number = ".checkout-order-complete-header__subheader--bold";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 60);
    Selectors selector = new Selectors();

    @Then("^the confirmation page is displayed$")
    public void iAmOnConfirmationPage() throws Throwable {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.container__page__order_confirmation)));

            WebElement orderConfNum = driver.findElement(By.cssSelector(selector.text__order_confirmation_number));
            wait.until(ExpectedConditions.visibilityOf(orderConfNum));
            System.out.println("ORDER CONF #: " + orderConfNum.getText());
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
    }

}

