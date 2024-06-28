Feature: Check UK visa is needed
  Checking the Visa requirement for the visitor in UK

  @test1
  Scenario Outline: When a visitor coming to UK for tourism ,doesn't require Visa
    Given User has visted the website
    And   User clicks the start now button
    And   User selects the "<country>" and continue
    And   User selects tourism for visiting the country and continue
    Then  User will not need a visa to come to the UK for tourism

    Examples:
      | country |
      |  Australia |
      #|   Chile     |


  Scenario Outline: When a visitor coming to UK for work for more than 6 months, they will require Visa
    Given User has visted the website
    And   User clicks the start now button
    And   User selects the "<country>" and continue
    And   User selects work as a purpose for visiting the country and continue
    And   User selects the "<jobType>" and continue
    And   User selects work duration more than 6 months
    Then  User confirms they require visa
    Then  User confirms "<noOfVisa>"  they are eligible for "<jobType>"

    Examples:
      | country    |  jobType                            |  noOfVisa |
      |   Chile    |    Health and care professional     |      8     |
      |   Chile    |    Digital technology professional  |       6    |
      |   Chile    |    Academic or researcher           |        7   |
     # |   Australia    |    Health and care professional     |      8     |
     # |   Australia    |    Digital technology professional  |       6    |
     # |  Australia    |    Academic or researcher           |        7   |


  Scenario Outline: When a visitor coming to UK join partner or family for more than 6 months, they may get family visa
    Given User has visted the website
    And   User clicks the start now button
    And   User selects the "<country>" and continue
    And   User selects join partner or family for a long stay as a purpose for visiting the country and continue
    And   User knows their  "<statusOfthePartner>" in UK
    Then  they may be eligible for family Visa


    Examples:
      | country       |  statusOfthePartner                           |
      |   Colombia    |    British citizen  |
      |   Colombia    |    settled in the UK   |
      |   Colombia    |     settled or pre-settled status under the EU Settlement Scheme  |
      |  Colombia     |     Turkish worker or businessperson visa      |
     # |   Chile     |    British citizen  |
     # |  Chile     |    settled in the UK   |
     # |   Chile     |     settled or pre-settled status under the EU Settlement Scheme  |
      #|  Chile      |     Turkish worker or businessperson visa      |


