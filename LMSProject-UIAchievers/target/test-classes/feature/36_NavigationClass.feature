 Feature: Navigation function validation from manage class page to other pages 

		 
		Scenario: Verify admin is able to navigate from manage class to student page
		Given   Admin is in ManageClass page
		When    Admin clicks "Student" student button in the navigation bar from manage class
		Then    Admin should be able to land on student page from manage class
		
		 
		Scenario: Verify admin is able to navigate from manage class to program page
		Given   Admin is in Manage class page
		When    Admin clicks "Program" program button in the navigation bar from manage class
		Then    Admin should be able to land on program page from manage class
		
		 
		Scenario: Verify admin is able to navigate from manage class to batch page
		Given   Admin is in Manage Class page
		When    Admin clicks "Batch" batch button in the navigation bar from manage class
		Then    Admin should be able to land on batch page from manage class
		 
		 
		Scenario: Verify admin is able to navigate from manage class to user page
		Given   Admin is in Manage Class page
		When    Admin clicks "User" user button in the navigation bar from manage class 
		Then    Admin should be able to land on user page from manage class
		
		 
		Scenario: Verify admin is able to navigate from manage class to assignment page
		Given   Admin is in Manage Class page
		When 	  Admin clicks "Assignment" assignment button in the navigation bar from manage class
		Then   	Admin should be able to land on Assignment page from manage class
		
		 
		Scenario: Verify admin is able to navigate from manage class to attendance page
		Given   Admin is in Manage Class page
		When 	  Admin clicks "Attendance" attendance button in the navigation bar from manage class
		Then    Admin should be able to land on attendance page from manage class
		 
		 
		Scenario: Verify admin should able to do logout function from manage class
		Given   Admin is in Manage Class page
		When 	  Admin clicks "Logout" logout button in the navigation bar from manage class
		Then    Admin should be able to land on login page from manage class
		
 