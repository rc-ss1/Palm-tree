Feature: Home Page Validation

  @Home
  Scenario: Customer Account Login
    When I login with the website
    Then I should see dashboard
    When user navigate to homepage
    Then Catalogs tab should display