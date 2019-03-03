package com.home.rcncalculator.element.operator;

import com.home.rcncalculator.element.Number;

import java.math.BigDecimal;
import java.util.Deque;

/**
 * {@code Multiply} perform the multiply functions.
 */
public class Multiply extends Operator {

  public static Multiply MULTIPLY = new Multiply();

  private Multiply() {
  }

  @Override
  public String symbol() {
    return "*";
  }

  @Override
  int requireParams() {
    return 2;
  }

  @Override
  void exec(Deque<Number> stack) {
    BigDecimal item1 = stack.poll().getValue();
    BigDecimal item2 = stack.poll().getValue();
    stack.push(new Number(item1.multiply(item2)));
  }
}
