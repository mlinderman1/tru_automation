#  Author: Anilsharma@zensar.com
#  Recent Update: 12/3/2018
Feature:  Webstore: Homepage Footer

@Regressssion, @REG_SC_HOME_38, @Footer_Links
Scenario Outline:  Guest user to verify the UI of the Footer Links
Given the user navigates to "<site>" site in "<environment>" environment
Then the user in Brand footer
Then the user clicks on 'countryflag' 
Then the user verifies select your region popup
Then the user closes dialogbox

  Examples:
      |site|environment| 
      |TRU|prod |        


