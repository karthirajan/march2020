@regressionFeb
Feature: Add Customer in demo site


  @sanity1
  Scenario: Add Customer with hard coded datas
    
    And User click on add customer button
    When User enters all the fields
    And User click on submit button
    Then User should be displayed customer ID is generated or not

 @smoke1 @karthi
  Scenario: One Dim List
    
    And User click on add customer button
    When User enters all the fields with one dimensional
      | karthick | soundararajan | rajan@gmail.com | thanjavur | 46224223342 |
    And User click on submit button
    Then User should be displayed customer ID is generated or not

 @karthi
  Scenario: 
  
    And User click on add customer button
    When User enters all the fields with one dimensional map
      | Fname   | ajith             |
      | Lname   | soundararajan     |
      | Email   | soundar@gmail.com |
      | Address | peravurani        |
      | phno    |        7356234654 |
    And User click on submit button
    Then User should be displayed customer ID is generated or not
