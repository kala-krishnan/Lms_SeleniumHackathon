#Author: Gayathri
Feature: Sorting(Data Ordering) Validation

 Background: Admin is on Manage Program Page after clicks Program on the navigation bar
 
    Given Admin is in Manage program Page. 
    When Admin clicks program link on the navigator bar.
    Then Admin should be on Manage Program page 'Manage Program'.

 Scenario Outline: Validates Sorting(data ordering) on the Program Data table
Given Admin is in Manage program Page. 
When User clicks on the Ascending or Descending arrow button on program page.
      | Program Name        |
      | Program Description |
      | Program Status      |
 Then User can see the results in Ascending or Descending order on program page.

    
 