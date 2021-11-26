import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import battle.Battle;
import battle.BattleImpl;
import player.Player;
import player.PlayerImpl;

/**
 * Test of Battle class.
 */
public class BattleTest {
  private Battle battle;
  private Player p1;
  private Player p2;

  @Before
  public void setUp() {
    p1 = new PlayerImpl();
    p2 = new PlayerImpl();
    battle = new BattleImpl(p1, p2);

  }

  @Test
  public void testBattle() {

    battle.assignGears();
    // Test assigned gear successfully
    assertEquals(20, p1.getGearsInMyBag().size());
    assertEquals(20, p2.getGearsInMyBag().size());
    assertEquals("Player1's info: \n" + "Basic Abilities: \n" + " - Health: 52\n"
        + " - Strength: 13\n" + " - Constitution: 13\n" + " - Dexterity: 13\n" + " - Charisma: 13\n"
        + "Gear Info: \n" + "\n" + "\n" + "Player2's info: \n" + "Basic Abilities: \n"
        + " - Health: 52\n" + " - Strength: 13\n" + " - Constitution: 13\n" + " - Dexterity: 13\n"
        + " - Charisma: 13\n" + "Gear Info: " + "\n", battle.getBattleStatus());

    // Test equip gear successfully
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
    assertEquals("Player1's info: \n" + "Basic Abilities: \n" + " - Health: 121\n"
        + " - Strength: 116\n" + " - Constitution: 77\n" + " - Dexterity: 87\n"
        + " - Charisma: 116\n" + "Gear Info: \n" + " - HEADGEAR\n"
        + "  + Effect On Constitution: 5\n" + " - PORION \n" + "  + Effect On Health: 7\n"
        + "  + Effect On Constitution: 7\n" + "  + Effect On Strength: 7\n"
        + "  + Effect On Charisma: 7\n" + "  + Effect On Dexterity: 7\n" + "  + Duration: 7\n"
        + " - PORION \n" + "  + Effect On Health: 10\n" + "  + Effect On Constitution: 10\n"
        + "  + Effect On Strength: 10\n" + "  + Effect On Charisma: 10\n"
        + "  + Effect On Dexterity: 10\n" + "  + Duration: 10\n" + " - PORION \n"
        + "  + Effect On Health: 6\n" + "  + Effect On Constitution: 6\n"
        + "  + Effect On Strength: 6\n" + "  + Effect On Charisma: 6\n"
        + "  + Effect On Dexterity: 6\n" + "  + Duration: 6\n" + " - PORION \n"
        + "  + Effect On Health: 8\n" + "  + Effect On Constitution: 8\n"
        + "  + Effect On Strength: 8\n" + "  + Effect On Charisma: 8\n"
        + "  + Effect On Dexterity: 8\n" + "  + Duration: 8\n" + " - PORION \n"
        + "  + Effect On Health: 11\n" + "  + Effect On Constitution: 11\n"
        + "  + Effect On Strength: 11\n" + "  + Effect On Charisma: 11\n"
        + "  + Effect On Dexterity: 11\n" + "  + Duration: 11\n" + " - PORION \n"
        + "  + Effect On Health: 12\n" + "  + Effect On Constitution: 12\n"
        + "  + Effect On Strength: 12\n" + "  + Effect On Charisma: 12\n"
        + "  + Effect On Dexterity: 12\n" + "  + Duration: 12\n" + " - PORION \n"
        + "  + Effect On Health: 15\n" + "  + Effect On Constitution: 15\n"
        + "  + Effect On Strength: 15\n" + "  + Effect On Charisma: 15\n"
        + "  + Effect On Dexterity: 15\n" + "  + Duration: 15\n" + " - BELTSLARGE\n"
        + "  + Effect On Strength: 12\n" + "  + Effect On Charisma: 12\n" + "\n" + " - BELTSLARGE\n"
        + "  + Effect On Strength: 15\n" + "  + Effect On Charisma: 15\n" + "\n"
        + " - BELTSMEDIUM\n" + "  + Effect On Strength: 7\n" + "  + Effect On Charisma: 7\n" + "\n"
        + " - FOOTWEAR\n" + "  + Effect On Dexterity: 5\n" + "\n" + "\n" + "Player2's info: \n"
        + "Basic Abilities: \n" + " - Health: 103\n" + " - Strength: 100\n"
        + " - Constitution: 55\n" + " - Dexterity: 67\n" + " - Charisma: 100\n" + "Gear Info: \n"
        + " - HEADGEAR\n" + "  + Effect On Constitution: 1\n" + " - PORION \n"
        + "  + Effect On Health: 5\n" + "  + Effect On Constitution: 5\n"
        + "  + Effect On Strength: 5\n" + "  + Effect On Charisma: 5\n"
        + "  + Effect On Dexterity: 5\n" + "  + Duration: 5\n" + " - PORION \n"
        + "  + Effect On Health: 9\n" + "  + Effect On Constitution: 9\n"
        + "  + Effect On Strength: 9\n" + "  + Effect On Charisma: 9\n"
        + "  + Effect On Dexterity: 9\n" + "  + Duration: 9\n" + " - PORION \n"
        + "  + Effect On Health: 13\n" + "  + Effect On Constitution: 13\n"
        + "  + Effect On Strength: 13\n" + "  + Effect On Charisma: 13\n"
        + "  + Effect On Dexterity: 13\n" + "  + Duration: 13\n" + " - PORION \n"
        + "  + Effect On Health: 3\n" + "  + Effect On Constitution: 3\n"
        + "  + Effect On Strength: 3\n" + "  + Effect On Charisma: 3\n"
        + "  + Effect On Dexterity: 3\n" + "  + Duration: 3\n" + " - PORION \n"
        + "  + Effect On Health: 14\n" + "  + Effect On Constitution: 14\n"
        + "  + Effect On Strength: 14\n" + "  + Effect On Charisma: 14\n"
        + "  + Effect On Dexterity: 14\n" + "  + Duration: 14\n" + " - PORION \n"
        + "  + Effect On Health: 2\n" + "  + Effect On Constitution: 2\n"
        + "  + Effect On Strength: 2\n" + "  + Effect On Charisma: 2\n"
        + "  + Effect On Dexterity: 2\n" + "  + Duration: 2\n" + " - PORION \n"
        + "  + Effect On Health: 4\n" + "  + Effect On Constitution: 4\n"
        + "  + Effect On Strength: 4\n" + "  + Effect On Charisma: 4\n"
        + "  + Effect On Dexterity: 4\n" + "  + Duration: 4\n" + " - PORION \n"
        + "  + Effect On Health: 1\n" + "  + Effect On Constitution: 1\n"
        + "  + Effect On Strength: 1\n" + "  + Effect On Charisma: 1\n"
        + "  + Effect On Dexterity: 1\n" + "  + Duration: 1\n" + " - BELTSLARGE\n"
        + "  + Effect On Strength: 13\n" + "  + Effect On Charisma: 13\n" + "\n" + " - BELTSLARGE\n"
        + "  + Effect On Strength: 14\n" + "  + Effect On Charisma: 14\n" + "\n"
        + " - BELTSMEDIUM\n" + "  + Effect On Strength: 9\n" + "  + Effect On Charisma: 9\n" + "\n"
        + " - FOOTWEAR\n" + "  + Effect On Dexterity: 3" + "\n", battle.getBattleStatus());

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

  }

  @Test(expected = IllegalArgumentException.class)
  public void testBattleInitialize() {
    battle = new BattleImpl(null, null);
  }
}
