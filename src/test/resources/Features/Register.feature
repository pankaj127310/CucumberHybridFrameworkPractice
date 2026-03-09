Feature: Registration Functionality

Scenario: User creates an account only with mandatory fields
Given User navigates to Register Account page.
When User enters the details into the below fields

|firstName	|Pankaj							|
|lastName	|shirke							|
|telephone	|9604065837						|
|password	|Test@12345						|

And User selects Privacy policy
And User clicks on continue button
Then User Account should get created successfully.

Scenario: User creates an account  with all fields
Given User navigates to Register Account page.
When User enters the details into the below fields

|firstName	|Pankaj							|
|lastName	|shirke							|
|telephone	|9604065837						|
|password	|Test@12345						|

And User selects Yes for NewsLetter
And User selects Privacy policy
And User clicks on continue button
Then User Account should get created successfully.

Scenario: User creates duplicate account
Given User navigates to Register Account page.
When User enters the details into the below fields with duplicate email

|firstName	|Pankaj							|
|lastName	|shirke							|
|email		|shirkepankaj912@gmail.com		|
|telephone	|9604065837						|
|password	|Test@12345						|

And User selects Yes for NewsLetter
And User selects Privacy policy
And User clicks on continue button
Then User should get proper warning about duplicate email.


Scenario: User creates an account  without filling fields
Given User navigates to Register Account page.
When User enters dont the details into the below fields.
And User clicks on continue button
Then User should get proper warning.