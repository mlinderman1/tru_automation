package com.toysrus.automation.steps.pdp;

import com.toysrus.automation.steps.common.*;
import com.toysrus.automation.steps.flyouts.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class PDP__AddToCart extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String btn__pdp__add_to_cart = ".tru-product-actions__primary-button";
        public static final String btn__add_to_cart = "//button/span[text()='add to cart']";
        public static final String sticky__footer = ".pdp-sticky-footer";
        public static final String btn__add_to_cart__sticky_footer = ".pdp-cta-primary-button";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    Selectors selector = new Selectors();
    Random rand = new Random();
    Flyout__PickupInStore ispu = new Flyout__PickupInStore();

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
    
    @When("^the user adds PDP item to cart from sticky footer$")
    public void the_user_adds_PDP_item_to_cart_from_sticky_footer() throws Throwable {
    	WebElement stickyFooter = driver.findElement(By.cssSelector(selector.sticky__footer));
    	WebElement btn__add_to_cart__stickyFooter = stickyFooter.findElement(By.cssSelector(selector.btn__add_to_cart__sticky_footer));
    	btn__add_to_cart__stickyFooter.click();

	}    


}
