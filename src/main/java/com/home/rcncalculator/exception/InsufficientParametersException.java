package com.home.rcncalculator.exception;

import com.home.rcncalculator.element.operator.Operator;

public class InsufficientParametersException extends BasicException {

  private static final String KEY = InsufficientParametersException.class.getName();

  public InsufficientParametersException(Operator operator) {
    super(BasicException.getMessage(KEY, operator.symbol()));
  }

}
