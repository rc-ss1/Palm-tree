Feature: Fetch wind, snow, seismic values from ATC API's

  @APIAutomationUsingRestAssured
  Scenario: Fetch wind, snow, seismic values from ATC API's

    When Get the codes and loads data for design load
    Then Codes and loads data updated successfully