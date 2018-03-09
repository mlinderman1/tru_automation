#  Author: bhaunsatish.s@zensar.com
#  Recent Update: 3/08/2018
Feature: Webstore: Recommended for you
@Regression, @RecommendedForYou, @REG_SC_HOME_18,
  Scenario Outline: Guest user Verify the functionality of Recommended for you section in home page.

    Given the user navigates to "<site>" site in "<environment>" environment
    And the user is on ToysRUs homepage
    And the user is on RecommendedForYou 
	Then the user clicks on rightarrow
	Then the user clicks on leftarrow  
    Then the user clicks on product
	And  the user is on the PDP page

    Examples:
      |site|environment|
      |TRU |prod       |
          