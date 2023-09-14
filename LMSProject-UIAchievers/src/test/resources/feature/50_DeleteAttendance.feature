Feature: Delete attendance validation
Background: Admin logged into LMS portal and clicks attendance button on the navigation bar 
#Admin clicks row level delete button after landing to manage attendance page
Given Admin is on login page
When Enter valid credentials "Admin""admin123"
Given Admin is in manage attendance page
@Valid
Scenario: Verify Delete attendance alert
Given Admin is in manage attendance page
When Admin clicks delete button in data table row level
Then Admin should see alert
@Valid 
Scenario: Verify  accept enabled in alert
Given Admin is in manage attendance page
When Admin clicks delete button in data table row level
Then Alert should have "yes" button to accept 
@Valid
Scenario: Verify reject enabled in alert
Given Admin is in manage attendance page
When Admin clicks delete button in data table row level
Then Alert should have "No" button to reject

@Valid
Scenario: Validate accept in alert
Given Admin is in delete alert
When Admin clicks yes button
Then Success message and selected attendance details are deleted from the data table

@Valid
Scenario: Validate reject in alert
Given Admin is in delete alert
When Admin clicks no button
Then Redirected attendance page and selected attendance details are not deleted from the data table

@Valid 
Scenario: Verify delete multiple class  button is enabled
Given Admin is in manage attendance page
When Admin clicks single  row level check box in the data table
Then Admin should see delete icon below the header is enabled

@Valid
Scenario: verify tick mark is visible after clicking on check box for single data
Given Admin is in manage attendance page
When Admin clicks single  row level check box in the data table
Then Admin should see tick mark in check box 

@Valid
Scenario: verify admin able to click multiple check box
Given Admin is in manage attendance page
When Admin clicks multiple row level check box in the data table
Then Admin should see tick mark in check box  of the selected rows

@Valid
Scenario: Verify accept alert in delete multiple attendance by selecting single checkbox
Given Admin is in delete alert
When Admin clicks yes button
Then Success message and selected attendance detail are deleted from the data table

@Valid
Scenario: Verify reject alert in delete multiple attendance by selecting multiple checkbox
Given Admin is in delete alert
When Admin clicks no button
Then Redirected to attendance page and selected attendance details are not deleted from the data table


@Valid
Scenario: Verify accept alert in delete multiple attendance by selecting multiple checkbox
Given Admin is in delete alert
When Admin clicks yes button
Then Success message and validate particular attendance details are deleted from the data table

@Valid
Scenario: Verify reject alert in delete multiple attendance by selecting multiple checkbox
Given Admin is in delete alert
When Admin clicks no button
Then Redirected to attendance page and selected attendance details are not deleted from the data table	
