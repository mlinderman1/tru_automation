package com.toysrus.automation.steps.pages;

import com.toysrus.automation.steps.common.*;
import com.toysrus.automation.steps.overlays.*;
import com.toysrus.automation.utils.LocatorProps;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class Page__Homepage extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String page = ".page-layout";
        public static final String page__homepage__tru = ".page-wrapper--tru";
        public static final String page__homepage__bru = ".page-wrapper--bru";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    Selectors selector = new Selectors();
    Overlay__LightBox lightBox = new Overlay__LightBox();
    String siteURL = null;

    @Before
    public void setUp() {
        getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void breakDown() {
        closeDriver();
    }

    @Given("^the user navigates to \"([^\"]*)\" site in \"([^\"]*)\" environment$")
    public void iNavigateToSiteSite(String site, String environment) throws Throwable {
    	
    	 String siteURL = LocatorProps.getProperty(environment.toLowerCase()+"."+site.toLowerCase());

        try{
            driver.navigate().to(siteURL);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        try
        {
            lightBox.theUserClosesTheLightbox();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @Then("^the user is on \"([^\"]*)\" homepage$")
    public void theUserIsOnHomepage(String site) throws Throwable {
        if (site.toLowerCase().contains("toys") || site.toLowerCase().equals("tru")) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.page__homepage__tru)));
        }
        else if (site.toLowerCase().contains("babies") || site.toLowerCase().equals("bru")) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.page__homepage__bru)));
        }
    }

    @And("^the user is on ToysRUs homepage$")
    public void theUserIsOnToysRUsHomepage() throws Throwable {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.page__homepage__tru)));
    }

    @And("^the user is on BabiesRUs homepage$")
    public void theUserIsOnBabiesRUsHomepage() throws Throwable {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.page__homepage__bru)));
    }

}

