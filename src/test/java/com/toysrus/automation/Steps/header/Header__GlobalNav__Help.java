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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class Header__GlobalNav__Help extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String btn__global_nav__help = ".tru-dropdown.help-tile";
        public static final String link__global_nav__help__help_center = ".help-tile__submenu-item-link";
        public static final String btn__global_nav__help__moxie_online = ".help-tile__submenu-item--moxie";
        public static final String btn__global_nav__help__moxie_offline = ".help-tile__submenu-item--moxie--disabled";
    }

    public class t2Selectors {
        public static final String btn__global_nav__help = ".global-nav-help";
        public static final String btn__global_nav__help__moxie_online = "chatLive";
        public static final String btn__global_nav__help__moxie_offline = "chatOff";
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

    @And("^the user clicks 'Help' from the global navbar$")
    public WebElement theUserClicksHelpFromTheGlobalNavbar() throws Throwable {
        WebElement btn__global_nav__help = null;

        try {
            btn__global_nav__help = driver.findElement(By.cssSelector(selector.btn__global_nav__help));
            return btn__global_nav__help;
        }
        catch (Exception e) {

            btn__global_nav__help = driver.findElement(By.cssSelector(t2selector.btn__global_nav__help));
            return btn__global_nav__help;
        }
        finally {
            btn__global_nav__help.click();
        }
    }

}

