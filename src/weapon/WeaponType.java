package weapon;

/**
 * The enum represents weapon's type..
 */
public enum WeaponType {

  KATANAS(6), BROADSWORD(10), TWOHANDEDSWORD(12), FLAILS(12), AXES(10);

  private int damage;

  private WeaponType(int damage) {
    this.damage = damage;
  }

  public int getDamage() {
    return this.damage;
  }

}
