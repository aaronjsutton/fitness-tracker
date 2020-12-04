/*
 * Aaron Sutton
 * ajs377@pitt.edu
 * Final Project: Fitness Tracker
 *
 * FitnessTrackerMain.java - Main driver program.
 */

package edu.pitt.ajs377.fitness;

import edu.pitt.ajs377.fitness.gui.FitnessTrackerGUI;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Fitness tracker main driver program.
 */
public class FitnessTrackerMain {
  private FitnessTrackerGUI gui_app;

  private static final String APP_NAME = "COMPINF401 Fitness Tracker Final Project";

  public FitnessTrackerMain(String dataFilename, String stepsFilename) {
    // Parse up the input files. TODO FileChooser
    try {
      List<Day> activeYear = FitnessTrackerManager.readActivities(dataFilename);
      List<Day> stepsYear = FitnessTrackerManager.readSteps(stepsFilename);
    } catch (FileNotFoundException e) {
      System.out.println("Failed to find a data file. Exit.");
    }

    // TODO Create a controller and process the data into a Map.

    HashMap<String, Object> init = new HashMap<>();
    init.put("applicationTitle", FitnessTrackerMain.APP_NAME);

    // Initialize a GUI app
    gui_app = new FitnessTrackerGUI(init);
    gui_app.launch(); // All systems go.
  }

  /**
   * Entry point for the program.
   * The POM for this Maven project bootstraps the arguments, so there
   * is no need to pass then in when running from `mvn exec:java`.
   */
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Usage: java FitnessTrackerMain [data file] [steps file]");
      System.exit(1);
    }

    FitnessTrackerMain ctx = new FitnessTrackerMain(args[0], args[1]);
  }
}
