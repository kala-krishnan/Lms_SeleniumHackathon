Feature: Navigation Validation from student page to other Pages
Background: Admin is logged in and on the student Details page

@Valid
Scenario: Program link on navigation bar
Given Admin is on student details page
When Admin clicks on program link on student  page
Then Admin is redirected to Program page

@Valid
Scenario: Batch link on navigation bar
Given Admin is on student details page
When Admin clicks on Batch link on student page
Then Admin is redirected to Batch page

@Valid
Scenario: Class link on navigation bar
Given Admin is on student details page
When Admin is redirected to User page
Then Admin is redirected to Class page


@Valid
Scenario: User link on navigation bar
Given Admin is on student details page
When Admin clicks on User link on student page
Then Admin is redirected to User page


@Valid
Scenario: Assignment link on navigation bar
Given Admin is on student details page
When Admin clicks on Assignment link on student page
Then Admin is redirected to Assignment page


@Valid
Scenario: Attendance link on navigation bar
Given Admin is on student details page
When Admin clicks on Attendance link on student page
Then Admin is redirected to Attendance page


@Valid
Scenario: Logout link on navigation bar
Given Admin is on student details page
When Admin clicks on Logout link on student page
Then Admin is redirected to Login page