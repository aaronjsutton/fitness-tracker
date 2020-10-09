/*
 * Aaron Sutton
 * ajs377@pitt.edu
 * Final Project: Fitness Tracker
 *
 * OutdoorBike.java - An outdoor running workout.
 */

package edu.pitt.ajs377.fitness.activity;

/**
 * An outdoor biking activity.
 *
 * An `OutdoorBike` shares the same behaviour as a `Bike`, except
 * for the attached location.
 *
 * @author Aaron Sutton
 */
public class OutdoorBike extends Bike {

  private String location;

  /** 
   * Create a new OutdoorBike that took place at a given location. 
   */
  public OutdoorBike(String location) {
    super();
    this.location = location;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  @Override
  public String getGenericTitle() {
    return "Outdoor Bike";
  }

  @Override
  public String toString() {
    return String.format(
      "== %s ==\n" +
      "Notes: %s\n" +
      "Location: %s\n" +
      "Duration: %,d min\n" +
      "Calories burned: %,f kcals\n" +
      "Distance ran: %,f miles\n",
      getTitle(),
      getNotes(),
      getLocation(),
      getDuration(),
      getCalories(),
      getDistance()
    );
  }
}
