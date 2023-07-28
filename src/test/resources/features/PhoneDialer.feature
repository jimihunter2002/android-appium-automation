@PhoneDialerApp
Feature: Login in TheApp

  Scenario: Verify user can dial a number using dialer app
    Given user launched PhoneDialerApp Application
    When Click On dialer keypad menu to display numbers
    Then user should be able to see the dial button
    And User dial the number "07432128414"
    Then number "07432128414" should be dialed successfully
    And user ends the call successfully