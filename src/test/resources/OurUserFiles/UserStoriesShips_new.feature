@tag
Feature: List of scenarios.
     
 @tag1
  Scenario Outline: Picking a ship
  Given Player 1 board view
  When "1" chooses to place a "<ShipType>"
  Then "<ShipType>" has the length "<length>"
  
  Examples:
  | ShipType   |  length  |
  | Carrier    |     5    |
  | BattleShip |     4    |
  | Destroyer  |     3    |
  | Submarine  |     2    |
  
 @tag2
   Scenario: Placing a ship
   
   Given Player "1" board view
   When "1" places "carrier"  on the position 2 2
   When "1" places "<ShipType>"  on the position 2 2
   Then there should be a ship on the initial positon 2 2


  	Examples:
   | ShipType   |
   | Carrier    |
   | BattleShip |
   | Destroyer  |
   | Submarine  |


  @tag3
  Scenario Outline: Health check
  Given "<ShipType>" on the position 1 1 with health 1
 	When It was hit by a move on the position 1 1
  Then the health is 0
  
 	Examples:
   | ShipType   |
   | Carrier    |
   | BattleShip |
   | Destroyer  |
   | Submarine  |
   
   @tag4
   Scenario: Overlapping ships
   Given Two ships "<ShipType>" and "<ShipType>"
   When "<ShipType>" is placed on the position 1 1
   When The "<ShipType>" is placed on the position 2 1
   Then the overlap method should return true 
    
   	Examples:
   | ShipType   |
   | Carrier    |
   | BattleShip |
   | Destroyer  |
   | Submarine  |
   
   @tag5
   Scenario: Check if a ship is in bounds of the game board
    Given "<ShipType>" on the position 1 1
    When I check if the ship is in bounds
    Then the player should be allowed to place it and the method returns true
    
    Examples:
   | ShipType   |
   | Carrier    |
   | BattleShip |
   | Destroyer  |
   | Submarine  |
   
   @tag6
   Scenario: Create Board object with default constructor
	Given a Board object is created
	Then the board array should be initialized with 10x10 WaterElement objects

@tag7
Scenario: Set Ship on the Board
Given a Board object is created with default constructor
And a Position and a Ship object is provided
When the setShip method is called with the Position and Ship object
Then the Ship object should be set at the positions on the Board
  
  @tag8
  Scenario: Get Health of all Ships on the Board
Given a Board object is created with 5 ships
Then the total health of all the ships on the Board equal to 5     

@tag9
Scenario: Rotate a Ship object
Given a Ship object is created
When the object is rotated
Then the object direction should be updated
#As a player,
#I want to be able to get all the positions that a Ship takes up on the board,
#So that I can ensure that the Ship is placed correctly.
@tag10
Scenario: Get all positions of a Ship
Given a ship "carrier" is created
When the objects direction is set 
When the position of the ship is set 1 1
Then the function should return a list of all the positions that the Ship takes up on the board.

#@tag11
#Scenario: Check if two Ships do not overlap
#Given Two ships "carrier" and "submarine" are placed
#When The "carrier" is being placed on the position 1 1
#When The "submarine" is placed on the position 5 3
#Then the overlap method should return false
