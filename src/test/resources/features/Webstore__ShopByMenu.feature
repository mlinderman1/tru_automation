#  Author: Soumya.Ramagiri@Zensar.com
#  Recent Update: 03/13/2018
Feature: Webstore: Shop by Menu

  @REG_SC_HOME_3 @REG_SC_HOME_4
  Scenario Outline: The user goes through family landing category options,items of selected option displays
    Given the user navigates to "<site>" site in "<environment>" environment
    And the user is on ToysRUs homepage
    When the user clicks on Shop By menu
    Then the user is on family landing category options
    And the user goes through family landing category options
    Then the user is on the PLP page
    And items of selected option displays

    Examples: 
      | site | environment |
      | TRU  | qa2         |
