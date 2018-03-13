#  Author: Soumya.Ramagiri@zensar.com
#  Recent Update: 03/09/2018
Feature: Webstore: Home page

  @REG_SC_HOME_18 @REG_SC_HOME_19 @REG_SC_HOME_23 @REG_SC_HOME_24 @REG_SC_HOME_28 @REG_SC_HOME_29 @REG_SC_HOME_31 @REG_SC_HOME_32
  Scenario Outline: verifying different categories section in Homepage (Ex: Recommended for you, Toy boy favorites)
    Given the user navigates to "<site>" site in "<environment>" environment
    And the user is on ToysRUs homepage
    When the user clicks on an item from "<section>"
    Then the user is on the PDP page
    And selected items PDP page displays

    Examples: 
      | site | environment | section                      |
      | TRU  | QA2         | recommended for you          |
      | TRU  | QA2         | shoppers like you also liked |
      | TRU  | QA2         | toy box favorites            |
      | TRU  | QA2         | now trending                 |
