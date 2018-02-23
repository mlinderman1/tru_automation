package com.toysrus.automation.steps.checkout;

import com.toysrus.automation.lib.Data;
import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.common.Common_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;
import com.toysrus.automation.steps.checkout.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Random;

public class Checkout__Common extends AbstractPage_StepDefs {


    public class Selectors {
        public static final String container__page__order_review = Checkout__OrderReview.Selectors.container__page__order_review;

        public static final String btn__order_review = ".checkout-review-order";
        public static final String btn__secure_checkout = ".summary-block-secure-checkout";

        public static final String input__address_field = ".shipping-address-field";

        public static final String container__page__checkout = "#checkout-container";

        public static final String btn__continue_to_payment = "#continue_to_payment";
        public static final String btn__continue_to_pickup = "#continue_to_pickup";
        public static final String btn__continue_to_gifting = "#continue_to_gifting";

        public static final String container__checkout__billing = ".checkout-payment";
        public static final String input__checkout__email = "#orderEmail";

        public static final String btn__checkout__place_order = "#nongoodbye_commitOrder";
        public static final String btn__order_review__place_order = "#nongoodbye_place_order_now";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    URL siteURL;
    Random rand = new Random();
    int n;
    Overlay__LightBox lightBox = new Overlay__LightBox();
    Selectors selector = new Selectors();
    Checkout__AddressDoctor addressDoctor = new Checkout__AddressDoctor();
    Data.user1 user = new Data.user1();
    Common_StepDefs common = new Common_StepDefs();

    @And("^the user is on the checkout page$")
    public void theUserIsOnTheCartPage() throws Throwable {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.container__page__checkout)));
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                lightBox.theUserClosesTheLightbox();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    @And("^the user continues to next tab during checkout$")
    public void iContinueToNextTabDuringCheckout() throws Throwable {
        String payment = selector.btn__continue_to_payment;
        String pickup = selector.btn__continue_to_pickup;
        String gifting = selector.btn__continue_to_gifting;

        if (driver.findElements(By.cssSelector(payment)).size() > 0) {
            WebElement continue_btn = driver.findElement(By.cssSelector(payment));
            wait.until(ExpectedConditions.elementToBeClickable(continue_btn));
            continue_btn.click();
        }

        if (driver.findElements(By.cssSelector(pickup)).size() > 0) {
            WebElement continue_btn = driver.findElement(By.cssSelector(pickup));
            wait.until(ExpectedConditions.elementToBeClickable(continue_btn));
            continue_btn.click();
        }

        if (driver.findElements(By.cssSelector(gifting)).size() > 0) {
            WebElement continue_btn = driver.findElement(By.cssSelector(gifting));
            wait.until(ExpectedConditions.elementToBeClickable(continue_btn));
            continue_btn.click();
        }

        try{
            addressDoctor.theUserOptsForInputtedAddress();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @And("^the user is on the billing tab of checkout$")
    public void theUserIsOnTheBillingTabOfCheckout() throws Throwable {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.container__checkout__billing)));
        }
        catch(Exception e){
            return;
        }
    }

    @Then("^the user inputs email during checkout$")
    public void iInputEmailDuringCheckout() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.container__checkout__billing)));

        String cssSelector = selector.input__checkout__email;
        String data = user.user__email;

        common.inputField(cssSelector, data);
    }

    @And("^the user clicks 'review order' button$")
    public void theUserClicksReviewOrderButton() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.btn__order_review)));

        WebElement orderReviewBtn = driver.findElement(By.cssSelector(selector.btn__order_review));
        orderReviewBtn.click();
    }


    @And("^the user clicks place order button$")
    public void theUserClicksPlaceOrderButton() throws Throwable {
        try {
            if (driver.findElements(By.cssSelector(selector.container__page__order_review)).size() > 0) {
                WebElement placeOrder_btn = driver.findElement(By.cssSelector(selector.btn__order_review__place_order));
                placeOrder_btn.click();
            }
            if (driver.findElements(By.cssSelector(selector.container__checkout__billing)).size() > 0) {
                WebElement placeOrder_btn = driver.findElement(By.cssSelector(selector.btn__checkout__place_order));
                placeOrder_btn.click();
            }
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
    }
}