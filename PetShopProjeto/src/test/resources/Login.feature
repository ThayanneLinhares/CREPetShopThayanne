@Login
Feature: Verify the login on different browsers


 	Scenario Outline: Login in at the PetStore website on different browsers
   	Given I am on the login page using "<browser>"
   	When I insert valid data to log in
    And I click to login button
    Then I should be redirected to the home page
  
       Examples: 
       | browser | 
       | chrome  | 
       | firefox | 