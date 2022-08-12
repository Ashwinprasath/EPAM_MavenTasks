Feature: Verifying account registration and signin

Background:
Given Open the Webpage

@TC1
Scenario: Register a user
    Given  Click on Signin button
    When I enter email as "ashwinr@gmail.com"
    When I click on Create an account button
    Then Automation Exercise Signup page should be displayed
    When I click on MR
    And I enter First Name as "Ashwin"
    And I enter Last Name as "Mohan"
    And I enter password as "12345"
    And I select date as "29"
    And I select month as "March"
    And I select year as "1996"
    And I enter company as "Epam"
    And I enter Address as "No 4"
    And I enter Address2 as "fgg"
    And I select State as "Utah"
    And I enter city as "Vandavasi"
    And I enter zipcode as "84095"
    And I enter mobile number as "9283746321"
    And I click on Register button
    Then Verify the page Automation Exercise Account Created
  
@TC2 
Scenario: Login and Logout
    Given Click on Signin button
    When I enter login email as "ashwinrockz@gmail.com"
    When I enter login Passowrd as "12345"
    When I click on Login button
    Then Automation Exercise page should be displayed
    When  Click on Logout button
    Then Automation Exercise Homepage page should be displayed
   