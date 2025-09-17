Feature: Upload File

  @Upload1
  Scenario: Verify file is uploaded
    When I launch uploadfile website
    Then I should see dashboard
    When user click on choose file button