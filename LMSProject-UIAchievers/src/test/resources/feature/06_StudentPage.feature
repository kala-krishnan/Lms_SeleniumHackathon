Feature: Student Page Verification

  Background: Logged on the LMS portal as Admin

  @Valid
  Scenario: Validate the title of the page
    Given Admin is on dashboard page after Login.
    When Admin clicks "Student" on the navigation bar.
    Then Admin should see the Student details Page Title

  @Valid
  Scenario: Validate response time from dashboard page to student page
    Given Admin is on dashboard page after Login.
    When Admin clicks "Student" on the navigation bar.
    Then Maximum navigation time in milliseconds, defaults to 30 seconds

  @Valid
  Scenario: Validate the broken link
    Given Admin is on dashboard page after Login.
    When Admin clicks "Student" on the navigation bar.
    Then HTTP response >= 400. Then the link is broken.

  @Valid
  Scenario: Verify LMS title
    Given Admin is on dashboard page after Login.
    When Admin clicks "Student" on the navigation bar.
    Then Admin should see LMS -Learning management system  as title

  @Valid
  Scenario: Verify the alignment of the Student detail title
    Given Admin is on dashboard page after Login.
    When Admin clicks "Student" on the navigation bar.
    Then Student Detail title should be in centre of the page

  #6
  @Valid
  Scenario: Validate drop down is present in the page
    Given Admin is on dashboard page after Login.
    When Admin clicks "Student" on the navigation bar.
    Then 2 dropdowns should be present in the page

  @Valid
  Scenario: Validate search bar in select student name drop down
    Given Admin is on dashboard page after Login.
    When Admin clicks "Student" on the navigation bar.
    Then Admin should see search box inside the drop down

  @Valid
  Scenario: Validate search bar in select batch id drop down
    Given Admin is on dashboard page after Login.
    When Admin clicks "Student" on the navigation bar.
    Then Admin should see search box inside  batch id drop down

  @Valid
  Scenario: Validate text spelling student name
    Given Admin is on dashboard page after Login.
    When Admin clicks "Student" on the navigation bar.
    Then Admin should see correct spelling select student name

  @Valid
  Scenario: Validate text spelling select batch id
    Given Admin is on dashboard page after Login.
    When Admin clicks "Student" on the navigation bar.
    Then Admin should see correct spelling select  batch id

  @Valid
  Scenario: Validate only numbers inside select batch id
    Given Admin is on dashboard page after Login.
    When Admin clicks "Student" on the navigation bar.
    Then Admin should see only numbers inside batch id drop down

  @Valid
  Scenario: Validate gray color in student name drop down
    Given Admin is on dashboard page after Login.
    When Admin clicks "Student" on the navigation bar.
    Then Admin should see select student name in gray color

  @Valid
  Scenario: Validate gray color in student name drop down
    Given Admin is on dashboard page after Login.
    When Admin clicks "Student" on the navigation bar.
    Then Admin should see select batch ID in gray color

  @Valid
  Scenario: Validate first drop down label is select student name
    Given Admin is on dashboard page after Login.
    When Admin clicks "Student" on the navigation bar.
    Then Admin should see select student name in first

  @Valid
  Scenario: Validate second drop down label is select batch id
    Given Admin is on dashboard page after Login.
    When Admin clicks "Student" on the navigation bar.
    Then Admin should see select batch id in second

  @Valid
  Scenario: Validate scroll down inside student name dropdown
    Given Admin is on dashboard page after Login.
    When Admin clicks "Student" on the navigation bar.
    Then Admin should able to scroll down to select the name

  @Valid
  Scenario: Validate scroll down inside batch id dropdown
    Given Admin is on dashboard page after Login.
    When Admin clicks "Student" on the navigation bar.
    Then Admin should able to scroll down to select the batch id
    
    @Valid
    Scenario: 
