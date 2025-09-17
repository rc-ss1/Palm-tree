Feature: Create a new user in the Pet Store

  @pet
  Scenario: Successfully create a new user
    Given I set the Pet Store user creation endpoint
    When I create a user with the following details
      | id       | 101           |
      | username | john_doe      |
      | firstName| John          |
      | lastName | Doe           |
      | email    | john@example.com |
      | password | secret123     |
      | phone    | 1234567890    |
      | userStatus | 1           |
    Then I should receive status code 200


Feature: Create new users in the Pet Store

  @pet
  Scenario Outline: Successfully create a new user
    Given I set the Pet Store user creation endpoint
    When I create a user with the following details
      | id        | <id>       |
      | username  | <username> |
      | firstName | <firstName>|
      | lastName  | <lastName> |
      | email     | <email>    |
      | password  | <password> |
      | phone     | <phone>    |
      | userStatus| <userStatus>|
    Then I should receive status code 200

    Examples:
      | id  | username  | firstName | lastName | email             | password  | phone      | userStatus |
      | 101 | john_doe  | John      | Doe      | john@example.com  | secret123 | 1234567890 | 1          |
      | 102 | jane_doe  | Jane      | Doe      | jane@example.com  | pass456   | 9876543210 | 1          |
