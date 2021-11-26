import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import gear.Gear;
import gear.GearImpl;
import gear.GearType;

/**
 * Tests of Gear class.
 */
public class GearTest {

  private Gear headgear;
  private Gear belt;
  private Gear footwear;
  private Gear potion;

  @Before
  public void setUp() {

    headgear = new GearImpl(0, 0, 5, 0, 0, 100, GearType.HEADGEAR);
    belt = new GearImpl(0, 5, 0, 0, 5, 100, GearType.BELTSMEDIUM);
    footwear = new GearImpl(0, 0, 0, 5, 0, 100, GearType.FOOTWEAR);
    potion = new GearImpl(5, 5, 5, 5, 5, 5, GearType.PORION);

  }

  @Test
  public void testGetType() {
    assertEquals(headgear.getType(), GearType.HEADGEAR);
    assertEquals(belt.getType(), GearType.BELTSMEDIUM);
    assertEquals(footwear.getType(), GearType.FOOTWEAR);
    assertEquals(potion.getType(), GearType.PORION);
  }

  @Test
  public void testGetEffectOnHealth() {

    assertEquals(0, headgear.getEffectOnHealth());
    assertEquals(0, belt.getEffectOnHealth());
    assertEquals(0, footwear.getEffectOnHealth());
    assertEquals(5, potion.getEffectOnHealth());

  }

  @Test
  public void testGetEffectOnStrength() {

    assertEquals(0, headgear.getEffectOnStrength());
    assertEquals(5, belt.getEffectOnStrength());
    assertEquals(0, footwear.getEffectOnStrength());
    assertEquals(5, potion.getEffectOnStrength());

  }

  @Test
  public void testGetEffectOnConstitution() {

    assertEquals(5, headgear.getEffectOnConstitution());
    assertEquals(0, belt.getEffectOnConstitution());
    assertEquals(0, footwear.getEffectOnConstitution());
    assertEquals(5, potion.getEffectOnConstitution());

  }

  @Test
  public void testGetEffectOnDexterity() {

    assertEquals(0, headgear.getEffectOnDexterity());
    assertEquals(0, belt.getEffectOnDexterity());
    assertEquals(5, footwear.getEffectOnDexterity());
    assertEquals(5, potion.getEffectOnDexterity());

  }

  @Test
  public void testGetEffectOnCharisma() {

    assertEquals(0, headgear.getEffectOnCharisma());
    assertEquals(5, belt.getEffectOnCharisma());
    assertEquals(0, footwear.getEffectOnCharisma());
    assertEquals(5, potion.getEffectOnCharisma());

  }

  @Test
  public void testGetUnitCost() {

    assertEquals(2, belt.getUnitCost());

  }

  @Test
  public void testDuration() {

    assertEquals(5, potion.getDuration());
    potion.reduceDuration();
    assertEquals(4, potion.getDuration());
    // test if duration goes below 0
    for (int i = 0; i < 6; i++) {
      potion.reduceDuration();

    }
    assertEquals(0, potion.getDuration());

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInitialize() {
    new GearImpl(0, 0, 5, 0, 0, 100, null);
  }

}
