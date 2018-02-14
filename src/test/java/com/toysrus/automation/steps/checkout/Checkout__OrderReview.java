package com.toysrus.automation.steps.checkout;

import com.toysrus.automation.lib.Data;
import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.common.Common_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.Random;

public class Checkout__OrderReview extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String container__page__order_review = "#review-tab";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    URL siteURL;
    Random rand = new Random();
    int n;
    Overlay__LightBox lightBox = new Overlay__LightBox();
    Selectors selector = new Selectors();
    Data.user1 user = new Data.user1();
    Data.credit_card__Visa cc = new Data.credit_card__Visa();
    Common_StepDefs common = new Common_StepDefs();
    Checkout__Shipping__DeliveryMethod delivery = new Checkout__Shipping__DeliveryMethod();

    @And("^the user is on order review page$")
    public void theUserIsOnOrderReviewPage() throws Throwable {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.container__page__order_review)));
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

}