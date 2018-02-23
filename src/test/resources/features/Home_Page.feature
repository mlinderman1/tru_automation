#  Author: Siva
#  Recent Update: 02/21/2018
Feature: Home_Page Functionality

  @REG_SC_033
  Scenario Outline: Provide Feedback from Homepage
    Given the user navigates to "<site>" site in "<environment>" environment
    When the user clicked on feedback button
    Then New window opens
    Then Enter Feedback and Submit

    Examples: 
      | site | environment |
      | TRU  | QA          |

  @REG_SC_030
  Scenario Outline: verify the functionality of Babiesrus logo
    Given the user navigates to "<site>" site in "<environment>" environment
    Given the user click on Babiesrus Logo
    Then The Message should display

    Examples: 
      | site | environment |
      | TRU  | QA          |

  @REG_SC_050
  Scenario Outline: To verify user able to add item from PLP
    Given the user navigates to "<site>" site in "<environment>" environment
    And the user searches for a random item
    And the user is on the PLP page
    When the user clicks to PDP of in-stock Ship-to item from PLP page
    When the user is on the PDP page
    And the user adds PDP item to cart
    Then the Add to Cart overlay is displayed

    Examples: 
      | site | environment |
      | TRU  | QA          |

  @REG_SC_031
  Scenario Outline: Verify that whole site is working in HTTPs domain
    Given the user navigates to "<site>" site in "<environment>" environment
    Given the user Verifies domain name

    Examples: 
      | site | environment |
      | TRU  | QA          |

  @REG_SC_024
  Scenario Outline: verify user is able to navigate to PLP from shop by menu
    Given the user navigates to "<site>" site in "<environment>" environment
    #When the user is on the PLP page
    Then verify Shop By menu button

    Examples: 
      | site | environment |
      | TRU  | QA          |

  @REG_SC_032
  Scenario Outline: Display Feedback icon in all Pages
    Given the user navigates to "<site>" site in "<environment>" environment
    Then Verify feedback is visible

    Examples: 
      | site | environment |
      | TRU  | QA          |

  @REG_SC_029
  Scenario: Verify the Findastore
    Given the user click on Findastore
    Then the user Search zipcode
