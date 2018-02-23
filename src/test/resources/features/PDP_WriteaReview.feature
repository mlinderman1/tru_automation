#  Author: bhanusatish.s@zensar.com
#  Recent Update: 2/20/2018
Feature: Write a Review 

@REG_SC_055 
Scenario Outline: Write a Review for Product 
	Given the user navigates to "<site>" site in "<environment>" environment 
	And the user searches for a random item 
	And the user is on the PLP page 
	When the user clicks to PDP of in-stock Ship-to item from PLP page 
	And the user is on the PDP page 
	And write a Review button 
	Then New Review window opens 
	Then Enter Review and Submit 
	
	Examples: 
		| site | environment |
		| TRU  | QA        |