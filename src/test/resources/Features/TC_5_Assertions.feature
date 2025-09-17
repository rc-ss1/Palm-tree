Feature: Login Page Validation

  @Assertions

Scenario: Validate Same Day Delivery page
    Given I open the Kapruka Same Day Delivery page
    Then I should see the correct page title
    Then I should be on the correct page URL
    Then at least one product should be listed
    Then the search box should be present
    Then the Text should be available