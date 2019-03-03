package com.home.rcncalculator.exception;

import com.home.rcncalculator.element.operator.Operator;

public class OperationErrorException extends BasicException {
  private static final String KEY = OperationErrorException.class.getName();

  public OperationErrorException(Operator operator) {
    super(BasicException.getMessage(KEY, operator.symbol()));
  }
}
