Feature: Edit New Program

  Background: Admin is on dashboard page after Login and clicks Program on the navigation bar
  
    Given Admin is on dashboard page after Login.
    When Admin clicks Program on the navigation bar.
    Then Admin should see URL with "Manage Program"  in program module

  Scenario: Validating admin is in LoginPage.
    Given Admin is in dashboard Page after login.
    When Admin clicks program on the navigator bar.
    Then Admin should be on Manage Program page 'Manage Program'.

  Scenario: Validate Edit Feature
    
    When Admin clicks <Edit> button on the data table for any row.
    Then Admin should see a popup open for Program details to edit.

   