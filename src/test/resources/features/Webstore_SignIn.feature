#  Author: surendra.pericherla@toysrus.com
#  Recent Update: 2/21/2018
Feature: Webstore: User SignedIn


    Scenario Outline: The User login from the empty cart through empty minicart global header
  
    Given the user navigates to "<site>" site in "<environment>" environment
    And the user clicks the minicart button from the global navbar
    And the user clicks 'signIn' link from the  empty cart
    And the user enters the email "<email>" and password "<password>" from flyout
    And the user submits the signIn button from flyout
    Then the user is "<email>" SignedIn Successfully from the  minimized global navbar
 
 Examples:   
    | site |environment| email                | password  |
    | TRU  |prod       | suran.varma@gmail.com| Sahasri10 |



      
  Scenario Outline: The User login from the flyout through empty minicart global header
  
    Given the user navigates to "<site>" site in "<environment>" environment
    And the user clicks the minicart button from the global navbar
    And the user clicks 'signIn' button from the  minimized global navbar
    And the user enters the email "<email>" and password "<password>" from flyout
    And the user submits the signIn button from flyout
    Then the user is "<email>" SignedIn Successfully from the  minimized global navbar

    Examples: 
     | site |environment| email                | password  |
     | TRU  |prod       | suran.varma@gmail.com| Sahasri10 |
  
    
    