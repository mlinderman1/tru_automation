#  Author: Erin.Murphy@toysrus.com
#  Recent Update: 2/20/2018
Feature: Registry Create
  @create

    Scenario Outline: Registrant creates a new registry account with co-registrant for their first baby (public registry)
    Given the user navigates to "<site>" sites in "<environment>" environment
    When the user clicks the create button on the registry home page
    And the user lands on the registry create page
    And the user enters their "<fn>" FirstName
    And the user enters their "<ln>" LastName
    And the user enters their UserName
    And the user enters their "<password>" Password
    And the user enters their "<password_confirm>" Confirm Password
    And the user clicks the add co-registrant option
    And the user enters their "<co_reg_first_name>" Co_Reg_First_Name
    And the user enters their "<co_reg_last_name>" Co_Reg Last_Name
    And the user enters their "<address_line1>" Street Address Line1
    And the user enters their "<address_line2>" Street Address Line2
    And the user enters their "<zip_code>" Zip code
    And the user enters their "<city>" City
    And the user enters their "<state>" State
    And the user enters their "<phone_number>" Phonenumber
    And the user enters their "<event_month>" Eventmonth and "<event_date>" EventDate
    #below step is lower priority
    #And the user clicks the preference to receive weekly purchase emails
    And the user clicks the create registry button
    Then the user lands on the my checklist page and has successfully created a registry account

    Examples:

    |site|environment|fn|ln|password|password_confirm|co_reg_first_name|co_reg_last_name|address_line1|address_line2|zip_code|city|state|phone_number|event_month|event_date|
    |registry|test|Lisa|TRU|registry16|registry16|FNCoReg|LNCoReg|1 Geoffery way|A|07470|Wayne|NJ|456456456465|Aug|20|
    |registry|uat|Lisa|TRU|registry16|registry16|FNCoReg|LNCoReg|1 Geoffery way|A|07470|Wayne|NJ|456456456465|Aug|20|
    |registry|prod|Lisa|TRU|registry16|registry16|FNCoReg|LNCoReg|1 Geoffery way|A|07470|Wayne|NJ|456456456465|Aug|20|
