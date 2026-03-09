Feature: Login Functionality 

Scenario Outline: Login with valid Credentials
Given User navigates to Login page.
When User enteres valid email address <username> into the email field
And User has entered Valid Password <password> into the password
And User Clicks on Login Button
Then User should get login successfully
Examples:
|username|password|
|pankajshirke901@gmail.com|Test@12345|
|pankajshirke933@gmail.com|Test@12345|
|pankajshirke934@gmail.com|Test@12345|

Scenario:Login with Invalid Credentials
Given User navigates to Login page.
When User enteres Invalid email address into the email field
And User has entered InValid Password "Tes@12345" into the password
And User Clicks on Login Button
Then User should get proper warning message for credential mismatch.

Scenario:Login with valid email with Invalid Password
Given User navigates to Login page.
When User enteres valid email address "pankajshirke901@gmail.com" into the email field
And User has entered InValid Password "Tes@12345" into the password
And User Clicks on Login Button
Then User should get proper warning message for credential mismatch.

Scenario:Login with Invalid email with valid Password
Given User navigates to Login page.
When User enteres Invalid email address into the email field
And User has entered Valid Password "Tet@12345" into the password
And User Clicks on Login Button
Then User should get proper warning message for credential mismatch.