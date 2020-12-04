/*
 * Aaron Sutton <ajs377@pitt.edu>
 * Final Project - Fitness Tracker
 *
 * ActiveDayTest.java - Unit tests for the ActiveDay class.
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import edu.pitt.ajs377.fitness.gui.Component;
import java.awt.BorderLayout;
import java.util.*;
import org.junit.Before;
import org.junit.Test;

public class ComponentTest {
  private Component c;

  private Map<String, Object> testData = new HashMap<>();

  @Before
  public void setUp() {
    testData.put("integer", 11938);
    testData.put("double", 391.2);
    testData.put("string", "hello string");
    c = new Component(new BorderLayout(), testData);
  }

  @Test
  public void testIntegerRender() {
    assertEquals("11938", c.render("integer"));
  }

  @Test
  public void testDoubleRender() {
    assertEquals("391.2", c.render("double"));
  }

  @Test
  public void testStringRender() {
    assertEquals("hello string", c.render("string"));
  }
}
