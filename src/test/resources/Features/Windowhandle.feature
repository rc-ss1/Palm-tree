Feature: Window handle management
  Scenario: Open a new window, verify it, close it and return to parent
    Given I open the sample page that opens new windows
    When I click the link that opens a new window
    Then a new window should open
    And I switch to the new window and verify the title contains "Example Domain"
    When I close the child window and switch back
    Then only the parent window should remain
