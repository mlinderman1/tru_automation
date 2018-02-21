#  Author: Erin.Murphy@toysrus.com
#  Recent Update: 2/12/2018

@reg @reg_addtocart
Feature: Registry: Add to Cart

  @reg_gift_giver @P1 @reg_critical_integration #JIRA Number reference pending
  Scenario Outline: Registry Gift Giver adds ship-to item from Registry list to cart

    #take Given statement from common step definitions the given statement
    Given the user navigates to "<URL>" site in "<environment>" environment on "<browser>" and "<device>"
    When the user clicks find on the registry home page
    And lands on the registry search page
    When the user searches for a "<reg_number>"
    And lands on the registry search results page
    When the user clicks on the corresponding registry "<reg_number>" result title
    And lands on the registry gift giver list page
    When the user sets the quantity to "<qty>" for "<item_number>"
    And clicks add to cart for item "<item_number>"
    And the Add to Cart overlay is displayed with item "<item_number>"
    And the minicart displays the total quantity carted along with any additional quantity ("<qty>") carted within this scenario
    #minicart add step for verification of mini cart value
    #keep our add to cart overlay separated as we often are asked to handle behavior different in registry vs webstore
    When the user clicks the minicart button from the global navbar
    And the user lands on the cart page
    Then the item "<item_number>" with quantity "<qty>" is displayed

    Examples:
      |URL|environment|ship_type|reg_number|item_number|qty|browser|device
      |TRU |prod       |ship-to    |12345678|12345678  |1     |chrome|MAC
    #add ship type later on the data should be an item which is S2H and update data scenarios these are placeholders for now

  @reg_gift_giver @P1 @reg_critical_integration #JIRA Number reference pending
  Scenario Outline: Registry Gift Giver adds ISPU item from Registry list to cart

   #NOTE: keeping separate for ISPU given the upcoming ISPU integration on registry list
   #take Given statement from common step definitions the given statement
    Given the user navigates to "<URL>" site in "<environment>" environment on "<browser>" and "<device>"
    When the user clicks find on the registry home page
    And lands on the registry search page
    When the user searches for a "<reg_number>"
    And lands on the registry search results pageok co
    When the user clicks on the corresponding registry "<reg_number>" result title
    And lands on the registry gift giver list page
    When the user sets the quantity to "<qty>" for "<item_number>"
    And clicks add to cart for item "<item_number>"
    And the Add to Cart overlay is displayed with item "<item_number>"
    And the minicart displays the total quantity carted along with any additional quantity ("<qty>") carted within this scenario
   #keep our add to cart overlay separated as we often are asked to handle behavior different in registry vs webstore
    When the user clicks the minicart button from the global navbar
    And the user lands on the cart page
    Then the item "<item_number>" with quantity "<qty>" is displayed

    Examples:
      |URL|environment|ship_type|reg_number|item_number|qty|browser|device|
      |TRU |prod       |ISPU    |12345678|12345678  |1     |chrome|MAC    |
    #add ship type later on the data should be an item which is S2H and update data scenarios these are placeholders for now

  @registrant @P1 @reg_critical_integration #JIRA Number reference pending
  Scenario Outline: Registrant (with 1 registry) adds ship-to item from Registry list to cart

     #take Given statement from common step definitions the given statement
    Given the user navigates to "<URL>" site in "<environment>" environment on "<browser>" and "<device>"
    When the user clicks manage on the registry home page
    And lands on the registry sign-in page
    When the user enters their "<user_name>"
    And the user enters their "<password>"
    And clicks the sign-in button
    And lands on the my registry list page
    When clicks add to cart for item "<item_number>"
    And the Add to Cart overlay is displayed with item "<item_number>"
    And the minicart displays the total quantity carted along with any additional quantity ("<qty>") carted within this scenario
     #keep our add to cart overlay separated as we often are asked to handle behavior different in registry vs webstore
    When the user clicks the minicart button from the global navbar
    And the user lands on the cart page
    Then the item "<item_number>" with quantity "<qty>" is displayed

    Examples:
      |URL|environment|ship_type|reg_number|item_number|qty|browser|device|user_name|password|
      |TRU |prod       |ship-to    |12345678|12345678  |1     |chrome|MAC |lisa@tru.com|password|
    #add ship type later on the data should be an item which is S2H and update data scenarios these are placeholders for now
    #will reference variables for various user accounts in the future these are just samples

  @registrant @P1 @reg_critical_integration #JIRA Number reference pending
  Scenario Outline: Registrant (with 1 registry) adds ship-to item from Registry list to cart

   #take Given statement from common step definitions the given statement
    Given the user navigates to "<URL>" site in "<environment>" environment on "<browser>" and "<device>"
    When the user clicks manage on the registry home page
    And lands on the registry sign-in page
    When the user enters their "<user_name>"
    And the user enters their "<password>"
    And clicks the sign-in button
    And lands on the my registry list page
    When clicks add to cart for item "<item_number>"
    And the Add to Cart overlay is displayed with item "<item_number>"
    And the minicart displays the total quantity carted along with any additional quantity ("<qty>") carted within this scenario
   #keep our add to cart overlay separated as we often are asked to handle behavior different in registry vs webstore
    When the user clicks the minicart button from the global navbar
    And the user lands on the cart page
    Then the item "<item_number>" with quantity "<qty>" is displayed

    Examples:
      |URL|environment|ship_type|reg_number|item_number|qty|browser|device|user_name|password|
      |TRU |prod       |ship-to    |12345678|12345678  |1     |chrome|MAC |lisa@tru.com|password|
    #add ship type later on the data should be an item which is S2H and update data scenarios these are placeholders for now
    #will reference variables for various user accounts in the future these are just samples




