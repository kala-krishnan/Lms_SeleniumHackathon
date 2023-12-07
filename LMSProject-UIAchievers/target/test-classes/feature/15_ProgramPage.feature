#Author: Gayathri
Feature: Delete Program

  Background: Admin is on dashboard page after Login and clicks Program on the navigation bar

  Scenario: Validating admin is in LoginPage.
    Given Admin is in dashboard Page after login.
    When Admin clicks program on the navigator bar.
    Then Admin should be on Manage Program page 'Manage Program' in program module

  Scenario: Validate details for Confirm Deletion form
    Then Admin should see a message "Are you sure you want to delete <Program name>?".

Scenario: Delete Single Program
    Given Admin is in Manage program Page.
    When User select the single program checkbox and its delete button.
    Then User lands on program delete confirmation page.
    
     Scenario Outline: Delete Single Program with the confirmation.
    When User clicks on Program delete dialog "<Confirmation>" button.
    Then User gets confirmation for Program delete "<Message>".
    And Admin is in Manage program Page.

    Examples: 
      | Confirmation | Message         						|
      | Yes          | Successful Program Deleted |
      | No           |   NA   										|