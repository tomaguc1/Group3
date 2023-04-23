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
      | Test       |          1 |         1 |2           |2            |
      
   @tag2
   Scenario Outline: Trying to add more than 5 ships
   Given A player with 5 ships
   When He tries to add another ship
   Then He still only has 5 ships
   
      
  @tag3
  Scenario Outline: Iterating between players setting ships 
  Given Two players: "1" and "2"
	When "1" is finished
	Then "1" has 5 ships
	Then "2" can set his ships
  
  @tag4
  Scenario Outline: Iterating between players setting ships 
  Given Two players: "1" and "2"
	When "2" is finished
	Then "2" has 5 ships
	Then "1" can set his ships
  
  @tag5
  Scenario Outline: Succesfull attack
  Given Player "1" board view 
  Given there is a ship on the position "1" "1"
  When "1" makes a move on the position "1" "1" 
  Then "1" can make another move 
  
  @tag6
  Scenario Outline: Unsuccesfull attack
  Given Player "1" board view 
  Given there is ocean on the position "1" "1"
  When "1" makes a move on the position "1" "1"
  Then it is player "2" turn
  
  @tag7
  #Scenario Outline: Unsuccesfull attack
  #Given Player "1" board view 
  #Given there is an obstacle on the position "1" "1"
  #When "1" makes a move on the position "1" "1"
  #Then it is player "2" turn
  
  @tag8
  Scenario Outline: Game ending
  Given Player "1" has 10 successful moves
  Then Player "1" is the winner
  Then The game ends 
  
  @tag9
  Scenario Outline: Setting a ship on top of the other
  Given Player "1" turn
  When there is a ship already on the position "1" "1"
  When "1" sets a ship on the position "1" "1"
  Then the ship does not stay on the position "1" "1"
  Then "1" needs to try again
  
  #@tag10
  #Scenario Outline: Setting a ship out of bounds
 # Given Player "1" board view 
 # When "1" sets a ship on the position "9" "9"
 # When The ship does not fit on the board if placed on "9" "9"
  #Then the ship does not stay on the position "9" "9"
  #Then "1" needs to try again
 
