@tag
Feature: List of scenarios.

  
  #@tag1
 # Scenario Outline: Placing a ship
   # Given A "<ShipType>"
    #When I am placing the ship on the position "<positionX>" "<positionY>"
    #Then There should be a ship on the initial position "<positionX>" "<positionY>" 
   # Then There should be a ship on the final position  "<positionXEnd>" "<positionYEnd>"

    #Examples: 
    #  | ShipType   |  positionX | positionY |positionXEnd | positionYEnd |
    #  | Carrier    |          1 |         1 | 5           | 1            |
     # | BattleShip |         1  |         1 |4            |1             |
    #  | Destroyer  |        1   |         1 |1            | 3            |
     # | Submarine  |          1 |         1 |1            |2             |
    #  | Patrol     |          1 |         1 |1            |1             |
      
     
  @tag1
  Scenario Outline: Picking a ship
  Given Player 1 with some ships
  When 1 chooses to place a "Ship" of length
  Then Has the appropiate length

  
  Examples:
  | ShipType   |  length  |
  | Carrier    |     5    |
  | BattleShip |     4    |
  | Destroyer  |     3    |
  | Submarine  |     2    |
  
  @tag2
  Scenario Outline: Placing a ship
  Given Player "1" board view
  When places on the position 2 2
  Then there should be a ship on the positon 2 2
 	
 	Examples:
 	| ShipType   |
 	| Carrier    |
  | BattleShip |
  | Destroyer  |
  | Submarine  |
  
  @tag3
  Scenario Outline: Health check
  Given "ShipElelment" on the position 1 1 with health 1
  When It was hit by a move on the position 1 1
  Then the health is 0
  
 
