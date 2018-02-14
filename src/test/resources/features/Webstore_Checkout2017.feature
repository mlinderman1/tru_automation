#  Author: Mike.Linderman@toysrus.com
#  Recent Update: 2/13/2018

Feature: Webstore: Checkout Payment Variations

  Scenario Outline: Guest user adds one ship-to item, standard checkout with credit card payment

    Given the user navigates to ToysRUs site
    And the user searches for a random item
    And the user is on the PLP page
    And the user adds "<ship_type>" item to cart from plp page
    And the user waits for the Add to Cart overlay to not be displayed
    And the user clicks the minicart button from the global navbar
    And the user is on the cart page
    When the user proceeds to "standard" checkout
    And the user is on the checkout page
    And the user inputs shipping address during checkout
    And the user continues to next tab during checkout
    And the user is on the billing tab of checkout
    And the user inputs email during checkout
    And the user chooses credit/debit card as method of payment
    And the user inputs credit/debit card information
    And the user clicks 'review order' button
    And the user is on order review page
    And the user clicks place order button
    Then the confirmation page is displayed

  Examples:
      |site|environment|ship_type|
      |TRU |prod       |ship-to    |


  Scenario Outline: Guest user adds one ship-to item, standard checkout with pay in store payment

    Given the user navigates to ToysRUs site
    And the user searches for a random item
    And the user is on the PLP page
    And the user adds "<ship_type>" item to cart from plp page
    And the user waits for the Add to Cart overlay to not be displayed
    And the user clicks the minicart button from the global navbar
    And the user is on the cart page
    When the user proceeds to "standard" checkout
    And the user is on the checkout page
    And the user inputs shipping address during checkout
    And the user continues to next tab during checkout
    And the user is on the billing tab of checkout
    And the user inputs email during checkout
    And the user chooses pay in store as method of payment
    And the user clicks 'review order' button
    And the user is on order review page
    And the user clicks place order button
    Then the confirmation page is displayed

    Examples:
      |site|environment|ship_type|
      |TRU |prod       |ship-to    |