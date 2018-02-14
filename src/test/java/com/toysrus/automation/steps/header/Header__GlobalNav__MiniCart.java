package com.toysrus.automation.steps.header;

import com.toysrus.automation.steps.common.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header__GlobalNav__MiniCart extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String btn_global_nav__minicart = ".header-fat__tile.header-fat__tile-cart";
    }

    public class t2Selectors {
        public static final String btn_global_nav__minicart = ".global-nav-cart";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    Selectors selector = new Selectors();
    t2Selectors t2selector = new t2Selectors();

    @When("^the user clicks the minicart button from the global navbar$")
    public void theUserClicksTheMinicartButtonFromTheGlobalNavbar() throws Throwable {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.btn_global_nav__minicart)));
            driver.findElement(By.cssSelector(selector.btn_global_nav__minicart)).click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(t2selector.btn_global_nav__minicart)));
            driver.findElement(By.cssSelector(t2selector.btn_global_nav__minicart)).click();
        }
    }
}

