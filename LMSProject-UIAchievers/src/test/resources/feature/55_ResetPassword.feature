
Feature: Reset Password
Background: Admin in login page after clicking login button in home page
Given Admin is in home page.
When Admin clicks login button in home page.
Then verify Admin is on login page.


Scenario: Verify  reset password link
Given Admin is in login page.
When Admin clicks reset password link.
Then Admin should land on reset password page 'Reset password'.


Scenario: Verify  text in the resetPassword page
Then Admin should see correct spellings in all fields in reset password page.

Scenario: Verify submit button is present
Then Admin should see "submit"  button.

Scenario: Verify the alignment of the  submit button
Then Admin should see submit button in center of the page.

Scenario: Verify text box is present is the page
Then Admin should see two text box.

Scenario: Verify first label text
Then Admin should see "Type in new password" in the first label text.

Scenario: Verify second label text
Then Admin should see "Retype password" in the second label text.

Scenario: verify text box is in disabled
Then Admin should see text box in disabled state.
