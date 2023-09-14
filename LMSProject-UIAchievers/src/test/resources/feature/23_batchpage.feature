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
Feature: Batch Page Validation 

Background: Logged on the LMS Portal



		Scenario: Verify admin is landing in Batch Page
    Given The admin is on dashboard page after login to click batch
    When 	The admin clicks "Batch" from navigation bar  
    Then  The admin should see the "Manage Batch" in the URL
    
		Scenario: Validate the header in the batch page
    Given The admin is on dashboard page after login to click batch
    When 	The admin clicks "Batch" from navigation bar  
    Then  The admin should see the "Manage Batch" in the header
    
		Scenario: Validate the pagination in the batch page
    Given The admin is on dashboard page after login to click batch
    When 	The admin clicks "Batch" from navigation bar  
    Then  The admin should see the pagination controls in the Manage batch data table
    
 		Scenario: Validate the data table headers in the batch page
    Given The admin is on dashboard page after login to click batch
    When 	The admin clicks "Batch" from navigation bar  
    Then  The admin should see the data table headers in "Batch" as Batch Name,Batch Description,Batch Status,No of Classes,Program Name,Edit ,Delete

		Scenario: Validate the delete button in the batch page
    Given The admin is on dashboard page after login to click batch
    When 	The admin clicks "Batch" from navigation bar  
    Then  The admin should be able to see the "Delete" icon button in Manage batch is disabled       
    
 		Scenario: Validate "+New Batch" in Batch Page
    Given The admin is on dashboard page after login to click batch
    When 	The admin clicks "Batch" from navigation bar  
    Then  The admin should be able to see the "+New Batch" button in Manage batch
    
 		Scenario: Validate data rows
    Given The admin is on dashboard page after login to click batch
    When 	The admin clicks "Batch" from navigation bar  
    Then  Each row in the Manage batch table should have a checkbox
    
  	Scenario: Validate data rows
    Given The admin is on dashboard page after login to click batch
    When 	The admin clicks "Batch" from navigation bar  
    Then  Each row in Manage batch table should have a Edit icon that is enabled
    
  	Scenario: Validate data rows
    Given The admin is on dashboard page after login to click batch
    When 	The admin clicks "Batch" from navigation bar  
    Then  Each row in Manage batch table should have a delete icon that is enabled
    
   	Scenario: Validate pop up for adding batch
    Given The admin is on dashboard page after login to click batch
    When 	The admin clicks "+ New Batch" button  
    Then  A new pop up with batch details appear



