Feature: Login Page Validation

  @Excel
  Scenario: Customer Account Login
    When I login with the website with excel data
    Then I should see dashboard
    When read from excel
    Then data should display from excel
    When write to excel
    Then data should display