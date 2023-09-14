 Feature: Admin Manage class page verification

  
 
  Scenario: Verify landing in class page in lms portal
    Given Admin is on dashboard page after Login for Manage class
    When Admin clicks manage Class button on the navigation bar  
    Then Admin should see URL with "Manage Class"
 
  Scenario: Capture the response time to navigate to Manage class page
     
    When Admin clicks Class button on the navigation bar  from dashboard
    Then Get the response time for navigation from dashboard page to Manage class page
 
  Scenario: Verify Manage Class Page Header to check Class page
    Given Admin is on dashboard page after Login for Manage class
    When Admin clicks Class button on the navigation bar 
    Then Admin should see header with "Manage Class"  
 
  Scenario: Validate text in Manage Class page 
    Given Admin is on dashboard page after Login for Manage class
    When Admin clicks Class button on the navigation bar and get all text from the portal page
    Then Admin should see correct spelling for the all the fields
 
  Scenario: Verify delete icon below the header in Manage class Page
    Given Admin is on dashboard page after Login for Manage class
    When Admin clicks Class button on the navigation bar 
    Then Admin should see disabled delete icon below the "Manage Class"
 
  Scenario: Verify checking search bar on the class page 
    Given Admin is on dashboard page after Login for Manage class
    When Admin clicks Class button on the navigation bar 
    Then Admin should see search bar on the class page
 
  Scenario: Verify add new class button  on class page
    Given Admin is on dashboard page after Login for Manage class
    When Admin clicks Class button on the navigation bar
    Then Admin should see +Add New Class button on the class page
 
  Scenario: Verify data table on the class page
    Given Admin is on dashboard page after Login for Manage class
    When Admin clicks Class button on the navigation bar  
    Then Admin should see data table on the Manage Class Page With column headers.
 
  Scenario: Verify Edit icon in the data table on class page
    Given Admin is on dashboard page after Login for Manage class
    When Admin clicks Class button on the navigation bar
    Then Edit Icon in each row of data table only when entries are available
 
  Scenario: Verify Edit icon when no data in the table on class apge
    Given Admin is on dashboard page after Login for Manage class
    When Admin clicks Class button on the navigation bar
    Then Edit Icon will not be present in data table
 
  Scenario: Verify delete icon in the data table on class page
    Given Admin is on dashboard page after Login for Manage class
    When Admin clicks Class button on the navigation bar 
    Then Delete Icon in each row of data table only  when entries are available
 
  Scenario: Verify delete icon when no data in the table on class page
    Given Admin is on dashboard page after Login for Manage class
    When Admin clicks Class button on the navigation bar
    Then Admin cant see delete Icon in data table in manage class page
 
  Scenario: Verify sort icon in the data table on class page
    Given Admin is on dashboard page after Login for Manage class
    When Admin clicks Class button on the navigation bar
    Then Admin should see sort icon near the column headers except for Edit and Delete in manage class page
 
  Scenario: Verify check box in the data table on class page
    Given Admin is on dashboard page after Login for Manage class
    When Admin clicks Class button on the navigation bar  
    Then Admin should see check box in the all rows  of data table on class page in manage class page
 
  Scenario: Validate the number entries displaying on class page
    Given Admin is on dashboard page after Login for Manage class
    When Admin clicks Class button on the navigation bar
    Then Admin should see the text as "Showing x to y of z entries" below the table in manage class page
 
  Scenario: Verify Pagination control below the data table on class apge
    Given Admin is on dashboard page after Login for Manage class
    When Admin clicks Class button on the navigation bar
    Then Admin should see the pagination controls under the data table in manage class page
 
  Scenario: Validate footer  text on manage class page
    Given Admin is on dashboard page after Login for Manage class
    When Admin clicks Class button on the navigation bar
    Then Admin should see the text with total number classes in the data table( " In total there are number of classes")

 
  Scenario: Validate search box function in class page
     
    Given Admin is on Manage Class Page
    When Admin enters batch id into search box "Batch Id" in manage class page
    Then Displays entries with that batch Id in class page
     
    When Admin enters batch id which is not existing the table into search box "Batch Id" in manage class page   
    Then Displays empty details in the data table in manage class page
    
      
    When Admin enters "class no" into search box in manage Class page 
    Then Displays entries with that class no in manage class page
    
    When Admin enters "class no" which is not existing the table into search box in manage class page <integer>  
    Then Displays empty details in the data table in manage class page
     
    When Admin enters class topic into search box "Class Topic" in manage class page     
    Then Displays entries with that  class topic in manage class page
     
    When Admin enters class topic which is not existing the table into search box "Class Topic" in manage class page     
    Then Displays empty details in the data table in manage class page
     
    When Admin enters staff id into search box "Staff Id" in manage class page    
    Then Displays entries with that  staff id in manage class page
     
    When Admin enters staff id which is not existing the table into search box "Staff Id" in manage class page    
    Then Displays empty details in the data table in manage class page
     
    When Admin enters class date into search box "Class Date" in manage class page       
    Then Displays entries with that  class date in manage class page
   
    When Admin enters invalid class date into search box "Class Date" in manage class page      
    Then Displays empty details in the data table in manage class page
  