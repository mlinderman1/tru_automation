package com.toysrus.automation.Steps.overlays;

import com.toysrus.automation.Steps.common.AbstractPage_StepDefs;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

public class Overlay__AddToCart extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String overlay__add_to_cart = ".atc-overlay";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    Selectors selector = new Selectors();

    @Before
    public void setUp() {
        getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void breakDown() {
        closeDriver();
    }

    @Then("^the Add to Cart overlay is displayed$")
    public void theAddToCartOverlayIsDisplayed() throws Throwable {
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.overlay__add_to_cart)));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @Then("^the user verifies if Add to Cart overlay is displayed$")
    public Boolean theUserVerifiesIfAddToCartOverlayIsDisplayed() throws Throwable {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.overlay__add_to_cart)));
            WebElement overlay__add_to_cart = driver.findElement(By.cssSelector(selector.overlay__add_to_cart));

            if (overlay__add_to_cart.isDisplayed()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @And("^the user waits for the Add to Cart overlay to not be displayed$")
    public void theUserWaitsForTheAddToCartOverlayToNotBeDisplayed() throws Throwable {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(selector.overlay__add_to_cart)));
    }
}
