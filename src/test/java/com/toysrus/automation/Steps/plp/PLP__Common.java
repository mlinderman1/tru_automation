package com.toysrus.automation.Steps.plp;

import com.toysrus.automation.Steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.Steps.common.Common_StepDefs;
import com.toysrus.automation.Steps.flyouts.Flyout__Common;
import com.toysrus.automation.Steps.flyouts.Flyout__PickupInStore;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class PLP__Common extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String container__page__plp1 = ".webstore-plp-page";
        public static final String container__page__plp2 = ".webstore-search-page__product-grid";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    Random rand = new Random();
    Selectors selector = new Selectors();
    int n;

    @Before
    public void setUp() {
        getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void breakDown() {
        closeDriver();
    }

    @And("^the user is on the PLP page$")
    public void theUserIsOnPlpPage() throws Throwable {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.container__page__plp1)));
        } catch (Exception e) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.container__page__plp2)));
        }
    }

}