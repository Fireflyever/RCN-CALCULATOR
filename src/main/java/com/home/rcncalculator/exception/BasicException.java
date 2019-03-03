package com.home.rcncalculator.exception;

import java.util.Locale;
import java.util.ResourceBundle;

public class BasicException extends RuntimeException {

  private static final String RESOURCE_NAME = "ExceptionMessages";
  //Using EN as the default bundle.
  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
      .getBundle(RESOURCE_NAME, Locale.ENGLISH);

  public BasicException(String message) {
    super(message);
  }

  /**
   * Get the message from the bundle.
   */
  public static String getMessage(String key, Object... params) {
    String resolvedMessage = RESOURCE_BUNDLE.getString(key);
    if (resolvedMessage != null) {
      return String.format(resolvedMessage, params);
    }
    return "";
  }
}
