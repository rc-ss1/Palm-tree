Feature: Login functionality for Kapruka website

  @LoginScenarioOutline
  Scenario Outline: Verify login with valid and invalid credentials
    When I login with the website1
    When I enter username "<username>" and password "<password>"
    And I click on the Login button
    Then I should see the appropriate login result

    Examples:
      | username             | password     |
      | validuser@gmail.com  | validpass    |
      | testuser@gmail.com   | testpass     |
      | invalid@gmail.com    | wrongpass    |