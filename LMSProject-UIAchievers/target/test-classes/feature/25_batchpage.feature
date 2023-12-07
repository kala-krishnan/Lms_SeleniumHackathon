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
Feature: Delete Batch Page Validation 

Background: Logged on the LMS Portal
						Admin is in the dashboard after login before clicking batch
						Admin clicks "Batch" in navigation bar
 @valid						
Scenario: Validate row level delete icon in manage Batch
			Given The delete icon on row level in batch data table is enabled
			When Admin clicks the delete icon in batch 
			Then Alert appears with Yes and No Button
 @valid			
			Scenario: Validate accept in delete pop up message in Batch
			Given Admin clicks the delete icon in batch 
			When  Click Yes option in batch delete confirmation page
			Then Batch deleted alert pops and batch is no more avaliable in batch
	 @valid		
			Scenario: Validate reject alert in delete pop up message in batch
			Given Admin clicks the delete icon in batch
			When  Click No option in batch delete confirmation page
			Then Batch is still listed in data table				
					
						
						