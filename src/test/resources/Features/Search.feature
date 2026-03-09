Feature: Search Functionality 

Scenario: User Search for valid a valid Product
Given User opens the application.
When User enteres valid product "hp" into searchbox field
And User clicks on search button.
Then User should get valid product displayed in searchbox results


Scenario: User Search for Invalid a valid Product
Given  User opens the application.
When User enteres Invalid product "honda" into searchbox field
And  User clicks on search button.
Then User should get a message about no product matching.


Scenario: User Search without Product
Given  User opens the application.
When User dont enteres any product name into searchbox field
And  User clicks on search button.
Then User should get a message about no product matching.