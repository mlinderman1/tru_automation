#  Author: surendra.pericherla@toysrus.com
#  Recent Update: 2/21/2018
Feature: Webstore: User SignedIn



 Scenario Outline: Guest user logs in from empty cart by clicking sign-in link from block text
  
    Given the user navigates to "<site>" site in "<environment>" environment
    And the user clicks the minicart button from the global navbar
    And the user clicks 'signIn' link from the  empty cart
    And the user enters the email "<email>" and password "<password>" from flyout
    And the user submits the signIn button from flyout
    And the user verifies the flyout has closed
    Then the user is "<email>" SignedIn Successfully from the  minimized global navbar
 
 Examples:   
    | site |environment| email                  | password    |
    | TRU  |prod       | tru.linderman@gmail.com| TestTest123 |





  Scenario Outline: Guest user logs in from empty cart by clicking sign-in button from minimized header    
  
  
    Given the user navigates to "<site>" site in "<environment>" environment
    And the user clicks the minicart button from the global navbar
    And the user clicks 'signIn' button from the  minimized global navbar
    And the user enters the email "<email>" and password "<password>" from flyout
    And the user submits the signIn button from flyout
    And the user verifies the flyout has closed
    Then the user is "<email>" SignedIn Successfully from the  minimized global navbar

    Examples: 
     | site |environment| email                  | password    |
     | TRU  |prod       | tru.linderman@gmail.com| TestTest123 |
  
    
    