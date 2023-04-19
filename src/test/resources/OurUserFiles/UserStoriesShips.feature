@tag
Feature: List of scenarios.

  @tag1
  Scenario Outline: Placing a ship
    Given A "<ShipType>"
    When I am placing the ship on the position "<positionX>" "<positionY>"
    Then There should be a ship on the initial position "<positionX>" "<positionY>" 
    Then There should be a ship on the final position  "<positionXEnd>" "<positionYEnd>"

    Examples: 
      | ShipType   |  positionX | positionY |positionXEnd | positionYEnd |
      | Carrier    |          1 |         1 | 5           | 1            |
      | BattleShip |         1  |         1 |4            |1             |
      | Destroyer  |        1   |         1 |1            | 3            |
      | Submarine  |          1 |         1 |1            |2             |
      | Patrol     |          1 |         1 |1            |1             |
      
      
  @tag2
  Scenario Outline: Iterating between players setting ships 
  Given Two players: "<PlayerA>" and "<PlayerB>"
	When "<PlayerA>" is finished with setting his ships
	Then "<PlayerB>" can set his ships
  
  
  
 
