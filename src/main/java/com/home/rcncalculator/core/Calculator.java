package com.home.rcncalculator.core;

import com.home.rcncalculator.element.Number;
import com.home.rcncalculator.element.Unit;
import com.home.rcncalculator.exception.CalculationException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * {@code Calculator} is defined for performing RCN calculator functions.
 */
public class Calculator {

  public static Calculator RCN_CALCULATOR = new Calculator();

  //The result history will record all the snapshot result in th past.
  private List<Deque<Number>> resultHistory = new ArrayList<>();

  private Calculator() {
  }

  /**
   * Core function here. accept the input units and given the stack back.
   *
   * @throws CalculationException when hitting error in the calculation.
   */
  public Deque<Number> calculate(List<Unit> inputUnits) throws CalculationException {
    for (int i = 0; i < inputUnits.size(); i++) {
      Unit newUnit = inputUnits.get(i);
      try {
        newUnit.getElement().execute(resultHistory);
      } catch (Exception err) {
        List<Unit> unProcessedUnit = new ArrayList<>();
        for (int j = i + 1; j < inputUnits.size(); j++) {
          unProcessedUnit.add(inputUnits.get(j));
        }
        throw new CalculationException(err, newUnit, unProcessedUnit);
      }
    }
    return currentStack();
  }

  /**
   * Return the current stack of the calculator.
   */
  public Deque<Number> currentStack() {
    if (!resultHistory.isEmpty()) {
      return resultHistory.get(resultHistory.size() - 1);
    } else {
      return new ArrayDeque<>();
    }
  }
}

