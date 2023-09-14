 Feature: Class detail Popup window verification
@valid
  Scenario: Verify class details popup window
    Given Admin is on Manage Class Page to validate class detail
    When Admin Click +Add New Class button 
    Then Admin should see a popup with heading class details
@valid
  Scenario: Verify input fields in class details popup window
    Given Admin is on Manage Class Page to validate class detail
    When Admin Click +Add New class button1
    Then Admin should see input fields Text (Batch ID , No of Classes, Class Date, Class Topic, Staff Id, Class description, Comments, Notes, Recordings)
@valid
  Scenario: Verify text box present in class details popup window
    Given Admin is on Manage Class Page to validate class detail
    When Admin Click +Add New Class button
    Then 6 textbox should be present in Class details popup window
@valid
  Scenario: Verify drop down in Batch Id in class details popup window
    Given Admin is on Manage Class Page to validate class detail
    When Admin Click +Add New Class button
    Then Admin should see Dropdown option for Batch ID in class details popup window
@valid
  Scenario: Verify drop down in Staff Id in class details popup window
    Given Admin is on Manage Class Page to validate class detail
    When Admin Click +Add New Class button
    Then Admin should see Dropdown option for Staff Id in class details popup window
@valid
  Scenario: Verify calendar icon in class date in class details popup window
    Given Admin is on Manage Class Page to validate class detail
    When Admin Click +Add New Class button
    Then Admin should see Calendar icon for class date in class details popup window
@valid
  Scenario: Verify save button is present in class details popup window
    Given Admin is on Manage Class Page to validate class detail
    When Admin Click +Add New Class button
    Then Admin should see "Save" button in the class detail Popup window
@valid
  Scenario: Verify cancel button is present in class details popup window
    Given Admin is on Manage Class Page to validate class detail
    When Admin Click +Add New Class button
    Then Admin should see "Cancel" button in the class detail popup window1
@valid
  Scenario: Verify close button in class details popup window
    Given Admin is on Manage Class Page to validate class detail
    When Admin Click +Add New Class button
    Then Admin should see Close button on the class details popup window
 