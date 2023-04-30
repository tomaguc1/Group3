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
    
