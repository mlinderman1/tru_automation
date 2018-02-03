package com.toysrus.automation.Steps.header;

import com.toysrus.automation.Steps.common.AbstractPage_StepDefs;
import cucumber.api.java.After;
import cucumber.api.java.Before;
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
    WebDriverWait wait = new WebDriverWait(driver, 30);
    Selectors selector = new Selectors();
    t2Selectors t2selector = new t2Selectors();

    @Before
    public void setUp() {
        getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void breakDown() {
        closeDriver();
    }


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

