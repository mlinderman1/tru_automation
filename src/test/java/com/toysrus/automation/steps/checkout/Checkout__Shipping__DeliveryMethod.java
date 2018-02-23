package com.toysrus.automation.steps.checkout;

import com.toysrus.automation.lib.Data;
import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.common.Common_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.Random;

public class Checkout__Shipping__DeliveryMethod extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String radiobtn__shipping_method_selected = ".select-shipping-method-block.selected";

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

    public void loadDeliveryMethods() {
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(selector.radiobtn__shipping_method_selected)));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}