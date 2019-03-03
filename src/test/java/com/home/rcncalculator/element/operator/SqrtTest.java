package com.home.rcncalculator.element.operator;

import com.home.rcncalculator.element.Number;
import com.home.rcncalculator.exception.InsufficientParametersException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;

public class SqrtTest {

  @Test
  public void testSqrt() {
    Deque<Number> currentStack = new ArrayDeque<>();
    currentStack.push(new Number(new BigDecimal("2")));
    Sqrt.SQRT.execute(currentStack);
    //[2, sqrt] -> [1.414213562373095]
    Number number = currentStack.poll();
    Assert.assertEquals(new BigDecimal("1.414213562373095"), number.getValue());
    Assert.assertEquals("1.4142135623", number.toString());
  }

  @Test(expected = InsufficientParametersException.class)
  public void testInsufficientParameters() {
    Deque<Number> currentStack = new ArrayDeque<>();
    Sqrt.SQRT.execute(currentStack);
  }
}
