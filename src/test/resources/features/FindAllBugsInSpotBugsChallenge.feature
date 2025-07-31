# NOTE: This is to find all bugs in CHALLENGE - Spot the BUGS! page in the requirement
# All scenarios here currently fail to highlight known bugs.
# Each failed scenario will need to raised a ticket for developers to fix.
# Once the bugs are fixed, all scenarios will pass.
# I have found 23 bugs in total (23 bugs are covered by automation and the remaining 2 bugs are left for manual testing)
#
################### Bugs founds covered by automation ############################
# Known bug 1: Phone number label is wrong (Screen says: Phone nunber*)
# Known bug 2: Phone number text helper is wrong (Screen says: Phone length validation: at least 10 digits)
#   NOTE: This is a bit unclear, but strictly speaking, it should say "Phone number length" instead of "Phone length"
# Known bug 3: Screen says "Email address". But it should say "Email Address" to be consistent with other field label conventions
# Known bug 4: Screen says "Password". But it should say "Enter password" to be consistent with other field label conventions
# Known bug 5: Screen says "Psw length validation: [6,20] characters". But it should say "Password length validation: [6,20] characters" to be consistent with other field label conventions
# Known bug 6: Currently the terms and condition checkbox is disabled so the user cannot tick the terms and condition checkbox
# Known bug 7: Last Name is marked as mandatory, but the empty value is allowed
# Known bug 8: Phone Number is marked as mandatory, but the empty value is allowed
# Known bug 9: Email Address is marked as mandatory, but the empty value is allowed
# Known bug 10: Currently the system doesn't validate the minimum length for the phone number
# Known bug 11: Expected an error message for invalid first name (e.g. 123), but it doesn't display any error message
# Known bug 12: Expected an error message for invalid last name (e.g. 567), but it doesn't display any error message
# Known bug 13: Expected an error message for invalid email address (e.g. hello), but it doesn't display any error message
# Known bug 14: Currently the system doesn't validate the minimum length for the password
# Known bug 15: Currently the system doesn't validate the maximum length for the password
# Known bug 16: Currently the system doesn't validate letters in phone number (e.g. abcdefg)
# Known bug 17: Currently the screen says "The phone number should contain at least 10 characters!", but it should say "The phone number should contain at least 10 digits!" instead.
# Known bug 18: After registration, the confirmation message says "First Name: Hye" which is different from what the user entered. It should say "First Name: Hye Jung" instead
# Known bug 19: After registration, the confirmation message says "Last Name: Jun" which is different from what the user entered. It should say "Last Name: Kim" instead
# Known bug 20: After registration, the confirmation message says "Phone Number: 1234567891" which is different from what the user entered. It should say "Phone Number: 1234567890" instead
# Known bug 21: After registration, Country is an optional field. When it is cleared, I do not expect the country to be displayed in the confirmation message. But it shows an Country placeholder as it is.
#
################### Bugs founds covered by manual testing ############################
# Known bug 22: Password is not masked. E.g. when I enter "1234567", it is displayed as it is, it should have been displayed as "*******" instead.
# Known bug 23: The message "Note: All the fields marked with * are mandatory" is currently shown underneath the Last Name field, which is not the best place.
#   It should be displayed either at the top or at the bottom or somewhere more appropriate.

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

    # NOTE: This scenario fails due to known bugs below
    Scenario: Invalid Email Address
        Given I enter email address "1234"
        When I click Register button
        # Known bug 13: Expected an error message for invalid email address, but it doesn't display any error message
        Then I expect error message "Enter a valid email address"


    # NOTE: This scenario fails due to known bugs below
    Scenario: Password length validation
        Given I enter password "12345"
        When I click Register button
        # Known bug 14: Currently it doesn't validate the minimum length for the password
        Then I expect error message "Password must be [6,20] characters"
        Given I enter password "123456789012345678901"
        When I click Register button
        # Known bug 15: Currently it doesn't validate the maximum length for the password
        Then I expect error message "Password must be [6,20] characters"
        Given I enter password "123456"
        When I click Register button
        Then I do not expect error message "Password must be [6,20] characters"
        Given I enter password "12345678901234567890"
        When I click Register button
        Then I do not expect error message "Password must be [6,20] characters"

    # NOTE: This scenario fails due to known bugs below
    Scenario: Phone number validation
        Given I enter phone number "abcdefg"
        When I click Register button
        # Known bug 16: Currently it doesn't validate letters in phone number
        Then I expect error message "Phone number must be at least 10 digits"

        Given I enter phone number "1234567"
        When I click Register button
        # Known bug 17: Currently the screen says "The phone number should contain at least 10 characters!",
        # but it should say "The phone number should contain at least 10 digits!" instead.
        Then I expect error message "The phone number should contain at least 10 digits!"

    # NOTE: This scenario fails due to known bugs below
    Scenario: Validate confirmation message after successful registration
        Given I enter first name "Hye Jung"
        And I enter last name "Kim"
        And I enter phone number "1234567890"
        And I select country "New Zealand"
        And I enter email address "hello@gmail.com"
        And I enter password "Password1234"
        When I click Register button
        Then I expect page to contain text "Successfully registered the following information"
        # Known bug 18: Currently the screen says "First Name: Hye" which is different from what the user entered. It should say "First Name: Hye Jung" instead
        And I expect page to contain text "First Name: Hye Jung"
        # Known bug 19: Currently the screen says "Last Name: Jun" which is different from what the user entered. It should say "Last Name: Kim" instead
        And I expect page to contain text "Last Name: Kim"
        # Known bug 20: Currently the screen says "Phone Number: 1234567891" which is different from what the user entered. It should say "Phone Number: 1234567890" instead
        And I expect page to contain text "Phone Number: 1234567890"
        And I expect page to contain text "Country: New Zealand"
        And I expect page to contain text "Email: hello@gmail.com"

        When I clear country
        And I click Register button
        # Known bug 21: Country is an optional field. When it is cleared, I do not expect the country to be displayed in the confirmation message
        # But it shows an Country placeholder as it is.
        Then I do not expect page to contain text "Country: Select a country..."

