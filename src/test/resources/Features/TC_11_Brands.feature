Feature: Get all brand names from Kapruka brands page

  @Brands
  Scenario: Extract and validate brand names
    Given I open the Kapruka brands page
    When I extract all brand names
    Then I should see at least one brand displayed
