Feature: Edit New Program

  Background: Admin is on Manage Program Page after clicks Program on the navigation bar

  Scenario: Validating admin is in 'Manage Program'
    Given Admin is in Manage program Page. 
    When Admin clicks program link on the navigator bar.
    Then Admin should be on Manage Program page 'Manage Program' in program module


    @validprogram
   Scenario Outline: Enter valid Program Name, Program Description and Select Status 
	When Admin edits the Name column and clicks save button program name, program description, status "<programName>" or "<programDesc>" or "<Status>" in text box and clicks Save button.
	Then Admin gets a message "Successful Program Updated" alert and able to see the updated details in the table for the particular program.
	Examples:
	
      | programName | programDesc  | Status   |SuccessMessage													|
      | SDET-edit   | TestEngineer | Active   |Successful Program Updated             |
 
 @invalidprogram
  Scenario Outline: Validate invalid values on the text column of Manage Program Page
   When Admin enters only program name or program description or status "<programName>" or "<programDesc>" or "<Status>" or 'Save' in text box and clicks Save button.

    Examples: 
      | programName | programDesc  | Status   |errorMessage													|
      | SDET        | 						 | Active   |Program Status is required						|
      |         		| TestEngineer | Active   |Program Name is required							|
      |         		|          		 | InActive |Program Name and Status are required	|
      |         		|          		 | InActive |Program Name and Status are required	|
      | SDET123     | TestEngineer | InActive |Enter valid Program Name							|
      | SDET@@@     | TestEngineer | InActive |Enter valid Program Name							|
 
 @validprogram
  Scenario Outline: Validate save button on Edit popup in program page.
   When Admin clicks <save>'save' button on edit popup.
Then Admin gets a message "Successful Program Updated" alert and able to see the updated details in the table for the particular program.

      
 Scenario: Validate Cancel button on Edit popup
 
When Admin clicks <Cancel>button on edit popup.
Then Admin can see the Program details popup disappears and can see nothing changed for particular program.

    