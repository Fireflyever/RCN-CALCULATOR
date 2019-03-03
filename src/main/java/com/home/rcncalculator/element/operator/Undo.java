package com.home.rcncalculator.element.operator;

import com.home.rcncalculator.element.Number;

import java.util.Deque;
import java.util.List;

/**
 * {@code Undo} perform the undo function.
 */
public class Undo extends Operator {

  public static Undo UNDO = new Undo();

  private Undo() {
  }

  public String symbol() {
    return "undo";
  }

  @Override
  int requireParams() {
    return 0;
  }

  @Override
  protected void exec(Deque<Number> stack) {
  }

  /**
   * The design for the undo function is just remove the latest snapshot history
   * rather than re-calculation the original numbers and symbols.
   */
  @Override
  public void execute(List<Deque<Number>> resultHistory) {
    if (!resultHistory.isEmpty()) {
      resultHistory.remove(resultHistory.size() - 1);
    }
  }
}
