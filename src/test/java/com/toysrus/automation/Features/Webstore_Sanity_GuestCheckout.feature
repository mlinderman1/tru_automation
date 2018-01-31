#  Author: Mike.Linderman@toysrus.com
#  Recent Update: 1/29/2018

Feature: Guest Checkout

  @critical_path
  Scenario Outline: Guest user having one item in cart for shipping (No Gifting) and payment with one CC.

    Given the user navigates to "<site>" site in "<environment>" environment
    When the user adds "<item>" item to cart from "<page>" for "<ship_type>"
    And the user navigates to cart page
    And the user proceeds to "<checkout_type>" checkout
    And the "<user_type>" user checks out with "<payment_type>" method of payment
    Then the confirmation page is displayed

    Examples:
      |environment|site|user_type|item|page|ship_type|checkout_type|payment_type|
      |qa2       |TRU        |guest|random |plp|ship-to        |standard|credit card|
      |qa2       |TRU        |guest|random |plp|pickup        |standard|credit card|
      |qa2       |TRU        |guest|random |pdp|ship-to        |standard|credit card|
      |qa2       |TRU        |guest|random |pdp|pickup        |standard|credit card|


  Scenario Outline: Guest user having one item in cart for shipping (with Gifting) and payment with PayinStore.

    Given the user navigates to "<site>" site in "<environment>" environment
    When the user adds a random gift-eligible item to cart
    And the user navigates to cart page
    And the user selects gift option on cart page
    And the user proceeds to "<checkout_type>" checkout
    And the "<user_type>" user checks out with "<payment_type>" method of payment
    Then the confirmation page is displayed

    Examples:
      |environment|site|user_type|item|page|ship_type|checkout_type|payment_type|
      |qa2       |TRU        |guest|random |plp|ship-to        |standard|pay in store|
