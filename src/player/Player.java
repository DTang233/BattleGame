package player;

import java.util.List;

import gear.Gear;
import weapon.Weapon;
import weapon.WeaponType;

/**
 * Player interface allows users to update all the attributes.
 */
public interface Player {

  /**
   * Receive gears from the bags.
   * 
   * @param gears received
   */
  void receiveGears(List<Gear> gears);

  /**
   * Equip the given gears.
   * 
   * @param gears to equip
   */
  void equipGears(Gear... gears);

  /**
   * Update health value of the player.
   * 
   * @param number to add
   */
  void updateHealth(int number);

  /**
   * Get the health value of the player.
   */
  int getHealth();

  /**
   * Update strength value of the player.
   * 
   * @param number to add
   */
  void updateStrength(int number);

  /**
   * Get strength value of the player.
   * 
   * @return get strength value
   */
  int getStrength();

  /**
   * Update constitution value of the player.
   * 
   * @param number to add
   */
  void updateConstitution(int number);

  /**
   * Get constitution value of the player.
   * 
   * @return constitution value
   */
  int getConstitution();

  /**
   * Update dexterity value of the player.
   * 
   * @param number to add
   */
  void updateDexterity(int number);

  /**
   * Get dexterity value of the player.
   * 
   * @return dexterity value
   */
  int getDexterity();

  /**
   * Update charisma value of the player.
   * 
   * @param number to add
   */
  void updateCharisma(int number);

  /**
   * Update potions' effect of the player.
   */
  void updatePotionsEffect();

  /**
   * Update weapon of the player.
   * 
   * @param weapon to equip
   */
  void updateWeapon(Weapon weapon);

  /**
   * Get damage value of the weapon.
   * 
   * @return damage value
   */

  int getWeaponDamage();

  /**
   * Get weapon type of current weapon.
   * 
   * @return weapon type
   */

  WeaponType getWeaponType();

  /**
   * Get Charisma value.
   * 
   * @return charisma value
   */

  int getCharisma();

  /**
   * Get description of the player.
   * 
   * @return description of player's abilities and gears
   */
  String getDescription();

  /**
   * Get what is in my bag.
   * 
   * @return content of player's bag
   */
  String getMyBagInfo();

  /**
   * Get what is in my bag.
   * 
   * @return content of player's bag
   */
  List<Gear> getGearsInMyBag();

}
