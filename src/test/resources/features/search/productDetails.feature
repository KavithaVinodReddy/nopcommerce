Feature: search results module

  Scenario: verify search results layout
    Given search results are displayed
    When I click first item
    Then product item should be displayed as per design

  Scenario: verify product is added to shopping card
    Given I am on a product detail page
    When I click Add to Cart
    Then shopping cart should be updated with "1"

  Scenario: verify product is added twice to shopping card
    Given I am on a product detail page
    When I click Add to Cart twice
    Then shopping cart should be updated with "2"

  Scenario: verify product to shopping cart correctly
    Given I am on a product detail page
    When I give 2 number in the quantity field
    And I click Add to Cart
    Then shopping cart should be updated with "2"

  Scenario: verify product is added to wishing list correctly
    Given I am on a product detail page
    When I give 2 number in the quantity field
    And I click Add to Cart
    Then shopping cart should be updated with "2"