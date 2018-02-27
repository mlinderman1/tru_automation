#  Author: Erin.Murphy@toysrus.com
#  Recent Update: 2/12/2018

#@reg @reg_addtocart
Feature: Registry: Add to Cart

  #@reg_gift_giver @P1 @reg_critical_integration #JIRA Number reference pending
  Scenario Outline: Registry Gift Giver adds ship-to item from Registry list to cart

    #take Given statement from common step definitions the given statement
    Given the user navigates to "<site>" sites in "<environment>" environment
    When the user clicks find on the registry home page
    And lands on the registry search page
    When the user searches for a "<reg_number>" RegistryNumber
    And lands on the registry search results page displaying registry "<reg_number>"
    When the user clicks on the corresponding registry "<reg_number>" result title
    And lands on the registry gift giver list page
    #When the user sets the quantity to "<qty>" for "<item_number>"
    And clicks add to cart for item# "<item_number>"
    And the Add to Cart overlay is displayed with item "<item_number>"
  #  And the minicart displays the total quantity carted along with any additional quantity "<qty>" carted within this scenario
    #minicart add step for verification of mini cart value
    #keep our add to cart overlay separated as we often are asked to handle behavior different in registry vs webstore
   # When the user clicks the minicart button from the global navbar
    #And the user lands on the cart page
    #Then the item "<item_number>" with quantity "<qty>" is displayed
 Examples:
  |site|environment|ship_type|reg_number|item_number|qty|browser|device|
  |registry |uat|ship-to    |05439599|12345678  |1     |chrome|MAC |



