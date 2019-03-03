package com.home.rcncalculator.element;

/**
 * {@Code Unit} contains com.airwallex.element as well as the its position.
 * Because I think the position is the parsing info and should not be a field inside the Elements.
 */
public class Unit {
  private Element element;
  private int position;

  public Unit(Element element, int position) {
    this.element = element;
    this.position = position;
  }

  public Element getElement() {
    return element;
  }

  public int getPosition() {
    return position;
  }

  @Override
  public String toString() {
    return element.toString();
  }
}
