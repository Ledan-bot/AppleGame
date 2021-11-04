package game;

import javax.swing.JComponent;
import java.awt.event.ActionListener;

public class Field extends JComponent implements ActionListener {
  public static final float GRAVITY = 9.8f;  // feet per second per second
  public static final int STEP = 40;   // duration of an animation frame in milliseconds
  public static final int APPLE_SIZE_IN_PIXELS = 30;
  public static final int TREE_WIDTH_IN_PIXELS = 60;
  public static final int TREE_HEIGHT_IN_PIXELS = 2 * TREE_WIDTH_IN_PIXELS;
  public static final int PHYSICIST_SIZE_IN_PIXELS = 75;
  public static final int MAX_TREES = 12;


}
