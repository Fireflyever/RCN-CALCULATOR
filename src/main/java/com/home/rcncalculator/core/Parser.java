package com.home.rcncalculator.core;

import static com.home.rcncalculator.element.operator.Clear.CLEAR;
import static com.home.rcncalculator.element.operator.Divide.DIVIDE;

import com.home.rcncalculator.config.SystemConfig;
import com.home.rcncalculator.element.Number;
import com.home.rcncalculator.element.Unit;
import com.home.rcncalculator.element.operator.Add;
import com.home.rcncalculator.element.operator.Minus;
import com.home.rcncalculator.element.operator.Multiply;
import com.home.rcncalculator.element.operator.Operator;
import com.home.rcncalculator.element.operator.Sqrt;
import com.home.rcncalculator.element.operator.Undo;
import com.home.rcncalculator.exception.ParsingException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




/**
 * {@code Parser} is responsible for parsing string
 * input to list of {@code Unit} for further processing.
 */
public class Parser {

  public static Parser STRING_PARSER = new Parser();

  private static char WHITE_SPACE_CHAR = ' ';
  private static Map<String, Operator> OPERATORS = new HashMap<>();

  /**
   * Init the operations symbols.
   */
  static {
    OPERATORS.put(Add.ADD.symbol(), Add.ADD);
    OPERATORS.put(Minus.MINUS.symbol(), Minus.MINUS);
    OPERATORS.put(Multiply.MULTIPLY.symbol(), Multiply.MULTIPLY);
    OPERATORS.put(DIVIDE.symbol(), DIVIDE);
    OPERATORS.put(Sqrt.SQRT.symbol(), Sqrt.SQRT);
    OPERATORS.put(Undo.UNDO.symbol(), Undo.UNDO);
    OPERATORS.put(CLEAR.symbol(), CLEAR);
  }

  private Parser() {
  }

  /**
   * parse the input text to the list of unit.
   *
   * @throws {@code ParsingException} when the input is not valid.
   */
  public List<Unit> parse(String input) {
    List<Unit> result = new ArrayList();
    //using index i , j rather than input.split for making the position correctly.
    for (int i = 0, j = 0; i < input.length(); i++) {
      if (input.charAt(i) != WHITE_SPACE_CHAR) {
        j = i + 1;
        while (j < input.length() && input.charAt(j) != WHITE_SPACE_CHAR) {
          j++;
        }
        String token = input.substring(i, j);
        try {
          if (OPERATORS.containsKey(token)) {
            result.add(new Unit(OPERATORS.get(token), i + 1));
          } else {
            BigDecimal number = new BigDecimal(token).setScale(SystemConfig.STORE_SCALE,
                RoundingMode.DOWN);
            result.add(new Unit(new Number(number), i + 1));
          }
          i = j;
        } catch (Exception err) {
          throw new ParsingException(token, i);
        }
      }
    }
    return result;
  }
}
