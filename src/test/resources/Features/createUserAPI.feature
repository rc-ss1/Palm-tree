Feature: Create User API Automation

  @createUser
  Scenario: Verify user creation using ReqRes API

    Given I set the POST API endpoint
    When I send POST request with user details
    Then I should receive a successful response with status code 201
