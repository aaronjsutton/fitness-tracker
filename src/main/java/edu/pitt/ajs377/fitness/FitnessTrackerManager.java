/*
 * Aaron Sutton
 * ajs377@pitt.edu
 * Final Project: Fitness Tracker
 *
 * FitnessTrackerManager.java - Utilities for reading/writing data.
 */

package edu.pitt.ajs377.fitness;

import edu.pitt.ajs377.fitness.activity.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FitnessTrackerManager {
  public static final String DELIMITER = "@@";

  public static final int MIN_RECORDS = 6;
  public static final int IN_RECORDS = 7;
  public static final int OUT_RECORDS = 8;

  public static List<Day> readActivities(String filename) throws FileNotFoundException {
    List<Day> mergedDays = new ArrayList<>();
    Map<Integer, List<ActiveDay>> days = parseFile(filename)
      .map(c -> makeActiveDay(c))
      .filter(a -> a != null)
      .collect(Collectors.groupingBy(Day::getDayOfYear));

    for (Map.Entry<Integer, List<ActiveDay>> e : days.entrySet()) {
      List<Activity> totalAct = new ArrayList<>();

      for (ActiveDay d : e.getValue()) {
        for (Activity a : d.getActivities()) {
          totalAct.add(a);
        }
      }
      mergedDays.add(new ActiveDay(e.getKey(), totalAct));
    }

    return mergedDays;
  }

  private static ActiveDay makeActiveDay(String[] c) {
    Activity a;

    if (c.length < MIN_RECORDS) {
      System.out.println("Not enough records. Skipping.");
      return null;
    }

    try {
      switch (c[0]) {
        case "BKE":
          if (c.length == IN_RECORDS) {
            a = new Bike(Double.parseDouble(c[6]));
          } else {
            a = new OutdoorBike(Double.parseDouble(c[6]), c[7]);
          }
          break;
        case "RUN":
          if (c.length == IN_RECORDS) {
            a = new Run(Double.parseDouble(c[6]));
          } else {
            a = new OutdoorRun(Double.parseDouble(c[6]), c[7]);
          }
          break;
        case "SWM":
          a = new Swim(Double.parseDouble(c[6]));
          break;
        case "OTH":
          a = new Other();
          break;
        default:
          System.out.println("Unknown short code. Skipping.");
          return null;
      }
      a.setCalories(Double.parseDouble(c[4]));
      a.setDuration(Integer.parseInt(c[5]));
      a.setTitle(c[2]);
      a.setNotes(c[3]);
      return new ActiveDay(Integer.parseInt(c[1]), a);
    } catch (NumberFormatException e) {
      System.out.println("Error parsing numerical value. Skipping.");
      return null;
    }
  }

  public static List<Day> readSteps(String filename) throws FileNotFoundException {
    try {
      return parseFile(filename)
        .map(c -> new DailySteps(Integer.parseInt(c[0]), Integer.parseInt(c[1])))
        .collect(Collectors.toList());
    } catch (NumberFormatException e) {
      System.out.println("Error parsing numerical value. Skipping.");
      return null;
    }
  }

  private static Stream<String[]> parseFile(String filename)
    throws FileNotFoundException {
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    return reader.lines().map(l -> l.split(DELIMITER));
  }
}
