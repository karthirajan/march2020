@regressionMarch
Feature: Title of your feature
  I want to use this template for my feature file

Background:
     And User click on add tariff button

@sanity
  Scenario: Title of your scenario
    When User enters tariff plan fields
    And User click on tariff submit button
    Then User should be received congratulation message
 
@smoke  
   Scenario: Title of your scenario
    When User enters tariff plan fields with two dim list
      | 400 | 300 | 200 | 100 | 4 | 3 | 2 |
      | 300 | 200 | 100 | 100 | 5 | 4 | 3 |
      | 200 | 100 | 300 | 100 | 6 | 5 | 4 |
      | 100 | 400 | 400 | 100 | 7 | 6 | 5 |
    And User click on tariff submit button
    Then User should be received congratulation message

@karthi
  Scenario: Title of your scenario
    When User enters tariff plan fields with two dim map
      | MR  | FLM | FIM | FSP | LMC | IMC | SMC |
      | 400 | 300 | 200 | 100 |   4 |   3 |   2 |
      | 300 | 200 | 100 | 100 |   5 |   4 |   3 |
      | 200 | 100 | 300 | 100 |   6 |   5 |   4 |
      | 100 | 400 | 400 | 100 |   7 |   6 |   5 |
    And User click on tariff submit button
    Then User should be received congratulation message

 @sanity   
    Scenario Outline:
    When User enters tariff plan fields "<MR>","<FLM>","<FIM>","<FSP>","<LMC>","<IMC>","<SMC>"
    And User click on tariff submit button
    Then User should be received congratulation message
    
    Examples:
      | MR  | FLM | FIM | FSP | LMC | IMC | SMC |
      | 400 | 300 | 200 | 100 |   4 |   3 |   2 |

    
    
