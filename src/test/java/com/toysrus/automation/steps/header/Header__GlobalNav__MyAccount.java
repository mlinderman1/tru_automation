package com.toysrus.automation.steps.header;

import com.toysrus.automation.steps.common.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class Header__GlobalNav__MyAccount extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String btn__global_nav__my_account = ".header-fat__tile.header-fat__tile-my-account";
        public static final String dropdown__global_nav__my_account = ".header-fat-my-account__desktop";
        public static final String page__global_nav__create = ".header-fat-my-account__top__register";
        public static final String btn_signOut = "#headerLogoutLink";
        public static final String btn_signin ="div#signInBtn a"; 
        public static final String page__global_nav__aws__create = "p.header-register-link a";
        public static final String btn__global_nav__welcomeback = "div#my-account-popover";
    }

    public class t2Selectors {
        public static final String btn__global_nav__my_account = "#my-account-popover";
        public static final String dropdown__global_nav__my_account =  "#my-account-popover-struct";
        public static final String page__global_nav__create = "//a[text() = 'register']";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    Random rand = new Random();
    int n;
    Common_StepDefs common = new Common_StepDefs();
    Selectors selector = new Selectors();
    t2Selectors t2selector = new t2Selectors();

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
    @And("^the user clicks 'Create' from the global navbar$")
    public WebElement theUserClicksCreateFromTheGlobalNavbar() throws Throwable {
        WebElement btn__global_nav__create = null;

        try {
        	btn__global_nav__create = driver.findElement(By.cssSelector(selector.page__global_nav__create));
            return btn__global_nav__create;
        }
        catch (Exception e) {
        	btn__global_nav__create = driver.findElement(By.cssSelector(Selectors.page__global_nav__aws__create));
            return btn__global_nav__create;
        }
        finally {
        	btn__global_nav__create.click();
        }
        
        
    }
    @And("^user clicks on welcome back$")
    public void user_clicks_on_welcome_back() throws InterruptedException {
    	//common.clickOn(Selectors.btn__global_nav__welcomeback);
    	common.waitduration(15000l);
    	common.javascriptClick(driver.findElement(By.cssSelector(Selectors.btn__global_nav__welcomeback)));
    	common.waitForWebElement(Selectors.btn_signOut);
    }

	@Then("^user sign out from ATG$")
	public void user_sign_out_from_ATG() {
		common.waitForWebElement(Selectors.btn_signOut);
		common.clickOn(Selectors.btn_signOut);
	}
	
	@Then("^user clicks sign in from the global navbar$")
	public void user_clicks_sign_in_from_the_global_navbar()  {
		common.clickOn(Selectors.btn_signin);
	    }

}
