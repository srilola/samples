Feature: Shopping cart checkout system

	Sales assistants at the till should be able to scan the items from a customer's shopping basket
	and output price of total cost. 
  	
  	Scenario: Shopping cart checkout of a shop that sells apples and oranges
  	
  	Given the shop sells the following items:
  	| Apple				| 0.60  			 |
  	| Orange        	| 0.25  			 |
    And a customer shopping cart contains:
    | Apple            |
    | Apple            |    
    | Orange           |
    | Apple            |

    When the shopping cart is scanned at the till
    
    Then checkout system should output total cost as £2.05 
  
