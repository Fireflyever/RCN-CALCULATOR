package com.home.rcncalculator.element.operator;

import com.home.rcncalculator.element.Number;

import java.util.Deque;

/**
 * {@code Clear} perform the clear function.
 */
public class Clear extends Operator {

  public static Clear CLEAR = new Clear();

  private Clear() {
  }

  @Override
  public String symbol() {
    return "clear";
  }

  @Override
  int requireParams() {
    return 0;
  }

  @Override
  void exec(Deque<Number> stack) {
    stack.clear();
  }

}
