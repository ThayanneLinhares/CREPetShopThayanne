@search
Feature: Ordering product on PetStore website 

   Scenario Outline: Searching and ordering a product on PetStore website on different browsers
    Given I am logged and able to search a product using "<browser>"
    When I add the product to the shopping cart
    When I proceed to checkout from the shopping cart
    Then I fill the form and confirm the order
    

 
       Examples: 
       | browser | 
       | chrome  | 
       | firefox | 
       
       
 