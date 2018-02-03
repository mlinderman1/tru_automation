package com.toysrus.automation.Steps.header;

import com.toysrus.automation.Steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.Steps.common.Common_StepDefs;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class Header__GlobalNav__MyAccount extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String btn__global_nav__my_account = ".header-fat__tile.header-fat__tile-my-account";
        public static final String dropdown__global_nav__my_account = ".header-fat-my-account__desktop";
    }

    public class t2Selectors {
        public static final String btn__global_nav__my_account = "#my-account-popover";
        public static final String dropdown__global_nav__my_account =  "#my-account-popover-struct";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    Random rand = new Random();
    int n;
    Common_StepDefs common = new Common_StepDefs();
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

    @And("^the user clicks 'My Account' from the global navbar$")
    public WebElement theUserClicksMyAccountFromTheGlobalNavbar() throws Throwable {
        WebElement btn__global_nav__my_account = null;

        try {
            btn__global_nav__my_account = driver.findElement(By.cssSelector(selector.btn__global_nav__my_account));
            return btn__global_nav__my_account;
        }
        catch (Exception e) {
            btn__global_nav__my_account = driver.findElement(By.cssSelector(t2selector.btn__global_nav__my_account));
            return btn__global_nav__my_account;
        }
        finally {
            btn__global_nav__my_account.click();
        }
    }
}
