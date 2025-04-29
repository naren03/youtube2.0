Feature: User Login Functionality

  Scenario: Display login button on homepage
    Given I am on the homepage
    Then I should see a prominently displayed login button

  Scenario: Access login form via login button
    Given I am on any page of the e-commerce website
    When I click on the login button
    Then I should see a modal with the login form
    And the login form should include fields for email/username and password
    And there should be a "Forgot Password?" link

  Scenario: Login with incorrect credentials
    Given I am on the login form
    When I enter an incorrect email/username and password
    And I click the login button
    Then I should see an error message indicating invalid credentials

  Scenario: Successful login
    Given I am on the login form
    When I enter a valid email/username and password
    And I click the login button
    Then I should be redirected to my account dashboard
    And I should see a welcome message

  Scenario: Remember user login session
    Given I have successfully logged in
    When I close the browser and reopen it
    Then I should still be logged in unless I log out

  Scenario: Logout functionality
    Given I am logged into my account
    When I click the logout button
    Then I should be redirected to the homepage
    And I should not be logged in
