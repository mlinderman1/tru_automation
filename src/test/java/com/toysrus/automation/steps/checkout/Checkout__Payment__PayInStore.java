package com.toysrus.automation.steps.checkout;

import com.toysrus.automation.lib.Data;
import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.common.Common_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.Random;

public class Checkout__Payment__PayInStore extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String radiobtn__pay_in_store = "#radio-payinstore";
        public static final String radiobtn__pay_in_store_unselected = ".payment-checkbox-payinstore.checkout-flow-radio-unselected";
        public static final String radiobtn__pay_in_store_selected = ".payment-checkbox-payinstore.checkout-flow-radio-selected";
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

    @And("^the user chooses pay in store as method of payment$")
    public void theUserChoosesPayInStoreAsMethodOfPayment() throws Throwable {
        WebElement billing_payInStore = driver.findElement(By.cssSelector(selector.radiobtn__pay_in_store));
        wait.until(ExpectedConditions.elementToBeClickable(billing_payInStore));
        billing_payInStore.click();
    }

}