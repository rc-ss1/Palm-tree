Feature: Search Page Validation

  @Search
  Scenario: Testing Search
    When I login with the website
    Then I should see dashboard
    When user enter text to Search and click on Search button
    Then verify all items displayed for Cake
#    When page loads
#    Then verify all items displayed related to Search criteria