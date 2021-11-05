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

  // Some helpers for optimizing the draw() method that can be called many, many times
  int x, y;
  int scaledLength;

  // Boundary helper for optimizing collision detection with physicists and trees
  Rectangle boundingBox;

  // If we bumped into something, keep a reference to that thing around for cleanup and removal
  GamePiece collided;

}