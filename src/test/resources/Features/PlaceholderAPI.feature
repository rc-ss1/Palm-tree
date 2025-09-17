Feature: StatusCode validation

  @APITest
  Scenario: APITest
    Given the API base URL is "https://jsonplaceholder.typicode.com"
    When I send a GET request to "/users"
    Then the response status code should be 200