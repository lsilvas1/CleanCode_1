Feature: Game Rock, Paper, or Scissors

  Scenario: Testing different combination of the game
    Given the user will choose "rock"
    And the computer will choose "scissors"
    When they play
    Then the user wins


