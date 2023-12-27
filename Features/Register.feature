Feature: Registration Functionality

  Background: Flow till launching application
    Given User navigates to Register Account page

  @Sanity @Regression
  Scenario: User creates an account only with mandatory fields
    When User enters details into below fields
      | FirstName | Varadaraj              |
      | LastName  | V V                    |
      | Email     | varadaraj777@gmail.com |
      | Telephone |              123456789 |
      | Password  |                  12345 |
    And User selects the Privacy Policy
    And User clicks on Continue button
    Then User account should be created successfully

  @Regression
  Scenario: User creates an account with all fields
    When User enters details into below fields
      | FirstName | Varadaraj              |
      | LastName  | V V                    |
      | Email     | varadaraj777@gmail.com |
      | Telephone |              123456789 |
      | Password  |                  12345 |
    And User selects Yes for Newsletter
    And User selects the Privacy Policy
    And User clicks on Continue button
    Then User account should be created successfully

  @Regression
  Scenario: User creates a Duplicate Account
    When User enters the details into below fields with duplicate email
      | FirstName | Varadaraj               |
      | LastName  | V V                     |
      | Email     | varadaraj.vv8@gmail.com |
      | Telephone |               123456789 |
      | Password  |                   12345 |
    And User selects Yes for Newsletter
    And User selects the Privacy Policy
    And User clicks on Continue button
    Then User should get a proper warning about duplicate email

  @Regression
  Scenario: User creates an account without filling any details
    When User dont enter any details into fields
    And User clicks on Continue button
    Then User should get proper warning message for every mandatory field
