/*
 * Aaron Sutton
 * ajs377@pitt.edu
 * Final Project: Fitness Tracker
 *
 * ActiveDay.java - Class to track activities on a given dayOfYear.
 */

package edu.pitt.ajs377.fitness;

import edu.pitt.ajs377.fitness.activity.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A record of activities that took place during a single dayOfYear.
 *
 * Associates a calendar dayOfYear (an integer) with a collection of activities
 * and can calculate some statistics from them.
 *
 * @author Aaron Sutton
 */
public class ActiveDay extends Day {
  private List<Activity> activities = new ArrayList<>();

  /**
   * Construct an empty ActiveDay with no activities.
   *
   * @param dayOfYear a calendar dayOfYear between 1-365.
   *
   */
  public ActiveDay(int dayOfYear) {
    super(dayOfYear);
  }

  /**
   * Constrct an ActiveDay with a list of Activities.
   *
   * @param dayOfYear a calendar dayOfYear between 1-365.
   * @param acts A list of activities done in a given dayOfYear.
   */
  public ActiveDay(int dayOfYear, List<Activity> acts) {
    super(dayOfYear);
    activities = acts;
  }

  /**
   * Varargs version of the constructor, allows backwards compatibilty with
   * the previous combination constructors.
   */
  public ActiveDay(int dayOfYear, Activity... acts) {
    super(dayOfYear);
    activities = Arrays.asList(acts);
  }

  public double getTotalCalories() {
    double sum = 0;
    for (Activity a : activities) {
      sum += a.getCalories();
    }
    return sum;
  }

  public int getTotalMinutes() {
    int sum = 0;
    for (Activity a : activities) {
      sum += a.getDuration();
    }
    return sum;
  }

  public List<Activity> getActivities() {
    return activities;
  }

  @Override
  public String toString() {
    StringBuilder b = new StringBuilder();
    b.append(
      String.format(
        "== Summary of Day %d ==\n" +
        "Total Minutes: %,dmin\n" +
        "Total Calories %,.2fkcals\n\n",
        getDayOfYear(),
        getTotalMinutes(),
        getTotalCalories()
      )
    );
    for (Activity a : activities) {
      b.append(a.toString() + "\n");
    }
    return b.toString();
  }
}
