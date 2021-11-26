package weapon;

/**
 * Weapon interface allows a battle to manage the players' weapons.
 */
public interface Weapon {
  /**
   * Get the damage of the weapon.
   * 
   * @return damage value
   */
  int getDamage();

  /**
   * Get the type of the weapon.
   * 
   * @return type value
   */
  WeaponType getWeaponType();

}
