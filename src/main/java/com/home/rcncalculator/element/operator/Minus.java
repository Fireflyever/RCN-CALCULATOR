package com.home.rcncalculator.element.operator;

import com.home.rcncalculator.element.Number;

import java.math.BigDecimal;
import java.util.Deque;

/**
 * {@code Minus} perform the minus function.
 */
public class Minus extends Operator {

  public static Minus MINUS = new Minus();

  private Minus() {
  }

  public String symbol() {
    return "-";
  }

  @Override
  int requireParams() {
    return 2;
  }

  @Override
  void exec(Deque<Number> stack) {
    BigDecimal item1 = stack.poll().getValue();
    BigDecimal item2 = stack.poll().getValue();
    stack.push(new Number(item2.subtract(item1)));
  }
}
