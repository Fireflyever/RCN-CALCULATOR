package com.home.rcncalculator.element;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;


/**
 * {@code Element} define the pure com.airwallex.
 * Element including numbers and operators under the RCN calculator.
 */
public abstract class Element {

  /**
   * Execute according stack and itself (numbers or operator).
   */
  protected abstract void execute(Deque<Number> stack);

  /**
   * Execute the latest stack result according the previous ones and itself.
   *
   * @Throws {@code Exception} when calculation hitting error.
   */
  public void execute(List<Deque<Number>> resultHistory) {
    Deque<Number> newStack = new ArrayDeque<>();
    if (!resultHistory.isEmpty()) {
      Deque<Number> lastResult = resultHistory.get(resultHistory.size() - 1);
      //Step I: Copy the previous stack to the current one.
      newStack.addAll(lastResult);
    }
    //Step II: Do the calculation according current stack & itself.
    //eg. the current stack is [2, 3] and itself is [+], the the new stack should be [5]
    execute(newStack);
    //Step III: Add the newStack into the stack history.
    resultHistory.add(newStack);
  }

}
