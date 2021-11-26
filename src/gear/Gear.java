package gear;

/**
 * Gear interface represents gears in the battle.
 */
public interface Gear {

  /**
   * Get the type of the gear.
   * 
   * @return gear type
   */
  GearType getType();

  /**
   * Get the effect on health.
   * 
   * @return effect value
   */
  int getEffectOnHealth();

  /**
   * Get the effect on strength.
   * 
   * @return effect value
   */
  int getEffectOnStrength();

  /**
   * Get the effect on constitution.
   * 
   * @return effect value
   */
  int getEffectOnConstitution();

  /**
   * Get the effect on dexterity.
   * 
   * @return effect value
   */
  int getEffectOnDexterity();

  /**
   * Get the effect on charisma.
   * 
   * @return effect value
   */
  int getEffectOnCharisma();

  /**
   * Get the unit cost of the gear.
   * 
   * @return unit cost
   */
  int getUnitCost();

  /**
   * get the value of duration.
   * 
   * @return duration value
   */
  int getDuration();

  /**
   * Reduce the duration by 1.
   */
  void reduceDuration();

}
