Feature: Adding new Class

  Background: Admin logged into LMS portal and clicks class button on the navigation bar
@valid
  Scenario: Validate all Batch ID is reflecting in the dropdown in class page
    Given Admin is in class detail popup window for adding new class
    When Admin clicks Batch ID dropdown in add new class page
    Then Batch ID in the drop down should match with Batch ID manage class page table
@valid
  Scenario: Admin fills mandatory fields with valid data to add new class
    Given Admin is in class detail popup window for adding new class
    When Admin enters all mandatory field values with valid data and clicks save button "Batch ID" , "No of Classes", "Class Date","Staff Id" in add new class page
    | Batch Id | No of Classes | Class date | Staff Id |
      |     2123 |             6 | 09/19/2021 | U12      |
    Then Admin should see new class detail is added in the data table    
 @invalid
  Scenario: Validate admin able to add new class with invalid data in mandatory fields
    Given Admin is in class detail popup window for adding new class
    When Admin enters all mandatory field values with invalid data and clicks save button "Batch ID" , "No of Classes", "Class Date","Staff Id" in add new class page
    
      | Batch Id | No of Classes | Class date | Staff Id |
      | 212Br    |             6 | 09/19/2021 | Uir      |
      Then Error message should appear for adding new class
@valid
  Scenario: Validate admin able to add new class with valid data  in all fields
    Given Admin is in class detail popup window for adding new class
    When Admin enters values in all fields with valid data and clicks save button  "Batch ID" , "No of Classes", "Class Date","Staff Id", "Class description", "Comments", "Notes", "Recordings" from given "<SheetName>" and <rownumber> in add new class page
    Then Admin get success message for adding new class
@invalid
  Scenario: Validate admin able to add new class with invalid data  in optional fields
    Given Admin is in class detail popup window for adding new class
    When Admin enters with invalid data in optional fields and clicks save button  "Class description", "Comments", "Notes", "Recordings" in add new class page
      | Class description | Comments | Notes     | Recordings           |
      | Advanced Python   | Yes      | C:\\Notes | C:\\Recordings\\data |
    Then Error message should appear as "Invalid data" for adding new class
@invalid
  Scenario: Validate admin able to add new class missing Batch Id
    Given Admin is in class detail popup window for adding new class
    When Admin enters data missing value in Batch ID and clicks save button "No of Classes", "Class Date","Staff Id" in add new class page
      | No of Classes | Class Date | Staff ID |
      |             3 | 08/19/2021 | U29      |
    Then Error message should appear as "Batch ID is missing" for adding new class
@invalid
  Scenario: Validate admin able to add new class missing No of Class
    
    When Admin enters data missing value in No of classes and clicks save button "Batch ID", "Class Date","Staff Id" in add new class page
      | Batch Id | Class Date | Staff ID |
      |     1256 | 08/19/2021 | U20      |
    Then Error message should appear as "No of Classes is missing" for adding new class
@invalid
  Scenario: Validate admin able to add new class missing Class Date
    Given Admin is in class detail popup window for adding new class
    When Admin enters data missing value in class date and clicks save button "Batch ID","No of Classes", "Staff Id" in add new class page
      | Batch Id | No of Classes | Staff ID |
      |     2763 |             4 | U89      |
    Then Error message should appear as "Class date" for adding new class
@invalid
  Scenario: Validate admin able to add new class missing staff id
    
    When Admin enters data missing value in Staff Id and clicks save button "Batch ID","No of Classes","Class Date" in add new class page
      | Batch ID | No of Classes | Class Date |
      |     1365 |             3 | 08/19/2021 |
    Then Error message should appear as "Staff Id is missing" for adding new class
@invalid
  Scenario: Validate admin able to add new class passing past date
    Given Admin is in class detail popup window for adding new class
    When Admin enters passed date in the class date field and clicks save button "Batch ID" , "No of Classes", "Class Date","Staff Id" in add new class page
      | Batch ID | No of Classes | Class Date | StaffID |
      |     1231 |             6 | 08/19/2005 | U29     |
    Then class cannot be created for the passed date for adding new class
@valid
  Scenario: Validate date picker
    Given Admin is in class detail popup window for adding new class
    When Admin clicks Class date from date picker in add new class page
    Then Selected date should be their in Class date text box with mm/dd/yyyy format
@valid
  Scenario: Validate right arrow in data picker to navigate to next month
    Given Admin is in class detail popup window for adding new class
    When Admin clicks Right arrow in the date picker near month in add new class page
    Then Next month Calender should visible for adding new class
@valid
  Scenario: Validate left arrow in data picker to navigate to previous month
    Given Admin is in class detail popup window for adding new class
    When Admin clicks Left arrow in the date picker near month in add new class page
    Then Previous month calender should visible for adding new class
@valid
  Scenario: Validate current date is highlighted in the date picker
    Given Admin is in class detail popup window for adding new class
    When Admin clicks Date picker button in add new class page
    Then Admin should see current date is highlighted in the date picker for adding new class
@valid
  Scenario: Validate selected date is highlighted in the date picker
    Given Admin is in class detail popup window for adding new class
    When Admin clicks Date picker button and selects future date in add new class page
    Then Admin should see selected date is highlighted in the date picker for adding new class
@invalid
  Scenario: Validate cancel button function in class details popup window
    Given Admin is in class detail popup window for adding new class
    When Admin clicks cancel button without entering values in the fields "cancel" in add new class page
    Then Admin should land on Manage Class Page for adding new class
@invalid
  Scenario: Validate cancel button function in class details popup window with values in field
    Given Admin is in class detail popup window for adding new class
    When Admin clicks cancel button entering values in the fields "cancel" in add new class page
    Then Admin should land on Manage Class Page and validate new Class is not created in the data table
