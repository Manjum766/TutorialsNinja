Feature: Login Functionality

  Background: Flow till launching application
    Given User navigates to login page

  @Regression
  Scenario Outline: Login with different set of Test Data
    When User enters email address <username> into email field
    And User enters password <password> into password field
    And User clicks on Login button
    Then User should get successfully logged in

    Examples: 
      | username                  | password |
      | varadaraj.vv@gmail.com    | Selenium |
      | varadaraj.vv8@gmail.com   | Selenium |
      | varadaraj.vv777@gmail.com | Selenium |
