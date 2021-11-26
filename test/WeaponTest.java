import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import weapon.Weapon;
import weapon.WeaponImpl;
import weapon.WeaponType;

/**
 * Tests of Weapon class.
 */
public class WeaponTest {

  private Weapon weapon;

  @Before
  public void setUp() {
    weapon = new WeaponImpl(WeaponType.AXES);

  }

  @Test
  public void getDamage() {
    assertEquals(10, weapon.getDamage());

  }

  @Test
  public void getType() {
    assertEquals(WeaponType.AXES, weapon.getWeaponType());

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInitialize() {
    new WeaponImpl(null);
  }
}
