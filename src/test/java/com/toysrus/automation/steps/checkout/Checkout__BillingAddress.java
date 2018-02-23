package com.toysrus.automation.steps.checkout;

import com.toysrus.automation.lib.Data;
import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.common.Common_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.Random;

public class Checkout__BillingAddress extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String input__address_field = Checkout__Common.Selectors.input__address_field;
        public static final String container__billing__address_form = ".checkout-shipping-address-form-content";
        public static final String input__billing__first_name = "#firstName";
        public static final String input__billing__last_name = "#lastName";
        public static final String input__billing__address1 = "#address1";
        public static final String input__billing__address2 = "#address2";
        public static final String input__billing__city = "#city";
        public static final String dropdown__billing__state = "#state";
        public static final String input__billing__zip = "#postalCode";
        public static final String input__billing__phone = "#phoneNumber";
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

    private void inputBillingField(int field) {
        switch (field) {
            case 1:
                inputBillingFirstName();
                break;
            case 2:
                inputBillingLastName();
                break;
            case 3:
                inputBillingAddress1();
                break;
            case 4:
                inputBillingAddress2();
                break;
            case 5:
                inputBillingCity();
                break;
            case 6:
                inputBillingState();
                break;
            case 7:
                inputBillingZip();
                break;
            case 8:
                inputBillingPhone();
                break;
        }
    }

    private void inputBillingFirstName() {
        String cssSelector = selector.input__billing__first_name;
        String data = user.user__billing__first_name;

        common.inputField(cssSelector, data);

    }

    private void inputBillingLastName() {
        String cssSelector = selector.input__billing__last_name;
        String data = user.user__billing__last_name;

        common.inputField(cssSelector, data);
    }

    private void inputBillingAddress1() {
        String cssSelector = selector.input__billing__address1;
        String data = user.user__billing__address1;

        common.inputField(cssSelector, data);
    }

    private void inputBillingAddress2() {
        String cssSelector = selector.input__billing__address2;
        String data = user.user__billing__address2;

        common.inputField(cssSelector, data);
    }

    private void inputBillingCity() {
        String cssSelector = selector.input__billing__city;
        String data = user.user__billing__city;

        common.inputField(cssSelector, data);
    }


    private void inputBillingState() {
        String cssSelector = selector.dropdown__billing__state;
        String data = user.user__billing__state;

        common.selectFromDropdownMenu(cssSelector, data);
    }

    private void inputBillingZip() {
        String cssSelector = selector.input__billing__zip;
        String data = user.user__billing__zip;

        common.inputField(cssSelector, data);
    }

    private void inputBillingPhone() {
        String cssSelector = selector.input__billing__phone;
        String data = user.user__billing__phone;

        common.inputField(cssSelector, data);
    }

    @And("^the user inputs billing address during checkout$")
    public void iInputBillingAddressDuringCheckout() throws Throwable {
        int billingFieldsCount = driver.findElements(By.cssSelector(selector.container__billing__address_form+ " " +selector.input__address_field)).size();
        try {

            for (int x = 1; x <= billingFieldsCount; x++) {
                inputBillingField(x);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}