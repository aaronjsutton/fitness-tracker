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

import edu.pitt.ajs377.fitness.activity.*;

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
  private List<Activity> activities = new ArrayList<>();

  private static final int MIN_CAL_DAY = 0;
  private static final int MAX_CAL_DAY = 365;

  /**
   * Construct an empty ActiveDay with no activities.
   *
   * @param day a calendar day between 1-31. 
   *
   */
  public ActiveDay(int day) {
    setDay(day);
  }

  public ActiveDay(int day, Run run) {
    setDay(day);
    activities.add(run);
  }

  public ActiveDay(int day, Run run, Bike bike) {
    setDay(day);
    activities.add(run);
    activities.add(bike);
  }

  public ActiveDay(int day, Run run, Bike bike, Swim swim) {
    setDay(day);
    activities.add(run);
    activities.add(bike);
    activities.add(swim);
  }

  public ActiveDay(int day, Run run, Bike bike, Swim swim, Other other) {
    setDay(day);
    activities.add(run);
    activities.add(bike);
    activities.add(swim);
    activities.add(other);
  }

  public ActiveDay(int day, Run run, OutdoorRun orun) {
    setDay(day);
    activities.add(run);
    activities.add(orun);
  }

  public ActiveDay(int day, Bike bike, OutdoorBike obike) {
    setDay(day);
    activities.add(bike);
    activities.add(obike);
  }

  public ActiveDay(int day, Swim swim) {
    setDay(day);
    activities.add(swim);
  }

  public ActiveDay(int day, Other other) {
    setDay(day);
    activities.add(other);
  }

  /**
   * @param day the calendar day from 1-365.
   */
  public void setDay(int day) {
    if (day < MIN_CAL_DAY || day > MAX_CAL_DAY)
      throw new IllegalArgumentException("** Invalid calendar day " + day + " **");
    else 
      this.day = day;
  }

  public double getTotalCalories() {
    double sum = 0;
    for (Activity a: activities) {
      sum += a.getCalories();
    }
    return sum;
  }

  public int getTotalMinutes() {
    int sum = 0;
    for (Activity a: activities) {
      sum += a.getDuration();
    }
    return sum;
  }

  @Override
  public String toString() {
    StringBuilder b = new StringBuilder();
    b.append(String.format(
      "== Summary of Day %d ==\n" +
      "Total Minutes: %,dmin\n" +
      "Total Calories %,.2fkcals\n\n",
      day,
      getTotalMinutes(),
      getTotalCalories()
    ));
    for (Activity a: activities) {
      b.append(a.toString() + "\n");
    }
    return b.toString();
  }
}

