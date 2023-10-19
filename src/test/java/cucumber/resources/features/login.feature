Feature: Login
  Scenario: Success Login
    Given user open login page
    When input username
    And input password
    And click btn login
    Then user in on dashboard page

  Scenario: Failed Login
    Given user open login page
    When  input unregistered username
    And input unregistered password
    And click btn login
    Then open error message
