Feature: Search Functionality

  Background: Flow till launching application
    Given User opens the Application

  @Sanity @Regression
  Scenario: User Searches for a Valid Product
    When User enters valid product "HP" into Search Box field
    And User clicks on Search button
    Then User should get Valid Product displayed in Search Results

  @Regression
  Scenario: User Searches for a Invalid Product
    When User enters Invalid product "Honda" into Search Box field
    And User clicks on Search button
    Then User should get a message about no product matching

  @Regression
  Scenario: User Searches without any Product
    When User donot enter any product name into Search Box field
    And User clicks on Search button
    Then User should get a message about no product matching
