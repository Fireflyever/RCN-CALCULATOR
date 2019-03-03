package com.home.rcncalculator.exception;

public class ParsingException extends BasicException {

  private static final String KEY = ParsingException.class.getName();

  public ParsingException(String token, int position) {
    super(BasicException.getMessage(KEY, token, position));
  }
}
