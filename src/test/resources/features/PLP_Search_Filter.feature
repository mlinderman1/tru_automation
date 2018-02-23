#  Author: soumya.ramagiri@zensar.com
#  Recent Update: 2/20/2018
Feature: Webstore: Search

  @REG_SC_026
  Scenario Outline: verify Category Search Filter on Home page
    Given the user navigates to "<site>" site in "<environment>" environment
    When the user navigates by Menu "<menu_option>" and "<sub_option>" "<sub_sub_option>"sub menu option
    And user select a category filter "<category>"
    Then check the its filterd accordingly by "<category>"
    And remove the filter applied on "<category>"

    Examples: 
      | site | environment |menu_option									|sub_option				|sub_sub_option			|category					|
      | TRU  | QA        |for Kids, Play Kitchen Sets	|Cooking for Kids	|Cookbooks & Aprons	|Cooking for Kids	|