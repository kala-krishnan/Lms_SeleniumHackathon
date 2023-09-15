Feature: Pagination in manage assignment


Scenario: Verify next page is enabled
 Given Admin is in add Assignment details popup windows
 When Admin creates 6 new Assignment 
 Then total Assignment entries above 5 next page is enabled ( On multiples of 5 new page will be enabled)
 
 Scenario: verify next page is disabled
 Given Admin is in add Assignment details popup windows
 When Admin creates less than or equals to 5 new Assignment  
 Then total Assignment entries  5 or below next pages is disabled