Feature: Create new customer account

    @AlertMessage
  Scenario: Validate error messages when invalid email and mismatched password are entered
  I
    When I login with the website1
    When user enters invalid details for account creation
    Then user should see error messages for invalid email and mismatched password