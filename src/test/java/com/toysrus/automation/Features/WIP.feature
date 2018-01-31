#  Author: Mike.Linderman@toysrus.com
#  Recent Update: 1/22/2018

Feature: Guest Checkout

  Scenario Outline: Guest user having one item in cart for shipping (with Gifting) and payment with PayinStore.

    Given the user navigates to "<site>" site in "<environment>" environment
    When the user adds a random gift-eligible item to cart
    And the user navigates to cart page
    And the user selects gift option on cart page
    And the user proceeds to "<checkout_type>" checkout
    And the "<user_type>" user checks out with "<payment_type>" method of payment
    Then the confirmation page is displayed
#
#
#    And the user clicks "cart" from global header
#    And the user selects gift option on cart page
#    And the user proceeds to "standard" checkout
#    And the user is in "shipping" of checkout
#    And the user inputs shipping address during checkout
#    And the user continues to next tab during checkout
#    And the user selects any gift wrap
#    And the user continues to next tab during checkout
#    And the user inputs email during checkout
#    And the user selects "<payment_type>" method of payment
#    And the user proceeds to order review
#    And the user clicks place order button
#    Then the confirmation page is displayed

    Examples:
      |environment|site|user_type|item|page|ship_type|checkout_type|payment_type|
      |qa2        |TRU |guest    |    |    |         |standard     |pay-in-store|


  Scenario Outline: Guest Checkout (ISPU) : Single Item, Credit card
    Given the user navigates to "<site>" site in "<environment>" environment
    When the user searches for a random item
    And the user adds "ISPU" item to my cart from plp page
    And the user clicks "cart" from global header
    And the user proceeds to "standard" checkout
    And the user inputs pickup information during checkout
    And the user continues to next tab during checkout
    And the user inputs billing address during checkout
    And the user inputs email during checkout
    And the user selects "<payment_type>" method of payment
    And the user proceeds to order review
    And the user clicks place order button
    Then the confirmation page is displayed

    Examples:
      |site|environment|keyword|ship type|payment_type|
      |tru |qa2    |ninja  |         |pay in store|



  Scenario Outline: Ship-to + ISPU

    Given the user navigates to "<site>" site in "<environment>" environment
    When the user searches for a random item
    And the user adds "ship" item to my cart from plp page
    And the user adds "ISPU" item to my cart from plp page
    And the user clicks "cart" from global header
    And the user proceeds to "standard" checkout
    And the user inputs shipping address during checkout
    And the user continues to next tab during checkout
    And the user inputs pickup information during checkout
    And the user continues to next tab during checkout
    And the user inputs email during checkout
    And the user selects "<payment_type>" method of payment
    And the user proceeds to order review
    And the user clicks place order button
    Then the confirmation page is displayed

    Examples:
      |site|environment|keyword|ship type|payment_type|
      |tru |qa2    |ninja  |         |credit card|

  Scenario Outline: Ship-to + ISPU + Gifting

    Given the user navigates to "<site>" site in "<environment>" environment
    When the user searches for a random item
    And the user click to PDP of in-stock item from PLP page
    And the user adds a gift-eligible item to cart
    And the user searches for a random item
    And the user adds "ISPU" item to my cart from plp page
    And the user clicks "cart" from global header
    And the user selects gift option on cart page
    And the user proceeds to "standard" checkout
    And the user is in "shipping" of checkout
    And the user inputs shipping address during checkout
    And the user continues to next tab during checkout
    And the user is in "gifting" of checkout
    And the user continues to next tab during checkout
    And the user inputs pickup information during checkout
    And the user continues to next tab during checkout
    And the user inputs email during checkout
    And the user selects "<payment_type>" method of payment
    And the user proceeds to order review
    And the user clicks place order button
    Then the confirmation page is displayed

    Examples:
      |site|environment|keyword|ship type|payment_type|
      |tru |qa2    |ninja  |         |credit card|

  Scenario Outline: PDP ISPU test

    Given the user navigates to "<site>" site in "<environment>" environment
    When the user searches for a random item
    And  the user clicks to PDP of in-stock ISPU item from PLP page
    And the user clicks ISPU link
    And the user selects store to pick up item
    And the user clicks "cart" from global header
    And the user proceeds to "standard" checkout
    And the user inputs shipping address during checkout
    And the user continues to next tab during checkout
    And the user inputs email during checkout
    And the user selects "<payment_type>" method of payment
    And the user proceeds to order review
    And the user clicks place order button
    Then the confirmation page is displayed

    Examples:
      |site|environment|keyword|ship type|payment_type|
      |tru |qa4    |ninja  |         |credit card|
