package gear;

/**
 * Implementation of Gear interface.
 */
public class GearImpl implements Gear {

  private final int effectOnHealth;
  private final int effectOnStrength;
  private final int effectOnConstitution;
  private final int effectOnDexterity;
  private final int effectOnCharisma;
  private final GearType type;
  private final int unitCost;
  private int duration;

  /**
   * Constructs a gear with given effect values.
   * 
   * @param effectOnHealth       the effect on health value
   * @param effectOnStrength     the effect on strength value
   * @param effectOnConstitution the effect on constitution
   * @param effectOnDexterity    the effect on dexterity
   * @param effectOnCharisma     the effect on charisma
   * @param duration             the duration of the gear
   * @throws IllegalArgumentException if type is not a valid gear type
   */
  public GearImpl(int effectOnHealth, int effectOnStrength, int effectOnConstitution,
      int effectOnDexterity, int effectOnCharisma, int duration, GearType type)
      throws IllegalArgumentException {
    if (type != GearType.BELTSLARGE || type != GearType.BELTSMEDIUM || type != GearType.BELTSSMALL
        || type != GearType.FOOTWEAR || type != GearType.HEADGEAR || type != GearType.PORION) {

      throw new IllegalArgumentException("Not a valid gear type!");
    }

    this.effectOnHealth = effectOnHealth;
    this.effectOnStrength = effectOnStrength;
    this.effectOnConstitution = effectOnConstitution;
    this.effectOnDexterity = effectOnDexterity;
    this.effectOnCharisma = effectOnCharisma;
    this.duration = duration;
    this.unitCost = type.getUnitCost();
    this.type = type;
  }

  @Override
  public int getEffectOnHealth() {
    return this.effectOnHealth;
  }

  @Override
  public int getEffectOnStrength() {
    return this.effectOnStrength;
  }

  @Override
  public int getEffectOnConstitution() {
    return this.effectOnConstitution;
  }

  @Override
  public int getEffectOnDexterity() {
    return this.effectOnDexterity;
  }

  @Override
  public int getUnitCost() {

    return this.unitCost;
  }

  @Override
  public int getEffectOnCharisma() {
    return this.effectOnCharisma;
  }

  @Override
  public GearType getType() {

    return this.type;
  }

  @Override
  public int getDuration() {

    return this.duration;
  }

  @Override
  public void reduceDuration() {
    if (this.duration > 0) {
      this.duration -= 1;
    }

  }

}
