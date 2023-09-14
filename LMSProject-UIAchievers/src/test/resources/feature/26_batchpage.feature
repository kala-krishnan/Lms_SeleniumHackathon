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
						
Scenario: Validate the delete icon below the header in manage batch page
			Given  admin in in the manage batch page
			When None of the checkboxes are selected
			Then The delete icon under the manage batch header should be disabled
			
			Scenario: check for single row delete in manage batch page
			Given  one of the checkbox/row 1 shold be selected
			When click delete icon below "Manage Batch" header
			Then The respective row in the manage batch data table is deleted
			
			Scenario: check for multiple rows delete in manage batch page
			Given  checkbox indexes 3 , 4 , 6 shold be selected
			When click delete icon below "Manage Batch" header
			Then The respective rows in the manage batch data table is deleted						