#  Author: Siva V
#  Recent Update: 3/08/2018
Feature: parallel POC
  @Poc
  Scenario Outline: 
    When user open "<browser Name>" broswer
    Given the user navigates to "<site>" site
    Then the user verify Shop By menu displays
    And user clicks on 'Shop By menu' button
    And the user selects "<category type>" category
    And the user is on "<category type>" page

    @firefox
    Examples: 
      | browser Name | site                     | category type |
      | firefox      | https://www.toysrus.com/ | Movie HQ      |

    @chrome
    Examples: 
      | browser Name | site                     | category type |
      | chrome       | https://www.toysrus.com/ | Age           |

    @ie
    Examples: 
      | browser Name | site                     | category type |
      | ie           | https://www.toysrus.com/ | Top Rated     |
