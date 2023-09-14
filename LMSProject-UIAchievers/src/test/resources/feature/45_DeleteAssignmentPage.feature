Feature:Manage assignment page Verification
Background:Logged on the LMS portal as Admin
Given Admin is on login page
When Enter valid credentials "Admin""admin123"
Given Admin is in manage assignment page
Scenario: Verify Delete Assignment alert
When Admin clicks delete button in data table "row level"
Then Admin should see dialog box
Scenario: Verify  accept enabled in alert
When Admin clicks delete button in data table "row level"
Then Alert should have "yes" button to accept
Scenario: Verify reject enabled in alert
When Admin clicks delete button in data table "row level"
Then Alert should have "No" button to reject
Scenario: Validate accept in alert
When Admin clicks "yes" button
Then Redirected to assignment page and selected assignment details are "deleted" from the data table
Scenario: Validate reject in alert
When Admin clicks "no" button
Then Redirected to assignment page and selected assignment details are "not deleted" from the data table (edited) 

Scenario: Verify delete multiple class  button is enabled
When Admin clicks single  row level check box in the data table
Then Admin should see delete icon below the header is enabled
Scenario: Verify accept alert in delete multiple class function by selecting single checkbox
Given Admin is in delete alert
When Admin clicks "yes" button
Then Redirected to assignment page and selected assignment details are "deleted" from the data table
Scenario: Validate reject in alert
Given Admin is in delete alert
When Admin clicks "no" button
Then Redirected to assignment page and selected assignment details are "not deleted" from the data table
Scenario: Verify accept alert in delete multiple class function by selecting multiple checkbox
Given Admin is in delete alert
When Admin clicks "yes" button
Then Redirected to assignment page and selected assignment details are "deleted" from the data table
Scenario: Verify reject alert in delete multiple class function by selecting multiple checkbox
Given Admin is in delete alert
When Admin clicks "no" button
Then Redirected to assignment page and selected assignment details are "not deleted" from the data table