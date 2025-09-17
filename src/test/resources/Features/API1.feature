Feature: Validate JSONPlaceholder API response

  @APITest
  Scenario: Verify GET API response for post with ID 1
    Given I set the base URI for JSONPlaceholder API
    When I send a GET request to "/posts/1"
    Then the response status code should be 200
    And the response should contain userId as 1