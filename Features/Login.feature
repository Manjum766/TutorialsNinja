Feature: Login Functionality

  Background: Flow till launching application
    Given User navigates to login page

  @Sanity @Regression
  Scenario: Login with Valid credentials
    When User enters valid email address "varadaraj.vv@gmail.com" into email field
    And User enters valid password "U2VsZW5pdW0=" into password field
    And User clicks on Login button
    Then User should get successfully logged in

  @Regression
  Scenario: Login with Invalid credentials
    When User enters invalid email address into email field
    And User enters valid password "U2VsZW5pdW0" into password field
    And User clicks on Login button
    Then User should get proper warning message about credentials mismatch

  @Regression
  Scenario: Login with Valid Email and Invalid Password
    When User enters valid email address "varadaraj.vv@gmail.com" into email field
    And User enters invalid password "U2VsZW5pdW0!@#$" into password field
    And User clicks on Login button
    Then User should get proper warning message about credentials mismatch

  @Regression
  Scenario: Login with Invalid Email and Valid Password
    When User enters invalid email address into email field
    And User enters valid password "U2VsZW5pdW0=" into password field
    And User clicks on Login button
    Then User should get proper warning message about credentials mismatch

  @Regression
  Scenario: Login without providing any credentials
    When User donot enter email address into email field
    And User donot enter password into password field
    And User clicks on Login button
    Then User should get proper warning message about credentials mismatch
