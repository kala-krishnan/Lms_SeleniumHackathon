#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Authenticate and verify the login feature
  
Scenario: Verify admin is able to land on homepage
    Given The admin is in Home page
    When 	The admin clicks on the Login link 
    Then  The admin should landed on LMS Login Page "LMS Login Page"
    
Scenario: Verifies for broken link
    Given The admin is in Home page
    When 	The admin clicks on the Login link 
    Then  The admin gets the errorMessage "URL is broken link." when the response is >=400 
    
Scenario: Verifies the header of the login page
    Given The admin is in Home page
    When 	The admin clicks on the Login link 
    Then  The admin gets the Message "Please login to LMS Application" 

Scenario: Verifies the correct spelling of the fields in login page
    Given The admin is in Home page
    When 	The admin clicks on the Login link 
    Then  The admin should see the correct spellings in all fields
    
Scenario: Verifies the text field is present
    Given The admin is in Home page
    When 	The admin clicks on the Login link 
    Then  The admin should see the two text fields      
        
Scenario: Verifies text on the first text field
    Given The admin is in Home page
    When 	The admin clicks on the Login link 
    Then  The admin should see "User" in the first text field  
    
Scenario: Verifies symbol next to user text
    Given The admin is in Home page
    When 	The admin clicks on the Login link 
    Then  The admin should see "*" symbol next to user text
    
Scenario: Verifies text on the second text field
    Given The admin is in Home page
    When 	The admin clicks on the Login link 
    Then  The admin should see "password" in the second text field    
      
Scenario: Verifies symbol next to password text
    Given The admin is in Home page
    When 	The admin clicks on the Login link 
    Then  The admin should see "*" symbol next to password text     
    
Scenario: Verifies the alignment input field for the login
    Given The admin is in Home page
    When 	The admin clicks on the Login link 
    Then  The admin should see the input field on the center of the page
    
Scenario: Verifies the login is present
    Given The admin is in Home page
    When 	The admin clicks on the Login link 
    Then  The admin should see login button
    
Scenario: Verifies the alignment of the login button
    Given The admin is in Home page
    When 	The admin clicks on the Login link 
    Then  The admin should see login button on the center of the page
    
Scenario: Verifies forgot username or password link
    Given The admin is in Home page
    When 	The admin clicks on the Login link 
    Then  The admin should see forget username or password link
    
Scenario: Verifies reset password link
    Given The admin is in Home page
    When 	The admin clicks on the Login link 
    Then  The admin should see reset password link
    
Scenario: Verifies input decriptive test in user field
    Given The admin is in Home page
    When 	The admin clicks on the Login link 
    Then  The admin should see user in gray "#808080" scolor
    
Scenario: Verifies input decriptive test in password field
    Given The admin is in Home page
    When 	The admin clicks on the Login link 
    Then  The admin should see password in gray "#808080" color
    
Scenario: Validate login with valid credentials
    Given The admin is in login page
    When 	The admin enter valid credentials and clicks login button
      | UIAchievers  | 
      |  Test@1234   |
    Then  The admin should land on dashboard page with the message "Welcome, Admin! Logged in successfully"
    
 
 Scenario Outline: Validate login with invalid credentials
	  Given The admin is in login page
    When The admin enters "<username>", "<password>" and clicks the login button
    Then the admin should see the error message indicating "<errormessage>"
  
 
 Examples:
 | username        | password   | errormessage                                                      |
 |                 | Test@1234  | Please enter valid username                                       |
 | UIAchievers     |            | Please enter valid password                                       |
 | 00000000000     | Test@1234  | Please enter valid username                                       |
 | UIAchievers     | 00000000000| Please enter valid password                                       |
 | *&^$$$$$$$$     | Test@1234  | Please enter valid username                                       |
 |                 |            | Please enter valid username and password                          |                              
 
 Scenario: Verify login button action through keyboard
    Given The admin is in Home page
    When 	The admin enter valid credentials and clicks login button through keyboard
      | UIAchievers  | 
      |  Test@1234   |
    Then  The admin should land on dashboard page with the message "Welcome, Admin! Logged in successfully"
    	
 
  Scenario: Verify login button action through mouse
    Given The admin is in Home page
    When 	The admin enter valid credentials and clicks login button through mouse
      | UIAchievers  | 
      |  Test@1234   |
    Then  The admin should land on dashboard page with the message "Welcome, Admin! Logged in successfully"
    	
 

 