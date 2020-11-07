/*
 * Aaron Sutton <ajs377@pitt.edu>
 * Final Project - Fitness Tracker
 *
 * ActiveDayTest.java - Unit tests for the ActiveDay class.
 */

import org.junit.Test;
import org.junit.Before;

import edu.pitt.ajs377.fitness.ActiveDay;
import edu.pitt.ajs377.fitness.activity.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

public class ActiveDayTest {

 private ActiveDay day;

  @Before
  public void setUp() {
    Run r = new Run();
    r.setDuration(20);
    r.setCalories(200);
    Bike b = new Bike();
    b.setDuration(40);
    b.setCalories(200);
    day = new ActiveDay(1, r, b);
  }

  @Test 
  public void totalMinutes() {
    assertEquals(day.getTotalMinutes(), 60);
  }

  @Test
  public void totalCalories() {
    assertEquals(day.getTotalCalories(), 400, 0.0);
  }

  @Test
  public void toString_NotNull() {
    assertNotNull(day.toString());
    System.out.println(day.toString());
  }

  @Test
  public void constructor_BikeAndOutdoorBike() {
    Bike b = new Bike();
    OutdoorBike ob = new OutdoorBike("Oakland");
    assertNotNull(new ActiveDay(1, b, ob));
  }

  @Test
  public void constructor_Run() {
    Run r = new Run();
    assertNotNull(new ActiveDay(1, r));
  }

  @Test
  public void constructor_RunBike() {
    Run r = new Run();
    Bike b = new Bike();
    assertNotNull(new ActiveDay(1, r, b));
  }

  @Test
  public void constructor_day() {
    assertNotNull(new ActiveDay(1));
  }

  @Test
  public void constructor_RunAndOutdoorRun() {
    Run r = new Run();
    OutdoorRun or = new OutdoorRun("home");
    assertNotNull(new ActiveDay(1, r, or));
  }

  @Test
  public void constructor_RBS() {
    Run r = new Run();
    Bike b = new Bike();
    Swim s = new Swim();
    assertNotNull(new ActiveDay(1, r, b, s));
  }

  @Test
  public void constructor_RBSO() {
    Run r = new Run();
    Bike b = new Bike();
    Swim s = new Swim();
    Other o = new Other();
    assertNotNull(new ActiveDay(1, r, b, s, o));
  }
}
