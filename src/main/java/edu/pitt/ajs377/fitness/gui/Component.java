/*
 * Aaron Sutton
 * ajs377@pitt.edu
 * Final Project: Fitness Tracker
 *
 * Component.java - Base component class.
 */

package edu.pitt.ajs377.fitness.gui;

import java.awt.LayoutManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JPanel;

public class Component extends JPanel implements View {
  /* We don't serialize classes, but declare this to supress a warning. */
  private static final long serialVersionUID = 1L;

  private Map<String, ?> data;

  /**
   * Initialize a Component.
   * @param init the inital state data
   */
  public Component(LayoutManager layout, Map<String, ?> init) {
    super(layout);
    data = init;
  }

  public String render(String k) {
    return data.get(k).toString();
  }
}
