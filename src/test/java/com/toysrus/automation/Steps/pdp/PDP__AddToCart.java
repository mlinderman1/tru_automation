package com.toysrus.automation.Steps.pdp;

import com.toysrus.automation.Steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.Steps.overlays.Overlay__AddToCart;
import com.toysrus.automation.Steps.flyouts.Flyout__PickupInStore;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.toysrus.automation.lib.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PDP__AddToCart extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String btn__pdp__add_to_cart = ".tru-product-actions__primary-button";
        public static final String btn__add_to_cart = "//button/span[text()='add to cart']";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    Selectors selector = new Selectors();
    Random rand = new Random();
    Flyout__PickupInStore ispu = new Flyout__PickupInStore();

    @Before
    public void setUp() {
        getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void breakDown() {
        closeDriver();
    }

    @Then("^the user adds PDP item to cart$")
    public void iAddPDPItemToCart() throws Throwable {
        WebElement btn__add_to_cart = driver.findElement(By.cssSelector(selector.btn__pdp__add_to_cart));

        wait.until(ExpectedConditions.elementToBeClickable(btn__add_to_cart));

        btn__add_to_cart.click();

        try {
            ispu.theUserSelectsStoreToPickUpItem();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
