#Author: Gayathri
Feature: Manage Program Validation

Background: Admin is on dashboard page after Login and clicks Program on the navigation bar
  
    Given Admin is on dashboard page after Login page.
    When Admin clicks Program page on the navigation bar. 
    Then Admin should see URL with "Manage Program" page in program module.


  Scenario Outline: Search Program By Name
  
  
    Given Admin is on Manage Program page.
		When Admin enters Program Name , Program Description and Program Status in search content into search box "<ProgramName>" 'Program description', 'ProgramStatus' .
    Then Admin see the search result "<ProgramName>" 'Program description', 'ProgramStatus' .

    Examples: 
      | programName | programDesc 			| ProgramStatus |  
      |      SDET-01   |    Testing     		| Active 				| 
          

  Scenario: Validating the Search with unrelated keyword
    When Admin enters the keywords not present in the data table 'AI 'on the Search box.
    Then Admin should see zero entries on the data table.
   