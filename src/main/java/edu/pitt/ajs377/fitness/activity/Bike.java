/*
 * Aaron Sutton
 * ajs377@pitt.edu
 * Final Project: Fitness Tracker
 *
 * Bike.java - A biking workout.
 */

package edu.pitt.ajs377.fitness.activity;

/**
 * A running activity.
 *
 * @author Aaron Sutton
 */
public class Bike extends Activity {
  private double distance;

  public Bike() {
    super();
  }

  public Bike(String title) {
    super(title);
  }

  /** The distance, in miles, biked. */
  public double getDistance() {
    return distance;
  }

  /** 
   * Update the distance for this bike ride.
   *
   * @param distance the distance in miles, cannot be less than 0.
   */
  public void setDistance(double distance) {
    if (distance < 0)
        throw new IllegalArgumentException("** Distance cannot be < 0. **");
    else
      this.distance = distance;
  }

  @Override
  public String getGenericTitle() {
    return "Bike";
  }

  @Override
  public String toString() {
    return String.format(
      "== %s ==\n" +
      "Notes: %s\n" +
      "Duration: %,d min\n" +
      "Calories burned: %,f kcals\n" + 
      "Distance biked: %,f miles\n",
      getTitle(),
      getNotes(),
      getDuration(),
      getCalories(),
      getDistance()
    );
  }
}
