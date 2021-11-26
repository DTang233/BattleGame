package battle;

/**
 * Battle interface represents each battle of the game.
 */
public interface Battle {

  /**
   * Assign players with gears.
   */
  void assignGears();

  /**
   * Assign weapons to players.
   */
  void assignWeapons();

  /**
   * Current player's turn to attack.
   */
  void attack();

  /**
   * Switch player.
   */
  void switchPlayer();

  /**
   * Get the winner of the game.
   * 
   * @return the winner of the game
   */
  String getWinner();

  /**
   * Get description of current battle.
   * 
   * @return the description of the player
   */
  String getBattleStatus();

  /**
   * Get information of current round.
   * 
   * @return information of current round
   */
  String getRoundInfo();

}
