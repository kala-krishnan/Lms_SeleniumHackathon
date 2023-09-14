
Feature: Additional scenarios for all modules
@valid
Scenario: Validating navigation bars on dashboardpage
Given Admin is on Dashboard Page
When clicks on student navigation button 
Then Admin should navigate to student page
@valid
Scenario: Validating program button adn link on dashboard page
Given Admin is on Dashboard Page
When cLicked on program navigation bar link 
Then Admin should navigate to program page
@valid
Scenario: Validating Batch button and link on dashboard page
Given Admin is on Dashboard Page
When cLicked on Batch navigation bar link 
Then Admin should navigate to Batch page
@valid
Scenario: Validating class button and link on dashboard page
Given Admin is on Dashboard Page
When cLicked on program class bar link 
Then Admin should navigate to class page
@valid
Scenario: Validating user button adn link on dashboard page
Given Admin is on Dashboard Page
When cLicked on user naigation bar link 
Then Admin should navigate to user page
@valid
Scenario: Validating Assignment  button adn link on dashboard page
Given Admin is on Dashboard Page
When cLicked on Assignment navigation bar link 
Then Admin should navigate to Assignemnt page
@valid
Scenario: Validating Attendance button adn link on dashboard page
Given Admin is on Dashboard Page
When cLicked on Attendance navigation bar link 
Then Admin should navigate to Attendance page


@valid
Scenario: Logout button is enabled
Given Admin is on Dashboard Page
When Able to click on logout button 
Then action performed as button is enabled	
