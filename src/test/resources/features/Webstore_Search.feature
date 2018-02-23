#  Author: soumya.ramagiri@zensar.com
#  Recent Update: 2/19/2018
Feature: Webstore: Search

  @REG_SC_020
  Scenario Outline: verify Category Search Filter on Home page
    Given the user navigates to "<site>" site in "<environment>" environment
    And the user searches for "<item>"
    When the user is on the PLP page
    And user select a category filter "<category>"
    Then check the its filterd accordingly by "<category>"
    And remove the filter applied on "<category>"

    Examples: 
      | site | environment|item					|category		|
      | TRU  | QA        	|mickey mouse	|Top Rated	|

  @REG_SC_022
  Scenario Outline: Search an item by Product item & SKU id
    Given the user navigates to "<site>" site in "<environment>" environment
   	And the user searches for a random item
   	And the user is on the PLP page and store search text info
    When the user clicks to PDP of in-stock Ship-to item from PLP page
    And the user is on the PDP page
    And get the SKU Id
    And get the Product Name
    Then search by Product Name
    And search by SKU Id

    Examples: 
     | site | environment |
     | TRU  | QA        |