package com.home.rcncalculator.element.operator;

import com.home.rcncalculator.config.SystemConfig;
import com.home.rcncalculator.element.Number;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Deque;

public class Sqrt extends Operator {


  public static Sqrt SQRT = new Sqrt();

  private static int SQRT_DEFAULT_PRECISION = 100;
  private static BigDecimal TWO = new BigDecimal("2");

  private Sqrt() {
  }

  @Override
  public String symbol() {
    return "sqrt";
  }

  @Override
  int requireParams() {
    return 1;
  }

  @Override
  void exec(Deque<Number> stack) {
    BigDecimal item = stack.poll().getValue();
    stack.push(new Number(sqrt(item, SystemConfig.STORE_SCALE)));
  }

  /**
   * Since the BigDecimal does not perform the sqrt function
   * and the Math.sqrt is only suitable for the double type.
   * So here is the simple Newton iterative method implementation.
   */
  private BigDecimal sqrt(BigDecimal value, int scale) {
    int sqrtPrecision = Math.max(SQRT_DEFAULT_PRECISION, scale);
    MathContext matchContext = new MathContext(sqrtPrecision, RoundingMode.HALF_UP);
    BigDecimal deviation = value;
    int cnt = 0;
    while (cnt < sqrtPrecision) {
      deviation = (deviation.add(value.divide(deviation, matchContext))).divide(TWO, matchContext);
      cnt++;
    }
    deviation = deviation.setScale(scale, BigDecimal.ROUND_HALF_UP);
    return deviation;
  }
}
