Feature: Add Product

  Scenario: Verify the successful addition of a product to the cart
    Given user open login page
    When input username
    And input password
    And click btn login
    And user in on dashboard page
    And klik product
    Then klik cart