package com.home.rcncalculator.element.operator;

import com.home.rcncalculator.element.Number;
import com.home.rcncalculator.exception.InsufficientParametersException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;

public class MultiplyTest {

  @Test
  public void testMultiply() {
    Deque<Number> currentStack = new ArrayDeque<>();
    currentStack.push(new Number(BigDecimal.TEN));
    currentStack.push(new Number(BigDecimal.TEN));
    Multiply.MULTIPLY.execute(currentStack);
    //[10, 10, *] -> [100]
    Assert.assertEquals(new BigDecimal("100"), currentStack.poll().getValue());
  }

  @Test(expected = InsufficientParametersException.class)
  public void testInsufficientParameters() {
    Deque<Number> currentStack = new ArrayDeque<>();
    currentStack.push(new Number(BigDecimal.ONE));
    Multiply.MULTIPLY.execute(currentStack);
  }
}
