package com.home.rcncalculator.element.operator;

import com.home.rcncalculator.element.Element;
import com.home.rcncalculator.element.Number;
import com.home.rcncalculator.exception.InsufficientParametersException;
import com.home.rcncalculator.exception.OperationErrorException;

import java.util.Deque;

/**
 * {@code Operator} is define for operations in the stack.
 */
public abstract class Operator extends Element {

  /**
   * How many elements using in this operator.
   */
  abstract int requireParams();

  /**
   * The actual execution for this operator.
   */
  abstract void exec(Deque<Number> stack);

  /**
   * The operator symbol.
   */
  public abstract String symbol();

  /**
   * Perform the pre check for the operators.
   */
  @Override
  protected void execute(Deque<Number> stack) {
    //1. Check the params length,
    if (stack.size() < requireParams()) {
      throw new InsufficientParametersException(this);
    }
    //2. do the execution and handle the com.airwallex.exception.
    try {
      exec(stack);
    } catch (Exception err) {
      throw new OperationErrorException(this);
    }
  }

  @Override
  public String toString() {
    return symbol();
  }
}
