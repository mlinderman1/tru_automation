#  Author: bhaunsatish.s@zensar.com
#  Recent Update: 3/08/2018
Feature: Webstore: Help Option
@Regression, @HelpOption, @REG_SC_HOME_46,
  Scenario Outline: Guest user Verify the functionality of Help option in home page.

    Given the user navigates to "<site>" site in "<environment>" environment
    And the user is on ToysRUs homepage
    Then the user verify 'Help Option' in the global navbar 
    And the user clicks 'Help' from the global navbar
    And the user verify 'live chat' in the Help Option 
    And the user verify 'help center' in the Help Option 
    
     Examples:
      |site|environment|
      |TRU |prod       |