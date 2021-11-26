package weapon;

/**
 * The class implements Weapon interface.
 */
public class WeaponImpl implements Weapon {
  private final int damage;
  private final WeaponType type;

  /**
   * Constructs a weapon with given type.
   * 
   * @param type the type if the weapon
   * @throws IllegalArgumentException if type is not a valid weapon type
   */
  public WeaponImpl(WeaponType type) throws IllegalArgumentException {
    if (type != WeaponType.AXES || type != WeaponType.BROADSWORD || type != WeaponType.FLAILS
        || type != WeaponType.KATANAS || type != WeaponType.TWOHANDEDSWORD) {

      throw new IllegalArgumentException("Not a valid weapon type!");
    }

    this.damage = type.getDamage();
    this.type = type;

  }

  @Override
  public int getDamage() {

    return this.damage;
  }

  @Override
  public WeaponType getWeaponType() {

    return this.type;
  }

}
