package com.home.rcncalculator.element.operator;

import com.home.rcncalculator.element.Number;
import com.home.rcncalculator.exception.InsufficientParametersException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;

public class AddTest {

  @Test
  public void testAdd() {
    Deque<Number> currentStack = new ArrayDeque<>();
    currentStack.push(new Number(BigDecimal.ONE));
    currentStack.push(new Number(BigDecimal.ONE));
    Add.ADD.execute(currentStack);
    //[1, 1, +] -> [2]
    Assert.assertEquals(new BigDecimal("2"), currentStack.poll().getValue());
  }

  @Test(expected = InsufficientParametersException.class)
  public void testInsufficientParameters() {
    Deque<Number> currentStack = new ArrayDeque<>();
    currentStack.push(new Number(BigDecimal.ONE));
    Add.ADD.execute(currentStack);
  }
}
