/*
 * Aaron Sutton
 * ajs377@pitt.edu
 * Final Project: Fitness Tracker *
 * FitnessTrackerGUI.java - Main grapical user interface driver.
 *
 * A note on the design:
 *
 * For this project we'll try a component-based approach. We'll break apart the UI
 * into individual components and separate them based on functionality. Then write subclasses of
 * JPanel and assemble them into one gorgeous user interface here.
 */

package edu.pitt.ajs377.fitness.gui;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class encapulates all the GUI logic for the program.
 * It can be thought of as a View layer in an MVC-structured app.
 *
 * @author Aaron Sutton
 */
public class FitnessTrackerGUI extends JFrame {
  /* We don't serialize classes, but declare this to supress a warning. */
  private static final long serialVersionUID = 1L;
  /** The root component which resides inside the root frame. */
  Component document;

  /** App header. */
  Header header;

  /**
   * Default constructor.
   * Builds the components. Start the user interface with the
   * `launch` method.
   *
   * @param init the initial data map.
   *
   * @see View
   */
  public <V>FitnessTrackerGUI(Map<String, V> init) {
    /* - Frame configuration - */
    super("Fitness Tracker");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    /*
     * We're going to define our own contentPane and replace the `rootFrame`.
     * so we can use JComponent features.
     * See https://docs.oracle.com/javase/tutorial/uiswing/components/toplevel.html#contentpane
     */
    document = new Component(new BorderLayout(), init);
    this.setContentPane(document);

    /* - Header configuration - */
    this.header = new Header(init);
    document.add(header, BorderLayout.PAGE_START);
  }

  public void launch() {
    pack();
    setVisible(true);
  }
}
