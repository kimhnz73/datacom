# NOTE: This is to validate that the controls (i.e. navigation) works in CHALLENGE - Spot the BUGS! page in the requirement
Feature: Validate all hyperlinks in the CHALLENGE - Spot the BUGS! page
    Background:
        Given I navigate to QA main page
        When I navigate to Spot the BUGS CHALLENGE page

    Scenario: Validate navigation to Spot The Bugs Challenge Page
        Then I expect page to contain text "CHALLENGE - Spot the BUGS!"

    Scenario: Validate Home link navigation back to the main page
        Then I expect page to contain text "Home"
        When I click Home link
        Then I expect page to contain text "Welcome!"

    Scenario: Validate Contact link navigation back to the main page
        Then I expect page to contain text "Contact"
        When I click Contact link
        Then I expect page to contain text "Contact us"

    Scenario: Validate Close menu button
        When I click Close menu button
        Then I expect menu to be hidden

