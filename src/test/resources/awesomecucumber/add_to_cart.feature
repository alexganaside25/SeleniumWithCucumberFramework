Feature: Add to cart

  Scenario: Add one quantity from Store
    Given I'm on the Store page
    When I add a "Blue Shoes" to the Cart
    Then I see 1 "Blue Shoes" in the Cart

  @smoke
  Scenario Outline: Add one quantity from Store - examples
    Given I'm on the Store page
    When I add a "<product_name>" to the Cart
    Then I see 1 "<product_name>" in the Cart
    Examples:
      | product_name                    |
      | Anchor Bracelet                 |
      | Black Over-the-shoulder Handbag |