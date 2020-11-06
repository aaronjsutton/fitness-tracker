/*
 * Aaron Sutton
 * ajs377@pitt.edu
 * Final Project: Fitness Tracker
 *
 * Day.java - An abstract class that defines functionality 
 * for every class using calendar dayOfYear logic.
 *
 */

package edu.pitt.ajs377.fitness;

/**
 * An abstract implementation of a class that is associated with a calendar day.
 *
 * A calendar day is stored as an `int` in the valid range [1, 365].
 */
public abstract class Day {
  private static final int MIN_CAL_DAY = 1;
  private static final int MAX_CAL_DAY = 365;

  private int dayOfYear;

  public Day(int day) {
    setDayOfYear(day);
  }

  public int getDayOfYear() {
    return dayOfYear;
  }

  /**
   * @param dayOfYear the calendar dayOfYear from 1-365.
   */
  public void setDayOfYear(int dayOfYear) {
    if (dayOfYear < MIN_CAL_DAY || dayOfYear > MAX_CAL_DAY)
      throw new IllegalArgumentException("** Invalid calendar dayOfYear " + dayOfYear + " **");
    else 
      this.dayOfYear = dayOfYear;
  }
}
