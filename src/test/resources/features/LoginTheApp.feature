@LoginTheApp
Feature: Login in TheApp

  Scenario: Verify user can login in TheApp
    Given user Open TheApp Application
    When Click On Login Screen
    And User type "alice" on username password with "mypassword"
    Then user should be able to see login profile