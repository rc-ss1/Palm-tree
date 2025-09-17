Feature: ContactUs Validation

  @ContactUs
  Scenario: Verify navigation to Orderstatus contactus page
    Given I login with the website
    When I click on ContactUs Page
    Then the page details should be correct