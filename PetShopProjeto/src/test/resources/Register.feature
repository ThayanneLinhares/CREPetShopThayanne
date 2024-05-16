@Register
Feature: Register at the PetStore website

  Scenario Outline: Register at the PetStore website on different browsers
    Given I am on the registration page using "<browser>"
    When I enter valid credentials to register 
    Then I click the save account button and I should be registered successfully
     

       Examples: 
       | browser | 
       | chrome  | 
       | firefox | 