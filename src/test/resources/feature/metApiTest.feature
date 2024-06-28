Feature: Find the weather forecast for a location from Met Office DataPoint API


  @test1
  Scenario Outline:  User request for the sitelist endpoint in Met Office DataPoint
     When    User request for the sitelist endpoint to find the location Id for the "<location>"
     Then    User find  weather  info for that location Id by requesting weather API
     Then     User assert the "<location>" is correct
     And     the parameter with name S has a description of wind speed
    Examples:
      | location |
      |  Croydon |
