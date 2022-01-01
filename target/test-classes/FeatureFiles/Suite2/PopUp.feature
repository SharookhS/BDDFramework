
@tag
Feature: Accepetance testing to validate email login and logout
  In order to validate register and login with new user
  In order to validate login with existing user
  test@123.com & Ab@123
  
  Background:
	Given As a normal user in Price.com
	

  @GB
  Scenario Outline: Validate Price email login
    When I click on login menu tab
    Then Login popup window enabled
    And Enter "<email>" in email field
    And Enter "<password>" in password field
    And Select SignIn button
    Then Home page visible with login situation

    Examples: 
      | email  | password |
      | test@123.com | Ab@123 |
      
