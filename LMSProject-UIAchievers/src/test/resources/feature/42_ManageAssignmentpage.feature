Feature: Manage assignment page Verification

  Background: Logged on the LMS portal as Admin
    Given Admin is on login page
    When Enter valid credentials "Admin""admin123"
    Then successfully logged in LMSportal
@valid
  Scenario: Verify landing in manage assignment page
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Admin should see URL with "Manage assignment"
@valid
  Scenario: Capture the response time to navigate to manage assignment page
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Get the response time for navigation from dashboard page to manage assignment page
@valid
  Scenario: Verify manage assignment page Header
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Admin should see header with "Manage assignment"
@valid
  Scenario: Validate text in manage assignment page
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar and get all text from the portal page
    Then Admin should see correct spelling for the all the fields
@valid
  Scenario: Verify delete icon below the header
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Admin should see disabled delete icon below the "Manage assignment"
@valid
  Scenario: Verify search bar on the manage assignment page
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Admin should see search bar on the manage assignment page
@valid
  Scenario: Verify add new assignment button  on manage assignment page
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Admin should see +Add New assignment button on the manage assignment page
@valid
  Scenario: Verify data table on the manage assignment page
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Admin should see data table on the manage "assignment" page With following column headers
@valid
  Scenario: Verify Edit icon in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Edit Icon in each row of data table only  when entries are available
@valid
  Scenario: Verify Edit icon when no data in the table
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Edit Icon will not be present in data table
@valid
  Scenario: Verify delete icon in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Delete Icon in each row of data table only  when entries are available
@valid
  Scenario: Verify delete icon when no data in the table
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Delete Icon will not be present in data table
@valid
  Scenario: Verify sort icon in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Admin should see sort icon near the column headers except for Edit and Delete
@valid
  Scenario: Verify check box in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Admin should see check box in the all rows  of data table when entries available
@valid
  Scenario: Validate the number entries displaying
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Above the footer Admin should see the text as "Showing x to y of z entries"
@valid
  Scenario: Verify Pagination control below the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Admin should see the pagination controls under the data table
@valid
  Scenario: Validate footer  text
    Given Admin is on dashboard page after Login
    When Admin clicks "assignment" button on the navigation bar
    Then Admin should see the text with total number assignments in the data table.

  # ( " In total there are number of assignments")
  #-----------------------------------------
  @valid
  Scenario: Validate search box function
    Given Admin is on manage assignment page
    When Admin enters assignment name into search box
    Then Displays entries with that assignment name

  @invalid
  Scenario: Validate search box function
    Given Admin is on manage assignment page
    When Admin enters assignment  name is not existing the table into search box
    Then Displays empty details in the data table
@valid
  Scenario: Validating search box function
    Given Admin is on manage assignment page
    When Admin enters assignment description into search box
    Then Displays entries with that assignment description
@valid
  Scenario: Validate the search box function
    Given Admin is on manage assignment page
    When Admin enters assignment description which is not existing the table into search box
    Then Displays empty details in the data table
@valid
  Scenario: Validate entries with  search box function
    Given Admin is on manage assignment page
    When Admin enters assignment due date into search box
    Then Displays entries with that assignment due date

  @invalid
  Scenario: Validate invalidentries with  search box function
    Given Admin is on manage assignment page
    When Admin enters assignment due date which is not existing the table into search box
    Then Displays empty details in the data table
@valid
  Scenario: Validate the entriy with  search box function
    Given Admin is on manage assignment page
    When Admin enters grade value  into search box
    Then Displays entries with that assignment  grade
@valid
  Scenario: Validate invalidentries in search box function
    Given Admin is on manage assignment page
    When Admin enters grade value which is not existing the table into search box
    Then Displays empty details in the data table

  #----------------------ASSIGNEMNT POP UP WINDOW
  @valid
  Scenario: Verify Assignment details popup window
    Given Admin is on manage assignment page
    When Admin click +Add new assignment button
    Then Admin should see a popup  with  heading "Assignment details"
@valid
  Scenario Outline: Verify input fields in Assignment details popup window
    Given Admin is on manage assignment page
    When Admin click +Add new assignment button
    Then Admin should see input "fields Text"

    Examples: 
      | fields Text            |
      | Program name           |
      | batch number           |
      | Assignment Name        |
      | Assignment Description |
      | grade by               |
      | Assignment due date    |
      | Assignment File1       |
      | Assignment file 2      |
      | Assignment file 3      |
      | Assignment file 4      |
      | Assignment file 5      |
@valid
  Scenario: Verify text box present in Assignment details popup window
    Given Admin is on manage assignment page
    When Admin click +Add new assignment button
    Then 8 textbox should be  present in Assignment details popup window
@valid
  Scenario: Verify drop down in Batch Number  in Assignment details popup window
    Given Admin is on manage assignment page
    When Admin click +Add new assignment button
    Then Admin should see  dropdown option for Batch Number
@valid
  Scenario: Verify drop down in Program name  in Assignment details popup window
    Given Admin is on manage assignment page
    When Admin click +Add new assignment button
    Then Admin should see  dropdown option for Program name
@valid
  Scenario: Verify calendar icon in Assignment due date  in Assignment details popup window
    Given Admin is on manage assignment page
    When Admin click +Add new assignment button
    Then Admin should see  calendar icon for assignment due date
@valid
  Scenario: Verify save button is present
    Given Admin is on manage assignment page
    When Admin click +Add new assignment button
    Then Admin should see  save button in the Assignment detail popup window
@valid
  Scenario: Verify cancel button is present
    Given Admin is on manage assignment page
    When Admin click +Add new assignment button
    Then Admin should see  cancel button in the Assignment detail popup window
@valid
  Scenario: Verify close button in  Assignment details popup window
    Given Admin is on manage assignment page
    When Admin click +Add new assignment button
    Then Admin should see  close button on the Assignment details popup windows
