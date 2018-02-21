#  Author: Erin.Murphy@toysrus.com
#  Recent Update: 2/20/2018

@reg @reg_create
Feature: Registry: Create

  @registrant @P1 #JIRA Number reference pending
  Scenario Outline: Registrant creates a new registry account with co-registrant for their first baby (public registry)

     #take Given statement from common step definitions the given statement
    Given the user navigates to "<URL>" site in "<environment>" environment on "<browser>" and "<device>"
    When the user clicks the create button on the registry home page
    And the user lands on the registry create page
    When the user enters their "<first_name>"
    And the user enters their "<last_name>"
    And the user enters their "<user_name>"
    And the user enters their "<password>"
    And the user enters their "<password>"
    And the user clicks the add co-registrant option1
    And the user enters their "<co_reg_first_name>"
    And the user enters their "<co_reg_last_name>"
    And the user enters their "<street_address>"
    And the user enters their "<street_address_2>"
    And the user enters their "<zip_code>"
    And the user enters their "<city>"
    And the user enters their "<state>"
    And the user enters their "<phone_number>"
    And the user enters their "<event_month>"
    #below step is lower priority
    And the user clicks the preference to receive weekly purchase emails
    And the user clicks the create registry button
    Then the user lands on the my checklist page and has successfully created a registry account

    Examples:
      |URL|environment|ship_type|reg_number|item_number|qty|browser|device|user_name|password|
      |TRU |prod       |ship-to    |12345678|12345678  |1     |chrome|MAC |lisa@tru.com|password|
 #Will update the data at a later point


