#  Author: Mike.Linderman@toysrus.com
#  Recent Update: 2/7/2018

Feature: Webstore: Add to Cart

  Scenario Outline: Guest user adds ship-to item from PLP page

    Given the user navigates to "<site>" site in "<environment>" environment
    And the user searches for a random item
    When the user is on the PLP page
    And the user adds "<ship_type>" item to cart from plp page
    Then the Add to Cart overlay is displayed

  Examples:
      |site|environment|ship_type|
      |TRU |prod       |ship-to    |


  Scenario Outline: Guest user adds ISPU item from PLP page

    Given the user navigates to "<site>" site in "<environment>" environment
    And the user searches for a random item
    And the user is on the PLP page
    When the user adds "<ship_type>" item to cart from plp page
    Then the Add to Cart overlay is displayed

  Examples:
      |site|environment|ship_type|
      |TRU |prod        |pickup    |

  Scenario Outline: Guest user adds any in-stock ship-to item from PDP page

    Given the user navigates to "<site>" site in "<environment>" environment
    And the user searches for a random item
    And the user is on the PLP page
    When the user clicks to PDP of in-stock Ship-to item from PLP page
    When the user is on the PDP page
    And the user adds PDP item to cart
    Then the Add to Cart overlay is displayed

  Examples:
      |site|environment|
      |TRU |prod        |

  Scenario Outline: Guest user adds any in-stock ISPU item from PDP page

    Given the user navigates to "<site>" site in "<environment>" environment
    And the user searches for a random item
    And the user is on the PLP page
    When the user clicks to PDP of in-stock ISPU item from PLP page
    When the user is on the PDP page
    And the user clicks 'Find in Store' link
    And the user selects store to pick up item
   Then the Add to Cart overlay is displayed


  Examples:
      |site|environment|
      |TRU |prod        |
      
     
     
  Scenario Outline: Guest user adds any in-stock ship-to item from PDP page from sticky footer

    Given the user navigates to "<site>" site in "<environment>" environment
    And the user searches for a random item
    And the user is on the PLP page
    When the user clicks to PDP of in-stock Ship-to item from PLP page
    When the user is on the PDP page
    And the user scrolls down the page so sticky footer shows up
    And the user adds PDP item to cart from sticky footer
    Then the Add to Cart overlay is displayed

  Examples:
      |site|environment|
      |TRU |prod        |