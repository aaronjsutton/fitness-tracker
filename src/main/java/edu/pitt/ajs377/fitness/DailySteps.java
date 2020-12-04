/*
 * Aaron Sutton
 * ajs377@pitt.edu
 * Final Project: Fitness Tracker
 *
 * DailySteps.java - Class to track steps taken on a given day.
 */

package edu.pitt.ajs377.fitness;

import edu.pitt.ajs377.fitness.activity.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A record of steps during a single day.
 *
 * Associates a calendar day (an integer) with a number of steps
 * and can calculate some statistics from them.
 *
 * @author Aaron Sutton
 */
public class DailySteps extends Day {
  private int numberOfSteps;

  public DailySteps(int day, int steps) {
    super(day);
    setNumberOfSteps(steps);
  }

  public int getNumberOfSteps() {
    return numberOfSteps;
  }

  public void setNumberOfSteps(int steps) {
    if (steps < 0) throw new IllegalArgumentException(
      "** Steps cannot be negative."
    ); else numberOfSteps = steps;
  }
}
