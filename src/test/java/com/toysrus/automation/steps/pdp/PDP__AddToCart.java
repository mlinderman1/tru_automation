package com.toysrus.automation.steps.pdp;

import com.toysrus.automation.steps.common.*;
import com.toysrus.automation.steps.flyouts.*;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class PDP__AddToCart extends AbstractPage_StepDefs {

    public static class Selectors {
        public static final String btn__pdp__add_to_cart = ".pdp-cta-primary-button";
        public static final String btn__add_to_cart = "//button/span[text()='add to cart']";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    Random rand = new Random();
    Flyout__PickupInStore ispu = new Flyout__PickupInStore();

    @Then("^the user adds PDP item to cart$")
    public void iAddPDPItemToCart() throws Throwable {
        WebElement btn__add_to_cart = driver.findElement(By.cssSelector(Selectors.btn__pdp__add_to_cart));

        wait.until(ExpectedConditions.elementToBeClickable(btn__add_to_cart));

        btn__add_to_cart.click();

        try {
            ispu.theUserSelectsStoreToPickUpItem();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
