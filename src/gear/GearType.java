package gear;

/**
 * The enum represents type of gears.
 */
public enum GearType {

  HEADGEAR(0), BELTSSMALL(1), BELTSMEDIUM(2), BELTSLARGE(4), PORION(0), FOOTWEAR(0);

  private int unitCost;

  private GearType(int unitCost) {
    this.unitCost = unitCost;
  }

  public int getUnitCost() {
    return this.unitCost;
  }

}
