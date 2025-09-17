Feature: HTTPS Certificate Handling
  As an automation tester
  I want to handle SSL certificate errors
  So that I can test websites with invalid certificates

  @HTTPSCertificate
  Scenario Outline: Verify access to HTTPS sites with certificate issues
    Given I launch the browser with SSL handling enabled
    When I open the URL "<site>"
    Then I should be able to see the page title

    Examples:
      | site                           |
      | https://self-signed.badssl.com |
      | https://expired.badssl.com     |
