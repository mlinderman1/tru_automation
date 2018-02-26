package com.toysrus.automation.steps.checkout;

import com.toysrus.automation.lib.Data;
import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.common.Common_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.Random;

public class Checkout__Payment__CreditCard extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String input__address_field = Checkout__Common.Selectors.input__address_field;

        public static final String container__credit_card = ".credit-card-left-section";
        public static final String radiobtn__credit_card = "#radio-creditcard";
        public static final String radiobtn__credit_card_unselected = ".payment-checkbox-creditcard.checkout-flow-radio-unselected";
        public static final String radiobtn__credit_card_selected = ".payment-checkbox-creditcard.checkout-flow-radio-selected";
        public static final String input__credit_card__full_name = "#nameOnCard";
        public static final String input__credit_card__card_number = "#ccnumber";
        public static final String input__credit_card__expiration_month = "#expirationMonth";
        public static final String input__credit_card__expiration_year = "#expirationYear";
        public static final String input__credit_card__cvv = "#creditCard_CVV";
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

//    private void inputCardField(int field) {
//        switch (field) {
//            case 1:
//                inputCardName();
//                break;
//            case 2:
//                inputCardNumber();
//                break;
//            case 3:
//                inputCardExpMonth();
//                break;
//            case 4:
//                inputCardExpYear();
//                break;
//            case 5:
//                inputCardCVV();
//                break;
//        }
//    }

    private void inputCardName() {
        String cssSelector = selector.input__credit_card__full_name;
        String data = user.user__billing__first_name + " " + user.user__billing__last_name;

        common.inputField(cssSelector, data);
    }

    private void inputCardNumber() {
        String cssSelector = selector.input__credit_card__card_number;
        String data = cc.credit_card__number;

        common.inputField(cssSelector, data);
    }

    private void inputCardExpMonth() {
        String cssSelector = selector.input__credit_card__expiration_month;
        String data = cc.credit_card__expiration_month;

        common.selectFromDropdownMenu(cssSelector, data);
    }

    private void inputCardExpYear() {
        String cssSelector = selector.input__credit_card__expiration_year;
        String data = cc.credit_card__expiration_year;

        common.selectFromDropdownMenu(cssSelector, data);
    }

    private void inputCardCVV() {
        String cssSelector = selector.input__credit_card__cvv;
        String data = cc.credit_card__cvv;

        common.inputField(cssSelector, data);
    }


    @And("^the user chooses credit/debit card as method of payment$")
    public void theUserChoosesCardAsMethodOfPayment() throws Throwable {
        try {
            WebElement billing_cc = driver.findElement(By.cssSelector(selector.radiobtn__credit_card));
            wait.until(ExpectedConditions.elementToBeClickable(billing_cc));
            billing_cc.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.container__credit_card)));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @And("^the user inputs credit/debit card information$")
    public void theUserInputsCreditDebitCardInformation() throws Throwable {
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.container__credit_card)));
            int inputFieldsCount = driver.findElements(By.cssSelector(selector.container__credit_card + " " + selector.input__address_field)).size();

            inputCardName();
            inputCardNumber();
            inputCardExpMonth();
            inputCardExpYear();
            inputCardCVV();
        }
        catch(Exception e){
            System.out.println(e);
        }

    }


}