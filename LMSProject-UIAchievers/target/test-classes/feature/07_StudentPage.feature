Feature: Sudent Page Verification
Background: Admin is logged in and on the student Details page

@Valid
Scenario: Validate select student name is fading
Given Admin is on student details page
When Admin select student name from the drop down 
Then Admin shouldn't see select student name text 

@Valid
Scenario: Validate select batch id  is fading
Given Admin is on student details page
When Admin select batch id from the drop down 
Then Admin shouldn't see select batch id text 

@Valid
Scenario: Validate select student name using search box
Given Admin is on student details page
When Admin clicks select student name and  enters x alphabet in the search box 
Then Admin should see student name start with x is listed below

@Valid
Scenario: Validate select batch id using search box
Given Admin is on student details page
When Admin  clicks select batch id and enter x number in the search box 
Then Admin should see batch id start with x is listed below

@Invalid
Scenario: Validate selecting only  student name  will not display any details
Given Admin is on student details page
When Admin selects only student name
Then Student details shouldn't be displayed

@Invalid
Scenario: Validate selecting only  batch id  will not display any details
Given Admin is on student details page
When Admin selects only  batch id
Then batchid details shouldn't be displayed

@Valid
Scenario: Validate selecting student name and batch id
Given Admin is on student details page
When Admin selects  student name and batch id
Then Particular student informations should be display

