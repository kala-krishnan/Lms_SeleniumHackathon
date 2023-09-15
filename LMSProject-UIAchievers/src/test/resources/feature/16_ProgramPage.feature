#Author: Gayathri
Feature: Delete Program

  Background: Admin is on Manage Program Page after clicks Program on the navigation bar

  Scenario: Validating admin is in 'Manage Program'.
    Given Admin is in Manage program Page .
    When Admin clicks program link on the navigator bar.
    Then Admin should be on Manage Program page 'Manage Program' in program module
   
  Scenario: Validate Close icon on Confirm Deletion alert.
    When Admin clicks Close Icon on Deletion alert.
    Then Admin can see the deletion alert disappears without any changes.
   