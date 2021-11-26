package driver;

import java.util.Scanner;

import battle.Battle;
import battle.BattleImpl;
import player.Player;
import player.PlayerImpl;

/**
 * The class runs the battle.
 */
public class Driver {
  /**
   * One possible running case.
   */
  public static void main(String[] args) {
    System.out.println("Start a new Battle! \n");
    Player p1 = new PlayerImpl();
    Player p2 = new PlayerImpl();
    Battle battle = new BattleImpl(p1, p2);
    System.out.println(battle.getBattleStatus());
    System.out.println("Assign gears to players. \n");
    battle.assignGears();
    System.out.println(p1.getMyBagInfo());
    System.out.println(p2.getMyBagInfo());
    System.out.println("Players can now choose gears to equip, enter "
        + "the gear with right position in your bag. \n");
    p1.equipGears(p1.getGearsInMyBag().get(8), p1.getGearsInMyBag().get(9),
        p1.getGearsInMyBag().get(3), p1.getGearsInMyBag().get(6), p1.getGearsInMyBag().get(11),
        p1.getGearsInMyBag().get(1), p1.getGearsInMyBag().get(13), p1.getGearsInMyBag().get(14),
        p1.getGearsInMyBag().get(15), p1.getGearsInMyBag().get(16), p1.getGearsInMyBag().get(17),
        p1.getGearsInMyBag().get(18), p1.getGearsInMyBag().get(19));

    p2.equipGears(p2.getGearsInMyBag().get(4), p2.getGearsInMyBag().get(6),
        p2.getGearsInMyBag().get(3), p2.getGearsInMyBag().get(10), p2.getGearsInMyBag().get(0),
        p2.getGearsInMyBag().get(1), p2.getGearsInMyBag().get(12), p2.getGearsInMyBag().get(13),
        p2.getGearsInMyBag().get(14), p2.getGearsInMyBag().get(15), p2.getGearsInMyBag().get(16),
        p2.getGearsInMyBag().get(17), p2.getGearsInMyBag().get(18), p2.getGearsInMyBag().get(19));
    System.out.println("Now assign weapons! \n");
    battle.assignWeapons();
    System.out.println(battle.getBattleStatus());
    System.out.println("Now Battle begins! \n");

    try {
      battle.attack();
      System.out.println(battle.getRoundInfo());
    } catch (IllegalStateException e) {
      System.out.println("Already Game Over!");
      System.out.println(battle.getWinner());
    }
    battle.switchPlayer();

    try {
      battle.attack();
      System.out.println(battle.getRoundInfo());
    } catch (IllegalStateException e) {
      System.out.println("Already Game Over!");
      System.out.println(battle.getWinner());
    }
    battle.switchPlayer();

    try {
      battle.attack();
      System.out.println(battle.getRoundInfo());
    } catch (IllegalStateException e) {
      System.out.println("Already Game Over!");
      System.out.println(battle.getWinner());
    }
    battle.switchPlayer();

    try {
      battle.attack();
      System.out.println(battle.getRoundInfo());
    } catch (IllegalStateException e) {
      System.out.println("Already Game Over!");
      System.out.println(battle.getWinner());
    }
    battle.switchPlayer();

    try {
      battle.attack();
      System.out.println(battle.getRoundInfo());
    } catch (IllegalStateException e) {
      System.out.println("Already Game Over!");
      System.out.println(battle.getWinner());
    }
    battle.switchPlayer();

    try {
      battle.attack();
      System.out.println(battle.getRoundInfo());
    } catch (IllegalStateException e) {
      System.out.println("Already Game Over!");
      System.out.println(battle.getWinner());
    }
    battle.switchPlayer();

    try {
      battle.attack();
      System.out.println(battle.getRoundInfo());
    } catch (IllegalStateException e) {
      System.out.println("Already Game Over!");
      System.out.println(battle.getWinner());
    }
    battle.switchPlayer();

    System.out.println("\n\n Replay the game? \n");
    Scanner scan = new Scanner(System.in);

    System.out.println("Enter 'Y' to replay. \n");
    String s = scan.nextLine();

    if (s.equals("Y")) {
      Driver.main(null);
      scan.close();

    }

  }

}
