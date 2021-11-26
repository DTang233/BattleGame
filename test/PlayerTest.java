import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import gear.Gear;
import gear.GearImpl;
import gear.GearType;
import player.Player;
import player.PlayerImpl;
import weapon.Weapon;
import weapon.WeaponImpl;
import weapon.WeaponType;

/**
 * Tests of Player class.
 */
public class PlayerTest {

  private Player player;

  private Gear headgear;
  private Gear belt;
  private Gear footwear;
  private Gear potion;
  private List<Gear> gears;
  private Weapon weapon;

  @Before
  public void setUp() {

    player = new PlayerImpl();

    gears = new ArrayList<>();

    headgear = new GearImpl(0, 0, 5, 0, 0, 100, GearType.HEADGEAR);
    belt = new GearImpl(0, 5, 0, 0, 5, 100, GearType.BELTSMEDIUM);
    footwear = new GearImpl(0, 0, 0, 5, 0, 100, GearType.FOOTWEAR);
    potion = new GearImpl(5, 5, 5, 5, 5, 5, GearType.PORION);
    weapon = new WeaponImpl(WeaponType.AXES);

    gears.add(headgear);
    gears.add(belt);
    gears.add(footwear);
    gears.add(potion);

  }

  @Test
  public void testInitialize() {

    assertEquals(
        "Basic Abilities: \n" + " - Health: 52\n" + " - Strength: 13\n" + " - Constitution: 13\n"
            + " - Dexterity: 13\n" + " - Charisma: 13\n" + "Gear Info: \n",
        player.getDescription());

  }

  @Test
  public void testReveiveGear() {
    player.receiveGears(gears);
    assertEquals(
        "BELTSMEDIUM\n" + "Position in my bag: 1\n" + " - Effect On Health: 0\n"
            + " - Effect On Constitution: 0\n" + " - Effect On Strength: 5\n"
            + " - Effect On Charisma: 5\n" + " - Effect On Dexterity: 0\n" + "\n" + "FOOTWEAR\n"
            + "Position in my bag: 2\n" + " - Effect On Health: 0\n"
            + " - Effect On Constitution: 0\n" + " - Effect On Strength: 0\n"
            + " - Effect On Charisma: 0\n" + " - Effect On Dexterity: 5\n" + "\n" + "HEADGEAR\n"
            + "Position in my bag: 0\n" + " - Effect On Health: 0\n"
            + " - Effect On Constitution: 5\n" + " - Effect On Strength: 0\n"
            + " - Effect On Charisma: 0\n" + " - Effect On Dexterity: 0\n" + "\n" + "PORION\n"
            + "Position in my bag: 3\n" + " - Effect On Health: 5\n"
            + " - Effect On Constitution: 5\n" + " - Effect On Strength: 5\n"
            + " - Effect On Charisma: 5\n" + " - Effect On Dexterity: 5" + "\n\n",
        player.getMyBagInfo());

  }

  @Test
  public void testEquipGear() {
    player.receiveGears(gears);
    player.equipGears(headgear, belt, potion, footwear);
    assertEquals("", player.getMyBagInfo());
    assertEquals(
        "Basic Abilities: \n" + " - Health: 57\n" + " - Strength: 23\n" + " - Constitution: 23\n"
            + " - Dexterity: 23\n" + " - Charisma: 23\n" + "Gear Info: \n" + " - HEADGEAR\n"
            + "  + Effect On Constitution: 5\n" + " - PORION \n" + "  + Effect On Health: 5\n"
            + "  + Effect On Constitution: 5\n" + "  + Effect On Strength: 5\n"
            + "  + Effect On Charisma: 5\n" + "  + Effect On Dexterity: 5\n" + "  + Duration: 5\n"
            + " - BELTSMEDIUM\n" + "  + Effect On Strength: 5\n" + "  + Effect On Charisma: 5\n"
            + "\n" + " - FOOTWEAR\n" + "  + Effect On Dexterity: 5" + "\n",
        player.getDescription());

  }

  @Test
  public void testHealth() {
    player.updateHealth(10);
    assertEquals(62, player.getHealth());
    player.updateHealth(-63);
    assertEquals(-1, player.getHealth());

  }

  @Test
  public void testStrength() {
    player.updateStrength(10);
    assertEquals(23, player.getStrength());

  }

  @Test
  public void testConstitution() {
    player.updateConstitution(10);
    assertEquals(23, player.getConstitution());

  }

  @Test
  public void testDexterity() {
    player.updateDexterity(10);
    assertEquals(23, player.getDexterity());

  }

  @Test
  public void testCharisma() {
    player.updateCharisma(10);
    assertEquals(23, player.getCharisma());

  }

  @Test
  public void updatePotionsEffect() {
    List<Gear> gear = new ArrayList<>();
    gear.add(potion);
    player.receiveGears(gear);
    player.equipGears(potion);
    System.out.print(player.getDescription());
    assertEquals("Basic Abilities: \n" + " - Health: 57\n" + " - Strength: 18\n"
        + " - Constitution: 18\n" + " - Dexterity: 18\n" + " - Charisma: 18\n" + "Gear Info: \n"
        + " - PORION \n" + "  + Effect On Health: 5\n" + "  + Effect On Constitution: 5\n"
        + "  + Effect On Strength: 5\n" + "  + Effect On Charisma: 5\n"
        + "  + Effect On Dexterity: 5\n" + "  + Duration: 5" + "\n", player.getDescription());
    player.updatePotionsEffect();
    assertEquals("Basic Abilities: \n" + " - Health: 57\n" + " - Strength: 18\n"
        + " - Constitution: 18\n" + " - Dexterity: 18\n" + " - Charisma: 18\n" + "Gear Info: \n"
        + " - PORION \n" + "  + Effect On Health: 5\n" + "  + Effect On Constitution: 5\n"
        + "  + Effect On Strength: 5\n" + "  + Effect On Charisma: 5\n"
        + "  + Effect On Dexterity: 5\n" + "  + Duration: 4" + "\n", player.getDescription());
    player.updatePotionsEffect();
    player.updatePotionsEffect();
    player.updatePotionsEffect();
    player.updatePotionsEffect();
    assertEquals(
        "Basic Abilities: \n" + " - Health: 52\n" + " - Strength: 13\n" + " - Constitution: 13\n"
            + " - Dexterity: 13\n" + " - Charisma: 13\n" + "Gear Info: " + "\n",
        player.getDescription());

  }

  @Test
  public void testWeapon() {

    player.updateWeapon(weapon);
    assertEquals(WeaponType.AXES, player.getWeaponType());
    assertEquals(10, player.getWeaponDamage());

  }

}
