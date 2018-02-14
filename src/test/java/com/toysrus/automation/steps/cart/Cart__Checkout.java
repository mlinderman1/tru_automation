package com.toysrus.automation.steps.cart;

import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.Random;

public class Cart__Checkout extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String btn__checkout_standard__top = "#cart_page_top_checkout";
        public static final String btn__checkout_standard__bottom = "#cart_page_bottom_checkout";
        public static final String btn__checkout_PayPal = ".order-summary-payment-buttons__paypal-button";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    URL siteURL;
    Random rand = new Random();
    int n;
    Overlay__LightBox lightBox = new Overlay__LightBox();
    Selectors selector = new Selectors();

    @And("^the user proceeds to \"([^\"]*)\" checkout$")
    public void iProceedToCheckout(String checkoutType) throws Throwable {
        if (checkoutType.toLowerCase().equals("paypal")||checkoutType.toLowerCase().contains("pay")){
            WebElement payPalBtn = driver.findElement(By.cssSelector(selector.btn__checkout_PayPal));
            payPalBtn.click();
        }
        else {
            WebElement bottom_checkout = driver.findElement(By.cssSelector(selector.btn__checkout_standard__bottom));
            bottom_checkout.click();
        }
    }

}