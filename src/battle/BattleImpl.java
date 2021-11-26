package battle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import player.Player;
import gear.GearImpl;
import gear.Gear;
import gear.GearType;
import weapon.Weapon;
import weapon.WeaponImpl;
import weapon.WeaponType;

/**
 * The class implements Battle interface.
 */
public class BattleImpl implements Battle {

  private Player player1;
  private Player player2;
  private boolean isPlayer1sTurn;
  private List<Gear> headgears;
  private List<Gear> footwears;
  private List<Gear> belts;
  private List<Gear> potions;
  private List<Weapon> weapons;
  private boolean isGameOver;
  private String roundInfo;

  private final int numOfHeadGear;
  private final int numOfFootwears;
  private final int numOfBelts;
  private final int numOfPotions;

  /**
   * Constructs a Battle with given players, initialize the available gears and
   * weapons in the bag.
   * 
   * @param player1 the first player
   * @param player2 the second player
   * @throws IllegalArgumentException if player object is null
   */
  public BattleImpl(Player player1, Player player2) throws IllegalArgumentException {

    if (Objects.isNull(player1) || Objects.isNull(player2)) {
      throw new IllegalArgumentException("Player cannot be null!");

    }
    this.player1 = player1;
    this.player2 = player2;

    this.isPlayer1sTurn = this.player1.getCharisma() >= this.player2.getCharisma() ? true : false;

    this.numOfHeadGear = 5;
    this.numOfFootwears = 5;
    this.numOfBelts = 15;
    this.numOfPotions = 15;

    this.headgears = new ArrayList<>();
    this.footwears = new ArrayList<>();
    this.belts = new ArrayList<>();
    this.potions = new ArrayList<>();

    for (int i = 1; i <= this.numOfHeadGear; i++) {
      Gear headgear = generateHeadgear(i);
      this.headgears.add(headgear);
    }

    for (int i = 1; i <= this.numOfFootwears; i++) {
      Gear footwear = generateFootwears(i);
      this.footwears.add(footwear);
    }

    for (int i = 1; i <= this.numOfBelts; i++) {
      Gear belt = generateBelt(i);
      this.belts.add(belt);
    }

    for (int i = 1; i <= this.numOfPotions; i++) {
      Gear potion = generatePotion(i);
      this.potions.add(potion);
    }

    this.weapons = generateWeapons();

  }

  @Override
  public void assignGears() {

    List<Gear> bag = new ArrayList<>();

    while (!this.headgears.isEmpty()) {
      int size = this.headgears.size();
      bag.add(this.headgears.remove(randomNumber(0, size - 1)));
    }

    while (!this.belts.isEmpty()) {
      int size = this.headgears.size();
      bag.add(this.belts.remove(randomNumber(0, size - 1)));
    }

    while (!this.footwears.isEmpty()) {
      int size = this.headgears.size();
      bag.add(this.footwears.remove(randomNumber(0, size - 1)));
    }

    while (!this.potions.isEmpty()) {
      int size = this.headgears.size();
      bag.add(this.potions.remove(randomNumber(0, size - 1)));
    }

    // Assign gears
    int total = this.numOfBelts + this.numOfFootwears + this.numOfHeadGear + this.numOfPotions;
    List<Gear> bag1 = new ArrayList<>();
    List<Gear> bag2 = new ArrayList<>();
    for (int i = 0; i < total; i++) {
      if (i % 2 == 0) {
        bag1.add(bag.get(i));
      } else {
        bag2.add(bag.get(i));
      }

    }

    this.player1.receiveGears(bag1);
    this.player2.receiveGears(bag2);

  }

  @Override
  public void assignWeapons() {
    this.player1.updateWeapon(this.weapons.get(randomNumber(0, this.weapons.size() - 1)));
    this.player2.updateWeapon(this.weapons.get(randomNumber(0, this.weapons.size() - 1)));
  }

  @Override
  public void switchPlayer() {

    this.player1.updatePotionsEffect();
    this.player2.updatePotionsEffect();

    if (this.isPlayer1sTurn) {
      this.isPlayer1sTurn = false;

    } else {
      this.isPlayer1sTurn = true;

    }

  }

  @Override
  public String getWinner() {
    if (this.player1.getHealth() <= 0 && this.player2.getHealth() <= 0) {
      return "This is a tie!";
    } else if (this.player1.getHealth() <= 0) {
      return "Player2 won the game!";
    } else if (this.player2.getHealth() <= 0) {
      return "Player1 won the game!";
    }
    return "No winner yet!";
  }

  @Override
  public String getBattleStatus() {
    StringBuilder res = new StringBuilder();
    res.append("Player1's info: \n");
    res.append(this.player1.getDescription() + "\n" + "\n");
    res.append("Player2's info: \n");
    res.append(this.player2.getDescription());

    return res.toString();
  }

  @Override
  public void attack() throws IllegalStateException {
    if (this.isGameOver) {
      throw new IllegalStateException("Already game over!");
    }

    this.roundInfo = "";
    StringBuilder info = new StringBuilder();

    Player attackingPlayer;
    Player defensePlayer;

    if (this.isPlayer1sTurn) {
      attackingPlayer = this.player1;
      defensePlayer = this.player2;
      info.append("Player1's turn to attack!" + "\n");
    } else {
      attackingPlayer = this.player2;
      defensePlayer = this.player1;
      info.append("Player2's turn to attack!" + "\n");

    }

    int strikingPower = calcStrikingPower(attackingPlayer);
    int avoidanceAbility = calcAvoidanceAbility(defensePlayer);

    int damageTook = 0;
    if (strikingPower > avoidanceAbility) {
      int potentialStrikingDamage = calcPotentialStrikingDamage(attackingPlayer);
      int actualDamage = potentialStrikingDamage - defensePlayer.getConstitution();
      if (actualDamage > 0) {
        damageTook = actualDamage;
        defensePlayer.updateHealth(-actualDamage);
        if (defensePlayer.getHealth() <= 0) {
          this.isGameOver = true;
        }
      }

    }
    info.append("The attacker caused " + damageTook + " points damage!" + "\n");
    info.append("The opponent has " + defensePlayer.getHealth() + " points health left!" + "\n");
    if (this.isGameOver) {

      info.append("Game Over!");
    }
    this.roundInfo = info.toString();

  }

  @Override
  public String getRoundInfo() {

    return this.roundInfo;
  }

  private int calcStrikingPower(Player player) {

    // Amplification of strength
    int strengthAmplifier = randomNumber(1, 10);
    return player.getStrength() + strengthAmplifier;

  }

  private int calcAvoidanceAbility(Player player) {

    // Amplification of dexterity
    int dexterityAmplifier = randomNumber(1, 6);
    return player.getDexterity() + dexterityAmplifier;

  }

  private int calcPotentialStrikingDamage(Player player) {

    // Loss of weapon damage
    int lossOfWeaponDamage = randomNumber(0, 4);
    int weaponDamage = 0;

    if (player.getWeaponType() == WeaponType.KATANAS) {
      lossOfWeaponDamage = randomNumber(0, 2);
      weaponDamage = 2 * (player.getWeaponDamage() - lossOfWeaponDamage);
    } else if (player.getWeaponType() == WeaponType.BROADSWORD
        || player.getWeaponType() == WeaponType.AXES) {
      weaponDamage = player.getWeaponDamage() - lossOfWeaponDamage;
    } else if (player.getWeaponType() == WeaponType.TWOHANDEDSWORD) {
      weaponDamage = player.getStrength() > 14 ? (player.getWeaponDamage() - lossOfWeaponDamage)
          : (player.getWeaponDamage() - lossOfWeaponDamage) / 2;
    } else if (player.getWeaponType() == WeaponType.FLAILS) {
      weaponDamage = player.getDexterity() > 14 ? (player.getWeaponDamage() - lossOfWeaponDamage)
          : (player.getWeaponDamage() - lossOfWeaponDamage) / 2;

    }

    return player.getStrength() + weaponDamage;

  }

  private Gear generateHeadgear(int value) {
    Gear gear = new GearImpl(0, 0, value, 0, 0, 100, GearType.HEADGEAR);
    return gear;
  }

  private Gear generateFootwears(int value) {
    Gear gear = new GearImpl(0, 0, 0, value, 0, 100, GearType.FOOTWEAR);
    return gear;
  }

  private Gear generateBelt(int value) {
    GearType type;
    if (value < this.numOfBelts / 3) {
      type = GearType.BELTSSMALL;

    } else if (this.numOfBelts / 3 <= value && value < (this.numOfBelts / 3) * 2) {
      type = GearType.BELTSMEDIUM;

    } else {
      type = GearType.BELTSLARGE;
    }

    Gear gear = new GearImpl(0, value, 0, 0, value, 100, type);
    return gear;
  }

  private Gear generatePotion(int value) {
    Gear gear = new GearImpl(value, value, value, value, value, value, GearType.PORION);
    return gear;
  }

  private List<Weapon> generateWeapons() {

    Weapon katanas1 = new WeaponImpl(WeaponType.KATANAS);
    Weapon katanas2 = new WeaponImpl(WeaponType.KATANAS);
    Weapon broadSwords = new WeaponImpl(WeaponType.BROADSWORD);
    Weapon twoHandedSwords = new WeaponImpl(WeaponType.TWOHANDEDSWORD);
    Weapon axes = new WeaponImpl(WeaponType.AXES);
    Weapon flails = new WeaponImpl(WeaponType.FLAILS);

    List<Weapon> weapons = new ArrayList<Weapon>(
        Arrays.asList(katanas1, katanas2, broadSwords, twoHandedSwords, axes, flails));

    return weapons;
  }

  private int randomNumber(int min, int max) {

    return min + (int) (Math.random() * ((max - min) + 1));
  }

}
