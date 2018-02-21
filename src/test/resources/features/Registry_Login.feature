#  Author: Erin.Murphy@toysrus.com
#  Recent Update: 2/12/2018

@reg @reg_login
Feature: Registry: Login

  @registrant @P1 @reg_critical_integration #JIRA Number reference pending
  Scenario Outline: Registrant (with 1 registry) logs in to Registry

     #take Given statement from common step definitions the given statement
    Given the user navigates to "<URL>" site in "<environment>" environment on "<browser>" and "<device>"
    When the user clicks the manage button on the registry home page
    And the user lands on the registry sign-in page
    When the user enters their "<user_name>"
    And the user enters their "<password>"
    And the user clicks the sign-in button
    Then the user lands on the my registry list page for "<reg_number>"

    Examples:
      |URL|environment|ship_type|reg_number|item_number|qty|browser|device|user_name|password|
      |TRU |prod       |ship-to    |12345678|12345678  |1     |chrome|MAC |lisa@tru.com|password|
    #add ship type later on the data should be an item which is S2H and update data scenarios these are placeholders for now
    #will reference variables for various user accounts in the future these are just samples

  @registrant @P2 @reg_critical_integration #JIRA Number reference pending
  Scenario Outline: Registrant (with multiple registries) logs in to Registry

     #take Given statement from common step definitions the given statement
    Given the user navigates to "<URL>" site in "<environment>" environment on "<browser>" and "<device>"
    When the user clicks the manage button on the registry home page
    And the user lands on the registry sign-in page
    When the user enters their "<user_name>"
    And the user enters their "<password>"
    And the user clicks the sign-in button
    Then the user lands on the my registries list (account page) with "<reg_number>" listed

    Examples:
      |URL|environment|ship_type|reg_number|item_number|qty|browser|device|user_name|password|
      |TRU |prod       |ship-to    |12345678|12345678  |1     |chrome|MAC |lisa@tru.com|password|
    #add ship type later on the data should be an item which is S2H and update data scenarios these are placeholders for now
    #will reference variables for various user accounts in the future these are just samples





