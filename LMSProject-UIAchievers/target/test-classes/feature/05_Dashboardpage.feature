Feature: Dashboard Page

Background: Admin clicks login button after giving correct URL
Given Admin launch the browser to open UI
When Admin enters URL and clicks login button
Then Admin should be in login page
@valid
Scenario: Verify after login  admin lands on manage program as dashboard page
Given Admin is in login page to sign in 
When The admin enter valid credentials and clicks login button to enter dashboard
      | UIAchievers |
      | Test@1234 |
Then Admin should see manage program as header 
@valid
Scenario: Verify the response time
Given Admin is in login page to sign in 
When The admin enter valid credentials and clicks login button to enter dashboard
      | UIAchievers |
      | Test@1234 |
Then  Maximum navigation time in milliseconds, defaults to 30 seconds in Dasboard
@valid
Scenario: Verify broken link
Given Admin is in login page to sign in 
When The admin enter valid credentials and clicks login button to enter dashboard
      | UIAchievers |
      | Test@1234 |
Then HTTP response >= 400. Then the link is broken for dashboard
@valid
Scenario: Verify LMS title 
Given Admin is in login page to sign in 
When The admin enter valid credentials and clicks login button to enter dashboard
      | UIAchievers |
      | Test@1234 |
Then Admin should see LMS -Learning management system  as title in Dashboard 
@valid
Scenario: Verify  LMS title alignment
Given Admin is in login page to sign in 
When 	The admin enter valid credentials and clicks login button to enter dashboard
      | UIAchievers |
      | Test@1234 |
Then LMS title should be on the top left corner of page
@valid
Scenario: Validate navigation bar text
Given Admin is in login page to sign in 
When The admin enter valid credentials and clicks login button to enter dashboard
      | UIAchievers |
      | Test@1234 |
Then Admin should see correct spelling in navigation bar text
@valid
Scenario: Validate LMS title has correct spelling ang space
Given  Admin is in login page to sign in 
When The admin enter valid credentials and clicks login button to enter dashboard
      | UIAchievers |
      | Test@1234 |
Then Admin should see correct spelling and space in LMS title
@valid
Scenario: Validate alignment for navigation bar
Given Admin is in login page to sign in 
When The admin enter valid credentials and clicks login button to enter dashboard
      | UIAchievers |
      | Test@1234 | 
Then Admin should see the navigation bar text on the top right side

@valid
Scenario Outline: Validate navigation bar orders 
Given Admin is in login page to sign in 
When The admin enter valid credentials and clicks login button to enter dashboard
      | UIAchievers |
      | Test@1234 |
Then Admin should see "fieldname" in the 8 position

Examples:

|fieldname|8|
|student|1|
|program|2|
|batch|3|
|class|4|
|user|5|
|assignment|6|
|Attendance|7|
|logout|8|






