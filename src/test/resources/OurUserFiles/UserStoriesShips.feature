@tag
Feature: List of scenarios.


  @tag1
  Scenario Outline: Placing a ship
    Given A "<ShipType>" ship with "<length>"
    And direction "<direction>"
    When I am placing the ship on the position "<positionX>" "<positionY>"
    Then The ship is displayed on the board

    Examples: 
      | ShipType   | length | direction  | positionX | positionY |
      | Carrier    |     5  | VERTICAL   | 1         | 1         |
      | BattleShip |     4  | VERTICAL   | 1         | 1         |
      | Destroyer  |     3  | HORIZONTAL | 1         | 1         |
      | Submarine  |     2  | HORIZONTAL | 1         | 1         |
      | Patrol     |     1  | VERTICAL   | 1         | 1         |
      
@tag2
Scenario Outline: Succesfull attack
	Given My board
	When I am choosing the position to attack "<positionX>" "<positionY>"
	Then A bomb falls there

@tag3
Scenario Outline: