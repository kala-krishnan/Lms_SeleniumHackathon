Feature: Reset Password
Background: Admin clicks reset password link after  reaching in login page
Given Admin clicks reset password link 
When Admin is in log in page
Then verify Admin is on Reset Password page

Scenario: verify text box is in enabled in new password field and retype password field
When Admin clicks on type in new password and retype password field	
Then Admin should see text box is enabled state

Scenario Outline:
When Admin enters same password on both field 'TypeinNewPassword', 'RetypePassword'  and clicks submit button	
Then Admin should recieve  : "Message". Please click here to login

Examples:
| TypeinNewPassword | RetypePassword  |Message													|
| admin        			| 	admin 			  |Your password has been reset			|
| admin 1        		| 	admin 1			  |Please try again			            |
|               		| 	         		  |Please try again			            |
| admin         		| 	admin1			  |Please try again			            |


