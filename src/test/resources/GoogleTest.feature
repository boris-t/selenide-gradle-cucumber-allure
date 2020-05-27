Feature: Google Search example

  Scenario: Check google search
    Given open "https://google.com" page
    When enter "Selenide" in search input
    Then search results page opens
    And first result has text "Selenide"