/*
 * Aaron Sutton
 * ajs377@pitt.edu
 * Final Project: Fitness Tracker
 *
 * ActiveDay.java - Main driver program.
 */

package edu.pitt.ajs377.fitness;

/**
 * Fitness tracker main driver program.
 */
public class FitnessTrackerMain {
  
  public FitnessTrackerMain(String dataFilename, String stepsFilename) {

  }

  public static void main(String[] args) {
    if (args.length != 2)
      System.out.println("Usage: java FitnessTrackerMain [data file] [steps file]");
      System.exit(1);
  }
}
