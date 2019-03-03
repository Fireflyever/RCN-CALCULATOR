package com.home.rcncalculator.element;


import com.home.rcncalculator.config.SystemConfig;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Deque;

/**
 * {@Code Number} is defined for number com.airwallex.element.
 */
public class Number extends Element {
  private static NumberFormat numberFormat = NumberFormat.getInstance();

  static {
    numberFormat.setMaximumFractionDigits(SystemConfig.DISPLAY_SCALE);
    numberFormat.setRoundingMode(RoundingMode.DOWN);
  }

  private BigDecimal value;

  public Number(BigDecimal value) {
    this.value = value;
  }

  public BigDecimal getValue() {
    return value;
  }

  /**
   * For numbers, just push into the stack is OK.
   */
  @Override
  protected void execute(Deque<Number> stack) {
    stack.push(this);
  }

  /**
   * The formatted String for Numbers.
   */
  @Override
  public String toString() {
    return numberFormat.format(value);
  }
}
