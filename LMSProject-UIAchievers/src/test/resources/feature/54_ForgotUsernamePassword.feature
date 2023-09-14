#Author: Gayathri
Feature: Admin Clicks forgot username and password after reaching login page

  Background: Admin in login page after clicking login button in home page
    Given Admin is in forgot username and password page.
    When Admin click login button in home page.
    Then Admin is in forgot username or password page.

  Scenario Outline: Validate email sent for forgot password
    Given Admin is in login page.
    When Admin enters valid 'email id' and clicks send link button 'message'.
    Then Admin sends link in mail for reset username or password. 
Examples:

|emailId				 		|message								     |
|Tester@gmail.com  |Email sent successfully      |
|Tester@@@gmail.com|Please enter valid Email Id		|