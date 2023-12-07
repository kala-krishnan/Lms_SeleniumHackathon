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
Feature: Add Batch Page Validation 

Background: Logged on the LMS Portal
						Admin is in the dashboard after login before clicking batch
						Admin clicks "Batch" in navigation bar
						Admin clicks "+ New Batch" in manage Batch
 	@valid
		Scenario: Validate if the batch fields exist in pop
    Given The new pop up with batch details appear
    When 	The admin clicks "+ New Batch" button  
    Then  The pop up should include the fields "Name","Description","Program Name","Status","No of Classes"
    
   @valid  
		Scenario: Adding New Batch
 		Given The admin is in Add New Batch Pop up page
 		When The user enter all the valid batch details 
 		Then the user sees the sucesss message "Batch Details Added Successfully"
 	 @invalid 	
 		Scenario Outline: Validate batch with invalid credentials
	  Given The new pop up with batch details appear 
    When The admin enters "<Name>","<Description>","<Program Name>","<Status>","<No of Classes>" in batch add pop up
    Then the admin should see the error message indicating "<errormessage>" in Batch pop up
  
 
 Examples:
 |    Name        |  Description   |   Program Name   |  Status  |   No of Classes  |  errormessage  |
 ||||||Please enter Mandatory fields |  
 |   101          |                |             | Active   |  3  |    Please enter valid Program Name |
 |                |                |   SDET      |  Active  |  3  |  Please enter valid Batch Name |
 |  101           |                |   SDET      |          | 3   | Please enter Status |
 |   101          |                |   SDET      |Active    |     | Please enter No of Classes | 
 |000000000       |                |  SDET       | Active   | 3   | Please enter valid Batch Name |
 | {}[]*&^%$?><@  |                | SDET        |Active    | 3   | Please enter valid Batch Name |
 | 4              |                | SDET        |Active    | 3   | Batch Name already exists     |