Feature: Add new assignment 
Background:Admin click +Add new assignment button after reaching to manage assignment page
Given Admin is on dashboardpage
And Admin clicks assignment button
When Admin is in Manage assignment page
Then Admin Clicks +Add new assignment button 

Given Admin is in  assignment details popup window
@valid
Scenario: Validate admin able to add new assignment with valid data in mandatory fields
When Admin enters all mandatory field values with "valid data" and clicks save button 
Then Admin should see new assignment details is added in the data table
#( Program name, batch number,Assignment Name, grade by, Assignment due date)

Scenario Outline: Validate admin able to add new assignment with invalid data in mandatory fields
 When The admin enters all mandatory fields "<Program Name>","<batch number>","<Assignment Name>","<grade by>","<Assignment due date>" and clicks save
 Then "<Error message>" should appear in alert 
 Examples:
 |    Program name| batch number   |  Assignment Name | grade by |   Assignment due date   |  Error message  |
 |jan23-hello|00	|hackathon	|admi|11-11-2000|Please enter valid credentials|  

@valid
Scenario: Validate admin able to add new assignment with valid data  in all fields
When Admin enters values in all fields with "all valid data" and clicks save button 
#(Program name, batch number,Assignment Name, Assignment Description, grade by, Assignment due date, Assignment File1, Assignment file 2, Assignment file 3, Assignment file 4, Assignment file 5)
Then Admin should see new assignment details is added in the data table


@invalid
Scenario Outline: Validate admin able to add new assignment with invalid data  in optional fields
When Admin enters with invalid data "<Assignment File1>","<Assignment File2>","<Assignment File3>","<Assignment File4>","<Assignment File5>" in optional fields and clicks save button 
Then "<Error message>" should appear in alert
#(Assignment File1, Assignment file 2, Assignment file 3, Assignment file 4, Assignment file 5)

Examples:
|Assignment File1| Assignment file 2| Assignment file 3| Assignment file 4| Assignment file 5|
|Filesassign1| Assignme2| As3| Assig4| Assi5|

@valid
Scenario: Validate admin able to add new assignment missing program name
When Admin enters "data" missing value in program name and clicks save button 
Then Program Name is missing
#(batch number,Assignment Name, Assignment Description, grade by, Assignment due date, Assignment File1, Assignment file 2, Assignment file 3, Assignment file 4, Assignment file 5)

@valid
Scenario Outline: Validate admin able to add new assignment missing batch number
When Admin enters data "missing value" in Batch number and clicks save button 
#(Program name,Assignment Name, Assignment Description, grade by, Assignment due date, Assignment File1, Assignment file 2, Assignment file 3, Assignment file 4, Assignment file 5)
Then Batch number is missing

@valid
Scenario: Validate admin able to add new assignment missing assignment name
When Admin enters data missing "value" in Assignment name and clicks save button 
Then Assignment name is missing


@valid
Scenario: Validate admin able to add new assignment missing due date
When Admin enters data "missing" value in Assignment due date and clicks save button
 Then Assignment due date is missing
 
@valid
Scenario: Validate admin able to add new assignment missing grade by
When Admin enters "data missing" value in grade by  and clicks save button 
Then Grade by is missing


@valid
Scenario: Validate  admin able to add new assignment passing past date 
When Admin enters passed date in the due date field and clicks save button 
Then Assignment cannot be created for the passed date
@valid
Scenario: Validate date picker
When Admin clicks date from date picker
Then selected date should be their in class date text box
@valid
Scenario: validate date picker should be correct format
When Admin clicks date from date picker
Then selected date should be in  mm/dd/yyyy format
@valid
Scenario: Validate right arrow in data picker to navigate to next month
When Admin clicks right arrow in the date picker near month
Then Next month calender should visible
@valid
Scenario: Validate left arrow in data picker to navigate to previous month
When Admin clicks left arrow in the date picker near month
Then previous month calender should visible
@valid
Scenario: Validate current date is highlighted in the date picker
When Admin clicks date picker button
Then Admin should see current date is highled in the date picker
@valid
Scenario: Validate selected date is highlighted in the date picker
When Admin clicks date picker button and selects future date
Then Admin should see selected date is highled in the date picker
@valid
Scenario: Validate cancel button function in assignment details popup window
When Admin clicks Cancel button without entering values in the fields
Then Admin should land on manage assignment page
@valid
Scenario: Validate cancel button function in assignment details popup window with values in field
When Admin clicks Cancel button entering values in the fields
Then Admin should land on manage assignment Page and validate new assignment is not created in the data table







