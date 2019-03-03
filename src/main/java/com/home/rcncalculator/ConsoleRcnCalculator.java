package com.home.rcncalculator;

import com.home.rcncalculator.core.Calculator;
import com.home.rcncalculator.core.Parser;
import com.home.rcncalculator.element.Number;
import com.home.rcncalculator.element.Unit;
import com.home.rcncalculator.exception.CalculationException;
import com.home.rcncalculator.exception.ParsingException;

import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * {@code ConsoleRcnCalculator} is the Java Console wrapper for the RCN calculator.
 */
public class ConsoleRcnCalculator {

  /**
   * The entrance of the Console calculator.
   */
  public static void main(String[] args) {
    System.out.println("Please input:");
    Scanner input = new Scanner(System.in);
    while (input.hasNext()) {
      try {
        List<Unit> inputs = Parser.STRING_PARSER.parse(input.nextLine());
        Deque<Number> stack = Calculator.RCN_CALCULATOR.calculate(inputs);
        printStack(stack);
      } catch (ParsingException err) {
        printError(err);
        printStack(Calculator.RCN_CALCULATOR.currentStack());
      } catch (CalculationException err) {
        printError(err);
        printStack(Calculator.RCN_CALCULATOR.currentStack());
        printUnProcessedUnits(err.getUnProcessedUnits());
      } catch (Exception err) {
        printUnKnownError(err);
      }
    }
  }

  private static void printError(Exception err) {
    System.out.println(err.getMessage());
  }

  private static void printStack(Deque<Number> stack) {
    System.out.print("stack: ");
    Iterator<Number> it = stack.descendingIterator();
    while (it.hasNext()) {
      System.out.print(it.next() + " ");
    }
    System.out.print("\r\n");
  }

  private static void printUnProcessedUnits(List<Unit> remainingUnits) {
    if (remainingUnits.size() > 0) {
      System.out.print("(the ");
      for (int i = 0; i < remainingUnits.size() - 1; i++) {
        System.out.print(remainingUnits.get(i).toString() + " and ");
      }
      System.out.print(remainingUnits.get(remainingUnits.size() - 1).toString() + " ");
      System.out.print(remainingUnits.size() == 1 ? "was" : "were");
      System.out.print(" not pushed on to the stack due to the previous error)\r\n");
    }
  }

  private static void printUnKnownError(Exception err) {
    System.out.println(err.toString());
  }
}
