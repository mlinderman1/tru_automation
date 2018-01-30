package Steps.Decouple;

import Steps.AbstractPage_StepDefs;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.Data;
import lib.t2Selectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class Checkout_StepDefs extends AbstractPage_StepDefs {

  WebDriver driver = getDriver();
  WebDriverWait wait = new WebDriverWait(driver, 10);
  Random rand = new Random();
  t2Selectors selector = new t2Selectors();
  Data.user1 user = new Data.user1();
  Data.credit_card__Visa cc = new Data.credit_card__Visa();
  Common_StepDefs common = new Common_StepDefs();

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

  private void inputPickupField(int field) {
    switch (field) {
      case 1:
        inputPickupFirstName();
        break;
      case 2:
        inputPickupLastName();
        break;
      case 3:
        inputPickupPhone();
        break;
      case 4:
        inputPickupEmail();
        break;
    }
  }

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

  private void inputCardField(int field) {
    switch (field) {
      case 1:
        inputCardName();
        break;
      case 2:
        inputCardNumber();
        break;
      case 3:
        inputCardExpMonth();
        break;
      case 4:
        inputCardExpYear();
        break;
      case 5:
        inputCardCVV();
        break;
    }
  }

  private void inputShippingFirstName() {
    String cssSelector = selector.input__shipping__first_name;
    String data = user.user__shipping__first_name;

    common.inputField(cssSelector, data);
  }

  private void inputShippingLastName() {
    String cssSelector = selector.input__shipping__last_name;
    String data = user.user__shipping__last_name;

    common.inputField(cssSelector, data);
  }

  private void inputShippingAddress1() {
    String cssSelector = selector.input__shipping__address1;
    String data = user.user__shipping__address1;

    common.inputField(cssSelector, data);
  }

  private void inputShippingAddress2() {
    String cssSelector = selector.input__shipping__address2;
    String data = user.user__shipping__address2;

    common.inputField(cssSelector, data);
  }

  private void inputShippingCity() {
    String cssSelector = selector.input__shipping__city;
    String data = user.user__shipping__city;

    common.inputField(cssSelector, data);
  }


  private void inputShippingState() {
    String cssSelector = selector.dropdown__shipping__state;
    String data = user.user__shipping__state;

    common.selectFromDropdownMenu(cssSelector, data);
  }

  private void inputShippingZip() {
    String cssSelector = selector.input__shipping__zip;
    String data = user.user__shipping__zip;

    common.inputField(cssSelector, data);
  }

  private void inputShippingPhone() {
    String cssSelector = selector.input__shipping__phone;
    String data = user.user__shipping__phone;

    common.inputField(cssSelector, data);
  }

  private void loadDeliveryMethods() {
    try {
      wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(selector.radiobtn__shipping_method_selected)));
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  private void inputPickupFirstName() {
    String cssSelector = selector.input__pickup__first_name;
    String data = user.user__pickup__first_name;

    common.inputField(cssSelector, data);
  }

  private void inputPickupLastName() {
    String cssSelector = selector.input__pickup__last_name;
    String data = user.user__pickup__last_name;

    common.inputField(cssSelector, data);
  }

  private void inputPickupPhone() {
    String cssSelector = selector.input__pickup__phone;
    String data = user.user__pickup__phone;

    common.inputField(cssSelector, data);
  }

  private void inputPickupEmail() {
    String cssSelector = selector.input__pickup__email;
    String data = user.user__pickup__email;

    common.inputField(cssSelector, data);
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

  @When("^the user checks out (?:with|without) PayPal method$")
  public void addToCart(String buttonType) throws Throwable {

  }

  @Then("^the user inputs shipping address during checkout$")
  public void iInputShippingInformationDuringCheckout() throws Throwable {

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.container__shipping)));
    int inputFieldsCount = driver.findElements(By.cssSelector(selector.input__address_field)).size();
    try {

      for (int x = 1; x <= inputFieldsCount; x++) {
        inputShippingField(x);
        loadDeliveryMethods();
      }

    } catch (Exception e) {
      System.out.println(e);
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

//     (ADDRESS DOCTOR TO BE DECOMMISSIONED WITH NEW CHECKOUT; GOOGLE ADDRESS API TO BE USED)
    try {
      WebElement addressDoctor = driver.findElement(By.cssSelector(selector.overlay__address_doctor));

      wait.until(ExpectedConditions.visibilityOf(addressDoctor));

      if (addressDoctor.isDisplayed()) {
        do {
          WebElement addressDoctor_useButton = driver.findElement(By.cssSelector(selector.checkbox__address_doctor__user_address));
          addressDoctor_useButton.click();
        }
        while (addressDoctor.isDisplayed());
      }
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  @And("^the user inputs pickup information during checkout$")
  public void iInputPickupInformationDuringCheckout() throws Throwable {
    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.container__checkout__pickup)));
      int shippingFieldsCount = driver.findElements(By.cssSelector(".shipping-address-field")).size();
      try {

        for (int x = 1; x <= shippingFieldsCount; x++) {
          inputPickupField(x);
        }

      } catch (Exception e) {
        System.out.println(e);
      }
    } catch (Exception e) {
      System.out.println(e);
    }

  }


  @And("^the user inputs billing address during checkout$")
  public void iInputBillingAddressDuringCheckout() throws Throwable {
    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.container__checkout__billing)));
    }
    catch(Exception e){
      return;
    }

    int billingFieldsCount = driver.findElements(By.cssSelector(selector.container__billing__address_form+ " " +selector.input__address_field)).size();
    try {

      for (int x = 1; x <= billingFieldsCount; x++) {
        inputBillingField(x);
      }

    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @Then("^the user inputs email during checkout$")
  public void iInputEmailDuringCheckout() throws Throwable {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.container__checkout__billing)));

    String cssSelector = selector.input__checkout__email;
    String data = user.user__email;

    common.inputField(cssSelector, data);
  }

  @And("^the user selects \"([^\"]*)\" method of payment$")
  public void iSelectMethodOfPayment(String paymentType) throws Throwable {
    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.container__checkout__billing)));

      if (paymentType.toLowerCase().contains("credit") || paymentType.toLowerCase().contains("debit")) {
        try {
          WebElement billing_cc = driver.findElement(By.cssSelector(selector.radiobtn__credit_card));
          wait.until(ExpectedConditions.elementToBeClickable(billing_cc));
          billing_cc.click();

          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.container__credit_card)));
          int inputFieldsCount = driver.findElements(By.cssSelector(selector.container__credit_card + " " + selector.input__address_field)).size();

          inputCardName();
          inputCardNumber();
          inputCardExpMonth();
          inputCardExpYear();
          inputCardCVV();

        } catch (Exception e) {
          System.out.println(e);
        }
      } else if (paymentType.toLowerCase().contains("store")) {
        WebElement billing_payInStore = driver.findElement(By.cssSelector(selector.radiobtn__pay_in_store));
        wait.until(ExpectedConditions.elementToBeClickable(billing_payInStore));
        billing_payInStore.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.radiobtn__pay_in_store_selected)));
      }

    } catch (Exception e) {
      System.out.println(e);
    }

  }


  @Then("^the confirmation page is displayed$")
  public void iAmOnConfirmationPage() throws Throwable {
    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.container__page__order_confirmation)));

      WebElement orderConfNum = driver.findElement(By.cssSelector(selector.text__order_confirmation_number));
      wait.until(ExpectedConditions.visibilityOf(orderConfNum));
      System.out.println("ORDER CONF #: " + orderConfNum.getText());
    } catch (NoSuchElementException e) {
      System.out.println(e);
    }
  }

  @And("^the user verifies gift option is \"([^\"]*)\"$")
  public void iVerifyGiftOptionIs(String giftOption) throws Throwable {
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.radiobtn__gift_option)));

    WebElement giftRadioBtn = driver.findElement(By.cssSelector(selector.radiobtn__gift_option));

    wait.until(ExpectedConditions.elementSelectionStateToBe(giftRadioBtn, true));
  }


  @And("^the user is in \"([^\"]*)\" of checkout$")
  public void iAmInSectionOfCheckout(String checkoutSection) throws Throwable {


    if (checkoutSection.toLowerCase().contains("shipping")) {
      wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(selector.container__shipping)));
    } else if (checkoutSection.toLowerCase().contains("gifting")) {
      wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(selector.container__checkout__gifting)));
    } else if (checkoutSection.toLowerCase().contains("pickup") || checkoutSection.toLowerCase().contains("pick up")) {
      wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(selector.container__checkout__pickup)));
    } else if (checkoutSection.toLowerCase().contains("billing") || checkoutSection.toLowerCase().contains("pay")) {
      wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(selector.container__checkout__billing)));
    } else if (checkoutSection.toLowerCase().contains("review")) {
      wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(selector.container__page__order_review)));
    }

  }


  @And("^the user proceeds to order review$")
  public void theUserProceedsToOrderReview() throws Throwable {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.btn__order_review)));

    WebElement orderReviewBtn = driver.findElement(By.cssSelector(selector.btn__order_review));
    orderReviewBtn.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.container__page__order_review)));
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

  @And("^the user selects any gift wrap$")
  public void theUserSelectsGiftWrap() throws Throwable {
    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.container__checkout__gifting)));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.container__checkout__gifting_row)));

      List<WebElement> giftWrapList = driver.findElements(By.cssSelector(selector.btn__checkout__gifting_wrap));

      int n = rand.nextInt(giftWrapList.size());

      giftWrapList.get(n).click();

    } catch (NoSuchElementException e) {
      System.out.println(e);
    }

  }


  @And("^the \"([^\"]*)\" user checks out with \"([^\"]*)\" method of payment$")
  public void theUserChecksOutWithMethodOfPayment(String userType, String paymentType) throws Throwable {
    try {
      iInputShippingInformationDuringCheckout();
      iContinueToNextTabDuringCheckout();

      try {
        theUserSelectsGiftWrap();
        iContinueToNextTabDuringCheckout();
      }
      catch (Exception e) {
        System.out.println(e);
      }
    }
    catch (Exception e) {
      System.out.println(e);
    }

    try {
      iInputPickupInformationDuringCheckout();
      iContinueToNextTabDuringCheckout();
    }

    finally {
      try {
        iInputBillingAddressDuringCheckout();
      }
      catch(Exception e) {
        System.out.println(e);
      }
      try {
        iInputEmailDuringCheckout();
      }
      finally{
        iSelectMethodOfPayment(paymentType);
        theUserProceedsToOrderReview();
        theUserClicksPlaceOrderButton();
      }
    }
  }
}


