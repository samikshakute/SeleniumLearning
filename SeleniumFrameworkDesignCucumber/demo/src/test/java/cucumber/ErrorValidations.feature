@tag
Feature: "Error Validation"
    This is feature description
    @ErrorValidation:
    Scenario Outline: Positive Test of Submitting the Order
        Given I Landed on Ecommerce page
        When Logged in with username <name> and password <password>
        Then "Incorrect email or password." message is displayed

        Examples:
            | name                  | password  |
            | wrong_email@gmail.com | Sam@12345 |