#  Author: Anilsharma@zensar.com
#  Recent Update: 2/3/2018
Feature:  Webstore: Homepage

 Scenario Outline: REG_SC_HOME_8 Guest User clicks on Babiesrus logo

 Given the user navigates to "<site>" site in "<environment>" environment
  When the user clicks main "<logo>" logo from the global navbar
  And the user is on BabiesRUs homepage
    Examples:
    
      |site|environment||logo|
      |TRU|qa2     |    |bru|

 
 Scenario Outline: REG_SC_HOME_41 To Verify the User should be able to navigate to the find a store page.
 
 Given the user navigates to "<site>" site in "<environment" environment
 When the user clicks Find a Store link from topline header
 Then the Find a Store flyout is displayed
 Then the user closes the flyout
 Examples:
      |site|environment|
      |TRU|qa2     |   
      
 Scenario Outline: REG_SC_HOME_48 To Verify the User should be to click and navigate to the "Wishlist"page.

 Given the user navigates to "<site>" site in "<environment>" environment
 When the user clicks Wishlist link from topline header
 Then The user in Wishlist page
                    
    Examples:
      |site|environment|
      |TRU|qa2     |   

 Scenario Outline: REG_SC_HOME_49 To Verify the User should be able to navigate to the "Gift Card" page.

 Given the user navigates to "<site>" site in "<environment>" environment
 When the user clicks Gift Cards link from topline header
 Then The user in  Gift Cards page      

    Examples:
      |site|environment|
      |TRU|qa2     |


Scenario Outline: REG_SC_HOME_31 To Verify the UI of Top Box Favorites  section  in Home Page

 Given the user navigates to "<site>" site in "<environment>" environment
 Then the user in toy box favorites
 Then the user clicks on rightarrow  
 Then the user clicks on leftarrow
 
 Examples:
      |site|environment|
      |TRU|qa2     |
     

Scenario Outline: REG_SC_HOME_32 To Verify the functionality of Top Box Favorites section in home page when user clicks on particular product

 Given the user navigates to "<site>" site in "<environment>" environment
 Then the user in toy box favorites
 Then the user clicks on product   
  
 Examples:
      |site|environment|
      |TRU|qa2     |
    

Scenario Outline: REG_SC_HOME_35 To Verify the Functionality of the Banners under the Sponsored Content section  in Home Page

Given the user navigates to "<site>" site in "<environment>" environment
Then the user in Sponsored Content
Then the user clicks on Sponsored product

  Examples:
      |site|environment|
      |TRU|qa2 |
  
 
