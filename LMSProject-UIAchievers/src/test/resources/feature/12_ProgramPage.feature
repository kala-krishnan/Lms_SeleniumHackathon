Feature: Add New Program
Background: Admin is on Manage Program Page after clicks Program on the navigation bar

Given Admin is on Manage Program page.
    When Admin clicks Program on the navigation bar.
    Then Admin should see URL with "Manage Program".
  
@validProgram
Scenario: Adding New Program
Given The admin is in Add New Program Pop up page.
When The user enter all the valid program details.
Then the user sees the 'sucesss' message in program page.
  
@invalidProgram
  Scenario Outline: Empty form submission
  
    When Admin clicks 'Save'button without entering any data "<programName>" "<programDesc>" "<Status>" "<Button>".
    Then Admin gets a Error message alert 'Enter mandatory fields Program Name and  status'. 

    Examples: 
      | programName | programDesc | Status | Button |
      |         		|         		| Active | Save   |

@invalidProgram
  Scenario Outline: Enter only Program Name, Program Description and Select Status only.
   When Admin enters only program name or program description or status "<programName>" or "<programDesc>" or "<Status>" or 'Save' in text box and clicks Save button.

    Examples: 
      | programName | programDesc  | Status   |errorMessage													|
      | SDET        | 						 | Active   |Program Status is required						|
      |         		| TestEngineer | Active   |Program Name is required							|
      |         		|          		 | InActive |Program Name and Status are required	|
      |         		|          		 | InActive |Program Name and Status are required	|
      | SDET123     | TestEngineer | InActive |Enter valid Program Name							|
      | SDET@@@     | TestEngineer | InActive |Enter valid Program Name							|
      | SDET        | TestEngineer | Active   |Program Name already exists          |
      
      
  @validProgram
   Scenario Outline: Enter valid Program Name, Program Description and Select Status 
	When Admin enters program name, program description, status "<programName>" or "<programDesc>" or "<Status>" in text box and clicks Save button
	Then Admin gets a message "Successful Program Created" alert and able to see the updated details in the table for the particular program
	Examples:
	
      | programName | programDesc  | Status   |SuccessMessage													|
      | SDET        | TestEngineer | Active   |Successful Program Created             |
  
      
  Scenario: Validate Cancel/Close(X) icon on Program Details form
  When Admin clicks Close 'close' Icon on Program Details form	
  Then Program Details popup window should be closed without saving
  
  Scenario: Validate Cancel/Close(X) icon on Program Details form
  When Admin clicks <Cancel> 'cancel' button 
	Then Admin can see the Program details popup disappears without creating any program

      