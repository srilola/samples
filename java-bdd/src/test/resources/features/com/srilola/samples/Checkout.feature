Feature: Shopping cart checkout system

	Sales assistants at the till should be able to scan the items from a customer's shopping basket
	and output price of total cost. 
  	"""
  	  Step -1 : Basic checkout functionality
  	"""
  	Scenario: Shopping cart checkout of a shop that sells apples and oranges
  	
  	Given the shop sells the following items:
  	| name              | price              |
  	| Apple				| 0.60  			 |
  	| Orange        	| 0.25  			 |
    And a customer shopping cart contains:
    | Apple            |
    | Apple            |    
    | Orange           |
    | Apple            |

    When the shopping cart is scanned at the till
    
    Then checkout system should output total cost as £2.05 
  

    Scenario: Shopping cart checkout of a shop that sells apples and oranges with offers
    """
    On scanning the items at the till, the shopping checkout system should apply any price discount that are
    being offered on the items.
    
    This scenario illustrated the required by the following two rules
    
    1) Buy one, get one free on Apples
    2) 3 for price of 2 on Oranges
    
    """
  	Given the shop sells the following items:
  	| name              | price              | offer                |
  	| Apple				| 0.60  			 | Buy one, get one free |
  	| Orange        	| 0.25  			 | 3 for price of 2      |

    And a customer shopping cart contains:
    | Apple            |
    | Apple            |    
    | Orange           |
    | Orange           |
    | Orange           |
    
    When the shopping cart is scanned at the till
    
    Then checkout system should output total cost as £1.10 
  
  
    Scenario Outline: Shopping cart checkout of a shop that sells apples and oranges with offers different cases
    """
    On scanning the items at the till, the shopping checkout system should apply any price discount that are
    being offered on the items.
    
    This scenario illustrated the required by the following two rules
    
    1) Buy one, get one free on Apples
    2) 3 for price of 2 on Oranges
    
    """
  	Given the shop sells the following items:
  	| name              | price              | offer                |
  	| Apple				| 0.60  			 | Buy one, get one free |
  	| Orange        	| 0.25  			 | 3 for price of 2      |

    And a customer shopping cart contains (with quantity):
    | Apple            |  <apples> |
    | Orange           |  <oranges>|
    
    When the shopping cart is scanned at the till
    
    Then checkout system should output total cost as £<totalCost> 
  
  	Examples:
  	|case No. | apples | oranges | totalCost |
  	| 1       | 2      | 3       | 1.10      |
  	| 1       | 1      | 2       | 1.10      |
  	| 1       | 3      | 2       | 1.70      |
  	