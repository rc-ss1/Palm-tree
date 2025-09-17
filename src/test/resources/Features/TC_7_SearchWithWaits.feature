Feature: Search functionality on Kapruka Same Day Delivery


  @Waits

  Scenario: Validate Same Day Delivery page

  Scenario: Search for cake and see results
    Given I am on the Kapruka Same Day Delivery page
    When I search for "cake"
    Then I should see search results related to "cake"