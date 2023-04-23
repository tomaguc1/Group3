@tag
Feature: Implements an AI bot to play with

  @tag1
  Scenario: fore game
    Given That it is the AI turn
    And It is the second turn
    Then Place ships randomly on the board
    When all ships are placed
    Then end the fore game
    
    
  #Scenario: play the game
    #Given That it is the AI turn
    #Then shoots a missile randomly
    #When it misses the enemy ship
    #Then end turn
    
  #Scenario: play the game
    #Given That it is the AI turn
    #Then shoots a missile randomly
    #When it hits the enemy ship
    #Then shoot again
    