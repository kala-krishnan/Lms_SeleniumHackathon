 Feature: Pagination in manage assignment
 
 Background: Logged on the LMS portal as Admin
Given: Admin is on login page
When: Admin enters valid credentials
Then Admin logged on LMS portal

Given Admin is on Dashboard page after Login
 When Admin clicks "Assignment" button on the Navigation bar
 Scenario: Verify sheet one is displayed on default in data table
 Then Data table should display 1 page  of assignment when entries available
 
 Scenario: Verify right arrow is enable when sheet one is displayed in data table
 Then Right arrow should be enabled in page one when of page entries are more than 5 available
 
 Scenario: Verify left arrow is disable when sheet one is displayed in data table
 Then Left arrow should be disabled in assign page one when entries are more than 5 available
 
 Scenario: Verify right arrow is enable when sheet two is displayed in data table when entries are more than 10
 Then Right arrow should be enabled in assignment page two when entries are more than 10 available
 
 Scenario: Verify left arrow is enable when sheet two is displayed in data table
 Then Left arrow should be enabled in adminassign page two 
 
 Scenario: Verify right arrow is disable when sheet two is displayed in data table when entries are less than 10
 Then Data table should display  page 1 when of assignment entries available 
 
 Scenario: Verify pagination controls enabled
 Then Entries are more than 5 in data table pagination assignment controls enabled
 
 Scenario: Verify pagination controls disabled
 Then Pagination controls disabled if entries are less than 5 in data table asssignment
 
 
 
 
 
 
 