// T2 (Category, Static, Account, Order History, Layaway, Current Checkout

package com.toysrus.automation.Selectors;

public class t2Selectors {

  // Top Line Header
  public static final String btn__topline__logo__TRU = ".tru-logo-sm";
  public static final String btn__topline__logo__BRU = ".bru-logo-sm";

  public static final String link__topline__registry1 = "#my-baby-reg";
  public static final String link__topline__registry2 = ".babyreg";

  public static final String link__topline__find_a_store1 = ".storeloc";
  public static final String link__topline__find_a_store2 = ".store-locator-tooltip";

  public static final String link__topline__weekly_ad1 = ".weeklyad";
  public static final String link__topline__weekly_ad2 = ".sprite-weekly-ad";

  public static final String link__topline__wishlist1 = ".wishlist";
  public static final String link__topline__wishlist2 = ".sprite-wish-list";

  public static final String link__topline__gift_card1 = ".giftcard";
  public static final String link__topline__gift_card2 = ".sprite-gift-card";


  // Global Nav
  public static final String btn__main__TRU_logo1 = "#logo-swap-lg-tru";
  public static final String btn__main__TRU_logo2 = ".headerspritetoysruslogolarge";
  public static final String btn__main__BRU__logo1 = ".logo-swap";
  public static final String btn__main__BRU__logo2 = "#logo-swap-lg-bru";

  public static final String input__global_nav__search_field = "#searchText";

  public static final String btn__global_nav__my_account = "#my-account-popover";
  public static final String dropdown__global_nav__my_account =  "#my-account-popover-struct";

  public static final String btn__global_nav__help = ".global-nav-help";
  public static final String btn__global_nav__help__moxie_online = "chatLive";
  public static final String btn__global_nav__help__moxie_offline = "chatOff";


  public static final String btn_global_nav__minicart = ".global-nav-cart";

  // Checkout - Shipping

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

  public static final String checkbox__shipping_as_billing = "#same-billing-address-checkbox";

  public static final String radiobtn__shipping_method_selected = ".select-shipping-method-block.selected";


  public static final String radiobtn__gift_option = "#gift-options-checkbox";

  //Address Doctor
  public static final String overlay__address_doctor = ".address-doctor";
  public static final String checkbox__address_doctor__user_address = "#suggestedAddressCount-0";
  public static final String checkbox__address_doctor__suggested_address = "#suggestedAddressCount-1";
  public static final String btn__address_doctor__useAddress = "#continueWithSugestedAddr";

  public static final String btn__continue_to_payment = "#continue_to_payment";
  public static final String btn__continue_to_pickup = "#continue_to_pickup";
  public static final String btn__continue_to_gifting = "#continue_to_gifting";


  // Checkout - Gifting;
  public static final String container__checkout__gifting = "#co-gifting-tab";
  public static final String container__checkout__gifting_row = ".checkout-gifting-registry-product";
  public static final String btn__checkout__gifting_wrap =".gift-wrap-tru-block";

  // Checkout - Pickup

  public static final String container__checkout__pickup = ".checkout-pickup-container";
  public static final String input__pickup__first_name = "#firstName_0";
  public static final String input__pickup__last_name = "#lastName_0";
  public static final String input__pickup__phone = "#phoneNumber_0";
  public static final String input__pickup__email = "#email_0";
  public static final String radiobtn__pickup__alternate_pickup =".checkout-flow-radio-unselected";

  //  Checkout - Billing

  public static final String container__checkout__billing = ".checkout-payment";

  public static final String container__billing__address_form = ".checkout-shipping-address-form-content";
  public static final String input__billing__first_name = "#firstName";
  public static final String input__billing__last_name = "#lastName";
  public static final String input__billing__address1 = "#address1";
  public static final String input__billing__address2 = "#address2";
  public static final String input__billing__city = "#city";
  public static final String dropdown__billing__state = "#state";
  public static final String input__billing__zip = "#postalCode";
  public static final String input__billing__phone = "#phoneNumber";

  public static final String input__checkout__email = "#orderEmail";

  public static final String container__credit_card = ".credit-card-left-section";
  public static final String radiobtn__credit_card = "#radio-creditcard";
  public static final String radiobtn__credit_card_unselected = ".payment-checkbox-creditcard.checkout-flow-radio-unselected";
  public static final String radiobtn__credit_card_selected = ".payment-checkbox-creditcard.checkout-flow-radio-selected";
  public static final String input__credit_card__full_name = "#nameOnCard";
  public static final String input__credit_card__card_number = "#ccnumber";
  public static final String input__credit_card__expiration_month = "#expirationMonth";
  public static final String input__credit_card__expiration_year = "#expirationYear";
  public static final String input__credit_card__cvv = "#creditCard_CVV";

  public static final String radiobtn__PayPal = "#radio-paypal";
  public static final String radiobtn__PayPal_unselected = ".payment-checkbox-paypal.checkout-flow-radio-unselected";
  public static final String radiobtn__PayPal_selected = ".payment-checkbox-paypal.checkout-flow-radio-selected";

  public static final String radiobtn__pay_in_store = "#radio-payinstore";
  public static final String radiobtn__pay_in_store_unselected = "payment-checkbox-payinstore.checkout-flow-radio-unselected";
  public static final String radiobtn__pay_in_store_selected = ".payment-checkbox-payinstore.checkout-flow-radio-selected";

  public static final String btn__order_review = ".checkout-review-order";
  public static final String btn__secure_checkout = ".summary-block-secure-checkout";
  public static final String btn__checkout__place_order = "#nongoodbye_commitOrder";
  public static final String container__page__order_review = "#review-tab";
  public static final String btn__order_review__place_order = "#nongoodbye_place_order_now";

  // Order Confirmation

  public static final String container__page__order_confirmation = "#nongoodbye_order_confirmation";
  public static final String text__order_confirmation_number = ".checkout-order-complete-header__subheader--bold";
}

