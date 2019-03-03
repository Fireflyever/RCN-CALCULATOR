package com.home.rcncalculator.exception;


import com.home.rcncalculator.element.Unit;

import java.util.List;

/**
 * {@code CalculationException} define the more information error duration the calculation.
 */
public class CalculationException extends RuntimeException {

  private static String POSITION_INDEX = "position_index";
  private List<Unit> unProcessedUnits;

  /**
   * The default constructor..
   */
  public CalculationException(Exception innerException,
                              Unit errorUnit,
                              List<Unit> unProcessedUnits) {
    super(innerException.getMessage().replaceAll(POSITION_INDEX,
        String.valueOf(errorUnit.getPosition())));
    this.unProcessedUnits = unProcessedUnits;
  }

  public List<Unit> getUnProcessedUnits() {
    return unProcessedUnits;
  }
}
