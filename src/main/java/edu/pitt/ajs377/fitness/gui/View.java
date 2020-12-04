/*
 * Aaron Sutton
 * ajs377@pitt.edu
 * Final Project: Fitness Tracker
 *
 * View.java - View contract.
 */

package edu.pitt.ajs377.fitness.gui;

import java.util.Map;

/**
 * A basic contract stating any view must take a key and produce a string.
 *
 * This will hopefully solve the problem of binding the data from out existing application classes
 * to the user interface in a generic, non-hardcoded way.
 */
public interface View {
  public String render(String k);
}
