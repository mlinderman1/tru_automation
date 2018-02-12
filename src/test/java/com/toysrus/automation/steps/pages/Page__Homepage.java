package com.toysrus.automation.steps.pages;

import com.toysrus.automation.steps.common.*;
import com.toysrus.automation.steps.overlays.*;
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

import java.io.IOException;
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
    URL siteURL;
    Overlay__LightBox lightBox = new Overlay__LightBox();


    @Before
    public void init() throws IOException{
        setUp();
        getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void breakDown() {
        closeDriver();
    }

    public String getURL() throws Throwable{
//        String env = System.getProperty("env");  //WORKS FOR MAVEN
        String env = prop.getProperty("env");
//        String env = System.getenv("ENVIRONMENT");  //WORKS FOR IDE
        String env_prefix = null;

        if (env.toLowerCase().contains("prod")){
            env_prefix = "https://www.";
            return env_prefix;
        }
        else if (env.toLowerCase().equals("qa2")){
            env_prefix = "https://webstoreqa2.";
            return env_prefix;
        }
        return null;
    }


    @And("^the user navigates to \"([^\"]*)\" site$")
    public void iNavigateToSiteSite(String site) throws Throwable {
//        System.out.println("XXXXXXX "+System.getProperty("env"));
        String env_prefix = getURL();
        String siteURL = null;

        if (site.toLowerCase().contains("toys") || site.toLowerCase().equals("tru")) {
            siteURL = env_prefix + "toysrus.com";
        } else if (site.toLowerCase().contains("babies") || site.toLowerCase().equals("bru")) {
            siteURL = env_prefix + "babiesrus.com";
        } else if (site.toLowerCase().contains("registry")) {
        }
        try {
            driver.navigate().to(siteURL);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Common_StepDefs.Selectors.page)));

            try {
                lightBox.theUserClosesTheLightbox();
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Given("^the user navigates to ToysRUs site$")
    public void theUserNavigatesToToysRUsSite() throws Throwable {
        String env_prefix = getURL();
        String siteURL = env_prefix + "toysrus.com";
        try{
            driver.navigate().to(siteURL);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Common_StepDefs.Selectors.page)));

            try
            {
                lightBox.theUserClosesTheLightbox();
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @Given("^the user navigates to BabiesRUs site$")
    public void theUserNavigatesToBabiesRUsSite() throws Throwable {
        String env_prefix = getURL();
        String siteURL = env_prefix + "babiesrus.com";
        try{
            driver.navigate().to(siteURL);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Common_StepDefs.Selectors.page)));

            try
            {
                lightBox.theUserClosesTheLightbox();
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
        catch(Exception e){
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

