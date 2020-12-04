/*
 * Aaron Sutton
 * ajs377@pitt.edu
 * Final Project: Fitness Tracker
 *
 * FitnessTrackerGUI.java - Main grapical user interface driver.
 */

package edu.pitt.ajs377.fitness.gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Header component for our application.
 *
 * @author Aaron Sutton
 */
public class Header extends Component {

  /* We don't serialize classes, but declare this to supress a warning. */
  private static final long serialVersionUID = 1L;

  private JLabel title;
  private JLabel date;

  public <V>Header(Map<String, V> init) {
    super(new FlowLayout(FlowLayout.CENTER, 20, 20), init);
    title = new JLabel(render("applicationTitle"));
    date =
      new JLabel(
        String.format(
          "Today is %s, the %s%s day of the year",
          nowOfPattern("EEEE, LLLL dd"),
          nowOfPattern("D"),
          suffix(LocalDate.now().getDayOfYear())
        )
      );

    title.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
    date.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));

    add(title);
    add(date);
  }

  private String nowOfPattern(String pat) {
    LocalDate now = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pat);
    return now.format(formatter);
  }

  private String suffix(int number) {
    String suffix = "";
    int digit = number % 10;
    if (digit == 1) suffix = "st"; else if (digit == 2) suffix =
      "nd"; else suffix = "th";
    return suffix;
  }
}
