Feature: Validate broken links on Kapruka Login Page

  @Links
  Scenario: Verify all links on the login page are working
    Given I am on the Kapruka login page
    When I collect all the links on the page
    Then none of the links should be broken
