/*
 * Aaron Sutton
 * ajs377@pitt.edu
 * Final Project: Fitness Tracker
 *
 * Swim.java - A swimming workout.
 */

package edu.pitt.ajs377.fitness.activity;

/**
 * A running activity.
 *
 * @author Aaron Sutton
 */
public class Swim extends Activity {

  private double distance;

  /**
   * The distance, in yards, swam.
   */
  public double getDistance() {
    return distance;
  }

  /**
   * Update the distance value for the activity.
   *
   * @param distance the new distance in yards, cannot be less than 0.
   */
  public void setDistance(double distance) {
    if (distance < 0)
        throw new IllegalArgumentException("** Distance cannot be less than 0. **");
    else
      this.distance = distance;
  }

  @Override
  public String getGenericTitle() {
    return "Run";
  }

  @Override
  public String toString() {
    return String.format(
      "== %s ==\n" +
      "Notes: %s\n" +
      "Duration: %,d min\n" +
      "Calories burned: %,f kcals\n",
      "Distance swam: %,f miles\n",
      getTitle(),
      getNotes(),
      getDuration(),
      getCalories(),
      getDistance()
    );
  }
}
