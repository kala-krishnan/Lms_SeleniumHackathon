#Author: Gayathri
Feature: Multiple Delete
Background: Admin clicks delete button under header after selecting the check box in the data table

Given Admin should see common delete option enabled under header Manage Program.
    When Admin clicks any checkbox in the data table.
    Then Admin should see the checkbox selected.

   
Scenario Outline: Validate multiple program deletion by selecting Single checkbox
    
    Given Admin click on multiple program delete button with checkbox selected.
    When Admin clicks on Program delete dialog "<Confirmation>" button.
    Then Admin gets confirmation for Program delete "<Message>".
    And Admin is in Manage program Page.

    Examples: 
      | Confirmation | Message          |
      | Yes          | Programs Deleted |
      | No           | NA               |
