#  Author: sanket.tomar@toysrus.com
#  Recent Update: 2/22/2018


Feature: Webstore: PDP Sticky Footer
 

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
      |TRU |prod       |