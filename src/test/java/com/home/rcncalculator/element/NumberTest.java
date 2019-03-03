package com.home.rcncalculator.element;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;

public class NumberTest {

  @Test
  public void testExecute() {
    Deque<Number> currentStack = new ArrayDeque<>();
    currentStack.push(new Number(BigDecimal.ONE));
    Number ten = new Number(BigDecimal.TEN);
    ten.execute(currentStack);
    //[0] -> [0, 10]
    Assert.assertEquals(BigDecimal.TEN, currentStack.poll().getValue());
  }
}
