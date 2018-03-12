#  Author: Anilsharma@zensar.com
#  Recent Update: 12/3/2018
Feature:  Webstore: Homepage Baby Registry

@Regressssion, @REG_SC_HOME_39, @Babyregistry
Scenario Outline:  Guest user to verify the UI of the Footer Links

Given the user navigates to "<site>" site in "<environment>" environment
When the user clicks Baby Registry link from topline header
Then  The user verifies the 'Find' link
Then The user verifies the 'Create' link
Then The user verifies the 'Manage' Link

  Examples:
      |site|environment| 
      |TRU|prod |        



