package com.toysrus.automation.Steps.pages;

import com.toysrus.automation.Steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.Steps.common.Common_StepDefs;
import com.toysrus.automation.Steps.overlays.Overlay__LightBox;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.*;
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
    WebDriverWait wait = new WebDriverWait(driver, 30);
    Selectors selector = new Selectors();
    URL siteURL;
    Overlay__LightBox lightBox = new Overlay__LightBox();

    @Before
    public void setUp() {
        getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void breakDown() {
        closeDriver();
    }


    @And("^the user navigates to \"([^\"]*)\" site in \"([^\"]*)\" environment$")
    public void iNavigateToSiteSite(String site, String environment) throws Throwable {

        try{
            if (site.toLowerCase().contains("toys") || site.toLowerCase().equals("tru")) {
                if (environment.toLowerCase().contains("prod") || environment.toLowerCase().contains("live")){
                    siteURL = new URL("https://www.toysrus.com");
                }
                else if (environment.toLowerCase().equals("qa1")) {
                    siteURL = new URL("https://webstoreqa1.toysrus.com");
                }
                else if (environment.toLowerCase().equals("qa2")) {
                    siteURL = new URL("https://webstoreqa2.toysrus.com");
                }
                else if (environment.toLowerCase().equals("qa4")) {
                    siteURL = new URL("https://webstoreqa4.toysrus.com");
                }
                else if (environment.toLowerCase().equals("staging")) {
                    siteURL = new URL("https://webstorestaging.toysrus.com");
                }

            } else if (site.toLowerCase().contains("babies") || site.toLowerCase().equals("bru")) {
                if (environment.toLowerCase().contains("prod")){
                    siteURL = new URL("https://www.babiesrus.com");
                }
                else if (environment.toLowerCase().equals("qa1")) {
                    siteURL = new URL("https://webstoreqa1.babiesrus.com");
                }
                else if (environment.toLowerCase().equals("qa2")) {
                    siteURL = new URL("https://webstoreqa2.babiesrus.com");
                }
                else if (environment.toLowerCase().equals("qa4")) {
                    siteURL = new URL("https://webstoreqa4.babiesrus.com");
                }
                else if (environment.toLowerCase().equals("staging")) {
                    siteURL = new URL("https://webstorestaging.babiesrus.com");
                }
            } else if (site.toLowerCase().contains("registry")) {
                if (environment.toLowerCase().contains("prod")){
                    siteURL = new URL("https://babyregistry.toysrus.com");
                }
                else if (environment.toLowerCase().equals("qa1")) {
                    siteURL = new URL("");
                }
                else if (environment.toLowerCase().equals("qa2")) {
                    siteURL = new URL("");
                }
                else if (environment.toLowerCase().equals("staging")) {
                    siteURL = new URL("https://babyregistryuat.toysrus.com");
                }
            } else if ((site.toLowerCase().equals("wishlist") || (site.toLowerCase().equals("wish list")))) {
                if (environment.toLowerCase().contains("prod")){
                    siteURL = new URL("https://wishlist.toysrus.com");
                }
                else if (environment.toLowerCase().equals("qa1")) {
                    siteURL = new URL("");
                }
                else if (environment.toLowerCase().equals("qa2")) {
                    siteURL = new URL("");
                }
                else if (environment.toLowerCase().equals("staging")) {
                    siteURL = new URL("https://wishlistuat.toysrus.com");
                }
            }
            driver.navigate().to(siteURL);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Common_StepDefs.Selectors.page)));
        }
        catch (InvalidArgumentException e) {
            System.out.println(e);
        }

        try
        {
            lightBox.theUserClosesTheLightbox();
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println(e);
        }

        catch (TimeoutException e) {
            System.out.println(e);
        }

        finally
        {
            System.out.println("Navigated to " + driver.getCurrentUrl());
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
