package com.home.rcncalculator.element.operator;

import com.home.rcncalculator.element.Number;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;

public class ClearTest {

  @Test
  public void testClear() {
    Deque<Number> currentStack = new ArrayDeque<>();
    currentStack.push(new Number(BigDecimal.ONE));
    currentStack.push(new Number(BigDecimal.ONE));
    Clear.CLEAR.execute(currentStack);
    //[1, 1, clear] -> []
    Assert.assertTrue(currentStack.isEmpty());
  }
}
