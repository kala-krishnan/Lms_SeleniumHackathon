Feature: Edit Assignment with all validations

Background: Admin clicks Edit button in manage assignment after reaching manage assignment page
Given Admin is on dashboard page clicks
When Admin clicks on assignment button 
Then Admin is on assignment page and clicks edit button

@valid
Scenario: Validate admin able to update assignment with valid data in mandatory fields
Given Admin is in  Edit assignment detail popup window
When Admin enters all mandatory field values with valid data and clicks save button 
Then Admin should see updated assignment details is added in the data table
@invalid
Scenario Outline: Validate admin able to update assignment with invalid data in mandatory fields
Given Admin is in  Edit assignment detail popup window
When The admin enters all mandatory fields "<Program Name>","<batch number>","<Assignment Name>","<grade by>","<Assignment due date>" and clicks save
 Then "<Error message>" should appear in alert 
 
 Examples:
 
 |  Program name| batch number   |  Assignment Name | grade by |   Assignment due date   |  Error message  |
 |jan23-hello|00	|hackathon	|admi|11-11-2000|Please enter valid credentials|  
@valid
Scenario: Validate admin able to update assignment with valid data  in all fields
Given Admin is in  Edit assignment detail popup window
When Admin enters values in all fields with "all valid data" and clicks save button 
#(Program name, batch number,Assignment Name, Assignment Description, grade by, Assignment due date, Assignment File1, Assignment file 2, Assignment file 3, Assignment file 4, Assignment file 5)
Then Admin should see new assignment details is added in the data table
@invalid
Scenario Outline: Validate admin able to update assignment with invalid data  in optional fields
Given Admin is in  Edit assignment detail popup window
When Admin enters with invalid data "<Assignment File1>","<Assignment File2>","<Assignment File3>","<Assignment File4>","<Assignment File5>" in optional fields and clicks save button 
Then "<Error message>" should appear in alert
#(Assignment File1, Assignment file 2, Assignment file 3, Assignment file 4, Assignment file 5)

Examples:
|Assignment File1| Assignment file 2| Assignment file 3| Assignment file 4| Assignment file 5|
|Filesassign1| Assignme2| As3| Assig4| Assi5|
@valid
Scenario: Validate admin able to update assignment missing program name
Given Admin is in  Edit assignment detail popup window
When Admin enters "data" missing value in program name and clicks save button 
Then Program Name is missing
@valid
Scenario: Validate admin able to update assignment missing batch number
Given Admin is in  Edit assignment detail popup window
When Admin enters data "missing value" in Batch number and clicks save button 
#(Program name,Assignment Name, Assignment Description, grade by, Assignment due date, Assignment File1, Assignment file 2, Assignment file 3, Assignment file 4, Assignment file 5)
Then Batch number is missing
@valid
Scenario: Validate admin able to update assignment missing assignment name
When Admin enters data missing "value" in Assignment name and clicks save button 
Then Assignment name is missing
@valid
Scenario: Validate admin able to update assignment missing due date
When Admin enters data "missing" value in Assignment due date and clicks save button
 Then Assignment due date is missing
@valid
Scenario: Validate admin able to update assignment missing grade by
When Admin enters "data missing" value in grade by  and clicks save button 
Then Grade by is missing

@valid
Scenario: Validate  admin able to update assignment passing past date 
When Admin enters passed date in the due date field and clicks save button 
Then Assignment cannot be updated for the passed date
@valid
Scenario: Validate cancel button function in assignment details popup window
When Admin clicks Cancel button without entering values in the fields
Then Admin should land on manage assignment page
@valid
Scenario: Validate cancel button function in assignment details popup window with values in field
When Admin clicks Cancel button entering values in the fields
Then Admin should land on manage assignment Page and validate new assignment is not created in the data table
@valid
Scenario: Verify Edit assignment popup window
Given Admin is in manage assignment page
When Admin clicks Edit button in data table 
Then Edit popup window appears with heading Assignment Details
@valid
Scenario: Verify values in popup window
Given Admin is in manage assignment page
When Admin clicks Edit button from one of the row in data table 
Then Edit popup window appears with same row values in the all fields








