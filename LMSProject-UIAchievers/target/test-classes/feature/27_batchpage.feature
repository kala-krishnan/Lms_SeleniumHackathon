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
Feature: Delete Multiple Batches Page Validation 

Background: Logged on the LMS Portal
						Admin is in the dashboard after login before clicking batch
						Admin clicks "Batch" in navigation bar
	 @valid					
Scenario: Validate row level edit icon in manage batch page
			Given The edit icon on row level in manage batch data table is enabled
			When Admin clicks the rownumber 2 edit icon in manage batch page
			Then A new pop up with batch details appears
	 @valid		
			Scenario: Check the fields in the new pop up with batch details are updated
			Given The admin is in the pop up edit batch page
			When Admin clicks the save button in edit batch page with valid details from excel
			Then The updated batch fields should appear on the data table
	 @valid		
			Scenario: Check the fields in the new pop up with batch details are updated
			Given The admin is in the pop up edit batch page
			When Admin clicks the save button in edit batch page with valid details
			| 100  | 
      |       |
      | SDET  |
      |Active |
      |   4   |
			Then The updated batch fields should appear on the data table
			
			
	 @invalid		
			Scenario Outline: The error message will appear when the invaild details are given in the edit batch
	  Given The edit pop up with batch details appear 
    When The admin enters "<Name>","<Description>","<Program Name>","<Status>","<No of Classes>" in batch edit pop up
    Then the admin should see the error message indicating "<errormessage>" in Batch edit pop up
  
 
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
 						