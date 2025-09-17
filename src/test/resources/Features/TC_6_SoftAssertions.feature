Feature: Login Page Validation

  @SoftAssertions

Scenario: Validate Same Day Delivery page
    Given I open the Kapruka Same Day Delivery page
    Then I should see the correct page title using soft assertions
    Then I should be on the correct page URL using soft assertions
    Then at least one product should be listed using soft assertions
    Then the search box should be present using soft assertions
    Then the Text should be available using soft assertions