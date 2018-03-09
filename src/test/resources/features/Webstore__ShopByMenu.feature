#  Author: Siva V
#  Recent Update: 3/01/2018
Feature: Webstore: ShopByMenu

  @REG_SC_HOME_2, @Regression_Test
  Scenario Outline: To verify user is able to navigate to PLP/ CLP from mega menu (Shop by Menu)
    Given the user navigates to "<site>" site in "<environment>" environment
    Then the user verify Shop By menu displays
    And the user clicks on 'Shop By menu' button
    And the user selects "<category type>" category
    And the user is on "<category type>" page

    Examples: 
      | site | environment | category type |
      | TRU  | prod        | Movie HQ      |

  @REG_SC_HOME_1
  Scenario Outline: To verify the different categories available with the hyperlinks under the Shop by Menu
    Given the user navigates to "<site>" site in "<environment>" environment
    Then the user verify Shop By menu displays
    And the user clicks on 'Shop By menu' button
    And verify all the category list

    Examples: 
      | site | environment |
      | TRU  | prod        |
