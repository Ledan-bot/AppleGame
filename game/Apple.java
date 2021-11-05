package game;

import java.awt.*;

public class Apple implements GamePiece {
  public static final int SMALL = 0;
  public static final int MEDIUM = 1;
  public static final int LARGE = 2;

  int size;
  double diameter;
  double mass;
  int centerX, centerY;
  Physicist myPhysicist;

  // In game play, apples can be thrown so track their velocities
  long lastStep;
  float velocityX, velocityY;

  // Some helpers for optimizing the draw() method that can be called many, many
  // times
  int x, y;
  int scaledLength;

  // Boundary helper for optimizing collision detection with physicists and trees
  Rectangle boundingBox;

  // If we bumped into something, keep a reference to that thing around for
  // cleanup and removal
  GamePiece collided;

  /**
   * Create a default, Medium apple
   */
  public Apple(Physicist owner) {
    this(owner, MEDIUM);
  }

  /**
   * Create an Apple of the given size
   */
  public Apple(Physicist owner, int size) {
    myPhysicist = owner;
    setSize(size);
  }

  /**
   * Sets the size (and dependent properties) of the apple based on the supplied
   * value which must be one of the size constants.
   *
   * @param size one of SMALL, MEDIUM, or LARGE, other values are bounded to SMALL
   *             or LARGE
   */
  public void setSize(int size) {
    if (size < SMALL) {
      size = SMALL;
    }
    if (size > LARGE) {
      size = LARGE;
    }
    this.size = size;
    switch (size) {
    case SMALL:
      diameter = 0.9;
      mass = 0.5;
      break;
    case MEDIUM:
      diameter = 1.0;
      mass = 1.0;
      break;
    case LARGE:
      diameter = 1.1;
      mass = 1.8;
      break;
    }
    // fillOval() used below draws an oval bounded by a box, so figure out the
    // length of the sides.
    // Since we want a circle, we simply make our box a square so we only need one
    // length.
    scaledLength = (int) (diameter * Field.APPLE_SIZE_IN_PIXELS + 0.5);
    boundingBox = new Rectangle(x, y, scaledLength, scaledLength);
  }

  public double getDiameter() {
    return diameter;
  }
}