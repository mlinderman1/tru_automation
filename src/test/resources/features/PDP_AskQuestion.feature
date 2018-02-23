#  Author: bhanusatish.s@zensar.com
#  Recent Update: 2/20/2018
Feature: Write a Review

@REG_SC_056
Scenario Outline: Ask a Question on Product
	Given the user navigates to "<site>" site in "<environment>" environment
	And the user searches for a random item
  And the user is on the PLP page
  When the user clicks to PDP of in-stock Ship-to item from PLP page
  And the user is on the PDP page
  And click on Ask a Question button
	Then New Ask a Question window opens
	And Enter Query and Submit
	
    Examples: 
      | site | environment |
      | TRU  | QA        |