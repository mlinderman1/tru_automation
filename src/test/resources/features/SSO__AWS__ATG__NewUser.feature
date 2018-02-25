#  Author: sunitha.paturi@toysrus.com
#  Recent Update: 2/16/2018
Feature: SSO: ATG New User

  Scenario Outline: user created in ATG should be linked in CLS
    Given the user navigates to "<site>" site in "<environment>" environment for SSO
    And the user clicks 'My Account' from the global navbar
    And the user clicks 'Create' from the global navbar
    And the user creates account in "toysrus"
    Then user should be linked

    Examples: 
      | site    | environment |
      | atg_aws | qa2         |

  Scenario Outline: user created in ATG should be able to login
    Given the user navigates to "<site>" site in "<environment>" environment for SSO
    And the user clicks 'My Account' from the global navbar
    And the user clicks 'Create' from the global navbar
    And the user creates account in "toysrus"
    Then user  see profile page
    And user clicks on welcome back
    And user sign out from ATG
    And the user clicks 'My Account' from the global navbar
    And user clicks sign in from the global navbar
    Then user should sign in with same credentials

    Examples: 
      | site    | environment |
      | atg_aws | qa2         |
