/*
 * Aaron Sutton
 * ajs377@pitt.edu
 * Final Project: Fitness Tracker
 *
 * Run.java - A running workout.
 */

package edu.pitt.ajs377.fitness.activity;

/**
 * A running activity.
 *
 * @author Aaron Sutton
 */
public class Run extends Activity {
  private double distance;

  /** Create a new run with the activity's generic title. */
  public Run(double distance) {
    super();
    this.distance = distance;
  }

  /** Create a new run with a custom title. */
  public Run(String title) {
    super(title);
  }

  /** The distance, in miles, ran. */
  public double getDistance() {
    return distance;
  }

  /**
   * Update the distance for this run.
   *
   * @param distance the distance in miles, cannot be less than 0.
   */
  public void setDistance(double distance) {
    if (distance < 0) throw new IllegalArgumentException(
      "** Distance cannot be < 0. **"
    ); else this.distance = distance;
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
      "Calories burned: %,2f kcals\n" +
      "Distance ran: %,2f miles\n",
      getTitle(),
      getNotes(),
      getDuration(),
      getCalories(),
      getDistance()
    );
  }
}
