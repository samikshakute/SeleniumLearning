@tag
Feature: "Purchase the order from Ecommerce website"
    This is feature description
    Background:
        Given I Landed on Ecommerce page
    @Regression
    Scenario Outline: Positive Test of Submitting the Order
        Given Logged in with username <name> and password <password>
        When I add <productName> to Cart
        And Checkout <productName> and submit the order
        Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

        Examples:
            | name                | password  | productName |
            | samikshak@gmail.com | Sam@12345 | ZARA COAT 3 |