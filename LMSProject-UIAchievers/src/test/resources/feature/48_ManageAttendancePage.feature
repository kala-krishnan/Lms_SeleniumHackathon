Feature: Manage Attendance Page verification and pop up window

  Background: Logged on the LMS portal as Admin
    Given Admin is on login page
    When Enter valid credentials "Admin""admin123"
    Then successfully logged in LMSportal
    And click attendance navigation button
    Then Admin is in manage attendance page.

  @Valid
  Scenario: Validate the header of the page
    Given Admin is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see the Manage attendance in header

  @Valid
  Scenario: Validate response time from dashboard page to attendance page
    Given Admin is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Maximum navigation time in milliseconds, defaults to 30 seconds

  @Valid
  Scenario: Validate the broken link
    Given Admin is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then HTTP response >= 400. Then the link is broken

  @Valid
  Scenario: Verify LMS title
    Given Admin is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see LMS -Learning management system  as title

  @Valid
  Scenario: Verify the alignment of the Manage Attendance header
    Given Admin is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Manage attendance header should be in left side of the page

  @Valid
  Scenario: Validate text in manage attendancepage
    Given Admin is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see correct spelling for the all the fields

  @Valid
  Scenario: Verify delete icon below the header
    Given Admin is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see disabled delete icon below the "Manage Attendance"

  @Valid
  Scenario: Verify search bar on the class page
    Given Admin is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see search bar on the attendance page

  @Valid
  Scenario: Verify add new Attendance button  on Attendance page
    Given Admin is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see +Add New Attendance button on the attendance page

  @Valid
  Scenario: Verify data table on the attendance page
    Given Admin is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see data table on the Manage Attendance Page With following column headers. 
  @Valid
  Scenario: Verify Edit icon in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Edit Icon in each row of data table only  when entries are available

  @Valid
  Scenario: Verify Edit icon when no data in the table
    Given Admin is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Edit Icon will not be present in data table

  @Valid
  Scenario: Verify delete icon in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Delete Icon in each row of data table only  when entries are available

  @Valid
  Scenario: Verify delete icon when no data in the table
    Given Admin is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Admin cant see delete  Icon in data table

  @Valid
  Scenario: Verify sort icon in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see sort icon near the column headers except for Edit and Delete

  @Valid
  Scenario: Verify check box in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see check box in the all rows  of data table

  @Valid
  Scenario: Validate the number entries displaying
    Given Admin is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Above the footer Admin should see the text as "Showing x to y of z entries" below the table

  #x- starting record number on that page
  #y-ending record number on that page
  #z-Total number of records  Note: with or without entries
  @Valid
  Scenario: Verify Pagination control below the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see the pagination controls under the data table

  @Valid
  Scenario: Validate footer  text
    Given Admin is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see the text with total number classes in the data table. 

#-----------------Attendance Detail Pop Up verification-----------------

 


   Scenario: Verify all label text  
    Given Admin now on manage attendance page
    When Admin clicks + a new attendance button
    Then Admin should see correct spellings in the label
    
   Scenario: Verify dropdown box is present
    Given Admin now on manage attendance page
    When Admin clicks + a new attendance button
    Then  four dropdown should be present
    
   Scenario: Verify close button in attendance details popup window
    Given Admin now on manage attendance page
    When Admin clicks + a new attendance button
    Then Admin should see  close button on the attendance details popup window
    
   Scenario: Verify the alignment of the close button
    Given Admin now on manage attendance page
    When Admin clicks + a new attendance button
    Then Close button should on the top right corner
    
   Scenario: Verify the text on first dropdown select a program name 
    Given Admin now on manage attendance page
    When Admin clicks + a new attendance button
    Then First dropdown box "select a program name" text  should be present 
    
   Scenario: Verify the text on second dropdown select class  name 		
    Given Admin now on manage attendance page
    When Admin clicks + a new attendance button
    Then Second dropdown box "select class name" text  should be present 
    
   Scenario: Verify the text on third dropdown select students 				
    Given Admin now on manage attendance page
    When Admin clicks + a new attendance button
    Then Third dropdown box "select students" text  should be present  
    
   Scenario: Verify the text on fourth dropdown select attendance 				
    Given Admin now on manage attendance page
    When Admin clicks + a new attendance button
    Then Fourth dropdown box "select attendance" text  should be present 
        
	 Scenario: Verify all the text inside the dropdown box is gray color					
    Given Admin now on manage attendance page
    When Admin clicks + a new attendance button
    Then Admin  should text in gray color
    
   Scenario: Verify save button is present				
    Given Admin now on manage attendance page
    When Admin clicks + a new attendance button
    Then Admin should see  save button in the class detail popup window
    
   Scenario: Verify cancel button is present	
    Given Admin now on manage attendance page
    When Admin clicks + a new attendance button
    Then Admin should see  cancel button in the class detail popup window
    
   Scenario Outline: Verify order of the label in attendance details page		
    Given Admin now on manage attendance page
    When Admin clicks + a new attendance button
    Then Order of the label should be "<ordernames>"
    
    Examples:
    |ordernames|
    |Program name|
     |Class Name|
      |Student Name| 
      |Attendance| 
      |Attendance Date|
   
   Scenario: Validate all program name is reflecting in the dropdown		
    Given Admin is in  attendance details popup window	
    When Admin clicks  program name dropdown
    Then Program Name in the drop down should match with  program name in  manage program page table
    
   Scenario: Validate all class name  is reflecting in the dropdown	
    Given Admin is in  attendance details popup window	
    When Admin clicks class name dropdown
    Then Class Name in the drop down should match with  class name in  manage class page table
    
   Scenario: Validate attendance field dropdown all mandatory keywords			
    Given Admin is in  attendance details popup window	
    When Admin clicks attendance dropdown
    Then Attendance field should have keywords such as - present, absent, late, excused
    
   Scenario: Verify spellings in the attendance field drop down 	
    Given Admin is in  attendance details popup window	
    When Admin clicks attendance dropdown
    Then  Admin should see correct spellings in dropdown text
    
   Scenario: Validate date picker
    Given Admin is in  attendance details popup window	
    When Admin clicks date from date picker
    Then  selected date should be their in class date text box
    
    Scenario: validate date picker should be correct format
    Given Admin is in  attendance details popup window	
    When Admin clicks date from date picker
    Then  selected date should be in  mm/dd/yyyy format
    
    Scenario: Validate right arrow in data picker to navigate to next month
    Given Admin is in  attendance details popup window	
    When Admin clicks right arrow in the date picker near month
    Then Next month calender should visible
    
    Scenario: Validate left arrow in data picker to navigate to previous month
    Given Admin is in  attendance details popup window	
    When Admin clicks left arrow in the date picker near month
    Then previous month calender should visible 
    
     Scenario: Validate current date is highlighted in the date picker
    Given Admin is in  attendance details popup window	
    When Admin clicks date picker button
    Then  Admin should see current date is highled in the date picker
    
     Scenario: Validate selected date is highlighted in the date picker
    Given Admin is in  attendance details popup window	
    When Admin clicks date picker button and selects future date
    Then  Admin should see selected date is highled in the date picker






  