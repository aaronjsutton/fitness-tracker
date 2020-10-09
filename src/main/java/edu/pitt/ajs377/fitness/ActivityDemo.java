/*
 * Aaron Sutton
 * ajs377@pitt.edu
 * Final Project: Fitness Tracker
 *
 * ActiveDemo.java - Demo main program.
 */

package edu.pitt.ajs377.fitness;

import edu.pitt.ajs377.fitness.activity.*;
import edu.pitt.ajs377.fitness.ActiveDay;

/** 
 * Demo class for our concrete instances of `Activity`.
 *
 * @author Aaron Sutton
 */
public class ActivityDemo {
  public static void main(String[] args) {
    System.out.println("Activity Demo v0.1");

    Run run = new Run("My Run");
    run.setDistance(2.5);
    run.setCalories(400);
    run.setDuration(43);

    Bike bike = new Bike("Mountain Bike");
    bike.setDistance(20);
    bike.setCalories(3000);
    bike.setDuration(300);
    bike.setNotes("A wonderful mountain bike ride");

    System.out.println(run);
    System.out.println(bike);

    ActiveDay today = new ActiveDay(2, run, bike);
    System.out.println(today); 
  }
}
