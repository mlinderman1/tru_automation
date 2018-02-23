Feature: Header and Footer Verification

  @REG_SC_028
  Scenario Outline: To verify the UI of home page Header/ Footer and Body Content
    Given the user navigates to "<site>" site in "<environment>" environment
    Then Verify Homepage Header body content
    Then Verify Homepage Footer body content

    Examples: 
      | site | environment |
      | TRU  | QA          |

  @REG_SC_050
  Scenario Outline: To verify user able to add item from PDP
    Given the user navigates to "<site>" site in "<environment>" environment
    Then Enter <product> then search
    And Click on AddToCart and click on View cart and Checkout
    Then Verify product details in shopping cart "Your cart subtotal"

    Examples: 
      | site | environment | product         |
      | TRU  | QA          | Guesstures Game |

 