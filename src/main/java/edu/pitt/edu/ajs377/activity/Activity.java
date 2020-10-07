/*
 * Aaron Sutton
 * ajs377@pitt.edu
 * Final Project: Fitness Tracker
 *
 * Activity.java - Base class to keep common activity functionality from being repeated.
 */

package edu.pitt.ajs377.fitness.activity;

/**
 * According to the project description, an activity contains a title,
 * notes, duration, and calories.
 *
 * This base class wraps up all functionality shared by activities so that
 * this behaviour is consistent and not repeated across multiple activity definitions.
 *
 * An activity cannot be created directly, you must instantiate a
 * concrete subclass i.e. `Run`, `Bike`, `Swim`.  If you wish to
 * create a custom activity, use the `Other` subclass.
 *
 * @author Aaron Sutton
 */
public abstract class Activity {
  private String title;
  private String notes;
  private int duration;
  private double calories;

  /** The maximum number of allowed characters in a title. */
  private static final int MAX_TITLE_CHARS = 40;

  /** The maximum number of allowed characters an activity's notes. */
  private static final int MAX_NOTES_CHARS = 2000;

  public Activity() {
    title = getGenericTitle();
  }

  /**
   * A short description of the activity.
   *
   * The title is a name given to shortly summarize the activity.
   * For example, "Daily Run", "Endurance Training".
   *
   * @return the current title `String`.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Set the title text describing this activity.
   *
   * Titles cannot be blank, and must be no longer that {@value #MAX_TITLE_CHARS} characters long.
   * This prevents titles from being too long. For longer descriptions, use the activity's notes.
   * 
   *
   * @param title The new title. If the title is null, an empty string, 
   *              or too long, the activity generic title value is used.
   *
   */
  public void setTitle(String title) {
    if (
      title == null || title.isEmpty() || title.length() > MAX_TITLE_CHARS
    ) this.title = getGenericTitle(); else this.title = title;
  }

  /**
   * A longer description of the activity, including additional details defined by the user.
   *
   * Notes should be used for any description of the activity beyond succint title text.
   *
   * @return the plaintext activity notes
   */
  public String getNotes() {
    return notes;
  }

  /**
   * Update or remove notes from the activity.
   *
   * Notes can be empty, and are limited to {@value #MAX_NOTES_CHARS}
   * characters in length. 
   *
   * @param notes The new notes text. If it is null or empty, 
   *              the notes are set to an empty `String`. If the new 
   *              notes `String` is too long, it is discarded 
   *              and the previous notes `String` is kept. 
   *
   */
  public void setNotes(String notes) {
    if (notes.length() <= MAX_NOTES_CHARS)
      this.notes = notes;
    else if (notes == null)
      this.notes = "";
  }

  /**
   * The total time theh activity took place.
   *
   * @return the duration in minutes.
   */
  public int getDuration() {
    return duration;
  }

  /**
   * Update the duration of this activity.
   *
   * @param duration the duration in whole minutes,
   *                 cannot be a negative.
   */
  public void setDuration(int duration) {
    if (duration < 0)
      throw new IllegalArgumentException("** Duration cannot be less than 0. **");
    else
      this.duration = duration;
  }

  /**
   * Total calories burned during the activity.
   *
   * @return the calories, in kcals.
   */
  public double getCalories() {
    return calories;
  }

  /**
   *
   *
   * @param calories the calories in kcals.
   *                 cannot be negative.
   *
   */
  public void setCalories(double calories) {
    if (calories < 0)
      throw new IllegalArgumentException("** Calories cannot be less than 0. **");
    else
      this.calories = calories;
  }

  protected abstract String getGenericTitle();
}
