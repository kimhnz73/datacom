# Note: All scenarios here currently fail to highlight known bugs.
# Each failed scenario will need to raised a ticket for developers to fix.
# Once the bugs are fixed, all scenarios will pass.
Feature: Find all bugs in the CHALLENGE - Spot the BUGS! page
    Background:
        Given I navigate to QA main page
        When I navigate to Spot the BUGS CHALLENGE page

    Scenario: Validate First Name Label, Placeholder and Text Helper
        Then I expect field label "First Name" to exist
        Then I expect field placeholder "Enter first name" to exist

    Scenario: Validate Last Name Label, Placeholder and Text Helper
        Then I expect field label "Last Name*" to exist
        Then I expect field placeholder "Enter last name" to exist

    # NOTE: This scenario fails due to known bugs below
    Scenario: Validate Phone Number Label, Placeholder and Text Helper
        # Known bug 1: Phone number label is wrong (Screen says: Phone nunber*)
        When I expect field label "Phone Number*" to exist
        Then I expect field placeholder "Enter phone number" to exist
        # Known bug 2: Phone number text helper is wrong (Screen says: Phone length validation: at least 10 digits)
        # NOTE: This is a bit unclear, but strictly speaking, it should say "Phone number length" instead of "Phone length"
        Then I expect field text helper "Phone number length validation: at least 10 digits" to exist

    Scenario: Validate Country Label, Placeholder and Text Helper
        When I expect field label "Country" to exist
        Then I expect field placeholder "Select a country..." to exist

    # NOTE: This scenario fails due to known bugs below
    Scenario: Validate Email Address Label, Placeholder and Text Helper
        # Known bug 3: Screen says "Email address". But it should say "Email Address" to be consistent with other field label conventions
        When I expect field label "Email Address*" to exist
        Then I expect field placeholder "Enter email" to exist

    # NOTE: This scenario fails due to known bugs below
    Scenario: Validate Password Label, Placeholder and Text Helper
        When I expect field label "Password*" to exist
        # Known bug 4: Screen says "Password". But it should say "Enter password" to be consistent with other field label conventions
        Then I expect field placeholder "Enter password" to exist
        # Known bug 5: Screen says "Psw length validation: [6,20] characters". But it should say "Password length validation: [6,20] characters" to be consistent with other field label conventions
        Then I expect field text helper "Password length validation: [6,20] characters" to exist

    # NOTE: This scenario fails due to known bugs below
    Scenario: Validate Terms and Condition
        # Known bug 6: Currently the checkbox is disabled so the user cannot tick the terms and condition checkbox
        When I expect Terms and Condition checkbox to be enabled

    # NOTE: This scenario fails due to known bugs below
    Scenario: Validate Mandatory fields
        Given I click Register button
        Then I expect error message "The password should contain between [6,20] characters!"
        # Known bug 7: Last Name is marked as mandatory, but the empty value is allowed
        Then I expect error message "Last Name is mandatory"
        # Known bug 8: Phone Number is marked as mandatory, but the empty value is allowed
        Then I expect error message "Phone Number is mandatory"
        # Known bug 9: Email Address is marked as mandatory, but the empty value is allowed
        Then I expect error message "Email Address is mandatory"

    # NOTE: This scenario fails due to known bugs below
    Scenario: Phone Number length validation
        Given I enter phone number "1234"
        When I click Register button
        # Known bug 10: Currently it doesn't validate the minimum length
        Then I expect error message "The phone number has to be at least 10 digits"
        Given I enter phone number "1234567890"
        When I click Register button
        Then I do not expect error message "The phone number has to be at least 10 digits"

    # NOTE: This scenario fails due to known bugs below
    Scenario: Invalid First Name and Last name
        Given I enter first name "1234"
        And I enter last name "5678"
        When I click Register button
        # Known bug 11: Expected an error message for invalid first name, but it doesn't display any error message
        Then I expect error message "First Name cannot contain number"
        # Known bug 12: Expected an error message for invalid last name, but it doesn't display any error message
        Then I expect error message "Last Name cannot contain number"


#    9. invalid enail format
#    10. password length validation is missing

#    13. Phone nunber* takes letter
#
#
#    15. after regi - last name phone number are not correct different from what I entered
#    Last Name: Ki
#    Phone Number: 12345678910
#
#    16. password is not encrypted
#
