Feature: Read PDF

  @PDFReport
Scenario: Customer Account Login
    When read pdf
    Then verify text in pdf
    When I login with the website
    Then I should see dashboard
