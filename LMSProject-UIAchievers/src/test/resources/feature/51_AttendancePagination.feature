 Feature: Pagination in manage attendance
 
 Background: Logged on the LMS portal as Admin and on Add Attendance page
Given: Admin is on login page
When: Admin enters valid credentials and loggedin
Then Admin is in Manage attendance page and licks +Add new Attendance button 




Given Admin is on Dashboard page after Login
 When Admin clicks "Attendance" button on the Navigation bar
 Scenario: Verify sheet one is displayed in attendance on default in data table
 Then Data table should display 1 a page when entries available
 
 Scenario: Verify right arrow is enable when sheet one is displayed in data table
 Then Right arrow should be enabled in page one when of entries are more than 5 available
 
 Scenario: Verify left arrow is disable when sheet one is displayed in data table
 Then Left arrow should be disabled in page one of when entries are more than 5 available
 
 Scenario: Verify right arrow is enable when sheet two is displayed in data table when entries are more than 10
 Then Right arrow should be enabled in page of two when entries are more than 10 available
 
 Scenario: Verify left arrow is enable when sheet two is displayed in data table
 Then Left arrow should be enabled in page two in attendance 
 
 Scenario: Verify right arrow is disable when sheet two is displayed in data table when entries are less than 10
 Then Data table should display  page 1 in attendance when entries available 
 
 Scenario: Verify pagination controls enabled
 Then Entries are more than 5 in attendance data table pagination controls enabled
 
 Scenario: Verify pagination controls disabled
 Then Pagination controls disabled if entries are less than 5 in attendance data table
 

Scenario: Verify next page is enabled
 Given Admin is in add Attendance details popup window
 When Admin creates 6 new Attendance
 Then total Attendance entries above 5 next page is enabled ( On multiples of 5 new page will be enabled)
 
 Scenario: verify next page is disabled
 Given Admin is in add Attendance details popup window
 When Admin creates less than or equal to 5 new Attendance  
 Then total Attendance entries  5 or below next page is disabled
 
 
 
 
 
 