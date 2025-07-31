Feature: CHALLENGE - Spot the BUGS!
    Background:
        Given I navigate to QA main page

    Scenario: Test navigation to Spot The Bugs Challenge Page
        Given I navigate to Spot the BUGS CHALLENGE
        Then I expect page to contain text "CHALLENGE - Spot the BUGS!"

