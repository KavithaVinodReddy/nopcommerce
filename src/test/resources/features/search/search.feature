Feature: search functionality

  Scenario: search with valid data
    Given I am on the website
    When I enter "HTC" as search text
    And click search button
    Then I should get appropriate results

  Scenario: search with empty data
    Given I am on the website
    When I enter "" as search text
    And click search button
    Then I should get alert

  Scenario: search invalid data
    Given I am on the website
    When I enter "123" as search text
    And click search button
    Then I should not get any results
    And Advance search option should be shown

  Scenario: search with right click
    Given I am on the website
    When I enter "HTC" as search text
    And I press enter key
    Then I should get appropriate results
