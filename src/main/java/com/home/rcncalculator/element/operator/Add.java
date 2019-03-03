package com.home.rcncalculator.element.operator;

import com.home.rcncalculator.element.Number;

import java.math.BigDecimal;
import java.util.Deque;

/**
 * {@code Add} perform the add function.
 */
public class Add extends Operator {
  public static Add ADD = new Add();

  private Add() {
  }

  @Override
  public String symbol() {
    return "+";
  }

  int requireParams() {
    return 2;
  }

  @Override
  protected void exec(Deque<Number> stack) {
    BigDecimal item1 = stack.poll().getValue();
    BigDecimal item2 = stack.poll().getValue();
    stack.push(new Number(item1.add(item2)));
  }

}
