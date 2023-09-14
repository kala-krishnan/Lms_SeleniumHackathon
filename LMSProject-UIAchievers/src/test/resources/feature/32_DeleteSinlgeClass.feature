  
 Feature: Verifying Delete Class Window
 
  Scenario: Verify Delete class alert in class page
    Given Admin is in Manage class page
    When Admin clicks delete button in data table row level in Manage class page 
    Then Admin should see alert in delete class window
 
 Scenario: Verify  accept enabled in alert in class page 
    Given Admin is in Manage class page
    When Admin clicks delete button in data table row level in Manage class page
    Then Alert should have "yes" button to accept in delete class window
    
 Scenario: Verify reject enabled in alert in class page 
    Given Admin is in Manage class page
    When Admin clicks delete button in data table row level in Manage class page
    Then Alert should have "No" button to reject in delete class window
    
 Scenario: Validate accept in alert in class page  
    Given Admin is on delete alert in delete class window
    When Admin clicks "yes" button on Alert in delete class window
    Then Success message and validate particular class details are deleted from the data table 
    
 Scenario: Validate reject in alert in class page 
    Given Admin is on delete alert in delete class window
    When Admin click "no" button on Alert in delete class window
    Then Admin should land on manage class page and validate particular class details are not deleted from the data table
  