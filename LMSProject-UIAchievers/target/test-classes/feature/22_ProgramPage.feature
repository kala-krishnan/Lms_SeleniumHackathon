
Feature: Navigation Validation from Manage Program to other Pages

  Background: Admin is on dashboard page after Login and clicks Program on the navigation bar
    Given Admin is on dashboard page after Login .
    When Admin clicks Program on the navigation bar.
    Then Admin should see URL with "Manage Program".

  Scenario: Student link on navigation bar
    Given Admin is on Manage Program page.
    When Admin clicks on Student link on Manage Program page.
    Then Admin is re-directed to Student page.

  Scenario: Batch link on navigation bar
    When Admin clicks on Batch link on Manage Program page.
    Then Admin is re-directed to Batch page.

  Scenario: Class link on navigation bar
    When Admin clicks on Class link on Manage Program page.
    Then Admin is re-directed to Class page.

  Scenario: User link on navigation bar
    When Admin clicks on User link on Manage Program page.
    Then Admin is re-directed to User page.

  Scenario: Assignment link on navigation bar
    When Admin clicks on Assignment link on Manage Program page.
    Then Admin is re-directed to Assignment page.

  Scenario: Attendance link on navigation bar
    When Admin clicks on Attendance link on Manage Program page.
    Then Admin is re-directed to Attendance page.

  Scenario: Logout link on navigation bar
    When Admin clicks on Logout link on Manage Program page.
    Then Admin is re-directed to Login page.
