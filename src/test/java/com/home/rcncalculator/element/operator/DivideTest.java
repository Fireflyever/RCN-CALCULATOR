package com.home.rcncalculator.element.operator;

import com.home.rcncalculator.element.Number;
import com.home.rcncalculator.exception.InsufficientParametersException;
import com.home.rcncalculator.exception.OperationErrorException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;

public class DivideTest {

  @Test
  public void testDivide() {
    Deque<Number> currentStack = new ArrayDeque<>();
    currentStack.push(new Number(new BigDecimal("100")));
    currentStack.push(new Number(new BigDecimal("20")));
    Divide.DIVIDE.execute(currentStack);
    //[100, 20, /] -> [5]
    Assert.assertEquals("5", currentStack.poll().toString());
  }

  @Test
  public void testDivideWithRepeatingDecimal() {
    Deque<Number> currentStack = new ArrayDeque<>();
    currentStack.push(new Number(new BigDecimal("2")));
    currentStack.push(new Number(new BigDecimal("3")));
    Divide.DIVIDE.execute(currentStack);
    //[2, 3, /] -> [0.666666666666667]
    Number number = currentStack.poll();
    Assert.assertEquals(new BigDecimal("0.666666666666667"), number.getValue());
    Assert.assertEquals("0.6666666666", number.toString());
  }

  @Test(expected = OperationErrorException.class)
  public void testAddWithInsufficientParameters() {
    Deque<Number> currentStack = new ArrayDeque<>();
    currentStack.push(new Number(new BigDecimal("100")));
    currentStack.push(new Number(BigDecimal.ZERO));
    Divide.DIVIDE.execute(currentStack);
    //[100, 0, /] -> ERROR
    Assert.assertEquals(new BigDecimal("5"), currentStack.poll().getValue());
  }

  @Test(expected = InsufficientParametersException.class)
  public void testInsufficientParameters() {
    Deque<Number> currentStack = new ArrayDeque<>();
    currentStack.push(new Number(BigDecimal.ONE));
    Divide.DIVIDE.execute(currentStack);
  }
}
