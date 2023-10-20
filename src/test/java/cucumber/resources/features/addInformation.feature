Feature: Add Information

  Scenario: Input checkout information
    Given success checkout
    When input checkout information
    And click btn continue
    Then open checkout overview page

  Scenario: Verify the checkout process when shipping information is empty
    Given success checkout
    When click btn continue
    Then open error message First Name is required