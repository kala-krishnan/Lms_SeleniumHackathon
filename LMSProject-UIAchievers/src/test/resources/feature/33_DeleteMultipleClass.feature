 Feature: Verify delete multiple class  button  
 
 
  Scenario: Verify delete multiple class  button is enabled
    Given Admin is in Manage Class page
    When Admin clicks single <1> row level check box in the data table in delete class window
    Then Admin should see delete icon below the header is enabled
 
 Scenario: verify tick mark is visible after clicking on check box in delete class window 
    Given Admin is in Manage Class page
    When Admin clicks single <1> row level check box in the data table in elete class window
    Then Admin should see tick mark in check box in delete class window
    
 Scenario: verify admin able to click multiple check box in delete class window 
    Given Admin is in Manage Class page
    When Admin clicks multiple row level check box in the data table
    Then Admin should see tick mark in Check box  of the selected rows in delete class window
    
 Scenario: Verify accept alert in delete multiple class function by selecting single checkbox   
    Given Admin is on Delete alert in delete class window
    When Admin clicks "Yes" button on alert window in delete class window 
    Then Success Message and validate particular Class details are deleted from the data table
    
 Scenario: Verify reject alert in delete multiple class function by selecting single checkbox  
    Given Admin is on Delete alert in delete class window
    When Admin clicks "No" button on alert window in delete class window 
    Then Admin should land on Manage class page and validate particular Class details are not deleted from the data table1
      
    Scenario: Verify accept alert in delete multiple class function by selecting multiple checkbox
    Given Admin is on Delete alert in delete class window
       When Admin click "Yes" button on alert window in delete class window1  
    Then Admin should land on Manage Class page and validate particular Class details are deleted from the data table
    
    Scenario: Verify reject alert in delete multiple class function by selecting multiple checkbox
    Given Admin is on Delete alert in delete class window
    When Admin click "No" button in alert in delete class window
    Then Admin should land on Manage Class page and validate particular class details are not deleted from the data table
    
    