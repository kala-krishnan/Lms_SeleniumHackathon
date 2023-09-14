#Author: Gayathri
Feature: Multiple delete
Background: Admin is on dashboard page after Login and clicks Program on the navigation bar

    Given Admin is on dashboard page after Login .
    
    When Admin clicks Program on the navigation bar.
    Then Admin should see URL with "Manage Program".
    
    Scenario: Validate Common Delete button.
    Given Admin is on Manage Program page.
    When Admin clicks any checkbox in the data table.	
    Then Admin should see common delete option enabled under header Manage Program.
    

  