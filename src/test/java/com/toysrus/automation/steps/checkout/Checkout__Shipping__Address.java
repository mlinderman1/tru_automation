package com.toysrus.automation.steps.checkout;

import com.toysrus.automation.lib.Data;
import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.common.Common_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.Random;

public class Checkout__Shipping__Address extends AbstractPage_StepDefs {

    public static class Selectors {
        public static final String container__shipping = ".checkout-shipping-content";

        public static final String input__address_field = ".shipping-address-field";

        public static final String input__shipping__first_name = "#fname";
        public static final String input__shipping__last_name = "#lname";
        public static final String input__shipping__address1 = "#address1";
        public static final String input__shipping__address2 = "#aptsuite";
        public static final String input__shipping__city = "#city";
        public static final String dropdown__shipping__state = "#state";
        public static final String input__shipping__zip = "#zip";
        public static final String input__shipping__phone = "#telephone";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    URL siteURL;
    Random rand = new Random();
    int n;
    Overlay__LightBox lightBox = new Overlay__LightBox();
    Data.user1 user = new Data.user1();
//    Data.addressVerificationTestUser user = new Data.addressVerificationTestUser();
    Data.credit_card__Visa cc = new Data.credit_card__Visa();
    Common_StepDefs common = new Common_StepDefs();
    Checkout__Shipping__DeliveryMethod delivery = new Checkout__Shipping__DeliveryMethod();

    private void inputShippingField(int field) {
        switch (field) {
            case 1:
                inputShippingFirstName();
                break;
            case 2:
                inputShippingLastName();
                break;
            case 3:
                inputShippingAddress1();
                break;
            case 4:
                inputShippingAddress2();
                break;
            case 5:
                inputShippingCity();
                break;
            case 6:
                inputShippingState();
                break;
            case 7:
                inputShippingZip();
                break;
            case 8:
                inputShippingPhone();
                break;
        }
    }

    private void inputShippingFirstName() {
        String cssSelector = Selectors.input__shipping__first_name;
        String data = user.user__shipping__first_name;

        common.inputField(cssSelector, data);
    }

    private void inputShippingLastName() {
        String cssSelector = Selectors.input__shipping__last_name;
        String data = user.user__shipping__last_name;

        common.inputField(cssSelector, data);
    }

    private void inputShippingAddress1() {
        String cssSelector = Selectors.input__shipping__address1;
        String data = user.user__shipping__address1;

        common.inputField(cssSelector, data);
    }

    private void inputShippingAddress2() {
        String cssSelector = Selectors.input__shipping__address2;
        String data = user.user__shipping__address2;

        common.inputField(cssSelector, data);
    }

    private void inputShippingCity() {
        String cssSelector = Selectors.input__shipping__city;
        String data = user.user__shipping__city;

        common.inputField(cssSelector, data);
    }


    private void inputShippingState() {
        String cssSelector = Selectors.dropdown__shipping__state;
        String data = user.user__shipping__state;

        common.selectFromDropdownMenu(cssSelector, data);
    }

    private void inputShippingZip() {
        String cssSelector = Selectors.input__shipping__zip;
        String data = user.user__shipping__zip;

        common.inputField(cssSelector, data);
    }

    private void inputShippingPhone() {
        String cssSelector = Selectors.input__shipping__phone;
        String data = user.user__shipping__phone;

        common.inputField(cssSelector, data);
    }

      @Then("^the user inputs shipping address during checkout$")
  public void iInputShippingInformationDuringCheckout() throws Throwable {

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Selectors.container__shipping)));
    int inputFieldsCount = driver.findElements(By.cssSelector(Selectors.input__address_field)).size();
    try {

      for (int x = 1; x <= inputFieldsCount; x++) {
        inputShippingField(x);
        delivery.loadDeliveryMethods();
      }

    } catch (Exception e) {
      System.out.println(e);
    }
  }

}