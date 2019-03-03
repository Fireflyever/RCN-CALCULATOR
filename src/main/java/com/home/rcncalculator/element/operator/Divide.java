package com.home.rcncalculator.element.operator;

import com.home.rcncalculator.config.SystemConfig;
import com.home.rcncalculator.element.Number;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Deque;

/**
 * {@code Divide} perform the divide function.
 */
public class Divide extends Operator {

  public static Divide DIVIDE = new Divide();

  private Divide() {
  }

  @Override
  public String symbol() {
    return "/";
  }

  @Override
  int requireParams() {
    return 2;
  }

  @Override
  void exec(Deque<Number> stack) {
    BigDecimal item1 = stack.poll().getValue();
    BigDecimal item2 = stack.poll().getValue();
    //Using half up rounding mode here for dividing.
    stack.push(new Number(item2.divide(item1, SystemConfig.STORE_SCALE, RoundingMode.HALF_UP)));
  }
}
