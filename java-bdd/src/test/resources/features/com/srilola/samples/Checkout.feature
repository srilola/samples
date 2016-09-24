Feature: Shopping cart checkout system

	Sales assistants at the till should be able to scan the items from a customer's shopping basket
	and output price of total cost. 
  	
  	Scenario Outline: Shopping cart checkout of a shop that sells apples and oranges
  	
  	Given the shop sells the following items:
  	| product			| price_in_pence |
  	| apple				| 60  			 |
  	| orange        	| 40  			 |
    And a customer shopping cart contains:
    | item				| quantity |
    | apple				| <apples> |
    | orange            | <oranges> |
    When the shopping cart is scanned at the till
    
    Then checkout system should output total cost as <total_cost> 
  	
  	Examples:
  	| No. 	| apples | oranges| total_cost|
  	|  1    |  1     |   1    | £1.00     |
  	
