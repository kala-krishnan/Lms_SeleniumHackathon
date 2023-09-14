#Author: Amandeep Kaur
Feature: User page validation

	@Valid
  Scenario: Validate landing in User page	
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar
    Then Admin should see the "Manage User" in the URL 
  @Valid
  Scenario: Validate header in the User Page
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar 
    Then Admin should see the "Manage User" in the header
	@Valid
  Scenario: Validate pagination in the User Page
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar 
    Then Admin should see the pagination controls under the data table
  @Valid 
  Scenario: Validate data table headers in the User Page
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar 
    Then Admin Should see the data table with headers Id, Name, location, Phone Number, Edit/Delete
    @Valid 
   Scenario: Validate Delete button in User Page
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar 
    Then Admin should be able to see the "Delete" icon button that is disabled
   @Valid 
   Scenario: Validate "+ A New user" button in User Page
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar 
    Then Admin should be able to see the "+ A New User" button
    @Valid
   Scenario: Validate "+ Assign staff"  button in User page
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar 
    Then Admin should be able to see the "+ Assign staff" button
   @Valid
   Scenario: Validate search box in User page
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar 
    Then Admin should be able to see the search text box
   @Valid
   Scenario: Validate data rows
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar 
    Then Each row in the data table should have a checkbox
    @Valid
   Scenario: Validate data rows
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar 
    Then Each row in the data table should have a delete icon that is enabled
   @Valid 
   Scenario: Validate pop up for adding user
    Given Admin is on dashboard page after Login and Admin clicks "User" from navigation bar
    When Admin clicks "+ A New User" button
    Then A new pop up with User details appear
    @Valid
		Scenario: Check if the fields exist in pop		
   	 Given A new pop up with user details appears
   	 Then The pop up should include the fields First Name,Middle name, Last Name, Location phone, email,linkedin Url,Undergraduate,postgraduate,time zone and user comments as text box User Role, Role status, visa status as drop down"
		@Valid
		Scenario: Check if Middle name, linkedIn url, email, user comments.under graduate,post graduate,time zone are optional 
    	Given A new pop up with user details appears
    	When  Fill in all the fields except optional fields with valid values and click submit
   	  Then The newly added user should be present in the data table in Manage User page
    @Valid		
    Scenario: Check if the program details are added in data table
    	Given A new pop up with user details appears
    	When  Fill in all the fields with valid values and click submit
   	  Then The newly added user should be present in the data table in Manage User page
   	@Invalid  
   	Scenario: Check for error messages for invalid fields
    	Given A new pop up with user details appears
    	When any of the fields have invalid values	
   	  Then Error message should appear
   	@Invalid  
   	 Scenario: Check for error messages for mandatory fields		
    	Given A new pop up with user details appears
    	When Any of the mandatory fields are blank		
   	  Then Error message should appear
	  @Valid	
		Scenario: Validate row level edit icon		
   	 	Given The edit icon on row level in data table is enabled
   	 When Admin clicks the edit icon
   	 Then A new pop up with User detail appears
   	 @Valid	
   Scenario: Check if the fields are updated
   	 Given Admin clicks the edit icn
   	 When Update the fields with valid values and click submit
   	 Then The updated user details should appear on the data table
   	@Invalid	
   	Scenario: Check if the update throws error with invalid values	
   	 Given Admin clicks the edit icon
   	 When Update the fields with invalid values and click submit
   	 Then Error message should appear
   	@Invalid
   	Scenario: Check if you get error message when mandatory fields are erased	
   	 Given Admin clicks the edit icon
   	 When Erase data from mandatory field
   	 Then Error message should appear
   	 @Valid	
   	Scenario: Check if description field is optional in update	
   	 Given Admin clicks the edit icon
   	 When Erase data from description field
   	 Then The updated user details should appear on the data table
   @Valid	
		Scenario: Validate row level delete icon
   	 Given 	The delete icon on row level in data table is enabled		
   	 When Admin clicks the delete icon
   	 Then Alert appears with yes and No option
   	@Valid	 
   	Scenario: Validate accept alert
   	 Given 	Admin clicks the delete icn		
   	 When Admin click yes option
   	 Then User deleted alert pops and user is no more available in data table
   	 @Valid	
   	 Scenario: Validate reject alert
   	 Given 	Admin clicks the delete icon			
   	 When Admin click No option
   	 Then User is still listed in data table
   	@Valid	 
		Scenario: Validate the delete icon below the header 
   	 Given None of the checkboxes in data table are selected	 
   	 Then The delete icon under the "Manage User" header should be disabled
   	 @Valid	
   	Scenario: Check for single row delete
   	 Given One of the checkbox or row is selected
   	 When Click delete icon below "Manage User" header
   	 Then The respective row in the data table is deleted
   	 @Valid	
   	Scenario: Check for multi row delete
   	 Given Two or more checkboxes/row is selected
   	 When Click delete icon below "Manage User" header
   	 Then The respective row in the data table is deleted
   	  
   	