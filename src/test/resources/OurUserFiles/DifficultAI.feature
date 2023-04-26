
@tag
Feature: DifficultAI

  @tag1
  Scenario: DifficultAI places ships
    Given Player 1 has set ships
    And It is the turn of the DiffultAI
    When DifficultAI places ships
    Then The ships should appear on the board


