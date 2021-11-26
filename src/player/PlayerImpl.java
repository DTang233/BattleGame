package player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import gear.Gear;
import gear.GearType;
import weapon.Weapon;
import weapon.WeaponType;

/**
 * The class implements Player interface.
 */
public class PlayerImpl implements Player {

  private int health;
  private int strength;
  private int constitution;
  private int dexterity;
  private int charisma;

  private Gear headGear;
  private Gear footWears;
  private List<Gear> belts;
  private List<Gear> potions;
  private Weapon weapon;

  private int unitsLeft;
  private List<Gear> myBag;

  /**
   * Constructs a Player with basic abilities. Player basic abilities are each
   * determined randomly by rolling four 6-sided dice, re-rolling any 1s, and then
   * adding together the highest 3 values resulting in values between 6 and 18,
   * and then assigned to 4 categories.
   */
  public PlayerImpl() {

    int total = 0;
    for (int i = 0; i < 3; i++) {
      int randNum = randomNumber(1, 6);
      while (randNum == 1) {
        randNum = randomNumber(1, 6);
      }
      total += randNum;
    }
    this.constitution = total;
    this.dexterity = total;
    this.charisma = total;
    this.strength = total;
    this.health = 4 * total;

    this.unitsLeft = 10;

    this.belts = new ArrayList<>();
    this.potions = new ArrayList<>();
    this.myBag = new ArrayList<>();

  }

  @Override
  public void updateHealth(int num) {
    this.health += num;

  }

  @Override
  public void updateStrength(int num) {
    this.strength += num;

  }

  @Override
  public void updateConstitution(int num) {
    this.constitution += num;
    if (this.constitution < 0) {
      this.constitution = 0;
    }

  }

  @Override
  public void updateDexterity(int num) {
    this.dexterity += num;

  }

  @Override
  public void updateCharisma(int num) {
    this.charisma += num;

  }

  @Override
  public void updateWeapon(Weapon weapon) throws IllegalArgumentException {
    if (Objects.isNull(weapon)) {
      throw new IllegalArgumentException("Please choose valid weapon!");
    } else if (!Objects.isNull(this.weapon)) {
      throw new IllegalArgumentException("You can only request for weapon once!");
    }

    this.weapon = weapon;

  }

  @Override
  public String getDescription() {

    StringBuilder res = new StringBuilder();

    // Basic abilities
    res.append("Basic Abilities: \n");
    res.append(" - Health: " + this.health + "\n");
    res.append(" - Strength: " + this.strength + "\n");
    res.append(" - Constitution: " + this.constitution + "\n");
    res.append(" - Dexterity: " + this.dexterity + "\n");
    res.append(" - Charisma: " + this.charisma + "\n");

    // Gears
    res.append("Gear Info: \n");
    // Headgear info
    if (!Objects.isNull(this.headGear)) {
      res.append(" - " + this.headGear.getType().toString() + "\n");
      res.append(
          "  + " + "Effect On Constitution: " + this.headGear.getEffectOnConstitution() + "\n");
    }

    // potions
    if (this.potions.size() > 0) {
      for (Gear potion : this.potions) {
        res.append(" - " + potion.getType().toString() + " \n");
        res.append("  + " + "Effect On Health: " + potion.getEffectOnHealth() + "\n");
        res.append("  + " + "Effect On Constitution: " + potion.getEffectOnConstitution() + "\n");
        res.append("  + " + "Effect On Strength: " + potion.getEffectOnStrength() + "\n");
        res.append("  + " + "Effect On Charisma: " + potion.getEffectOnCharisma() + "\n");
        res.append("  + " + "Effect On Dexterity: " + potion.getEffectOnDexterity() + "\n");
        res.append("  + " + "Duration: " + potion.getDuration() + "\n");

      }

    }

    // Belts
    if (this.belts.size() > 0) {
      ArrayList<String> beltsInfo = new ArrayList<>();
      for (Gear belt : this.belts) {
        StringBuilder temp = new StringBuilder();
        temp.append(" - " + belt.getType().toString() + "\n");
        temp.append("  + " + "Effect On Strength: " + belt.getEffectOnStrength() + "\n");
        temp.append("  + " + "Effect On Charisma: " + belt.getEffectOnCharisma() + "\n");
        beltsInfo.add(temp.toString());
      }
      java.util.Collections.sort(beltsInfo);
      for (String s : beltsInfo) {
        res.append(s + "\n");
      }
    }

    // Footwears
    if (!Objects.isNull(this.footWears)) {
      res.append(" - " + this.footWears.getType().toString() + "\n");
      res.append("  + " + "Effect On Dexterity: " + this.footWears.getEffectOnDexterity() + "\n");
    }

    // Weapon
    if (!Objects.isNull(this.weapon)) {
      res.append("Weapon Info: \n");
      res.append(" - " + this.weapon.getWeaponType().toString() + "\n");
      res.append("  + " + "Damage: " + weapon.getDamage() + "\n");
    }

    return res.toString();
  }

  @Override
  public void receiveGears(List<Gear> gears) throws IllegalArgumentException {
    if (gears.isEmpty()) {
      throw new IllegalArgumentException("Gears cannot be empty!");
    }
    this.myBag = gears;

  }

  @Override
  public String getMyBagInfo() {
    StringBuilder res = new StringBuilder();

    ArrayList<String> bagInfo = new ArrayList<>();

    for (Gear gear : this.myBag) {
      StringBuilder temp = new StringBuilder();
      temp.append(gear.getType().toString() + "\n");
      temp.append("Position in my bag: " + this.myBag.indexOf(gear) + "\n");
      temp.append(" - " + "Effect On Health: " + gear.getEffectOnHealth() + "\n");
      temp.append(" - " + "Effect On Constitution: " + gear.getEffectOnConstitution() + "\n");
      temp.append(" - " + "Effect On Strength: " + gear.getEffectOnStrength() + "\n");
      temp.append(" - " + "Effect On Charisma: " + gear.getEffectOnCharisma() + "\n");
      temp.append(" - " + "Effect On Dexterity: " + gear.getEffectOnDexterity() + "\n");
      bagInfo.add(temp.toString());

    }

    java.util.Collections.sort(bagInfo);

    for (String s : bagInfo) {
      res.append(s + "\n");
    }
    return res.toString();
  }

  @Override
  public int getStrength() {
    return this.strength;
  }

  @Override
  public int getDexterity() {

    return this.dexterity;
  }

  @Override
  public int getWeaponDamage() {

    return this.weapon.getDamage();
  }

  @Override
  public int getConstitution() {
    return this.constitution;

  }

  @Override
  public int getHealth() {
    return this.health;
  }

  @Override
  public void updatePotionsEffect() {
    Iterator<Gear> iterate = this.potions.iterator();
    List<Gear> temp = new ArrayList<>();

    while (iterate.hasNext()) {
      Gear potion = iterate.next();
      potion.reduceDuration();
      if (potion.getDuration() > 0) {
        temp.add(potion);
      } else if (potion.getDuration() == 0) {

        this.updateHealth(-potion.getEffectOnHealth());
        this.updateConstitution(-potion.getEffectOnConstitution());
        this.updateStrength(-potion.getEffectOnStrength());
        this.updateDexterity(-potion.getEffectOnDexterity());
        this.updateCharisma(-potion.getEffectOnCharisma());

      }

    }
    this.potions = temp;

  }

  @Override
  public List<Gear> getGearsInMyBag() {
    List<Gear> gearsCopy = new ArrayList<>();
    gearsCopy.addAll(this.myBag);
    return gearsCopy;
  }

  @Override
  public int getCharisma() {

    return this.charisma;
  }

  @Override
  public WeaponType getWeaponType() {
    if (Objects.isNull(this.weapon)) {
      return null;

    }

    return this.weapon.getWeaponType();
  }

  @Override
  public void equipGears(Gear... gears) throws IllegalArgumentException {
    if (gears.length == 0) {
      throw new IllegalArgumentException("Gears cannot be empty!");
    }
    for (Gear gear : gears) {

      if (gear.getType() == GearType.HEADGEAR) {

        updateHeadgear(gear);

      } else if (gear.getType().equals(GearType.BELTSLARGE)
          || gear.getType().equals(GearType.BELTSMEDIUM)
          || gear.getType().equals(GearType.BELTSSMALL)) {

        updateBelts(gear);

      } else if (gear.getType() == GearType.FOOTWEAR) {
        updateFootwears(gear);
      } else if (gear.getType() == GearType.PORION) {
        updatePotions(gear);
      }

    }
    // 25% of the items that are in the bag will diminish the player's constitution
    float usedQuota = ((float) gears.length) / (gears.length + this.myBag.size());
    if (usedQuota <= 0.85) {
      this.updateConstitution(-10);
    }
  }

  private void updateHeadgear(Gear gear) throws IllegalArgumentException {
    if (Objects.isNull(gear) || !gear.getType().equals(GearType.HEADGEAR)) {
      throw new IllegalArgumentException("Please choose a valid headgear!");
    } else if (!this.myBag.contains(gear)) {
      throw new IllegalArgumentException("Please choose a headgear in your bag!");
    }

    // Remove current gear
    if (!Objects.isNull(this.headGear)) {

      this.myBag.add(this.headGear);
      this.updateConstitution(-this.headGear.getEffectOnConstitution());
      this.headGear = null;

    }
    // Equip current gear
    this.headGear = gear;
    this.myBag.remove(gear);
    this.updateConstitution(gear.getEffectOnConstitution());

  }

  private void updateFootwears(Gear gear) throws IllegalArgumentException {
    if (Objects.isNull(gear) || !gear.getType().equals(GearType.FOOTWEAR)) {
      throw new IllegalArgumentException("Please choose a valid footwear!");
    } else if (!this.myBag.contains(gear)) {
      throw new IllegalArgumentException("Please choose a footwear in your bag!");
    }

    // Remove current gear
    if (!Objects.isNull(this.footWears)) {

      this.myBag.add(this.footWears);
      this.updateDexterity(-this.footWears.getEffectOnDexterity());
      this.footWears = null;

    }
    // Equip current gear
    this.footWears = gear;
    this.myBag.remove(gear);
    this.updateDexterity(gear.getEffectOnDexterity());

  }

  private void updateBelts(Gear... gears) throws IllegalArgumentException {
    if (gears.length == 0) {
      throw new IllegalArgumentException("Please choose valid belts!");
    }
    for (Gear gear : gears) {
      if (Objects.isNull(gear) || !(gear.getType().equals(GearType.BELTSLARGE)
          || gear.getType().equals(GearType.BELTSMEDIUM)
          || gear.getType().equals(GearType.BELTSSMALL))) {

        throw new IllegalArgumentException("Please choose valid belts!");

      } else if (!this.myBag.contains(gear)) {
        throw new IllegalArgumentException("Please choose a belt in your bag!");
      }

      int unitCost = gear.getType().getUnitCost();
      if (this.unitsLeft >= unitCost) {

        this.updateHealth(gear.getEffectOnHealth());
        this.updateConstitution(gear.getEffectOnConstitution());
        this.updateDexterity(gear.getEffectOnDexterity());
        this.updateStrength(gear.getEffectOnStrength());
        this.updateCharisma(gear.getEffectOnCharisma());

        this.belts.add(gear);
        this.myBag.remove(gear);
        this.unitsLeft -= unitCost;

      }

    }

  }

  private void updatePotions(Gear... gears) throws IllegalArgumentException {
    if (gears.length == 0) {
      throw new IllegalArgumentException("Please choose valid potion!");
    }
    for (Gear gear : gears) {
      if (Objects.isNull(gear) || !gear.getType().equals(GearType.PORION)) {
        throw new IllegalArgumentException("Please choose valid potions!");

      } else if (!this.myBag.contains(gear)) {
        throw new IllegalArgumentException("Please choose a potion in your bag!");
      }

      this.potions.add(gear);
      this.updateHealth(gear.getEffectOnHealth());
      this.updateConstitution(gear.getEffectOnConstitution());
      this.updateStrength(gear.getEffectOnStrength());
      this.updateDexterity(gear.getEffectOnDexterity());
      this.updateCharisma(gear.getEffectOnCharisma());

      this.myBag.remove(gear);
    }

  }

  private int randomNumber(int min, int max) {

    return min + (int) (Math.random() * ((max - min) + 1));
  }

}
