#Author: Gayathri
Feature: Manage Program Validation
Background: Logged on the LMS portal as Admin

		Given Admin users launch the browser.
    When Admin users gives the correct LMS portal URL.
    Then Admin users should land on the dashboard page.
    
  Scenario: Validate landing in Program page
    Given Admin users is on dashboard page after Login page.
    When Admin users clicks Program on the navigation bar.
    Then Admin users should see URL with "Manage Program".

  Scenario: Validate the heading in program page
  
  
    Then Admin users should see a heading with text "Manage Program" on the page.

  Scenario: Validate the text and pagination icon below the data table in program page
    Then Admin users should see the text as "Showing x to y of z entries" along with Pagination icon below the table. 

  Scenario: Validate the text and pagination icon below the data table in program page
    Then Admin users should see the footer as "In total there are z programs".

  Scenario: Validate the text and pagination icon below the data table in program page
    Then Admin users should see a Delete button on the top left hand side as Disabled.

  Scenario: Validate the text and pagination icon below the data table in program page
    Then Admin users should see a "+A New Program" button on the program page above the data table.

  Scenario: Validate that number of records (rows of data in the table) displayed in program page
    Then Admin users should see the number of records (rows of data in the table) displayed on the page are 5.

  Scenario: Verify data table on the Program page
    Then Admin users should see data table on the Manage Program Page with following column headers 'Program'.

  Scenario: Verify Sort arrow icon on the data table in program page
    Then Admin users should see the sort arrow icon beside to each column header except Edit and Delete.

  Scenario: Verify Check box on the data table in program page
    Then Admin users should see check box on the left side in all rows of the data table.

  Scenario: Verify Edit and Delete buttons in program page
    Then Admin users should see the Edit and Delete buttons on each row of the data table.

  Scenario: Verify Search bar on the Program page
    Then Admin users should see Search bar with text as "Search...".
