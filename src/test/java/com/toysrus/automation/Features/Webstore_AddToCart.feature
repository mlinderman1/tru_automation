#  Author: Mike.Linderman@toysrus.com
#  Recent Update: 1/29/2018

Feature: Webstore: Add to Cart

  Scenario Outline: Guest user adds ship-to item from PLP page

    Given the user navigates to "<site>" site in "<environment>" environment
    When the user adds "<item>" item to cart from "plp" for "ship-to"
    And the user navigates to cart page

    Examples:
      |environment|site|user_type|item|page|ship_type|checkout_type|payment_type|
      |qa2       |TRU        |guest|random |plp|ship-to        |standard|credit card|

  Scenario Outline: Guest user adds ISPU item from PLP page

    Given the user navigates to "<site>" site in "<environment>" environment
    When the user adds "<item>" item to cart from "plp" for "pickup"
    And the user navigates to cart page

    Examples:
      |environment|site|user_type|item|page|ship_type|checkout_type|payment_type|
      |qa2       |TRU        |guest|random |plp|ship-to        |standard|credit card|

  Scenario Outline: Guest user adds any in-stock ship-to item from PDP page

    Given the user navigates to "<site>" site in "<environment>" environment
    When the user adds "<item>" item to cart from "pdp" for "ship-to"
    And the user navigates to cart page

    Examples:
      |environment|site|user_type|item|page|ship_type|checkout_type|payment_type|
      |qa2       |TRU        |guest|random |plp|ship-to        |standard|credit card|

  Scenario Outline: Guest user adds any in-stock ISPU item from PDP page

    Given the user navigates to "<site>" site in "<environment>" environment
    When the user adds "<item>" item to cart from "pdp" for "pickup"
    And the user navigates to cart page

    Examples:
      |environment|site|user_type|item|page|ship_type|checkout_type|payment_type|
      |qa2       |TRU        |guest|random |plp|ship-to        |standard|credit card|

  Scenario Outline: Guest user adds a gift-eligible item from PDP page

    Given the user navigates to "<site>" site in "<environment>" environment
    When the user adds a random gift-eligible item to cart
    And the user navigates to cart page

    Examples:
      |environment|site|user_type|item|page|ship_type|checkout_type|payment_type|
      |qa2       |TRU        |guest|random |plp|ship-to        |standard|credit card|

  Scenario Outline: Guest user adds ship-to and ISPU items from PLP page

    Given the user navigates to "<site>" site in "<environment>" environment
    When the user adds "<item>" item to cart from "plp" for "ship-to"
    When the user adds "<item>" item to cart from "plp" for "pickup"
    And the user navigates to cart page

    Examples:
      |environment|site|user_type|item|page|ship_type|checkout_type|payment_type|
      |qa2       |TRU        |guest|random |plp|ship-to        |standard|credit card|

  Scenario Outline: Guest user adds gift-eligible ship-to item from PDP and adds ISPU item from PLP page

    Given the user navigates to "<site>" site in "<environment>" environment
    When the user adds a random gift-eligible item to cart
    And the user adds "<item>" item to cart from "plp" for "pickup"
    And the user navigates to cart page

  Examples:
  |environment|site|user_type|item|page|ship_type|checkout_type|payment_type|
  |qa2       |TRU        |guest|random |plp|ship-to        |standard|credit card|
