#  Author: Mike.Linderman@toysrus.com
#  Recent Update: 1/29/2018

Feature: Webstore:

  Scenario Outline:

    When the user clicks <"site"> mini logo from topline header
    Then the user is navigated to <"site"> homepage

    When the user clicks Baby Registry link from topline header
    Then the user is navigated to Baby Registry homepage

    When the user clicks Find a Store link from topline header
    Then the Find a Store flyout is displayed
    When the Find a Store flyout "X" close button is clicked
    Then the Find a Store flyout is not displayedFeatures

    When the user clicks Weekly Ad link from topline header
    Then the user is navigated to the Savings Center page

    When the user clicks Wishlist link from topline header
    Then the user is navigated to the Wishlist page



    When the user clicks Gift Cards link from topline header


    When the user clicks main logo from global navbar
    When the user clicks Shop By hamburger menu from global navbar
    Then categories are displayed in Search By menu
    And the user selects a random category from Shop By menu
    And the user selects "<string>" from Shop By menu

    When the user inputs "<string>" into global navbar search field
    And the user clicks the search button from the global navbar search field
    Then suggested search results are displayed
    And the user clicks a suggested search result

    When the "<user_type>" user clicks My Account from global navbar
    And the guest user clicks Sign-in from global navbar My Account
    And the signed-in user clicks Sign-out from global navbar My Account


    When the user clicks Help tile from global navbar
    And the user clicks









    Examples:
      |environment|site|user_type|item|page|ship_type|checkout_type|payment_type|
      |qa2       |TRU        |guest|random |plp|ship-to        |standard|credit card|

