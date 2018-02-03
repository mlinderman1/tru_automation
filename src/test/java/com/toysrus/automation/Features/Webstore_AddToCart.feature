#  Author: Mike.Linderman@toysrus.com
#  Recent Update: 2/1/2018

Feature: Webstore: Add to Cart

  Scenario Outline: Guest user adds ship-to item from PLP page

    Given the user navigates to "<site>" site in "<environment>" environment
    And the user searches for a random item
    When the user adds "<ship_type>" item to cart from plp page
    Then the Add to Cart overlay is displayed

    Examples:
      |site|environment|ship_type|
      |TRU |qa2        |ship-to    |


  Scenario Outline: Guest user adds ISPU item from PLP page

    Given the user navigates to "<site>" site in "<environment>" environment
    And the user searches for a random item
    When the user adds "<ship_type>" item to cart from plp page
    Then the Add to Cart overlay is displayed

    Examples:
      |site|environment|ship_type|
      |TRU |qa2        |pickup    |

  Scenario Outline: Guest user adds any in-stock ship-to item from PDP page

    Given the user navigates to "<site>" site in "<environment>" environment
    And the user searches for a random item
    When the user clicks to PDP of in-stock Ship-to item from PLP page
    And the user adds PDP item to cart
    Then the Add to Cart overlay is displayed

    Examples:
      |site|environment|
      |TRU |qa2        |

  Scenario Outline: Guest user adds any in-stock ISPU item from PDP page

    Given the user navigates to "<site>" site in "<environment>" environment
    And the user searches for a random item
    When the user clicks to PDP of in-stock ISPU item from PLP page
    And the user clicks 'Find in Store' link
    And the user selects store to pick up item
    Then the Add to Cart overlay is displayed


    Examples:
      |site|environment|
      |TRU |qa2        |

#  Scenario Outline: Guest user adds a gift-eligible item from PDP page

  Scenario Outline: Guest user adds ship-to and ISPU items from PLP page

    Given the user navigates to "<site>" site in "<environment>" environment
    And the user searches for a random item
    When the user adds "ship-to" item to cart from plp page
    And the user waits for the Add to Cart overlay to not be displayed
    And the user adds "pickup" item to cart from plp page
    Then the Add to Cart overlay is displayed

    Examples:
      |site|environment|
      |TRU |qa2        |