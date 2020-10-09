/*
 * Aaron Sutton
 * ajs377@pitt.edu
 * Final Project: Fitness Tracker
 *
 * ActiveDay.java - Class to track activities on a given day.
 */

package edu.pitt.ajs377.fitness;

import java.util.List;
import java.util.ArrayList;

import edu.pitt.ajs377.fitness.activity.Activity;

/** 
 * A record of activities that took place during a single day.
 *
 * Associates a calendar day (an integer) with a collection of activities
 * and can calculate some statistics from them.
 *
 * @author Aaron Sutton
 */
public class ActiveDay {
  private int day;
  private List<Activity> activities;

  private static final int MIN_NAIVE_CAL_DAY = 0;
  private static final int MAX_NAIVE_CAL_DAY = 31; 

  /**
   * Construct an empty ActiveDay with no activities.
   *
   * @param day a calendar day between 1-31. 
   *
   */
  public ActiveDay(int day) {
    setDay(day);
    this.activities = new ArrayList<>();
  }

  /**
   * TODO The implementation for tracking the day does not account for
   * differing days by month, leap years, etc. 
   *
   * A rewrite with actual Java date/time classes will be more 
   * effective. For the project right now, a simple integer will suffice.
   */
  public void setDay(int day) {
    if (day < MIN_NAIVE_CAL_DAY || day > MAX_NAIVE_CAL_DAY)
      throw new IllegalArgumentException("** Invalid calendar day " + day + " **");
    else 
      this.day = day;
  }
}

