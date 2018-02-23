#  Author: soumya.ramagiri@zensar.com
#  Recent Update: 2/21/2018

Feature: Webstore: verify collections search & add to cart

  @REG_SC_023
  Scenario Outline: Verify Add to Cart from collections page
    Given the user navigates to "<site>" site in "<environment>" environment
    And  the user click on Babiesrus Logo
    When the user navigates by Menu "<menu_option>" and "<sub_option>" "<sub_sub_option>"sub menu option
    Then view the product details
    
    Examples: 
      | site | environment	|menu_option	|sub_option				|sub_sub_option			|
      | TRU  | QA		       	|& Room Decor	|Bedding					|Bedding Collections|
    
  @REG_SC_051
  Scenario Outline: Verify Add to Cart from collections page
    Given the user navigates to "<site>" site in "<environment>" environment
    And  the user click on Babiesrus Logo
    When the user navigates by Menu "<menu_option>" and "<sub_option>" "<sub_sub_option>"sub menu option
    Then view the product details 
    And click on Add to Cart
    And check it in shopping cart
    
    Examples: 
      | site | environment	|menu_option	|sub_option				|sub_sub_option			|
      | TRU  | QA		       	|& Room Decor	|Bedding					|Bedding Collections|