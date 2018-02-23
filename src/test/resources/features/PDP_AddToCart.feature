#  Author:Siva V
#  Recent Update:2/22/2018
Feature: Home_Page Basic Functionality

  @REG_SC_060
  Scenario Outline: To Verify the display and Functionality of the Facebook,PINTEREST, Twitter and Mail  link in PDP page for TRU/BRU site
    Given the user navigates to "<site>" site in "<environment>" environment
    And the user searches for a random item
    And the user is on the PLP page
    When the user clicks to PDP of in-stock Ship-to item from PLP page
    When the user is on the PDP page
    And verify user is able to click on all mail link's

    Examples: 
      | site | environment |
      | TRU  | QA          |

  @REG_SC_052
  Scenario Outline: To verify on click of Add to Cart the ISPU light box is displayed for items with only store inventory available and user is able to proceed by selecting a store
    Given the user navigates to "<site>" site in "<environment>" environment
    Then Enter <product> then search
    Then Click on find a store and enter <Zipcode>
    Then Click on pick up here button
    Then Click on view cart and checkout button
    Then Verify product details in shopping cart "Your cart subtotal"

    Examples: 
      | site | environment | product  | Zipcode |
      | TRU  | QA          | E40FEF77 |   97536 |
