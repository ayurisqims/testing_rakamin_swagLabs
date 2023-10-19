Feature: Add Cart

  Scenario: successful addition of a product to the cart
    Given success login web
    When click add to cart
    And click cart
    Then open your cart page

  Scenario: successful addition of a product more than one
    Given success login web
    When click add to cart
    And click add to cart jacket
    And click cart
    Then open your cart page