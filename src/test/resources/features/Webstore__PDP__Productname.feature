#  Author: Anilsharma@zensar.com
#  Recent Update: 13/3/2018
Feature: Webstore: PDP Page 
@Regressssion, @REG_SC_PDP_1, @Productname 
Scenario Outline: Guest user to verify the productname and price 
	Given the user navigates to "<site>" site in "<environment>" environment 
	And the user searches for a random item 
	And the user is on the PLP page 
	When the user clicks to PDP of in-stock Ship-to item from PLP page 
	When the user is on the PDP page 
	Then the user verifies 'Productname' 
	Then the user verifies 'Productprice' 
	Then the user verifies 'Quantity' 
	Then the user verifies 'Product description' 
	Then the user verifies 'Product features'
	Then the user verifies 'good to know'
	Then the user verifies 'additional info'
	Then the user verifies 'product questions'
	Then the user verifies 'customer reivew summery'
	
	Examples: 
	
		|site|environment|
		|TRU|prod    |    
