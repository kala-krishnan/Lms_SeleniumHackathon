 
 
 Feature: Verify sort Function in manage class page
 
 Scenario: Verify sort function in data table for descending order in class page
     
    Given Admin is in manage Class page 
    When Admin click on Batch id column header to sort in class page
    Then Admin should see data table sorted in descending order in "class" page
    
   Scenario: Verify sort function in data table for ascending order
     
    Given Admin is in Manage Class page
    When Admin double click on Batch id column header to sort in class page 
    Then Admin should see data table sorted in ascending  order in "class" page
     
    