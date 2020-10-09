/*
 * Aaron Sutton
 * ajs377@pitt.edu
 * Final Project: Fitness Tracker
 *
 * Run.java - A running workout.
 */

package edu.pitt.ajs377.fitness.activity;

/** * A generic, nondescript activity.
 *
 * Use this class for any activty which does not fall under 
 * any of the predefined categories.
 *
 * @author Aaron Sutton
 */
public class Other extends Activity {

  @Override
  public String getGenericTitle() {
    return "Workout";
  }

  @Override
  public String toString() {
    return String.format(
      "== %s ==\n" +
      "Notes: %s\n" +
      "Duration: %,d min\n" +
      "Calories burned: %,f kcals\n",
      getTitle(),
      getNotes(),
      getDuration(),
      getCalories()
    );
  }
}
