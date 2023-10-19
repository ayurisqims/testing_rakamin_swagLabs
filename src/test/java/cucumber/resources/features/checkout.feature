Feature: Checkout

  Scenario: successful checkout process
    Given success add product
    When click btn checkout
    And input checkout information
    And click btn continue
    Then open checkout overview page

  Scenario: checkout process with null information
    Given success add product
    When click btn checkout
    And click btn continue
    Then open checkout overview page