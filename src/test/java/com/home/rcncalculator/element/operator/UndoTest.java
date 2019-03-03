package com.home.rcncalculator.element.operator;

import com.home.rcncalculator.element.Number;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class UndoTest {
  @Test
  public void testUndo() {
    Deque<Number> stack1 = new ArrayDeque<>();
    Deque<Number> stack2 = new ArrayDeque<>();
    stack1.push(new Number(BigDecimal.ONE));
    stack2.push(new Number(BigDecimal.ONE));
    stack2.push(new Number(BigDecimal.TEN));
    List<Deque<Number>> history = new ArrayList<>();
    history.add(stack1);
    history.add(stack2);
    Undo.UNDO.execute(history);
    Assert.assertEquals(1, history.size());
    Assert.assertEquals(stack1, history.get(0));
  }
}
