package com.toysrus.automation.steps.checkout;

import com.toysrus.automation.lib.Data;
import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.common.Common_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.Random;

public class Checkout__RewardsRUs extends AbstractPage_StepDefs {

    public class Selectors {
       
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



}