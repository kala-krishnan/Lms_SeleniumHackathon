 Feature: Edit class Validation

  Scenario: Verify Edit class popup window in manage class window
    Given Admin is in Manage Class page to validate edit class  window
    When Admin clicks Edit button in data table in manage class window
    Then Edit popup window appears with Heading Class Details

  Scenario: Verify values in popup window in Edit class window
    Given Admin is in Manage Class page to validate Edit class  window1
    When Admin clicks Edit button from one of the row in data table in manage class window
    Then Edit popup window appears with same row values in the all fields in manage class window

  Scenario: Validate admin able to update class with valid data in mandatory fields
    Given Admin is in Edit class detail popup window in Edit class window
    When Admin enters all mandatory field values with valid data and clicks save button( Batch ID , No of Classes, Class Date, Staff Id)
    | Batch Id | No of Classes | Class date | Staff Id |
      |     1352 |         3 | 07/25/2021 | U17      |
    
    Then Admin should see particular class details is updated in the data table

  Scenario: Validate admin able to  update class with invalid data in mandatory fields
    Given Admin is in Edit class detail popup window in Edit class window
    When Admin enters all mandatory field values with invalid data and clicks save button( Batch ID , No of Classes, Class Date, Staff Id) in Edit class window
     | Batch Id | No of Classes | Class date | Staff Id |
      | 27y8    |         five  | 02/20/2020 | 8ah      |
    
    Then Error message should appear in alert in manage class window

  Scenario: Validate admin able to update class with valid data  in all fields in Edit class window
    Given Admin is in Edit class detail popup in Edit class window
    When Admin enters values in all fields with valid data and clicks save button(Batch ID , No of Classes, Class Date, Class Topic, Staff Id, Class description, Comments, Notes, Recordings) in Edit class window
     | Batch Id | No of Classes | Class date | Staff Id | Class descirption| Comments | Notes |Recordings |
      | 2121    |             3 | 09/19/2022 | U06      | Advanced SQL     |   No   | C:\pr\Notes|C:\pr\Reocordings|
    
    Then Admin should see particular class details is updated in the data table

  Scenario: Validate admin able to  update  class with invalid data  in all fields
    Given Admin is in Edit class detail popup in Edit class window
    When Admin enters with invalid data in optional fields and clicks save button( Batch ID , No of Classes, Class Date, Staff Id) in Edit class window
    | Class description | Comments | Notes     | Recordings           |
    | CoreJava2.0  | Yes      | NA      |     NA |
    
    Then Error message should appear in alert in manage class window

  Scenario: Validate admin able to update class missing Batch Id  
    Given Admin is in Edit class detail popup in manage class window
    When Admin enters data missing value in Batch ID and clicks save button(No of Classes, Class Date, Staff Id) in manage class window
     | No of Classes | Class Date | Staff ID |
     |             3 | 09/19/2022 | U06      |
    
    Then BatchId is missing in manage class window

  Scenario: Validate admin able to update  class missing No of Class
    Given Admin is in Edit class detail popup in Edit class window
    When Admin enters data missing value in No of class and clicks save button(Batch ID , Class Date, Staff Id) in Edit class window
    | Batch Id | Class Date | Staff ID |
     | 2121    |  09/19/2022 | U06      |
    Then Noofclasses is missing in manage class window

  Scenario: Validate admin able to update class missing Class Date
    Given Admin is in Edit class detail popup in Edit class window
    When Admin enters data missing value in class date and clicks save button(Batch ID , No of Classes, Staff Id) in manage class window
        | Batch Id | No of Classes | Staff ID |
       | 2121    |     3 |  U06      |
    Then classdate is missing in manage class window

  Scenario: Validate admin able to update class missing staff id
    Given Admin is in Edit class detail popup in Edit class window
    When Admin enters data missing value in staff id and clicks save button (Batch ID , No of Classes, Class Date) in manage class window
    | Batch ID | No of Classes | Class Date |
    | 2121    |             3 | 09/19/2022 | 
    Then staffid is missing in manage class window

  Scenario: Validate  admin able to update class passing past date
    Given Admin is in Edit class detail popup in Edit class window
    When Admin enters passed date in the class date field and clicks save button( Batch ID , No of Classes, Class Date, Staff Id) in manage class window
    | Batch ID | No of Classes | Class Date | StaffID |
    |     126 |             2 | 08/19/2005 | U29     |
    
    Then class cannot be updated for the passed date in manage class window

  Scenario: Validate cancel button function in Edit class details popup window
    Given Admin is in Edit class detail popup in manage class window 
    When Admin clicks "Cancel" button without entering values in the fields in Edit class window
    Then Admin should land on Manage Class page to validate edit class

  Scenario: Validate cancel button function in Edit class details popup window with values in field
    Given Admin is in Edit class detail popup in manage class window
    When Admin clicks "Cancel" button entering values in the fields in Edit class window
    Then Admin should land on Manage Class Page and validate particular class details are not changed  in the data table
 